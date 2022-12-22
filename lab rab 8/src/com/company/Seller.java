//Лосик Олеси, 7группа
package com.company;

import java.beans.ExceptionListener;
import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;

public class Seller extends DealsAbstract
{
    static int id = 0;
    private int index;
    private String surname;
    private String address;
    private String birthday;
    private String category;
    private int percent;
    private int salary;

    public Seller(String []str)
    {
        try{
        id++;
        index=id;
        surname=str[0];
        address=str[1];
        birthday=str[2];
        category=str[3];
        percent=Integer.parseInt(str[4]);
        salary=Integer.parseInt(str[5]);
        }
        catch (Exception ex)
        {
            System.out.println("Something went wrong...");
        }
    }
    public Seller(){}

    @Override
    public String toString(){
        return "Surname: " + surname + "\naddress: " + address + "\nbirthday: " + birthday +
                "\ncategory: " + category + "\npercent: " + percent +
                "\nsalary: "+salary+ "\n\n";
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Seller.id = id;
    }
    public int get_index()
    {
        return index;
    }
    public void serialization_XML(String filename, XMLEncoder encoder) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        encoder.setExceptionListener(new ExceptionListener() {
            public void exceptionThrown(Exception e) {
                System.out.println(e.toString());
            }
        });
        encoder.writeObject(this);
        encoder.close();
        fos.close();
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean equals(Object o) {
        Seller seller = (Seller) o;
        return surname.compareTo(seller.surname) == 0 && address.compareTo(seller.address)==0&&
               birthday.compareTo(seller.birthday) == 0 && category.compareTo(seller.category)==0 &&
                percent== seller.percent && salary == seller.salary;
    }

}
