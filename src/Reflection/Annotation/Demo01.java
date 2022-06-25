package Reflection.Annotation;
/*
元注解的作用就是负责注解其他注解
Target
*/
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo01 {

	@Override
	public String toString() {
		return "";
	}

	@Deprecated
	public static void test001() {
		System.out.println("test001");
	}


	@SuppressWarnings("all")
	public static void test002() {
		List list=new ArrayList<>();
	}


	public static void main(String[] args) {
		Date date = new Date();
		test001();
	}

}
