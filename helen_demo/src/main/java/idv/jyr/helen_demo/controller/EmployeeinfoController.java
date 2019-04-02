package idv.jyr.helen_demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import idv.jyr.helen_demo.dao.GetEmpDeptCondition;
import idv.jyr.helen_demo.model.Deptinfo;
import idv.jyr.helen_demo.model.Employeeinfo;
import idv.jyr.helen_demo.repository.DeptRepository;
import idv.jyr.helen_demo.repository.EmployeeRepository;
import idv.jyr.helen_demo.dao.*;

@Controller
public class EmployeeinfoController
{
//	@Autowired
//	EmployeeinfoRepo empinfoRep;
	
	@Autowired
	EmployeeRepository empinfoRepository;
	@Autowired
	DeptRepository deptRepository;
	
	@RequestMapping("/")
	public String displayEmplyeeInfoList() 
	{
		return "empinfoList.jsp";
	}
	
	/***
	 * 新增員工資料
	 * @param employee
	 * @return
	 */
	@GetMapping(path="/addempInfo")
	@ResponseBody
	public List<Employeeinfo> addEmployeeInfo(Employeeinfo employee)
	{
		Date date= new Date();
		employee.setEmpinfoInsDate(date);
		employee.setEmpinfoModDate(date);
		List<Employeeinfo> result = new ArrayList<Employeeinfo>();
		result.add((Employeeinfo)empinfoRepository.save(employee));

		return result;
	}
	
	/***
	 * 更新員工資料
	 * @param employee
	 * @return
	 */
	@GetMapping(path="/updemp")
	@ResponseBody
	public Employeeinfo updateEmployee(Employeeinfo employee)
	{	
		if(employee.getEmpinfoId() == 0)
		{
			return null;
		}else 
		{
			Employeeinfo orgEmployee = findEmployee(employee.getEmpinfoId());
			if("".equals(employee.getEmpinfoName()))
			{
				employee.setEmpinfoName(orgEmployee.getEmpinfoName());
			}
			
			if("".equals(employee.getEmpinfoGender()))
			{
				employee.setEmpinfoGender(orgEmployee.getEmpinfoGender());
			}
			
			if("".equals(employee.getEmpinfoPhone()))
			{
				employee.setEmpinfoPhone(orgEmployee.getEmpinfoPhone());
			}
			
			if("".equals(employee.getEmpinfoAddress()))
			{
				employee.setEmpinfoAddress(orgEmployee.getEmpinfoAddress());
			}
			
			if(employee.getEmpinfoDeptid() == null)
			{
				employee.setEmpinfoDeptid(orgEmployee.getEmpinfoDeptid());
			}
			
			if(employee.getEmpinfoAge() == 0)
			{
				employee.setEmpinfoAge(orgEmployee.getEmpinfoAge());
			}
			
			if(employee.getEmpinfoInsDate() == null)
			{
				employee.setEmpinfoInsDate(orgEmployee.getEmpinfoInsDate());
			}
			Date date= new Date();
			employee.setEmpinfoModDate(date);
		}
		Employeeinfo result = (Employeeinfo)empinfoRepository.save(employee);

		return result;
	}
	
	/***
	 * 刪除員工資料
	 * @param id
	 * @return
	 */
	@RequestMapping("/delemp/{empinfoId}")
	@ResponseBody
	public String delEmployeeInfo(@PathVariable ("empinfoId")int id)
	{
		Employeeinfo employee = findEmployee(id);
		employee.setEmpinfoId(id);
		empinfoRepository.delete(employee);
		
		if(!isExistEmp(id))
		{
			return "Delete successfully";
		}
		return "Delete failure";
	}
	
	/***
	 * 新增部門資料
	 * @param dept
	 * @return
	 */
	@RequestMapping("/insdept")
	@ResponseBody
	public List<Deptinfo> insDept(Deptinfo dept)
	{
		List<Deptinfo> result = new ArrayList<Deptinfo>();
		result.add((Deptinfo)deptRepository.save(dept));

		return result;
	}
	
	/***
	 * 更新部門資料
	 * @param dept
	 * @return
	 */
	@RequestMapping("/upddept")
	@ResponseBody
	public Deptinfo updDept(Deptinfo dept)
	{
		if(dept.getDeptinfoDeptid() == 0)
		{
			return null;
		}

		return deptRepository.save(dept);
	}
	
