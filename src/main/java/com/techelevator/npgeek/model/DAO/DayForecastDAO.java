package com.techelevator.npgeek.model.DAO;

import java.util.LinkedList;

import com.techelevator.npgeek.model.DayForecast;

public interface DayForecastDAO {

public LinkedList<DayForecast> getWeatherByParkCode(String parkcode);
}
