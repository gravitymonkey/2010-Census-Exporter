/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gravitymonkey.census.exporter;

public class GeoRecordColumn {

	String columnName;
	String fileType;
	int length;
	int pos;
	boolean isString;
	boolean isNumeric;
	
	public GeoRecordColumn(String _columnName, String _fileType, int _length, int _pos, String datatype){
		columnName = _columnName.toLowerCase();
		fileType = _fileType;
		length = _length;
		pos = _pos - 1; //to make it start at zero, instead of 1
		if (datatype.equals("A")){
			isString = true;
			isNumeric = false;
		} else if (datatype.equals("N")){
			isString = false;
			isNumeric = true;
		} else if (datatype.equals("A/N")){
			isString = true;
			isNumeric = false;
		} else {
			System.out.println("unrecognized datatype " + datatype);
		}
	}
	
	public String getValue(String s){		
		return s.substring(pos, pos + length);
	}
}
