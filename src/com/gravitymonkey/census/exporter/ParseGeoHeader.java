/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gravitymonkey.census.exporter;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;

public class ParseGeoHeader {

	ParseGeoHeader(String filename, String tempDirectory, String stateName) {
            try {
                System.out.println("loading SF1 Data");
		HashMap<String, String> ids = loadGeo(filename + stateName  + "geo2010.sf1");
                System.out.println("\tfinished loading geo data from " + filename + stateName + "geo2010.sf1");
                int[] counts = loadTableCounts("filenumber_numrecords_table.txt");
                System.out.println("\tfinished loading tablecounts");
                
                File tempdir = new File(tempDirectory);
                boolean isThere = tempdir.mkdir();
                if (isThere) System.out.println("tempDirectory '" + tempDirectory + "' already exists");
                
                loadDataFiles(ids, counts, filename + stateName, tempdir);
                
                combineFinishedFiles(tempdir, stateName + ".tsv");
                
            } catch (Exception ee){
                ee.printStackTrace(System.out);
            }
	}
        
        
        private void combineFinishedFiles(File dir, String outputName) throws Exception {
                System.out.println("\tcombining finished files");
                File[] fx = dir.listFiles();
                File output = new File(outputName);
                FileWriter fw = new FileWriter(output);
                BufferedWriter bw = new BufferedWriter(fw);
                for (int w = 0; w < fx.length; w++){
                    if (!fx[w].getName().startsWith(".")){
                        File fp = fx[w];
                        FileReader ffr = new FileReader(fp);
                        BufferedReader br = new BufferedReader(ffr);
                        String q = "";
                        while ((q = br.readLine())!=null){
                            bw.append(q);
                            bw.newLine();
                        }
                        bw.flush();
                        br.close();
                        ffr.close();
                    }                    
                    if ((w % 100) == 0) System.out.println("\tcombined " + w + " of " + fx.length);
                }
                bw.flush();
                bw.close();
                System.out.println("\tcompleted: " + outputName);
                
                //clean up interim files
                for (int w = 0; w < fx.length; w++){
                    fx[w].delete();
                }
                

        }
        
        private void loadDataFiles(HashMap<String,String> ids, int[] counts, String filename, File dir) throws Exception {
            for (int w = 1; w <= 47; w++){
                StringBuilder sb = new StringBuilder();
                    sb.append(w);
                while (sb.toString().length() < 5){
                    sb.insert(0, "0");
                }
                
                System.out.print("\tloading file " + w);
                
                loadFile(ids, counts[w], filename + sb.toString() + "2010.sf1", dir);
                System.out.println("....complete");
            }

        }
        
        private int[] loadTableCounts(String fn) throws Exception {
            int[] ii = new int[48];
            File f = new File(fn);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null){
                String[] tt = s.trim().split(" ");
                if (tt.length > 3){
                    int i = Integer.parseInt(tt[0]);
                    int y = Integer.parseInt(tt[1]);
                    ii[i] = y;
                }
            }
            return ii;
        }
        
        
        private void loadFile(HashMap<String, String> ids, int numCols, String filename, File directory) throws Exception {
            File f = new File(filename);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null){
                String[] ss = s.split(",");
                if (ss != null){
                    if (ss.length > 4){
                        String recordName = ss[4];
                        if (ids.containsKey(recordName)){
                            StringBuilder sb = new StringBuilder();
                            for (int w = 5; w < (numCols + 5); w++){
                                sb.append(ss[w]).append("\t");
                            }
                            File ff = new File(directory, recordName);
                            boolean addHeader = false;
                            if (!ff.exists()){
                                addHeader = true;
                            }
                            FileWriter datafile = new FileWriter(ff, true);
                            if (addHeader){
                                datafile.write(ids.get(recordName));
                            }
                            datafile.write(sb.toString());
                            datafile.flush();
                            datafile.close();
                            
                        }
                    }
                }
            }
        }
        
	
	private HashMap<String, String> loadGeo(String filename) throws Exception {
		try {
                        HashMap<String, String> recordNumbers = new HashMap<String,String>();
			File f = new File(filename);
			if (f.exists()){
				FileReader fr = new FileReader(f);
				BufferedReader br = new BufferedReader(fr);
				String s = null;
				while ((s = br.readLine()) != null){
					GeoRecord gr = new GeoRecord(s);	
					if (gr.getValue("Block") == null&& gr.getValue("Block Group") != null){
                                                StringBuilder sb = new StringBuilder();
                                                    sb.append(gr.getValue("State (FIPS)")).append("\t");
                                                    sb.append(gr.getValue("County")).append("\t");
                                                    sb.append(gr.getValue("Census Tract")).append("\t");
                                                    sb.append(gr.getValue("Block Group"));
                                                    sb.append("\t");
                                                String recordNumber = gr.getValue("Logical Record Number");
                                                recordNumbers.put(recordNumber, sb.toString());
					}
				}
			} else {
                            throw new FileNotFoundException("can't find " + f.getAbsolutePath());
                        }
        
                        return recordNumbers;
		} catch (Exception ee){                    
			ee.printStackTrace(System.out);
                        throw ee;
		}
	}
	
	public static void main(String[] args){
//		ParseGeoHeader pgh = new ParseGeoHeader("/data/census_collection/census_2010_sf1/", "scratch", "nj");
		ParseGeoHeader pgh = new ParseGeoHeader(args[0], args[1], args[2]);
	}
	

}
