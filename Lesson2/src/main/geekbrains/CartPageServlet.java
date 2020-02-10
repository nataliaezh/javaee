package ru.geekbrains;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="CartPageServlet", urlPatterns = "cart")
public class CartPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "text/html; charset=utf-8");
        response.getWriter().println("<head><title>Cart</title></head>");
        response.getWriter().println("<h1>You are on the cart's page</h1>");
        request.getRequestDispatcher("main.html").forward(request, response);
        request.getRequestDispatcher("catalog.html").forward(request, response);
        request.getRequestDispatcher("product.html").forward(request, response);
        request.getRequestDispatcher("order.html").forward(request, response);
        //getServletContext().getRequestDispatcher("/main.html").forward(request, response);
    }
}
