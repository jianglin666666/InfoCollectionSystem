package com.key.dwsurvey.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.key.common.QuType;
import com.key.common.plugs.page.PropertyFilter;
import com.key.common.service.BaseServiceImpl;
import com.key.common.utils.ReflectionUtils;
import com.key.dwsurvey.dao.QuestionDao;
import com.key.dwsurvey.entity.*;
import com.key.dwsurvey.mapper.QuRadioMapper;
import com.key.dwsurvey.mapper.QuestionMapper;
import com.key.dwsurvey.service.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


/**
 * 基础题
 *
 * @author keyuan(keyuan258 @ gmail.com)
 * <p>
 * https://github.com/wkeyuan/DWSurvey
 * http://dwsurvey.net
 */
@Service("questionManager")
public class QuestionManagerImpl extends BaseServiceImpl<Question, String> implements QuestionManager {

    @Autowired
    private QuestionDao questionDao;
    @Autowired
    private QuCheckboxManager quCheckboxManager;
    @Autowired
    private QuRadioManager quRadioManager;
    @Autowired
    private QuMultiFillblankManager quMultiFillblankManager;
    @Autowired
    private QuChenRowManager quChenRowManager;
    @Autowired
    private QuChenColumnManager quChenColumnManager;
    @Autowired
    private QuChenOptionManager quChenOptionManager;
    @Autowired
    private QuScoreManager quScoreManager;
    @Autowired
    private QuOrderbyManager quOrderbyManager;
    @Autowired
    private QuestionLogicManager questionLogicManager;
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private QuRadioMapper quRadioMapper;
    @Override
    public void setBaseDao() {
        this.baseDao = questionDao;
    }


    /**
     * 所有修改，新增题的入口 方法
     *
     * @param question
     */
    @Transactional
    @Override
    public void save(Question question) {
//		User user=accountManager.getCurUser();
//		if(user!=null){
        String uuid = question.getId();
        if (uuid == null || "".equals(uuid)) {
            question.setId(null);
        }
        questionDao.save(question);
//			question.setUserUuid(user.getId());
//			System.out.println("getRows:"+question.getRows().size());
//        if (question.getId() == null){
//            questionDao.save(question);
////            questionMapper.insertSelective(question);
////            for (int i = 0; i < question.getQuRadios().size(); i++) {
////                question.getQuRadios().get(i).setQuId(question.getId());
////                quRadioMapper.insertSelective(question.getQuRadios().get(i));
////            }
//        }else{
//            questionMapper.updateByPrimaryKeySelective(question);
////            for (int i = 0; i < question.getQuRadios().size(); i++) {
////                question.getQuRadios().get(i).setQuId(question.getId());
////                quRadioMapper.updateByPrimaryKeySelective(question.getQuRadios().get(i));
////            }
//        }
//        questionDao.save(question);
//		}
    }


    /**************************************************************************/
    /**
     * 依据条件得到符合条件的题列表，不包含选项信息   用于列表显示
     *
     * @param qubankId
     * @param tag      1题库  2问卷
     * @return
     */
    public List<Question> find(String belongId, String tag) {
//        Page<Question> page = new Page<Question>();
//        page.setOrderBy("orderById");
//        page.setOrderDir("asc");
//
//        List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
//        filters.add(new PropertyFilter("EQS_belongId", belongId));
//        filters.add(new PropertyFilter("EQI_tag", tag));
//        filters.add(new PropertyFilter("NEI_quTag", "3"));
//        return findAll(page, filters);

        return questionMapper.findAll(belongId, Integer.parseInt(tag), Integer.valueOf(3));
    }

    /**
     * 查出指定条件下的所有题，及每一题内容的选项   用于展示试卷,如预览,答卷,查看
     *
     * @param qubankId
     * @param tag
     * @return
     */
    public List<Question> findDetails(String belongId, String tag) {
        List<Question> questions = find(belongId, tag);
        for (Question question : questions) {
            getQuestionOption(question);
        }
        return questions;
    }


//	public List<Question> findDetail

