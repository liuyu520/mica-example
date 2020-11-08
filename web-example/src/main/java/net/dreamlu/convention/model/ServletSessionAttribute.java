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
@TableName("t_servlet_session_attribute")
public class ServletSessionAttribute implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;

	@TableField("createTime")
	private String createTime;

	private String key2;

	@TableField("listItemEleClass")
	private String listItemEleClass;

	@TableField("sessionId")
	private String sessionId;

	@TableField("updateTime")
	private String updateTime;

	private String val2;

	@TableField("valClass")
	private String valClass;

	private String reserved;

	private String description;


}
