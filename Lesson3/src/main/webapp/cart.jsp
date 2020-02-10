<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="geekbrains.persist.Product" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>
<div class="col-12">
    <a href="/les3/">Continue shopping</a>
    <table class="table table-bordered my-2">
        <thead>
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Name</th>
            <th scope="col">Description</th>
            <th scope="col">Price</th>
            <th scope="col">Quantity</th>
            <th scope="col">Sub Total</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="it" items="${sessionScope.cart}">

            <tr>
                <td><c:out value="${it.product.id}"/></td>
                <td><c:out value="${it.product.name}"/></td>
                <td><c:out value="${it.product.description}"/></td>
                <td><c:out value="${it.product.price}"/></td>
                <td><c:out value="${it.quantity}"/></td>
                <td><c:out value="${it.product.price * it.quantity}"/></td>

            </tr>

        </c:forEach>
        </tbody>
    </table>
    <a href="order_proceed.jsp">Proceed order</a>
</div>
</body>
</html>
