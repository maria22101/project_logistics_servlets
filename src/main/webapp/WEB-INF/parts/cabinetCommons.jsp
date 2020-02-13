<a href="?lang=en"><fmt:message key="lang.eng"/></a><br>

<a href="?lang=ua"><fmt:message key="lang.ua"/></a><br>


<a href="${pageContext.request.contextPath}/index.jsp"><fmt:message key="main.return.link"/></a>

<p></p>

<form action="${pageContext.request.contextPath}/app/logout" method="post">
   <input class="button" type="submit" value="<fmt:message key="logout.button"/>"/>
</form>