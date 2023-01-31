package com.example.materias.model;

import com.example.materias.util.ConnectionMysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoUsuario {

    Connection con;
    PreparedStatement pstm;
    Statement statement;
    ResultSet rs;


    public boolean crearUsuario(Usuario usuario){
        boolean state = false;

        try {
            con= ConnectionMysql.getConnection();
            String query = "Insert into usuarios (nombre,status)\n" +
                    "values (?,?);";
            pstm = con.prepareStatement(query);
            pstm.setString(1,usuario.getNombre());
            pstm.setString(2,usuario.getEstatus());
            state = pstm.executeUpdate() == 1;
        } catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            closeConnection();
        }
        return state;
    }


    public List<Usuario> findAll(){
        List<Usuario> listUsuarios = new ArrayList<>();
        try{
            con= ConnectionMysql.getConnection();
            String query = "Select usuarios.id,usuarios.nombre,usuarios.status from usuarios;";
            statement = con.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()){
                Usuario user = new Usuario();
                user.setId(rs.getInt("id"));
                user.setNombre(rs.getString("nombre"));
                user.setEstatus(rs.getString("status"));
                listUsuarios.add(user);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            closeConnection();
        }
        return listUsuarios;
    }

    public Usuario findById(int id) {
        Usuario usuario = new Usuario();
        try{
            con = ConnectionMysql.getConnection();
            String query = "Select usuarios.id,usuarios.nombre,usuarios.status from usuarios where usuarios.id = ?;";
            pstm = con.prepareStatement(query);
            pstm.setInt(1,id);
            rs = pstm.executeQuery();
            if(rs.next()){
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setEstatus(rs.getString("status"));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            closeConnection();
        }
        return usuario;
    }

    public boolean actualizarUsuarios(Usuario usuario){
        boolean state = false;
        try {
            con= ConnectionMysql.getConnection();
            String query = "update usuarios set usuarios.nombre = ?,usuarios.status = ? where usuarios.id = ?";
            pstm = con.prepareStatement(query);
            pstm.setString(1,usuario.getNombre());
            pstm.setString(2,usuario.getEstatus());
            pstm.setInt(3,usuario.getId());
            state = pstm.executeUpdate() == 1;
        } catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            closeConnection();
        }
        return state;
    }

    public boolean eliminarUsuario(int id){
        boolean state = false;
        try {
            con= ConnectionMysql.getConnection();
            String query = "Delete from usuarios where usuarios.id = ?;";
            pstm = con.prepareStatement(query);
            pstm.setInt(1,id);
            state = pstm.executeUpdate() == 1;
        } catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            closeConnection();
        }
        return state;
    }





























    public void closeConnection(){
        try{
            if(con != null){
                con.close();
            }
            if (pstm != null){
                pstm.close();
            }
            if (rs != null){
                rs.close();
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }


}
