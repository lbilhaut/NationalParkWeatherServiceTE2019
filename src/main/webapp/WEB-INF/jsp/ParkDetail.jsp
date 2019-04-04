<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<body>
<div class="main-content">
 	    		<img id="listImage" src="img/parks/${park.parkcodeInLowerCase}.jpg"/>
<br>
<br>
<strong>
<div id="park"><em>Park: <c:out value="${park.parkname}"/></em></div></strong>
 	    		<p id="inspirationalquote">"<c:out value ="${park.inspirationalquote}"/>"</p>
 	    		<p id="inspirationalquotesource">--<c:out value ="${park.inspirationalquotesource}"/> </p>
 	  
 	    		<br>

	<p id="parkdescription"><c:out value="${park.parkdescription}"/></p>
	<p id="acreage">Acreage: <c:out value="${park.acreage}"/></p>
	<p id="elevationinfeet">Elevation(ft): <c:out value="${park.elevationinfeet}"/></p>
		<p id="milesoftrail">Miles of Trail: <c:out value="${park.milesoftrail}"/></p>
		<p id="numberofcampsites">Number of Campsites: <c:out value="${park.numberofcampsites}"/></p>
		<p id="climate">Climate: <c:out value="${park.climate}"/></p>
		<p id="yearfounded">Year Founded: <c:out value="${park.yearfounded}"/></p>
		<p id="annualvisitorcount">Annual Visitor Count: <c:out value="${park.annualvisitorcount}"/></p>
		<p id="numberofanimalspecies">Number of Animal Species: <c:out value="${park.numberofanimalspecies}"/></p>
			<p id="entryfee">Entry Fee: $
			<c:choose>
			<c:when test="{park.entryfee == 0}"> 
			<c:out value="0"/> 
			</c:when>
			
			<c:otherwise>
			<c:out value="${park.entryfee}"/> 
			</c:otherwise>
			</c:choose>
		</p>
		
<h1>Weather forecast</h1>

	<div class="buttonToChangeTemperatureUnit">
 	<c:url var="action" value="/convertTemperature" />
 	<form method="POST" action="${action}" >
 		<input  name="parkcode" type="hidden" value="${park.parkcode}"/> 
 		<input type="submit" name="temperatureUnit" value="Change Temperature Unit" />
 	</form>
	</div>

<c:set var="i" value="${1}" />
<div id="weatherForecastGrid">

<c:forEach var="day" items="${fiveDayForecast}">
<span id="day${i}">

<div id="weatherForecastLine">
    <c:if test="${day.fivedayforecastvalue == 1}" >
        <p id="today">Today!</p>
    </c:if>

    <img src="img/weather/${day.forecast}.png" id="imageWeather"/>

    <div id="temperatureLow">
    <c:if test='${temperatureUnit eq "celsius"}'>
	    Low <c:out value="${day.lowInCelsius}" />°C
    </c:if>

    <c:if test='${temperatureUnit eq "fahrenheit"}'>
        Low <c:out value="${day.low}" />°F
    </c:if>
    </div>

    <div id="temperatureHigh">
      <c:if test='${temperatureUnit eq "celsius"}'>
	    High <c:out value="${day.highInCelsius}" />°C
    </c:if>

    <c:if test='${temperatureUnit eq "fahrenheit"}'>
        High <c:out value="${day.high}" />°F
    </c:if>
    </div>
    
    <div id="advice">
    <ul>
        <br>
        <c:if test='${day.forecast eq "snow" || day.forecast eq "rain" || day.forecast eq "thunderstorms" ||
         day.forecast eq "sunny" || day.extrawater || day.layers || day.frigidtemperature }'>   
        <li><b> National Park Advice</b></li>
        </c:if>
        <br>
        <c:choose>
            <c:when test='${day.forecast eq "snow"}'>
            <li>Pack snowshoes!</li>
            </c:when>
            <c:when test='${day.forecast eq "rain"}'>
            <li>Pack rain gear and wear waterproof shoes.</li>
            </c:when>
            <c:when test='${day.forecast eq "thunderstorms"}'>
            <li>Seek shelter and avoid hiking on exposed ridges.</li>
            </c:when>
            <c:when test='${day.forecast eq "sunny"}'>
            <li>Pack sunblock.</li>
            </c:when>   
        </c:choose>
        
            <c:if test="${day.extrawater}" >
        <li>Bring an extra gallon of water.</li>
            </c:if>
        
        <c:if test="${day.layers}" >
        <li>
            Wear breathable layers.
        </li>
        </c:if>
        
        
        <c:if test="${day.frigidtemperature}" >
            <li>Beware: frigid temperatures.</li>
        </c:if>
        
    </ul>
</div>
    
</div>
</span>
<c:set var="i" value="${i+1}" />
</c:forEach>

</div>

</div>

 <c:import url="/WEB-INF/jsp/common/footer.jsp" />


