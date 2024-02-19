package seminars.five.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomNumberModule {
    public List<Integer> generateList(int size) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt());
        }
        return list;
    }
}
