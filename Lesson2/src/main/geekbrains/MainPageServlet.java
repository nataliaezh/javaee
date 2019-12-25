package ru.geekbrains;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="MainPageServlet", urlPatterns = "main")
public class MainPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("<head><title>Home Page</title></head>");
        request.getRequestDispatcher("catalog.html").forward(request, response);
        request.getRequestDispatcher("cart.html").forward(request, response);
        request.getRequestDispatcher("order.html").forward(request, response);
        request.getRequestDispatcher("product.html").forward(request, response);

    }

    }