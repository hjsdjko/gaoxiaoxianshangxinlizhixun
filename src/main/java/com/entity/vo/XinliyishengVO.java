package com.entity.vo;

import com.entity.XinliyishengEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 心理医生
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xinliyisheng")
public class XinliyishengVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 心理医生名称
     */

    @TableField(value = "xinliyisheng_name")
    private String xinliyishengName;


    /**
     * 心理医生类型
     */

    @TableField(value = "xinliyisheng_types")
    private Integer xinliyishengTypes;


    /**
     * 头像
     */

    @TableField(value = "xinliyisheng_photo")
    private String xinliyishengPhoto;


    /**
     * 就职点
     */

    @TableField(value = "xinliyisheng_jiuzhi")
    private String xinliyishengJiuzhi;


    /**
     * 主攻方向
     */

    @TableField(value = "xinliyisheng_zhugong")
    private String xinliyishengZhugong;


    /**
     * 职位
     */

    @TableField(value = "xinliyisheng_zhiwei")
    private String xinliyishengZhiwei;


    /**
     * 心理医生简介
     */

    @TableField(value = "xinliyisheng_content")
    private String xinliyishengContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "xinliyisheng_delete")
    private Integer xinliyishengDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow homeMain
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：心理医生名称
	 */
    public String getXinliyishengName() {
        return xinliyishengName;
    }


    /**
	 * 获取：心理医生名称
	 */

    public void setXinliyishengName(String xinliyishengName) {
        this.xinliyishengName = xinliyishengName;
    }
    /**
	 * 设置：心理医生类型
	 */
    public Integer getXinliyishengTypes() {
        return xinliyishengTypes;
    }


    /**
	 * 获取：心理医生类型
	 */

    public void setXinliyishengTypes(Integer xinliyishengTypes) {
        this.xinliyishengTypes = xinliyishengTypes;
    }
    /**
	 * 设置：头像
	 */
    public String getXinliyishengPhoto() {
        return xinliyishengPhoto;
    }


    /**
	 * 获取：头像
	 */

    public void setXinliyishengPhoto(String xinliyishengPhoto) {
        this.xinliyishengPhoto = xinliyishengPhoto;
    }
    /**
	 * 设置：就职点
	 */
    public String getXinliyishengJiuzhi() {
        return xinliyishengJiuzhi;
    }


    /**
	 * 获取：就职点
	 */

    public void setXinliyishengJiuzhi(String xinliyishengJiuzhi) {
        this.xinliyishengJiuzhi = xinliyishengJiuzhi;
    }
    /**
	 * 设置：主攻方向
	 */
    public String getXinliyishengZhugong() {
        return xinliyishengZhugong;
    }


    /**
	 * 获取：主攻方向
	 */

    public void setXinliyishengZhugong(String xinliyishengZhugong) {
        this.xinliyishengZhugong = xinliyishengZhugong;
    }
    /**
	 * 设置：职位
	 */
    public String getXinliyishengZhiwei() {
        return xinliyishengZhiwei;
    }


    /**
	 * 获取：职位
	 */

    public void setXinliyishengZhiwei(String xinliyishengZhiwei) {
        this.xinliyishengZhiwei = xinliyishengZhiwei;
    }
    /**
	 * 设置：心理医生简介
	 */
    public String getXinliyishengContent() {
        return xinliyishengContent;
    }


    /**
	 * 获取：心理医生简介
	 */

    public void setXinliyishengContent(String xinliyishengContent) {
        this.xinliyishengContent = xinliyishengContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getXinliyishengDelete() {
        return xinliyishengDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setXinliyishengDelete(Integer xinliyishengDelete) {
        this.xinliyishengDelete = xinliyishengDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
