package com.bjsxt.shopping;

import java.util.Date;
import java.util.List;

import com.bjsxt.shopping.dao.ProductDao;
import com.bjsxt.shopping.dao.ProductMYSQLDao;

public class ProductMgr {

	private static ProductMgr pm = null;

	private ProductMgr() {
	}

	static {
		if (pm == null) {
			pm = new ProductMgr();
			// should read the config file and set the specific object
			pm.setDao(new ProductMYSQLDao());
		}
	}

	ProductDao dao = null;

	public static ProductMgr getInstance() {
		return pm;
	}

	public ProductDao getDao() {
		return dao;
	}

	public void setDao(ProductDao dao) {
		this.dao = dao;
	}

	public List<Product> getProducts() {
		return dao.getProducts();
	}

	public List<Product> getProducts(int pageNo, int pageSize) {
		return dao.getprProducts(pageNo, pageSize);
	}

	public int getProducts(List<Product> products, int pageNo, int pageSize) {
		return dao.getProducts(products, pageNo, pageSize);
	}

	public int findProducts(List<Product> list, int[] categoryId, String keyWord,
			double lowNormalPrice, double higeNormalPrice,
			double lowMemberPrice, double highMemberPrice, Date startDate,
			Date endDate, int pageNo, int pageSize) {
		
		return dao.findProducts(list, categoryId, keyWord, lowNormalPrice,
				higeNormalPrice, lowMemberPrice, highMemberPrice, startDate,
				endDate, pageNo, pageSize);
	}

	public List<Product> findProducts(String name) {
		return null;
	}

	public boolean deleteProductByCategoryId(int categoryId) {
		return false;
	}

	public boolean deleteProductByCategoryId(int[] idArray) {
		return false;
	} 

	public boolean updateProduct(Product p) {
		return false;
	}

	public boolean addProduct(Product p) {
		return dao.addProduct(p);
	}
	
	public int[] getCategoryIdArray() {
		return dao.getCategoryIdArray();
	}
	
	public Product loadById(int id) {
		return dao.loadById(id);
	}
	
	public boolean update(Product p) {
		return dao.updateProduct(p);
	}
	
	public List<Product> getLatestProducts(int count) {
		return dao.getLatestProducts(count);
	}
}
