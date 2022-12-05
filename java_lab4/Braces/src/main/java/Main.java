import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;

/*
В текстовом файле input.txt в записаны строки, в которых есть скобки.
Удалить в каждой строке текст в одинарных скобках и эти скобки.
Если есть вложенность, текст во вложенных скобках  не изменять.
Использовать  String,  StringBuffer и StringTokenizer.

Например
В текстовом( файле input.txt в записаны строки), в которых есть скобки.
Удалить (в каждой строке ( текст в (одинарных) )скобках и эти скобки. )
Если есть  (вложенность, )текст (во вложенных )скобках ( не) изменять.
(Использовать  String,  StringBuffer и StringTokenizer.)

Лосик Олеси, 2 курс, 7 группа

*/

public class Main {

    public static PairOfIntegers str_GetBracketsSubstring(String input)
    {
        int first_bracket = input.indexOf('(');
        int counter = 1;
        for(int i = first_bracket + 1; i < input.length(); i++)
        {
            if (input.charAt(i) == '(')
            {
                counter++;
            }
            else if (input.charAt(i) == ')')
            {
                counter--;
            }
            if (counter == 0)
            {
                return new PairOfIntegers(first_bracket + 1, i);
            }
        }
        return new PairOfIntegers(0, input.length());
    }
    public static String Str_ClearOfSingleBrackets(String workOn)
    {
        String result = new String();
        boolean wasRedacted = false;
        while (workOn.length() != 0) {
            PairOfIntegers InnerIterators = str_GetBracketsSubstring(workOn);
            String workOnInner = workOn.substring(InnerIterators.int1, InnerIterators.int2);
            String resultIn = new String();

            while (workOnInner.length() != 0) {
                PairOfIntegers Inner2Iterators = str_GetBracketsSubstring(workOnInner);
                if(Inner2Iterators.int2 == workOnInner.length())
                {
                    break;
                }
                resultIn += workOnInner.substring(Inner2Iterators.int1 - 1, Inner2Iterators.int2 + 1);
                workOnInner = workOnInner.substring(Inner2Iterators.int2 + 1);
            }
            if (InnerIterators.int1 > 0) {
                result += workOn.substring(0, InnerIterators.int1 - 1) + resultIn;
            }
            else
            {
                result += resultIn;
            }
            if(InnerIterators.int1 == 0)
            {
                if (wasRedacted) {
                    result += workOnInner.substring(0, InnerIterators.int2);
                }
                break;
            }
            workOn = workOn.substring(InnerIterators.int2+ 1);
            wasRedacted = true;
        }

        return result;
    }

    public static void main(String[] args)  throws IOException
    {
        try {
            File file = new File("input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String line = new String();
            ArrayList<String> FileStrings = new ArrayList<String>();

            Stream<String> stream = reader.lines();
            stream.forEach(s -> FileStrings.add(s));

            for (int j = 0; j<FileStrings.size(); j++)
            {
                FileStrings.set(j, Str_ClearOfSingleBrackets(FileStrings.get(j)));
                System.out.println(FileStrings.get(j));
            }

        }
        catch (IOException e) {
            System.out.println("Error of reading from file");
        }
    }
}