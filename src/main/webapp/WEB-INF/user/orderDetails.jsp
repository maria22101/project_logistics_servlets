<%@ include file="/WEB-INF/parts/commons.jsp" %>

<html>
<body>

    <%@ include file="/WEB-INF/parts/userHeader.jsp" %>

    <h2 style="color: seagreen"><fmt:message key="usercabinet.orderdetails.title"/></h2>

    <table border="0.5">
        <thead>
        <tr>
            <th style="background-color: #3a60bf"><fmt:message key="usercabinet.orderdetails.data"/></th>
            <th style="background-color: #3a60bf"><fmt:message key="usercabinet.orderdetails.information"/></th>
        </tr>
        </thead>

        <tbody>
        <tr>
            <td><fmt:message key="order.number"/></td>
            <td>${invoice.order.orderNumber}</td>
        </tr>
        <tr>
            <td><fmt:message key="order.dispatch.city"/></td>
            <td>${invoice.order.dispatchAddress.city}</td>
        </tr>
        <tr>
            <td><fmt:message key="order.dispatch.street"/></td>
            <td>${invoice.order.dispatchAddress.street}</td>
        </tr>
        <tr>
            <td><fmt:message key="order.dispatch.house"/></td>
            <td>${invoice.order.dispatchAddress.house}</td>
        </tr>
        <tr>
            <td><fmt:message key="order.dispatch.apartment"/></td>
            <td>${invoice.order.dispatchAddress.apartment}</td>
        </tr>
        <tr>
            <td><fmt:message key="order.delivery.city"/></td>
            <td>${invoice.order.deliveryAddress.city}</td>
        </tr>
        <tr>
            <td><fmt:message key="order.delivery.street"/></td>
            <td>${invoice.order.deliveryAddress.street}</td>
        </tr>
        <tr>
            <td><fmt:message key="order.delivery.house"/></td>
            <td>${invoice.order.deliveryAddress.house}</td>
        </tr>
        <tr>
            <td><fmt:message key="order.delivery.apartment"/></td>
            <td>${invoice.order.deliveryAddress.apartment}</td>
        </tr>
        <tr>
            <td><fmt:message key="order.delivery.date"/></td>
            <td>${invoice.order.deliveryDate}</td>
        </tr>
        <tr>
            <td><fmt:message key="order.weight"/></td>
            <td>${invoice.order.weight}</td>
        </tr>
        <tr>
            <td><fmt:message key="order.cargo"/></td>
            <td>${invoice.order.cargoType}</td>
        </tr>
        <tr>
            <td><fmt:message key="order.sum"/></td>
            <td>${invoice.order.sum}</td>
        </tr>
        <tr>
            <td><fmt:message key="order.status"/></td>
            <td>${invoice.order.orderStatus}</td>
        </tr>
        <tr>
            <td><fmt:message key="order.invoice.number"/></td>
            <td>${invoice.invoiceNumber}</td>
        </tr>
        </tbody>
    </table>

    <p></p>

    <form action="${pageContext.request.contextPath}/app/user/invoiced_orders/paying" method="post">
        <div>
            <input type="hidden" value="${invoice.order.orderNumber}" name="orderNumber">
            <input type="submit" value="<fmt:message key="usercabinet.invoice.payment.button"/>">
        </div>
    </form>

</body>
</html>