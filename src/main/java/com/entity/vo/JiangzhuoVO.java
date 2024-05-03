package com.entity.vo;

import com.entity.JiangzhuoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 讲座信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiangzhuo")
public class JiangzhuoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 讲座标题
     */

    @TableField(value = "jiangzhuo_name")
    private String jiangzhuoName;


    /**
     * 讲座类型
     */

    @TableField(value = "jiangzhuo_types")
    private Integer jiangzhuoTypes;


    /**
     * 封面
     */

    @TableField(value = "jiangzhuo_photo")
    private String jiangzhuoPhoto;


    /**
     * 讲座时长
     */

    @TableField(value = "jiangzhuo_shichang")
    private String jiangzhuoShichang;


    /**
     * 开始时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jiangzhuo_time")
    private Date jiangzhuoTime;


    /**
     * 讲座地址
     */

    @TableField(value = "jiangzhuo_address")
    private String jiangzhuoAddress;


    /**
     * 讲座简介
     */

    @TableField(value = "jiangzhuo_content")
    private String jiangzhuoContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "jiangzhuo_delete")
    private Integer jiangzhuoDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：讲座标题
	 */
    public String getJiangzhuoName() {
        return jiangzhuoName;
    }


    /**
	 * 获取：讲座标题
	 */

    public void setJiangzhuoName(String jiangzhuoName) {
        this.jiangzhuoName = jiangzhuoName;
    }
    /**
	 * 设置：讲座类型
	 */
    public Integer getJiangzhuoTypes() {
        return jiangzhuoTypes;
    }


    /**
	 * 获取：讲座类型
	 */

    public void setJiangzhuoTypes(Integer jiangzhuoTypes) {
        this.jiangzhuoTypes = jiangzhuoTypes;
    }
    /**
	 * 设置：封面
	 */
    public String getJiangzhuoPhoto() {
        return jiangzhuoPhoto;
    }


    /**
	 * 获取：封面
	 */

    public void setJiangzhuoPhoto(String jiangzhuoPhoto) {
        this.jiangzhuoPhoto = jiangzhuoPhoto;
    }
    /**
	 * 设置：讲座时长
	 */
    public String getJiangzhuoShichang() {
        return jiangzhuoShichang;
    }


    /**
	 * 获取：讲座时长
	 */

    public void setJiangzhuoShichang(String jiangzhuoShichang) {
        this.jiangzhuoShichang = jiangzhuoShichang;
    }
    /**
	 * 设置：开始时间
	 */
    public Date getJiangzhuoTime() {
        return jiangzhuoTime;
    }


    /**
	 * 获取：开始时间
	 */

    public void setJiangzhuoTime(Date jiangzhuoTime) {
        this.jiangzhuoTime = jiangzhuoTime;
    }
    /**
	 * 设置：讲座地址
	 */
    public String getJiangzhuoAddress() {
        return jiangzhuoAddress;
    }


    /**
	 * 获取：讲座地址
	 */

    public void setJiangzhuoAddress(String jiangzhuoAddress) {
        this.jiangzhuoAddress = jiangzhuoAddress;
    }
    /**
	 * 设置：讲座简介
	 */
    public String getJiangzhuoContent() {
        return jiangzhuoContent;
    }


    /**
	 * 获取：讲座简介
	 */

    public void setJiangzhuoContent(String jiangzhuoContent) {
        this.jiangzhuoContent = jiangzhuoContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getJiangzhuoDelete() {
        return jiangzhuoDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setJiangzhuoDelete(Integer jiangzhuoDelete) {
        this.jiangzhuoDelete = jiangzhuoDelete;
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
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
