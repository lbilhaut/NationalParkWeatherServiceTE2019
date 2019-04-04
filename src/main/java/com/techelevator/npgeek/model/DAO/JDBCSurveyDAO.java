
package com.techelevator.npgeek.model.DAO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.bouncycastle.asn1.gnu.GNUObjectIdentifiers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.method.annotation.MapMethodProcessor;

import com.fasterxml.jackson.databind.deser.std.MapEntryDeserializer;
import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Survey;

@Component
public class JDBCSurveyDAO implements SurveyDAO{

private JdbcTemplate jdbcTemplate;
private JDBCParkDAO jdbcParkDAO;

@Autowired
public JDBCSurveyDAO(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
    this.jdbcParkDAO = new JDBCParkDAO(dataSource);
}
    
@Override
public void saveNewSurvey(Survey newSurvey) {
    
    Long id = getNextSurveyId(); 
    String sqlInsertString = "INSERT INTO survey_result (surveyid, parkcode, emailaddress, state, activitylevel) "+
            "VALUES (?,?,?,?,?)";
// System.out.println("Park code: " + newSurvey.getParkCode());
// System.out.println("Email address: " + newSurvey.getEmailAddress());
// System.out.println("State: " + newSurvey.getState());
// System.out.println("Activity level: " + newSurvey.getActivityLevel());
// System.out.println("Survey id: " + newSurvey.getSurveyId());
newSurvey.setSurveyId(id);
jdbcTemplate.update(sqlInsertString, id , newSurvey.getParkCode(), newSurvey.getEmailAddress(), newSurvey.getState(), newSurvey.getActivityLevel());
}

private Long getNextSurveyId() {
    SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT NEXTVAL('seq_surveyid')");
    Long id = null;
    if(results.next()) {
        id = results.getLong(1);
        System.out.println("The id is " + id);
    } else {
        throw new RuntimeException("Something went wrong while getting an id for the new survey");
    }
    return id;
}

//public Map<String, Integer> getOrderedFavoriteParks(){
//    String favoriteParkSQLQueryString = " SELECT parkcode, count(*) " + 
//                                    "FROM survey_result " + 
//                                    "GROUP BY parkcode "+
//                                    "ORDER BY count DESC;";
//    SqlRowSet results = jdbcTemplate.queryForRowSet(favoriteParkSQLQueryString);
//    Map<String, Integer> favoriteParks = new HashMap<String, Integer>();
//    //LinkedList<Park> favoriteParks = new ArrayList<Park>();
//    while(results.next()) {
//        String key = results.getString(1);
//        Integer value = results.getInt(2);
//        favoriteParks.put(key, value);
//    }
//    return favoriteParks;
//}

public LinkedList<String> orderFavoritePark(Map<String, Integer> mapOfParks){
    LinkedList<String> favoriteParkList = new LinkedList<String>();
    int sizeOfList = mapOfParks.size();
    for(int i= 0; i < sizeOfList; i++) {
        Integer numberOfVotesInteger = 0;
        String parkCode = "";
        Set<String> keys = mapOfParks.keySet();
        for(String name:keys) {
            if(mapOfParks.get(name) >= numberOfVotesInteger) {
                numberOfVotesInteger = mapOfParks.get(name);
                parkCode = name;
            }
        }
        favoriteParkList.add(i,parkCode);
        mapOfParks.remove(parkCode);
    }
    return favoriteParkList;
}



@SuppressWarnings({ "unchecked", "rawtypes" })
public Object[] orderFavoriteParkAsObjectArray(Map<Park, Integer> mapOfParks){

	Object[] a = mapOfParks.entrySet().toArray();
	Arrays.sort(a, new Comparator() {
		@Override
	    public int compare(Object o1, Object o2) {
	    	int resultComparison = ((Map.Entry<String, Integer>) o2).getValue()
	                   .compareTo(((Map.Entry<String, Integer>) o1).getValue());
	    	
	    	if(resultComparison == 0) {
	    		return ((Map.Entry<Park, Integer>) o1).getKey().getParkname()
			.compareTo(((Map.Entry<Park, Integer>) o2).getKey().getParkname());
	    	}
	    	else return resultComparison;
	    }
	});
	return a;
}


public Map<Park, Integer> getOrderedFavoriteParks(){
    String favoriteParkSQLQueryString = " SELECT parkcode, count(*) " + 
                                    "FROM survey_result " + 
                                    "GROUP BY parkcode "+
                                    "ORDER BY count DESC;";
    SqlRowSet results = jdbcTemplate.queryForRowSet(favoriteParkSQLQueryString);
    Map<Park, Integer> favoriteParks = new HashMap<Park, Integer>();
    //LinkedList<Park> favoriteParks = new ArrayList<Park>();

    while(results.next()) {
        String key = results.getString(1);
        Integer value = results.getInt(2);
        
        favoriteParks.put(jdbcParkDAO.getParkFromParkCode(key), value);
    }
    return favoriteParks;
}

}
