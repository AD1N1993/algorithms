public class BitOperations {
    // Вспомогательный метод для красивого вывода битов
    private void printBitState(String label, int value, int index) {
        String binary = String.format("%32s", Integer.toBinaryString(value)).replace(' ', '0');
        String markedBinary = "";
        for (int i = 0; i < binary.length(); i++) {
            if (31 - i == index) {
                markedBinary += "[" + binary.charAt(i) + "]";
            } else {
                markedBinary += binary.charAt(i);
            }
        }
        System.out.println(label + ": " + markedBinary + " (десятичное: " + value + ")");
    }

    int setBit(int n, int index) {
        System.out.println("\n=== SET BIT (установка бита в позицию " + index + ") ===");
        printBitState("Было", n, index);
        
        int mask = 1 << index;
        System.out.println("Маска: " + String.format("%32s", Integer.toBinaryString(mask)).replace(' ', '0'));
        
        int result = n | mask;
        printBitState("Стало", result, index);
        System.out.println("Операция: OR (|) - устанавливает бит в 1");
        return result;
    }

    int unsetBit(int n, int index) {
        System.out.println("\n=== UNSET BIT (сброс бита в позицию " + index + ") ===");
        printBitState("Было", n, index);
        
        int mask = ~(1 << index);
        System.out.println("Маска: " + String.format("%32s", Integer.toBinaryString(mask)).replace(' ', '0'));
        
        int result = n & mask;
        printBitState("Стало", result, index);
        System.out.println("Операция: AND (&) с инвертированной маской - обнуляет бит");
        return result;
    }

    int inverseBit(int n, int index) {
        System.out.println("\n=== INVERSE BIT (инверсия бита в позицию " + index + ") ===");
        printBitState("Было", n, index);
        
        int mask = 1 << index;
        System.out.println("Маска: " + String.format("%32s", Integer.toBinaryString(mask)).replace(' ', '0'));
        
        int result = n ^ mask;
        printBitState("Стало", result, index);
        System.out.println("Операция: XOR (^) - переворачивает бит (0->1, 1->0)");
        return result;
    }

    boolean isSetBit(int n, int index) {
        System.out.println("\n=== CHECK BIT (проверка бита в позицию " + index + ") ===");
        printBitState("Проверяем", n, index);
        
        int mask = 1 << index;
        System.out.println("Маска: " + String.format("%32s", Integer.toBinaryString(mask)).replace(' ', '0'));
        
        int result = n & mask;
        boolean isSet = result != 0;
        System.out.println("Результат AND: " + result);
        System.out.println("Бит установлен (=1)? " + (isSet ? "ДА ✓" : "НЕТ ✗"));
        return isSet;
    }

    int swap(int n) {
        System.out.println("\n=== SWAP BITS (обмен четных и нечетных позиций) ===");
        String binary32 = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');
        System.out.println("Исходное число: " + binary32 + " (десятичное: " + n + ")");
        System.out.println("Позиции:       " + "31...24 23...16 15...8  7...0 (нумерация справа)");

        // Swap even and odd bits
        int evenBits = n & 0x55555555; // 01010101... mask for even positions
        String evenBinary = String.format("%32s", Integer.toBinaryString(evenBits)).replace(' ', '0');
        System.out.println("\nЧетные позиции (маска 01010101...): " + evenBinary);
        
        int oddBits = n & 0xAAAAAAAA;  // 10101010... mask for odd positions 
        String oddBinary = String.format("%32s", Integer.toBinaryString(oddBits)).replace(' ', '0');
        System.out.println("Нечетные позиции (маска 10101010...): " + oddBinary);
        
        System.out.println("\nСмещение:");
        System.out.println("  Четные биты << 1 (сдвиг влево): " + String.format("%32s", Integer.toBinaryString(evenBits << 1)).replace(' ', '0'));
        System.out.println("  Нечетные биты >>> 1 (сдвиг вправо): " + String.format("%32s", Integer.toBinaryString(oddBits >>> 1)).replace(' ', '0'));
        
        int result = (evenBits << 1) | (oddBits >>> 1);
        String resultBinary = String.format("%32s", Integer.toBinaryString(result)).replace(' ', '0');
        
        System.out.println("\nРезультат после обмена: " + resultBinary + " (десятичное: " + result + ")");
        
        return result;
    }

    int getCountDifExample1(int a, int b) {
        System.out.println("\n=== COUNT DIFFERENT BITS (подсчет различающихся битов) ===");
        
        String binaryA = String.format("%32s", Integer.toBinaryString(a)).replace(' ', '0');
        String binaryB = String.format("%32s", Integer.toBinaryString(b)).replace(' ', '0');
        
        System.out.println("Число A: " + binaryA + " (десятичное: " + a + ")");
        System.out.println("Число B: " + binaryB + " (десятичное: " + b + ")");
        System.out.println("\nПроцесс сравнения (справа налево, позиция 0 -> 31):");
        System.out.println("─".repeat(90));
        
        int count = 0;
        int position = 0;
 
        while (a != 0 || b != 0) {
            int bitA = a & 1;  // Берем младший бит числа a 
            int bitB = b & 1;  // Берем младший бит числа b

            String comparison = bitA != bitB ? "≠ РАЗНЫЕ! ✗" : "= одинаковые ✓";
            String marker = bitA != bitB ? " ← СЧЕТЧИК +1" : "";
            
            System.out.printf("Позиция %2d: A[%d] %d vs B[%d] %d  %s%s%n", 
                position, position, bitA, position, bitB, comparison, marker);

            if (bitA != bitB) {
                count++;
            }

            a >>>= 1;  // Логический сдвиг вправо (убираем младший бит)
            b >>>= 1;
            position++;
        }
        
        System.out.println("─".repeat(90));
        System.out.println("Всего различающихся битов: " + count);
        System.out.println("Объяснение: метод сравнивает каждый бит справа налево");
        System.out.println("и считает, сколько позиций имеют разные значения (0 в одном и 1 в другом)");
        
        return count;
    }

    int getCountDifExample2(int a, int b) {
        System.out.println("\n=== COUNT DIFFERENT BITS v2 (подсчет через XOR - оптимизированный способ) ===");
        
        String binaryA = String.format("%32s", Integer.toBinaryString(a)).replace(' ', '0');
        String binaryB = String.format("%32s", Integer.toBinaryString(b)).replace(' ', '0');
        
        System.out.println("Число A: " + binaryA + " (десятичное: " + a + ")");
        System.out.println("Число B: " + binaryB + " (десятичное: " + b + ")");
        
        int xorAB = a ^ b;
        String binaryXOR = String.format("%32s", Integer.toBinaryString(xorAB)).replace(' ', '0');
        
        System.out.println("\nШаг 1: XOR операция (a ^ b)");
        System.out.println("Результат XOR: " + binaryXOR + " (десятичное: " + xorAB + ")");
        System.out.println("  ⓘ XOR дает 1 только где биты РАЗНЫЕ, 0 где одинаковые");
        
        System.out.println("\nШаг 2: Подсчет единиц в XOR результате:");
        System.out.println("─".repeat(90));
        
        int count = 0;
        int position = 0;
        int tempXor = xorAB;
        
        while (tempXor != 0) {
            int bitXorAB = tempXor & 1;  // Берем младший бит

            if (bitXorAB != 0) {
                System.out.printf("Позиция %2d: бит = 1 (было различие) → СЧЕТЧИК +1 (всего: %d)%n", position, count + 1);
                count++;
            } else {
                System.out.printf("Позиция %2d: бит = 0 (биты одинаковые)%n", position);
            }

            tempXor >>>= 1;  // Сдвиг вправо
            position++;
        }
        
        System.out.println("─".repeat(90));
        System.out.println("Всего различающихся битов: " + count);
        System.out.println("\n⚡ Преимущество XOR способа:");
        System.out.println("  • XOR автоматически находит все разные биты");
        System.out.println("  • Более эффективен - сразу видно где различия");
        System.out.println("  • В реальном коде часто используют Brian Kernighan алгоритм:");
        System.out.println("    while(xor != 0) { count++; xor &= (xor-1); } // Еще быстрее!");
        
        return count;
    }

    void demonstrateShifts(int n) {
        System.out.println("\n" + "═".repeat(100));
        System.out.println("═══ РАЗНИЦА МЕЖДУ МАТЕМАТИЧЕСКИМ И ЛОГИЧЕСКИМ СДВИГАМИ ═══");
        System.out.println("═".repeat(100));
        
        String binaryOriginal = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');
        System.out.println("\nИсходное число: " + binaryOriginal + " (десятичное: " + n + ")");
        System.out.println("Знаковый бит (старший бит слева): " + binaryOriginal.charAt(0));
        
        // ============ ЛОГИЧЕСКИЙ СДВИГ ВПРАВО >>>  ============
        System.out.println("\n" + "─".repeat(100));
        System.out.println("1️⃣  ЛОГИЧЕСКИЙ СДВИГ ВПРАВО (>>>)");
        System.out.println("─".repeat(100));
        System.out.println("Заполняет слева НУЛЯМИ, независимо от знака числа");
        System.out.println("Используется для работы с беззнаковыми числами");
        
        int logicalShift = n >>> 1;
        String binaryLogical = String.format("%32s", Integer.toBinaryString(logicalShift)).replace(' ', '0');
        
        System.out.println("\nПроцесс:");
        System.out.println("  До:    " + binaryOriginal);
        System.out.println("  После: " + binaryLogical);
        System.out.println("         ↑ вставлен 0 слева");
        System.out.println("\nРезультат: " + logicalShift + " (примерно делим на 2)");
        
        // ============ МАТЕМАТИЧЕСКИЙ СДВИГ ВПРАВО >> ============
        System.out.println("\n" + "─".repeat(100));
        System.out.println("2️⃣  МАТЕМАТИЧЕСКИЙ СДВИГ ВПРАВО (>>)");
        System.out.println("─".repeat(100));
        System.out.println("Заполняет слева КОПИЕЙ ЗНАКОВОГО БИТА");
        System.out.println("Используется для работы со знаковыми числами (сохраняет знак)");
        
        int arithmeticShift = n >> 1;
        String binaryArithmetic = String.format("%32s", Integer.toBinaryString(arithmeticShift)).replace(' ', '0');
        
        System.out.println("\nПроцесс:");
        System.out.println("  До:    " + binaryOriginal + " (знаковый бит: " + binaryOriginal.charAt(0) + ")");
        System.out.println("  После: " + binaryArithmetic);
        System.out.println("         ↑ вставлена копия знакового бита (" + binaryOriginal.charAt(0) + ")");
        System.out.println("\nРезультат: " + arithmeticShift + " (делим на 2, сохраняя знак)");
        
        // ============ СДВИГ ВЛЕВО << ============
        System.out.println("\n" + "─".repeat(100));
        System.out.println("3️⃣  СДВИГ ВЛЕВО (<<) - Одинаков для обоих вариантов");
        System.out.println("─".repeat(100));
        System.out.println("Заполняет справа НУЛЯМИ");
        System.out.println("Умножает число на 2^k, где k - количество позиций");
        
        int leftShift = n << 1;
        String binaryLeft = String.format("%32s", Integer.toBinaryString(leftShift)).replace(' ', '0');
        
        System.out.println("\nПроцесс:");
        System.out.println("  До:    " + binaryOriginal);
        System.out.println("  После: " + binaryLeft);
        System.out.println("                                          0 ← вставлен 0 справа");
        System.out.println("\nРезультат: " + leftShift + " (умножаем на 2)");
        
        // ============ ПРАКТИЧЕСКИЙ ПРИМЕР ============
        System.out.println("\n" + "═".repeat(100));
        System.out.println("📊 ПРАКТИЧЕСКИЙ ПРИМЕР: Отрицательное число (-5)");
        System.out.println("═".repeat(100));
        
        int negativeNum = -5;
        String binaryNeg = String.format("%32s", Integer.toBinaryString(negativeNum)).replace(' ', '0');
        
        System.out.println("\nИсходное число: " + binaryNeg + " (десятичное: " + negativeNum + ")");
        System.out.println("Знаковый бит: 1 (отрицательное число)");
        
        int logShiftNeg = negativeNum >>> 1;
        String binaryLogNeg = String.format("%32s", Integer.toBinaryString(logShiftNeg)).replace(' ', '0');
        
        int arithShiftNeg = negativeNum >> 1;
        String binaryArithNeg = String.format("%32s", Integer.toBinaryString(arithShiftNeg)).replace(' ', '0');
        
        System.out.println("\nЛОГИЧЕСКИЙ сдвиг (>>>): " + binaryLogNeg);
        System.out.println("  Результат: " + logShiftNeg + " (ОШИБКА! Число стало положительным!)");
        
        System.out.println("\nМАТЕМАТИЧЕСКИЙ сдвиг (>>): " + binaryArithNeg);
        System.out.println("  Результат: " + arithShiftNeg + " (Правильно! Сохранен знак)");
        
        System.out.println("\n" + "═".repeat(100));
        System.out.println("⚠️  ВЫВОД:");
        System.out.println("  • Для ПОЛОЖИТЕЛЬНЫХ чисел: >> и >>> дают одинаковый результат");
        System.out.println("  • Для ОТРИЦАТЕЛЬНЫХ чисел: ");
        System.out.println("    - >>> (логический) = неправильный результат (число становится положительным)");
        System.out.println("    - >> (математический) = правильный результат (знак сохраняется)");
        System.out.println("═".repeat(100) + "\n");
    }

    void demonstrateArithmeticShift(int n, int positions) {
        System.out.println("\n" + "═".repeat(100));
        System.out.println("═══ МАТЕМАТИЧЕСКИЙ СДВИГ ВПРАВО (>>) - ПОДРОБНО ═══");
        System.out.println("═".repeat(100));
        
        String binaryOriginal = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');
        char signBit = binaryOriginal.charAt(0);
        
        System.out.println("\nИсходное число: " + binaryOriginal + " (десятичное: " + n + ")");
        System.out.println("Знаковый бит (MSB - старший бит): " + signBit);
        if (signBit == '0') {
            System.out.println("  → Число ПОЛОЖИТЕЛЬНОЕ");
        } else {
            System.out.println("  → Число ОТРИЦАТЕЛЬНОЕ");
        }
        
        System.out.println("\n" + "─".repeat(100));
        System.out.println("Сдвиг на " + positions + " позиций вправо (>> " + positions + ")");
        System.out.println("─".repeat(100));
        
        int result = n >> positions;
        String binaryResult = String.format("%32s", Integer.toBinaryString(result)).replace(' ', '0');
        
        System.out.println("\nПроцесс сдвига:");
        
        // Визуализация пошагового сдвига
        int temp = n;
        String currentBinary = binaryOriginal;
        
        for (int i = 1; i <= positions; i++) {
            temp = temp >> 1;
            currentBinary = String.format("%32s", Integer.toBinaryString(temp)).replace(' ', '0');
            
            System.out.println("\nШаг " + i + ":");
            System.out.println("  " + currentBinary);
            System.out.println("  ↑ вставлен " + signBit + " (копия знакового бита)");
            System.out.println("  Десятичное значение: " + temp);
        }
        
        System.out.println("\n" + "═".repeat(100));
        System.out.println("ИТОГОВЫЙ РЕЗУЛЬТАТ:");
        System.out.println("═".repeat(100));
        
        System.out.println("\nДо:    " + binaryOriginal + " = " + n);
        System.out.println("После: " + binaryResult + " = " + result);
        
        // Математическое объяснение
        System.out.println("\n📐 МАТЕМАТИЧЕСКОЕ ОБЪЯСНЕНИЕ:");
        System.out.println("  " + n + " >> " + positions + " = " + n + " / 2^" + positions + " = " + n + " / " + (int)Math.pow(2, positions));
        System.out.println("  Результат: " + result + " (целая часть от деления)");
        
        // Сравнение с логическим сдвигом
        System.out.println("\n" + "─".repeat(100));
        System.out.println("СРАВНЕНИЕ С ЛОГИЧЕСКИМ СДВИГОМ (>>>):");
        System.out.println("─".repeat(100));
        
        int logicalResult = n >>> positions;
        String binaryLogical = String.format("%32s", Integer.toBinaryString(logicalResult)).replace(' ', '0');
        
        System.out.println("\nМатематический (>>): " + binaryResult + " = " + result);
        System.out.println("Логический (>>>):    " + binaryLogical + " = " + logicalResult);
        
        if (n >= 0) {
            System.out.println("\n✓ Для ПОЛОЖИТЕЛЬНЫХ чисел результаты ОДИНАКОВЫЕ");
        } else {
            System.out.println("\n✗ Для ОТРИЦАТЕЛЬНЫХ чисел результаты РАЗНЫЕ!");
            System.out.println("  • >> сохраняет знак (вставляет 1)");
            System.out.println("  • >>> игнорирует знак (вставляет 0)");
        }
        
        // Практические примеры
        System.out.println("\n" + "═".repeat(100));
        System.out.println("💡 ПРАКТИЧЕСКИЕ ПРИМЕРЫ:");
        System.out.println("═".repeat(100));
        
        System.out.println("\n1️⃣  БЫСТРОЕ ДЕЛЕНИЕ НА 2:");
        System.out.println("   int x = 16;");
        System.out.println("   int y = x >> 1;  // Вместо x / 2");
        System.out.println("   // Результат: " + (16 >> 1) + " (быстрее, чем деление)");
        
        System.out.println("\n2️⃣  БЫСТРОЕ ДЕЛЕНИЕ НА ЛЮБУЮ СТЕПЕНЬ 2:");
        System.out.println("   int x = 100;");
        System.out.println("   int y = x >> 3;  // Делим на 2^3 = 8");
        System.out.println("   // Результат: " + (100 >> 3) + " (100 / 8)");
        
        System.out.println("\n3️⃣  РАБОТА С ОТРИЦАТЕЛЬНЫМИ ЧИСЛАМИ:");
        System.out.println("   int x = -16;");
        System.out.println("   int y = x >> 1;  // Правильно: " + (-16 >> 1));
        System.out.println("   int z = x >>> 1; // Неправильно: " + (-16 >>> 1) + " (потеря знака!)");
        
        System.out.println("\n" + "═".repeat(100) + "\n");
    }
}
