<%@ page import="java.util.ArrayList" %>
<%@ page import="geekbrains.persist.User" %>
<!doctype html>
<html lang="en">

<%@include file="head.jsp"%>

<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">EShop</a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="#">List</a>
            </li>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="row py-2">
        <div class="col-12">
            <h2>
                Your order has been proceeded.
                Please provide us with delivery address:
            </h2>
              <form action="order_confirmation.jsp" method="post">
                <input type="hidden" value="${user.id}" id="id" name="id">
                <div class="form-group">
                    <label>Name</label>
                    <input type="text" value="${user.name}" class="form-control" id="name" name="name" placeholder="Enter name">
                </div>
                <div class="form-group">
                    <label>Address</label>
                    <input type="text" value="${user.address}" class="form-control" id="address" name="address" placeholder="Enter address">
                </div>
                <div class="form-group">
                    <label>Phone number</label>
                    <input type="number" value="${user.phone}" class="form-control" id="phone" name="phone" placeholder="Enter phone">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>
<table>
<%
    ArrayList<User> users = new ArrayList<>();
    if(request.getServletContext().getAttribute("deliveryList")!=null){
        users= (ArrayList<User>) request.getServletContext().getAttribute("deliveryList");
        if(!users.isEmpty()){
            %>
    <th> ID</th>
<th> Your name</th>
    <th> Your address</th>
    <th> Your phone</th>
    <%
        for (User u : users){
            %>
            <tr>
                <td><%=u.getId()%></td>
                <td><%=u.getName()%></td>
                <td><%=u.getAddress()%></td>
                <td><%=u.getPhone()%></td>

                    </tr>
    <%
        }
        }
        }
    %>
 </table>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

</body>