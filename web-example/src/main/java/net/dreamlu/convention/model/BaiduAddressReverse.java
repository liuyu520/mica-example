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
@TableName("t_baidu_Address_reverse")
public class BaiduAddressReverse implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	private String adcode;

	private String city;

	@TableField("cityCode")
	private Integer cityCode;

	private Integer cityLevel;

	private String country;

	private Integer countryCode;

	private String countryCodeIso;

	private String direction;

	private String distance;

	private String district;

	private String formattedAddress;

	private BigDecimal lat;

	private BigDecimal lng;

	private String province;

	private String sematicDescription;

	private String street;

	private String remark;

	private String streetNumber;

	private String town;


}
