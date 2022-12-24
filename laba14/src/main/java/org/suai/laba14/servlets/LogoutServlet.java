package org.suai.laba14.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        session.invalidate();
        session.setMaxInactiveInterval(0);

        //request.getRequestDispatcher("/WEB-INF/views/board.jsp").forward(request, response);
        response.sendRedirect("/board");

    }

}
