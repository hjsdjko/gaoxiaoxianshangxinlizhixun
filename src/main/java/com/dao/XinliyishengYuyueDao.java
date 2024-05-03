package com.dao;

import com.entity.XinliyishengYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XinliyishengYuyueView;

/**
 * 心理医生预约 Dao 接口
 *
 * @author 
 */
public interface XinliyishengYuyueDao extends BaseMapper<XinliyishengYuyueEntity> {

   List<XinliyishengYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
