package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgrammTestDaoDepartment {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		Department newDepartment = new Department(null, "Music");
		
		System.out.println("=== TEST 1: department insert ===");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("=== TEST 2: department update ===");
		newDepartment.setId(8);
		departmentDao.update(newDepartment);

	}

}
