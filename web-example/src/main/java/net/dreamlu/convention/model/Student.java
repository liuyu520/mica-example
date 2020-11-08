package net.dreamlu.convention.model;

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
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String username;

	private Integer age;

	private String no;

	private Integer type;


}