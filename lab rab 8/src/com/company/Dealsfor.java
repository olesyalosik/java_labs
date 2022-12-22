//Лосик Олеси, 7группа
package com.company;

public class Dealsfor {
    private Product product = new Product();
    private Seller seller = new Seller();
    public Dealsfor(Product advertiser, Seller tvShow)
    {
        this.product = advertiser;
        this.seller = tvShow;
    }
    public String advertiser_data()
    {
        return product.toString();
    }
    public String tvShow_data()
    {
        return seller.toString();
    }


}
