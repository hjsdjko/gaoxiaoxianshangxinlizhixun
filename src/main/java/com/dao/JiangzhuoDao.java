package com.dao;

import com.entity.JiangzhuoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiangzhuoView;

/**
 * 讲座信息 Dao 接口
 *
 * @author 
 */
public interface JiangzhuoDao extends BaseMapper<JiangzhuoEntity> {

   List<JiangzhuoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
