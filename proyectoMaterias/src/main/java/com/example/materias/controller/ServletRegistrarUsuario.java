package com.example.materias.controller;

import com.example.materias.model.DaoUsuario;
import com.example.materias.model.Usuario;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ServletRegistrarUsuario", value = "/ServletRegistrarUsuario")
public class ServletRegistrarUsuario extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listUsuarios", new DaoUsuario().findAll());
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Usuario usuario = new Usuario();
        DaoUsuario dao = new DaoUsuario();

        usuario.setNombre(request.getParameter("nombre"));
        usuario.setEstatus(request.getParameter("status"));

        if (dao.crearUsuario(usuario)){
            request.setAttribute("listUsuarios", new DaoUsuario().findAll());
            request.getRequestDispatcher("/WEB-INF/view/historial.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }
}
