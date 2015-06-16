package com.alex.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public class GenericDaoJpaImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

	protected Class<T> entityClass;

	/*@PersistenceContext
	protected EntityManager entityManager; */

	public GenericDaoJpaImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass	.getActualTypeArguments()[0];
		}
	
	@Override
	public T create(T t) {
		//this.entityManager.persist(t);
		//return t;
		return null;
	}

	@Override
	public T read(PK id) {
		//return this.entityManager.find(entityClass, id);
		return null;
	}

	@Override
	public T update(T t) {
		//return this.entityManager.merge(t);
		return null;
	}

	@Override
	public void delete(T t) {
		//t = this.entityManager.merge(t);
		//this.entityManager.remove(t);		
		}
}