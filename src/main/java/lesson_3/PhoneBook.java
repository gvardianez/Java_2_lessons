package lesson_3;

import java.util.*;

public class PhoneBook<K extends String,V extends Integer>  {

    private final List<K> names = new ArrayList<>();
    private final List<V> phoneNumber = new ArrayList<>();

    public void add(K name, V number) {
        names.add(name);
        phoneNumber.add(number);
    }

    public List<V> get(K name) {
        List<V> phones = new ArrayList<>();
        int count = 0;
        if (!names.contains(name)){
            return phones;
        }
        for (K stringName :names) {
            if (stringName.equals(name)){
                phones.add(phoneNumber.get(count));
            }
            count++;
        }
       return phones;
    }

    @Override
    public String toString() {
        return "PhoneBook {" +
                " names = " + names +
                ", phoneNumber = " + phoneNumber +
                '}';
    }

}





