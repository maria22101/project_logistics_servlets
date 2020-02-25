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
            <td>${dispatchCity}</td>
        </tr>

        <tr>
            <td><fmt:message key="main.route.point.two"/></td>
            <td>${deliveryCity}</td>
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

</body>
</html>

