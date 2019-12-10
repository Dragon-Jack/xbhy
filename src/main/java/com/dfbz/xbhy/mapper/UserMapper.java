package com.dfbz.xbhy.mapper;

import com.dfbz.xbhy.entity.User;
import com.dfbz.xbhy.mapper.Impl.FocusNumMapperImpl;
import com.dfbz.xbhy.mapper.Impl.UserMapperImpl;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {

    @SelectProvider(type = UserMapperImpl.class,method = "LookUser")
    List<User> LookUser(Map<String, Object> params);

    @SelectProvider(type = FocusNumMapperImpl.class,method = "FocusNum")
    String FocusNum(String id);

}