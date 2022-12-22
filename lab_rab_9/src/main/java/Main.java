//Лосик Олеси, 7 группа
import java.util.ArrayList;
import java.util.concurrent.Exchanger;

public class Main {



    public static void main(String[] args) {

        Exchanger<ArrayList<Integer>> exArray = new Exchanger<>();
        Exchanger<Integer> exOrder = new Exchanger<>();
        new Thread(new MainTh(exArray, exOrder)).start();
        new Thread(new Sort(exArray, exOrder)).start();
    }
}