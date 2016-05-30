package cn.cqu.knowplants.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsChinese {
	
       public boolean isChineseChar(String str){
    	System.out.println("中文");
        Pattern p=Pattern.compile("[\u4e00-\u9fa5]"); 
        Matcher m=p.matcher(str); 
        if(m.find()){ 
            return  true;
        }
        return false;
}

}
