
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String result="";
        String result1="";
        String numbers="0123456789";
        StringTokenizer tokenizer=new StringTokenizer(input, ";,.\s*:");
        while(tokenizer.hasMoreTokens())
        {
            String token=tokenizer.nextToken();
            int tmp=0;
            for(int i=0; i<token.length(); i++)
            {
                String symbol= token.substring(i, i+1);
                for(int j=0; j<numbers.length(); j++)
                {
                    String n=numbers.substring(j, j+1);
                    if(symbol.equals(n))
                    {
                        tmp++;
                    }
                }
            }
            if(tmp==token.length())
            {
                result=result+token+" ";
            }
            else
            {
                result1=result1+token+ " ";
            }
        }
        result+=result1;
        System.out.println(result);
        }
}
