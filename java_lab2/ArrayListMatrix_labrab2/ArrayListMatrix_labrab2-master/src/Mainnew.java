import java.util.*;
import java.util.Scanner;

public class Mainnew {

public static void MyFunction(ArrayList<ArrayList<Integer>>  matr)
{
    for(int j=0; j<matr.get(0).size(); j++)
    {
        int count=0;
        for(int i=1; i<matr.size()-1; i++)
        {
            if((matr.get(i).get(j)>=matr.get(i+1).get(j) && matr.get(i).get(j)<=matr.get(i-1).get(j))||(matr.get(i).get(j)<=matr.get(i+1).get(j) && matr.get(i).get(j)>=matr.get(i-1).get(j)))
            {
                count++;
            }
        }
        if(count==matr.size()-2)
        {
            System.out.println(j+1);
        }
    }
}

    public static void main(String[] args) {
        int dim_1;
        int dim_2;

        int click1;

        ArrayList<ArrayList<Integer>> matrix;
        ArrayList<Integer> tmp;

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the first dimension:");
        dim_1=scanner.nextInt();
        System.out.println("Enter the second dimension:");
        dim_2=scanner.nextInt();
        Random rnd = new Random();
        matrix = new ArrayList();
        tmp = new ArrayList();
        System.out.println("Enter 1, if random matrix. Enter 0, if you want to input matrix yourself");
        click1=scanner.nextInt();
        if(click1==1)
        { for (int i = 0; i < dim_1; i++)
        {
            for (int j = 0; j < dim_2; j++)
            {
                tmp.add(rnd.nextInt(10));
            }
            matrix.add(tmp);
            tmp = new ArrayList();
        }
        }
        else if(click1==0)
        {
            System.out.println("Enter your matrix:");
            for (int i = 0; i < dim_1; i++)
            {
                for (int j = 0; j < dim_2; j++)
                {
                    tmp.add(scanner.nextInt());
                }
                matrix.add(tmp);
                tmp = new ArrayList();
            }
        }
        for (int i = 0; i < dim_1; i++) {
            for (int j = 0; j < dim_2; j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println("");
        }
            MyFunction(matrix);
        }
}