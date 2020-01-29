package ru.geekbrains;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="CatalogPageServlet", urlPatterns = "catalog")
public class CatalogPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-Type", "text/html; charset=utf-8");
        response.getWriter().println("<head><title>Catalog</title></head>");
        request.getRequestDispatcher("main.html").forward(request, response);
        request.getRequestDispatcher("cart.html").forward(request, response);
        request.getRequestDispatcher("order.html").forward(request, response);
        request.getRequestDispatcher("product.html").forward(request, response);

    }
}
