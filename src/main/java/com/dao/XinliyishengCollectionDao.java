package com.dao;

import com.entity.XinliyishengCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.XinliyishengCollectionView;

/**
 * 心理医生收藏 Dao 接口
 *
 * @author 
 */
public interface XinliyishengCollectionDao extends BaseMapper<XinliyishengCollectionEntity> {

   List<XinliyishengCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
