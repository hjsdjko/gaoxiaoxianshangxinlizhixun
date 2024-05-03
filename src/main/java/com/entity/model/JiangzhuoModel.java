package com.entity.model;

import com.entity.JiangzhuoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 讲座信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiangzhuoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 讲座标题
     */
    private String jiangzhuoName;


    /**
     * 讲座类型
     */
    private Integer jiangzhuoTypes;


    /**
     * 封面
     */
    private String jiangzhuoPhoto;


    /**
     * 讲座时长
     */
    private String jiangzhuoShichang;


    /**
     * 开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jiangzhuoTime;


    /**
     * 讲座地址
     */
    private String jiangzhuoAddress;


    /**
     * 讲座简介
     */
    private String jiangzhuoContent;


    /**
     * 逻辑删除
     */
    private Integer jiangzhuoDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：讲座标题
	 */
    public String getJiangzhuoName() {
        return jiangzhuoName;
    }


    /**
	 * 设置：讲座标题
	 */
    public void setJiangzhuoName(String jiangzhuoName) {
        this.jiangzhuoName = jiangzhuoName;
    }
    /**
	 * 获取：讲座类型
	 */
    public Integer getJiangzhuoTypes() {
        return jiangzhuoTypes;
    }


    /**
	 * 设置：讲座类型
	 */
    public void setJiangzhuoTypes(Integer jiangzhuoTypes) {
        this.jiangzhuoTypes = jiangzhuoTypes;
    }
    /**
	 * 获取：封面
	 */
    public String getJiangzhuoPhoto() {
        return jiangzhuoPhoto;
    }


    /**
	 * 设置：封面
	 */
    public void setJiangzhuoPhoto(String jiangzhuoPhoto) {
        this.jiangzhuoPhoto = jiangzhuoPhoto;
    }
    /**
	 * 获取：讲座时长
	 */
    public String getJiangzhuoShichang() {
        return jiangzhuoShichang;
    }


    /**
	 * 设置：讲座时长
	 */
    public void setJiangzhuoShichang(String jiangzhuoShichang) {
        this.jiangzhuoShichang = jiangzhuoShichang;
    }
    /**
	 * 获取：开始时间
	 */
    public Date getJiangzhuoTime() {
        return jiangzhuoTime;
    }


    /**
	 * 设置：开始时间
	 */
    public void setJiangzhuoTime(Date jiangzhuoTime) {
        this.jiangzhuoTime = jiangzhuoTime;
    }
    /**
	 * 获取：讲座地址
	 */
    public String getJiangzhuoAddress() {
        return jiangzhuoAddress;
    }


    /**
	 * 设置：讲座地址
	 */
    public void setJiangzhuoAddress(String jiangzhuoAddress) {
        this.jiangzhuoAddress = jiangzhuoAddress;
    }
    /**
	 * 获取：讲座简介
	 */
    public String getJiangzhuoContent() {
        return jiangzhuoContent;
    }


    /**
	 * 设置：讲座简介
	 */
    public void setJiangzhuoContent(String jiangzhuoContent) {
        this.jiangzhuoContent = jiangzhuoContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJiangzhuoDelete() {
        return jiangzhuoDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setJiangzhuoDelete(Integer jiangzhuoDelete) {
        this.jiangzhuoDelete = jiangzhuoDelete;
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
