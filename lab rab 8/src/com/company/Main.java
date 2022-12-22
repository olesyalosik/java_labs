//Лосик Олеси, 7группа
package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//        String[] arguments_1 = {"Fudziyama","France", "12.12.2000", "gadgets", "30", "850"};
//        Seller seller = new Seller(arguments_1);
//        System.out.println(seller);
//        String[] arguments_2 = {"Samsung", "phones", "300", "450", "50"};
//        Product product = new Product(arguments_2);
//        System.out.println(product);
//        Dealsfor commercialBreak = new Dealsfor(product, seller);
//        System.out.println(commercialBreak.advertiser_data());
//        System.out.println(commercialBreak.tvShow_data());
        try {
            Deals ads = new Deals();
            ads.search_company_name();
            ads.menu();
        }
        catch (Exception ex)
        {

        }
    }
}
