package net.dreamlu.convention.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author hanjun
 * @since 2020-11-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_baby_growth_route")
public class BabyGrowthRoute implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@TableField("monthSeq")
	private Integer monthSeq;

	private String desc2;

	private String notice;

	private String extend;

	private String extend2;

	@TableField("updateTime")
	private String updateTime;

	@TableField("createTime")
	private String createTime;

	@TableField("createDay")
	private String createDay;

	@TableField("updateDay")
	private String updateDay;


}
