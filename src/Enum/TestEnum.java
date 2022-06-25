package Enum;

public class TestEnum {
	public static void main(String[] args) {
		System.out.println(Season.SPRING);
		Season a = Season.AUTUMN;
         switch (a) {
		case SPRING:
			System.out.println("春天來了，播种的季节 ");
			break;
		case SUMMER:
			System.out.println("夏天來了，游泳的季节");
			break;
		case AUTUMN:
			System.out.println("秋天來了，收获的季节");
			break;
		case WINTER:
			System.out.println("冬天來了，冬眠的季节");
			break;
		default:
			break;
		}
	}
}

enum Season {
	SPRING, SUMMER, AUTUMN, WINTER
}

enum Week {
	星期一, 星期二, 星期三, 星期四, 星期五, 星期六, 星期天
}