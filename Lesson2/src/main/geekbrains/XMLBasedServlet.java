package ru.geekbrains;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class XMLBasedServlet implements Servlet {
    private  ServletConfig servletConfig;
    private Logger logger= LoggerFactory.getLogger(XMLBasedServlet.class);
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig=servletConfig;

    }

    @Override
    public ServletConfig getServletConfig() {
        return this.servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        logger.info("New request");
        servletResponse.getWriter().println("<h1>I sent response</h1>");
    }

    @Override
    public String getServletInfo() {
        return "Я метод, который может возвращать любую строку";
    }

    @Override
    public void destroy() {
        logger.info("Servlet can be destroyed");
    }
}
