package Manger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Utils {
    public static String scan() {
        try {
            //BufferedReaderֻ��һ�����߹ܵ�����
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            //�ܵ��������뵽�����е�
            String to = in.readLine();
            return to;
        } catch (Exception e) {

        }
        return "";
    }

    public static int scanInt() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            //InputStreamReader�൱�ڰ���Ҫд��Ķ���д������ܵ���
            int to = Integer.parseInt(in.readLine());
            return to;
        } catch (Exception e) {

        }
        return 0;
    }

}
