package IO;

import java.io.File;

// �ݹ�   �������Ե����Լ� �ݹ�ͷ
// �ݹ�ͷ ��ʱ�����ݹ� 
// �ݹ��� �ظ�����
//ͳ���ļ��д�С

public class Dir_Demo02 {
    public static void main(String[] args) {
        File src = new File("F:\\Multifunctionapplication\\Advanced Files\\Java Project\\.metadata");
        printName(src, 0);
    }

    private static long len = 0;

    // ��ӡ���ＶĿ¼���ļ�������
    public static void printName(File src, int deep) {
        for (int i = 0; i < deep; i++) {
            System.out.print("-");
        }
        // ��ӡ����
        System.out.println(src.getName());
        if (!src.exists() || src == null) {// �ݹ�ͷ
            return;
        } else if (src.isDirectory()) {// Ŀ¼
            for (File temp : src.listFiles()) {
                printName(temp, deep + 1);
            }
        }
    }

    public static void count(File src) {
        // ��ȡ��С
        if (src != null && src.exists()) {
            if (src.isFile()) {
                len = len + src.length();
            } else {// ���Ｖ
                for (File temp : src.listFiles()) {
                    count(temp);
                }
            }
        }
    }

}
