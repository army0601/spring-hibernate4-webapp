package com.demo.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface IDao {

	public List getObjects(Class clazz);

	public List getObjectsByProperty(Class clazz, String propertyName,
			Object value);

	public List getObjectsByProperty(Class clazz, String propertyName,
			Object value, int start, int limit);

	public Object getObject(Class clazz, Serializable id);

	public void SaveObject(Object o);

	public void deleteObject(Object o);

	public List getObjectsBySql(Class clazz, String queryString);
	
	public List getMapObjectsBySql(String queryString);

}
