package com.sas.sanction.helper;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.support.DatabaseMetaDataCallback;
import org.springframework.jdbc.support.MetaDataAccessException;

public class ColumnMetaDataCallback implements DatabaseMetaDataCallback{

	private String tableName;
	
	public ColumnMetaDataCallback(String tableName) {
		this.tableName = tableName;
	}

	@Override
	public Object processMetaData(DatabaseMetaData dbmd) throws SQLException, MetaDataAccessException {
		ResultSet rs = null ;
		ArrayList<String> colNames = new ArrayList<String>();
		try {
		// u can specify table name instead of %
		rs = dbmd.getColumns(null,null,tableName,"%");
		while (rs.next()) {
			colNames.add(rs.getString(4));
		}
		} catch (Exception e) {
		throw new SQLException() ;
		} finally {
		if (rs != null)
		rs.close() ;
		}
		return colNames;
	}

}
