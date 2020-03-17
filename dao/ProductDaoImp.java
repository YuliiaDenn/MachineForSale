package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Product;
import entity.Product.Name;

public class ProductDaoImp extends Dao implements ProductDao {

	@Override
	public void add(Product product) {

		Connection conn = getConnection();
		Statement stat = null;
		String sql = "INSERT INTO products(id_product, price) VALUE ('" + product.getIdProduct() + "', '"
				+ product.getPrice() + "') ";
		try {
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void remove(Name idName) {
		Connection conn = getConnection();
		Statement stat = null;
		String sql = "DELETE FROM products WHERE id_product = '" + idName + "' LIMIT 1";
		try {
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	@Override
	public Product getById(Name idName) {
		Connection conn = getConnection();
		Statement stat = null;
		String sql = "SELECT * FROM products WHERE id_product = '" + idName + "' LIMIT 1";
		Product product = new Product();
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			rs.next();
			Name name = Name.valueOf(rs.getString(1));
			product.setIdProduct(name);
			product.setPrice(rs.getDouble(2));
			stat.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("This product is missing. Choose another product!");
		}
		return product;
	}

	@Override
	public List<Product> getAll() {
		Connection conn = getConnection();
		Statement stat = null;
		String sql = "SELECT * FROM products";
		Product product = null;
		List<Product> products = new ArrayList<>();
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				product = new Product();
				Name name = Name.valueOf(rs.getString(1));
				product.setIdProduct(name);
				product.setPrice(rs.getDouble(2));
				products.add(product);
			}
			stat.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public void update(Product product) {
		Connection conn = getConnection();
		Statement stat = null;
		String sql = "UPDATE products SET price = '" + product.getPrice() + "' WHERE id_product = '"
				+ product.getIdProduct() + "' ";
		try {
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			stat.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> getDifferent() {
		Connection conn = getConnection();
		Statement stat = null;
		String sql = "SELECT DISTINCT id_product, price  FROM products";
		Product product = null;
		List<Product> products = new ArrayList<>();
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				product = new Product();
				Name name = Name.valueOf(rs.getString(1));
				product.setIdProduct(name);
				product.setPrice(rs.getDouble(2));
				products.add(product);
			}
			stat.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;

	}

}
