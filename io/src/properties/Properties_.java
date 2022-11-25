package properties;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

public class Properties_ {
    public static void main(String[] args) {

    }

    @Test
    public void p1() throws Exception {
        //读取数据
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\properties\\mysql.properties"));
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split("=");
            System.out.println(split[0] + "值是" + split[1]);
        }
        bufferedReader.close();
    }

    @Test
    public void p2() throws Exception {
        Properties properties = new Properties();
        //加载指定文件
        properties.load(new FileReader("src\\properties\\mysql.properties"));
        //把k-v显示控制台
        properties.list(System.out);
        //获取
        String pass = properties.getProperty("pass");
        System.out.println(pass);
    }

    @Test
    public void p3() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("Hello","nihao");
        properties.setProperty("user","汤姆");  //没有指定会保存Tom的unicode码
        properties.setProperty("age","12");
        //存储
        properties.store(new FileWriter("src\\properties\\mysql.properties"),null);
    }

}

