<%@ include file="/WEB-INF/parts/commons.jsp" %>

<html>
<body>

    <%@ include file="/WEB-INF/parts/userHeader.jsp" %>

    <h2 style="color: seagreen"><fmt:message key="cabinet.orderlist.title"/></h2>

    <c:if test="${page.elements.size() > 0}">

        <table border="0.5">
            <thead>
            <tr>
                <th><fmt:message key="order.number"/></th>
                <th style="background-color: mediumseagreen"><fmt:message key="order.dispatch.city"/></th>
                <th style="background-color: mediumseagreen"><fmt:message key="order.dispatch.street"/></th>
                <th style="background-color: mediumseagreen"><fmt:message key="order.dispatch.apartment"/></th>
                <th style="background-color: seagreen"><fmt:message key="order.delivery.city"/></th>
                <th style="background-color: seagreen"><fmt:message key="order.delivery.street"/></th>
                <th style="background-color: seagreen"><fmt:message key="order.delivery.apartment"/></th>
                <th ><fmt:message key="order.delivery.date"/></th>
                <th><fmt:message key="order.weight"/></th>
                <th><fmt:message key="order.cargo"/></th>
                <th><fmt:message key="order.sum"/></th>
                <th><fmt:message key="order.status"/></th>

            </tr>
            </thead>
            <tbody>
<%--            <c:forEach var="order" items="${orders}">--%>
            <c:forEach var="order" items="${page.elements}">
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
    </c:if>

    <p></p>

    <c:if test="${page.totalPage > 1}">
        <div class="pagination">
            <a href="#">&laquo;</a>
                <c:forEach begin="1" end='${page.totalPage}' var="i">
                    <c:choose>
                        <c:when test="${page.currentPage + 1 eq i}">
                             <a class="active" href="#">${i}</a>
                        </c:when>
                        <c:otherwise>
                             <a href="?page=${i}">${i}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            <a href="#">&raquo;</a>
        </div>
    </c:if>

</body>
</html>