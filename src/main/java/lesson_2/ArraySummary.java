package lesson_2;

public class ArraySummary {

    public static void main(String[] args) {
        String[][] array = {
                {"5", "67", "5", "53"},
                {"2", "57", "24", "-20"},
                {"1", "0", "34", "17"},
                {"78","5","25","-100"}
        };

        try {
            System.out.println("Сумма элементов массива " + ArraySummary.sumArray(array));
        } catch (MyArraySizeException | MyArrayDataException exception){
            exception.printStackTrace();
        }

//        array = new String[][]{
//                {"5", "67", "5", "53"},
//                {"2", "57", "24", "-20"},
//                {"1", "0", "34", "17"},
//                {"78", "fdfdf", "25", "-100"}
//        };
//
//        try {
//            System.out.println("Сумма элементов массива " + ArraySummary.sumArray(array));
//        } catch (MyArraySizeException exception){
//            exception.printStackTrace();
//        }

        array = new String[][]{
                {"5", "67", "5", "53"},
                {"2", "57", "24", "-20"},
                {"1", "0", "34", "17"},
                {"78", "52"}
        };

        try {
            System.out.println("Сумма элементов массива " + ArraySummary.sumArray(array));
        } catch (MyArraySizeException exception){
            System.out.println("Ошибка!");
            exception.printStackTrace();
        }
    }

    public static int sumArray(String[][] array) throws MyArraySizeException{
        int sum = 0;
        if (array.length!=4){
            throw new MyArraySizeException("Передан строковый массив неверного размера");
        }
        for (String[] strings : array) {
            if (strings.length != 4) {
                throw new MyArraySizeException("Передан строковый массив неверного размера");
            }
        }
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array.length; x++) {
                try {
                   sum += Integer.parseInt(array[y][x]);
                } catch (NumberFormatException e){
                    System.out.printf("В элементе массива [%d] [%d], строка не представляющая число \n",y,x);
                    throw new MyArrayDataException("Неверный тип данных");
                }
            }
        }
        return sum;
    }

    //Консоль
//    Сумма элементов массива 253
//    В элементе массива [3] [1], строка не представляющая число
//    Exception in thread "main" lesson_2.MyArrayDataException: Неверный тип данных
//    at lesson_2.ArraySummary.sumArray(ArraySummary.java:64)
//    at lesson_2.ArraySummary.main(ArraySummary.java:27)
//    Ошибка!
//    lesson_2.MyArraySizeException: Передан строковый массив неверного размера
//    at lesson_2.ArraySummary.sumArray(ArraySummary.java:54)
//    at lesson_2.ArraySummary.main(ArraySummary.java:40)


}
