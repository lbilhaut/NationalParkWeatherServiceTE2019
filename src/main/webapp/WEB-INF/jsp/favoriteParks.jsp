<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<body>
<div class="main-content">

<h1>Favorite Parks</h1>
<c:if test="${thankYou}">
    <p id="ThankYouForVoting">Thank you for submitting your vote!</p>
</c:if>


<c:set var="i" value="${0}" />
<c:forEach var="park" items="${favoriteParksVotes}">

<c:if test="${i == 0}">
	<c:set var="highestVoteCount" value="${park.value}" />
</c:if>

	<c:url var="parkDetailUrl" value="/parkDetail" >
		 <c:param name="parkcode">${park.key.parkcode}</c:param>
	</c:url>
	<div id="resultSurveyGrid">
  		<a href="${parkDetailUrl}"><img id="SurveyParkImage" src = "img/parks/${park.key.parkcodeInLowerCase}.jpg"/></a>
		<span class="SurveyParkName"> 
		<c:if test="${ park.value == highestVoteCount}">
			<p id="VotedBestNationalPark">Voted best National Park!</p>
		</c:if>
		<c:out value="${park.key.parkname}"	 />
		</span>
		<span id="SurveyVote">
			<c:if test="${park.value == 1 }">
				<c:out value=" ${park.value}" /> vote 
			</c:if>
			<c:if test="${park.value > 1 }">
				<c:out value=" ${park.value}" /> votes
			</c:if>
		</span>

	</div>
	<c:set var="i" value="${i+1}" />
</c:forEach>

</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />