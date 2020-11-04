package com.key.dwsurvey.service.impl;

import com.key.common.plugs.page.Page;
import com.key.common.plugs.page.PropertyFilter;
import com.key.common.service.BaseServiceImpl;
import com.key.dwsurvey.dao.QuChenColumnDao;
import com.key.dwsurvey.entity.QuChenColumn;
import com.key.dwsurvey.mapper.QuChenColumnMapper;
import com.key.dwsurvey.service.QuChenColumnManager;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 矩陈题列
 * @author keyuan(keyuan258@gmail.com)
 *
 * https://github.com/wkeyuan/DWSurvey
 * http://dwsurvey.net
 */
@Service
public class QuChenColumnManagerImpl extends BaseServiceImpl<QuChenColumn, String> implements QuChenColumnManager {

	@Autowired
	private QuChenColumnDao chenColumnDao;
	@Autowired
	private QuChenColumnMapper chenColumnMapper;
	
	@Override
	public void setBaseDao() {
		this.baseDao=chenColumnDao;
	}

	@Override
	public List<QuChenColumn> findByQuId(String quId) {
//		Page<QuChenColumn> page=new Page<QuChenColumn>();
//		page.setOrderBy("orderById");
//		page.setOrderDir("asc");
//
//		List<PropertyFilter> filters=new ArrayList<PropertyFilter>();
//		filters.add(new PropertyFilter("EQS_quId", quId));
//		filters.add(new PropertyFilter("EQI_visibility", "1"));
//		return findAll(page, filters);
		return chenColumnMapper.selectByQuIdAndvisibility(quId,Integer.valueOf(1));

	}

	@Override
	public String getContentByQuId(String quId) {
		String content="";
		if(quId!=null && !"".equals(quId)){
			List<QuChenColumn> columns=findByQuId(quId);
			for (QuChenColumn quChenColumn : columns) {
				content+=quChenColumn.getOptionName()+"\r\n";
			}
		}
		return content;
	}

	public int getOrderById(String quId){
		QuChenColumn quChenColumn = chenColumnMapper.findFirstByOrderByIdDesc(quId);
		//begin delete  by jesse at 2020-07-16  for 优化
		//		Criterion criterion=Restrictions.eq("quId", quId);
		//		QuChenColumn quChenColumn=chenColumnDao.findFirst("orderById", false, criterion);
		//end delete by jesse at 2020-07-16

		if(quChenColumn!=null){
			return quChenColumn.getOrderById();
		}
		return 0;
	}
	
	@Override
	@Transactional
	public QuChenColumn upOptionName(String quId,String quItemId, String optionName) {
		if(quItemId!=null && !"".equals(quItemId)){
			QuChenColumn quChenColumn = chenColumnMapper.selectByPrimaryKey(quItemId);
			//begin delete  by jesse at 2020-07-16  for  优化
			//			QuChenColumn quChenColumn=chenColumnDao.get(quItemId);
			//end delete by jesse at 2020-07-16

			quChenColumn.setOptionName(optionName);
			chenColumnMapper.updateByPrimaryKeySelective(quChenColumn);
			//begin delete  by jesse at 2020-07-16  for  优化
			//			chenColumnDao.save(quChenColumn);
			//end delete by jesse at 2020-07-16

			return quChenColumn;
		}else{
			//取orderById
			int orderById=getOrderById(quId);
			//新加选项
			QuChenColumn quChenColumn=new QuChenColumn();
			quChenColumn.setQuId(quId);
			quChenColumn.setOptionName(optionName);
			//title
			quChenColumn.setOrderById(++orderById);
			chenColumnMapper.insertSelective(quChenColumn);
			//begin delete  by jesse at 2020-07-16  for 优化
			//chenColumnDao.save(quChenColumn);
			//end delete by jesse at 2020-07-16

			return quChenColumn;
		}
	}
	

	@Override
	@Transactional
	public void ajaxDelete(String quItemId) {
		QuChenColumn quChenColumn = chenColumnMapper.selectByPrimaryKey(quItemId);
		//begin delete  by jesse at 2020-07-16  for 优化
		//QuChenColumn quChenColumn=get(quItemId);
		//end delete by jesse at 2020-07-16

		quChenColumn.setVisibility(0);
		chenColumnMapper.updateByPrimaryKeySelective(quChenColumn);
		//begin delete  by jesse at 2020-07-16  for 优化
		//		chenColumnDao.save(quChenColumn);
		//end delete by jesse at 2020-07-16

	}
	
}
