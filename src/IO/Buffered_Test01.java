package IO;

import java.io.*;

//���뻺����
public class Buffered_Test01 {
    public static void main(String[] args) {

        // 1������Դ
        // 2��ѡ����
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
