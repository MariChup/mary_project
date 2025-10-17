package com.example.homework4;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestParam;

import java.time.DayOfWeek;
import java.util.Arrays;

@RestController
public class Lesson4HWController {


    @GetMapping("/day-of-week")
    public String calculateDayofWeek(@RequestParam String date) {
        LocalDate localDate = LocalDate.parse(date);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();

        return switch (dayOfWeek) {
            case MONDAY -> "Понедельник";
            case TUESDAY -> "Вторник";
            case WEDNESDAY -> "Среда";
            case THURSDAY -> "Четверг";
            case FRIDAY -> "Пятница";
            case SATURDAY -> "Суббота";
            case SUNDAY -> "Воскресенье";
        };
    }


    @GetMapping("/generate-password")
    public String generatePassword(@RequestParam int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!&@#%$*^";
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(chars.length());
            char s = chars.charAt(randomIndex);
            password.append(s);
        }

        return "Случайный пароль: " + password;
    }


    @GetMapping("/factorial")
    public String calculateFactorial(@RequestParam int number) {
        int result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return "Факториал числа " + number + ": " + result;
    }


    @GetMapping("/power")
    public String calculatePower(@RequestParam int number, @RequestParam int power) {
        double resultDouble = Math.pow(number, power);
        long result = (long) resultDouble;
        return number + " в степени " + power + ": " + result;
    }


    @GetMapping("/random-date")
    public String getDateBetween(@RequestParam String startDate, @RequestParam String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);

        long startEpochDay = start.toEpochDay();
        long endEpochDay = end.toEpochDay();

        long daysBetween = endEpochDay - startEpochDay + 1;

        Random random = new Random();
        long randomDay = startEpochDay + random.nextLong(daysBetween);

        LocalDate randomDate = LocalDate.ofEpochDay(randomDay);

        return "Случайная дата: " + randomDate;
    }


    @GetMapping("/sort-array")
    public String getSortedArray(@RequestParam int[] numbers, @RequestParam boolean isAsc) {
        int[] sortedArray = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sortedArray);

        if (!isAsc) {
            for (int i = 0; i < sortedArray.length / 2; i++) {
                int temp = sortedArray[i];
                sortedArray[i] = sortedArray[sortedArray.length - 1 - i];
                sortedArray[sortedArray.length - 1 - i] = temp;
            }
        }

        return "Отсортированный массив: " + Arrays.toString(sortedArray);
    }


    @GetMapping("/substring")
    public String getSubstring(@RequestParam String str, @RequestParam int position, @RequestParam boolean isFirst) {
        String substring;

        if (isFirst) {
            substring = str.substring(0, position);
        } else {
            substring = str.substring(position);
        }

        return "Часть строки: " + substring;
    }
}
