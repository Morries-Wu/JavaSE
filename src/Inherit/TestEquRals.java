package Inherit;

public class TestEquRals {

	public static void main(String[] args) {
		Object obj;
		String str;
		User u1 = new User(1000, "Ïé¸ç", "123456");
		User u2 = new User(1000, "¼ÎÃ÷½ã", "123456");
		System.out.println(u1 == u2);
		System.out.println(u1.equals(u2));
	}

}
//java bean
class User {

	int id;
	String name, password;

	public User(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
