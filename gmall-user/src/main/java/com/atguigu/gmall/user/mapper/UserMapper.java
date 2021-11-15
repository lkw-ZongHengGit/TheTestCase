package com.atguigu.gmall.user.mapper;

import com.atguigu.gmall.user.bean.UmsMember;
import com.atguigu.gmall.user.bean.WareInfo;
import tk.mybatis.mapper.common.Mapper;


import java.util.List;

public interface UserMapper extends Mapper<UmsMember> {

    String getUser();

    List<UmsMember> selectAllUser();

    Integer insertWareInfo(WareInfo wareInfo);
}
