<%@ include file="/WEB-INF/parts/commons.jsp" %>

<html>
<body>

    <%@ include file="/WEB-INF/parts/userHeader.jsp" %>

    <h2 style="color: seagreen"><fmt:message key="cabinet.orderlist.title"/></h2>

    <table border="0.5">
        <thead>
        <tr>
            <th><fmt:message key="order.number"/></th>
            <th><fmt:message key="order.dispatch.city"/></th>
            <th><fmt:message key="order.dispatch.street"/></th>
            <th><fmt:message key="order.dispatch.apartment"/></th>
            <th><fmt:message key="order.delivery.city"/></th>
            <th><fmt:message key="order.delivery.street"/></th>
            <th><fmt:message key="order.delivery.apartment"/></th>
            <th><fmt:message key="order.delivery.date"/></th>
            <th><fmt:message key="order.weight"/></th>
            <th><fmt:message key="order.cargo"/></th>
            <th><fmt:message key="order.sum"/></th>
            <th><fmt:message key="order.status"/></th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.orderNumber}</td>
                <td>${order.dispatchAddress.city}</td>
                <td>${order.dispatchAddress.street}</td>
                <td>${order.dispatchAddress.apartment}</td>
                <td>${order.deliveryAddress.city}</td>
                <td>${order.deliveryAddress.street}</td>
                <td>${order.deliveryAddress.apartment}</td>
                <td>${order.deliveryDate}</td>
                <td>${order.weight}</td>
                <td>${order.cargoType}</td>
                <td>${order.sum}</td>
                <td>${order.orderStatus}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>