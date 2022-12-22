//Лосик Олеси, 7группа
package com.company;

import javax.imageio.IIOException;
import java.beans.ExceptionListener;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.*;

public class Deals implements DealsInterface {
    static final String path_1 = "seller";
    static final String path_2 = "product";
    private HashMap<Integer, Product> product = new HashMap<>();
    private HashMap<Integer, Seller> seller = new HashMap<>();

    public Deals() throws IOException {
        read(path_1, path_2);
    }

    @Override
    public void read(String path_1, String path_2) throws IOException {
        FileReader fr_seller = new FileReader(path_1);
        Scanner scanner = new Scanner(fr_seller);
        FileReader fr_product = new FileReader(path_2);
        while (scanner.hasNextLine()) {
            String data_for_object = scanner.nextLine();
            String args[] = data_for_object.split(",");
            Seller tvShow_obj = new Seller(args);
            seller.putIfAbsent(tvShow_obj.get_index(), tvShow_obj);

        }
        scanner = new Scanner(fr_product);
        while (scanner.hasNextLine()) {
            String data_for_object = scanner.nextLine();
            String args[] = data_for_object.split(",");
            Product ads = new Product(args);
            product.putIfAbsent(ads.get_index(), ads);

        }
        fr_product.close();
        fr_seller.close();
    }


    @Override
    public void write(String path_1, String path_2) throws IOException {
        FileWriter fw_1 = new FileWriter(path_1);
        FileWriter fw_2 = new FileWriter(path_2);
        for (Seller value : seller.values()) {
            fw_1.write(value.toString());
        }
        for (Product value : product.values()) {
            fw_2.write(value.toString());
        }
        fw_1.close();
        fw_2.close();
    }

    @Override
    public void serialization() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("project.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }

    @Override
    public void deserialization() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("project.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Deals tmp = (Deals) objectInputStream.readObject();
        product = tmp.product;
        seller = tmp.seller;
        objectInputStream.close();
    }
    public void serialization_XML(String filename) throws IIOException, FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(filename);
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.setExceptionListener(new ExceptionListener() {
            @Override
            public void exceptionThrown(Exception e) {
                System.out.println(e.toString());
            }
        });
        encoder.writeObject(product);
        encoder.writeObject(seller);
        encoder.close();


    }
    public void search_company_name()
    {
        System.out.println("Please, enter data following the next order: name of product\n");
        Scanner sc = new Scanner(System.in);
        String data_1 = sc.nextLine();
        boolean flag = false;
        System.out.println("And one more time: surname of seller\n");
       String data_2 = sc.nextLine();

        for (Product value_1 : product.values()) {
            for (Seller value_2 : seller.values()) {
                if (value_2.getSurname().equals(data_2) && value_1.getName().equals(data_1)) {
                    flag = true;
                    System.out.println("Look, what i found:\n" + value_2 + value_1);
                }

            }
        }
        if (!flag) {
            System.out.println("Didn't find anything");
        }
        sc.close();
    }
    @Override
    public void search() {
        System.out.println("Please, enter data following the next order: product name, type of product, cost_first, cost_last, number\nNote: don't use any extra spaces\n");
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        ArrayList<String> arrayList_for_ads = new ArrayList<>(Arrays.asList(data.split(",")));
        Product tmp_product = new Product(arrayList_for_ads.toArray(new String[0]));
        boolean flag = false;
        System.out.println("And one more time: surname, address, birthday, category, percent, salary\nNote: don't use any extra spaces\n");
        data = sc.nextLine();
        ArrayList<String> arrayList_for_seller = new ArrayList<>(Arrays.asList(data.split(",")));
        Seller tmp_seller = new Seller(arrayList_for_seller.toArray(new String[0]));
        for (Product value_1 : product.values()) {
            for (Seller value_2 : seller.values()) {
                if (tmp_product.equals(value_1) && tmp_seller.equals(value_2)) {
                    flag = true;
                    System.out.println("Look, what i found:\n" + value_2 + value_1);
                }

            }
        }
        if (!flag) {
            System.out.println("Didn't find anything");
        }
        sc.close();
    }

