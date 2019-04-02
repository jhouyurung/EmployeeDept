package idv.jyr.helen_demo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name="EMPLOYEE_INFO")
public class Employeeinfo
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empinfoId = 0;
	
	private String empinfoName = null;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "empinfoDeptid", referencedColumnName="DEPTINFO_DEPTID")
	private Deptinfo deptinfo = null;
	
	private String empinfoGender = null;
	
	private String empinfoPhone = null;
	
	private String empinfoAddress = null;
	
	private int empinfoAge = 0;
	
    @Column(name = "EMPINFO_INS_DATE", nullable = false, columnDefinition = "DATE DEFAULT CURRENT_DATE")
    @CreatedDate
	private Date empinfoInsDate = null;
	
    @Column(name = "EMPINFO_MOD_DATE", nullable = false,columnDefinition = "DATE DEFAULT CURRENT_DATE")
    @LastModifiedDate
	private Date empinfoModDate = null;
	
	public Employeeinfo()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Employeeinfo(int empinfoId, String empinfoName, Deptinfo deptinfo, String empinfoGender,
			int empinfoAge) {
		super();
		this.empinfoId = empinfoId;
		this.empinfoName = empinfoName;
		this.deptinfo = deptinfo;
		this.empinfoGender = empinfoGender;
		this.empinfoAge = empinfoAge;
	}

	public int getEmpinfoId() {
		return empinfoId;
	}

	public void setEmpinfoId(int empinfoId) {
		this.empinfoId = empinfoId;
	}

	public String getEmpinfoName() {
		return empinfoName;
	}

	public void setEmpinfoName(String empinfoName) {
		this.empinfoName = empinfoName;
	}

	public Deptinfo getEmpinfoDeptid() {
		return deptinfo;
	}

	public void setEmpinfoDeptid(Deptinfo deptinfo) {
		this.deptinfo = deptinfo;
	}

	public String getEmpinfoGender() {
		return empinfoGender;
	}

	public void setEmpinfoGender(String empinfoGender) {
		this.empinfoGender = empinfoGender;
	}

	public String getEmpinfoPhone() {
		return empinfoPhone;
	}

	public void setEmpinfoPhone(String empinfoPhone) {
		this.empinfoPhone = empinfoPhone;
	}

	public String getEmpinfoAddress() {
		return empinfoAddress;
	}

	public void setEmpinfoAddress(String empinfoAddress) {
		this.empinfoAddress = empinfoAddress;
	}

	public int getEmpinfoAge() {
		return empinfoAge;
	}

	public void setEmpinfoAge(int empinfoAge) {
		this.empinfoAge = empinfoAge;
	}

	public Date getEmpinfoInsDate() {
		return empinfoInsDate;
	}

	public void setEmpinfoInsDate(Date empinfoInsDate) {
		this.empinfoInsDate = empinfoInsDate;
	}

	public Date getEmpinfoModDate() {
		return empinfoModDate;
	}

	public void setEmpinfoModDate(Date empinfoModDate) {
		this.empinfoModDate = empinfoModDate;
	}




}
