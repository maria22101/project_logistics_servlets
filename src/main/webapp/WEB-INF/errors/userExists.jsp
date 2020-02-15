<%@ include file="/WEB-INF/parts/commons.jsp" %>

<html>
<body>

<h3 class="error"><fmt:message key="registration.emailexist.error.message"/></h3><br/>

<a href="${pageContext.request.contextPath}/app/registration">
    <fmt:message key="main.registration.link"/>
</a>

</body>
</html>