package com.key.dwsurvey.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.key.common.service.BaseServiceImpl;
import com.key.dwsurvey.DTO.AnChenScoreDTO;
import com.key.dwsurvey.dao.AnChenScoreDao;
import com.key.dwsurvey.entity.AnChenScore;
import com.key.dwsurvey.entity.Question;
import com.key.dwsurvey.mapper.AnChenScoreMapper;
import com.key.dwsurvey.service.AnChenScoreManager;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 矩陈评分题
 * @author keyuan(keyuan258@gmail.com)
 *
 * https://github.com/wkeyuan/DWSurvey
 * http://dwsurvey.net
 */
@Service
public class AnChenScoreManagerImpl extends BaseServiceImpl<AnChenScore, String> implements AnChenScoreManager {

	@Autowired
	private AnChenScoreDao anChenScoreDao;
	@Autowired
	private AnChenScoreMapper anChenScoreMapper;
	@Override
	public void setBaseDao() {
		this.baseDao=anChenScoreDao;
	}

	@Override
	public List<AnChenScore> findAnswer(String belongAnswerId, String quId) {//belongAnswerId quId
		QueryWrapper<AnChenScore> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("belong_answer_id", belongAnswerId);
		queryWrapper.eq("qu_id", quId);
		return anChenScoreMapper.selectList(queryWrapper);
		//begin delete  by jesse at 2020-07-15  for  优化
		//		Criterion criterion1=Restrictions.eq("belongAnswerId", belongAnswerId);
		//		Criterion criterion2=Restrictions.eq("quId", quId);
		//		return anChenScoreDao.find(criterion1,criterion2);
		//end delete by jesse at 2020-07-15
	}

	@Override
	public void findGroupStats(Question question) {
//		anChenScoreDao.findGroupStats(question);


		List<AnChenScoreDTO> list=anChenScoreMapper.findGroupStats(question.getId());

		List<AnChenScore> anChenScores=new ArrayList<AnChenScore>();

		for (AnChenScoreDTO item : list) {
			AnChenScore anChenScore=new AnChenScore();
			//anChenRadio.setBelongId(belongId);
			anChenScore.setQuRowId(item.getQuRowId());
			anChenScore.setQuColId(item.getQuColId());
			//int anCount=Integer.parseInt(objects[2].toString());
			//anChenScore.setAnCount(anCount);
			anChenScore.setAvgScore(item.getAvgScore());
			anChenScores.add(anChenScore);
		}

		question.setAnChenScores(anChenScores);
	}
	
}
