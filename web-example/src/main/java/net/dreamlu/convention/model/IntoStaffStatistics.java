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
@TableName("t_into_staff_statistics")
public class IntoStaffStatistics implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@TableField("updateTime")
	private String updateTime;

	private String status;

	@TableField("createTime")
	private String createTime;

	@TableField("realName")
	private String realName;

	@TableField("staffNo")
	private String staffNo;

	private String mobile;

	@TableField("deptName")
	private String deptName;

	@TableField("picUrl")
	private String picUrl;

	@TableField("isBackCompany")
	private String isBackCompany;

	@TableField("homeAddress")
	private String homeAddress;

	@TableField("isWillTrip")
	private String isWillTrip;

	@TableField("tripDistination")
	private String tripDistination;

	private String reasons;

	/**
	 * 是否仅仅为了测试,取值["y","n"]
	 */
	private String isJustForTest;

	private String description;

	@TableField("problemAnserOne")
	private String problemAnserOne;

	@TableField("problemAnswer2")
	private String problemAnswer2;

	@TableField("problemAnswer3")
	private String problemAnswer3;

	@TableField("problemAnswer3a")
	private String problemAnswer3a;

	@TableField("problemAnswer3b")
	private String problemAnswer3b;

	@TableField("problemAnswer4")
	private String problemAnswer4;

	@TableField("problemAnswer4a")
	private String problemAnswer4a;

	@TableField("problemAnswer4b")
	private String problemAnswer4b;

	@TableField("problemAnswer5")
	private String problemAnswer5;

	@TableField("problemAnswer6")
	private String problemAnswer6;

	@TableField("problemAnswer7")
	private String problemAnswer7;

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

	/**
	 * 职务
	 */
	@TableField("workTitle")
	private String workTitle;

	@TableField("isTouchPatient")
	private String isTouchPatient;

	@TableField("isGoHospital")
	private String isGoHospital;

	/**
	 * 预计回去公司工作的时间
	 */
	@TableField("backWorkTime")
	private String backWorkTime;


}
