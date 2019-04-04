<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<body>
<div class="main-content">
		<h1>Here is a list of the Parks!</h1>
		
		
			<c:forEach var="park" items="${parks}">
				
		 		<c:url var="parkDetailUrl" value="/parkDetail" >
		 			<c:param name="parkcode">${park.parkcode}</c:param>
		 		</c:url>
		 	
		 <div id="homepageGrid">	
		 <a href="${parkDetailUrl}"><img id="listImage" src = "img/parks/${park.parkcodeInLowerCase}.jpg"/></a>
		 		
			<strong><p id="homepageGridPark">Park: <c:out value="${park.parkname}"/></p>
	    		
	    	<p id="homepageGridState">State: <c:out value="${park.state}"/></p>
	    		
	    	<p id="homemadeGridDescription"> Description: <c:out value="${park.parkdescription}"/></p>
	    	</div> 
		</c:forEach>
		</div>	
		
 <c:import url="/WEB-INF/jsp/common/footer.jsp" />
 