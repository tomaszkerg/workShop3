package pl.coderslab.films;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/films")
public class FilmList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FilmDao filmDao = new FilmDao();
        Film[] films = filmDao.filmsAll();
        req.setAttribute("films",films);
        getServletContext().getRequestDispatcher("/films/films.jsp").forward(req, resp);
    }
}
