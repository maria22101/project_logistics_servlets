<%@ include file="/WEB-INF/parts/commons.jsp" %>

<html>
<body>

    <h2 style="color: seagreen"><fmt:message key="usercabinet.title"/>${name} !</h2>

    <a href="${pageContext.request.contextPath}/app/user/orders">
        <fmt:message key="cabinet.orderlist.link"/>
    </a><br><br>

    <a href="${pageContext.request.contextPath}/app/user/invoiced_orders">
        <fmt:message key="usercabinet.invoiced.orderlist.link"/>
    </a><br><br>

    <a href="${pageContext.request.contextPath}/app/user/place_order">
        <fmt:message key="usercabinet.order.creation.link"/>
    </a><br><br>

    <p></p>

    <%@ include file="/WEB-INF/parts/cabinetCommons.jsp" %>

</body>
</html>