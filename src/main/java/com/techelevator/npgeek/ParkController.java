package com.techelevator.npgeek;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.DayForecast;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.DAO.JDBCDayForecastDAO;
import com.techelevator.npgeek.model.DAO.ParkDAO;

@Controller
public class ParkController {
	
	@Autowired
	private ParkDAO dao;
	
	@Autowired
	private JDBCDayForecastDAO forecastDAO;
	
	@RequestMapping(value = {"/", "/home"}) 
	public String dislplayHomePage(Model modelMap) {
		List<Park> listOfParks = dao.getAllParks();

		modelMap.addAttribute("parks", listOfParks);
		return "HomePage";
		
	}
	 @RequestMapping("/parkDetail")
	 public String getParkDescription(HttpServletRequest request, RedirectAttributes flashScope, HttpSession session) {
		
		 
		 if(session.getAttribute("temperatureUnit") == null) {
			 
			 session.setAttribute("temperatureUnit", "fahrenheit");
			}	
		 
			String parkcode = request.getParameter("parkcode");
			flashScope.addFlashAttribute("parkcode", parkcode);
		//	System.out.println("Park code in the controller " + parkcode);
			request.setAttribute("park", dao.getParkFromParkCode(parkcode));
			LinkedList<DayForecast> fiveDayForecast = forecastDAO.getWeatherByParkCode(parkcode);
			request.setAttribute("fiveDayForecast", fiveDayForecast);
			return "ParkDetail";	

	 }
	 
	 @RequestMapping(path="/convertTemperature", method=RequestMethod.POST) 
	 public String changeTemperatureUnit(HttpServletRequest request, HttpSession session) {
		 if(session.getAttribute("temperatureUnit").equals("celsius")) {
			 session.setAttribute("temperatureUnit", "fahrenheit");
		 }
		 else {
		 session.setAttribute("temperatureUnit", "celsius");
		 }
		 String parkcode = request.getParameter("parkcode");
	     return "redirect:/parkDetail"+"?parkcode="+parkcode;
	 }
	 
	 
}



















