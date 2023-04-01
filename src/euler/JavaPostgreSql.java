/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package euler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JavaPostgreSql {

    public JavaPostgreSql(){
        
    }
    
    public void mainTest() {
        
            
        String url = "jdbc:postgresql://192.168.124.135:5432/vim";
        String user = "postgres";
        String password = "000";

        try (Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT VERSION()")) {

            if (rs.next()) {
                System.out.println(rs.getString(1));
            }

        } catch (SQLException ex) {
        
            Logger lgr = Logger.getLogger(JavaPostgreSql.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
        
        /**/
    }
}

/**
 *
 * @author zanxi
 */

