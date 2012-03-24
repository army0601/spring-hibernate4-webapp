package com.demo.dao.service;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.demo.dao.Dao;
import com.demo.dao.pojo.ShwTest;

public class ShwTestDao extends Dao implements IShwTestDao {

	@Override
	public ShwTest findById(Long id) {
		// TODO Auto-generated method stub
		return (ShwTest)getObject(ShwTest.class, id);
	}

	@Override
	public List findAll() {
		// TODO Auto-generated method stub
		return getObjects(ShwTest.class);
	}

	@Override
	public List findByProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub
		return getObjectsByProperty(ShwTest.class, propertyName, value);
	}

	@Override
	public List findByProperty(String propertyName, Object value, int start,
			int limit) {
		// TODO Auto-generated method stub
		return getObjectsByProperty(ShwTest.class, propertyName, value, start, limit);
	}

	@Override
	public void save(ShwTest shwTest) {
		// TODO Auto-generated method stub
		SaveObject(shwTest);
	}

	@Override
	public void delete(ShwTest shwTest) {
		// TODO Auto-generated method stub
		deleteObject(shwTest);
	}
	
	public static ShwTestDao getFromApplicationContext(
			ApplicationContext ctx){
		return (ShwTestDao) ctx.getBean("ShwTestDao");
	}

	@Override
	public List findBySql(String queryString) {
		// TODO Auto-generated method stub
		return getObjectsBySql(ShwTest.class, queryString);
	}

}
