package com.entity;

public class TUser {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.id
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.dept_id
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    private Integer deptId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.staffname
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    private String staffname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.username
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.password
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.status
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    private Integer status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.id
     *
     * @return the value of t_user.id
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.id
     *
     * @param id the value for t_user.id
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.dept_id
     *
     * @return the value of t_user.dept_id
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.dept_id
     *
     * @param deptId the value for t_user.dept_id
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.staffname
     *
     * @return the value of t_user.staffname
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    public String getStaffname() {
        return staffname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.staffname
     *
     * @param staffname the value for t_user.staffname
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    public void setStaffname(String staffname) {
        this.staffname = staffname == null ? null : staffname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.username
     *
     * @return the value of t_user.username
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.username
     *
     * @param username the value for t_user.username
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.password
     *
     * @return the value of t_user.password
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.password
     *
     * @param password the value for t_user.password
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.status
     *
     * @return the value of t_user.status
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.status
     *
     * @param status the value for t_user.status
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}