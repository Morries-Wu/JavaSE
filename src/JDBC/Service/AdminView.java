package JDBC.Service;

import java.util.Scanner;

public class AdminView {

    public void login() {
        Scanner input = new Scanner(System.in);
        System.out.println("�������û���:");
        String username = input.next();
        System.out.println("����������:");
        String password = input.next();

        AdminService as = new AdminService();
        if (as.login(username, password)) {
            System.out.println("��¼�ɹ�!");
        } else {
            System.out.println("��¼ʧ��!");
        }

    }


    public void showMainMenu() {
        System.out.println("��ʾ���˵�");
    }

    public static void main(String[] args) {
        new AdminView().login();
    }

}
