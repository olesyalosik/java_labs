//Лосик Олеси, 7 группа
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Exchanger;

class Sort implements Runnable{

    Exchanger<ArrayList<Integer>> exArray;
    Exchanger<Integer> exOrder;
    ArrayList<Integer> array;
    Integer order;

    Sort(Exchanger<ArrayList<Integer>> exArray, Exchanger<Integer> exOrder){
        this.exArray = exArray;
        this.exOrder = exOrder;
    }

    public void run(){
        System.out.println("Sort started...");
        try{
            array = exArray.exchange(array);
            order = exOrder.exchange(order);
            if(order == 1) {
                Collections.sort(array);
            }
            else {
                Collections.sort(array, Collections.reverseOrder());
            }
            exArray.exchange(array);
        }
        catch(InterruptedException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Sort finised...");
    }

}
