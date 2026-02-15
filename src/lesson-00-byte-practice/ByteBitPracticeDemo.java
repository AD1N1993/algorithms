//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ByteBitPracticeDemo {
    public static void main(String[] args) {
        // byte a = 22;
        //byte a = 0b00010110;
        // Установка в 1
        byte a = 0x16;

        a = (byte) (a | 0x20);
        System.out.println(a);

        // Установка в 0
        byte b = 0x16;
        b = (byte) (b & 0xFB);
        System.out.println(b);

        // Инверсия
        byte c = 0x16;
        c = (byte) (c ^ 0x08);
        System.out.println(c);

        // Проверка бита

        //Получить значение самого младшего бита
        byte d = 0b00001001;
        byte mask = 0b00000001;
        d = (byte) (d & mask);
        System.out.println(d);

        // обнулить все биты слева начиная от 3 по индексу

        byte e = 0b01101011;
        byte emask = 0b01101000;
        e = (byte) (e ^ emask);
        System.out.println(e);
    }
}
