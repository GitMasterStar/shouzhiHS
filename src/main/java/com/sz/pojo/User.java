package com.sz.pojo;

import java.util.Date;

public class User {
    private Integer userid;

    private String username;

    private String userpwd;

    private String userrealname;

    private Date createdate;

    private Date updatedate;

    private Integer deptid;

    private Integer leaderid;

    private String email;

    private String phone;

    private String remark;

    private String standby;

    private String createuser;

    private String updateuser;

    private Integer valid;

    private String salt;

    public User(Integer userid, String username, String userpwd, String userrealname, Date createdate, Date updatedate, Integer deptid, Integer leaderid, String email, String phone, String remark, String standby, String createuser, String updateuser, Integer valid, String salt) {
        this.userid = userid;
        this.username = username;
        this.userpwd = userpwd;
        this.userrealname = userrealname;
        this.createdate = createdate;
        this.updatedate = updatedate;
        this.deptid = deptid;
        this.leaderid = leaderid;
        this.email = email;
        this.phone = phone;
        this.remark = remark;
        this.standby = standby;
        this.createuser = createuser;
        this.updateuser = updateuser;
        this.valid = valid;
        this.salt = salt;
    }

    public User() {
        super();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }

    public String getUserrealname() {
        return userrealname;
    }

    public void setUserrealname(String userrealname) {
        this.userrealname = userrealname == null ? null : userrealname.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public Integer getLeaderid() {
        return leaderid;
    }

    public void setLeaderid(Integer leaderid) {
        this.leaderid = leaderid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getStandby() {
        return standby;
    }

    public void setStandby(String standby) {
        this.standby = standby == null ? null : standby.trim();
    }

    public String getCreateuser() {
        return createuser;
    }

    public void setCreateuser(String createuser) {
        this.createuser = createuser == null ? null : createuser.trim();
    }

    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser == null ? null : updateuser.trim();
    }

    public Integer getValid() {
        return valid;
    }

    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }
}