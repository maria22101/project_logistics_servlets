<%@ include file="/WEB-INF/parts/commons.jsp" %>

<html>
<body>

    <%@ include file="/WEB-INF/parts/adminHeader.jsp" %>

    <h2><fmt:message key="admincabinet.open.routes.title"/></h2>

    <table>
        <thead>
        <tr>
            <th><fmt:message key="main.route.point.one"/></th>
            <th><fmt:message key="main.route.point.two"/></th>
            <th><fmt:message key="main.basic.rate"/></th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="route" items="${routes}">
            <tr>
                <td>${route.pointOne}</td>
                <td>${route.pointTwo}</td>
                <td>${route.basicRate}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

<%--    <%=request.getAttribute("routes")%>--%>
<%--    <c:out value="${routes}"/>--%>

</body>
</html>