package bbi.carpooling.service.impl.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import bbi.carpooling.model.BaseBean;




public abstract class GenericJpaDao<T extends BaseBean> implements IGenericDao<T> {
	@PersistenceContext
	private EntityManager entityManager;

	private Class<T> entityBeanType;

	public GenericJpaDao(Class<T> entityBeanType) {
		super();
		this.entityBeanType = entityBeanType;
	}

	@Override
	public void remove(T entity) {
		//entity.setDeleted(true);
		//entityManager.merge(entity);
		entityManager.remove(entityManager.merge(entity));
	}

	@Override
	public T save(T entity) {
		return entityManager.merge(entity);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> select() {
		return entityManager.createQuery(
				"select e from " + entityBeanType.getName() )
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> select(String query) {
		List<T> resultList = entityManager.createQuery(
				"select e from " + entityBeanType.getName() + " e where " +query)
				.getResultList();
		return resultList;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<T> executeQuery(String query) {
		List<T> resultList = entityManager.createQuery(query).getResultList();
		return resultList;
	}
	
//	@Override
//	public int delete(String query) {
//		int resultList = entityManager.createQuery(
//				"delete from " + entityBeanType.getName() + " e where " +query)
//				.executeUpdate();
//		return resultList;
//	}
	
	@Override
	public T selectById(Long id) {
		return entityManager.find(entityBeanType, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> search(Object... params) {
		
		final Query query = entityManager.createNativeQuery("search", entityBeanType);
		int i=1;
		for(Object param : params){
			query.setParameter(i, param);
			i++;
		}
		return query.getResultList();
	}

//	@Override
//	public void rollBack() {
//		entityManager.getTransaction().rollback();
//	}

		
}
