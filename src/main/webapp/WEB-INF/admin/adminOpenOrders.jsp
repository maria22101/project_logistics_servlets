<%@ include file="/WEB-INF/parts/commons.jsp" %>

<html>
<body>

    <%@ include file="/WEB-INF/parts/adminHeader.jsp" %>

    <h2 style="color: #3a60bf"><fmt:message key="admincabinet.open.orderlist.title"/></h2>

        <table border="0.5">
            <thead>
            <tr>
                <th><fmt:message key="order.number"/></th>
                <th><fmt:message key="name.indication"/></th>
                <th><fmt:message key="surname.indication"/></th>
                <th><fmt:message key="email.indication"/></th>
<%--                <th><fmt:message key="order.dispatch.city"/></th>--%>
<%--                <th><fmt:message key="order.delivery.city"/></th>--%>
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
                    <td>${order.user.email}</td>
<%--                    <td>${openOrder.dispatchAddress.city}</td>--%>
<%--                    <td>${openOrder.deliveryAddress.city}</td>--%>
                    <td>${order.weight}</td>
                    <td>${order.cargoType}</td>
                    <td>${order.sum}</td>
                    <td>${order.orderStatus}</td>

                    <td>
                        <form action="${pageContext.request.contextPath}/app/admin/open_orders/invoicing">
                          <div>
                                <input type="hidden" value="${order.orderNumber}" name="orderNumber">
                                <input type="submit" value="<fmt:message key="admincabinet.issue.invoice.button"/>">
                          </div>
                        </form>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>

</body>
</html>