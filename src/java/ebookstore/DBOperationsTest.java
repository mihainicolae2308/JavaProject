/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookstore;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mihai
 */
public class DBOperationsTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String url = "jdbc:derby://localhost:1527/firstdb";
        String user = "Mihai";
        String password = "12";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        
        
        DatabaseOperations databaseOp = new DatabaseOperations();
        try {
            Connection c = databaseOp.dbConnect(url, driver, user, password);
   
            //Adding book types
            databaseOp.addBookType(1, "novel", c);
            databaseOp.addBookType(2, "art album" , c);
            //Adding book genres
            databaseOp.addBookGenre(1, "romance", c);
            databaseOp.addBookGenre(2, "mistery", c);
            databaseOp.addBookGenre(3, "SF", c);
            databaseOp.addBookGenre(4, "NA", c); //Not applicable for art albums
            //Adding paper qualities
            databaseOp.addPaperQuality(1, "low", c);
            databaseOp.addPaperQuality(2, "medium", c);
            databaseOp.addPaperQuality(3, "high", c);
            databaseOp.addPaperQuality(4, "NA", c); //Not applicable for novels
            //Adding some books
            databaseOp.addEbook("139012831222", "Interstellar", 1, 4, 234, 3, c);          
            
            databaseOp.removeEbookByName("Interstellar", c);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(DBOperationsTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
