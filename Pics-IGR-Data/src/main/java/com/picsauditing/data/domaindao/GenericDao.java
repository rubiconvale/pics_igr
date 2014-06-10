package com.picsauditing.data.domaindao;

import com.picsauditing.exception.DAOLayerException;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GenericDao<E,K> {

	public <E> E create(E entity) throws DAOLayerException;

	public <E> void persist(E entity) throws DAOLayerException;
	
	public <E> void update(E entity) throws DAOLayerException;
	
	public <E> void delete(E entity) throws DAOLayerException;
	
	public <E> E findById(E clazz, Serializable id) throws DAOLayerException;
	
	public <E> Collection<E> findAllObjects(Class<E> clazz) throws DAOLayerException;
	
	Object getObjectByCriteria(Class type, HashMap<Object, String> nameValue) throws DAOLayerException;
		
	public List<Map<String, Object>> findObjectsByQuery(String query, Map<?, ?> params);
}



