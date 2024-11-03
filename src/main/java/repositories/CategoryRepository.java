package repositories;

import models.Category;
import utils.DatabaseUtil; 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {

    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try (Connection conn = DatabaseUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM categories")) {
            while (rs.next()) {
                categories.add(new Category(rs.getLong("id"), rs.getString("name"), rs.getString("description")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public void save(Category category) {
        String query = category.getId() == null ? 
                       "INSERT INTO categories (name, description) VALUES (?, ?)" :
                       "UPDATE categories SET name = ?, description = ? WHERE id = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, category.getName());
            ps.setString(2, category.getDescription());
            if (category.getId() != null) ps.setLong(3, category.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Long id) {
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM categories WHERE id = ?")) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
