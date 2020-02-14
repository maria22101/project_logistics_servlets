<%@ include file="/WEB-INF/parts/commons.jsp" %>

<html>
<body>

    <h2><fmt:message key="admincabinet.title"/></h2>

    <a href="${pageContext.request.contextPath}/app/admin/orders">
        <fmt:message key="cabinet.orderlist.link"/>
    </a><br><br>

    <a href="${pageContext.request.contextPath}/app/admin/open_orders">
        <fmt:message key="admincabinet.open.orderlist.link"/>
    </a><br><br>

    <a href="${pageContext.request.contextPath}/app/admin/users">
        <fmt:message key="admincabinet.userlist.link"/>
    </a><br><br>

    <a href="${pageContext.request.contextPath}/app/admin/routes">
        <fmt:message key="admincabinet.routelist.link"/>
    </a><br><br>

    <p></p>

    <%@ include file="/WEB-INF/parts/cabinetCommons.jsp" %>

</body>
</html>