package dao;

import java.util.List;

import entity.Product;
import entity.Product.Name;

public interface ProductDao {

	void add(Product product);

	void remove(Name idName);

	Product getById(Name idName);

	List<Product> getAll();

	List<Product> getDifferent();

	void update(Product product);

}
