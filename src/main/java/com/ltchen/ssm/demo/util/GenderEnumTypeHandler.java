package com.ltchen.ssm.demo.util;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.ltchen.ssm.demo.bean.Gender;

/**
 * 
 * @file : GenderEnumTypeHandler.java
 * @date : 2017年5月6日
 * @author : ltchen
 * @email : loupipalien@gmail.com
 * @desc : Gender枚举类型转换器,将java的Gender枚举类型转换为sql兼容的字符串类型
 */
public class GenderEnumTypeHandler implements TypeHandler<Gender> {

	/** 
     * 用于在Mybatis通过字段名称获取字段数据时把数据库类型转换为对应的Java类型 
     * @param resultSet 当前的结果集 
     * @param colName 当前的字段名称
     * @return 转换后的Java对象 
     * @throws SQLException 
     */ 
	@Override
	public Gender getResult(ResultSet rs, String colName) throws SQLException {
		return transferType(rs.getString(colName));
	}

	/** 
     * 用于在Mybatis通过字段位置获取字段数据时把数据库类型转换为对应的Java类型 
     * @param resultSet 当前的结果集 
     * @param colIndex 当前字段的位置 
     * @return 转换后的Java对象 
     * @throws SQLException 
     */ 
	@Override
	public Gender getResult(ResultSet rs, int colIndex) throws SQLException {
		return transferType(rs.getString(colIndex));
	}

	/** 
     * 用于Mybatis在调用存储过程后把数据库类型的数据转换为对应的Java类型 
     * @param callableStatement 当前的CallableStatement执行后的CallableStatement 
     * @param colIndex 当前输出参数的位置 
     * @return 转换后的Java对象 
     * @throws SQLException 
     */ 
	@Override
	public Gender getResult(CallableStatement cs, int colIndex) throws SQLException {
		return transferType(cs.getString(colIndex));
	}

	/** 
     * 用于定义在Mybatis设置参数时该如何把Java类型的参数转换为对应的数据库类型 
     * @param preparedStatement 当前的PreparedStatement对象 
     * @param paramIndex 当前参数的位置 
     * @param obj 当前参数的Java对象 
     * @param jdbcType 当前参数的数据库类型 
     * @throws SQLException 
     */
	@Override
	public void setParameter(PreparedStatement ps, int paramIndex, Gender obj, JdbcType jdbcType) throws SQLException {
		if(obj.toString().equalsIgnoreCase("man")){ 
            ps.setString(paramIndex,"man"); 
        }
		else{
			 ps.setString(paramIndex,"woman"); 
		}

	}

	/**
	 * 将字符串转换为Gender枚举类型
	 * @param value 需要被转换的字符串
	 * @return value被转换后对应的Gender类型
	 */
	private  Gender transferType(String value) {
        for (Gender gender : Gender.values()) {
             //判断null,sql语句中left join或者right join时此对象为空,导致空指针
             if(value == null){
                  return null;
             }
             else if (value.equalsIgnoreCase(gender.toString())) {
                  return gender;
             }
        }
        throw new IllegalArgumentException("Cannot transfer from value: " + value + " !");
  }


}
