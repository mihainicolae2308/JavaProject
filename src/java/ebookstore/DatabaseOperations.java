/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookstore;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Mihai
 */
public class DatabaseOperations {

    //Connection connection = null;
    //Statement statement = null;
    
    public Connection dbConnect (String url, String driver, String user, String password) throws SQLException, ClassNotFoundException {
        Class driverClass = Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;
    }
    
    public void addEbook (String isbn, String name, int id_type, int id_quality, int pages, int id_genre, Connection con) throws SQLException {
        Statement st = con.createStatement();
        String sqlCommand = "INSERT INTO EBOOKS VALUES ('" + isbn + 
                "', '" + name + "', " + id_type + ", " + id_quality + 
                ", " + pages + ", " + id_genre + ")";
        System.out.println(sqlCommand);
        st.execute(sqlCommand);
    }
    
    public void addBookType (int id_type, String type, Connection con) throws SQLException {
        Statement st = con.createStatement();
        String sqlCommand = "INSERT INTO BOOK_TYPES VALUES (" + id_type + ", '" + type + "')";
        System.out.println(sqlCommand);
        st.execute(sqlCommand);
    }
    
    public void addBookGenre (int id_genre, String genre, Connection con) throws SQLException {
        Statement st = con.createStatement();
        String sqlCommand = "INSERT INTO BOOK_GENRES VALUES (" + id_genre + ", '" + genre + "')";
        System.out.println(sqlCommand);
        st.execute(sqlCommand);
    }
    
    public void addPaperQuality (int id_quality, String quality, Connection con) throws SQLException {
        Statement st = con.createStatement();
        String sqlCommand = "INSERT INTO BOOK_PAPER_QUALITIES VALUES (" + id_quality + ", '" + quality + "')";
        System.out.println(sqlCommand);
        st.execute(sqlCommand);
    }
    
    public void removeEbookByName (String name, Connection con) throws SQLException {
        Statement st = con.createStatement();
        String sqlCommand = "DELETE FROM EBOOKS WHERE DENUMIRE='" + name +"'";
        System.out.println(sqlCommand);
        st.execute(sqlCommand);
    }
    
}
