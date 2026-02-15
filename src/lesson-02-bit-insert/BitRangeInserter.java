public class BitRangeInserter {
    
    /**
     * Вставляет биты из числа B в число A с позиции start по позицию end
     * @param A исходное число
     * @param B число, биты которого вставляются
     * @param start позиция начала вставки (слева)
     * @param end позиция конца вставки (справа)
     * @return число A с вставленными битами из B
     */
    int insertBtoA(int A, int B, int start, int end) {
        System.out.println("\n========== НАЧАЛО ОПЕРАЦИИ ==========");
        System.out.println("Исходные данные:");
        System.out.println("  A (исходное число) = " + A + " | " + toBinaryString(A));
        System.out.println("  B (число для вставки) = " + B + " | " + toBinaryString(B));
        System.out.println("  Позиция начала (start) = " + start);
        System.out.println("  Позиция конца (end) = " + end);
        System.out.println("  Количество вставляемых битов = " + (start - end + 1));
        
        // ШАГ 1: Создание левой маски (все единицы с позиции start+1 и выше)
        System.out.println("\n--- ШАГ 1: Создание левой маски (maskL) ---");
        int maskL = (int)(-1L << (start + 1));
        System.out.println("  Формула: (-1L << " + (start + 1) + ")");
        System.out.println("  maskL = " + maskL + " | " + toBinaryString(maskL));
        System.out.println("  Смысл: сохранить биты выше позиции " + start);
        
        // ШАГ 2: Создание правой маски (все единицы до позиции end)
        System.out.println("\n--- ШАГ 2: Создание правой маски (maskR) ---");
        int maskR = (1 << end) - 1;
        System.out.println("  Формула: (1 << " + end + ") - 1");
        System.out.println("  maskR = " + maskR + " | " + toBinaryString(maskR));
        System.out.println("  Смысл: сохранить биты ниже позиции " + end);
        
        // ШАГ 3: Объединение масок
        System.out.println("\n--- ШАГ 3: Объединение масок (maskA = maskL | maskR) ---");
        int maskA = maskL | maskR;
        System.out.println("  maskL       = " + toBinaryString(maskL));
        System.out.println("  maskR       = " + toBinaryString(maskR));
        System.out.println("  maskA (ИЛИ) = " + toBinaryString(maskA));
        System.out.println("  Смысл: маска для очистки диапазона [end, start]");
        
        // ШАГ 4: Очистка позиций в числе A
        System.out.println("\n--- ШАГ 4: Очистка позиций в числе A (A &= maskA) ---");
        System.out.println("  До: A = " + toBinaryString(A));
        A &= maskA;
        System.out.println("  После: A = " + toBinaryString(A));
        System.out.println("  Смысл: обнулить позиции с " + end + " по " + start);
        
        // ШАГ 5: Сдвиг битов B на позицию end
        System.out.println("\n--- ШАГ 5: Сдвиг битов B на позицию (B <<= " + end + ") ---");
        System.out.println("  До: B = " + B + " | " + toBinaryString(B));
        B <<= end;
        System.out.println("  После: B = " + B + " | " + toBinaryString(B));
        System.out.println("  Смысл: переместить биты B на правильную позицию");
        
        // ШАГ 6: Создание маски для B (оставить только нужные биты)
        System.out.println("\n--- ШАГ 6: Создание маски для B ---");
        System.out.println("  Количество битов для маски: " + (start - end + 1));
        int maskB = (int)((1L << (start - end + 1)) - 1);
        System.out.println("  Формула: (1L << " + (start - end + 1) + ") - 1");
        System.out.println("  maskB = " + maskB + " | " + toBinaryString(maskB));
        System.out.println("  Смысл: оставить только нужное количество битов из B");
        
        // ШАГ 7: Применение маски к B
        System.out.println("\n--- ШАГ 7: Применение маски к B (B &= maskB) ---");
        System.out.println("  До: B = " + B + " | " + toBinaryString(B));
        B &= maskB;
        System.out.println("  После: B = " + B + " | " + toBinaryString(B));
        System.out.println("  Смысл: убрать лишние биты из B");
        
        // ШАГ 8: Объединение результатов
        System.out.println("\n--- ШАГ 8: Объединение A и B (result = A | B) ---");
        System.out.println("  A = " + toBinaryString(A));
        System.out.println("  B = " + toBinaryString(B));
        int result = A | B;
        System.out.println("  result = " + toBinaryString(result));
        System.out.println("  Десятичное значение: " + result);
        System.out.println("  Смысл: вставить биты B в очищенные позиции A");
        
        System.out.println("\n========== КОНЕЦ ОПЕРАЦИИ ==========\n");
        
        return result;
    }
    
    /**
     * Вспомогательный метод для преобразования числа в двоичную строку
     */
    private String toBinaryString(int value) {
        String binary = Integer.toBinaryString(value);
        // Дополнить нулями до 32 битов для наглядности
        while (binary.length() < 32) {
            binary = "0" + binary;
        }
        // Разбить на группы по 8 бит для удобства чтения
        StringBuilder formatted = new StringBuilder();
        for (int i = 0; i < binary.length(); i++) {
            if (i > 0 && i % 8 == 0) {
                formatted.append(" ");
            }
            formatted.append(binary.charAt(i));
        }
        return formatted.toString();
    }
}
