package com.key.dwsurvey.mapper;

import com.key.dwsurvey.pojo.MailInviteInbox;

public interface MailInviteInboxMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mail_invite_inbox
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mail_invite_inbox
     *
     * @mbggenerated
     */
    int insert(MailInviteInbox record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mail_invite_inbox
     *
     * @mbggenerated
     */
    int insertSelective(MailInviteInbox record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mail_invite_inbox
     *
     * @mbggenerated
     */
    MailInviteInbox selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mail_invite_inbox
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(MailInviteInbox record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_mail_invite_inbox
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(MailInviteInbox record);
}