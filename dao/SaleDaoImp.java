package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Product.Name;
import entity.Sale;

public class SaleDaoImp extends Dao implements SaleDao {

	@Override
	public void add(Sale sale) {
		Connection conn = getConnection();
		Statement stat = null;
		String sql = "INSERT INTO sales(name, amount) VALUE ('" + sale.getName() + "', '" + sale.getAmount() + "')";
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
	public void remove(int id) {
		Connection conn = getConnection();
		Statement stat = null;
		String sql = "DELETE FROM sales WHERE id_sale = '" + id + "'";
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
	public Sale getById(int id) {
		Connection conn = getConnection();
		Statement stat = null;
		String sql = "SELECT * FROM sales WHERE id_sale = '" + id + "'";
		Sale sale = new Sale();
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			rs.next();
			sale.setIdSale(rs.getInt(1));
			Name name = Name.valueOf(rs.getString(2));
			sale.setName(name);
			sale.setAmount(rs.getInt(3));
			stat.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sale;
	}

	@Override
	public List<Sale> getAll() {
		Connection conn = getConnection();
		Statement stat = null;
		String sql = "SELECT * FROM sales";
		List<Sale> sales = new ArrayList<>();
		Sale sale = null;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			while (rs.next()) {
				sale = new Sale();
				sale.setIdSale(rs.getInt(1));
				Name name = Name.valueOf(rs.getString(2));
				sale.setName(name);
				sale.setAmount(rs.getInt(3));
				sales.add(sale);
			}
			stat.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sales;
	}

	@Override
	public void update(Sale sale) {
		Connection conn = getConnection();
		Statement stat = null;
		String sql = "UPDATE sales SET amount = '" + sale.getAmount() + "' WHERE name = '" + sale.getName() + "'";
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
	public Sale getByName(Name name) {
		Connection conn = getConnection();
		Statement stat = null;
		String sql = "SELECT * FROM sales WHERE name = '" + name + "' LIMIT 1";
		Sale sale = new Sale();
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(sql);
			rs.next();
			sale.setIdSale(rs.getInt(1));
			Name getName = Name.valueOf(rs.getString(2));
			sale.setName(getName);
			sale.setAmount(rs.getInt(3));
			stat.close();
			conn.close();
		} catch (SQLException e) {

			return null;
		}
		return sale;
	}
}
