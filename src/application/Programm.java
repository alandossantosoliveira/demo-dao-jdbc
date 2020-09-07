package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Programm {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		List<Seller> list = new ArrayList<>();
		
		System.out.println("=== TEST 1: seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST 2: seller findByDeparment ===");
		Department department = new Department(2, null);
		list = sellerDao.findByDepartment(department);
		
		//list.forEach(System.out::println);
		for(Seller vendedor : list) {
			System.out.println(vendedor);
		}
		
		System.out.println("\n=== TEST 3: seller findAll ===");
		list = sellerDao.findAll();		
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 4: insert Seller ===");
		Seller newSeller = new Seller(null, "James Brown", "brown@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n=== TEST 5: update Seller ===");
		newSeller = sellerDao.findById(2);
		newSeller.setName("Maria Blue");
		sellerDao.update(newSeller);
		System.out.println("Update sucsess!");
		
		System.out.println("\n=== TEST 6: delete Seller ===");
		System.out.print("Type id seller for delete: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete complete!");
	}

}
