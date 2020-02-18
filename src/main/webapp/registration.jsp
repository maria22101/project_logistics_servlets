<%@ include file="/WEB-INF/parts/commons.jsp" %>

<html>
<body>

<h2><fmt:message key="registration.page.title"/></h2><br/>

    <form method="post" action="${pageContext.request.contextPath}/app/registration">

        <input type="hidden" name="submitted" value="true">

        <div><label> <fmt:message key="name.indication"/>

            <input type="text" name="name" value="<c:out value="${param.name}" />">

            <c:choose>
                <c:when test="${param.submitted && empty param.name}">
                    <span class="error"><fmt:message key="input.error.blank.field"/>
                </c:when>
                <c:otherwise>
                    <c:if test="${invalidNameInput==true}">
                        <span class="error"><fmt:message key="input.error.name"/></span>
                    </c:if>
                </c:otherwise>
             </c:choose>

            <br/><br/>
        </label></div>

        <div><label> <fmt:message key="surname.indication"/>

            <input type="text" name="surname" value="<c:out value="${param.surname}" />">

<%--            <c:if test="${param.submitted && empty param.surname}">--%>
<%--                <span class="error"><fmt:message key="input.error.blank.field"/>--%>
<%--            </c:if>--%>
<%--            <c:if test="${invalidSurnameInput==true}">--%>
<%--                <span class="error"><fmt:message key="input.error.surname"/></span>--%>
<%--            </c:if>--%>

            <c:choose>
                <c:when test="${param.submitted && empty param.surname}">
                    <span class="error"><fmt:message key="input.error.blank.field"/>
                </c:when>
                <c:otherwise>
                    <c:if test="${invalidSurnameInput==true}">
                        <span class="error"><fmt:message key="input.error.surname"/></span>
                    </c:if>
                </c:otherwise>
             </c:choose>

            <br/><br/>
        </label></div>

        <div><label> <fmt:message key="email.indication"/>

            <input type="text" name="email" value="<c:out value="${param.email}" />">

             <c:choose>
                <c:when test="${param.submitted && empty param.email}">
                    <span class="error"><fmt:message key="input.error.blank.field"/>
                </c:when>
                <c:otherwise>
                    <c:if test="${invalidEmailInput==true}">
                        <span class="error"><fmt:message key="input.error.email"/></span>
                    </c:if>
                </c:otherwise>
             </c:choose>

            <br/><br/>
        </label></div>

        <div><label> <fmt:message key="password.indication"/>

            <input type="password" name="password" value="<c:out value="${param.password}" />">

             <c:choose>
                <c:when test="${param.submitted && empty param.password}">
                    <span class="error"><fmt:message key="input.error.blank.field"/>
                </c:when>
                <c:otherwise>
                    <c:if test="${invalidPasswordInput==true}">
                        <span class="error"><fmt:message key="input.error.password"/></span>
                    </c:if>
                </c:otherwise>
             </c:choose>

            <br/><br/>
        </label></div>

        <input class="button" type="submit" value="<fmt:message key="registration.button"/>">

    </form>

<p></p>

<%@ include file="/WEB-INF/parts/unauthorizedCommons.jsp" %>

</body>
</html>