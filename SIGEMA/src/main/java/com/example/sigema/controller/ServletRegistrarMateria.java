package com.example.sigema.controller;

import com.example.sigema.model.DaoMateria;
import com.example.sigema.model.Materia;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletRegistrarMateria", value = "/ServletRegistrarMateria")
public class ServletRegistrarMateria extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listMaterias", new DaoMateria().findAll());
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Materia materia = new Materia();
        DaoMateria dao =  new DaoMateria();

        materia.setNombre(request.getParameter("nombre"));
        materia.setDescripcion(request.getParameter("descripcion"));
        materia.setEstado(true);
        materia.setFecha_inicio(request.getParameter("fecha_inicio"));
        materia.setFecha_fin(request.getParameter("fecha_fin"));
        materia.setBloques(Integer.parseInt(request.getParameter("bloques")));

        if(dao.createMateria(materia)){
            request.setAttribute("listMaterias", new DaoMateria().findAll());
            request.getRequestDispatcher("/WEB-INF/view/Historial.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("/index.jsp");
        }

        doGet(request,response);

    }
}
