import java.util.*;
import java.util.Scanner;


public class Mainnew {
    public static int FindMin(Vector<Vector<Integer>> matr)
    {
        int MIN = matr.get(0).get(0);
        for (int i = 0; i < matr.size(); i++)
        {
            for (int j = 0; j < matr.get(i).size(); j++)
            {
                if (matr.get(i).get(j) <= MIN)
                {
                    MIN = matr.get(i).get(j);
                }
            }
        }
        return MIN;
    }
    public static int IndexCol( Vector<Vector<Integer>> matr)
    {
        int index = 0;
        int MIN=FindMin(matr);
        for (int i = 0; i < matr.size(); i++)
        {
            for (int j = 0; j < matr.get(i).size(); j++)
            {
                if (matr.get(i).get(j) <= MIN)
                {
                    index = j;
                }
            }
        }
        return index;
    }

    public static int IndexRow(Vector<Vector<Integer>> matr) {
        int index = 0;
        int MIN = FindMin(matr);
        for (int i = 0; i < matr.size(); i++) {
            for (int j = 0; j < matr.get(i).size(); j++) {
                if (matr.get(i).get(j) <= MIN) {
                    index = i;
                }
            }
        }
        return index;
    }

    public static void MyFunction(Vector<Vector<Integer>> matr)
    {
        int indexcol=IndexCol(matr);
        int indexrow=IndexRow(matr);
        for(int i=indexrow; i<(matr.size()-1); i++)
        {
            for(int j=0; j<matr.get(0).size(); j++)
            {
                int temp=matr.get(i+1).get(j);
                matr.get(i+1).set(j, matr.get(i).get(j));
                matr.get(i).set(j, temp);
            }
        }
        for(int j=indexcol; j<(matr.get(0).size()-1); j++)
        {
            for(int i=0; i<matr.size(); i++)
            {
                int temp=matr.get(i).get(j+1);
                matr.get(i).set((j+1), matr.get(i).get(j));
                matr.get(i).set(j, temp);
            }
        }
    }

    public static void main(String[] args)
    {
         int dim_1;
         int dim_2;

         int click;

         Vector<Vector<Integer>> matrix;
         Vector<Integer> tmp;

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the first dimension:");
        dim_1=scanner.nextInt();
        System.out.println("Enter the second dimension:");
        dim_2=scanner.nextInt();
        Random rnd = new Random();
        matrix = new Vector();
        tmp = new Vector();
        System.out.println("Enter 1, if random matrix. Enter 0, if you want to input matrix yourself");
        click=scanner.nextInt();
        if(click==1)
        {for (int i = 0; i < dim_1; i++) {
            for (int j = 0; j < dim_2; j++) {
                tmp.add(rnd.nextInt(20));
            }
            matrix.add(tmp);
            tmp = new Vector();
        }
            for (int i = 0; i < dim_1; i++) {
                for (int j = 0; j < dim_2; j++) {
                    System.out.print(matrix.get(i).get(j) + " ");
                }
                System.out.println("");
            }
        }
        if(click==0)
        {
            System.out.println("Enter your matrix:");
            for (int i = 0; i < dim_1; i++) {
                for (int j = 0; j < dim_2; j++) {
                    tmp.add(scanner.nextInt());
                }
                matrix.add(tmp);
                tmp = new Vector();
            }
        }
        MyFunction(matrix);
        for (int i = 0; i < dim_1; i++) {
            for (int j = 0; j < dim_2; j++) {
                System.out.print(matrix.get(i).get(j) + " ");
            }
            System.out.println("");
        }
    }
}

