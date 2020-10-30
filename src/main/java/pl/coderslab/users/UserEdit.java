package pl.coderslab.users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/user/edit")
public class UserEdit extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/users/edit.jsp").forward(req, resp);
        HttpSession session = req.getSession();
        String sId = req.getParameter("id");
        int id = 0;
        try{
            id = Integer.parseInt(sId);
        }catch (NumberFormatException ex) {}
        session.setAttribute("id",id);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        int id = (int) session.getAttribute("id");
        if(username!=null && email!=null && password != null) {
            UserDao userDao = new UserDao();
            userDao.editor(id, username, email, password);
            resp.sendRedirect("/user/list");
        }else{
            resp.sendRedirect("/user/edit");
        }
    }
}
