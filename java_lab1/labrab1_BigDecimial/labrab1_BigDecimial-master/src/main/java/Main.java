import java.math.BigDecimal;
import java.math.RoundingMode;
import java.lang.Math;
import java.io.IOException;
import java.io.*;
import java.text.*;

public class Main {

    public static void main(String[] args) {
        final BigDecimal pi=new BigDecimal(3.1415926535);
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        try {
            System.out.println("Input x : ");
            String line=br.readLine();
            double ourNumber2 = Double.parseDouble(line);
            BigDecimal ourNumber = new BigDecimal(line);
            BigDecimal p= new BigDecimal(line);
            System.out.println("Input natural number k: ");
            String secondLine=br.readLine();
            BigDecimal ourDegree = new BigDecimal(secondLine);
            BigDecimal first= new BigDecimal(1.0);
            BigDecimal ten= new BigDecimal(10.0);
            BigDecimal two=new BigDecimal(2.0);
            BigDecimal zero=new BigDecimal(0);
            BigDecimal newDegree=new BigDecimal(ourDegree.doubleValue());
            BigDecimal e=new BigDecimal(1.0);
            BigDecimal doublepi=pi.multiply(two);
            for(int i=0; i<ourDegree.intValue(); i++) {
                e = e.divide(ten);
            }
            while(ourNumber.compareTo(doublepi)>=0 || ourNumber.compareTo(zero) < 0)
            {
                if(ourNumber.compareTo(zero) < 0)
                {
                    ourNumber=ourNumber.add(doublepi);
                }
                else
                {
                    ourNumber=ourNumber.subtract(doublepi);
                }
            }
            System.out.println("my result: ");
            BigDecimal result = new BigDecimal(0);
            BigDecimal one=new BigDecimal(-1);
            BigDecimal i1=new BigDecimal(1);
            p=ourNumber;
            result = result.add(p);
            BigDecimal temp = new BigDecimal(p.doubleValue());
            BigDecimal i = new BigDecimal(1);
            while(temp.abs().compareTo(e) >=0)
            {
                p=p.multiply(ourNumber);
                p=p.multiply(ourNumber);
                p=p.multiply(one);
                i = i.add(first);
                i1 = i1.multiply(i);
                i = i.add(first);
                i1 = i1.multiply(i);
                temp=p.divide(i1, ourDegree.intValue() + 5,RoundingMode.HALF_UP);
                result=result.add(temp);
            }
            NumberFormat formatter=NumberFormat.getNumberInstance();
            formatter.setMaximumFractionDigits(3);
            System.out.println(formatter.format(result));
            System.out.println("Result with standard functions:");
            System.out.println(Math.sin(ourNumber2));
        }
        catch (NumberFormatException e) {
            System.out.println("Not number");
        }
        catch (IOException e) {
            System.out.println("ERROR OF READING");
        }
    }
}