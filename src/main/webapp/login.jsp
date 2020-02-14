<%@ include file="/WEB-INF/parts/commons.jsp" %>

<html>
<body>

    <h2><fmt:message key="login.page.title"/></h2><br/>

    <form method="post" action="${pageContext.request.contextPath}/app/login">

        <div><label> <fmt:message key="email.indication"/>
            <input type="text" name="email"><br/><br/>
        </label></div>

        <div><label> <fmt:message key="password.indication"/>
            <input type="password" name="password"><br/><br/>
        </label></div>

        <input class="button" type="submit" value="<fmt:message key="login.button"/>">

    </form>

    <p></p>

    <%@ include file="/WEB-INF/parts/unauthorizedCommons.jsp" %>

</body>
</html>