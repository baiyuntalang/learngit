package com.entity;

public class TRole {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role.id
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role.name
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role.sn
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    private String sn;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role.remark
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role.id
     *
     * @return the value of t_role.id
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role.id
     *
     * @param id the value for t_role.id
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role.name
     *
     * @return the value of t_role.name
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role.name
     *
     * @param name the value for t_role.name
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role.sn
     *
     * @return the value of t_role.sn
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    public String getSn() {
        return sn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role.sn
     *
     * @param sn the value for t_role.sn
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role.remark
     *
     * @return the value of t_role.remark
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role.remark
     *
     * @param remark the value for t_role.remark
     *
     * @mbggenerated Mon Jan 28 16:04:07 CST 2019
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}