package files;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static  void main(String[] args)  {
        String[] names = Options.analyze(args);
        List <String> listFloats = new ArrayList<>();
        List <String> listInts = new ArrayList<>();
        List <String> listStrings = new ArrayList<>();
        for (String name : names) {
            try (BufferedReader reader = new BufferedReader(new FileReader(name))) {
                String str = reader.readLine();
                while (str != null) {
                    if (isInt(str)) {
                        listInts.add(str);
                        Statistic.calculate(Integer.parseInt(str));
                    } else if (isFloat(str)) {
                        listFloats.add(str);
                        Statistic.calculate(Float.parseFloat(str));
                    } else {
                        listStrings.add(str);
                        Statistic.calculate(str);
                    }
                    str = reader.readLine();

                }
            } catch (IOException e) {
                System.out.println("Ошибка при чтении файла.");
                throw new RuntimeException(e);
            }
        }

        writeToFile(listInts, Options.int_file_name, Options.appender);
        writeToFile(listFloats, Options.float_file_name, Options.appender);
        writeToFile(listStrings, Options.string_file_name, Options.appender);

        if (Options.brief_print) {
            Statistic.printBriefStatistics();
        }
        if (Options.full_print){
            Statistic.printFullStatistics();
        }

    }
    static void writeToFile(List<String> list, String filename, boolean appender) {
        if (!list.isEmpty()) {
            try (BufferedWriter writer = new BufferedWriter(
                    new FileWriter(filename, appender))) {
                for (String val: list) {
                    writer.write(val + "\n");
                }
            } catch (IOException e) {
                System.out.println("Ошибка при записи файла.");
                throw new RuntimeException(e);
            }
        }
    }

    static boolean isFloat(String num) {
        try {
            Float.parseFloat(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    static boolean isInt(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}