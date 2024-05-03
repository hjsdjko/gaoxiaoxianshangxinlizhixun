package com.dao;

import com.entity.XinliyishengChatEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XinliyishengChatView;

/**
 * 心理医生咨询 Dao 接口
 *
 * @author 
 */
public interface XinliyishengChatDao extends BaseMapper<XinliyishengChatEntity> {

   List<XinliyishengChatView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
