package org.hcl.services;

import java.util.List;

import org.hcl.dao.ProductDao;
import org.hcl.dao.ProductDaoImpl;
import org.hcl.model.Product;

public class ProductServiceImpl implements ProductService {
	ProductDao dao=new ProductDaoImpl();
	@Override
	public List<Product> getProducts() {
		return dao.getAll();
	}
	@Override
	public boolean addProduct(Product product) {
		return dao.add(product);
	}

}
