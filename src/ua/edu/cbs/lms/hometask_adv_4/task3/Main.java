package ua.edu.cbs.lms.hometask_adv_4.task3;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        LocalDateTime birthday = LocalDateTime.of(1982,8,17,0,0,0);

        System.out.println(TimeElapsed.timeElapsed(birthday, LocalDateTime.now()));
    }
}
