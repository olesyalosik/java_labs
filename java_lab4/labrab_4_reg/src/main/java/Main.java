//6.      Задан текстовый файл input.txt.
//        Требуется определить строки этого файла,
//        содержащие максимальную по длине подстроку,
//        состоящую только из цифр.
//        Если таких строк несколько, найти первые 10.
//        Результат вывести на консоль в форме,
//        удобной для чтения.
//        Выполнение лаб 32 с использованием регулярных выражений.

//Лосик Олеси, 2 курс, 7 группа

import java.io.IOException;
import java.nio.file.Files ;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args)
    {
        Path path = Path.of("input.txt");
        List<Integer> maxSizes = new ArrayList<>();
        List<String> result = new ArrayList<>();
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        List<String> list = null;
        int maxSize = 0;
        try {
            list = Files.readAllLines(path);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (String str : list)
        {
            Matcher matcher = pattern.matcher(str);
            int max = 0;
            while(matcher.find()){
                int grlen = matcher.group().length();
                if (grlen > max){
                    max = grlen;
                }
            }
            maxSizes.add(max);
        }
        for (Integer i : maxSizes){
            if (i > maxSize){
                maxSize = i;
            }
        }
        for (int i = 0; i < maxSizes.size(); i++){
            if (maxSizes.get(i) == maxSize){
                result.add(list.get(i));
            }
        }
        for (int i = 0; i < result.size() && i < 10; i++){
            System.out.println(result.get(i));
        }
    }
}