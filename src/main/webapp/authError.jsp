<%@ include file="/WEB-INF/parts/commons.jsp" %>

<html>
<body>

    <h3 class="error"><fmt:message key="login.fail.message"/></h3><br/>

    <a href="${pageContext.request.contextPath}/app/login">
        <fmt:message key="main.login.link"/>
    </a><br>

</body>
</html>