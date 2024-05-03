
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 心理医生预约
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xinliyishengYuyue")
public class XinliyishengYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(XinliyishengYuyueController.class);

    private static final String TABLE_NAME = "xinliyishengYuyue";

    @Autowired
    private XinliyishengYuyueService xinliyishengYuyueService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表非注册的service
    //注册表service
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private XinliyishengService xinliyishengService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("心理医生".equals(role))
            params.put("xinliyishengId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = xinliyishengYuyueService.queryPage(params);

        //字典表数据转换
        List<XinliyishengYuyueView> list =(List<XinliyishengYuyueView>)page.getList();
        for(XinliyishengYuyueView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XinliyishengYuyueEntity xinliyishengYuyue = xinliyishengYuyueService.selectById(id);
        if(xinliyishengYuyue !=null){
            //entity转view
            XinliyishengYuyueView view = new XinliyishengYuyueView();
            BeanUtils.copyProperties( xinliyishengYuyue , view );//把实体数据重构到view中
            //级联表 心理医生
            //级联表
            XinliyishengEntity xinliyisheng = xinliyishengService.selectById(xinliyishengYuyue.getXinliyishengId());
            if(xinliyisheng != null){
            BeanUtils.copyProperties( xinliyisheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "xinliyishengId"
, "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setXinliyishengId(xinliyisheng.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(xinliyishengYuyue.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "xinliyishengId"
, "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XinliyishengYuyueEntity xinliyishengYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xinliyishengYuyue:{}",this.getClass().getName(),xinliyishengYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("心理医生".equals(role))
            xinliyishengYuyue.setXinliyishengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("用户".equals(role))
            xinliyishengYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XinliyishengYuyueEntity> queryWrapper = new EntityWrapper<XinliyishengYuyueEntity>()
            .eq("xinliyisheng_id", xinliyishengYuyue.getXinliyishengId())
            .eq("yonghu_id", xinliyishengYuyue.getYonghuId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinliyishengYuyueEntity xinliyishengYuyueEntity = xinliyishengYuyueService.selectOne(queryWrapper);
        if(xinliyishengYuyueEntity==null){
            xinliyishengYuyue.setXinliyishengYuyueYesnoTypes(1);
            xinliyishengYuyue.setInsertTime(new Date());
            xinliyishengYuyue.setCreateTime(new Date());
            xinliyishengYuyueService.insert(xinliyishengYuyue);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XinliyishengYuyueEntity xinliyishengYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xinliyishengYuyue:{}",this.getClass().getName(),xinliyishengYuyue.toString());
        XinliyishengYuyueEntity oldXinliyishengYuyueEntity = xinliyishengYuyueService.selectById(xinliyishengYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("心理医生".equals(role))
//            xinliyishengYuyue.setXinliyishengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("用户".equals(role))
//            xinliyishengYuyue.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<XinliyishengYuyueEntity> queryWrapper = new EntityWrapper<XinliyishengYuyueEntity>()
            .notIn("id",xinliyishengYuyue.getId())
            .andNew()
            .eq("xinliyisheng_id", xinliyishengYuyue.getXinliyishengId())
            .eq("yonghu_id", xinliyishengYuyue.getYonghuId())
            .eq("xinliyisheng_yuyue_time", xinliyishengYuyue.getXinliyishengYuyueTime())
            .eq("insert_time", xinliyishengYuyue.getInsertTime())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinliyishengYuyueEntity xinliyishengYuyueEntity = xinliyishengYuyueService.selectOne(queryWrapper);
        if(xinliyishengYuyueEntity==null){
            xinliyishengYuyueService.updateById(xinliyishengYuyue);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody XinliyishengYuyueEntity xinliyishengYuyueEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,xinliyishengYuyueEntity:{}",this.getClass().getName(),xinliyishengYuyueEntity.toString());

        XinliyishengYuyueEntity oldXinliyishengYuyue = xinliyishengYuyueService.selectById(xinliyishengYuyueEntity.getId());//查询原先数据

//        if(xinliyishengYuyueEntity.getXinliyishengYuyueYesnoTypes() == 2){//通过
//            xinliyishengYuyueEntity.setXinliyishengYuyueTypes();
//        }else if(xinliyishengYuyueEntity.getXinliyishengYuyueYesnoTypes() == 3){//拒绝
//            xinliyishengYuyueEntity.setXinliyishengYuyueTypes();
//        }
        xinliyishengYuyueService.updateById(xinliyishengYuyueEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XinliyishengYuyueEntity> oldXinliyishengYuyueList =xinliyishengYuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        xinliyishengYuyueService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<XinliyishengYuyueEntity> xinliyishengYuyueList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            XinliyishengYuyueEntity xinliyishengYuyueEntity = new XinliyishengYuyueEntity();
//                            xinliyishengYuyueEntity.setXinliyishengId(Integer.valueOf(data.get(0)));   //心理医生 要改的
//                            xinliyishengYuyueEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            xinliyishengYuyueEntity.setXinliyishengYuyueText(data.get(0));                    //预约原因 要改的
//                            xinliyishengYuyueEntity.setXinliyishengYuyueTime(sdf.parse(data.get(0)));          //预约时间 要改的
//                            xinliyishengYuyueEntity.setXinliyishengYuyueYesnoTypes(Integer.valueOf(data.get(0)));   //预约状态 要改的
//                            xinliyishengYuyueEntity.setXinliyishengYuyueYesnoText(data.get(0));                    //审核回复 要改的
//                            xinliyishengYuyueEntity.setInsertTime(date);//时间
//                            xinliyishengYuyueEntity.setCreateTime(date);//时间
                            xinliyishengYuyueList.add(xinliyishengYuyueEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        xinliyishengYuyueService.insertBatch(xinliyishengYuyueList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = xinliyishengYuyueService.queryPage(params);

        //字典表数据转换
        List<XinliyishengYuyueView> list =(List<XinliyishengYuyueView>)page.getList();
        for(XinliyishengYuyueView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XinliyishengYuyueEntity xinliyishengYuyue = xinliyishengYuyueService.selectById(id);
            if(xinliyishengYuyue !=null){


                //entity转view
                XinliyishengYuyueView view = new XinliyishengYuyueView();
                BeanUtils.copyProperties( xinliyishengYuyue , view );//把实体数据重构到view中

                //级联表
                    XinliyishengEntity xinliyisheng = xinliyishengService.selectById(xinliyishengYuyue.getXinliyishengId());
                if(xinliyisheng != null){
                    BeanUtils.copyProperties( xinliyisheng , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXinliyishengId(xinliyisheng.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(xinliyishengYuyue.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody XinliyishengYuyueEntity xinliyishengYuyue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xinliyishengYuyue:{}",this.getClass().getName(),xinliyishengYuyue.toString());
        Wrapper<XinliyishengYuyueEntity> queryWrapper = new EntityWrapper<XinliyishengYuyueEntity>()
            .eq("xinliyisheng_id", xinliyishengYuyue.getXinliyishengId())
            .eq("yonghu_id", xinliyishengYuyue.getYonghuId())
            .eq("xinliyisheng_yuyue_text", xinliyishengYuyue.getXinliyishengYuyueText())
            .eq("xinliyisheng_yuyue_yesno_types", xinliyishengYuyue.getXinliyishengYuyueYesnoTypes())
            .eq("xinliyisheng_yuyue_yesno_text", xinliyishengYuyue.getXinliyishengYuyueYesnoText())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinliyishengYuyueEntity xinliyishengYuyueEntity = xinliyishengYuyueService.selectOne(queryWrapper);
        if(xinliyishengYuyueEntity==null){
            xinliyishengYuyue.setXinliyishengYuyueYesnoTypes(1);
            xinliyishengYuyue.setInsertTime(new Date());
            xinliyishengYuyue.setCreateTime(new Date());
        xinliyishengYuyueService.insert(xinliyishengYuyue);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}
