package courseJavaCore.lesson15.hw1;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        User user1 = new User(100121, "Ann23", "qwe12");
        User user2 = new User(100121, "Ann3", "qwe13");
        User user3 = new User(100411, "Ann4", "qwe14");
        User user4 = new User(100151, "Ann5", "qwe15");
        User user5 = new User(100611, "Ann6", "qwe16");
        User user6 = new User(100171, "Ann7", "qwe17");
        User user7 = new User(100181, "Ann8", "qwe18");
        User user8 = new User(100191, "Ann9", "qwe19");
        User user9 = new User(100010, "Ann101", "qwe20");
        User user90 = new User(100010, "Ann1011", "qwe20");


        UserRepository userRepository = new UserRepository();
        userRepository.save(new User(100010, "Ann10", "qwe20"));
        userRepository.save(new User(1000101, "Ann1011", "qwe20"));
        System.out.println("+++++++++++++++++++");
        System.out.println(Arrays.toString(userRepository.getUsers()));

        System.out.println(userRepository.update(user9));
        System.out.println("+++++++++++++++++++");
        System.out.println(Arrays.toString(userRepository.getUsers()));

        userRepository.delete(1000101);
        System.out.println("+++++++++++++++++++");
        System.out.println(Arrays.toString(userRepository.getUsers()));


    }
}
