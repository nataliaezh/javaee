import geekbrains.persist.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet (name = "DeliveryController", urlPatterns = "deliveryUrl")
public class DeliveryController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String id=req.getParameter("id");
        String name=req.getParameter("name");
        String address=req.getParameter("address");
        String phone=req.getParameter("phone");
        User user = new User();
        user.setId(Integer.parseInt("id"));
        user.setName("name");
        user.setAddress("address");
        user.setPhone(Integer.parseInt("phone"));

        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        if(req.getServletContext().getAttribute("deliveryList")!=null){
            users= (ArrayList<User>) req.getServletContext().getAttribute("deliveryList");
            users.add(user);
            req.getServletContext().setAttribute("deliveryList", users);
        }else {
            req.getServletContext().setAttribute("deliveryList", users);
        }
       // resp.sendRedirect("/les3/");


    }


}
