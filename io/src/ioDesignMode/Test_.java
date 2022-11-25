package ioDesignMode;
/*
    模拟修饰器设计模式
 */
public class Test_ {

    public static void main(String[] args) {
        BufferedReader_ bufferedReader_ = new BufferedReader_(new FileReader_());
        bufferedReader_.readFiles(10);

        //这次希望通过BufferedReader_多次读取字符串
        BufferedReader_ bufferedReader_1 = new BufferedReader_(new StringReader_());
        bufferedReader_1.readStrings(5);
    }
}
