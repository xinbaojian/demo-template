package com.qitech.mybatis.handler;

import com.qitech.utils.GsonUtils;
import com.qitech.utils.ObjectMapperUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.postgresql.util.PGobject;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author xin.bj
 * @program security-parent
 * @description JsonTypeHandler
 * @create 2018-10-30 09:10
 **/
@MappedTypes(Object.class)
public class JsonTypeHandler extends BaseTypeHandler<Object> {

    private static final PGobject JSON_OBJECT = new PGobject();

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {
        JSON_OBJECT.setType("json");
        JSON_OBJECT.setValue(ObjectMapperUtils.toJson(o));
        preparedStatement.setObject(i, JSON_OBJECT);
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return GsonUtils.toJsonElement(resultSet.getString(s));
    }

    @Override
    public Object getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return GsonUtils.toJsonElement(resultSet.getString(i));
    }

    @Override
    public Object getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return GsonUtils.toJsonElement(callableStatement.getString(i));
    }
}
