package com.example.materias.controller;

import com.example.materias.model.DaoUsuario;
import com.example.materias.model.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletActualizar", value = "/ServletActualizar")
public class ServletActualizar extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id")!= null){
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("listUsuarios", new DaoUsuario().findAll());
            request.setAttribute("usuario", new DaoUsuario().findById(id));
            request.getRequestDispatcher("/WEB-INF/view/Actualizar.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoUsuario dao = new DaoUsuario();
        Usuario usuario = new Usuario();
        usuario.setNombre(request.getParameter("nombre"));
        usuario.setEstatus(request.getParameter("status"));
        usuario.setId(Integer.parseInt(request.getParameter("id")));
        if (dao.actualizarUsuarios(usuario)){
            request.setAttribute("listUsuarios", new DaoUsuario().findAll());
            request.getRequestDispatcher("/WEB-INF/view/historial.jsp").forward(request,response);
        }else{
            request.setAttribute("listUsuarios", new DaoUsuario().findAll());
            request.getRequestDispatcher("/WEB-INF/view/historial.jsp").forward(request,response);
        }
    }
}
