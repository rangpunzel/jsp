package com.groupware.request;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.groupware.dto.CareerVO;
import com.groupware.dto.EmployeeVO;

public class ModifyEmployeeRequest {
	
	private String id;
	private String pwd;
	private String eno;
	private String name;
	private String[] email;
	private int enabled;
	private String phone_c;
	private String phone_p;

	private MultipartFile picture;
	private String old_picture;
	
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
	
	private String old_licenseDoc;
	private String old_graduDoc;
	private String old_scoreDoc;
	
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

	public String getOld_picture() {
		return old_picture;
	}

	public void setOld_picture(String old_picture) {
		this.old_picture = old_picture;
	}

	public Date getRegDate() {
		return regDate;
	}

	@DateTimeFormat(pattern="yyyy-MM-dd")
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
		List<CareerVO> tempList = new ArrayList<CareerVO>();
		
		for(int i=0;i<careers.length;i++) {
			if(careers[i]==null) continue;
			tempList.add(careers[i]);
		}
		CareerVO[] temp = new CareerVO[tempList.size()];
		for(int i =0;i<tempList.size();i++) {
			temp[i]=tempList.get(i);
		}
		this.careers = temp;
	}
	
	public List<CareerVO> getCareerList(){
		if(careers==null) return null;
		
		List<CareerVO> careerList = new ArrayList<CareerVO>();
		
		for(int i=0;i<careers.length;i++) {
			if(careers[i]==null) continue;
			careers[i].setId(this.id);
			careerList.add(careers[i]);
		}
		
		return careerList;
	}
	

	public String getOld_licenseDoc() {
		return old_licenseDoc;
	}

	public void setOld_licenseDoc(String old_licenseDoc) {
		this.old_licenseDoc = old_licenseDoc;
	}

	public String getOld_graduDoc() {
		return old_graduDoc;
	}

	public void setOld_graduDoc(String old_graduDoc) {
		this.old_graduDoc = old_graduDoc;
	}

	public String getOld_scoreDoc() {
		return old_scoreDoc;
	}

	public void setOld_scoreDoc(String old_scoreDoc) {
		this.old_scoreDoc = old_scoreDoc;
	}

	@Override
	public String toString() {
		return "ModifyEmployeeRequest [id=" + id + ", pwd=" + pwd + ", eno=" + eno + ", name=" + name + ", email="
				+ Arrays.toString(email) + ", enabled=" + enabled + ", phone_c=" + phone_c + ", phone_p=" + phone_p
				+ ", picture=" + picture + ", old_picture=" + old_picture + ", regDate=" + regDate + ", posi_no="
				+ posi_no + ", dept_no=" + dept_no + ", postCode=" + postCode + ", address1=" + address1 + ", address2="
				+ address2 + ", ssn=" + Arrays.toString(ssn) + ", remark=" + remark + ", register=" + register
				+ ", licenseDoc=" + licenseDoc + ", graduDoc=" + graduDoc + ", scoreDoc=" + scoreDoc
				+ ", old_licenseDoc=" + old_licenseDoc + ", old_graduDoc=" + old_graduDoc + ", old_scoreDoc="
				+ old_scoreDoc + ", careers=" + Arrays.toString(careers) + "]";
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
