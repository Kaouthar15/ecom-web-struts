//package repositories;
//
//import models.Product;
//import utils.DatabaseUtil;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ProductRepository {
//
//	public List<Product> findAll() {
//		System.out.println("findAll products");
//		List<Product> products = new ArrayList<>();
//		try {
//			Connection conn = DatabaseUtil.getConnection();
//			Statement stmt = conn.createStatement();
//			ResultSet rs = stmt.executeQuery("SELECT * FROM products");
//			while (rs.next()) {
//				products.add(new Product(rs.getLong("id"), rs.getString("name"), rs.getDouble("price"),
//						rs.getString("photo"), rs.getLong("id_category")));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return products;
//	}
//
//	public void save(Product product) {
//		System.out.println("save product");
//		
//		String query = product.getId() == null
//				? "INSERT INTO products (name, price, photo, id_category) VALUES (?, ?, ?, ?)"
//				: "UPDATE products SET name = ?, price = ?, photo = ?, id_category = ? WHERE id = ?";
//		try {
//			Connection conn = DatabaseUtil.getConnection();
//			PreparedStatement ps = conn.prepareStatement(query);
//			ps.setString(1, product.getName());
//			ps.setDouble(2, product.getPrice());
//			ps.setString(3, product.getPhoto());
//			ps.setLong(4, product.getCategoryId());
//			if (product.getId() != null)
//				ps.setLong(5, product.getId());
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public void delete(Long id) {
//		System.out.println("delete product");
//		try {
//			Connection conn = DatabaseUtil.getConnection();
//			PreparedStatement ps = conn.prepareStatement("DELETE FROM products WHERE id = ?");
//			ps.setLong(1, id);
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//}
