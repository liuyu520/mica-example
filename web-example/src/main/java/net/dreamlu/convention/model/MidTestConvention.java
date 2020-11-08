package net.dreamlu.convention.model;

import com.baomidou.mybatisplus.annotation.TableName;

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
@TableName("t_mid_test_convention")
public class MidTestConvention implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer testId;

	private Integer conventionId;

	/**
	 * 1:有效;2:被删除
	 */
	private Integer status;


}
