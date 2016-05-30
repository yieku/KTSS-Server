package cn.cqu.knowplants.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate4.HibernateTemplate;

public interface BaseDao<T> {

	/**
	 * 根据ID加载PO实例
	 * 
	 * @param id
	 * @return 返回相应的持久化PO实例
	 */
	T load(Serializable id);

	/**
	 * 根据ID获取PO实例
	 * 
	 * @param id
	 * @return 返回相应的持久化PO实例
	 */
	T get(Serializable id);

	/**
	 * 获取PO的所有对象
	 * 
	 * @return
	 */
	List<T> loadAll();

	/**
	 * 保存PO
	 * 
	 * @param entity
	 */

	void save(T entity);

	/**
	 * 删除PO
	 * 
	 * @param entity
	 */
	void remove(T entity);

	/**
	 * 更改PO
	 * 
	 * @param entity
	 */
	void update(T entity);

	/**
	 * 执行HQL查询
	 * 
	 * @param sql
	 * @return 查询结果
	 */
	List find(String hql);

	/**
	 * 执行带参的HQL查询
	 * 
	 * @param sql
	 * @param params
	 * @return 查询结果
	 */
	List find(String hql, Object... params);
	
	/**
	 * 执行带参的HQL查询,只返回一个结果
	 * 
	 * @param sql
	 * @param params
	 * @return 查询结果
	 */
	T findOne(String hql, Object... params);
	
	/**
	 * 对延迟加载的实体PO执行初始化
	 * @param entity
	 */
	void initialize(Object entity);

	/**
	 * 分页查询函数，使用hql.
	 *
	 * @param pageNo 页号,从1开始.
	 */
	 
	Query createQuery(String hql, Object... values);

	HibernateTemplate getHibernateTemplate();

	void setHibernateTemplate(HibernateTemplate hibernateTemplate);

	List<T> getAll();

	

}