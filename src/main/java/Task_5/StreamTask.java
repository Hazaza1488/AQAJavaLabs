package Task_5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTask {
    public static void main(String[] args) {
        List<User> userList = generateUserList(10);
        System.out.println(userList);

        System.out.println(userList.stream().sorted().collect(Collectors.toList()));
        System.out.println(userList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        System.out.println(userList.stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList()));

        System.out.println("filter");
        System.out.println(userList.stream().filter(u -> u.getId() > 4).collect(Collectors.toList()));

        System.out.println("stringList");
        System.out.println(userList.stream().map(User::getName).collect(Collectors.toList()));
    }

    private static List<User> generateUserList(int n) {
        Random random = new Random();
        List<User> userList = new ArrayList<>();
        IntStream.range(1, n).forEach(i -> {
            User user = new User();
            user.setName("userName" + UUID.randomUUID().toString().substring(0, 5));
            user.setId(random.nextInt(100));
            userList.add(user);
        });
        return userList;
    }
}
