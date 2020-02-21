<%@ include file="/WEB-INF/parts/commons.jsp" %>

<html>
<body>

    <%@ include file="/WEB-INF/parts/userHeader.jsp" %>

    <h2 style="color: seagreen"><fmt:message key="usercabinet.invoiced.orderlist.title"/></h2>

    <table border="0.5">
        <thead>
        <tr>
            <th><fmt:message key="order.number"/></th>
            <th><fmt:message key="name.indication"/></th>
            <th><fmt:message key="surname.indication"/></th>
            <th><fmt:message key="order.dispatch.city"/></th>
            <th><fmt:message key="order.delivery.city"/></th>
            <th><fmt:message key="order.weight"/></th>
            <th><fmt:message key="order.cargo"/></th>
            <th><fmt:message key="order.sum"/></th>
            <th><fmt:message key="order.status"/></th>
            <th><fmt:message key="order.action"/></th>

        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orders}">
            <tr>
                <td>${order.orderNumber}</td>
                <td>${order.user.name}</td>
                <td>${order.user.surname}</td>
                <td>${order.dispatchAddress.city}</td>
                <td>${order.deliveryAddress.city}</td>
                <td>${order.weight}</td>
                <td>${order.cargoType}</td>
                <td>${order.sum}</td>
                <td>${order.orderStatus}</td>

                <td>
<%--                    <a href="${pageContext.request.contextPath}/app/user/invoiced_orders/order_details">--%>
<%--                        <fmt:message key="usercabinet.review.and.pay"/>--%>
<%--                    </a>--%>

                    <form action="${pageContext.request.contextPath}/app/user/invoiced_orders/order_details" method="get">
                        <div>
                            <input type="hidden" value="${order.orderNumber}" name="orderNumber">
                            <input type="submit" value="<fmt:message key="usercabinet.invoice.payment.button"/>">
                        </div>
                    </form>
                </td>

            </tr>
        </c:forEach>
        </tbody>
    </table>

</body>
</html>