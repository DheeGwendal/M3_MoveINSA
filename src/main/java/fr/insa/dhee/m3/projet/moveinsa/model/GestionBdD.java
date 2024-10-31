/*
Copyright 2000- Francois de Bertrand de Beuvron

This file is part of CoursBeuvron.

CoursBeuvron is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

CoursBeuvron is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with CoursBeuvron.  If not, see <http://www.gnu.org/licenses/>.
 */
package fr.insa.dhee.m3.projet.moveinsa.model;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *
 * @author gwend
 */
public class GestionBdD {
    
    public static Connection connectMySQL(String host, int port,
            String database, String user, String pass) throws SQLException {
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new SQLException("driver mysql not found", ex);
        }
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://" + host + ":" + port + "/" + database, database, pass);
        con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        return con;
    }
    
    public static Connection mysqlServeurPourM3() throws SQLException {
        return connectMySQL("92.222.25.165", 3306,
                "m3_gdhee01",
                "m3_gdhee01",
                "5363125f");
    }
    
    public static void debut(){
        try{
            Connection conn = mysqlServeurPourM3();
            System.out.println("Connecte");
        } catch (SQLException ex){
            throw new Error(ex);
        }
    }
    public static void main (String[] args){
        debut();
    }
    
    @SpringBootApplication
@PWA(name = "MoveINSA", shortName = "MoveINSA")
@Theme("my-theme")
public class Application extends SpringBootServletInitializer 
        implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        }
    
    }
    
    public static Connection defaultCon() throws SQLException {
        return mysqlServeurPourM3();
//        return h2InMemory("test");
//        return h2InFile("bdd");
    }
    
}
