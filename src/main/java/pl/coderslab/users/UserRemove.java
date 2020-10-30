package pl.coderslab.users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/user/remove")
public class UserRemove extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sId = req.getParameter("id");
        HttpSession session = req.getSession();
        session.setAttribute("id",sId);
        getServletContext().getRequestDispatcher("/users/remove.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String decision = req.getParameter("decision");
        if(decision.equals("yes")) {
            HttpSession session = req.getSession();
            String id1 = (String) session.getAttribute("id");
            UserDao userDao = new UserDao();
            int id = 0;
            try {
                id = Integer.parseInt(id1);
            } catch (NumberFormatException ex) {
            }
            userDao.remove(id);
            resp.sendRedirect("/user/list");
        }else{
            resp.sendRedirect("/user/list");
        }
    }
}
