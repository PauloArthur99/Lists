package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("How many employees will be registered?");
		int numEmployees = sc.nextInt();
		
		List<Employee> list = new ArrayList<>();
		for (int i = 0; i < numEmployees; i++) {
			System.out.println("What's the id?");
			int id = sc.nextInt();
			System.out.println("What's the name?");
			String name = sc.next();
			System.out.println("What's the salary");
			double salary = sc.nextDouble();
			
			list.add(new Employee(id, name, salary));
		}
		
		System.out.println("Enter the employee id that will have salary increase: ");
		int id = sc.nextInt();
		
		Employee empl = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		
		if (empl != null) {
			System.out.println("Enter the percentage: ");
			double percentage  = sc.nextDouble();
			empl.increaseSalary(percentage);
		}
		else 
			System.out.println("This id doesn't exist.");
	
		for (Employee obj : list) {
			 System.out.println(obj.toString());
		}
		
		sc.close();
	}
}
