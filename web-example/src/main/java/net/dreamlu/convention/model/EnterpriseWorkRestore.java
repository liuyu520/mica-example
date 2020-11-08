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
@TableName("t_enterprise_work_restore")
public class EnterpriseWorkRestore implements Serializable {

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

	@TableField("appKey")
	private String appKey;

	@TableField("processCode")
	private String processCode;

	@TableField("appZhName")
	private String appZhName;

	/**
	 * 姓名
	 */
	@TableField("processZhName")
	private String processZhName;

	/**
	 * 温度
	 */
	@TableField("yidaAppType")
	private String yidaAppType;

	/**
	 * 时间段,morning,noon,after
	 */
	@TableField("yidaApiToken")
	private String yidaApiToken;

	@TableField("url_for_test")
	private String urlForTest;

	@TableField("dataSearchUrl")
	private String dataSearchUrl;

	@TableField("processMgmtUrl")
	private String processMgmtUrl;

	/**
	 * 是否删除,n,y
	 */
	private String isDeleted;

	@TableField("reservedOne")
	private String reservedOne;

	private String reserved2;

	private String reserved3;

	private String reserved4;

	private String reserved5;

	private String reserved6;

	private String reserved7;

	private String reserved8;

	private String reserved9;

	private String reserved10;

	private String reserved11;

	private String reserved12;

	@TableField("applyCity")
	private String applyCity;


	@TableField("dataAuthQueryRole")
	private String dataAuthQueryRole;

	@TableField("dataAuthExportRole")
	private String dataAuthExportRole;

	private String roleBindingJson;

	@TableField("appUuid")
	private String appUuid;

	@TableField("processDataStatisticsUrl")
	private String processDataStatisticsUrl;


}
