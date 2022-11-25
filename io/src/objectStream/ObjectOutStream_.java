package objectStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectOutStream_ {
    public static void main(String[] args) throws IOException {
        //序列化后,保存的文件格式,不是存文本,而是按照他的格式来保存的
        String filePath = "F:\\data.dat";

        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath));
        //序列化数据到E:\\data.dat
        outputStream.writeInt(100);// int -> Integer 实现了Serializable
        outputStream.writeChar('a');// -> Character
        outputStream.writeBoolean(true);// -> Boolean
        outputStream.writeDouble(6.6);// -> Double
        outputStream.writeUTF("韩顺平");// String
        outputStream.writeObject(new Dog("旺财",10));
    }
}

class Dog implements Serializable {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Dog() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
