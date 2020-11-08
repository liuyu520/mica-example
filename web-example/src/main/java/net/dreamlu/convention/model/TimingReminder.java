package net.dreamlu.convention.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author hanjun
 * @since 2020-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_timing_reminder")
public class TimingReminder implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	private String description;

	@TableField("timingType")
	private String timingType;

	@TableField("actionType")
	private String actionType;

	private String cron;

	private String accessDaytime;

	@TableField("updateTime")
	private String updateTime;

	@TableField("createTime")
	private String createTime;

	private String status;

	@TableField("remindTimes")
	private Integer remindTimes;

	private String groupUuid;

	private String reminderType;

	@TableField("manyDays")
	private Integer manyDays;

	@TableField("memoryCurveId")
	private Long memoryCurveId;

	@TableField("forTest")
	private String forTest;

	@TableField("fromId")
	private String fromId;

	@TableField("fromGroupUuid")
	private String fromGroupUuid;

	private String remark;

	/**
	 * 发短信的接收手机号
	 */
	private String contactMobile;


}
