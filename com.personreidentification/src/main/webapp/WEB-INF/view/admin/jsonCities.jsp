
    <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
    <c:set var="length" value="${f:length(cityList)}"/>
[
	<c:forEach begin="0" end="${length-1}"  items="${cityList}" var="city" varStatus="j">
	
	{
		"cityName":"${city.cityName}",
		"id":"${city.id}"
	
	}
		<c:if test="${j.count ne length}">,</c:if>
		
	</c:forEach>
		
]
