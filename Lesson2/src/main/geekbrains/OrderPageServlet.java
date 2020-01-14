package ru.geekbrains;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

@WebServlet(name="OrderPageServlet", urlPatterns = "order")
public class OrderPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException, ServletException {
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        response.getWriter().println("<head><title>Order</title></head>");
        request.getRequestDispatcher("main.html").forward(request, response);
        request.getRequestDispatcher("catalog.html").forward(request, response);
        request.getRequestDispatcher("cart.html").forward(request, response);
        request.getRequestDispatcher("product.html").forward(request, response);
    }
}
