package dao;

import java.util.List;

import entity.Product.Name;
import entity.Sale;

public interface SaleDao {

	void add(Sale sale);

	void remove(int id);

	Sale getById(int id);

	Sale getByName(Name name);

	List<Sale> getAll();

	void update(Sale sale);

}
