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
@TableName("t_access_log")
public class AccessLog implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	private String accessDay;

	private String accessDaytime;

	private Integer accessType;

	private String description;

	private String deviceId;

	private String deviceType;

	private String extranetIp;

	private String ip;

	private String operateResult;

	private String osType;

	private String queryString;

	private String requestTarget;

	@TableField("requestURI")
	private String requestURI;

	private String reserved;

	private String session2Id;

	private Long time;

	private String userAgent;

	@TableField("userId")
	private Integer userId;

	private String username;

	@TableField("contentType")
	private String contentType;

	@TableField("redisCookieId")
	private String redisCookieId;

	@TableField("secretKey")
	private String secretKey;

	@TableField("accessKey")
	private String accessKey;

	private String requestHeader;


}
