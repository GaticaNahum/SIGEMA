package com.example.sigema.controller;

import com.example.sigema.model.DaoMateria;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletHistorialMaterias", value = "/ServletHistorialMaterias")
public class ServletHistorialMateria extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listMaterias", new DaoMateria().findAll());
        request.getRequestDispatcher("/WEB-INF/view/Historial.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}
