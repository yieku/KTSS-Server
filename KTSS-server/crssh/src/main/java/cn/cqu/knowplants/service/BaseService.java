package cn.cqu.knowplants.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cn.cqu.knowplants.dao.AdminDao;
import cn.cqu.knowplants.dao.AuditExpertDao;
import cn.cqu.knowplants.dao.ExpertDao;
import cn.cqu.knowplants.dao.FarmDao;
import cn.cqu.knowplants.dao.PictureDao;
import cn.cqu.knowplants.dao.UpdateInfoDao;

public abstract class BaseService {
	static Logger logger = LoggerFactory.getLogger(BaseService.class);

	 @Autowired
	 AdminDao adminDao;
	 @Autowired
	 AuditExpertDao audtExpDao;
	 @Autowired
	 ExpertDao expDao;
	 @Autowired
	 FarmDao farmDao;
	 @Autowired
	 PictureDao picDao;
	 @Autowired
	 UpdateInfoDao updateDao;
	 
	 
	 
	 
	
}
