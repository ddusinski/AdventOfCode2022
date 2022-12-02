package com.dusinski.utils;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class utils {

    public static void readPuzzleInput(String inputUrl) throws IOException {

        URL url = new URL(inputUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        System.out.println(content);
    }

    public static List<Long> loadLongList(String resourceName) {
        List<String> lines = loadStringList(resourceName);
        List<Long> numbers = new ArrayList<>();
        lines.forEach(s -> numbers.add(Long.parseLong(s)));
        return numbers;
    }

    public static List<String> loadStringList(String resourceName) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream(resourceName);
        if (input != null) {
            try {
                List<String> lines = IOUtils.readLines(input, "UTF-8");
                return lines;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new LinkedList<>();
    }

    public static String loadStringLine(String resourceName) {
        return loadLine(resourceName);
    }

    private static String loadLine(String resourceName) {
        String result;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream(resourceName);
        if (input != null) {
            try {
                String string = IOUtils.toString(input, StandardCharsets.UTF_8);

                return string;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static List<Integer> loadDelimitedStringToList(String resourceName) {
        String string = loadLine(resourceName);
        String[] delimitedStringArray = string.split(",");
        List<String> strings = Arrays.asList(delimitedStringArray);
        List<Integer> numbers = new ArrayList<>();
        strings.forEach(s -> {
            numbers.add(Integer.parseInt(s));
        });

        return numbers;
    }

    public void test(){
        
    }
}
