package lesson15;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {


        UserRepository userRepository = new UserRepository();
        System.out.println(userRepository.save(new User(100010, "Ann10", "qwe20")));
        System.out.println("+++++++++++++++++++");
        System.out.println(Arrays.toString(userRepository.getUsers()));


    }
}
