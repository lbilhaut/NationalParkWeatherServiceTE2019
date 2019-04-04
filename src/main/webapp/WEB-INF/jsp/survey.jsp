<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<body>
<div class="main-content">

<h1>Survey</h1>
<h3>Vote for your favorite National Park!</h3>

<c:url value="/survey" var="loginFormUrl" />
<form:form action="${loginFormUrl}" method="POST" modelAttribute="survey" >

<div class="gridSurveyQuestion">
	<form:label path="parkCode" id="surveyLabel" >Park</form:label>
	<form:select path="parkCode" id="surveyField">
		<c:forEach var="park" items="${listOfParks}">
			<option value="${park.parkcode}">${park.parkname}</option>
	 	</c:forEach>
	</form:select> 
</div>
<br>
<div class="gridSurveyQuestion">
    <form:label path="emailAddress" id="surveyLabel">Email</form:label>
    <form:input path="emailAddress"/>
    <form:errors path="emailAddress" />
</div>
<br>
<div class="gridSurveyQuestion">
    <form:label path="state" id="surveyLabel">Residence state</form:label>
    <form:input path="state"/>
    <form:errors path="state" />
</div>
<br>
<div class="gridSurveyQuestion">

<form:label path="activityLevel" id="surveyLabel" >Activity Level</form:label>
<span id="surveyField">
<form:radiobutton path="activityLevel" value="inactive"/>Inactive 
<form:radiobutton path="activityLevel" value="sedentary"/>Sedentary 
<form:radiobutton path="activityLevel" value="active"/>Active 
<form:radiobutton path="activityLevel" value="extremelyActive"/>Extremely active 
</span>

</div>
<br>
<div class="gridSurveyQuestion">
<span id="surveyField">
<input type="submit" value="Submit your vote!"/>
</span>
</div>
</form:form>


</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />