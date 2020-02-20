<%@ include file="/WEB-INF/parts/commons.jsp" %>

<html>
<body>

    <%@ include file="/WEB-INF/parts/adminHeader.jsp" %>

    <h2 style="color: #3a60bf"><fmt:message key="admincabinet.userlist.title"/></h2>

    <table border="0.5">
        <thead>
        <tr>
            <th><fmt:message key="admincabinet.user.id"/></th>
            <th><fmt:message key="name.indication"/></th>
            <th><fmt:message key="surname.indication"/></th>
            <th><fmt:message key="email.indication"/></th>
            <th><fmt:message key="admincabinet.user.role"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.surname}</td>
                <td>${user.email}</td>
                <td>${user.role}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>