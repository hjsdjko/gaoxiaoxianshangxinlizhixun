
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
 * 心理医生
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xinliyisheng")
public class XinliyishengController {
    private static final Logger logger = LoggerFactory.getLogger(XinliyishengController.class);

    private static final String TABLE_NAME = "xinliyisheng";

    @Autowired
    private XinliyishengService xinliyishengService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    @Autowired
    private XinliyishengCollectionService xinliyishengCollectionService;
    //级联表非注册的service
    //注册表service
    @Autowired
    private YonghuService yonghuService;


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
        params.put("xinliyishengDeleteStart",1);params.put("xinliyishengDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = xinliyishengService.queryPage(params);

        //字典表数据转换
        List<XinliyishengView> list =(List<XinliyishengView>)page.getList();
        for(XinliyishengView c:list){
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
        XinliyishengEntity xinliyisheng = xinliyishengService.selectById(id);
        if(xinliyisheng !=null){
            //entity转view
            XinliyishengView view = new XinliyishengView();
            BeanUtils.copyProperties( xinliyisheng , view );//把实体数据重构到view中
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
    public R save(@RequestBody XinliyishengEntity xinliyisheng, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xinliyisheng:{}",this.getClass().getName(),xinliyisheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<XinliyishengEntity> queryWrapper = new EntityWrapper<XinliyishengEntity>()
            .eq("username", xinliyisheng.getUsername())
            .andNew()
            .eq("xinliyisheng_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinliyishengEntity xinliyishengEntity = xinliyishengService.selectOne(queryWrapper);
        if(xinliyishengEntity==null){
            xinliyisheng.setXinliyishengDelete(1);
            xinliyisheng.setInsertTime(new Date());
            xinliyisheng.setCreateTime(new Date());
            xinliyisheng.setPassword("123456");
            xinliyishengService.insert(xinliyisheng);
            return R.ok();
        }else {
            return R.error(511,"账户已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XinliyishengEntity xinliyisheng, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,xinliyisheng:{}",this.getClass().getName(),xinliyisheng.toString());
        XinliyishengEntity oldXinliyishengEntity = xinliyishengService.selectById(xinliyisheng.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<XinliyishengEntity> queryWrapper = new EntityWrapper<XinliyishengEntity>()
            .notIn("id",xinliyisheng.getId())
            .andNew()
            .eq("username", xinliyisheng.getUsername())
            .andNew()
            .eq("xinliyisheng_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinliyishengEntity xinliyishengEntity = xinliyishengService.selectOne(queryWrapper);
        if("".equals(xinliyisheng.getXinliyishengPhoto()) || "null".equals(xinliyisheng.getXinliyishengPhoto())){
                xinliyisheng.setXinliyishengPhoto(null);
        }
        if(xinliyishengEntity==null){
            xinliyishengService.updateById(xinliyisheng);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<XinliyishengEntity> oldXinliyishengList =xinliyishengService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<XinliyishengEntity> list = new ArrayList<>();
        for(Integer id:ids){
            XinliyishengEntity xinliyishengEntity = new XinliyishengEntity();
            xinliyishengEntity.setId(id);
            xinliyishengEntity.setXinliyishengDelete(2);
            list.add(xinliyishengEntity);
        }
        if(list != null && list.size() >0){
            xinliyishengService.updateBatchById(list);
        }

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
            List<XinliyishengEntity> xinliyishengList = new ArrayList<>();//上传的东西
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
                            XinliyishengEntity xinliyishengEntity = new XinliyishengEntity();
//                            xinliyishengEntity.setUsername(data.get(0));                    //账户 要改的
//                            //xinliyishengEntity.setPassword("123456");//密码
//                            xinliyishengEntity.setXinliyishengName(data.get(0));                    //心理医生名称 要改的
//                            xinliyishengEntity.setXinliyishengTypes(Integer.valueOf(data.get(0)));   //心理医生类型 要改的
//                            xinliyishengEntity.setXinliyishengPhoto("");//详情和图片
//                            xinliyishengEntity.setXinliyishengJiuzhi(data.get(0));                    //就职点 要改的
//                            xinliyishengEntity.setXinliyishengZhugong(data.get(0));                    //主攻方向 要改的
//                            xinliyishengEntity.setXinliyishengZhiwei(data.get(0));                    //职位 要改的
//                            xinliyishengEntity.setXinliyishengContent("");//详情和图片
//                            xinliyishengEntity.setXinliyishengDelete(1);//逻辑删除字段
//                            xinliyishengEntity.setInsertTime(date);//时间
//                            xinliyishengEntity.setCreateTime(date);//时间
                            xinliyishengList.add(xinliyishengEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<XinliyishengEntity> xinliyishengEntities_username = xinliyishengService.selectList(new EntityWrapper<XinliyishengEntity>().in("username", seachFields.get("username")).eq("xinliyisheng_delete", 1));
                        if(xinliyishengEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(XinliyishengEntity s:xinliyishengEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        xinliyishengService.insertBatch(xinliyishengList);
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
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        XinliyishengEntity xinliyisheng = xinliyishengService.selectOne(new EntityWrapper<XinliyishengEntity>().eq("username", username));
        if(xinliyisheng==null || !xinliyisheng.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(xinliyisheng.getXinliyishengDelete() != 1)
            return R.error("账户已被删除");
        String token = tokenService.generateToken(xinliyisheng.getId(),username, "xinliyisheng", "心理医生");
        R r = R.ok();
        r.put("token", token);
        r.put("role","心理医生");
        r.put("username",xinliyisheng.getXinliyishengName());
        r.put("tableName","xinliyisheng");
        r.put("userId",xinliyisheng.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody XinliyishengEntity xinliyisheng, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<XinliyishengEntity> queryWrapper = new EntityWrapper<XinliyishengEntity>()
            .eq("username", xinliyisheng.getUsername())
            .andNew()
            .eq("xinliyisheng_delete", 1)
            ;
        XinliyishengEntity xinliyishengEntity = xinliyishengService.selectOne(queryWrapper);
        if(xinliyishengEntity != null)
            return R.error("账户已经被使用");
        xinliyisheng.setXinliyishengDelete(1);
        xinliyisheng.setInsertTime(new Date());
        xinliyisheng.setCreateTime(new Date());
        xinliyishengService.insert(xinliyisheng);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        XinliyishengEntity xinliyisheng = xinliyishengService.selectById(id);
        xinliyisheng.setPassword("123456");
        xinliyishengService.updateById(xinliyisheng);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        XinliyishengEntity xinliyisheng = xinliyishengService.selectOne(new EntityWrapper<XinliyishengEntity>().eq("username", username));
        if(xinliyisheng!=null){
            xinliyisheng.setPassword("123456");
            boolean b = xinliyishengService.updateById(xinliyisheng);
            if(!b){
               return R.error();
            }
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrXinliyisheng(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        XinliyishengEntity xinliyisheng = xinliyishengService.selectById(id);
        if(xinliyisheng !=null){
            //entity转view
            XinliyishengView view = new XinliyishengView();
            BeanUtils.copyProperties( xinliyisheng , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }


    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<XinliyishengView> returnXinliyishengViewList = new ArrayList<>();

        //查看收藏
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        PageUtils pageUtils = xinliyishengCollectionService.queryPage(params1);
        List<XinliyishengCollectionView> collectionViewsList =(List<XinliyishengCollectionView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(XinliyishengCollectionView collectionView:collectionViewsList){
            Integer xinliyishengTypes = collectionView.getXinliyishengTypes();
            if(typeMap.containsKey(xinliyishengTypes)){
                typeMap.put(xinliyishengTypes,typeMap.get(xinliyishengTypes)+1);
            }else{
                typeMap.put(xinliyishengTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("xinliyishengTypes",type);
            PageUtils pageUtils1 = xinliyishengService.queryPage(params2);
            List<XinliyishengView> xinliyishengViewList =(List<XinliyishengView>)pageUtils1.getList();
            returnXinliyishengViewList.addAll(xinliyishengViewList);
            if(returnXinliyishengViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = xinliyishengService.queryPage(params);
        if(returnXinliyishengViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnXinliyishengViewList.size();//要添加的数量
            List<XinliyishengView> xinliyishengViewList =(List<XinliyishengView>)page.getList();
            for(XinliyishengView xinliyishengView:xinliyishengViewList){
                Boolean addFlag = true;
                for(XinliyishengView returnXinliyishengView:returnXinliyishengViewList){
                    if(returnXinliyishengView.getId().intValue() ==xinliyishengView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnXinliyishengViewList.add(xinliyishengView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnXinliyishengViewList = returnXinliyishengViewList.subList(0, limit);
        }

        for(XinliyishengView c:returnXinliyishengViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnXinliyishengViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = xinliyishengService.queryPage(params);

        //字典表数据转换
        List<XinliyishengView> list =(List<XinliyishengView>)page.getList();
        for(XinliyishengView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XinliyishengEntity xinliyisheng = xinliyishengService.selectById(id);
            if(xinliyisheng !=null){


                //entity转view
                XinliyishengView view = new XinliyishengView();
                BeanUtils.copyProperties( xinliyisheng , view );//把实体数据重构到view中

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
    public R add(@RequestBody XinliyishengEntity xinliyisheng, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,xinliyisheng:{}",this.getClass().getName(),xinliyisheng.toString());
        Wrapper<XinliyishengEntity> queryWrapper = new EntityWrapper<XinliyishengEntity>()
            .eq("username", xinliyisheng.getUsername())
            .andNew()
            .eq("xinliyisheng_delete", 1)
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XinliyishengEntity xinliyishengEntity = xinliyishengService.selectOne(queryWrapper);
        if(xinliyishengEntity==null){
            xinliyisheng.setXinliyishengDelete(1);
            xinliyisheng.setInsertTime(new Date());
            xinliyisheng.setCreateTime(new Date());
        xinliyisheng.setPassword("123456");
        xinliyishengService.insert(xinliyisheng);

            return R.ok();
        }else {
            return R.error(511,"账户已经被使用");
        }
    }

}
