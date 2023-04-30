package ua.edu.cbs.lms.hometask_adv_4.task3;

import java.time.Duration;
import java.time.LocalDateTime;

public class TimeElapsed {
    public static String timeElapsed(LocalDateTime fromTime, LocalDateTime toTime){
        Duration duration = Duration.between(fromTime, toTime);
        long years = duration.toDays() / 365;
        long months = (duration.toDays() % 365) / 30;
        long days = duration.toDays() % 30;
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;
        return "Вам виповнилося " + years + " років, " + months + " місяців, " + days + " днів, "
                + hours + " годин, " + minutes + " хвилин та " + seconds + " секунд";

    }
}
