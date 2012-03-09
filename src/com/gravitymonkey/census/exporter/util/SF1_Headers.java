/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gravitymonkey.census.exporter.util;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class SF1_Headers {

	public static void main(String[] args){
		try {
			//this is just the output file
			File j = new File("sf1_export_metadata.txt");
			FileWriter fw = new FileWriter(j);
			BufferedWriter bw = new BufferedWriter(fw);
			
			
			//this is taken from 2-5 in www.census.gov/prod/cen2010/doc/sf1.pdf
			//(simplfied and cleaned up)
			File o = new File("filenumber_numrecords_table.txt");
			FileReader fro = new FileReader(o);
			BufferedReader bro = new BufferedReader(fro);
			String q;
			int[] ii = new int[8912];
			int[] pos = new int[8912];
			int icounter = 0;
			while ((q = bro.readLine()) != null){
				String[] tx = q.split(" ");
				int pageNum = Integer.parseInt(tx[0]);
				int cc = Integer.parseInt(tx[1]);
				for (int w = 0; w < cc; w++){
					ii[icounter] = pageNum;
					pos[icounter] = w;
					icounter++;
				}
			}
		
			
			//this is a TSV version of SF1_Final_1.5_Internet-1.xls
			//which was edited to catch a few gov't errors in the offset column
			//and some extraneous lines removed to make parsing easier
			File f = new File("SF1_Final_1.5_Internet-1.txt");
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String s = "";
			int lineCounter = 0;
			String tableID = "";
			String tableName = "";
			ArrayList<String> al = new ArrayList<String>();
			int counter = 1;
			icounter = 0;
			
			while ((s = br.readLine()) != null){
					String[] tt = s.split("\t");
					if (tt.length > 1){
						if (tt[0] != null){
							if (!tt[0].equals(tableID)){
								//new name
								if (!tt[0].trim().isEmpty()){
									tableID = tt[0];
									if (tt[3].indexOf("[") > -1){
										tableName = tt[3].substring(0, tt[3].indexOf("[") - 1); 
										if (tableName.startsWith("\"")) tableName = tableName.substring(1);
									}
								//	System.out.println(tableID + tableName);
									al = new ArrayList<String>();
									counter = 1;
								}
							} else {
								if (tt[1] != null){
//									if (!tt[1].trim().isEmpty()){
									//	System.out.println(s.replace("\t", "~"));
										int offset = Integer.parseInt(tt[2]);		
										for (int w = al.size() - 1; w >= offset; w--){
											al.remove(w);
										}
										al.add(offset, tt[offset + 3]);
									if (!tt[1].trim().isEmpty()){
										StringBuilder sb = new StringBuilder();
										for (int w = 0; w < al.size(); w++){
											String field = (al.get(w).trim());
											if (field.endsWith(":")){
												field = field.substring(0, field.length() - 1);
											}
											sb.append(field);
											if (w < al.size() - 1){
												sb.append(":");
											}
										}
										System.out.println(ii[icounter] + "\t" + pos[icounter]+ "\t" + tableID + counter + "\t" + tableName + "-" + sb.toString());
										bw.write(ii[icounter] + "\t" + pos[icounter]+ "\t" + tableID + counter + "\t" + tableName + "-" + sb.toString());
										bw.newLine();
										
										counter++;
										icounter++;
									}
								}
							}
						}
					}
					bw.flush();
					
					
				lineCounter++;
			}
			bw.flush();
			bw.close();
			
			/*
			 * 
			 * The result is an output file that looks like this:
			 *  -- filenumber  
			 *  -- column number of the value (counting from zero, from the data columns in the datafile)
			 *  -- column name (table number + column count)
			 *  -- column description
			 * 
			 * 47		60	HCT3.13	TENURE BY PRESENCE AND AGE OF RELATED CHILDREN-Total:Renter-occupied:No related children under 18 years
			 * 
			 */
			
		} catch (Exception ee){
			ee.printStackTrace(System.out);
		}
	}
	
	
}
