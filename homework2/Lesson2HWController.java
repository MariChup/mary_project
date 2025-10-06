package homework2;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@RestController
public class Lesson2HWController {

    @GetMapping("/current-datetime")
    public String currentTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = now.format(formatter);
        return "Текущее время: " + formattedTime;
    }


    @GetMapping("/current-season")
    public String currentSeason() {
        int monthValue = LocalDate.now().getMonthValue();
        return switch (monthValue) {
            case 12, 1, 2 -> "Зима";
            case 3, 4, 5 -> "Весна";
            case 6, 7, 8 -> "Лето";
            case 9, 10, 11 -> "Осень";
            default -> throw new IllegalStateException("Unexpected value: " + monthValue);
        };
    }


    @GetMapping("/future-date")
    public String futureDate() {
        LocalDate date = LocalDate.now();
        Random random = new Random();
        int number = random.nextInt(30) + 1;
        date = date.plusDays(number);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = date.format(formatter);

        return "Случайная дата в будущем: " + formattedDate;
    }
}

