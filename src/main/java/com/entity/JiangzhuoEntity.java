package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 讲座信息
 *
 * @author 
 * @email
 */
@TableName("jiangzhuo")
public class JiangzhuoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiangzhuoEntity() {

	}

	public JiangzhuoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 讲座标题
     */
    @ColumnInfo(comment="讲座标题",type="varchar(200)")
    @TableField(value = "jiangzhuo_name")

    private String jiangzhuoName;


    /**
     * 讲座类型
     */
    @ColumnInfo(comment="讲座类型",type="int(11)")
    @TableField(value = "jiangzhuo_types")

    private Integer jiangzhuoTypes;


    /**
     * 封面
     */
    @ColumnInfo(comment="封面",type="varchar(200)")
    @TableField(value = "jiangzhuo_photo")

    private String jiangzhuoPhoto;


    /**
     * 讲座时长
     */
    @ColumnInfo(comment="讲座时长",type="varchar(200)")
    @TableField(value = "jiangzhuo_shichang")

    private String jiangzhuoShichang;


    /**
     * 开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="开始时间",type="timestamp")
    @TableField(value = "jiangzhuo_time")

    private Date jiangzhuoTime;


    /**
     * 讲座地址
     */
    @ColumnInfo(comment="讲座地址",type="varchar(200)")
    @TableField(value = "jiangzhuo_address")

    private String jiangzhuoAddress;


    /**
     * 讲座简介
     */
    @ColumnInfo(comment="讲座简介",type="text")
    @TableField(value = "jiangzhuo_content")

    private String jiangzhuoContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "jiangzhuo_delete")

    private Integer jiangzhuoDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jiangzhuo{" +
            ", id=" + id +
            ", jiangzhuoName=" + jiangzhuoName +
            ", jiangzhuoTypes=" + jiangzhuoTypes +
            ", jiangzhuoPhoto=" + jiangzhuoPhoto +
            ", jiangzhuoShichang=" + jiangzhuoShichang +
            ", jiangzhuoTime=" + DateUtil.convertString(jiangzhuoTime,"yyyy-MM-dd") +
            ", jiangzhuoAddress=" + jiangzhuoAddress +
            ", jiangzhuoContent=" + jiangzhuoContent +
            ", jiangzhuoDelete=" + jiangzhuoDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
