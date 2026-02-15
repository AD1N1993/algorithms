public class BitRangeInserterDemo {
    public static void main(String[] args) {
        BitRangeInserter bitRangeInserter = new BitRangeInserter();
        
        // Тест 1: Простая вставка
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                          ТЕСТ 1                                ║");
        System.out.println("║         Вставить биты из B в диапазон [3, 0] числа A           ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        
        int A1 = 0b10101010; // 170
        int B1 = 0b0011;     // 3
        int result1 = bitRangeInserter.insertBtoA(A1, B1, 3, 0);
        System.out.println("ИТОГОВЫЙ РЕЗУЛЬТАТ: " + result1 + " | " + Integer.toBinaryString(result1));
        
        // Тест 2: Вставка в другой диапазон
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                          ТЕСТ 2                                ║");
        System.out.println("║         Вставить биты из B в диапазон [5, 2] числа A           ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        
        int A2 = 0b11111111; // 255
        int B2 = 0b1010;     // 10
        int result2 = bitRangeInserter.insertBtoA(A2, B2, 5, 2);
        System.out.println("ИТОГОВЫЙ РЕЗУЛЬТАТ: " + result2 + " | " + Integer.toBinaryString(result2));
        
        // Тест 3: Вставка с нулями
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                          ТЕСТ 3                                ║");
        System.out.println("║         Вставить биты из B (нули) в диапазон [7, 4] числа A    ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
        
        int A3 = 0b11111111; // 255
        int B3 = 0b0000;     // 0
        int result3 = bitRangeInserter.insertBtoA(A3, B3, 7, 4);
        System.out.println("ИТОГОВЫЙ РЕЗУЛЬТАТ: " + result3 + " | " + Integer.toBinaryString(result3));
    }
}
