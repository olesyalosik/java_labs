//Лосик Олеси, 7группа
package com.company;

public class Product extends DealsAbstract {
    //о товаре: название товара, вид,
    // цена единицы товара на момент поступления,
    // цена единицы товара на данный момент, количество поставленных единиц
    static int id = 0;
    private int index;
    private String name;
    private String type;
    private int cost_first;
    private int cost_last;
    private int number;
    public Product(String []str)
    {
        try
        {
            id++;
            index = id;
            name=str[0];
            type=str[1];
            cost_first=Integer.parseInt(str[2]);
            cost_last=Integer.parseInt(str[3]);
            number=Integer.parseInt(str[4]);
        }
        catch (Exception ex)
        {
            System.out.println("Something went wrong");
        }
    }
    public Product(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return "Product name: " + name + "\ntype of product: " + type+"\ncost_first: " +
                cost_first+"\ncost_last: " + cost_last+"\nnumber: " + number+"\n\n";
    }
    public int get_index()
    {
        return index;
    }
    public boolean equals(Object o) {
        Product product = (Product) o;
        return name.compareTo(product.name) == 0 &&
                type.compareTo(product.type) == 0 &&
                cost_first==product.cost_first&&
                cost_last==product.cost_last&&
                number==product.number;
    }

}
