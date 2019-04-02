package idv.jyr.helen_demo.dao;

import idv.jyr.helen_demo.model.Deptinfo;

public class GetEmpDeptCondition
{
	private int pageNum = 0;
	
	private int pageSize = 0;

	private int empId = 0;
	
	private String name = null;
	
	private int age = 0;
	
	private Deptinfo department = null;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Deptinfo getDepartment() {
		return department;
	}

	public void setDepartment(Deptinfo department) {
		this.department = department;
	}

}
