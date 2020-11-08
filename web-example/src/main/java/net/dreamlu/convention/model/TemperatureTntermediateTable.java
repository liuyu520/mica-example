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
@TableName("t_temperature_tntermediate_table")
public class TemperatureTntermediateTable implements Serializable {

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

	@TableField("idList")
	private String idList;

	@TableField("realName")
	private String realName;

	private String mobile;

	@TableField("temperatureList")
	private String temperatureList;

	@TableField("measuringTimeList")
	private String measuringTimeList;

	@TableField("timeSlotList")
	private String timeSlotList;

	@TableField("reservedOne")
	private String reservedOne;

	@TableField("updateTimeList")
	private String updateTimeList;

	private String isReturnToWorkcity;

	@TableField("deptName")
	private String deptName;

	@TableField("isReturn2workCity")
	private String isReturn2workCity;


}
