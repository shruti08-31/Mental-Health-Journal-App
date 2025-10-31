package PRIYANSHU.Audio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Music_Database_Entry {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java_project";
        String user = "root";
        String password = "password";
        String query = "INSERT INTO music (music_name, music_address) VALUES (?, ?)";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,password);
            PreparedStatement pstmt = con.prepareStatement(query);
            Scanner input = new Scanner(System.in);
            System.out.print("Enter music name: ");
            String musicName = input.nextLine();

            System.out.print("Enter music address: ");
            String musicAddress = input.nextLine();
            pstmt.setString(1,musicName);
            pstmt.setString(2,musicAddress);
            pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
