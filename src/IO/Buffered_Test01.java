package IO;

import java.io.*;

//加入缓冲流
public class Buffered_Test01 {
    public static void main(String[] args) {

        // 1、创建源
        // 2、选择流
        BufferedInputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream("src\\OutFile\\dest.txt"));
            byte flush[] = new byte[1024];
            int len = -1;
            while ((len = in.read(flush)) != -1) {
                String str = new String(flush, 0, len);
                System.out.println(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
