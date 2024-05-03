
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
 * 心理医生咨询
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xinliyishengChat")
public class XinliyishengChatController {
    private static final Logger logger = LoggerFactory.getLogger(XinliyishengChatController.class);

    private static final String TABLE_NAME = "xinliyishengChat";

    @Autowired
    private XinliyishengChatService xinliyishengChatService;


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
        PageUtils page = xinliyishengChatService.queryPage(params);

        //字典表数据转换
        List<XinliyishengChatView> list =(List<XinliyishengChatView>)page.getList();
        for(XinliyishengChatView c:list){
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
        XinliyishengChatEntity xinliyishengChat = xinliyishengChatService.selectById(id);
        if(xinliyishengChat !=null){
            //entity转view
            XinliyishengChatView view = new XinliyishengChatView();
            BeanUtils.copyProperties( xinliyishengChat , view );//把实体数据重构到view中
            //级联表 心理医生
            //级联表
            XinliyishengEntity xinliyisheng = xinliyishengService.selectById(xinliyishengChat.getXinliyishengId());
            if(xinliyisheng != null){
            BeanUtils.copyProperties( xinliyisheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "xinliyishengId"
, "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setXinliyishengId(xinliyisheng.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(xinliyishengChat.getYonghuId());
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
    public R save(@RequestBody XinliyishengChatEntity xinliyishengChat, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xinliyishengChat:{}",this.getClass().getName(),xinliyishengChat.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("心理医生".equals(role))
            xinliyishengChat.setXinliyishengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("用户".equals(role))
            xinliyishengChat.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XinliyishengChatEntity> queryWrapper = new EntityWrapper<XinliyishengChatEntity>()
            .eq("yonghu_id", xinliyishengChat.getYonghuId())
            .eq("xinliyisheng_id", xinliyishengChat.getXinliyishengId())
            .eq("zhuangtai_types", xinliyishengChat.getZhuangtaiTypes())
            .eq("xinliyisheng_chat_types", xinliyishengChat.getXinliyishengChatTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinliyishengChatEntity xinliyishengChatEntity = xinliyishengChatService.selectOne(queryWrapper);
        if(xinliyishengChatEntity==null){
            xinliyishengChat.setInsertTime(new Date());
            xinliyishengChat.setCreateTime(new Date());
            xinliyishengChatService.insert(xinliyishengChat);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XinliyishengChatEntity xinliyishengChat, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xinliyishengChat:{}",this.getClass().getName(),xinliyishengChat.toString());
        XinliyishengChatEntity oldXinliyishengChatEntity = xinliyishengChatService.selectById(xinliyishengChat.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("心理医生".equals(role))
//            xinliyishengChat.setXinliyishengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("用户".equals(role))
//            xinliyishengChat.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<XinliyishengChatEntity> queryWrapper = new EntityWrapper<XinliyishengChatEntity>()
            .notIn("id",xinliyishengChat.getId())
            .andNew()
            .eq("yonghu_id", xinliyishengChat.getYonghuId())
            .eq("xinliyisheng_id", xinliyishengChat.getXinliyishengId())
            .eq("zhuangtai_types", xinliyishengChat.getZhuangtaiTypes())
            .eq("xinliyisheng_chat_types", xinliyishengChat.getXinliyishengChatTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinliyishengChatEntity xinliyishengChatEntity = xinliyishengChatService.selectOne(queryWrapper);
        if(xinliyishengChatEntity==null){
            xinliyishengChatService.updateById(xinliyishengChat);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XinliyishengChatEntity> oldXinliyishengChatList =xinliyishengChatService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        xinliyishengChatService.deleteBatchIds(Arrays.asList(ids));

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
            List<XinliyishengChatEntity> xinliyishengChatList = new ArrayList<>();//上传的东西
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
                            XinliyishengChatEntity xinliyishengChatEntity = new XinliyishengChatEntity();
//                            xinliyishengChatEntity.setYonghuId(Integer.valueOf(data.get(0)));   //提问人 要改的
//                            xinliyishengChatEntity.setXinliyishengId(Integer.valueOf(data.get(0)));   //回答人 要改的
//                            xinliyishengChatEntity.setXinliyishengChatIssueText(data.get(0));                    //问题 要改的
//                            xinliyishengChatEntity.setIssueTime(sdf.parse(data.get(0)));          //问题时间 要改的
//                            xinliyishengChatEntity.setXinliyishengChatReplyText(data.get(0));                    //回复 要改的
//                            xinliyishengChatEntity.setReplyTime(sdf.parse(data.get(0)));          //回复时间 要改的
//                            xinliyishengChatEntity.setZhuangtaiTypes(Integer.valueOf(data.get(0)));   //状态 要改的
//                            xinliyishengChatEntity.setXinliyishengChatTypes(Integer.valueOf(data.get(0)));   //数据类型 要改的
//                            xinliyishengChatEntity.setInsertTime(date);//时间
//                            xinliyishengChatEntity.setCreateTime(date);//时间
                            xinliyishengChatList.add(xinliyishengChatEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        xinliyishengChatService.insertBatch(xinliyishengChatList);
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
        PageUtils page = xinliyishengChatService.queryPage(params);

        //字典表数据转换
        List<XinliyishengChatView> list =(List<XinliyishengChatView>)page.getList();
        for(XinliyishengChatView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XinliyishengChatEntity xinliyishengChat = xinliyishengChatService.selectById(id);
            if(xinliyishengChat !=null){


                //entity转view
                XinliyishengChatView view = new XinliyishengChatView();
                BeanUtils.copyProperties( xinliyishengChat , view );//把实体数据重构到view中

                //级联表
                    XinliyishengEntity xinliyisheng = xinliyishengService.selectById(xinliyishengChat.getXinliyishengId());
                if(xinliyisheng != null){
                    BeanUtils.copyProperties( xinliyisheng , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setXinliyishengId(xinliyisheng.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(xinliyishengChat.getYonghuId());
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
    public R add(@RequestBody XinliyishengChatEntity xinliyishengChat, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xinliyishengChat:{}",this.getClass().getName(),xinliyishengChat.toString());
        Wrapper<XinliyishengChatEntity> queryWrapper = new EntityWrapper<XinliyishengChatEntity>()
            .eq("yonghu_id", xinliyishengChat.getYonghuId())
            .eq("xinliyisheng_id", xinliyishengChat.getXinliyishengId())
            .eq("xinliyisheng_chat_issue_text", xinliyishengChat.getXinliyishengChatIssueText())
            .eq("xinliyisheng_chat_reply_text", xinliyishengChat.getXinliyishengChatReplyText())
            .eq("zhuangtai_types", xinliyishengChat.getZhuangtaiTypes())
            .eq("xinliyisheng_chat_types", xinliyishengChat.getXinliyishengChatTypes())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinliyishengChatEntity xinliyishengChatEntity = xinliyishengChatService.selectOne(queryWrapper);
        if(xinliyishengChatEntity==null){
            xinliyishengChat.setInsertTime(new Date());
            xinliyishengChat.setCreateTime(new Date());
        xinliyishengChatService.insert(xinliyishengChat);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}
