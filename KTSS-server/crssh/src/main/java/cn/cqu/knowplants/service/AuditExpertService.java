package cn.cqu.knowplants.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.cqu.knowplants.domain.AuditExpertBean;

@Service
@Transactional
public class AuditExpertService extends BaseService {
	   public boolean addAuditExpert(String auditExpertID,String auditExpertPassword,String auditExpertPhone,String auditExpertMaterial)
	  {
		 AuditExpertBean expertBean =audtExpDao.get(auditExpertID);
		  {
			  if(expertBean!=null)
			  {
				  return false;
			  }
			  
			  else {
				  expertBean = new AuditExpertBean();
				   expertBean.setAuditExpertID(auditExpertID);
				   expertBean.setAuditExpertMaterial(auditExpertMaterial);
				   expertBean.setAuditExpertPassword(auditExpertPassword);
				   expertBean.setAuditExpertPhone(auditExpertPhone);
				  audtExpDao.save(expertBean);
				  return true;
			}
		  }
	  }
}
