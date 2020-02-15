<%@ include file="/WEB-INF/parts/commons.jsp" %>

<html>
<body>

<h2><fmt:message key="registration.page.title"/></h2><br/>

<form method="post" action="${pageContext.request.contextPath}/app/registration">

    <div><label> <fmt:message key="name.indication"/>
        <input type="text" name="name"><br/><br/>
    </label></div>

    <div><label> <fmt:message key="surname.indication"/>
        <input type="text" name="surname"><br/><br/>
    </label></div>

    <div><label> <fmt:message key="email.indication"/>
        <input type="text" name="email"><br/><br/>
    </label></div>

    <div><label> <fmt:message key="password.indication"/>
        <input type="password" name="password"><br/><br/>
    </label></div>

    <input class="button" type="submit" value="<fmt:message key="registration.button"/>">

</form>

<p></p>

<%@ include file="/WEB-INF/parts/unauthorizedCommons.jsp" %>

</body>
</html>