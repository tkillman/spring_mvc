package spring.service;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import spring.model.fileInfo;
import spring.model.fileInfo2;

public class fileDao extends SqlSessionDaoSupport{

	
	public int insertFileInfo(fileInfo fileInfo){
		
		
		int resultNum =getSqlSession().insert("mapperName.insert", fileInfo);
		
		return resultNum;
	}
	
	public int insertFileInfo2(fileInfo2 fileInfo2){
		
		
		int resultNum =getSqlSession().insert("mapperName.insertDB", fileInfo2);
		
		return resultNum;
	}
	
	
	
	
}
