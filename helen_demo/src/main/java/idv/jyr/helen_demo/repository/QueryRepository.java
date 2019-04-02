package idv.jyr.helen_demo.repository;

import java.util.List;

import idv.jyr.helen_demo.dao.GetEmpDeptCondition;
import idv.jyr.helen_demo.model.Employeeinfo;

public interface QueryRepository
{
	List<Employeeinfo> findEmployeeByMultiCondition(GetEmpDeptCondition condition);
}
