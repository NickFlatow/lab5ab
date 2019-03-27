import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {


        // Create a new ItemDB
        CreateItemDB idb = new CreateItemDB();

        //Get input from user
        boolean run = true;
        while(run) {
            displayCatalog();
            System.out.println("Enter ProductId to Enter add to ShoppingCart");
            Scanner sc = new Scanner(System.in);

            int option = (int) (sc.nextInt());

            addToCart(option);
            displayCart();
            if(option == 9999){
                run = false;
            }
        }

    }

    private static void displayCart() {
        final String DB_URL = "jdbc:derby:ProductDB";
        // Create a connection to the database.

        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();
            System.out.println("====================================");
            System.out.println("Shopping Cart");
            System.out.println("====================================");
            String sql = "SELECT ProdNum,Name,Cost, Img FROM ShoppingCart";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id  = rs.getInt("Prodnum");
                String name = rs.getString("Name");
                double cost = rs.getDouble("Cost");
                String img = rs.getString("Img");

                System.out.println("Id: " + id);
                System.out.println("Name: " + name);
                System.out.println("Cost: " + cost);
                System.out.println("Img: " + img + "\n");
            }
            //clean up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println("displayCart Error :" + e.getMessage());
        }
    }

    private static void addToCart(int option) {
        final String DB_URL = "jdbc:derby:ProductDB";
        try {

            Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();
            Statement shoppingCart = conn.createStatement();
            String sql = "SELECT ProdNum, Name, Cost, Img FROM ItemTable WHERE Prodnum ="+option;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("Prodnum");
                String name = rs.getString("Name");
                double cost = rs.getDouble("Cost");
                String img  = rs.getString("Img");


                System.out.println(id + " " + name + " " + " " +cost + " " + img );
                shoppingCart.executeUpdate("INSERT INTO ShoppingCart VALUES("+id+",'"+name+"',"+
                        cost+",'"+img+"')");

                System.out.println(name + " Added to Cart");
            }
            //clean up environment
//            rs.close();
//            stmt.close();
//            conn.close();
        }catch(SQLException e){
            System.out.println("add to cart Error :" + e.getMessage());
        }
    }

    private static void displayCatalog() {
        final String DB_URL = "jdbc:derby:ProductDB";
        try {

            Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();

            System.out.println("====================================");
            System.out.println("Catalog Listing");
            System.out.println("====================================");
            String sql = "SELECT ProdNum, Name, Cost, Img FROM ItemTable";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                //Get column by name
                String id = rs.getString("ProdNum");
                String name = rs.getString("Name");
                double cost = rs.getDouble("Cost");
                String img = rs.getString("Img");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Cost: " + cost);
                System.out.println("Img: " + img + "\n");
            }
            //clean up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException e){
            System.out.println("Error :" + e.getMessage());
        }
    }
}
