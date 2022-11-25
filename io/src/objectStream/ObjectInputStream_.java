package objectStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStream_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //指定反序列化的文件
        String filePath = "F:\\data.dat";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));

        //反序列化的顺序要和你保存数据序列化一致,
        System.out.println(objectInputStream.readInt());
        System.out.println(objectInputStream.readChar());
        System.out.println(objectInputStream.readBoolean());
        System.out.println(objectInputStream.readDouble());
        System.out.println(objectInputStream.readUTF());
        System.out.println(objectInputStream.readObject());
    }
}
