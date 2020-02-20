<%@ include file="/WEB-INF/parts/commons.jsp" %>

<html>
<body>

    <%@ include file="/WEB-INF/parts/userHeader.jsp" %>

    <c:set var="map" value="${applicationScope['properties']}"/>

    <h2 style="color: seagreen"><fmt:message key="usercabinet.order.creation.title"/></h2>

    <form method="post" action="${pageContext.request.contextPath}/app/user/place_order">
        <input type="hidden" name="submitted" value="true">

        <div><label> <fmt:message key="order.dispatch.city"/>
             <select name="dispatchCity">
                <c:forEach items="${routes}" var="route">
                    <option value="${route}">
                            ${route}
                    </option>
                </c:forEach>
            </select>
        </label></div>

        <div><label> <fmt:message key="order.dispatch.street"/>
            <input type="text" name="dispatchStreet" value="<c:out value="${param.dispatchStreet}" />">
                <c:choose>
                    <c:when test="${param.submitted && empty param.dispatchStreet}">
                        <span class="error"><fmt:message key="input.error.blank.field"/>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${invalidDispatchStreetInput==true}">
                            <span class="error"><fmt:message key="input.error.dispatch.street"/></span>
                        </c:if>
                    </c:otherwise>
                 </c:choose>
        </label></div>

        <div><label> <fmt:message key="order.dispatch.house"/>
            <input type="text" name="dispatchHouse" value="<c:out value="${param.dispatchHouse}" />">
                <c:choose>
                    <c:when test="${param.submitted && empty param.dispatchHouse}">
                        <span class="error"><fmt:message key="input.error.blank.field"/>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${invalidDispatchHouseInput==true}">
                            <span class="error"><fmt:message key="input.error.dispatch.house"/></span>
                        </c:if>
                    </c:otherwise>
                 </c:choose>
        </label></div>

        <div><label> <fmt:message key="order.dispatch.apartment"/>
            <input type="text" name="dispatchApartment" value="<c:out value="${param.dispatchApartment}" />">
                        <c:if test="${invalidDispatchApartmentInput==true}">
                            <span class="error"><fmt:message key="input.error.dispatch.apartment"/></span>
                        </c:if>
        </label></div>

        </br></br>

        <div><label> <fmt:message key="order.delivery.city"/>
           <select name="deliveryCity">
                <c:forEach items="${routes}" var="route">
                    <option value="${route}">
                            ${route}
                    </option>
                </c:forEach>
            </select>
        </label></div>

        <div><label> <fmt:message key="order.delivery.street"/>
            <input type="text" name="deliveryStreet" value="<c:out value="${param.deliveryStreet}" />">
                <c:choose>
                    <c:when test="${param.submitted && empty param.deliveryStreet}">
                        <span class="error"><fmt:message key="input.error.blank.field"/>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${invalidDeliveryStreetInput==true}">
                            <span class="error"><fmt:message key="input.error.delivery.street"/></span>
                        </c:if>
                    </c:otherwise>
                 </c:choose>
        </label></div>

        <div><label> <fmt:message key="order.delivery.house"/>
            <input type="text" name="deliveryHouse" value="<c:out value="${param.deliveryHouse}" />">
                <c:choose>
                    <c:when test="${param.submitted && empty param.deliveryHouse}">
                        <span class="error"><fmt:message key="input.error.blank.field"/>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${invalidDeliveryHouseInput==true}">
                            <span class="error"><fmt:message key="input.error.delivery.house"/></span>
                        </c:if>
                    </c:otherwise>
                 </c:choose>
        </label></div>

        <div><label> <fmt:message key="order.delivery.apartment"/>
            <input type="text" name="deliveryApartment" value="<c:out value="${param.deliveryApartment}" />">
                        <c:if test="${invalidDeliveryApartmentInput==true}">
                            <span class="error"><fmt:message key="input.error.delivery.apartment"/></span>
                        </c:if>
        </label></div>

        </br></br>

        <div><label> <fmt:message key="order.delivery.date"/>
            <input type="text" name="deliveryDate" value="<c:out value="${param.deliveryDate}" />">
                <c:choose>
                    <c:when test="${param.submitted && empty param.deliveryDate}">
                        <span class="error"><fmt:message key="input.error.blank.field"/>
                    </c:when>
                    <c:otherwise>
                        <c:if test="${invalidDeliveryDateInput==true}">
                            <span class="error"><fmt:message key="input.error.delivery.date"/></span>
                        </c:if>
                    </c:otherwise>
                 </c:choose>
        </label></div>

        <p></p>

        <div><label> <fmt:message key="order.weight"/>
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
        </label></div>

        <p></p>

        <div><label> <fmt:message key="order.cargo"/>
            <select name="cargoType">
                <c:forEach items="${cargoTypes}" var="cargoType">
                    <option value="${cargoType}">
                            ${cargoType}
                    </option>
                </c:forEach>
            </select>
        </label></div>

        </br></br>

        <input class="button" type="submit" value="<fmt:message key="usercabinet.order.placing.button"/>">
    </form>

</body>
</html>