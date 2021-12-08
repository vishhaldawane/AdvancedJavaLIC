import java.util.List;

import com.java.entity.Department;
import com.java.repository.DepartmentRepositoryImpl;

public class DepartmentCRUDTest {

	public static void main(String[] args) {
		
		DepartmentRepositoryImpl deptRepo = new DepartmentRepositoryImpl();

		Department dept = deptRepo.selectDepartment(10);
		System.out.println("deptno : "+dept.getDepartmentNumber());
		System.out.println("dname  : "+dept.getDepartmentName());
		System.out.println("loc    : "+dept.getDepartmentLocation());
		System.out.println("--------------------");
		
		
		List<Department> deptList = deptRepo.selectDepartments();
		for(Department dept1 : deptList) {
			System.out.println("deptno : "+dept1.getDepartmentNumber());
			System.out.println("dname  : "+dept1.getDepartmentName());
			System.out.println("loc    : "+dept1.getDepartmentLocation());
		}
		System.out.println("--------------------");
		
		Department newDept = new Department();
				newDept.setDepartmentNumber(50);
				newDept.setDepartmentName("JAVATRG");
				newDept.setDepartmentLocation("BORIVALI");
				deptRepo.insertDepartment(newDept);

		System.out.println("--------------------");
				
		Department modDept = new Department();
				modDept.setDepartmentNumber(40);
				modDept.setDepartmentName("OPR");
				modDept.setDepartmentLocation("DELHI");
				deptRepo.updateDepartment(modDept);
						
		System.out.println("--------------------");
		deptRepo.deleteDepartment(50);
	}

}
