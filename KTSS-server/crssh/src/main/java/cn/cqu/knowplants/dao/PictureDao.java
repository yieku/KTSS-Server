package cn.cqu.knowplants.dao;

import java.util.ArrayList;

import cn.cqu.knowplants.domain.PictureBean;

public interface PictureDao extends BaseDao<PictureBean> {
	public ArrayList<PictureBean> getByFarmID(String farmID);
	public ArrayList<PictureBean> getPictureByPictureURL(String url);
	public ArrayList<PictureBean> getPictureByPictureID(int pictureID);
	 //按照FarmID取出所有未识别的图片
    public ArrayList getAllUnrecognizedPictureByFarmID(String farmID);
    public ArrayList getAllUnrecognizedPicture();
    public ArrayList getAllrecognizedPicture();
    public ArrayList getAllAutoRecognizedPictureByFarmID(String farmID);
    public ArrayList getAllExpertRecognizedPictureByFarmID(String farmID);
    public void deleteByID(int id);
}
