package files;

public class Statistic {
    private static int number_of_float_numbers = 0;
    private static int number_of_int_numbers = 0;
    private static int number_of_strings = 0;
    private static int int_min_num = 0;
    private static int int_max_num = 0;
    private static int int_sum = 0;
    private static float float_min_num = 0;
    private static float float_max_num = 0;
    private static float float_sum = 0;
    private static int max_length = 0;
    private static int min_length = 0;

    public static void calculate(int number) {
        if (number > int_max_num | number_of_int_numbers == 0) {
            int_max_num = number;
        }
        if (number < int_min_num | number_of_int_numbers == 0) {
            int_min_num = number;
        }
        number_of_int_numbers++;
        int_sum += number;
    }
    public static void calculate(float number) {
        if (number > float_max_num | number_of_int_numbers == 0) {
            float_max_num = number;
        }
        if (number < float_min_num | number_of_float_numbers == 0) {
            float_min_num = number;
        }
        number_of_float_numbers++;
        float_sum += number;
    }

    public static void calculate(String string) {
        if (string.length() > float_max_num | number_of_strings == 0) {
            max_length = string.length();
        }
        if (string.length() < float_min_num | number_of_strings == 0) {
            min_length = string.length();
        }
        number_of_strings++;
    }



    public static void printBriefStatistics(){
        System.out.println("Количество вещественных чисел: " + number_of_float_numbers);
        System.out.println("Количество целых чисел: " + number_of_int_numbers);
        System.out.println("Количество строк: " + number_of_strings);
    }


    public static void printFullStatistics(){
        System.out.println("Статистика для целых чисел:");
        System.out.println("Количество целых чисел: " + number_of_int_numbers);
        System.out.println("Минимальное целое число: " + int_min_num);
        System.out.println("Максимальное целое число: " + int_max_num);
        System.out.println("Сумма целых чисел: " + int_sum);
        System.out.println("Среднее значение целых чисел: " +
                (number_of_int_numbers == 0 ? 0 : (float) int_sum / number_of_int_numbers));
        System.out.println();


        System.out.println("Статистика для вещественных чисел:");
        System.out.println("Количество вещественных чисел: " + number_of_float_numbers);
        System.out.println("Минимальное вещественное число: " + float_min_num);
        System.out.println("Максимальное вещественное число: " + float_max_num);
        System.out.println("Сумма вещественных чисел: " + float_sum);
        System.out.println("Среднее значение вещественных чисел: " +
                (number_of_float_numbers == 0 ? 0 : float_sum / number_of_float_numbers));
        System.out.println();


        System.out.println("Статистика для строк:");
        System.out.println("Количество строк: " + number_of_strings);
        System.out.println("Размер самой короткой строки: " + min_length);
        System.out.println("Размер самой длинной строки: " + max_length);
    }
}
