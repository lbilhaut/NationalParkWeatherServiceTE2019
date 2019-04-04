package com.techelevator.npgeek.model.DAO;

import java.sql.Savepoint;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Survey;

public interface SurveyDAO {
public void saveNewSurvey(Survey newSurvey);
//public Map<String, Integer> getOrderedFavoriteParks();
public Map<Park, Integer> getOrderedFavoriteParks();
public LinkedList<String> orderFavoritePark(Map<String, Integer> mapOfParks);
//public Object[] orderFavoriteParkAsObjectArray(Map<String, Integer> mapOfParks);
public Object[] orderFavoriteParkAsObjectArray(Map<Park, Integer> mapOfParks);

}