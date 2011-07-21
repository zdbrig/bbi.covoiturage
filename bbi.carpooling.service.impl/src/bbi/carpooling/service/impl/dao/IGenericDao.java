package bbi.carpooling.service.impl.dao;

import java.util.List;

import bbi.carpooling.model.BaseBean;


public interface IGenericDao<T extends BaseBean> {
	List<T> select() ;
	T selectById(Long id) ;
	T save(T entity) ;
	void remove(T entity) ;
	List<T> search(Object ... params) ;
	List<T> select(String query) ;
	//void rollBack();
	//int delete(String query);
	List<T> executeQuery(String query) ;
}

