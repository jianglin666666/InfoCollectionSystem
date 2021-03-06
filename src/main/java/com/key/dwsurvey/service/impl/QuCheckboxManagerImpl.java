package com.key.dwsurvey.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.key.common.service.BaseServiceImpl;
import com.key.dwsurvey.dao.QuCheckboxDao;
import com.key.dwsurvey.entity.QuCheckbox;
import com.key.dwsurvey.mapper.QuCheckboxMapper;
import com.key.dwsurvey.service.QuCheckboxManager;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 多选题
 * @author keyuan(keyuan258@gmail.com)
 *
 * https://github.com/wkeyuan/DWSurvey
 * http://dwsurvey.net
 */
@Service("quCheckboxManager")
public class QuCheckboxManagerImpl extends BaseServiceImpl<QuCheckbox, String> implements QuCheckboxManager {

	@Autowired
	private QuCheckboxDao quCheckboxDao;
	@Autowired
	private QuCheckboxMapper quCheckboxMapper;
	
	@Override
	public void setBaseDao() {
		this.baseDao=quCheckboxDao;
	}
	
	public List<QuCheckbox> findByQuId(String quId){
//		Page<QuCheckbox> page=new Page<QuCheckbox>();
//		page.setOrderBy("orderById");
//		page.setOrderDir("asc");
//
//		List<PropertyFilter> filters=new ArrayList<PropertyFilter>();
//		filters.add(new PropertyFilter("EQS_quId", quId));
//		filters.add(new PropertyFilter("EQI_visibility", "1"));

		return quCheckboxMapper.selectvisibilityAndQuId( Integer.valueOf(1),quId);
	}
	
	
	public int getOrderById(String quId){
		//begin delete  by jesse at 2020-07-16  for 优化
		//		Criterion criterion=Restrictions.eq("quId", quId);
		//		QuCheckbox quCheckbox=quCheckboxDao.findFirst("orderById", false, criterion);
		//end delete by jesse at 2020-07-16
		QuCheckbox quCheckbox = quCheckboxMapper.findFirstByOrderByIdDesc(quId);
		if(quCheckbox!=null){
			return quCheckbox.getOrderById();
		}
		return 0;
	}
	
	/*******************************************************************8
	 * 更新操作
	 */
	
	@Override
	@Transactional
	public QuCheckbox upOptionName(String quId, String quItemId, String optionName) {
		if(quItemId!=null && !"".equals(quItemId)){
			QuCheckbox quCheckbox = quCheckboxMapper.selectByPrimaryKey(quItemId);
			//begin delete  by jesse at 2020-07-16  for 优化
			//			QuCheckbox quCheckbox=quCheckboxDao.get(quItemId);
			//end delete by jesse at 2020-07-16

			quCheckbox.setOptionName(optionName);
			quCheckboxMapper.updateByPrimaryKeySelective(quCheckbox);
			//begin delete  by jesse at 2020-07-16  for 优化
			//			quCheckboxDao.save(quCheckbox);
			//end delete by jesse at 2020-07-16

			return quCheckbox;
		}else{
			//取orderById
			int orderById=getOrderById(quId);
			//新加选项
			QuCheckbox quCheckbox=new QuCheckbox();
			quCheckbox.setQuId(quId);
			quCheckbox.setOptionName(optionName);
			//title
			quCheckbox.setOrderById(++orderById);
			quCheckbox.setOptionTitle(orderById+"");
			quCheckboxMapper.insertSelective(quCheckbox);
			//begin delete  by jesse at 2020-07-16  for 优化
			//			quCheckboxDao.save(quCheckbox);
			//end delete by jesse at 2020-07-16

			return quCheckbox;
		}
	}
	
	@Override
	@Transactional
	public List<QuCheckbox> saveManyOptions(String quId, List<QuCheckbox> quCheckboxs) {
		//取orderById
		int orderById=getOrderById(quId);
		for (QuCheckbox quCheckbox : quCheckboxs) {
			//新加选项
			quCheckbox.setOrderById(++orderById);
			quCheckbox.setOptionTitle(orderById+"");
			quCheckboxMapper.updateByPrimaryKeySelective(quCheckbox);
			//begin delete  by jesse at 2020-07-16  for  优化
			//			quCheckboxDao.save(quCheckbox);
			//end delete by jesse at 2020-07-16
		}
		return quCheckboxs;
	}
	
	@Override
	@Transactional
	public void ajaxDelete(String quItemId) {
		QuCheckbox quCheckbox = quCheckboxMapper.selectByPrimaryKey(quItemId);
		//begin delete  by jesse at 2020-07-15  for  优化
		//QuCheckbox quCheckbox=get(quItemId);
		//end delete by jesse at 2020-07-15

		quCheckbox.setVisibility(0);
		quCheckboxMapper.updateByPrimaryKeySelective(quCheckbox);
		//begin delete  by jesse at 2020-07-15  for 优化
		//quCheckboxDao.save(quCheckbox);
		//end delete by jesse at 2020-07-15

	}
	
	@Override
	@Transactional
	public void saveAttr(String quItemId, String isNote) {
		//begin delete  by jesse at 2020-07-16  for 优化
		//QuCheckbox quCheckbox=get(quItemId);
		//end delete by jesse at 2020-07-16

		QuCheckbox quCheckbox = quCheckboxMapper.selectByPrimaryKey(quItemId);
		if(isNote!=null && "1".equals(isNote)){
			quCheckbox.setIsNote(1);
		}else{
			quCheckbox.setIsNote(0);
		}
		quCheckboxMapper.updateByPrimaryKeySelective(quCheckbox);
		//begin delete  by jesse at 2020-07-16  for 优化
		//quCheckboxDao.save(quCheckbox);
		//end delete by jesse at 2020-07-16

	}

}
