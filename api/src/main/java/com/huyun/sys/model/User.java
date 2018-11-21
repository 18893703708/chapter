package com.huyun.sys.model;

import com.huyun.base.model.BaseModel;
import com.huyun.group.AddGroup;
import com.huyun.group.UpdateGroup;
import org.hibernate.validator.constraints.Length;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.GroupSequence;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Table(name = "sys_user")
@GroupSequence({AddGroup.class, UpdateGroup.class,User.class})//先验证AddGroup分组，如果有错误立即返回而不会验证UpdateGroup分组，接着如果AddGroup分组验证通过了，那么才去验证UpdateGroup分组，最后指定User.class表示那些没有分组的在最后。
public class User extends BaseModel {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer userId;


    @NotBlank(message="帐号不能为空",groups = {AddGroup.class})
    @Length(min = 5, max = 20, message = "长度为5-20", groups = {UpdateGroup.class})
    private String username;
    @NotBlank(message="密码不能为空")
    private String password;
    private String imgUrl;
    private String email;
    private String mobile;
    private Integer status;
    private Date createTime;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
