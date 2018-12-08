package com.auth0.example;

import com.auth0.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.TimeZone;
import java.util.function.Supplier;

@WebServlet(urlPatterns = {"/portal/home"})
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        final String accessToken = (String) SessionUtils.get(req, "accessToken");
        final String idToken = (String) SessionUtils.get(req, "idToken");

        if (accessToken != null) {
            req.setAttribute("userId", accessToken);
        } else if (idToken != null) {
            // TODO display ID token details, better format on username
            req.setAttribute("userId", idToken);
        } else {
            req.setAttribute("userId", "Unknown User");
        }

        final Optional<Object> lastAccess = Optional.ofNullable(req.getSession().getAttribute("lastAccess"));
        if (lastAccess.isPresent()) {
            req.setAttribute("lastSeen", lastAccess.get());
        } else {
            req.setAttribute("lastSeen", "Never");
        }

        req.getSession().setAttribute("lastAccess", currentTimeAsDate.get());
        req.getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(req, res);
    }

    private static Supplier<String> currentTimeAsDate = () -> {
        final TimeZone timeZone = TimeZone.getTimeZone("UTC");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        dateFormat.setTimeZone(timeZone);
        return dateFormat.format(new Date()) + " UTC";
    };
}
