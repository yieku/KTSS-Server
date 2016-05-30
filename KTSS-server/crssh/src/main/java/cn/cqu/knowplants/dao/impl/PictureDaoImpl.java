package cn.cqu.knowplants.dao.impl;

import java.util.ArrayList;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import cn.cqu.knowplants.dao.PictureDao;
import cn.cqu.knowplants.domain.PictureBean;
@Repository
public class PictureDaoImpl extends BaseDaoImpl<PictureBean>implements PictureDao {

	 @SuppressWarnings("unchecked")
	public ArrayList<PictureBean> getByFarmID(String farmID)
	 {
		 DetachedCriteria criteria = DetachedCriteria.forClass(PictureBean.class);
		 criteria.add(Restrictions.eq("farmID", farmID));
		 return (ArrayList<PictureBean>) this.getHibernateTemplate().findByCriteria(criteria);
	 }
	 
	 @SuppressWarnings("unchecked")
	public ArrayList<PictureBean> getPictureByPictureURL(String url)
	 {

		 DetachedCriteria criteria = DetachedCriteria.forClass(PictureBean.class);
		 criteria.add(Restrictions.eq("pictureURL", url));
		 return (ArrayList<PictureBean>) this.getHibernateTemplate().findByCriteria(criteria);
		 
		 
	 }
	 
	@SuppressWarnings("unchecked")
	public ArrayList<PictureBean> getPictureByPictureID(int pictureID)
	 {
		 DetachedCriteria criteria = DetachedCriteria.forClass(PictureBean.class);
		 criteria.add(Restrictions.eq("pictureID",pictureID));
		 return (ArrayList<PictureBean>) this.getHibernateTemplate().findByCriteria(criteria);
		 
	 }

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList getAllUnrecognizedPictureByFarmID(String farmID) {
		 DetachedCriteria criteria = DetachedCriteria.forClass(PictureBean.class);
		 criteria.add(Restrictions.eq("farmID", farmID));
		 criteria.add(Restrictions.isNull("plantName"));
		 return (ArrayList<PictureBean>) this.getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList getAllUnrecognizedPicture() {
		 DetachedCriteria criteria = DetachedCriteria.forClass(PictureBean.class);
		 criteria.add(Restrictions.isNull("plantName"));
		 return (ArrayList<PictureBean>) this.getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList getAllrecognizedPicture() {
		DetachedCriteria criteria = DetachedCriteria.forClass(PictureBean.class);
		 criteria.add(Restrictions.isNotNull("plantName"));
		 return (ArrayList<PictureBean>) this.getHibernateTemplate().findByCriteria(criteria);
	}
	
	 

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList getAllAutoRecognizedPictureByFarmID(String farmID) {
		DetachedCriteria criteria = DetachedCriteria.forClass(PictureBean.class);
		 criteria.add(Restrictions.isNotNull("plantName"));
		 criteria.add(Restrictions.eq("farmID", farmID));
		 criteria.add(Restrictions.eq("recognizedBy", "machine"));
		 return (ArrayList<PictureBean>) this.getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList getAllExpertRecognizedPictureByFarmID(String farmID) {
		DetachedCriteria criteria = DetachedCriteria.forClass(PictureBean.class);
		 criteria.add(Restrictions.isNotNull("plantName"));
		 criteria.add(Restrictions.eq("farmID", farmID));
		 criteria.add(Restrictions.eq("recognizedBy", "专家"));
		 return (ArrayList<PictureBean>) this.getHibernateTemplate().findByCriteria(criteria);
	}

	@Override
	public void deleteByID(int id) {
		PictureBean pic = this.get(id);
		if(pic!=null)
			this.getHibernateTemplate().delete(pic);
	}
}
