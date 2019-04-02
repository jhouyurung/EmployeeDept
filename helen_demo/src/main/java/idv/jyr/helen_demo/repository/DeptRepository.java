package idv.jyr.helen_demo.repository;

import org.springframework.data.repository.CrudRepository;

import idv.jyr.helen_demo.model.Deptinfo;

public interface DeptRepository extends CrudRepository<Deptinfo,Long>
{

}
