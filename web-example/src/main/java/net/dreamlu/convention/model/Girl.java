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
@TableName("t_girl")
public class Girl implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	private Integer age;

	private String birthday;

	private String college;

	private String constellation;

	@TableField("createTime")
	private String createTime;

	private String description;

	private String hate;

	private String hobby;

	private String hometown;

	private String job;

	private String name;

	@TableField("nickName")
	private String nickName;

	private String pics;

	private String portrait;

	private Integer status;

	@TableField("updateTime")
	private String updateTime;

	/**
	 * 工作地点
	 */
	private String workPlace;

	/**
	 * 身高
	 */
	private Integer height;

	private Integer weight;

	/**
	 * 生肖
	 */
	private String animalSign;

	/**
	 * 民族
	 */
	private String nation;


}
