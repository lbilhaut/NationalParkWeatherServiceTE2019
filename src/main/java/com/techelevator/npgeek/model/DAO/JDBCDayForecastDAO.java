package com.techelevator.npgeek.model.DAO;

import java.util.LinkedList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.DayForecast;

@Component
public class JDBCDayForecastDAO implements DayForecastDAO {

private JdbcTemplate jdbcTemplate;

@Autowired
public  JDBCDayForecastDAO(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);   
}

@Override
public LinkedList<DayForecast> getWeatherByParkCode(String parkcode) {

    String sql = "SELECT * from weather where parkcode = '"
                + parkcode + "' order by fivedayforecastvalue";
//    System.out.println(sql);
    SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
    
    LinkedList<DayForecast> newWeatherList = new LinkedList<DayForecast>();
    while(results.next()) {
        newWeatherList.add(mapRowToDayForecast(results));
    }
    
    return newWeatherList;
}

private DayForecast mapRowToDayForecast(SqlRowSet results) {
    String parkcode = results.getString("parkcode");
    Integer fivedayforecastvalue = results.getInt("fivedayforecastvalue");
    Integer low = results.getInt("low");
    Integer high = results.getInt("high");
    String forecast = results.getString("forecast");
    
    DayForecast newWeather = new DayForecast();
    newWeather.setFivedayforecastvalue(fivedayforecastvalue);
    newWeather.setForecast(forecast);
    newWeather.setHigh(high);
    newWeather.setLow(low);
    newWeather.setParkcode(parkcode);
    newWeather.setExtrawater();
    newWeather.setLayers();
    newWeather.setFrigidtemperature();
    newWeather.setLowInCelsius();
    newWeather.setHighInCelsius();
    
//    newWeather.setTemperatureinFahrenheit();
    return newWeather;
// Weather theWeather;
// theWeather = new Weather();
// theWeather.setparkcode(results.getString("parkcode"));
// theWeather.setFiveDayForecastValue(results.getInt("fivedayforecastvalue"));
// theWeather.setLow(results.getInt("low"));
// theWeather.setHigh(results.getInt("high"));
// theWeather.setLowC((results.getInt("low")-32)5/9);
// theWeather.setHighC((results.getInt("high")-32)5/9);
// theWeather.setForecast(results.getString("forecast"));
// return theWeather;
}

}
