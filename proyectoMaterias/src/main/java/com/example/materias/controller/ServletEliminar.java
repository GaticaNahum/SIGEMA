package com.example.materias.controller;

import com.example.materias.model.DaoUsuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletEliminar", value = "/ServletEliminar")
public class ServletEliminar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoUsuario dao = new DaoUsuario();
        int id;
        id = Integer.parseInt(request.getParameter("id"));

        if(dao.eliminarUsuario(id)){
            request.setAttribute("listUsuarios", new DaoUsuario().findAll());
            request.getRequestDispatcher("/WEB-INF/view/historial.jsp").forward(request,response);
        }else{
            request.setAttribute("listUsuarios", new DaoUsuario().findAll());
            request.getRequestDispatcher("/WEB-INF/view/historial.jsp").forward(request,response);
        }
    }
}