    /**
     * 得到某一题下面的选项，包含大题下面的小题
     *
     * @param question
     */
    public void getQuestionOption(Question question) {
        String quId = question.getId();
        QuType quType = question.getQuType();
        if (quType == QuType.RADIO || quType == QuType.COMPRADIO) {
            question.setQuRadios(quRadioManager.findByQuId(quId));
        } else if (quType == QuType.CHECKBOX || quType == QuType.COMPCHECKBOX) {
            question.setQuCheckboxs(quCheckboxManager.findByQuId(quId));
        } else if (quType == QuType.MULTIFILLBLANK) {
            question.setQuMultiFillblanks(quMultiFillblankManager.findByQuId(quId));
        } else if (quType == QuType.BIGQU) {
            //根据大题ID，找出所有小题
            String parentQuId = question.getId();
            List<Question> childQuList = findByParentQuId(parentQuId);
            for (Question childQu : childQuList) {
                getQuestionOption(childQu);
            }
            question.setQuestions(childQuList);
            //根据小题的类型，取选项
        } else if (quType == QuType.CHENRADIO || quType == QuType.CHENCHECKBOX || quType == QuType.CHENSCORE || quType == QuType.CHENFBK || quType == QuType.COMPCHENRADIO) {//矩阵单选，矩阵多选，矩阵填空题，复合矩阵单选
            List<QuChenRow> rows = quChenRowManager.findByQuId(quId);
            List<QuChenColumn> columns = quChenColumnManager.findByQuId(quId);
            question.setRows(rows);
            question.setColumns(columns);

            if (quType == QuType.COMPCHENRADIO) {//如果是复合矩阵单选题， 则还有题选项
                List<QuChenOption> options = quChenOptionManager.findByQuId(quId);
                question.setOptions(options);
            }
        } else if (quType == QuType.SCORE) {
            List<QuScore> quScores = quScoreManager.findByQuId(quId);
            question.setQuScores(quScores);
        } else if (quType == QuType.ORDERQU) {
            List<QuOrderby> quOrderbys = quOrderbyManager.findByQuId(quId);
            question.setQuOrderbys(quOrderbys);
        }
        List<QuestionLogic> questionLogics = questionLogicManager.findByCkQuId(quId);
            question.setQuestionLogics(questionLogics);
    }

    public List<Question> findByParentQuId(String parentQuId) {
        //        List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
        //   filters.add(new PropertyFilter("EQS_parentQuUuId", parentQuId));
        return questionMapper.selectByparentQuUuId(parentQuId);
//        return parentList;
    }

    /**
     * 根据ID，得到一批题
     *
     * @param quIds
     * @param b     表示是否提出每一题的详细选项信息
     * @return
     */
    public List<Question> findByQuIds(String[] quIds, boolean b) {
        List<Question> questions = new ArrayList<Question>();
        if (quIds == null || quIds.length <= 0) {
            return questions;
        }
//        StringBuffer hqlBuf = new StringBuffer("from Question qu where qu.id in(");
//        for (String quId : quIds) {
//            hqlBuf.append("'" + quId + "'").append(",");
//        }
////		hqlBuf.append("0)");
//        String hql = hqlBuf.substring(0, hqlBuf.lastIndexOf(",")) + ")";
//        questions = questionDao.find(hql);
        //TODO 测试
        List<String> questIds = new ArrayList<>();
        Collections.addAll(questIds, quIds);
        questions = questionMapper.selectBatchIds(questIds);
        if (b) {
            for (Question question : questions) {
                getQuestionOption(question);
            }
        }
        return questions;
    }

    /**
     * 批量删除题，及题包含的选项一同删除-真删除。
     *
     * @param delQuIds
     */
    @Transactional
    public void deletes(String[] delQuIds) {
        if (delQuIds != null) {
            for (String quId : delQuIds) {

            }
        }
    }

    @Transactional
    public void delete(String quId) {
        if (quId != null && !"".equals(quId)) {
            Question question = questionMapper.selectByPrimaryKey(quId);
//            Question question = get(quId);
            //同时删除掉相应的选项
            if (question != null) {
                QuType quType = question.getQuType();
                String id = question.getId();
                String belongId = question.getBelongId();
                int orderById = question.getOrderById();
                questionMapper.deleteByPrimaryKey(question.getId());
                //begin delete  by jesse at 2020-07-15  for 优化
                ////                questionDao.delete(question);
                //end delete by jesse at 2020-07-15

                //更新ID
                questionMapper.quOrderByIdDel1(belongId, orderById);
                //begin delete  by jesse at 2020-07-15  for 优化
                //                questionDao.quOrderByIdDel1(belongId, orderById);
                //end delete by jesse at 2020-07-15

            }
        }
    }

