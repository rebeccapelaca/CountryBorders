package it.polito.tdp.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.country.model.Country;

public class CountryDao {

	public List<Country> listCountry() {

		final String sql = "SELECT CCode, StateAbb, StateNme FROM country ORDER BY CCode ASC";

		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet res = st.executeQuery() ;
			
			List<Country> list = new ArrayList<>() ;
			
			while(res.next()) {
				list.add(new Country(res.getInt("CCode"), res.getString("StateAbb"), res.getString("StateNme"))) ;
			}
			
			res.close();
			conn.close();
			
			return list ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null ;
		}

	}

}
