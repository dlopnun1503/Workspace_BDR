package com.es.tema9.teoria3;

import java.sql.*;

public class Teoria3 {
    public static void main(String[] args) {

        // 1º Crear base de datos con nombre BDInstituto
        // 2º Craer 2 tablas -> estudiantes y asignaturas
        // 3º estudiantes: VARCHAR -> (PK)correo, nombre, DOUBLE -> nota_media
        //    asignaturas: varchar -> (PK)codigo, nombre, INT -> num_alumnos

        // Parte de java *******************************
        String url = "jdbc:mysql://localhost:3306/bdInstituto?user=root&password=";
        // 4º Crear conexion con la base de datos
        // 5º Visualizar todos los estudiantes
        // 6º Visualizar estudiantes con nota > 9
        // 7º Visualizar estudiantes con note < 5
        // 8º Insertar un estuduante
        // 9º Eliminar el estudiante del paso 7
        // 10º Visualizar todas las asignTURAS
        // 11º Insertar una nueva asignatura
        // 12º Cambiar el numero de alumnos de la asignatura anterior para que haya 1 mas


        try {
            Connection connection = DriverManager.getConnection(url);

            // Crear un objeto statement
            Statement st = connection.createStatement();

            // Lanzar una query -> 5º Visualizar estudiantes
            ResultSet rs = st.executeQuery("SELECT * FROM estudiantes");

            while(rs.next()){

                // Visualizar los registros
                String correo = rs.getString("correo");
                String nombre = rs.getString("nombre");
                String nota_media = rs.getString("nota_media");

                System.out.println("\tcorreo: " +correo);
                System.out.println("\tnombre: " +nombre);
                System.out.println("\tnota_media: " +nota_media);
            }


            // 6º Visualizar estudiantes con nota > 9
            Statement st2 = connection.createStatement();
            ResultSet rs2 = st2.executeQuery("SELECT * FROM estudiantes WHERE nota_media > 9.0 ");
            while(rs2.next()){

                // Visualizar los registros
                String correo = rs2.getString("correo");
                String nombre = rs2.getString("nombre");
                String nota_media = rs2.getString("nota_media");

                System.out.println("\tcorreo: " +correo);
                System.out.println("\tnombre: " +nombre);
                System.out.println("\tnota_media: " +nota_media);
            }


            // 7º Visualizar estudiantes con note < 5
            Statement st3 = connection.createStatement();
            ResultSet rs3 = st3.executeQuery("SELECT * FROM estudiantes WHERE nota_media < 5.0 ");
            while(rs3.next()){

                // Visualizar los registros
                String correo = rs3.getString("correo");
                String nombre = rs3.getString("nombre");
                String nota_media = rs3.getString("nota_media");

                System.out.println("\tcorreo: " +correo);
                System.out.println("\tnombre: " +nombre);
                System.out.println("\tnota_media: " +nota_media);
            }



            // 8º Insertar un estuduante
            Statement st6 = connection.createStatement();
            st6.execute("INSERT INTO estudiantes(`correo`, `nombre`, `nota_media`) VALUES ('maria@gmail.com','Maria',9.3)");
            ResultSet rs6 = st6.executeQuery("SELECT * FROM estudiantes WHERE correo LIKE 'maria@gmail.com'");
            while(rs6.next()){

                // Visualizar los registros
                String correo = rs6.getString("correo");
                String nombre = rs6.getString("nombre");
                String nota_media = rs6.getString("nota_media");

                System.out.println("\tcorreo: " +correo);
                System.out.println("\tnombre: " +nombre);
                System.out.println("\tnota_media: " +nota_media);
            }




            // 9º Eliminar el estudiante del paso 7
            Statement st7 = connection.createStatement();
            st7.execute("DELETE FROM estudiantes WHERE correo LIKE 'maria@gmail.com'");


            // 10º Visualizar todas las asignaturas
            Statement st8 = connection.createStatement();
            ResultSet rs8 = st8.executeQuery("SELECT * FROM asignaturas");
            while(rs8.next()){

                // Visualizar los registros
                String codigo = rs8.getString("codigo");
                String nombre = rs8.getString("nombre");
                String num_alumnos = rs8.getString("num_alumnos");

                System.out.println("\tcodigo: " +codigo);
                System.out.println("\tnombre: " +nombre);
                System.out.println("\tnum_alumnos: " +num_alumnos);
            }


            // 11º Insertar una nueva asignatura
            Statement st9 = connection.createStatement();
            st9.execute("INSERT INTO asignaturas(`codigo`, `nombre`, `num_alumnos`) VALUES ('as5','FOL',10)");
            ResultSet rs9 = st9.executeQuery("SELECT * FROM asignaturas WHERE codigo LIKE 'as5'");
            while(rs9.next()){

                // Visualizar los registros
                String codigo = rs9.getString("codigo");
                String nombre = rs9.getString("nombre");
                String num_alumnos = rs9.getString("num_alumnos");

                System.out.println("\tcodigo: " +codigo);
                System.out.println("\tnombre: " +nombre);
                System.out.println("\tnum_alumnos: " +num_alumnos);
            }

            // 12º Cambiar el numero de alumnos de la asignatura anterior para que haya 1 mas
            Statement st10 = connection.createStatement();
            st10.execute("UPDATE asignaturas SET num_alumnos = num_alumnos + 1");
            ResultSet rs10 = st10.executeQuery("SELECT * FROM asignaturas WHERE codigo LIKE 'as5'");
            while(rs10.next()){

                // Visualizar los registros
                String codigo = rs10.getString("codigo");
                String nombre = rs10.getString("nombre");
                String num_alumnos = rs10.getString("num_alumnos");

                System.out.println("\tcodigo: " +codigo);
                System.out.println("\tnombre: " +nombre);
                System.out.println("\tnum_alumnos: " +num_alumnos);
            }


            connection.close();

        }catch (SQLException e){
            e.printStackTrace();
        }



    }
}