    /**
     * 题排序
     *
     * @param prevId
     * @param nextId
     */
    @Transactional
    public boolean upsort(String prevId, String nextId) {
        if (prevId != null && !"".equals(prevId) && nextId != null && !"".equals(nextId)) {
            Question prevQuestion = questionMapper.selectByPrimaryKey(prevId);
//            Question prevQuestion = get(prevId);
            Question nextQuestion = questionMapper.selectByPrimaryKey(nextId);
//            Question nextQuestion = get(nextId);
            int prevNum = prevQuestion.getOrderById();
            int nextNum = nextQuestion.getOrderById();

            prevQuestion.setOrderById(nextNum);
            nextQuestion.setOrderById(prevNum);

            save(prevQuestion);
            save(nextQuestion);
            return true;
        }
        return false;
    }

    public Question findUnById(String id) {
        return questionMapper.selectByPrimaryKey(id);
//        return questionDao.findUniqueBy("id", id);
    }

    public List<Question> findByparentQuId(String parentQuUuId) {
//        List<PropertyFilter> filters = new ArrayList<PropertyFilter>();
//        filters.add(new PropertyFilter("EQS_parentQuUuId", parentQuUuId));
        return questionMapper.selectByparentQuUuId(parentQuUuId);
//        return findList(filters);
    }

    public void saveBySurvey(String belongId, int tag, List<Question> questions) {
        for (Question question : questions) {
            copyQu(belongId, tag, question);
        }
    }

    /**
     * 保存选中的题目 即从题库或从其它试卷中的题
     */
    @Transactional
    public void saveChangeQu(String belongId, int tag, String[] quIds) {
        for (String quId : quIds) {
            Question changeQuestion = findUnById(quId);
            copyQu(belongId, tag, changeQuestion);
        }
    }

    private void copyQu(String belongId, int tag, Question changeQuestion) {
        String quId = changeQuestion.getId();
        if (changeQuestion.getQuType() == QuType.BIGQU) {
            Question question = new Question();
            ReflectionUtils.copyAttr(changeQuestion, question);
            //设置相关要改变的值
            question.setId(null);
            question.setBelongId(belongId);
            question.setCreateDate(new Date());
            question.setTag(tag);
            question.setQuTag(2);
            question.setCopyFromId(quId);

            List<Question> changeChildQuestions = findByparentQuId(quId);
            List<Question> qulits = new ArrayList<Question>();
            for (Question changeQu : changeChildQuestions) {
                Question question2 = new Question();
                ReflectionUtils.copyAttr(changeQu, question2);
                //设置相关要改变的值
                question2.setId(null);
                question2.setBelongId(belongId);
                question2.setCreateDate(new Date());
                question2.setTag(tag);
                question2.setQuTag(3);
                question2.setCopyFromId(changeQu.getId());

                getQuestionOption(changeQu);
                copyItems(belongId, changeQu, question2);

                qulits.add(question2);
            }
            question.setQuestions(qulits);
            save(question);
        } else {
            copyroot(belongId, tag, changeQuestion);
        }
    }

    private void copyroot(String belongId, Integer tag, Question changeQuestion) {
        //拷贝先中的问题属性值到新对象中
        Question question = new Question();
        ReflectionUtils.copyAttr(changeQuestion, question);
        //设置相关要改变的值
        question.setId(null);
        question.setBelongId(belongId);
        question.setCreateDate(new Date());
        question.setTag(tag);
        question.setCopyFromId(changeQuestion.getId());

        getQuestionOption(changeQuestion);
        //TODO有问题
        copyItems(belongId, changeQuestion, question);
        save(question);
    }

