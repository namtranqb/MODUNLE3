package com.jwbd_exam.DAOImpl;

import com.jwbd_exam.DAO.IProductDAO;
import com.jwbd_exam.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {

    protected  static Connection getConnection(){

        final String jdbcURL="jdbc:mysql://localhost:3306/jwbd_exam";
        final String jdbcUsername = "root";
        final String jdbcPassword = "admin";
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Product> displayAllProduct() {

        String sql ="SELECT pl.Id,pl.Product_name,pl.Price, pl.Quantity,pl.Color, c.Category_name FROM product_list pl join category c on pl.Category_id = c.Id";
        List<Product> products = new ArrayList<>();
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);){

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                int id = rs.getInt("Id");
                String productName = rs.getString("Product_name");
                Double price = rs.getDouble("Price");
                int quantity = rs.getInt("Quantity");
                String color = rs.getString("Color");
                String categoryName = rs.getString("Category_name");

                products.add(new Product(id,productName,price,quantity,color,categoryName));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return products;
    }




    @Override
    public void createProduct(Product product) {
        String sql ="insert into product_list(Product_name, Price, Quantity, Color,`Description`,Category_id) values (?,?,?,?,?,(select Id from category where Category_name = ?))";
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);){

            preparedStatement.setString(1,product.getProduct_name());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setInt(3,product.getQuantity());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getDescription());
            preparedStatement.setInt(6, Integer.parseInt((product.getCategory_name())));

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
                throwables.printStackTrace();
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }

    }
}
