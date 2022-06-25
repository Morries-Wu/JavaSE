package IO;

import java.io.File;

// 递归   方法可以调用自己 递归头
// 递归头 何时结束递归 
// 递归体 重复调用
//统计文件夹大小

public class Dir_Demo02 {
    public static void main(String[] args) {
        File src = new File("F:\\Multifunctionapplication\\Advanced Files\\Java Project\\.metadata");
        printName(src, 0);
    }

    private static long len = 0;

    // 打印子孙级目录和文件的名称
    public static void printName(File src, int deep) {
        for (int i = 0; i < deep; i++) {
            System.out.print("-");
        }
        // 打印名称
        System.out.println(src.getName());
        if (!src.exists() || src == null) {// 递归头
            return;
        } else if (src.isDirectory()) {// 目录
            for (File temp : src.listFiles()) {
                printName(temp, deep + 1);
            }
        }
    }

    public static void count(File src) {
        // 获取大小
        if (src != null && src.exists()) {
            if (src.isFile()) {
                len = len + src.length();
            } else {// 子孙级
                for (File temp : src.listFiles()) {
                    count(temp);
                }
            }
        }
    }

}
