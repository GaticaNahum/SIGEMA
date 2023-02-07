package com.example.sigema.controller;

import com.example.sigema.model.DaoMateria;
import com.example.sigema.model.Materia;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletActualizarMateria", value = "/ServletActualizarMateria")
public class ServletActualizarMateria extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getParameter("id") != null){
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("listMaterias", new DaoMateria().findAll());
            request.setAttribute("materia", new DaoMateria().findById(id));
            request.getRequestDispatcher("/WEB-INF/view/Actualizar.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DaoMateria dao = new DaoMateria();
        Materia materia = new Materia();

        materia.setNombre(request.getParameter("nombre"));
        materia.setDescripcion(request.getParameter("descripcion"));
        materia.setEstado(Boolean.parseBoolean(request.getParameter("estado")));
        materia.setFecha_inicio(request.getParameter("fecha_inicio"));
        materia.setFecha_fin(request.getParameter("fecha_fin"));
        materia.setBloques(Integer.parseInt(request.getParameter("bloques")));
        materia.setId(Integer.parseInt(request.getParameter("id")));

        if(dao.actualizarMaterias(materia)){
            request.setAttribute("listMaterias", new DaoMateria().findAll());
            request.getRequestDispatcher("/WEB-INF/view/Historial.jsp").forward(request,response);
        }else{
            request.setAttribute("listMaterias", new DaoMateria().findAll());
            request.getRequestDispatcher("/WEB-INF/view/Historial.jsp").forward(request,response);
        }

    }
}
