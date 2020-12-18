package org.hcl.dao;

import java.util.List;

import org.hcl.model.Product;

public interface ProductDao {
	List<Product> getAll();
	boolean add(Product product);

}
