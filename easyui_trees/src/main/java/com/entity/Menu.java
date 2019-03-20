package com.entity;

import java.util.List;

import net.sf.json.JSONObject;

public class Menu {
private Integer id;
private Integer parantid;
// 子菜单
private List<Menu> children;
private String text;
private String state;
private String checked;
private JSONObject attribute;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getParantid() {
	return parantid;
}
public void setParantid(Integer parantid) {
	this.parantid = parantid;
}
public List<Menu> getChildren() {
	return children;
}
public void setChildren(List<Menu> children) {
	this.children = children;
}
public String getText() {
	return text;
}
public void setText(String text) {
	this.text = text;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getChecked() {
	return checked;
}
public void setChecked(String checked) {
	this.checked = checked;
}
public JSONObject getAttribute() {
	return attribute;
}
public void setAttribute(JSONObject attribute) {
	this.attribute = attribute;
}

}
