package IO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

//ת����:InputStreamReader OutputStreamWriter
//1�����ַ�������ʽ�����ֽ���(���ı�)
//2��ָ���ַ���
public class Convert_Test02 {
    public static void main(String[] args) {
        readerURL01();
    }

    public static void readerURL01() {
        // ����������,���ذٶȵ�Դ��
        try (InputStream in = new URL("http://www.baidu.com").openStream();) {
            int temp;
            while ((temp = in.read()) != -1) {
                System.out.print((char) temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readerURL02() {
        // ����������,���ذٶȵ�Դ��
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new URL("http://www.baidu.com").openStream(), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(
                     new OutputStreamWriter(new FileOutputStream("src\\OutFile\\net.txt"), "GBK"));) {
            String temp = null;
            while ((temp = reader.readLine()) != null) {
                writer.append(temp);
                writer.newLine();
            }
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
