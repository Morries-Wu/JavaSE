package IO;

//实现放大器对声音的放大功能  
public class Decorate_Test01 {

	public static void main(String[] args) {
		Person p = new Person();
		p.say();
		Amplifier am = new Amplifier(p);
		am.say();
	}
}

interface Say {
	void say();
}

class Person implements Say {

	private int voice = 10;

	@Override
	public void say() {
		System.out.println("人的声音为:" + this.getVoice());
	}

	public int getVoice() {
		return voice;
	}

	public void setVoice(int voice) {
		this.voice = voice;
	}
}

class Amplifier implements Say {
	private Person p;

	public Amplifier(Person p) {
		this.p = p;
	}

	@Override
	public void say() {
		System.out.println("人的声音为:" + p.getVoice() * 100);
		System.out.println("噪音");
	}
}