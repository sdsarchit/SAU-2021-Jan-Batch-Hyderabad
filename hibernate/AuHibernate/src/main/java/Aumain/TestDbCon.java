package Aumain;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDbCon {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dbkn";
        try{
            Connection con = DriverManager.getConnection(url,"root","1126");
            System.out.println("success");
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
