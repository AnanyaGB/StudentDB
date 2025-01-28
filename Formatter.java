public class Formatter {
	String name;
	char dept;

	public Formatter(String name) {
		this.name = name;
	}

	public Formatter(String name, char dept) {
		this.name = name;
		this.dept = dept;
	}

	public String formatName() {
		String formattedName = new String();
		formattedName += name.substring(name.lastIndexOf(' ') + 1) + ", ";
		for (int i = 0; i < name.lastIndexOf(' '); i++) {
			if (i == 0)
				formattedName += name.charAt(0);
			else if (name.charAt(i) == ' ')
				formattedName += name.charAt(i + 1);
		}
		return formattedName;
	}

	public String getDept() {
		String deptName = new String();
		switch (dept) {
		case 'P':
		case 'p':
			deptName = "PHY";
			break;
		case 'C':
		case 'c':
			deptName = "CHM";
			break;
		case 'M':
		case 'm':
			deptName = "MAT";
			break;
		case 'I':
		case 'i':
			deptName = "CMS";
			break;
		case 'B':
		case 'b':
			deptName = "BOT";
			break;
		case 'Z':
		case 'z':
			deptName = "ZOO";
			break;
		case 'S':
		case 's':
			deptName = "STS";
			break;
		case 'E':
		case 'e':
			deptName = "ECO";
			break;
		default:
			deptName = "NA";
			break;
		}
		return deptName;
	}
}
