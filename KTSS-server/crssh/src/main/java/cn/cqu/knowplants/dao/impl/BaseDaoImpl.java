package cn.cqu.knowplants.dao.impl;



import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.FlushMode;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.util.Assert;

import cn.cqu.knowplants.dao.BaseDao;
import cn.cqu.knowplants.domain.PictureBean;

/**
 * DAO基类，其它DAO可以直接继承这个DAO，不但可以复用共用的方法，还可以获得泛型的好处。
 */
public class BaseDaoImpl<T> implements BaseDao<T>{
	static Logger logger = LoggerFactory.getLogger(BaseDaoImpl.class);
	
	private Class<T> entityClass;
	protected HibernateTemplate hibernateTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
		
	}
	
	/**
	 * 通过反射获取子类确定的泛型类
	 */
	public BaseDaoImpl() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class) params[0];
	}

	/* (non-Javadoc)
	 * @see cqu.crs.dao.hibernate.BaseDao#load(java.io.Serializable)
	 */
	@Override
	public T load(Serializable id) {
		return (T) getHibernateTemplate().load(entityClass, id);
	}

	/* (non-Javadoc)
	 * @see cqu.crs.dao.hibernate.BaseDao#get(java.io.Serializable)
	 */
	@Override
	public T get(Serializable id) {
		return (T) getHibernateTemplate().get(entityClass, id);
	}

	/* (non-Javadoc)
	 * @see cqu.crs.dao.hibernate.BaseDao#loadAll()
	 */
	@Override
	public List<T> loadAll() {
		return getHibernateTemplate().loadAll(entityClass);
	}
	
	@Override
	public List<T> getAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
		 return  (List<T>) this.getHibernateTemplate().findByCriteria(criteria);
	}
	
	/* (non-Javadoc)
	 * @see cqu.crs.dao.hibernate.BaseDao#save(T)
	 */
	
	
	@Override
	public void save(T entity) {
		
		getHibernateTemplate().save(entity);
		System.out.println("者这");
		
		
	}

	/* (non-Javadoc)
	 * @see cqu.crs.dao.hibernate.BaseDao#remove(T)
	 */
	@Override
	public void remove(T entity) {
		getHibernateTemplate().delete(entity);
	}

	/* (non-Javadoc)
	 * @see cqu.crs.dao.hibernate.BaseDao#update(T)
	 */
	@Override
	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	/* (non-Javadoc)
	 * @see cqu.crs.dao.hibernate.BaseDao#find(java.lang.String)
	 */
	@Override
	public List find(String hql) {
		return this.getHibernateTemplate().find(hql);
	}

	/* (non-Javadoc)
	 * @see cqu.crs.dao.hibernate.BaseDao#find(java.lang.String, java.lang.Object)
	 */
	@Override
	public List find(String hql, Object... params) {
		return this.getHibernateTemplate().find(hql,params);
	}
    
	/* (non-Javadoc)
	 * @see cqu.crs.dao.hibernate.BaseDao#initialize(java.lang.Object)
	 */
	@Override
	public void initialize(Object entity) {
		this.getHibernateTemplate().initialize(entity);
	}
	
	
	/* (non-Javadoc)
	 * @see cqu.crs.dao.hibernate.BaseDao#pagedQuery(java.lang.String, int, int, java.lang.Object)
	 */
	 
	/* (non-Javadoc)
	 * @see cqu.crs.dao.hibernate.BaseDao#createQuery(java.lang.String, java.lang.Object)
	 */
	@Override
	public Query createQuery(String hql, Object... values) {
		Assert.hasText(hql);
		Query query = this.getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql);
		for (int i = 0; i < values.length; i++) {
			query.setParameter(i, values[i]);
		}
		return query;
	}
	/**
	 * 去除hql的select 子句，未考虑union的情况,用于pagedQuery.
	 *
	 * @see #pagedQuery(String,int,int,Object[])
	 */
	private static String removeSelect(String hql) {
		Assert.hasText(hql);
		int beginPos = hql.toLowerCase().indexOf("from");
		Assert.isTrue(beginPos != -1, " hql : " + hql + " must has a keyword 'from'");
		return hql.substring(beginPos);
	}
	
	/**
	 * 去除hql的orderby 子句，用于pagedQuery.
	 *
	 * @see #pagedQuery(String,int,int,Object[])
	 */
	private static String removeOrders(String hql) {
		Assert.hasText(hql);
		Pattern p = Pattern.compile("order\\s*by[\\w|\\W|\\s|\\S]*", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(hql);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "");
		}
		m.appendTail(sb);
		return sb.toString();
	}

	/* (non-Javadoc)
	 * @see cqu.crs.dao.hibernate.BaseDao#getHibernateTemplate()
	 */
	@Override
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	/* (non-Javadoc)
	 * @see cqu.crs.dao.hibernate.BaseDao#setHibernateTemplate(org.springframework.orm.hibernate3.HibernateTemplate)
	 */
	@Override
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
  

	@Override
	public T findOne(String hql, Object... params) {
		List l=this.getHibernateTemplate().find(hql,params);
		
		if(l!=null&&l.size()>0)
		{
			return (T) l.get(0);
		}
		return null;
	}

	
	
}