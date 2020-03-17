package service;

import java.util.List;

import dao.ProductDao;
import dao.ProductDaoImp;
import dao.SaleDao;
import dao.SaleDaoImp;
import entity.Product;
import entity.Product.Name;
import entity.Sale;

public class MachineForSale {

	ProductDao productDao = new ProductDaoImp();
	SaleDao saleDao = new SaleDaoImp();

	public void putProduct(Product prod) {
		productDao.add(prod);
	}

	public double outputProductc(Name name, double pay) {

		Product choseProduct = new Product();
		choseProduct = productDao.getById(name);

		try {
			if (choseProduct.getPrice() > pay) {

				throw new IllegalArgumentException(
						"Not enough money! Need " + choseProduct.getPrice() + ". You put " + pay + "! Try again. ");

			} else if (choseProduct.getPrice() == pay) {

				Sale inStock = new Sale();
				inStock = saleDao.getByName(choseProduct.getIdProduct());

				if (inStock == null) {
					Sale writeDown = new Sale();
					writeDown.setName(name);
					writeDown.setAmount(1);
					saleDao.add(writeDown);
				} else {
					inStock = saleDao.getByName(choseProduct.getIdProduct());
					inStock.setAmount(inStock.getAmount() + 1);
					saleDao.update(inStock);
				}

				System.out.println("Your order!");
				System.out.println(choseProduct);
				productDao.remove(name);

				return 0;

			} else {

				Sale inStock = new Sale();
				inStock = saleDao.getByName(choseProduct.getIdProduct());

				if (inStock == null) {
					Sale writeDown = new Sale();
					writeDown.setName(name);
					writeDown.setAmount(1);
					saleDao.add(writeDown);
				} else {
					inStock = saleDao.getByName(choseProduct.getIdProduct());
					inStock.setAmount(inStock.getAmount() + 1);
					saleDao.update(inStock);
				}

				double rest = pay - choseProduct.getPrice();

				System.out.println("Your order!");
				System.out.println(choseProduct);
				System.out.println("Your rest - " + rest + "!");
				productDao.remove(name);

				return rest;
			}
		} catch (IllegalArgumentException e) {

			System.out.println(e.getMessage());

			return pay;
		}
	}

	public void changPrice(Product prod) {
		productDao.update(prod);
	}

	public List<Product> informationOnAvailableProduct() {
		return productDao.getDifferent();

	}

	public Product getByNameId(Name name) {
		return productDao.getById(name);

	}
}
