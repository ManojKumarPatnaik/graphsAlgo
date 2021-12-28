package com.epam.HomeTask.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class ProductImplementation implements ProductInterface {
	@Override
	public List<Product> getProductByPrice(List<Product> product) {
		return product.stream().filter(p -> p.getPrice() > 1000).collect(Collectors.toList());
	}

	@Override
	public List<Product> getProductByCategory(List<Product> product, String category) {

		return product.stream().filter(p -> p.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());
	}

	@Override
	public List<String> getProductByPriceAndCategory(List<Product> product, String category) {

		return product.stream().filter(p -> p.getPrice() > 1000 || p.getCategory().equalsIgnoreCase(category))
				.map((str -> str.getName().toUpperCase())).collect(Collectors.toList());
	}

	@Override
	public long getCountOfAllElectronicProducts(List<Product> product, String category) {

		return product.stream().filter(p -> p.getCategory().equalsIgnoreCase(category)).count();
	}

}

public class Response {

	public static void main(String args[]) {
		List<Product> list = new ArrayList<>();
		list.add(new Product("RealMe", 10000, "B", "Electronics"));
		list.add(new Product("SonyTv", 30000, "A", "Electronics"));
		list.add(new Product("Haier", 20000, "C", "Electronics"));
		list.add(new Product("KTM", 200000, "A", "Mechanical"));
		ProductImplementation products = new ProductImplementation();
		System.out.println(products.getProductByPrice(list));
		System.out.println(products.getProductByCategory(list, "Electronics"));
		System.out.println(products.getProductByPriceAndCategory(list, "Electronics"));
		System.out.println(products.getCountOfAllElectronicProducts(list, "Electronics"));
	}
}
