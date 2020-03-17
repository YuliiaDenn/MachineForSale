package main;

import dao.ProductDao;
import dao.ProductDaoImp;
import dao.SaleDao;
import dao.SaleDaoImp;
import entity.Product;
import entity.Product.Name;
import entity.Sale;
import service.MachineForSale;

public class Main {

	public static void main(String[] args) {
		ProductDao prod = new ProductDaoImp();
		SaleDao sales = new SaleDaoImp();
		Sale sale = new Sale();
		Product p = new Product();
		MachineForSale choose = new MachineForSale();
		
//		p.setIdProduct(Name.Coffee);
//		p.setPrice(30.0);
//		choose.putProduct(p);
//
//		p = choose.getByNameId(Name.Coffee);
//		p.setPrice(32.0);
//		choose.changPrice(p);


		System.out.println(choose.informationOnAvailableProduct());
//		System.out.println(prod.getAll());
//		System.out.println(sales.getAll());		

	}

}
