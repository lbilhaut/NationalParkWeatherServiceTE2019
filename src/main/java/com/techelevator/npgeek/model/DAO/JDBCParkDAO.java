package com.techelevator.npgeek.model.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Park;

  @Component
public class JDBCParkDAO implements ParkDAO{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCParkDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Park> getAllParks() {
		
		String sql = "SELECT parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, "
				+ "yearfounded, annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, "
				+ "numberofanimalspecies from park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		
		List<Park> newParkList = new ArrayList<Park>();
		
		while(results.next()) {
			newParkList.add(mapRowToPark(results));
		}
//		System.out.println("Number of parks " + newParkList.size());
		
		return newParkList;
	}
	
	private Park mapRowToPark(SqlRowSet row) {
		String parkcode = row.getString("parkcode");
		String parkname = row.getString("parkname");
		String state = row.getString("state");
		String parkdescription = row.getString("parkdescription");
		Integer acreage = row.getInt("acreage");
		Integer elevationinfeet = row.getInt("elevationinfeet");
		Float milesoftrail = row.getFloat("milesoftrail");
		Integer numberofcampsites = row.getInt("numberofcampsites");
		String climate = row.getString("climate");
		Integer yearfounded = row.getInt("yearfounded");
		Integer annualvisitorcount = row.getInt("annualvisitorcount");
		String inspirationalquote = row.getString("inspirationalquote");
		String inspirationalquotesource = row.getString("inspirationalquotesource");
		Integer entryfee = row.getInt("entryfee");
		Integer numberofanimalspecies = row.getInt("numberofanimalspecies");
		
		
		Park newPark = new Park();
		newPark.setAcreage(acreage);
		newPark.setAnnualvisitorcount(annualvisitorcount);
		newPark.setClimate(climate);
		newPark.setElevationinfeet(elevationinfeet);
		newPark.setEntryfee(entryfee);
		newPark.setInspirationalquote(inspirationalquote);
		newPark.setInspirationalquotesource(inspirationalquotesource);
		newPark.setMilesoftrail(milesoftrail);
		newPark.setNumberofanimalspecies(numberofanimalspecies);
		newPark.setNumberofcampsites(numberofcampsites);
		newPark.setParkcode(parkcode);
		newPark.setParkdescription(parkdescription);
		newPark.setParkname(parkname);
		newPark.setState(state);
		newPark.setYearfounded(yearfounded);
		
		
		return newPark;
	}

	@Override
	public Park getParkFromParkCode(String parkcode) {
		Park park = null;
		
		String sqlGetParkByCode = "SELECT * from park where parkcode = '" + parkcode + "'";
	//	System.out.println("Query string is " + sqlGetParkByCode);
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetParkByCode);
		if(results.next()) {
		 park = mapRowToPark(results);
	//	 System.out.println("getting back a park");
		}		
		return park;
	}
	
	
}