    @Override
    public void add(int param) {
        switch (param) {
            case (1) -> {
                System.out.println("Please, enter data following the next order: product name, type of product, cost_first, cost_last, number\nNote: don't use any extra spaces\n");
                Scanner sc = new Scanner(System.in);
                String data = sc.nextLine();
                Product tmp = new Product(data.split(","));
                if (!product.containsValue(tmp)) {
                    product.put(tmp.get_index(), tmp);
                    System.out.println("Added successfully!");
                } else System.out.println("Wrong input or product already exists!");
            }
            case (2) -> {
                System.out.println("Please, enter data following the next order: surname, address, birthday, category, percent, salary\nNote: don't use any extra spaces\n");
                Scanner sc = new Scanner(System.in);
                String data = sc.nextLine();
                Seller tmp = new Seller(data.split(","));
                if (!seller.containsValue(tmp)) {
                    seller.put(tmp.get_index(), tmp);
                    System.out.println("Added successfully!");
                } else System.out.println("Wrong input or seller already exists!");
            }
        }
    }

    @Override
    public void delete(int param) {
        switch (param) {
            case (1) -> {
                System.out.println("Please, enter data following the next order: product name, type of product, cost_first, cost_last, number\nNote: don't use any extra spaces\n");
                Scanner sc = new Scanner(System.in);
                String data = sc.nextLine();
                Product tmp = new Product(data.split(","));
                ArrayList<Integer> list_ok_keys = new ArrayList<>();
                if (!product.containsValue(tmp)) {
                    System.out.println("The object is not in the map!");
                } else {
                    for (Integer key : product.keySet()) {
                        if (product.get(key).equals(tmp)) {
                            list_ok_keys.add(key);
                        }
                    }
                }
                    for (Integer key: list_ok_keys) {
                        product.remove(key);
                    }
                    System.out.println("Removed successfully!");

            }
            case (2) -> {
                System.out.println("Please, enter data following the next order: surname, address, birthday, category, percent, salary\nNote: don't use any extra spaces\n");
                Scanner sc = new Scanner(System.in);
                String data = sc.nextLine();
                Seller tmp = new Seller(data.split(","));
                ArrayList<Integer> list_ok_keys = new ArrayList<>();
                if (!seller.containsValue(tmp)) {
                    System.out.println("Object is not in the map!");
                } else {
                    for (Integer key : seller.keySet()) {
                        if (seller.get(key).equals(tmp)) {
                            list_ok_keys.add(key);
                        }
                    }

                        for (Integer key: list_ok_keys) {
                            seller.remove(key);
                        }
                        System.out.println("Removed successfully!");
                    }


            }
        }
    }
//    "Please, enter data following the next order: product name, type of product, cost_first, cost_last, number\nNote: don't use any extra spaces\n"
//            "Please, enter data following the next order: surname, address, birthday, category, percent, salary\nNote: don't use any extra spaces\n"
    public void show() {
        System.out.println("Products: ");
        for (Product value : product.values()) {

            System.out.println(value);
        }
        System.out.println("Sellers: ");
        for (Seller value : seller.values()) {

            System.out.println(value);
        }

    }

