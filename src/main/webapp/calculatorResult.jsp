<%@ include file="/WEB-INF/parts/commons.jsp" %>

<html>
<body>

<table border="0.5">
    <thead>
        <tr>
            <th style="background-color: seagreen"><fmt:message key="usercabinet.orderdetails.data"/></th>
            <th style="background-color: seagreen"><fmt:message key="usercabinet.orderdetails.information"/></th>
        </tr>
    </thead>

    <tbody>

        <tr>
            <td><fmt:message key="main.route.point.one"/></td>
            <td>
                <c:choose>
                    <c:when test="${sessionScope.lang == ua}">
                        ${route.pointOne}
                    </c:when>

                    <c:otherwise>
                        ${route.pointOneUA}
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>

        <tr>
            <td><fmt:message key="main.route.point.two"/></td>
            <td>
                <c:choose>
                    <c:when test="${sessionScope.lang == ua}">
                        ${route.pointTwo}
                    </c:when>

                    <c:otherwise>
                        ${route.pointTwoUA}
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>

        <tr>
            <td><fmt:message key="calculator.results.weight"/></td>
            <td>${weight}</td>
        </tr>

        <tr>
            <td><fmt:message key="calculator.results.cost"/></td>
            <td>${sum}</td>
        </tr>

    </tbody>
</table>

<br><br>

<a href="${pageContext.request.contextPath}/"><fmt:message key="main.return.link"/></a><br/>

