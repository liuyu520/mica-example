package net.dreamlu.convention.model;

import java.math.BigDecimal;

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
@TableName("t_business_order_item")
public class BusinessOrderItem implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@TableField("createDay")
	private String createDay;

	@TableField("createTime")
	private String createTime;

	@TableField("createTimestamp")
	private Long createTimestamp;

	@TableField("orderNo")
	private String orderNo;

	private String reserved;

	private Integer status;

	@TableField("totalPrice")
	private BigDecimal totalPrice;

	@TableField("updateDay")
	private String updateDay;

	@TableField("updateTime")
	private String updateTime;

	@TableField("updateTimestamp")
	private Long updateTimestamp;

	private BigDecimal price;

	@TableField("productBaseInfo_id")
	private Integer productbaseinfoId;


}
