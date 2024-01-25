package files;

import java.io.File;
import java.util.Arrays;

public class Options {
    static String float_file_name = "floats.txt";
    static String int_file_name = "integers.txt";
    static String string_file_name = "strings.txt";
    static boolean brief_print = false;
    static boolean full_print = false;
    static boolean appender = false;

    static String[] analyze(String[] names){
        String o = "";
        String p = "";
        String[] names2 = new String[0];
        label: for (int i = 0; i < names.length; i++) {
            switch (names[i]) {
                case "-s":
                    brief_print = true;
                    break;
                case "-f":
                    full_print = true;
                    break;
                case "-o":
                    if (new File(names[i + 1]).isDirectory()) {
                        o = names[i+1] + "/";
                    }else {
                        System.out.println("Неправильно указан путь до результатов.");
                        brief_print = false;
                        full_print = false;
                        break label;
                    }
                    i++;
                    break;
                case "-p":
                    p = names[i+1];
                    i++;
                    break;
                case "-a":
                    appender = true;
                    break;
                default:
                    names2 = Arrays.copyOfRange(names, i, names.length);
                    for (String name: names2) {
                        if (! new File(name).isFile()) {
                            System.out.println("Неправильно введены данные.");
                            names2 = new String[0];
                            brief_print = false;
                            full_print = false;
                            break;
                        }
                    }
                    break label;
            }

        }
        float_file_name = o + p + float_file_name;
        int_file_name = o + p + int_file_name;
        string_file_name = o + p +  string_file_name;
        return names2;
    }
}
