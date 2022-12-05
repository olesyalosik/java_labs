/*
Модифицировать условие задачи учитывая свои пожелания
Возможно  авторское условие задачи
Использовать контейнеры:
 Vector, ArrayList, LinkedList, HashSet, TreeSet, HashMap, TreeMap.)

в) Для тестирования класса Контакт, создать консольное приложение позволяющее
создать небольшой массив контактов и напечатать отсортированными по
выбранному полю.
*/

import java.io.*;
import java.util.*;

public class Main {

        public static class NoSuchComparator extends Throwable{}

        public static void main(String[] args) throws IOException, Contact.NotEnoughInfo, Contact.TooMuchInfo, ArrayIndexOutOfBoundsException, NoSuchComparator
        {
            FileReader buf2 = new FileReader("input.txt");
            BufferedReader fileIn = new BufferedReader(buf2);
            try {
                InputStreamReader buf = new InputStreamReader(System.in);
                BufferedReader In = new BufferedReader(buf);

                System.out.println("Delimiters: ");
                String delimiters = In.readLine();
                System.out.println("Number of member of class Contact for sorting(1-7) or input 8, if compare all members ");
                int numCompare = Integer.parseInt(In.readLine());

                String input;
                ArrayList<Contact> contactsFile = new ArrayList<>();
                TreeSet<Contact> contactsFileTree= new TreeSet<>();
                while (true) {
                    input = fileIn.readLine();
                    if (input == null)
                    {break;}
                    Contact user = new Contact(input, delimiters);
                    contactsFileTree.add(user);
                    contactsFile.add(user);
                }

                Comparator<Contact> compare;
                switch (numCompare)
                {
                    case 1 -> compare = new Contact.ContactComparatorName();
                    case 2 -> compare = new Contact.ContactComparatorMobilePhone();
                    case 3 -> compare = new Contact.ContactComparatorWorkPhone();
                    case 4 -> compare = new Contact.ContactComparatorHomePhone();
                    case 5 -> compare = new Contact.ContactComparatorEMail();
                    case 6 -> compare = new Contact.ContactComparatorWEB();
                    case 7 -> compare = new Contact.ContactComparatorHomeAddress();
                    case 8 -> compare=new Contact.ContactComparator();
                    default -> throw new NoSuchComparator();
                }

                contactsFile.sort(compare);

                System.out.println("Sorted with comparator ArrayList  " + numCompare +":");
                for (Contact cont : contactsFile) {
                    System.out.println(cont);
                }

                System.out.println();
                System.out.println("TreeSet with basic compare (property Comparable)" + ":");
                for (Contact contTree: contactsFileTree)
                {
                    System.out.println(contTree);
                }

                System.out.println();
                System.out.println("ArrayList[i] (i = 1...size) with iterator Contacts");
                for (Contact cont : contactsFile) {
                    Iterator<String> itFirst = cont.iterator();
                    int i = 1;
                    while (itFirst.hasNext()) {
                        System.out.print("Member " + i + ": " + itFirst.next() + " | ");
                        i++;
                    }
                    System.out.println();
                }
            }
            catch (IOException e)
            {
                System.out.println(e.getLocalizedMessage());
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                System.out.println(e.getLocalizedMessage());
            }
            catch (Contact.TooMuchInfo e)
            {
                System.out.println("Too much Info in constructor Contact");
            }
            catch (Contact.NotEnoughInfo e)
            {
                System.out.println("Not enough Info in constructor Contact");
            }
            catch (NoSuchComparator e)
            {
                System.out.println("Number of comporator is out of range");
            }
            catch (Exception e)
            {
                System.out.println(e.getLocalizedMessage());
                System.out.println("Something went wrong");
            }
            finally
            {
                fileIn.close();
            }
        }
    }
