package com.auth0.example;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {

    private String auth0Domain;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        // TODO static-ize the config params!
        auth0Domain = config.getServletContext().getInitParameter("com.auth0.domain");
    }

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession() != null) {
            request.getSession().invalidate();
        }
        response.sendRedirect(String.format("https://%s/v2/logout?", auth0Domain));
    }

}
