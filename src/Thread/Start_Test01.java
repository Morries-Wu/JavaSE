package Thread;


//�̴߳�����ʽһ:

public class Start_Test01 extends Thread {

    // �߳���ڵ�
    public void run() {
        // ���߳����������ǿ���д���ǵĴ���Ҳ����д�����ĵ���
        for (int i = 0; i < 20; i++) {
            System.out.println("�ߴ����");
        }
    }

    public static void main(String[] args) {
        // �����̴߳����������
        new Start_Test01().start();
        // ������������start����
        //����֤����������CPU����
        //st.run();��ͨ��������
        for (int i = 0; i < 20; i++) {
            System.out.println("һ��ϴͷ");
        }
    }
}
