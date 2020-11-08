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
@TableName("t_house")
public class House implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	private String beautiful;

	private String consuming1;

	private String consuming2;

	private String consuming3;

	private String consuming4;

	private String description2;

	@TableField("displayName")
	private String displayName;

	private Float distance1;

	private Float distance2;

	private Float distance3;

	private Float distance4;

	private String location;

	private String mobile;

	private String phone;

	private Integer size;

	private String time;

	@TableField("totalPrice")
	private String totalPrice;

	private String typee;

	@TableField("unitPrice")
	private String unitPrice;


}
