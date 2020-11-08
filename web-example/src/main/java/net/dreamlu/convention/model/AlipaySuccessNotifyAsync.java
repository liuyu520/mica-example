package net.dreamlu.convention.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

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
@TableName("t_alipay_success_notify_async")
public class AlipaySuccessNotifyAsync implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	private String appId;

	private String authAppId;

	private String body;

	private String buyerId;

	private String buyerLogonId;

	private String buyerPayAmount;

	private String gmtCreate;

	private String gmtPayment;

	private String notifyId;

	private String notifyTime;

	private String notifyType;

	private String outTradeNo;

	private String reserved;

	private String sellerEmail;

	private String sellerId;

	private String signType;

	private String subject;

	private String totalAmount;

	private String tradeNo;

	private String tradeStatus;

	private String version;

	private String desc2;


}
