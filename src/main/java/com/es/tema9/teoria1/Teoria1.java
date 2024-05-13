package com.es.tema9.teoria1;

import java.sql.*;

public class Teoria1 {
    public static void main(String[] args) {


        String url = "jdbc:mysql://localhost:3306/alumnos?user=root&password=";
        try {

            //Establecer conexion
            Connection connection = DriverManager.getConnection(url);

            //Crear objeto de tipo statement
            Statement stmt = connection.createStatement();

            //Lanzar Query
            ResultSet rs = stmt.executeQuery("SELECT * FROM estudiantes");

            //Leer result
            while(rs.next()){
                String nombre = rs.getString("nombre");
                System.out.println("Nombre: " +nombre);
            }

            // Cerrar conexion
            connection.close();

        }catch (SQLException e){
            e.printStackTrace();
        }




    }
}
