<%@ include file="/WEB-INF/parts/commons.jsp" %>

<html>
<body>

    <h2 class="error"><fmt:message key="access.denied"/></h2>

    <a href="${pageContext.request.contextPath}/"><fmt:message key="main.return.link"/></a>

</body>
</html>