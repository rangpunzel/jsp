package com.groupware.request;

import java.util.Arrays;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.groupware.dto.CareerVO;
import com.groupware.dto.EmployeeVO;

public class RegistEmployeeRequest {
	
	private String id;
	private String pwd;
	private String eno;
	private String name;
	private String[] email;
	private int enabled;
	private String phone_c;
	private String phone_p;
	private MultipartFile picture;
	private Date regDate;
	private String posi_no;
	private String dept_no;
	private String postCode;
	private String address1;
	private String address2;	
	private String[] ssn;
	private String remark;
	private String register;
	
	private MultipartFile licenseDoc;
	private MultipartFile graduDoc;
	private MultipartFile scoreDoc;
	
	private CareerVO[] careers;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEno() {
		return eno;
	}

	public void setEno(String eno) {
		this.eno = eno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getEmail() {
		return email;
	}

	public void setEmail(String[] email) {
		this.email = email;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getPhone_c() {
		return phone_c;
	}

	public void setPhone_c(String phone_c) {
		this.phone_c = phone_c;
	}

	public String getPhone_p() {
		return phone_p;
	}

	public void setPhone_p(String phone_p) {
		this.phone_p = phone_p;
	}

	public MultipartFile getPicture() {
		return picture;
	}

	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getPosi_no() {
		return posi_no;
	}

	public void setPosi_no(String posi_no) {
		this.posi_no = posi_no;
	}

	public String getDept_no() {
		return dept_no;
	}

	public void setDept_no(String dept_no) {
		this.dept_no = dept_no;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String[] getSsn() {
		return ssn;
	}

	public void setSsn(String[] ssn) {
		this.ssn = ssn;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public MultipartFile getLicenseDoc() {
		return licenseDoc;
	}

	public void setLicenseDoc(MultipartFile licenseDoc) {
		this.licenseDoc = licenseDoc;
	}

	public MultipartFile getGraduDoc() {
		return graduDoc;
	}

	public void setGraduDoc(MultipartFile graduDoc) {
		this.graduDoc = graduDoc;
	}

	public MultipartFile getScoreDoc() {
		return scoreDoc;
	}

	public void setScoreDoc(MultipartFile scoreDoc) {
		this.scoreDoc = scoreDoc;
	}

	public CareerVO[] getCareers() {
		return careers;
	}

	public void setCareers(CareerVO[] careers) {
		this.careers = careers;
	}

	@Override
	public String toString() {
		return "RegistEmployeeRequest [id=" + id + ", pwd=" + pwd + ", eno=" + eno + ", name=" + name + ", email="
				+ Arrays.toString(email) + ", enabled=" + enabled + ", phone_c=" + phone_c + ", phone_p=" + phone_p
				+ ", picture=" + picture + ", regDate=" + regDate + ", posi_no=" + posi_no + ", dept_no=" + dept_no
				+ ", postCode=" + postCode + ", address1=" + address1 + ", address2=" + address2 + ", ssn="
				+ Arrays.toString(ssn) + ", remark=" + remark + ", register=" + register + ", licenseDoc=" + licenseDoc
				+ ", graduDoc=" + graduDoc + ", scoreDoc=" + scoreDoc + ", careers=" + Arrays.toString(careers) + "]";
	}

	public EmployeeVO toEmployeeVO() {
		EmployeeVO employee = new EmployeeVO();
		employee.setId(id);
		employee.setName(name);
		employee.setDept_no(dept_no);
		employee.setPosi_no(posi_no);
		employee.setPostCode(postCode);
		employee.setAddress1(address1);
		employee.setAddress2(address2);
		employee.setEmail(email[0]+"@"+email[1]);
		employee.setEnabled(enabled);
		employee.setEno(eno);
		employee.setPhone_c(phone_c);
		employee.setPhone_p(phone_p);
		employee.setPwd(pwd);
		employee.setRegDate(regDate);
		employee.setRemark(remark);
		employee.setSsn(ssn[0]+ssn[1]);
		employee.setRegister(register);
		
		return employee;
	}

}
