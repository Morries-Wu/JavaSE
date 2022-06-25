package Reflection.Annotation;

@Table("tb_student")
public class Student {

	@myField(columnName = "id", type = "int", length = 10)
	private int id;
	@myField(columnName = "sname", type = "varchar", length = 10)
	private String studentName;
	@myField(columnName = "age", type = "int", length = 3)
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
