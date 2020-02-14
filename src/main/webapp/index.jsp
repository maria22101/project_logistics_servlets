<%@ include file="/WEB-INF/parts/commons.jsp" %>

<html>
<body>

    <%@ include file="/WEB-INF/parts/mainHeader.jsp" %>

    <div style="width: 100%; float: left;">

        <div style="float: left;">
            <div>

                <h2 style="color: #3a60bf"><fmt:message key="main.services.routes.table.title"/></h2>

                <table border="0.5">
                    <thead>
                        <tr>
                            <th><fmt:message key="main.route.point.one"/></th>
                            <th><fmt:message key="main.route.point.two"/></th>
                            <th><fmt:message key="main.basic.rate"/></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="route" items="${routes}">
                            <tr>
                                <td>${route.pointOne}</td>
                                <td>${route.pointTwo}</td>
                                <td>${route.basicRate}</td>
                            </tr>
                        </c:forEach>
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

        <strong style="color: #3a60bf"><fmt:message key="main.services.weight.coeff.explanation"/></strong>

</body>
</html>
