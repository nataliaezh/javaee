package geekbrains;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Получаем параметры авторизации
        String username = request.getParameter("user");
        String password = request.getParameter("password");

        // Проверяем имя пользователя и пароль
        if (username.equals("user")
                && password.equals("123")) {
            // если логин и пароль верны,
            // получаем ссылку на текущую сессию
            HttpSession session = request.getSession(true);
            // и устанавливаем атрибут user
            session.setAttribute("user", username);
            // также создаем новую корзину товаров
            session.setAttribute("productBasket", new HashMap());
        }
        // перенаправляем запрос на страницу выбора товаров
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(
                        "/index.jsp");
        dispatcher.forward(request, response);
    }
}


