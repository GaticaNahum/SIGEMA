package com.example.materias.controller;

import com.example.materias.model.DaoUsuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletHistorialUsuarios", value = "/ServletHistorialUsuarios")
public class ServletHistorialUsuarios extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listUsuarios", new DaoUsuario().findAll());
        request.getRequestDispatcher("/WEB-INF/view/historial.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
