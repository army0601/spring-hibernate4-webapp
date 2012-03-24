package com.demo.dao.service;

import java.util.List;

import com.demo.dao.IDao;
import com.demo.dao.pojo.ShwTest;

public interface IShwTestDao extends IDao {
	public ShwTest findById(java.lang.Long id);

	public List findAll();
	
	public List findByProperty(String propertyName, Object value);
	
	public List findByProperty(String propertyName, Object value, int start, int limit);
	
	public List findBySql(String queryString);

	public void save(ShwTest shwTest);

	public void delete(ShwTest shwTest);
}
