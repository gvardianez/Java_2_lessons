package lesson_3;

import java.util.*;

public class WordsAndPhoneBook {

    public static void main(String[] args) {
        List<String> listWords = new ArrayList<>();
        listWords.add("Cat");
        listWords.add("Dog");
        listWords.add("Cat");
        listWords.add("Wolf");
        listWords.add("Cat");
        listWords.add("Lion");
        listWords.add("Hippo");
        listWords.add("Wolf");
        listWords.add("Wolf");
        listWords.add("Lion");
        System.out.println(WordsAndPhoneBook.uniqueWords(listWords));
        System.out.println(WordsAndPhoneBook.valueUniqueWords(listWords));

        PhoneBook<String, Integer> phoneBook = new PhoneBook<>();
        phoneBook.add("Petr", 55574);
        phoneBook.add("Vasya", 15455);
        phoneBook.add("Masha", 41245);
        phoneBook.add("Petr", 12385);
        phoneBook.add("Masha", 12545);
        System.out.println("Phones Petr " + phoneBook.get("Petr"));
        System.out.println("Phones Vasya " + phoneBook.get("Vasya"));
        System.out.println("Phones Masha " + phoneBook.get("Masha"));

        PhoneBookMap<String> phoneBookMap = new PhoneBookMap<>();
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(955444);
        numbers.add(415246);
        numbers.add(884532);
        phoneBookMap.add("Pupkin", numbers);
        ArrayList<Integer> numbers1 = new ArrayList<>();
        numbers1.add(24544);
        numbers1.add(55441);
        numbers1.add(88247);
        phoneBookMap.add("Dudkin", numbers1);
        System.out.println(phoneBookMap);
        System.out.println("Phones Dudkin " + phoneBookMap.get("Dudkin"));
    }

    public static Set<String> uniqueWords(List<String> list) {
        return new TreeSet<>(list);
    }

    public static Map<String, Integer> valueUniqueWords(List<String> list) { //Показалось, что так неплохо сделать Map,
        Map<String, Integer> wordsAndValue = new TreeMap<>();                //с уникальными словами как ключи, и значениями как их количество
        Set<String> words = uniqueWords(list);
        int value = 0;
        for (String uniqueWord : words) {
            for (String word : list) {
                if (uniqueWord.equals(word)) {
                    value++;
                }
            }
            wordsAndValue.put(uniqueWord, value);
            value = 0;
        }
        return wordsAndValue;
    }

}

//Консоль
//        [Cat, Dog, Hippo, Lion, Wolf]
//        {Cat=3, Dog=1, Hippo=1, Lion=2, Wolf=3}
//        Phones Petr [55574, 12385]
//        Phones Vasya [15455]
//        Phones Masha [41245, 12545]
//        {Dudkin=[24544, 55441, 88247], Pupkin=[955444, 415246, 884532]}
//        Phones Dudkin [24544, 55441, 88247]