    private void copyItems(String quBankUuid, Question changeQuestion, Question question) {
        QuType quType = changeQuestion.getQuType();
        if (quType == QuType.RADIO || quType == QuType.COMPRADIO) {
            List<QuRadio> changeQuRadios = changeQuestion.getQuRadios();
            List<QuRadio> quRadios = new ArrayList<QuRadio>();
            for (QuRadio changeQuRadio : changeQuRadios) {
                QuRadio quRadio = new QuRadio();
                ReflectionUtils.copyAttr(changeQuRadio, quRadio);
                quRadio.setId(null);
                quRadios.add(quRadio);
            }
            question.setQuRadios(quRadios);
        } else if (quType == QuType.CHECKBOX || quType == QuType.COMPCHECKBOX) {
            List<QuCheckbox> changeQuCheckboxs = changeQuestion.getQuCheckboxs();
            List<QuCheckbox> quCheckboxs = new ArrayList<QuCheckbox>();
            for (QuCheckbox changeQuCheckbox : changeQuCheckboxs) {
                QuCheckbox quCheckbox = new QuCheckbox();
                ReflectionUtils.copyAttr(changeQuCheckbox, quCheckbox);
                quCheckbox.setId(null);
                quCheckboxs.add(quCheckbox);
            }
            question.setQuCheckboxs(quCheckboxs);
        } else if (quType == QuType.MULTIFILLBLANK) {
            List<QuMultiFillblank> changeQuDFillbanks = changeQuestion.getQuMultiFillblanks();
            List<QuMultiFillblank> quDFillbanks = new ArrayList<QuMultiFillblank>();
            for (QuMultiFillblank changeQuDFillbank : changeQuDFillbanks) {
                QuMultiFillblank quDFillbank = new QuMultiFillblank();
                ReflectionUtils.copyAttr(changeQuDFillbank, quDFillbank);
                quDFillbank.setId(null);
                quDFillbanks.add(quDFillbank);
            }
            question.setQuMultiFillblanks(quDFillbanks);
        } else if (quType == QuType.SCORE) {
            //评分
            List<QuScore> changeQuScores = changeQuestion.getQuScores();
            List<QuScore> quScores = new ArrayList<QuScore>();
            for (QuScore changeQuScore : changeQuScores) {
                QuScore quScore = new QuScore();
                ReflectionUtils.copyAttr(changeQuScore, quScore);
                quScore.setId(null);
                quScores.add(quScore);
            }
            question.setQuScores(quScores);
        } else if (quType == QuType.CHENRADIO || quType == QuType.CHENCHECKBOX || quType == QuType.CHENFBK || quType == QuType.COMPCHENRADIO) {
            List<QuChenRow> changeRows = changeQuestion.getRows();
            List<QuChenColumn> changeColumns = changeQuestion.getColumns();
            List<QuChenRow> rows = new ArrayList<QuChenRow>();
            List<QuChenColumn> columns = new ArrayList<QuChenColumn>();
            for (QuChenRow changeRow : changeRows) {
                QuChenRow quChenRow = new QuChenRow();
                ReflectionUtils.copyAttr(changeRow, quChenRow);
                quChenRow.setId(null);
                rows.add(quChenRow);
            }
            question.setRows(rows);

            for (QuChenColumn changeColumn : changeColumns) {
                QuChenColumn quChenColumn = new QuChenColumn();
                ReflectionUtils.copyAttr(changeColumn, quChenColumn);
                quChenColumn.setId(null);
                columns.add(quChenColumn);
            }
            question.setColumns(columns);

            if (quType == QuType.COMPCHENRADIO) {
                List<QuChenOption> changeOptions = changeQuestion.getOptions();
                List<QuChenOption> options = new ArrayList<QuChenOption>();
                for (QuChenOption changeOption : changeOptions) {
                    QuChenOption quChenColumn = new QuChenOption();
                    ReflectionUtils.copyAttr(changeOption, quChenColumn);
                    quChenColumn.setId(null);
                    options.add(quChenColumn);
                }
                question.setOptions(options);
            }

        }else if (quType == QuType.ORDERQU){
            List<QuOrderby> changeQuOrderbys = changeQuestion.getQuOrderbys();
            List<QuOrderby> orderbies = new ArrayList<>();
            for (QuOrderby changeQuOrderby : changeQuOrderbys){
                QuOrderby quOrderby = new QuOrderby();
                ReflectionUtils.copyAttr(changeQuOrderby,quOrderby);
                quOrderby.setId(null);
                orderbies.add(quOrderby);
            }
            question.setQuOrderbys(orderbies);

        }

    }


