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
@TableName("t_recruit_apply_item")
public class RecruitApplyItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@TableField("updateTime")
	private String updateTime;

	private String status;

	@TableField("createTime")
	private String createTime;

	/**
	 * 姓名
	 */
	@TableField("realName")
	private String realName;

	/**
	 * 预留
	 */
	@TableField("staffNo")
	private String staffNo;

	private String mobile;

	@TableField("recruitRequirementsItemId")
	private Integer recruitRequirementsItemId;

	/**
	 * 预留
	 */
	@TableField("picUrl")
	private String picUrl;

	@TableField("birthPlace")
	private String birthPlace;

	@TableField("realAddress")
	private String realAddress;

	private Integer age;

	/**
	 * "man","fe"
	 */
	private String sex2;

	private String reasons;

	/**
	 * 是否仅仅为了测试,取值["y","n"]
	 */
	private String isJustForTest;

	/**
	 * 是否已婚,n,y
	 */
	@TableField("isMarried")
	private String isMarried;

	/**
	 * 职务
	 */
	@TableField("workTitle")
	private String workTitle;

	/**
	 * 是否删除,n,y
	 */
	private String isDeleted;

	@TableField("reservedOne")
	private String reservedOne;

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

	@TableField("createDay")
	private String createDay;

	private String email;

	private String attachmentField;

	private String description;


}
