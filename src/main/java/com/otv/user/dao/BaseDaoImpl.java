package com.otv.user.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.otv.domain.BaseEntity;


@SuppressWarnings("unchecked")
public class BaseDaoImpl<T extends BaseEntity<I>, I extends Serializable>
		implements BaseDao<T, I> {

	@Autowired
	private SessionFactory sessionFactory;
	private Class<T> persistentClass;

	protected Session session() {
		return sessionFactory.getCurrentSession();
	}

	public BaseDaoImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	protected Class<T> persistentClass() {
		return persistentClass;
	}

	public T saveOrUpdate(T entity) {
		session().saveOrUpdate(entity);
		return entity;
	}

	public void delete(T entity) {
		session().delete(entity);
	}

	public T findById(I id) {
		return (T) session().get(persistentClass(), id);
	}

	public Collection<T> saveOrUpdateAll(Collection<T> entities) {
		if (entities != null)
			for (T entity : entities) {
				session().saveOrUpdate(entity);
			}
		return entities;
	}

	public void deleteAll(Collection<T> entities) {
		if (entities != null)
			for (T entity : entities) {
				session().delete(entity);
			}
	}

}
