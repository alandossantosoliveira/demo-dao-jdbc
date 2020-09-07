package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgrammTestDaoDepartment {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		Department newDepartment = new Department(null, "Payments");
		
		System.out.println("=== TEST 1: department insert ===");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());
		
		System.out.println("=== TEST 2: department update ===");
		newDepartment.setId(8);
		departmentDao.update(newDepartment);
		
		
		System.out.println("=== TEST 3: department delete ===");
		System.out.print("Type id department for delete: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		
		System.out.println("=== TEST 4: department findById ===");
		Department dep = departmentDao.findById(3);
		System.out.println(dep);
		
		System.out.println("=== TEST 5: department findAll ===");
		List<Department> list = new ArrayList<>();
		list = departmentDao.findAll();
		
		for(Department department : list) {
			System.out.println(department);
		}
		
		sc.close();
	}

}
