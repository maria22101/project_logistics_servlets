<%@ include file="/WEB-INF/parts/commons.jsp" %>
<%@ page language="java" isErrorPage="true"  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>

<html>
<body>

    <h3 class="error"><fmt:message key="error.page.title"/></h3><br/>

        <br>
        <a href="${pageContext.request.contextPath}/"><fmt:message key="main.return.link"/></a><br/>

</body>
</html>