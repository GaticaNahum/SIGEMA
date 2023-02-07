package com.example.sigema.model;

import com.example.sigema.util.ConnectionMySql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoMateria {

    Connection con;
    PreparedStatement pstm;
    Statement statement;
    ResultSet rs;

    public List<Materia> findAll(){
        List<Materia> listMaterias = new ArrayList<>();

        try {
            con = ConnectionMySql.getConnection();
            String query = "SELECT materias.id, materias.nombre, materias.descripción, materias.estado, materias.fecha_inicio," +
                    "materias.fecha_fin, materias.bloques from materias ;";
            statement = con.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()){
                Materia materia = new Materia();
                materia.setId(rs.getInt("id"));
                materia.setNombre(rs.getString("nombre"));
                materia.setDescripcion(rs.getString("descripción"));
                materia.setEstado(rs.getBoolean("estado"));
                materia.setFecha_inicio(rs.getString("fecha_inicio"));
                materia.setFecha_fin(rs.getString("fecha_fin"));
                materia.setBloques(rs.getInt("bloques"));
                listMaterias.add(materia);
            }

        }catch (SQLException ex){
            ex.printStackTrace();

        }finally {
            closeConnection();
        }
        return listMaterias;
    }

    public Materia findById(int id) {
        Materia materia = new Materia();
        try{
            con = ConnectionMySql.getConnection();
            String query = "Select materias.id, materias.nombre, materias.descripción, materias.estado, materias.fecha_inicio," +
                    "materias.fecha_fin, materias.bloques from materias where materias.id = ?;";
            pstm = con.prepareStatement(query);
            pstm.setInt(1,id);
            rs = pstm.executeQuery();
            if(rs.next()){
                materia.setId(rs.getInt("id"));
                materia.setNombre(rs.getString("nombre"));
                materia.setDescripcion(rs.getString("descripción"));
                materia.setEstado(rs.getBoolean("estado"));
                materia.setFecha_inicio(rs.getString("fecha_inicio"));
                materia.setFecha_fin(rs.getString("fecha_fin"));
                materia.setBloques(rs.getInt("bloques"));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            closeConnection();
        }
        return materia;
    }

    public boolean createMateria(Materia materia){
        boolean state = false;

        try {
            con= ConnectionMySql.getConnection();
            String query = "Insert into Materias (nombre,descripción, estado, fecha_inicio, fecha_fin, bloques)\n" +
                    "values (?,?,?,?,?,?);";
            pstm = con.prepareStatement(query);
            pstm.setString(1,materia.getNombre());
            pstm.setString(2,materia.getDescripcion());
            pstm.setBoolean(3,materia.isEstado());
            pstm.setString(4,materia.getFecha_inicio());
            pstm.setString(5,materia.getFecha_fin());
            pstm.setInt(6,materia.getBloques());
            state = pstm.executeUpdate() == 1;
        } catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            closeConnection();
        }
        return state;
    }

    public boolean actualizarMaterias(Materia materia){
        boolean state = false;
        try {
            con= ConnectionMySql.getConnection();
            String query = "Update materias set materias.nombre = ?,materias.descripción = ?, materias.estado = ?," +
                    "materias.fecha_inicio = ?, materias.fecha_fin = ?, materias.bloques = ? where materias.id = ?";
            pstm = con.prepareStatement(query);
            pstm.setString(1,materia.getNombre());
            pstm.setString(2,materia.getDescripcion());
            pstm.setBoolean(3,materia.isEstado());
            pstm.setString(4,materia.getFecha_inicio());
            pstm.setString(5,materia.getFecha_fin());
            pstm.setInt(6,materia.getBloques());
            pstm.setInt(7,materia.getId());

            state = pstm.executeUpdate() == 1;
        } catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            closeConnection();
        }
        return state;
    }

    public boolean eliminarMateria(int id){
        boolean state = false;
        try {
            con= ConnectionMySql.getConnection();
            String query = "Delete from materias where materias.id = ?;";
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
