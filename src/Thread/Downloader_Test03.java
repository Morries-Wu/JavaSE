package Thread;

import java.util.concurrent.*;

public class Downloader_Test03 implements Callable<Boolean> {
	private String url;// 远程路径
	private String name;// 存储名字

	@Override
	public Boolean call() throws Exception {
		WebDownloader wd = new WebDownloader();
		wd.dowload(url, name);
		System.out.println(name);
		return true;
	}

	public Downloader_Test03(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Downloader_Test03 t1 = new Downloader_Test03("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1214358152,2194881589&fm=11&gp=0.jpg", "girl-1.jpg");
		Downloader_Test03 t2 = new Downloader_Test03("http://img.2qqtouxiang.com/pic/TX9484_01.jpg", "girl-2.jpg");
		Downloader_Test03 t3 = new Downloader_Test03("http://img.2qqtouxiang.com/pic/TX9484_07.jpg", "pig-jpg");
		// 创建执行服务:
		ExecutorService ser = Executors.newFixedThreadPool(3);
		// 提交执行
		Future<Boolean> result1 = ser.submit(t1);
		Future<Boolean> result2 = ser.submit(t2);
		Future<Boolean> result3 = ser.submit(t3);
		// 获取结果
		boolean r1 = result1.get();
		boolean r2 = result1.get();
		boolean r3 = result1.get();
		ser.shutdownNow();
	}
}
