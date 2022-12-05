
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String result1="";
        String result="";
        String[] numbers={"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] inputArray = input.split("[;.,*\s]");
        for(String word : inputArray)
        {
            int tmp=0;
            String [] wordArray=word.split("");
            for(String symbol : wordArray)
            {
                for(String number : numbers)
                {
                    if(symbol.equals(number))
                    {
                        tmp++;
                    }
                }
            }
            if(tmp==word.length())
            {
                result1=result1+word+" ";
            }
            else
            {
                result=result+word+ " ";
            }
        }

        System.out.println(result1+result);
    }
}
