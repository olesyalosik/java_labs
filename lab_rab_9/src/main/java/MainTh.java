//Ëîñèê Îëåñè, 7 ãðóïïà
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Exchanger;

class MainTh implements Runnable{

    Exchanger<ArrayList<Integer>> exArray;
    Exchanger<Integer> exOrder;

    MainTh(Exchanger<ArrayList<Integer>> exArray, Exchanger<Integer> exOrder){
        this.exArray = exArray;
        this.exOrder = exOrder;
    }

    public static int SizeOfArray() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input array size: ");
        int size = in.nextInt();
        return size;
    }

    public static ArrayList<Integer> Ñreate(int n) {
        Random random = new Random();
        ArrayList<Integer> arr = new ArrayList<Integer>(n);
        for(int i = 1; i <= n; i++) {
            arr.add(random.nextInt(n) + 1);
        }
        return arr;
    }

    public static void print(ArrayList<Integer> array) {
        System.out.println("Size: " + array.size() + "; Array: " + array);
    }

    public static int Order() {
        System.out.println("Sort order. 1 if in ascending order, else 0");
        Scanner sc = new Scanner(System.in);
        Integer result = sc.nextInt();
        return result;
    }

    public void run(){
        System.out.println("Main started...");
        int size = SizeOfArray();
        ArrayList<Integer> arr = Ñreate(size);
        print(arr);
        try{
            exArray.exchange(arr);
            exOrder.exchange(Order());
            arr = exArray.exchange(arr);
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(arr);
        System.out.println("Main finised...");
    }

}
