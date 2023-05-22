package controllers;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Task;
import utils.DBUtil;


@WebServlet("/show")
public class ShowServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public ShowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager entityManager = DBUtil.createEntityManager();

        //該当のIDメッセージを取得
        Task task = entityManager.find(Task.class, Integer.parseInt(request.getParameter("id")));

        entityManager.close();

        request.setAttribute("task", task);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/views/tasks/show.jsp");
        requestDispatcher.forward(request,response);
    }

}
