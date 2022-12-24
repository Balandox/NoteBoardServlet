package org.suai.laba14.servlets;

import org.suai.laba14.dao.NoteDAO;
import org.suai.laba14.dao.PersonDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Objects;
import java.util.StringTokenizer;


public class NoticeBoardServlet extends HttpServlet {

    private NoteDAO noteDAO;
    private PersonDAO personDAO;

    public void init(){
        this.noteDAO = new NoteDAO();
        this.personDAO = new PersonDAO();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        // для только что залогинившегося пользователя

        HttpSession session = request.getSession();
        String userName = null;

        if(uri.equals("/board")) {
/*            request.setAttribute("noteList", this.noteDAO.index());
            request.setAttribute("userName", userName);
            request.getRequestDispatcher("/WEB-INF/views/board.jsp").forward(request, response);*/
            userName = (String) session.getAttribute("userName");
            String text = request.getParameter("noteText");
            this.noteDAO.addNote(this.personDAO.findByUserName(userName), text);
            request.setAttribute("userName", userName);

            request.setAttribute("noteList", this.noteDAO.index());
            request.getRequestDispatcher("/WEB-INF/views/board.jsp").forward(request, response);
        }

/*        else if(uri.equals("/board/newNote")){
            userName = (String) session.getAttribute("userName");
            String text = request.getParameter("noteText");
            this.noteDAO.addNote(this.personDAO.findByUserName(userName), text);
            request.setAttribute("userName", userName);

            request.setAttribute("noteList", this.noteDAO.index());
            request.getRequestDispatcher("/WEB-INF/views/board.jsp").forward(request, response);
*//*            response.sendRedirect("/board");*//*
        }*/

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        HttpSession session = request.getSession(false);
        String userName = null;

        if(Objects.equals(uri, "/board")){
                request.setAttribute("noteList", this.noteDAO.index());
                if(session != null) {
                    userName = (String) session.getAttribute("userName");
/*                    System.out.println(session.getId());
                    System.out.println(userName);*/
                    request.setAttribute("userName", userName);
                }

            request.getRequestDispatcher("/WEB-INF/views/board.jsp").forward(request, response);
        }

        else if(uri.equals("/board/newNote")){
            if(session != null) {
                userName = (String) session.getAttribute("userName");
                request.setAttribute("userName", userName);
            }
            request.getRequestDispatcher("/WEB-INF/views/newNote.jsp").forward(request, response);
        }

    }

}