    @Override
    public List<Question> findStatsRowVarQus(SurveyDirectory survey) {
//        Criterion criterion1 = Restrictions.eq("belongId", survey.getId());
//        Criterion criterion2 = Restrictions.eq("tag", 2);

//		Criterion criterion31=Restrictions.ne("quType", QuType.FILLBLANK);
//		Criterion criterion32=Restrictions.ne("quType", QuType.MULTIFILLBLANK);
//		Criterion criterion33=Restrictions.ne("quType", QuType.ANSWER);
//		
////		Criterion criterion3=Restrictions.or(criterion31, criterion32);
//		//where s=2 and (fds !=1 or fds!=2 )
//		return questionDao.find(criterion1,criterion2,criterion31,criterion32,criterion33);
        List<Integer> list = new ArrayList<>();
        list.add(QuType.FILLBLANK.getIndex());
        list.add(QuType.MULTIFILLBLANK.getIndex());
        list.add(QuType.ANSWER.getIndex());
        list.add(QuType.CHENCHECKBOX.getIndex());
        list.add(QuType.CHENFBK.getIndex());
        list.add(QuType.CHENRADIO.getIndex());
        list.add(QuType.ENUMQU.getIndex());
        list.add(QuType.ORDERQU.getIndex());
        list.add(QuType.SCORE.getIndex());
        return questionMapper.findByBelongIdAndTagNotInQuType(survey.getId(),2,list);
//        Criterion criterion31 = Restrictions.ne("quType", QuType.FILLBLANK);
//        Criterion criterion32 = Restrictions.ne("quType", QuType.MULTIFILLBLANK);
//        Criterion criterion33 = Restrictions.ne("quType", QuType.ANSWER);
//        Criterion criterion34 = Restrictions.ne("quType", QuType.CHENCHECKBOX);
//        Criterion criterion35 = Restrictions.ne("quType", QuType.CHENFBK);
//        Criterion criterion36 = Restrictions.ne("quType", QuType.CHENRADIO);
//        Criterion criterion37 = Restrictions.ne("quType", QuType.ENUMQU);
//        Criterion criterion38 = Restrictions.ne("quType", QuType.ORDERQU);
//        Criterion criterion39 = Restrictions.ne("quType", QuType.SCORE);
//
//        return questionDao.find(criterion1, criterion2, criterion31, criterion32, criterion33, criterion34, criterion35, criterion36, criterion37, criterion38, criterion39);
//		return null;
    }


    @Override
    public List<Question> findStatsColVarQus(SurveyDirectory survey) {
        //begin delete  by jesse at 2020-07-16  for 优化
        //        Criterion criterion1 = Restrictions.eq("belongId", survey.getId());
        //        Criterion criterion2 = Restrictions.eq("tag", 2);
        //end delete by jesse at 2020-07-16


//		Criterion criterion31=Restrictions.ne("quType", QuType.FILLBLANK);
//		Criterion criterion32=Restrictions.ne("quType", QuType.MULTIFILLBLANK);
//		Criterion criterion33=Restrictions.ne("quType", QuType.ANSWER);
//		
////		Criterion criterion3=Restrictions.or(criterion31, criterion32);
//		//where s=2 and (fds !=1 or fds!=2 )
//		return questionDao.find(criterion1,criterion2,criterion31,criterion32,criterion33);
        List<Integer> list = new ArrayList<>();
        list.add(QuType.FILLBLANK.getIndex());
        list.add(QuType.MULTIFILLBLANK.getIndex());
        list.add(QuType.ANSWER.getIndex());
        list.add(QuType.CHENCHECKBOX.getIndex());
        list.add(QuType.CHENFBK.getIndex());
        list.add(QuType.CHENRADIO.getIndex());
        list.add(QuType.ENUMQU.getIndex());
        list.add(QuType.ORDERQU.getIndex());
        list.add(QuType.SCORE.getIndex());
        return questionMapper.findByBelongIdAndTagNotInQuType(survey.getId(),2,list);
        //begin delete  by jesse at 2020-07-16  for  优化
        //        Criterion criterion31 = Restrictions.ne("quType", QuType.FILLBLANK);
        //        Criterion criterion32 = Restrictions.ne("quType", QuType.MULTIFILLBLANK);
        //        Criterion criterion33 = Restrictions.ne("quType", QuType.ANSWER);
        //        Criterion criterion34 = Restrictions.ne("quType", QuType.CHENCHECKBOX);
        //        Criterion criterion35 = Restrictions.ne("quType", QuType.CHENFBK);
        //        Criterion criterion36 = Restrictions.ne("quType", QuType.CHENRADIO);
        //        Criterion criterion37 = Restrictions.ne("quType", QuType.ENUMQU);
        //        Criterion criterion38 = Restrictions.ne("quType", QuType.ORDERQU);
        //        Criterion criterion39 = Restrictions.ne("quType", QuType.SCORE);
        //
        //        return questionDao.find(criterion1, criterion2, criterion31, criterion32, criterion33, criterion34, criterion35, criterion36, criterion37, criterion38, criterion39);
        //end delete by jesse at 2020-07-16
    }


    @Override
    public Question getDetail(String quId) {
        Question question = questionMapper.selectByPrimaryKey(quId);
        getQuestionOption(question);
        return question;
    }

    @Transactional
    public void update(Question entity) {
        questionMapper.updateByPrimaryKeySelective(entity);
//        questionDao.update(entity);
    }

    @Override
    public Question getQuestion(String id) {
        return questionMapper.selectByPrimaryKey(id);
    }

}
