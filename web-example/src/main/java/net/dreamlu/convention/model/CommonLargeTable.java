package net.dreamlu.convention.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDateTime;

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
@TableName("t_common_large_table")
public class CommonLargeTable implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	private String column01;

	private String column02;

	private String column03;

	private String column04;

	private String column05;

	private String column06;

	private String column07;

	private String column08;

	private String column09;

	private String column10;

	private String column11;

	private String column12;

	private String column13;

	private String column14;

	private String column15;

	private String column16;

	private String column17;

	private String column18;

	private String column19;

	private String column20;

	private String column21;

	private Integer column22Int;

	private Integer column23Int;

	private Integer column24Int;

	private String column25;

	private String column26;

	private LocalDateTime column27Time;

	private LocalDateTime column28Time;

	private LocalDateTime column29Time;

	private LocalDateTime column30Time;

	private LocalDate column31Date;

	private LocalDate column32Time;

	private LocalDate column33Time;

	private String column34Char;

	private String column35Char;

	private String column36Char;

	private Integer column37Byte;

	private Integer column38Byte;

	private Long column39Long;

	private Long column40Long;

	private Long column41Long;

	private Long column42Long;

	@TableField("updateTime")
	private String updateTime;

	@TableField("createTime")
	private String createTime;

	@TableField("createDay")
	private String createDay;

	@TableField("updateDay")
	private String updateDay;

	/**
	 * 是否删除,n,y
	 */
	private String isDeleted;

	private LocalDate column32Date;

	private LocalDate column33Date;

	private String type2;


}
