package pl.coderslab.users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/show")
public class UserShow extends HttpServlet {

    private final String printUser = "SELECT * FROM users WHERE id = ?";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        String id = req.getParameter("id");
        User user = userDao.read(id,printUser);
        req.setAttribute("user",user);
        getServletContext().getRequestDispatcher("/users/show.jsp").forward(req, resp);
    }
}
