package com.test;
import java.sql.*;

public class Worker {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/perfios", "root", "password");

        PreparedStatement pst1= con.prepareStatement("select first_name, last_name, upper(concat(first_name,' ',last_name)) as full_name from worker_table");
        ResultSet rs1= pst1.executeQuery();
        System.out.println("First Name"+" "+"Last Name"+" "+"Full Name");
        while(rs1.next()) {
            System.out.println(rs1.getString(1)+"    "+rs1.getString(2)+"     "+rs1.getString(3));
        }
        System.out.println();

        PreparedStatement pst2= con.prepareStatement("select distinct(department) from worker_table");
        ResultSet rs2=pst2.executeQuery();
        System.out.println("Departments");
        while(rs2.next())
        {
            System.out.println(rs2.getString(1));
        }
        System.out.println();

        PreparedStatement pst3= con.prepareStatement("select instr(binary first_name,'a') from worker_table where first_name = 'Amitabh'");
        ResultSet rs3=pst3.executeQuery();
        System.out.println("Position");
        while(rs3.next())
        {
            System.out.println(rs3.getInt(1));
        }
    }
}