    @Override
    public void update(int param) {
        switch (param) {
            case (1) -> {
                System.out.println("Please, enter data following the next order: product name, type of product, cost_first, cost_last, number\nNote: don't use any extra spaces\n");
                Scanner sc = new Scanner(System.in);
                String data = sc.nextLine();
                Product tmp = new Product(data.split(","));
                if (!product.containsValue(tmp)) {
                    System.out.println("The object is not in the map!");
                } else {
                    ArrayList<Integer> list_of_keys = new ArrayList<>();
                    for (Integer key : product.keySet()) {
                        if (product.get(key).equals(tmp)) {
                            list_of_keys.add(key);
                        }
                    }
                    System.out.println("Please, enter data following the next order: surname, address, birthday, category, percent, salary\nNote: don't use any extra spaces\n");
                    data = sc.nextLine();

                    for (Integer key : list_of_keys) {
                        product.remove(key);
                        Product updated_tmp = new Product(data.split(","));
                        product.put(updated_tmp.get_index(), updated_tmp);
                    }
                    System.out.println("Updated successfully!");
                }
            }
            case (2) -> {
                System.out.println("Please, enter data following the next order: surname, address, birthday, category, percent, salary\nNote: don't use any extra spaces\n");
                Scanner sc = new Scanner(System.in);
                String data = sc.nextLine();
                Seller tmp = new Seller(data.split(","));
                if (!seller.containsValue(tmp)) {
                    System.out.println("Object is not in the map!");
                } else {
                    ArrayList<Integer> list_of_keys = new ArrayList<>();
                    for (Integer key : seller.keySet()) {
                        if (seller.get(key).equals(tmp)) {
                            list_of_keys.add(key);
                        }
                    }
                    System.out.println("Please, enter data following the next order: surname, address, birthday, category, percent, salary\nNote: don't use any extra spaces\n");
                    data = sc.nextLine();

                    for (Integer key : list_of_keys) {
                        seller.remove(key);
                        Seller updated_tmp = new Seller(data.split(","));
                        seller.put(updated_tmp.get_index(), updated_tmp);
                    }
                    System.out.println("Updated successfully!");
                }
            }
        }

    }

    public void show_menu(int param) {
        switch (param) {
            case (1) -> System.out.println("""
                    To add product press 1\s
                    To delete product press 2\s
                    To update product press 3\s
                    To go to main menu press 0\s
                    """);
            case (2) -> System.out.println("""
                    To add seller press 1\s
                    To delete seller press 2\s
                    To update seller press 3\s
                    To go to main menu press 0\s
                    """);
            case (3) -> System.out.println(
                    """
                            To search deals press 1\s
                            To go to main menu press 0\s
                            """);
            default -> System.out.println("""
                    To work with products press 1\s
                    To work with sellers press 2\s
                    To work with commercial breaks press 3\s
                    To show current maps press 4\s
                    To exit press 0\s
                    """);
        }
    }

    public void menu() throws IOException {
        show_menu(0);
        Scanner sc = new Scanner(System.in);
        String command = sc.next();
        switch (Integer.parseInt(command)) {
            case (0) -> {
                write("seller_output", "product_output");
                serialization();
                System.exit(0);
            }
            case (1) -> {
                show_menu(1);
                Scanner sc1 = new Scanner(System.in);
                String command1 = sc1.next();
                switch (Integer.parseInt(command1)) {
                    case (0) -> menu();
                    case (1) -> {
                        add(1);
                        menu();
                    }
                    case (2) -> {
                        delete(1);
                        menu();
                    }
                    case (3) -> {
                        update(1);
                        menu();
                    }

                }
            }
            case (2) -> {
                show_menu(2);
                Scanner sc2 = new Scanner(System.in);
                String command2 = sc2.next();
                switch (Integer.parseInt(command2)) {
                    case (0) -> menu();
                    case (1) -> {
                        add(2);
                        menu();
                    }
                    case (2) -> {
                        delete(2);
                        menu();
                    }
                    case (3) -> {
                        update(2);
                        menu();
                    }

                }
            }
            case (3) -> {
                show_menu(3);
                Scanner sc3 = new Scanner(System.in);
                String command3 = sc3.next();
                switch (Integer.parseInt(command3)) {
                    case (0) -> menu();
                    case (1) -> {
                        search();
                        menu();
                    }
                }
            }
            case (4) -> {
                show();
                menu();

            }
        }
    }
}




