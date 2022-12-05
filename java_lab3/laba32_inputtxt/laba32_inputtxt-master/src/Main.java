
import java.io.IOException;
import java.nio.file.Files ;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        Path path = Path.of("input.txt");
        List<Integer> maxSizes = new ArrayList<>();
        List<String> result = new ArrayList<>();
        String[] numbers={"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
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
            int max=0;
            List<String> strArray = new ArrayList<>(Arrays.asList(str.split("")));
            strArray.add("a");
            String tmp = "";
            for(String symbol : strArray)
            {
                boolean f = false;
                for(String number : numbers)
                {
                    if(symbol.equals(number))
                    {
                        f = true;
                        break;
                    }
                }
                if (!f){
                    if(tmp.length()>=max)
                    {
                        max=tmp.length();
                    }
                    tmp = "";
                }
                else {
                    tmp += symbol;
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