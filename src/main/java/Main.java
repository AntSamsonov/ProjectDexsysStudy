import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    private static List<Integer> getRandomList(){
        List<Integer> list = new ArrayList<>();
        int size = new Random().nextInt(15);
        for (int i = 0; i < size; i++) {
            list.add(new Random().nextInt(10));
        }
        return list;

       // return Stream.generate(() -> new Random().nextInt(10))
       //         .limit(new Random().nextInt(15))
       //         .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> randomList = getRandomList();
        System.out.println(randomList);

        randomList.sort(Integer::compareTo);

        System.out.println(randomList);

        //оставить все числа больше 2
        //вычесть из каждого 2
        //удалить дубликаты

        List<Integer> newList = new ArrayList<>();
        for (Integer i : randomList) {
            if (i > 3 && !newList.contains(i - 2)) {
                newList.add(i - 2);
            }
        }

        List<Integer> newList2 = randomList
                .stream()
                .filter(value -> value > 3)
                .map(value -> value - 2)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(newList);
        System.out.println(newList2);


    }
}
