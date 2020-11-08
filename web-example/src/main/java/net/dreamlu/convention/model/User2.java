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
@TableName("t_user2")
public class User2 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String username2;

	private Integer age;

	private String hobby;


}
