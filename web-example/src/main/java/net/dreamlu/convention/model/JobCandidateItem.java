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
@TableName("t_job_candidate_item")
public class JobCandidateItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@TableField("updateTime")
	private String updateTime;

	/**
	 * 预留
	 */
	private String status;

	@TableField("createTime")
	private String createTime;

	@TableField("realName")
	private String realName;

	@TableField("staffNo")
	private String staffNo;

	private String mobile;

	private String description;

	/**
	 * 职务
	 */
	private String remark;

	/**
	 * 级别"P6,P7"
	 */
	@TableField("gradeLevel")
	private String gradeLevel;

	/**
	 * 工作年限,例如"工作3年"
	 */
	@TableField("workYears")
	private String workYears;

	/**
	 * 专场城市,例如"上海","南京"
	 */
	@TableField("recruitSpecialCity")
	private String recruitSpecialCity;

	/**
	 * 简历优质排序,我个人自定义的
	 */
	@TableField("qualityRank")
	private String qualityRank;

	/**
	 * 简历地址,如果有多个,则以逗号分隔
	 */
	private String url;

	/**
	 * 职务名称:"政务钉钉事业部-JAVA服务端技术专家（上海专场）-杭州"
	 */
	@TableField("workTitle")
	private String workTitle;

	/**
	 * 面试时间
	 */
	private String interviewTime;

	/**
	 * 预留
	 */
	@TableField("reservedOne")
	private String reservedOne;

	/**
	 * n,y
	 */
	private String isDeleted;

	private String reserved2;

	private String reserved3;

	private String reserved4;

	private String reserved5;

	private String reserved6;

	private String reserved7;

	private String reserved8;

	private String reserved9;

	private String reserved10;

	private String reserved11;

	private String reserved12;

	private String email;

	@TableField("weixinNo")
	private String weixinNo;

	@TableField("isHighQuality")
	private String isHighQuality;

	@TableField("specialCase")
	private String specialCase;


}
