package com.jdbc.td1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataRetriever {
        DBConnection dbConnection = new DBConnection();

        long countAllVotes(){
            long count = 0;
            try( Connection con = dbConnection.getConnection()){
                PreparedStatement ps = con.prepareStatement("select count(id) from vote");
                ResultSet rs = ps.executeQuery();
                while (rs.next()){

                }

            }
            catch(SQLException e){
                throw new RuntimeException(e);
            }
            return 0;
        }

}
