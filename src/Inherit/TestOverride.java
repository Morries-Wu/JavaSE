package Inherit;

public class TestOverride {

}

class Vehicle {
	public void run() {
		System.out.println("��..........");
	}

	public void stop() {
		System.out.println("ֹͣ!");

	}

	class Horse extends Vehicle {
		public void run() {
			System.out.println("���㷭�ɣ��N�N��.....");
		}
	}
}