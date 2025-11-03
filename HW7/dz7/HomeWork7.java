package org.example.dz7;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class HomeWork7 {

    private static final Gson gson = new Gson();


    public static String randomDate(String jsonInput) {
        JsonObject obj = gson.fromJson(jsonInput, JsonObject.class);
        LocalDate start = LocalDate.parse(obj.get("startDate").getAsString());
        LocalDate end = LocalDate.parse(obj.get("endDate").getAsString());

        long daysBetween = end.toEpochDay() - start.toEpochDay();
        long randomOffset = new Random().nextLong(daysBetween + 1);
        LocalDate randomDate = start.plusDays(randomOffset);

        JsonObject result = new JsonObject();
        result.addProperty("randomDate", randomDate.toString());
        return gson.toJson(result);
    }


    public static String sortNumbers(String jsonInput, boolean isAsc) {
        JsonObject obj = gson.fromJson(jsonInput, JsonObject.class);
        var arr = obj.getAsJsonArray("numbers");

        List<Integer> numbers = new ArrayList<>();
        arr.forEach(e -> numbers.add(e.getAsInt()));

        numbers.sort(isAsc ? Comparator.naturalOrder() : Comparator.reverseOrder());

        JsonObject result = new JsonObject();
        result.add("sortedNumbers", gson.toJsonTree(numbers));
        return gson.toJson(result);
    }


    public static String charFrequency(String jsonInput) {
        JsonObject obj = gson.fromJson(jsonInput, JsonObject.class);
        String text = obj.get("text").getAsString().replaceAll(" ", "");

        Map<Character, Long> freq = text.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        List<Map.Entry<Character, Long>> sorted = freq.entrySet().stream()
                .sorted(Map.Entry.<Character, Long>comparingByValue().reversed())
                .toList();

        JsonObject result = new JsonObject();
        sorted.forEach(e -> result.addProperty(e.getKey().toString(), e.getValue()));
        return gson.toJson(result);
    }


    public static String sum(String jsonInput) {
        JsonObject obj = gson.fromJson(jsonInput, JsonObject.class);
        var arr = obj.getAsJsonArray("numbers");

        int total = 0;
        for (var el : arr) {
            total += el.getAsInt();
        }

        JsonObject result = new JsonObject();
        result.addProperty("sum", total);
        return gson.toJson(result);
    }


    public static String sumIf(String jsonInput) {
        JsonObject obj = gson.fromJson(jsonInput, JsonObject.class);
        var nums = obj.getAsJsonArray("numbers");
        var conds = obj.getAsJsonArray("conditions");

        int total = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (conds.get(i).getAsBoolean()) {
                total += nums.get(i).getAsInt();
            }
        }

        JsonObject result = new JsonObject();
        result.addProperty("sum", total);
        return gson.toJson(result);
    }


    public static void main(String[] args) {

        String json1 = "{\"startDate\":\"2024-01-01\",\"endDate\":\"2024-12-31\"}";
        System.out.println(randomDate(json1));


        String json2 = "{\"numbers\":[5,1,9,2]}";
        System.out.println(sortNumbers(json2, true));


        String json3 = "{\"text\":\"hello world\"}";
        System.out.println(charFrequency(json3));


        String json4 = "{\"numbers\":[1,2,3,4]}";
        System.out.println(sum(json4));


        String json5 = "{\"numbers\":[10,20,30],\"conditions\":[true,false,true]}";
        System.out.println(sumIf(json5));
    }
}