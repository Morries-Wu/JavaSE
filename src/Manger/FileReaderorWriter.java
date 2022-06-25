package Manger;

import java.io.*;

public class FileReaderorWriter {
	public static void objectToFile(Object obj, String outputFile) {
		ObjectOutputStream out = null;
		try {
			/**BufferedOutputStream��һ��д���ڴ���Ϣ�Ļ�������,�ļ��൱��һ�������Ļ���,������ÿ��ֻ��װ��һ���Ļ���
			 * FileOutputStream�����Ҫ���������ļ�����ʽд�����ļ���,outputFile�����ļ����������Student.txt
			 * ������д��Student.txt��
			 * ObjectOutputStream���Զ������ʽд��ȥ��������,Ȼ�󻺳�����ת��Ϊ�ļ���ʽд��ȥStudent.txt�ļ�
			 */
			out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(outputFile)));
			out.writeObject(obj);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}

	public static Object FileToObject(String filename) {
		ObjectInputStream in = null;
		try {
			/**
			 * BufferedInputStream����һ����ȡ���ݵĻ�������,FileInputStream���ļ������ݶ�ȡ���ڴ��е���
			 * ObjectInputStream���ڴ��е����ݶ�ȡ���Լ������,Ȼ������readObject()���������ݶ�ȡ��һ��Object[ArrayList<Person>]
			 * Ȼ��Ѷ�ȡ�����ݴ��͸�ָ��Ŀ��
			 */
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)));
			Object object = in.readObject();
			return object;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		//����ļ�����һ����Ϣ��û�о�ֱ�ӷ��ظ�null,˵���ļ��ǿյ�
		return null;
	}
}