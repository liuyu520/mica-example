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
@TableName("t_product_base_info")
public class ProductBaseInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@TableField("displayName")
	private String displayName;

	private String code;

	@TableField("imgUrl")
	private String imgUrl;

	private String desc2;

	private BigDecimal price;

	@TableField("totalPrice")
	private BigDecimal totalPrice;

	private String reserved;

	private String remark;

	private String rewards;


}
