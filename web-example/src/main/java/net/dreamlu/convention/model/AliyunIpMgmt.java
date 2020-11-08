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
 * @since 2020-11-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("t_aliyun_ip_mgmt")
public class AliyunIpMgmt implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	private String ip;

	@TableField("neiwangIp")
	private String neiwangIp;

	private String name;

	private String port;

	@TableField("loginUser")
	private String loginUser;

	private String passwd;

	private String description;

	@TableField("networkLoginUser")
	private String networkLoginUser;

	private String location;

	@TableField("reservedOne")
	private String reservedOne;

	private String reserved2;

	private String reserved3;

	private String reserved4;

	private String reserved5;

	@TableField("updateTime")
	private String updateTime;

	@TableField("createTime")
	private String createTime;

	@TableField("createDay")
	private String createDay;

	@TableField("updateDay")
	private String updateDay;


}
