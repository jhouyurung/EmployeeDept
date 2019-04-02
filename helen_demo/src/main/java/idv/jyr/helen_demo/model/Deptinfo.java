package idv.jyr.helen_demo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEPT_INFO")
public class Deptinfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DEPTINFO_DEPTID")
	private int deptinfoDeptid = 0;
	
	@Column(name = "DEPTINFO_NAME")
	private String deptinfoName = null;
	
	public Deptinfo()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Deptinfo(int deptinfoDeptid, String deptinfoName) {
		super();
		this.deptinfoDeptid = deptinfoDeptid;
		this.deptinfoName = deptinfoName;
	}
	public Deptinfo(int deptinfoDeptid) {
		super();
		this.deptinfoDeptid = deptinfoDeptid;
	}

	public int getDeptinfoDeptid() {
		return deptinfoDeptid;
	}

	public void setDeptinfoDeptid(int deptinfoDeptid) {
		this.deptinfoDeptid = deptinfoDeptid;
	}

	public String getDeptinfoName() {
		return deptinfoName;
	}

	public void setDeptinfoName(String deptinfoName) {
		this.deptinfoName = deptinfoName;
	}
	
	
}
