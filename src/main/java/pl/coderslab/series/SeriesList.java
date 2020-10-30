package pl.coderslab.series;


import pl.coderslab.films.Film;
import pl.coderslab.films.FilmDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/series")
public class SeriesList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SeriesDao seriesDao = new SeriesDao();
        Series[] series = seriesDao.seriesAll();
        req.setAttribute("series",series);
        getServletContext().getRequestDispatcher("/films/series.jsp").forward(req, resp);
    }
}
