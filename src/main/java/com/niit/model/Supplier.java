package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Supplier {
@Id
int supId;
String supName,supAddress;
public int getSupId() {
	return supId;
}
public void setSupId(int supId) {
	this.supId = supId;
}
public String getSupName() {
	return supName;
}
public void setSupName(String supName) {
	this.supName = supName;
}
public String getSupAddress() {
	return supAddress;
}
public void setSupAddress(String supAddress) {
	this.supAddress = supAddress;
}
}


