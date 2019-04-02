package idv.jyr.helen_demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import idv.jyr.helen_demo.model.Employeeinfo;
import idv.jyr.helen_demo.repository.QueryRepository;
@Repository
public class queryEmpDept implements QueryRepository
{

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employeeinfo> findEmployeeByMultiCondition(GetEmpDeptCondition condition) {
		StringBuffer jsqlBuffer = null;
		List<Employeeinfo> employees = null;
		
		if(condition != null) {
			jsqlBuffer = new StringBuffer("select e.* from employee_info e where 1 = 1 ");
			
			if(condition.getEmpId() != 0) {
				jsqlBuffer.append("AND e.EMPINFO_ID = :empinfoId ");
			}
			if(condition.getName() != null) {
				jsqlBuffer.append("AND e.EMPINFO_NAME like :empinfoName ");
			}
			if(condition.getAge() != 0) {
				jsqlBuffer.append("AND e.EMPINFO_AGE = :empinfoAge ");
			}
			if(condition.getDepartment() != null) {
				jsqlBuffer.append("AND e.EMPINFO_DEPTID = :empinfoDeptid ");//empinfoDeptid
			}
			System.out.println("@@@@@@@@@@b "+jsqlBuffer.toString());
			Query query = entityManager.createNativeQuery(jsqlBuffer.toString(), Employeeinfo.class);
			System.out.println("@@@@@@@@@@a "+jsqlBuffer.toString());
			if(condition.getEmpId() !=  0) {
				query.setParameter("empinfoId", condition.getEmpId());
			}
			if(condition.getName() != null) {
				query.setParameter("empinfoName", "%" + condition.getName() + "%");
			}
			if(condition.getAge() != 0) {
				query.setParameter("empinfoAge", condition.getAge());
			}
			if(condition.getDepartment()!= null) {
				query.setParameter("empinfoDeptid", condition.getDepartment().getDeptinfoDeptid());	
			}
			
			query.setFirstResult(condition.getPageNum() * condition.getPageSize());
			query.setMaxResults(condition.getPageSize());
			
			employees = query.getResultList();
		}
		
		return employees;

	}

}
