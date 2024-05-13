package com.es.tema9.teoria2;

import java.sql.*;

public class Teoria2 {
    public static void main(String[] args) {


        // Establecer la url
        String url = "jdbc:mysql://localhost:3306/bdempleados?user=root&password=";

        // Conectarse a la BBDD
        try {
            Connection connection = DriverManager.getConnection(url);

            // Crear un objeto statement
            Statement st = connection.createStatement();

            // Lanzar una query
            ResultSet rs = st.executeQuery("SELECT * FROM empleados");

            while(rs.next()){

                // Visualizar los registros
                String id = rs.getString("id");
                String nombre = rs.getString("nombre");
                String edad = rs.getString("edad");
                String correo = rs.getString("correo");
                String isAdmin = rs.getString("isAdmin");

                System.out.println("id: " +id);
                System.out.println("\tnombre: " +nombre);
                System.out.println("\tedad: " +edad);
                System.out.println("\tcorreo: " +correo);
                System.out.println("\tisAdmin: " +isAdmin+ "\n"+"\n");
            }


            // Prueba
            Statement st2 = connection.createStatement();
            ResultSet rs2 = st2.executeQuery("SELECT * FROM empleados WHERE edad < 30");
            while(rs2.next()){

                // Visualizar los registros
                String id = rs2.getString("id");
                String nombre = rs2.getString("nombre");
                String edad = rs2.getString("edad");
                String correo = rs2.getString("correo");
                String isAdmin = rs2.getString("isAdmin");

                System.out.println("id: " +id);
                System.out.println("\tnombre: " +nombre);
                System.out.println("\tedad: " +edad);
                System.out.println("\tcorreo: " +correo);
                System.out.println("\tisAdmin: " +isAdmin+ "\n"+"\n");
            }


            //Consulta para obtener los registros de los empleados con nombre gumersindo
            Statement st3 = connection.createStatement();
            ResultSet rs3 = st3.executeQuery("SELECT * FROM empleados WHERE nombre like 'Gumersindo'");
            while(rs3.next()){

                // Visualizar los registros
                String id = rs3.getString("id");
                String nombre = rs3.getString("nombre");
                String edad = rs3.getString("edad");
                String correo = rs3.getString("correo");
                String isAdmin = rs3.getString("isAdmin");

                System.out.println("id: " +id);
                System.out.println("\tnombre: " +nombre);
                System.out.println("\tedad: " +edad);
                System.out.println("\tcorreo: " +correo);
                System.out.println("\tisAdmin: " +isAdmin+ "\n"+"\n");
            }


            //Empleados > 30 años
            Statement st4 = connection.createStatement();
            ResultSet rs4 = st4.executeQuery("SELECT * FROM empleados WHERE edad > 30");
            while(rs4.next()){

                // Visualizar los registros
                String id = rs4.getString("id");
                String nombre = rs4.getString("nombre");
                String edad = rs4.getString("edad");
                String correo = rs4.getString("correo");
                String isAdmin = rs4.getString("isAdmin");

                System.out.println("id: " +id);
                System.out.println("\tnombre: " +nombre);
                System.out.println("\tedad: " +edad);
                System.out.println("\tcorreo: " +correo);
                System.out.println("\tisAdmin: " +isAdmin+ "\n"+"\n");
            }

            // Empleados mayores de 30 y que sean admin
            Statement st5 = connection.createStatement();
            ResultSet rs5 = st5.executeQuery("SELECT * FROM empleados WHERE edad > 30 AND isAdmin = 1");
            while(rs5.next()){

                // Visualizar los registros
                String id = rs5.getString("id");
                String nombre = rs5.getString("nombre");
                String edad = rs5.getString("edad");
                String correo = rs5.getString("correo");
                String isAdmin = rs5.getString("isAdmin");

                System.out.println("id: " +id);
                System.out.println("\tnombre: " +nombre);
                System.out.println("\tedad: " +edad);
                System.out.println("\tcorreo: " +correo);
                System.out.println("\tisAdmin: " +isAdmin+ "\n"+"\n");
            }


            //Insertar registro
            Statement st6 = connection.createStatement();
            st6.execute("INSERT INTO empleados(`id`, `nombre`, `edad`, `correo`, `isAdmin`) VALUES ('emp8','Patri','patri@patri.com',24,1)");
            ResultSet rs6 = st6.executeQuery("SELECT * FROM empleados WHERE id LIKE 'emp8'");
            while(rs6.next()){

                // Visualizar los registros
                String id = rs6.getString("id");
                String nombre = rs6.getString("nombre");
                String edad = rs6.getString("edad");
                String correo = rs6.getString("correo");
                String isAdmin = rs6.getString("isAdmin");

                System.out.println("id: " +id);
                System.out.println("\tnombre: " +nombre);
                System.out.println("\tedad: " +edad);
                System.out.println("\tcorreo: " +correo);
                System.out.println("\tisAdmin: " +isAdmin+ "\n"+"\n");
            }





            connection.close();

        }catch (SQLException e){
            e.printStackTrace();
        }


    }
}
