package XML.JavaBean;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Dom4JTest {
    public void test() throws Exception {
        //创建一个saxreader输入流,去读取XML配置文件,生成document对象
        SAXReader saxReader = new SAXReader();
        Document read = saxReader.read("src/XML/XML/books.xml");
        System.out.println(read);
    }

    //读取booksXML文件生成Book类
    public void test2() throws Exception {
        //1、读取books.xml文件
        SAXReader reader = new SAXReader();
        Document read = reader.read("src/XML/XML/books.xml");
        //2、通过document对象根元素
        Element rootElement = read.getRootElement();
        //3、通过根元素获取book标签对象,element()和elements()都是通过标签名查找子元素
        List<Element> books = rootElement.elements();
        //4、遍历,处理每个book标签转换为book类
        for (Element book : books) {
            //asXML()把标签对象,转换为标签字符串
            Element nameElement = book.element("name");
            String nameText=nameElement.getText();
            //直接获取标签名的文本内容
            String author = book.elementText("author");
            System.out.println(author);

            String sn = book.attributeValue("sn");
            System.out.println(sn);
        }
    }


    public static void main(String[] args) throws Exception {
        new Dom4JTest().test2();
    }


}
