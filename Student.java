public class Student extends Formatter {
	String name;
	String dept;
	int age;

	public Student(String name, int age) {
		super(name);
		this.name = formatName();
		this.age = age;
	}

	public Student(String name, char dept, int age) {
		super(name, dept);
		this.name = formatName();
		this.dept = getDept();
		this.age = age;
	}
}
