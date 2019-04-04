package com.techelevator.npgeek.model.DAO;

import java.util.List;
import java.util.Map;

import com.techelevator.npgeek.model.Park;

public interface ParkDAO {
	
	public List<Park> getAllParks();

	
	public Park getParkFromParkCode(String parkcode);
	
		
}
