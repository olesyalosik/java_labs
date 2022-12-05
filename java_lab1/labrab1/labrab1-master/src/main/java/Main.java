import java.math.BigInteger;
import java.util.Scanner;
import java.lang.Math;
import java.io.IOException;
import java.io.*;
import java.text.*;
import java.math.BigDecimal;
public class Main {
    public static double fact(int a)
    {
        double result=1;
        for(int i=1; i<=a; i++)
        {
            result*=i;
        }
        return result;
    }
    public  static double myPow(double x, int y) {
        double result=1;
        if(y>0){
            for(int i=1; i<=y; i++){
                result*=x;
            }
        }
        else if(y<0){
            for(int i=0; i<=(-y); i++) {
                x /= 10;
            }
            result=x;
        }
        else {
            result=1;
        }
        return result;
    }
    public static double myFunction(double x, double e){
        double y=0;
        double p=x;
        int k=1;
        while(Math.abs(p/fact(k))>e)
        {
            y+=(p/fact(k));
            p*=(-1)*x*x;
            k+=2;
        }
        return y;
    }
    public static void main(String[] args) {
        final double pi=3.1415926535;
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        try {
            System.out.println("Input x: ");
            String line=br.readLine();
            double ourNumber = Double.parseDouble(line);
            while(ourNumber>=(2*pi) || ourNumber<0)
            {
                if(ourNumber<0)
                {
                    ourNumber+=(2*pi);
                }
                else
                {
                    ourNumber-=(2*pi);
                }
            }
            System.out.println("Input natural number k: ");
            String secondLine=br.readLine();
            int ourDegree = Integer.parseInt(secondLine);
            ourDegree = -ourDegree;
            double e = myPow(10, ourDegree);
            System.out.println("Result with standard functions: ");
            double result = Math.sin(ourNumber);
            NumberFormat formatter=NumberFormat.getNumberInstance();
            formatter.setMaximumFractionDigits(3);
            System.out.println(formatter.format(result));
            System.out.println("My result: ");
            double myResult = myFunction(ourNumber, e);
            System.out.println(formatter.format(myResult));
        }
        catch (NumberFormatException e) {
            System.out.println("Not number");
        }
        catch (IOException e) {
            System.out.println("ERROR OF READING");
        }
    }
}