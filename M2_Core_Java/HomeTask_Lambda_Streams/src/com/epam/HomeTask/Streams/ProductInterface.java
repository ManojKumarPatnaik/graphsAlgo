package com.epam.HomeTask.Streams;

import java.util.List;

public interface ProductInterface {
	List<Product> getProductByPrice(List<Product> product);

	List<Product> getProductByCategory(List<Product> product, String category);

	List<String> getProductByPriceAndCategory(List<Product> product, String category);

	long getCountOfAllElectronicProducts(List<Product> product, String category);
}