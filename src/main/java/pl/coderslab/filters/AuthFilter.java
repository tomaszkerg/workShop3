//package pl.coderslab.filters;
//
//import pl.coderslab.users.User;
//import pl.coderslab.users.UserDao;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//import java.util.List;
//
//@WebFilter("/*")
//public class AuthFilter extends HttpFilter {
//
//    private final String printUser = "SELECT * FROM users WHERE email = ?";
//    private final static String USER = "admin";
//    private final static String PASSWORD = "coderslab";
//
//    @Override
//    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
//        HttpSession session = req.getSession();
//        if(session!=null) {
//            List<String> data = (List) session.getAttribute("username");
//            String email = data.get(0);
//            String pass = data.get(1);
//            UserDao userDao = new UserDao();
//            User user = userDao.read(email, printUser);
//            if (pass.equals(user.getPassword()) && email.equals(user.getEmail())) {
//                res.sendRedirect("/films");
//            } else if (USER.equals(email) && PASSWORD.equals(pass)) {
//                chain.doFilter(req, res);
//            } else {
//                res.sendRedirect("/login");
//            }
//        }else{
//            chain.doFilter(req, res);
//            res.sendRedirect("/login");
//        }
//
//    }
//}