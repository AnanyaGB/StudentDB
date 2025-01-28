import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SysInOut {

	List<Student> list = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	public void clearScreen() {
		System.out.print("\033[2J");
	}

	public void getContinue() {
		System.out.print("Press 'Enter' key to continue.");
		try {
			System.in.read();
		} catch (IOException e) {
			/*
			 * Do something in case of error and fill in accordingly.
			 */
		}
	}

	public Student getInput() {
		clearScreen();
		System.out.print("Student name?: ");
		String name = sc.nextLine();
		System.out.println("Choose department:");
		System.out.println("[P]\tPhysics");
		System.out.println("[C]\tChemistry");
		System.out.println("[M]\tMathematics");
		System.out.println("[I]\tComputer Science");
		System.out.println("[B]\tBotany");
		System.out.println("[Z]\tZoology");
		System.out.println("[S]\tStatistics");
		System.out.println("[E]\tEconomics");
		System.out.println("[X]\tUndecided");
		System.out.print("Input?: ");
		char dept = sc.next().charAt(0);
		System.out.print("Enter student age: ");
		int age = sc.nextInt();
		Student s = new Student(name, dept, age);
		return s;
	}

	public char getChoice() {
		clearScreen();
		System.out.println("Perform:");
		System.out.println("[I]\tInsert new data");
		System.out.println("[D]\tDelete data");
		System.out.println("[V]\tView data");
		System.out.println("[E]\tExit");
		System.out.print("Your choice?: ");
		char ch = sc.next().charAt(0);
		return ch;
	}

	public void viewData() {
		clearScreen();
		System.out.println("#\tName\t\tDept\tAge");
		for (int i = 0; i < list.size(); i++) {
			Student x = list.get(i);
			System.out.println((i + 1) + "\t" + x.name + "\t" + x.dept + "\t" + x.age);
		}
		getContinue();
	}

	public void deleteStudent() {
		clearScreen();
		System.out.print("Student # to delete?: ");
		int x = sc.nextInt();
		System.out.print("Are you sure?[y/n]: ");
		char conf = sc.next().charAt(0);
		if (conf == 'Y' || conf == 'y') {
			list.remove(x - 1);
			System.out.print("Student record deleted!");
		} else {
			System.out.print("Cancelled delete operation.");
		}
		getContinue();
	}

	public void addStudent() {
		Student s = getInput();
		list.add(s);
		System.out.println("Student record added!");
		getContinue();
	}

	public void performOperations() {
		char ch;
		do {
			ch = getChoice();
			switch (ch) {
			case 'I':
			case 'i':
				addStudent();
				break;
			case 'D':
			case 'd':
				deleteStudent();
				break;
			case 'V':
			case 'v':
				viewData();
				break;
			case 'E':
			case 'e':
				System.out.print("Exit database successful.");
				break;
			default:
				System.out.println("Wrong input! Try again...");
			}
		} while (ch != 'E' && ch != 'e');
	}
}
