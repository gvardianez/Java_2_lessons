package lesson_3;

import java.util.ArrayList;
import java.util.TreeMap;

public class PhoneBookMap<K extends String> extends TreeMap<K, ArrayList<Integer>> {

    public void add(K name, ArrayList<Integer> phoneNumbers) {
    this.put(name, phoneNumbers);
    }

}

