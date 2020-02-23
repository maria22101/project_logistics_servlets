<%@ include file="/WEB-INF/parts/commons.jsp" %>

<html>
<body>

    <%@ include file="/WEB-INF/parts/adminHeader.jsp" %>

    <h2 style="color: #3a60bf"><fmt:message key="admincabinet.open.routes.title"/></h2>

    <table border="0.5">
        <thead>
            <tr>
                <th><fmt:message key="main.route.point.one"/></th>
                <th><fmt:message key="main.route.point.two"/></th>
                <th><fmt:message key="main.basic.rate"/></th>
            </tr>
        </thead>
        <tbody>

            <c:choose>

                <c:when test="${sessionScope.lang == ua}">
                    <c:forEach var="route" items="${routes}">
                        <tr>
                            <td>${route.pointOneUa}</td>
                            <td>${route.pointTwoUa}</td>
                            <td>${route.basicRate}</td>
                        </tr>
                    </c:forEach>
                </c:when>

                <c:otherwise>
                    <c:forEach var="route" items="${routes}">
                        <tr>
                            <td>${route.pointOne}</td>
                            <td>${route.pointTwo}</td>
                            <td>${route.basicRate}</td>
                        </tr>
                    </c:forEach>
                </c:otherwise>

            </c:choose>

        </tbody>
    </table>

</body>
</html>