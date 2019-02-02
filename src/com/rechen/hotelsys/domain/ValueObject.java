/**
 * 
 */
package com.rechen.hotelsys.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * 实体类基类
 * @author Re.chen
 *
 */
public class ValueObject {
	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
