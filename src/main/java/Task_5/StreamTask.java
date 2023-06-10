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

        List<User> sortedList = userList.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedList);

        List<User> reverseSortedList = userList.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(reverseSortedList);

        List<User> idSortedList = userList.stream()
                .sorted(Comparator.comparing(User::getId))
                .collect(Collectors.toList());
        System.out.println(idSortedList);

        System.out.println("Filter:");
        List<User> filteredList = userList.stream()
                .filter(u -> u.getId() > 4)
                .collect(Collectors.toList());
        System.out.println(filteredList);

        System.out.println("Name List:");
        List<String> nameList = userList.stream()
                .map(User::getName)
                .collect(Collectors.toList());
        System.out.println(nameList);
    }

    private static List<User> generateUserList(int n) {
        Random random = new Random();
        List<User> userList = new ArrayList<>();
        IntStream.range(0, n).forEach(i -> {
            User user = new User();
            user.setName("userName" + UUID.randomUUID().toString().substring(0, 5));
            user.setId(random.nextInt(100));
            userList.add(user);
        });
        return userList;
    }
}
