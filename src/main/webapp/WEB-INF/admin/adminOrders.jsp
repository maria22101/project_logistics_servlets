<%@ include file="/WEB-INF/parts/commons.jsp" %>

<html>
<body>

    <%@ include file="/WEB-INF/parts/adminHeader.jsp" %>

    <h2 style="color: #3a60bf"><fmt:message key="cabinet.orderlist.title"/></h2>

    <table border="0.5">
        <thead>
        <tr>
            <th><fmt:message key="order.number"/></th>
            <th><fmt:message key="name.indication"/></th>
            <th><fmt:message key="surname.indication"/></th>
            <th><fmt:message key="email.indication"/></th>
            <th><fmt:message key="order.dispatch.city"/></th>
            <th><fmt:message key="order.delivery.city"/></th>
            <th><fmt:message key="order.weight"/></th>
            <th><fmt:message key="order.cargo"/></th>
            <th><fmt:message key="order.sum"/></th>
            <th><fmt:message key="order.status"/></th>
            <th style="color: seagreen"><fmt:message key="order.invoice.number"/></th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="invoice" items="${invoices}">
            <tr>
                <td>${invoice.order.orderNumber}</td>
                <td>${invoice.order.user.name}</td>
                <td>${invoice.order.user.surname}</td>
                <td>${invoice.order.user.email}</td>
                <td>${invoice.order.dispatchAddress.city}</td>
                <td>${invoice.order.deliveryAddress.city}</td>
                <td>${invoice.order.weight}</td>
                <td>${invoice.order.cargoType}</td>
                <td>${invoice.order.sum}</td>
                <td>${invoice.order.orderStatus}</td>
                <td>
                    <c:if test="${invoice.invoiceNumber != 0}">
                        ${invoice.invoiceNumber}
                    </c:if>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>