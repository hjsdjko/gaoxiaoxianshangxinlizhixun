package com.entity.model;

import com.entity.XinliyishengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 心理医生
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XinliyishengModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 心理医生名称
     */
    private String xinliyishengName;


    /**
     * 心理医生类型
     */
    private Integer xinliyishengTypes;


    /**
     * 头像
     */
    private String xinliyishengPhoto;


    /**
     * 就职点
     */
    private String xinliyishengJiuzhi;


    /**
     * 主攻方向
     */
    private String xinliyishengZhugong;


    /**
     * 职位
     */
    private String xinliyishengZhiwei;


    /**
     * 心理医生简介
     */
    private String xinliyishengContent;


    /**
     * 逻辑删除
     */
    private Integer xinliyishengDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow homeMain
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：心理医生名称
	 */
    public String getXinliyishengName() {
        return xinliyishengName;
    }


    /**
	 * 设置：心理医生名称
	 */
    public void setXinliyishengName(String xinliyishengName) {
        this.xinliyishengName = xinliyishengName;
    }
    /**
	 * 获取：心理医生类型
	 */
    public Integer getXinliyishengTypes() {
        return xinliyishengTypes;
    }


    /**
	 * 设置：心理医生类型
	 */
    public void setXinliyishengTypes(Integer xinliyishengTypes) {
        this.xinliyishengTypes = xinliyishengTypes;
    }
    /**
	 * 获取：头像
	 */
    public String getXinliyishengPhoto() {
        return xinliyishengPhoto;
    }


    /**
	 * 设置：头像
	 */
    public void setXinliyishengPhoto(String xinliyishengPhoto) {
        this.xinliyishengPhoto = xinliyishengPhoto;
    }
    /**
	 * 获取：就职点
	 */
    public String getXinliyishengJiuzhi() {
        return xinliyishengJiuzhi;
    }


    /**
	 * 设置：就职点
	 */
    public void setXinliyishengJiuzhi(String xinliyishengJiuzhi) {
        this.xinliyishengJiuzhi = xinliyishengJiuzhi;
    }
    /**
	 * 获取：主攻方向
	 */
    public String getXinliyishengZhugong() {
        return xinliyishengZhugong;
    }


    /**
	 * 设置：主攻方向
	 */
    public void setXinliyishengZhugong(String xinliyishengZhugong) {
        this.xinliyishengZhugong = xinliyishengZhugong;
    }
    /**
	 * 获取：职位
	 */
    public String getXinliyishengZhiwei() {
        return xinliyishengZhiwei;
    }


    /**
	 * 设置：职位
	 */
    public void setXinliyishengZhiwei(String xinliyishengZhiwei) {
        this.xinliyishengZhiwei = xinliyishengZhiwei;
    }
    /**
	 * 获取：心理医生简介
	 */
    public String getXinliyishengContent() {
        return xinliyishengContent;
    }


    /**
	 * 设置：心理医生简介
	 */
    public void setXinliyishengContent(String xinliyishengContent) {
        this.xinliyishengContent = xinliyishengContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getXinliyishengDelete() {
        return xinliyishengDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setXinliyishengDelete(Integer xinliyishengDelete) {
        this.xinliyishengDelete = xinliyishengDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：录入时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
