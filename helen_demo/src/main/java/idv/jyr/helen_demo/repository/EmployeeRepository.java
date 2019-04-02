package idv.jyr.helen_demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import idv.jyr.helen_demo.model.Employeeinfo;

@Repository
public interface EmployeeRepository extends CrudRepository<Employeeinfo,Long>
{

}
