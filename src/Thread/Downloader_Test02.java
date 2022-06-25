package Thread;

public class Downloader_Test02 implements Runnable {
	private String url;// Ô¶³ÌÂ·¾¶
	private String name;// ´æ´¢Ãû×Ö

	public Downloader_Test02(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}

	@Override
	public void run() {
		WebDownloader wd = new WebDownloader();
		wd.dowload(url, name);
	}

	public static void main(String[] args) {
		Downloader_Test02 t1 = new Downloader_Test02(
				"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1214358152,2194881589&fm=11&gp=0.jpg",
				"girl-1.jpg");
		Downloader_Test02 t2 = new Downloader_Test02("http://img.2qqtouxiang.com/pic/TX9484_01.jpg", "girl-2.jpg");
		Downloader_Test02 t3 = new Downloader_Test02("http://img.2qqtouxiang.com/pic/TX9484_07.jpg", "pig.jpg");
		new Thread(t3).start();
		new Thread(t2).start();
		new Thread(t1).start();
	}
}
