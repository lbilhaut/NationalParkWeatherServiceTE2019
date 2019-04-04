package com.techelevator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;

import org.junit.Test;

import com.techelevator.npgeek.model.DayForecast;
import com.techelevator.npgeek.model.DAO.JDBCDayForecastDAO;

public class JDBCDayForecastDAOTest extends DAOIntegrationTest {
	
	private JDBCDayForecastDAO dao;
	
	public JDBCDayForecastDAOTest() {
		dao = new JDBCDayForecastDAO(super.getDataSource());
	}
	
	
	@Test
	public void get_weekly_forecast() throws SQLException {
		
		DayForecast testDayForecast = new DayForecast();
		testDayForecast.setFivedayforecastvalue(1);
		testDayForecast.setForecast("rain");
		testDayForecast.setHigh(62);
		testDayForecast.setLow(38);
		
		
		
		DayForecast actualWeather = dao.getWeatherByParkCode("CVNP").get(0);
		
		assertNotNull(actualWeather);
		assertEquals(testDayForecast.getForecast(), actualWeather.getForecast());
		assertEquals(testDayForecast.getHigh(), actualWeather.getHigh());
		assertEquals(testDayForecast.getLow(), actualWeather.getLow());


	}

}
