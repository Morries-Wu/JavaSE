package JDBC.Service;

import java.util.Scanner;

public class AdminView {

    public void login() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = input.next();
        System.out.println("请输入密码:");
        String password = input.next();

        AdminService as = new AdminService();
        if (as.login(username, password)) {
            System.out.println("登录成功!");
        } else {
            System.out.println("登录失败!");
        }

    }


    public void showMainMenu() {
        System.out.println("显示主菜单");
    }

    public static void main(String[] args) {
        new AdminView().login();
    }

}
