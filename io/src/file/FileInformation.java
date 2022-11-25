package file;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class FileInformation {
    public static void main(String[] args) {

    }
    //获取文件信息
    @Test
    public void info(){
        //先创建文件对象
        File file = new File("E:\\news1.txt");
        //调用相呼应的方法,得到对应的信息
        System.out.println("文件名 = " + file.getName());
        System.out.println("文件绝对路径 = " + file.getAbsolutePath());
        System.out.println("文件父级目录 = " + file.getParent());
        System.out.println("文件大小(字节) = " + file.length());
        System.out.println("文件是否存在 = " + file.exists());
        System.out.println("是不是一个文件 = " + file.isFile());
        System.out.println("是不是一个目录 = " + file.isDirectory());
    }

    @Test
    public void work() throws IOException {
        //判断目录是否存在,存在就删除,否则就创建
        File file = new File("E:\\file");
        if(file.exists()){
            if (file.delete()) System.out.println("删除成功");
        }else {
            if (file.createNewFile()) System.out.println("创建成功");
            else System.out.println("创建失败");
        }
    }
}
