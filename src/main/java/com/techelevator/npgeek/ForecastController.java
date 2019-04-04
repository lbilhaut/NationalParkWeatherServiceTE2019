package com.techelevator.npgeek;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.npgeek.model.DayForecast;
import com.techelevator.npgeek.model.DAO.DayForecastDAO;
import com.techelevator.npgeek.model.DAO.JDBCDayForecastDAO;
import com.techelevator.npgeek.model.DAO.JDBCParkDAO;
import com.techelevator.npgeek.model.DAO.ParkDAO;

@Controller
public class ForecastController {

@Autowired
private ParkDAO dao;

@Autowired
private JDBCDayForecastDAO forecastDAO;

@RequestMapping("/parkWeatherForecast") 
public String displayForecastPage(HttpServletRequest request) {
    String parkcode = request.getParameter("parkcode");
    request.setAttribute("park", dao.getParkFromParkCode(parkcode));
    
    LinkedList<DayForecast> fiveDayForecast = forecastDAO.getWeatherByParkCode(parkcode);
    request.setAttribute("fiveDayForecast", fiveDayForecast);
    return "parkWeatherForecast";
}




}