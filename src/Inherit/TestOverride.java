package Inherit;

public class TestOverride {

}

class Vehicle {
	public void run() {
		System.out.println("ÅÜ..........");
	}

	public void stop() {
		System.out.println("Í£Ö¹!");

	}

	class Horse extends Vehicle {
		public void run() {
			System.out.println("ËÄÌã·­·É£¬‡N‡NµÄ.....");
		}
	}
}