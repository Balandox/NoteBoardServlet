package org.suai.laba14.servlets;

import org.suai.laba14.dao.CookieDAO;
import org.suai.laba14.dao.NoteDAO;
import org.suai.laba14.dao.PersonDAO;
import org.suai.laba14.model.Person;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

// сюда мы попадем, когда нам придут данные с формы(имя и пароль)
public class LoginServlet extends HttpServlet {
    private PersonDAO personDAO;
    private NoteDAO noteDAO;

    private CookieDAO cookieDAO;

    @Override
    public void init(){
        this.personDAO = new PersonDAO();
        this.noteDAO = new NoteDAO();
        this.cookieDAO = new CookieDAO();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // сюда мы попадем только, если у нас зашел новый чел
        // ему нужно было заново войти или заргеться и он отправил нам свои данные
        // т.е. сессия будет пустой, создаем новую
/*        HttpSession session = request.getSession(false);*/
        HttpSession session = request.getSession();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        if(this.personDAO.findByUserName(userName) == null){ // new user
            System.out.println(request.getCookies().length);
            this.personDAO.addPerson(userName, password);
        }

        this.cookieDAO.addCookieAndEntryTime(userName, request.getCookies()[0]);

        session.setAttribute("userName", userName);
        session.setAttribute("password", password);
        session.setMaxInactiveInterval(30*60);

        response.sendRedirect("/board");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();

        if(uri.equals("/login"))
            request.getRequestDispatcher("/WEB-INF/views/singIn.jsp").forward(request, response);
        else
            request.getRequestDispatcher("/WEB-INF/views/singUp.jsp").forward(request, response);

    }

}
