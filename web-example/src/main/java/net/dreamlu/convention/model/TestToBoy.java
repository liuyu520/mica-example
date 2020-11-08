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
@TableName("t_test_to_boy")
public class TestToBoy implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	private String testcase;

	private String aliass;

	private String alias2;

	private Integer bestConventionId;

	private String updateTime;

	private Integer stars;

	/**
	 * 1:有效;2:被删除
	 */
	private Integer status;

	@TableField("userId")
	private Integer userId;

	private String onlyISee;

	private Integer type;

	/**
	 * 1:加密
	 */
	private Integer encrypted;

	private String key2;

	private Integer order2;

	@TableField("latestAccessDetailTime")
	private String latestAccessDetailTime;

	@TableField("createTime")
	private String createTime;

	private String alias;

	private String isOffen;


}
