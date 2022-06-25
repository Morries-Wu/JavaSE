package Manger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Utils {
    public static String scan() {
        try {
            //BufferedReader只是一个工具管道来的
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            //管道就是输入到程序中的
            String to = in.readLine();
            return to;
        } catch (Exception e) {

        }
        return "";
    }

    public static int scanInt() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            //InputStreamReader相当于把需要写入的东西写道缓存管道中
            int to = Integer.parseInt(in.readLine());
            return to;
        } catch (Exception e) {

        }
        return 0;
    }

}
