import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void Matrix(int matr[][]) //ввод матрицы рандомно
    {
        Random numb = new Random();
        for(int i = 0; i < matr.length; i++)
            for (int j = 0; j < matr[i].length; j++)
            {
                matr[i][j] = numb.nextInt() % 100;
            }
    }
    public static void Matrix1(int matr[][]) //ввод матрицы вручную
    {

        for(int i = 0; i < matr.length; i++)
            for (int j = 0; j < matr[i].length; j++) {
                Scanner sc = new Scanner(System.in);
                String a = sc.next();
                int numb = Integer.parseInt(a);
                matr[i][j]=numb;
            }
    }
    public static void Print(int matr[][])
    {
        System.out.println("Matrix:");
        for(int i = 0; i < matr.length; i++)
        {
            for (int j = 0; j < matr[i].length; j++)
            {
                System.out.print(matr[i][j] + " ");
            }
            System.out.print('\n');
        }
    }
    public static int FindCount(int matr[][])
    {
        int count=0;
        for(int i=0; i<matr.length; i++)
        {
            int temp=0;
            for(int j=0; j<matr[i].length; j++)
            {
                if(matr[j][i]>=(-10) && matr[j][i]<=(-1))
                {
                    temp++;
                }
            }
            if(temp==matr.length)
            {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args)
    {
        System.out.println("Enter matrix size: ");
        Scanner sc = new Scanner(System.in);
        String numbS = sc.next();
        int numb = Integer.parseInt(numbS);
        if(numb > 0)
        {
            int matr[][] = new int[numb][numb];
            System.out.println("If you want to input matrix by yourself, click 1. If you want to get matrix with random integers, click 0 ");
            String clickS=sc.next();
            int click = Integer.parseInt(clickS);
            if(click==1)
            {Matrix1(matr);}
            if(click==0)
            {Matrix(matr);}
            Print(matr);
            int result= FindCount(matr);
            System.out.println(result);
        }
        else
            System.out.println("Wrong matrix size!");
    }
}
