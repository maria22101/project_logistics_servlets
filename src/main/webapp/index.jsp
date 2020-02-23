<%@ include file="/WEB-INF/parts/commons.jsp" %>

<html>
<body>

    <%@ include file="/WEB-INF/parts/mainHeader.jsp" %>

    <div style="width: 100%; float: left;">

        <div style="float: left;">
            <div>

                <h2 style="color: midnightblue"><fmt:message key="main.services.routes.table.title"/></h2>

                <table border="0.5">
                    <thead>
                    <tr>
                        <th><fmt:message key="main.route.point.one"/></th>
                        <th><fmt:message key="main.route.point.two"/></th>
                        <th><fmt:message key="main.basic.rate"/></th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:choose>

                        <c:when test="${sessionScope.lang == ua}">
                            <c:forEach var="route" items="${routes}">
                                <tr>
                                    <td>${route.pointOne}</td>
                                    <td>${route.pointTwo}</td>
                                    <td>${route.basicRate}</td>
                                </tr>
                            </c:forEach>
                        </c:when>

                        <c:otherwise>
                            <c:forEach var="route" items="${routes}">
                                <tr>
                                    <td>${route.pointOneUA}</td>
                                    <td>${route.pointTwoUA}</td>
                                    <td>${route.basicRate}</td>
                                </tr>
                            </c:forEach>
                        </c:otherwise>

                    </c:choose>

                    </tbody>
                </table>

            </div>
        </div>

        <div style="float: left;">
            <div style="padding-left: 15px;">

                <h2 style="color: seagreen"><fmt:message key="main.services.weight.coeff.table.title"/></h2>

                <table border="0.5">

                    <thead>
                    <tr>
                        <th style="background-color: mediumseagreen"><fmt:message key="main.weight.differenciation"/></th>
                        <th style="background-color: mediumseagreen"><fmt:message key="main.weight.lower.bound"/></th>
                        <th style="background-color: mediumseagreen"><fmt:message key="main.weight.upper.bound"/></th>
                        <th style="background-color: mediumseagreen"><fmt:message key="main.weight.coeff"/></th>
                    </tr>
                    </thead>

                    <c:set var="map" value="${applicationScope['properties']}"/>

                    <tbody>
                    <tr>
                        <td><fmt:message key="main.weight.light"/></td>
                        <td>${map['weight.light.lower.bound.value']}</td>
                        <td>${map['weight.light.upper.bound.value']}</td>
                        <td>${map['weight.coeff.light']}</td>
                    </tr>
                    <tr>
                        <td><fmt:message key="main.weight.medium"/></td>
                        <td>${map['weight.medium.lower.bound.value']}</td>
                        <td>${map['weight.medium.upper.bound.value']}</td>
                        <td>${map['weight.coeff.medium']}</td>
                    </tr>
                    <tr>
                        <td><fmt:message key="main.weight.heavy"/></td>
                        <td>${map['weight.heavy.lower.bound.value']}</td>
                        <td>${map['weight.heavy.upper.bound.value']}</td>
                        <td>${map['weight.coeff.heavy']}</td>
                    </tr>
                    </tbody>

                </table>

            </div>
        </div>
    </div>

        <div style="clear: both;"></div>

    <br/><br/>

    <form method="get" action="${pageContext.request.contextPath}/app/calculate">
        <input type="hidden" name="submitted" value="true">

        <div>
        <strong><label style="color: darkgreen; font-size: medium"> <fmt:message key="main.route.point.one"/>
            <select name="dispatchCity">
                <c:forEach items="${citiesOptions}" var="city">
                            <option value="${city}">
                                    ${city}
                            </option>
                </c:forEach>
            </select>
        </label></strong>

        <strong><label style="color: darkgreen; font-size: medium"> <fmt:message key="main.route.point.two"/>
            <select name="deliveryCity">
                <c:forEach items="${citiesOptions}" var="city">
                    <option value="${city}">
                            ${city}
                    </option>
                </c:forEach>
            </select>
        </label></strong>

        <strong><label style="color: darkgreen; font-size: medium"> <fmt:message key="order.weight"/>
            <input type="text" name="weight" value="<c:out value="${param.weight}" />">
                <c:choose>
                    <c:when test="${param.submitted && empty param.weight}">
                        <span class="error"><fmt:message key="input.error.blank.field"/>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${invalidWeightInput==true}">
                            <span class="error"><fmt:message key="input.error.weight"/>
                               ${map['weight.light.lower.bound.value']}-${map['weight.heavy.upper.bound.value']}
                               <fmt:message key="input.error.kg"/>
                            </span>
                        </c:if>
                    </c:otherwise>
                </c:choose>
        </label></strong>
        </div>
        <p></p>
        <input class="button" type="submit" value="<fmt:message key="main.calculate.button"/>">
    </form>

</body>
</html>
