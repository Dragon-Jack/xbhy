package com.dfbz.xbhy.mapper;

import com.dfbz.xbhy.entity.User;
import com.dfbz.xbhy.entity.UserFocus;
import com.dfbz.xbhy.mapper.Impl.UserFocusMapperImpl;
import com.dfbz.xbhy.mapper.Impl.UserMapperImpl;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@org.apache.ibatis.annotations.Mapper
public interface UserFocusMapper extends Mapper<UserFocus> {
    @SelectProvider(type = UserFocusMapperImpl.class,method = "attention")
    List<UserFocus> attention(String id);
}