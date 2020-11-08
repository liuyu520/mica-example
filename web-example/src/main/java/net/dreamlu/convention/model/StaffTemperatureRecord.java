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
@TableName("t_staff_temperature_record")
public class StaffTemperatureRecord implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@TableField("updateTime")
	private String updateTime;

	@TableField("createTime")
	private String createTime;

	@TableField("createDay")
	private String createDay;

	@TableField("updateDay")
	private String updateDay;

	@TableField("measuringTime")
	private String measuringTime;

	/**
	 * 姓名
	 */
	@TableField("realName")
	private String realName;

	/**
	 * 温度
	 */
	private String temperature;

	/**
	 * 时间段,morning,noon,after
	 */
	private String timeSlot;

	private String mobile;

	private Integer age;

	private String reasons;

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

	@TableField("deptName")
	private String deptName;

	@TableField("workTitle")
	private String workTitle;

	private String isReturnToWorkcity;


}
