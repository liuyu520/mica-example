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
@TableName("t_recruit_requirements_item")
public class RecruitRequirementsItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@TableField("updateTime")
	private String updateTime;

	private String status;

	@TableField("createTime")
	private String createTime;

	@TableField("createDay")
	private String createDay;

	private String mobile;

	private String description;

	private String requirements;

	@TableField("recruitmentTitle")
	private String recruitmentTitle;

	@TableField("timeLimit")
	private String timeLimit;

	@TableField("contractPeople")
	private String contractPeople;

	@TableField("workAddress")
	private String workAddress;

	private String content;

	@TableField("reservedOne")
	private String reservedOne;

	private String reserved2;

	private String reserved3;

	private String reserved4;

	private String reserved5;

	/**
	 * 是否删除,n,y
	 */
	private String isDeleted;


}