	/***
	 * 更新部門資料
	 * @param dept
	 * @return
	 */
	@RequestMapping("/deldept")
	@ResponseBody
	public String delDeptInfo(Deptinfo dept)
	{
		deptRepository.delete(dept);
		
		if(!isExistDept(dept.getDeptinfoDeptid()))
		{
			return "Delete successfully";
		}
		return "Delete failure";
	}
	
	/***
	 * 員工全部搜尋
	 * @return
	 */
	@GetMapping("/showemp")
	@ResponseBody
	public List<Employeeinfo> getEmployee()
	{
		List<Employeeinfo> emp = (List<Employeeinfo>)empinfoRepository.findAll();
		return emp;
	}
	
	
	/***
	 * 員工搜尋BY employee_id
	 * @param empinfoId
	 * @return
	 */
	@RequestMapping("/showemp/{empinfoId}")
	@ResponseBody
	public Employeeinfo findEmployee(@PathVariable("empinfoId") int empinfoId)
	{
		if(!isExistEmp(empinfoId)) return null;
		
		List<Employeeinfo> allemployee = getEmployee();
		Employeeinfo findemployee = null;
		Employeeinfo tempmployee = null;
		for(int i = 0 ;i <= allemployee.size() ; i++) 
		{
			tempmployee = allemployee.get(i);
			if(empinfoId == tempmployee.getEmpinfoId())
			{
				findemployee = tempmployee;
				break;
			}
		}
		return findemployee;
	}
	
	public Deptinfo findDept(int deptId)
	{
		if(!isExistEmp(deptId)) return null;
		
		List<Deptinfo> alldept = getDept();
		Deptinfo finddept = null;
		Deptinfo tempdept = null;
		for(int i = 0 ;i <= alldept.size() ; i++) 
		{
			tempdept = alldept.get(i);
			if(deptId == tempdept.getDeptinfoDeptid())
			{
				finddept = tempdept;
				break;
			}
		}
		return finddept;
	}
	
	@RequestMapping("/updempphone/{empinfoId}/{phone}")
	@ResponseBody
	public Employeeinfo updateEmployeePhone(@PathVariable ("empinfoId")int id,@PathVariable String phone)
	{
		Employeeinfo employee = findEmployee(id);
		employee.setEmpinfoPhone(phone);
		employee= empinfoRepository.save(employee);
		return employee;
	}
	
	
	public boolean isExistEmp(int id)
	{
		boolean isEist = false;
		List<Employeeinfo> allemployee = getEmployee();
		Employeeinfo tempEmp = null; 

		for(int i = 0;i < allemployee.size();i++) 
		{
			tempEmp = allemployee.get(i);
			if(id==tempEmp.getEmpinfoId()) 
			{
				isEist = true;
				break;
			}
		}
		
		return isEist;
	}
	
	public boolean isExistDept(int id)
	{
		boolean isEist = false;
		List<Deptinfo> allDept = getDept();
		Deptinfo tempDept = null; 

		for(int i = 0;i < allDept.size();i++) 
		{
			tempDept = allDept.get(i);
			if(id==tempDept.getDeptinfoDeptid()) 
			{
				isEist = true;
				break;
			}
		}
		
		return isEist;
	}
	
	@RequestMapping("/insdeptinfo")
	public String displayDeptList() 
	{
		return "deptinfoList.jsp";
	}
	
	@RequestMapping(path="/adddeptInfo")
	public String addDeptInfo(Deptinfo dept)
	{
		deptRepository.save(dept);
		new ModelMap("dept",dept);

		return "success_dept.jsp";
	}
	
	@GetMapping("/showdept")
	@ResponseBody
	public List<Deptinfo> getDept()
	{
		List<Deptinfo> dept = (List<Deptinfo>)deptRepository.findAll();
		return dept;
	}
	
	@RequestMapping("/queryEmpDept")
	@ResponseBody
	public List<Employeeinfo> queryEmpDept(GetEmpDeptCondition condition)
	{
		System.out.println("@@@@@@@@@@ "+condition.getName());
		queryEmpDept query = new queryEmpDept();
		List<Employeeinfo> result = query.findEmployeeByMultiCondition(condition);
		return result;
	}
}
