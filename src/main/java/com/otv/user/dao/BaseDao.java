package com.otv.user.dao;

import java.io.Serializable;
import java.util.Collection;
import com.otv.domain.BaseEntity;

public interface BaseDao<T extends BaseEntity<I>, I extends Serializable> {

	public T saveOrUpdate(T entity);
	public void delete(T entity);
	public T findById(I id);
	public Collection<T> saveOrUpdateAll(Collection<T> entity);
	public void deleteAll(Collection<T> entity);
	
}
