package com.techelevator.npgeek;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.hibernate.validator.internal.util.privilegedactions.NewInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.DAO.ParkDAO;
import com.techelevator.npgeek.model.DAO.SurveyDAO;

@Controller
public class SurveyController {

@Autowired
SurveyDAO surveyDAO;

@Autowired
ParkDAO parkDAO;

@RequestMapping(path="/survey", method=RequestMethod.GET)
public String displaySurveyPage(Model modelHolder, HttpServletRequest request) {
    if(!modelHolder.containsAttribute("survey")) {
        modelHolder.addAttribute("survey", new Survey());
    }
	List<Park> listOfParks = parkDAO.getAllParks();
	request.setAttribute("listOfParks", listOfParks);
    return "survey";
}



@RequestMapping(path="/survey", method=RequestMethod.POST)
public String saveSurveyResults(@Valid @ModelAttribute("survey") Survey survey, BindingResult result, Model modelMap,
        RedirectAttributes flashScope ) {
	
//	List<Park> listOfParks = parkDAO.getAllParks();
//	System.out.println("Number of parks in the Survey controller" + listOfParks.size());
//
//	modelMap.addAttribute("parks", listOfParks);
	
//	List<Park> listOfParks = parkDAO.getAllParks();
//	request.setAttribute("listOfParks", listOfParks);
	
    if(result.hasErrors()) {
        flashScope.addFlashAttribute("survey", survey);
        flashScope.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey", result);
        return "redirect:/survey";
    }
    surveyDAO.saveNewSurvey(survey);
    flashScope.addFlashAttribute("thankYou", true);
    return "redirect:/favoriteParks";   
}

@RequestMapping("/favoriteParks")
public String displayFavoriteParks(HttpServletRequest request, Model modelHolder) {
//    Map<String, Integer> favoriteParks = surveyDAO.getOrderedFavoriteParks();
//    modelHolder.addAttribute("favoriteParksVotes", favoriteParks);
// System.out.println("Size of map is " + favoriteParks.size());
//    LinkedList<String> favoriteParksCodeOrderByCount = surveyDAO.orderFavoritePark(favoriteParks);
//    modelHolder.addAttribute("favoriteParkList", favoriteParksCodeOrderByCount);
    
//	Object[] favoriteParks = surveyDAO.orderFavoriteParkAsObjectArray(surveyDAO.getOrderedFavoriteParks());
  
	Object[] favoriteParks = surveyDAO.orderFavoriteParkAsObjectArray(surveyDAO.getOrderedFavoriteParks());
	  modelHolder.addAttribute("favoriteParksVotes", favoriteParks);


return "favoriteParks";
}
}
