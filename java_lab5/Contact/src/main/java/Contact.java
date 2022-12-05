import java.sql.Array;
import java.util.*;

/*
1) Задача "контакты"
а) разработать класс Контакт, определяющий запись в электронной книге мобильного
телефона и содержащий по меньшей мере следующие поля:
- *Наименование (имя человека или организации)
- *Номер телефона мобильного
- Номер телефона рабочего
- Номер телефона (домашнего)
- Адрес электронной почты
- Адрес веб-страницы
- Адрес

Обязательными является поля помеченные *, остальные поля могут быть пустыми

б) класс Контакт должен реализовать:
-интерфейс Comparable и Comparator с возможностью выбора одного из полей для сравнения
-интерфейс Iterator - индексатор по всем полям объекта Контакт
-метод для сохранения значений всех полей в строке текста (переопределить toString())
-конструктор или метод для инициализации объекта из строки текста
*/
public class Contact implements Comparable<Contact>{
    static public class NotEnoughInfo extends Throwable {}
    static public class TooMuchInfo extends Throwable {}
    ArrayList<String> Users;
    public Contact(String Name, String MobilePhone,String JobPhone, String HomePhone, String EMail, String WEB, String HomeAddress)
    {
        Users=new ArrayList<>();
        Users.add(Name);
        Users.add(MobilePhone);
        Users.add(JobPhone);
        Users.add(HomePhone);
        Users.add(EMail);
        Users.add(WEB);
        Users.add(HomeAddress);
    }

    public Contact(String input, String delimiter) throws NotEnoughInfo, TooMuchInfo
    {
        String[] inputSplitted = input.split(delimiter);
        if (inputSplitted.length < 2)
        {
            throw new NotEnoughInfo();
        }
        else if(inputSplitted.length > 7)
        {
            throw new TooMuchInfo();
        }
        else
        {
            Users = new ArrayList<>();
            Users.addAll(Arrays.asList(inputSplitted));
        }
    }

    public Contact()
    {
        Users=new ArrayList<>();
        Users.add("");
        Users.add("");
        Users.add("");
        Users.add("");
        Users.add("");
        Users.add("");
        Users.add("");
    }
    public String GetName()
    {
        return Users.get(0);
    }
    public String GetMobilePhone()
    {
        return Users.get(1);
    }
    public String GetJobPhone()
    {
        return Users.get(2);
    }
    public String GetHomePhone()
    {
        return Users.get(3);
    }
    public String GetEMail()
    {
        return Users.get(4);
    }
    public String GetWEB()
    {
        return Users.get(5);
    }
    public String GetHomeAddress()
    {
        return Users.get(6);
    }
    public void SetName(String Name)
    {
       Users.set(0, Name);
    }
    public void SetMobilePhone(String MobilePhone)
    {
        Users.set(1, MobilePhone);
    }
    public void SetJobPhone(String JobPhone)
    {
        Users.set(2, JobPhone);
    }
    public void SetHomePhone(String HomePhone)
    {
        Users.set(3, HomePhone);
    }
    public void SetEMail(String EMail)
    {
        Users.set(4, EMail);
    }
    public void SetWEB(String WEB)
    {
        Users.set(5, WEB);
    }
    public void SetHomeAddress(String HomeAddress)
    {
        Users.set(6, HomeAddress);
    }

//
//    static Contact fromString(String input, String delimiter){
//
//        String[] strs = input.split(delimiter);
//        return new Contact(strs[0], strs[1], strs[2], strs[3], strs[4],strs[5],strs[6]);
//    }

    public Iterator<String> iterator(){
        return Users.iterator();

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (String data : Users){
            res.append(data).append(" ");
        }
        return res.toString();
    }

    public int compareTo(Contact user)
    {
        return Users.get(0).compareTo(user.Users.get(0));
    }
    static class ContactComparatorName implements Comparator<Contact> {

        @Override
        public int compare(Contact user1, Contact user2){

            return user1.Users.get(0).compareTo(user2.Users.get(0));
        }

    }

    static class ContactComparatorMobilePhone implements Comparator<Contact> {
        @Override
        public int compare(Contact user1, Contact user2){

            return user1.Users.get(1).compareTo(user2.Users.get(1));
        }
    }

    static class ContactComparatorWorkPhone implements Comparator<Contact> {
        @Override
        public int compare(Contact user1, Contact user2)
        {
            if (user1.Users.size() > 2 && user2.Users.size() > 2)
            {
                return user1.Users.get(2).compareTo(user2.Users.get(2));
            }
            else
            {
                Integer size1 = user1.Users.size();
                Integer size2 = user2.Users.size();
                return size1.compareTo(size2);
            }
        }
    }

    static class ContactComparatorHomePhone implements Comparator<Contact> {
        @Override
        public int compare(Contact user1, Contact user2)
        {
            if (user1.Users.size() > 3 && user2.Users.size() > 3)
            {
                return user1.Users.get(3).compareTo(user2.Users.get(3));
            }
            else
            {
                Integer size1 = user1.Users.size();
                Integer size2 = user2.Users.size();
                return size1.compareTo(size2);
            }
        }
    }

    static class ContactComparatorEMail implements Comparator<Contact> {
        @Override
        public int compare(Contact user1, Contact user2)
        {
            if (user1.Users.size() > 4 && user2.Users.size() > 4)
            {
                return user1.Users.get(4).compareTo(user2.Users.get(4));
            }
            else
            {
                Integer size1 = user1.Users.size();
                Integer size2 = user2.Users.size();
                return size1.compareTo(size2);
            }
        }
    }

    static class ContactComparatorWEB implements Comparator<Contact> {
        @Override
        public int compare(Contact user1, Contact user2)
        {
            if (user1.Users.size() > 5 && user2.Users.size() > 5)
            {
                return user1.Users.get(5).compareTo(user2.Users.get(5));
            }
            else
            {
                Integer size1 = user1.Users.size();
                Integer size2 = user2.Users.size();
                return size1.compareTo(size2);
            }
        }
    }

    static class ContactComparatorHomeAddress implements Comparator<Contact> {
        @Override
        public int compare(Contact user1, Contact user2)
        {
            if (user1.Users.size() > 6 && user2.Users.size() > 6)
            {
                return user1.Users.get(6).compareTo(user2.Users.get(6));
            }
            else
            {
                Integer size1 = user1.Users.size();
                Integer size2 = user2.Users.size();
                return size1.compareTo(size2);
            }
        }
    }
    static class ContactComparator implements Comparator<Contact> {
        @Override
        public int compare(Contact user1, Contact user2)
        {
            if (user1.Users.size()==user2.Users.size())
            {
                int i=-1;
                while(i<user1.Users.size())
                {
                    i++;
                    if(!user1.Users.get(i).equals( user2.Users.get(i)))
                    {
                        return user1.Users.get(i).compareTo(user2.Users.get(i));
                    }
                }
                return 0;
            }
            else
            {
                Integer size1 = user1.Users.size();
                Integer size2 = user2.Users.size();
                return size1.compareTo(size2);
            }
        }
    }

}
