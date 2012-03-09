/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gravitymonkey.census.exporter;


import java.util.ArrayList;
import java.util.HashMap;

public class GeoRecord {
	HashMap<String, String> data;
	
	static ArrayList<GeoRecordColumn> cols;
	
	static {
		cols = new ArrayList<GeoRecordColumn>();		
			cols.add(new GeoRecordColumn("File Identification", "FILEID", 6, 1, "A/N"));			
			cols.add(new GeoRecordColumn("State/U .S . Abbreviation (USPS)", "STUSAB", 2, 7, "A"));
			cols.add(new GeoRecordColumn("Summary Level", "SUMLEV", 3, 9, "A/N"));
			cols.add(new GeoRecordColumn("Geographic Component", "GEOCOMP", 2, 12, "A/N"));
			cols.add(new GeoRecordColumn("Characteristic Iteration", "CHARITER", 3, 14, "A/N"));
			cols.add(new GeoRecordColumn("Characteristic Iteration File Sequence Number", "CIFSN", 2, 17, "A/N"));
			cols.add(new GeoRecordColumn("Logical Record Number", "LOGRECNO", 7, 19, "N"));
			cols.add(new GeoRecordColumn("Region", "REGION", 1, 26, "A/N"));
			cols.add(new GeoRecordColumn("Division", "DIVISION", 1, 27, "A/N"));
			cols.add(new GeoRecordColumn("State (FIPS)", "STATE", 2, 28, "A/N"));
			cols.add(new GeoRecordColumn("County", "COUNTY", 3, 30, "A/N"));
			cols.add(new GeoRecordColumn("FIPS County Class Code", "COUNTYCC", 2, 33, "A/N"));
			cols.add(new GeoRecordColumn("County Size Code", "COUNTYSC", 2, 35, "A/N"));
			cols.add(new GeoRecordColumn("County Subdivision (FIPS)", "COUSUB", 5, 37, "A/N"));
			cols.add(new GeoRecordColumn("FIPS County Subdivision Class Code", "COUSUBCC", 2, 42, "A/N"));
			cols.add(new GeoRecordColumn("County Subdivision Size Code", "COUSUBSC", 2, 44, "A/N"));
			cols.add(new GeoRecordColumn("Place (FIPS)", "PLACE", 5, 46, "A/N"));
			cols.add(new GeoRecordColumn("FIPS Place Class Code", "PLACECC", 2, 51, "A/N"));
			cols.add(new GeoRecordColumn("Place Size Code", "PLACESC", 2, 53, "A/N"));
			cols.add(new GeoRecordColumn("Census Tract", "TRACT", 6, 55, "A/N"));
			cols.add(new GeoRecordColumn("Block Group", "BLKGRP", 1, 61, "A/N"));
			cols.add(new GeoRecordColumn("Block", "BLOCK", 4, 62, "A/N"));
			cols.add(new GeoRecordColumn("Internal Use Code", "IUC", 2, 66, "A/N"));
			cols.add(new GeoRecordColumn("Consolidated City (FIPS)", "CONCIT", 5, 68, "A/N"));
			cols.add(new GeoRecordColumn("FIPS Consolidated City Class Code", "CONCITCC", 2, 73, "A/N"));
			cols.add(new GeoRecordColumn("Consolidated City Size Code", "CONCITSC", 2, 75, "A/N"));
			cols.add(new GeoRecordColumn("American Indian Area/Alaska Native Area/Hawaiian Home Land (Census)", "AIANHH", 4, 77, "A/N"));
			cols.add(new GeoRecordColumn("American Indian Area/Alaska Native Area/Hawaiian Home Land (FIPS)", "AIANHHFP", 5, 81, "A/N"));
			cols.add(new GeoRecordColumn("FIPS American Indian Area/Alaska Native Area/Hawaiian Home Land Class Code", "AIANHHCC", 2, 86, "A/N"));
			cols.add(new GeoRecordColumn("American Indian Trust Land/Hawaiian Home Land Indicator", "AIHHTLI", 1, 88, "A/N"));
			cols.add(new GeoRecordColumn("American Indian Tribal Subdivision (Census)", "AITSCE", 3, 89, "A/N"));
			cols.add(new GeoRecordColumn("American Indian Tribal Subdivision (FIPS)", "AITS", 5, 92, "A/N"));
			cols.add(new GeoRecordColumn("FIPS American Indian Tribal Subdivision Class Code", "AITSCC", 2, 97, "A/N"));
			cols.add(new GeoRecordColumn("Tribal Census Tract", "TTRACT", 6, 99, "A/N"));
			cols.add(new GeoRecordColumn("Tribal Block Group", "TBLKGRP", 1, 105, "A/N"));
			cols.add(new GeoRecordColumn("Alaska Native Regional Corporation (FIPS)", "ANRC", 5, 106, "A/N"));
			cols.add(new GeoRecordColumn("FIPS Alaska Native Regional Corporation Class Code", "ANRCCC", 2, 111, "A/N"));
			cols.add(new GeoRecordColumn("Metropolitan Statistical Area/Micropolitan Statistical Area", "CBSA", 5, 113, "A/N"));
			cols.add(new GeoRecordColumn("Metropolitan Statistical Area/Micropolitan Statistical Area Size Code", "CBSASC", 2, 118, "A/N"));
			cols.add(new GeoRecordColumn("Metropolitan Division", "METDIV", 5, 120, "A/N"));
			cols.add(new GeoRecordColumn("Combined Statistical Area", "CSA", 3, 125, "A/N"));
			cols.add(new GeoRecordColumn("New England City and Town Area", "NECTA", 5, 128, "A/N"));
			cols.add(new GeoRecordColumn("New England City and Town Area Size Code", "NECTASC", 2, 133, "A/N"));
			cols.add(new GeoRecordColumn("New England City and Town Area Division", "NECTADIV", 5, 135, "A/N"));
			cols.add(new GeoRecordColumn("Combined New England City and Town Area", "CNECTA", 3, 140, "A/N"));
			cols.add(new GeoRecordColumn("Metropolitan Statistical Area/Micropolitan Statistical Area Principal City Indicator", "CBSAPCI", 1, 143, "A/N"));
			cols.add(new GeoRecordColumn("New England City and Town Area Principal City Indicator", "NECTAPCI", 1, 144, "A/N"));
			cols.add(new GeoRecordColumn("Urban Area", "UA", 5, 145, "A/N"));
			cols.add(new GeoRecordColumn("Urban Area Size Code", "UASC", 2, 150, "A/N"));
			cols.add(new GeoRecordColumn("Urban Area Type", "UATYPE", 1, 152, "A/N"));
			cols.add(new GeoRecordColumn("Urban/Rural", "UR", 1, 153, "A/N"));
			cols.add(new GeoRecordColumn("Congressional District (111th)", "CD", 2, 154, "A/N"));
			cols.add(new GeoRecordColumn("State Legislative District (Upper Chamber) (Year 1)", "SLDU", 3, 156, "A/N"));
			cols.add(new GeoRecordColumn("State Legislative District (Lower Chamber) (Year 1)", "SLDL", 3, 159, "A/N"));
			cols.add(new GeoRecordColumn("Voting District", "VTD", 6, 162, "A/N"));
			cols.add(new GeoRecordColumn("Voting District Indicator", "VTDI", 1, 168, "A/N"));
			cols.add(new GeoRecordColumn("Reserved", "RESERVE2", 3, 169, "A/N"));
			cols.add(new GeoRecordColumn("ZIP Code Tabulation Area (5-Digit)", "ZCTA5", 5, 172, "A/N"));
			cols.add(new GeoRecordColumn("Subminor Civil Division (FIPS)", "SUBMCD", 5, 177, "A/N"));
			cols.add(new GeoRecordColumn("FIPS Subminor Civil Division Class Code", "SUBMCDCC", 2, 182, "A/N"));
			cols.add(new GeoRecordColumn("School District (Elementary)", "SDELM", 5, 184, "A/N"));
			cols.add(new GeoRecordColumn("School District (Secondary)", "SDSEC", 5, 189, "A/N"));
			cols.add(new GeoRecordColumn("School District (Unified)", "SDUNI", 5, 194, "A/N"));			
			cols.add(new GeoRecordColumn("Area (Land)", "AREALAND", 14, 199, "N"));
			cols.add(new GeoRecordColumn("Area (Water)", "AREAWATR", 14, 213, "N"));
			cols.add(new GeoRecordColumn("Area Name-Legal/Statistical Area Description (LSAD) Term-Part Indicator", "NAME", 90, 227, "A/N"));
			cols.add(new GeoRecordColumn("Functional Status Code", "FUNCSTAT", 1, 317, "A/N"));
			cols.add(new GeoRecordColumn("Geographic Change User Note Indicator", "GCUNI", 1, 318, "A/N"));
			cols.add(new GeoRecordColumn("Population Count (100%)", "POP100", 9, 319, "N"));
			cols.add(new GeoRecordColumn("Housing Unit Count (100%)", "HU100", 9, 328, "N"));
			cols.add(new GeoRecordColumn("Internal Point (Latitude)", "INTPTLAT", 11, 337, "A/N"));
			cols.add(new GeoRecordColumn("Internal Point (Longitude)", "INTPTLON", 12, 348, "A/N"));
			cols.add(new GeoRecordColumn("Legal/Statistical Area Description Code", "LSADC", 2, 360, "A/N"));
			cols.add(new GeoRecordColumn("Part Flag", "PARTFLAG", 1, 362, "A/N"));
			cols.add(new GeoRecordColumn("Reserved", "RESERVE3", 6, 363, "A/N"));
			cols.add(new GeoRecordColumn("Urban Growth Area", "UGA", 5, 369, "A/N"));
			cols.add(new GeoRecordColumn("State (ANSI)", "STATENS", 8, 374, "A/N"));
			cols.add(new GeoRecordColumn("County (ANSI)", "COUNTYNS", 8, 382, "A/N"));
			cols.add(new GeoRecordColumn("County Subdivision (ANSI)", "COUSUBNS", 8, 390, "A/N"));
			cols.add(new GeoRecordColumn("Place (ANSI)", "PLACENS", 8, 398, "A/N"));
			cols.add(new GeoRecordColumn("Consolidated City (ANSI)", "CONCITNS", 8, 406, "A/N"));
			cols.add(new GeoRecordColumn("American Indian Area/Alaska Native Area/Hawaiian Home Land (ANSI)", "AIANHHNS", 8, 414, "A/N"));
			cols.add(new GeoRecordColumn("American Indian Tribal Subdivision (ANSI)", "AITSNS", 8, 422, "A/N"));
			cols.add(new GeoRecordColumn("Alaska Native Regional Corporation(ANSI)", "ANRCNS", 8, 430, "A/N"));
			cols.add(new GeoRecordColumn("Subminor Civil Division (ANSI)", "SUBMCDNS", 8, 438, "A/N"));
			cols.add(new GeoRecordColumn("Congressional District (113th)", "CD113", 2, 446, "A/N"));
			cols.add(new GeoRecordColumn("Congressional District (114th)", "CD114", 2, 448, "A/N"));
			cols.add(new GeoRecordColumn("Congressional District (115th)", "CD115", 2, 450, "A/N"));
			cols.add(new GeoRecordColumn("State Legislative District (Upper Chamber)(Year 2)", "SLDU2", 3, 452, "A/N"));
			cols.add(new GeoRecordColumn("State Legislative District (Upper Chamber)(Year 3)", "SLDU3", 3, 455, "A/N"));
			cols.add(new GeoRecordColumn("State Legislative District (Upper Chamber)(Year 4)", "SLDU4", 3, 458, "A/N"));
			cols.add(new GeoRecordColumn("State Legislative District (Lower Chamber)(Year 2)", "SLDL2", 3, 461, "A/N"));
			cols.add(new GeoRecordColumn("State Legislative District (Lower Chamber)(Year 3)", "SLDL3", 3, 464, "A/N"));
			cols.add(new GeoRecordColumn("State Legislative District (Lower Chamber)(Year 4)", "SLDL4", 3, 467, "A/N"));
			cols.add(new GeoRecordColumn("American Indian Area/Alaska Native Area/Hawaiian Home Land Size Code", "AIANHHSC", 2, 470, "A/N"));
			cols.add(new GeoRecordColumn("Combined Statistical Area Size Code", "CSASC", 2, 472, "A/N"));
			cols.add(new GeoRecordColumn("Combined NECTA Size Code", "CNECTASC", 2, 474, "A/N"));
			cols.add(new GeoRecordColumn("Metropolitan/Micropolitan Indicator", "MEMI", 1, 476, "A/N"));
			cols.add(new GeoRecordColumn("NECTA Metropolitan/Micropolitan Indicator", "NMEMI", 1, 477, "A/N"));
			cols.add(new GeoRecordColumn("Public Use Microdata Area", "PUMA", 5, 478, "A/N"));
			cols.add(new GeoRecordColumn("Reserved", "RESERVED", 18, 483, "A/N"));	
				
	}
	
	public GeoRecord(String s){
		data = new HashMap<String, String>();
		this.parseLine(s);
	}
	
	private void parseLine(String s){
		for (int w = 0; w < cols.size(); w++){
			GeoRecordColumn col = cols.get(w);
			String name = col.columnName;
			String value = col.getValue(s);
			data.put(name, value);
		//	System.out.println(w + "\t" + name + "\t" + value);
		}
	}
	
	public String getValue(String name){
		String s = data.get(name.toLowerCase());
		if (s != null){
			s = s.trim();
			if (s.isEmpty()) return null;
		}
		return s;
	}
	

}
