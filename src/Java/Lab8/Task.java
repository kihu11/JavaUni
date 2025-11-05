package Java.Lab8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class Task {

    public static void textCheck(String text) {

        ArrayList<String> words = new ArrayList<>();
        int counter = 0;

        System.out.println("Исходный текст: " + text);

        if (!text.trim().endsWith(".")) {
            System.out.println("Предложение должно заканчиваться точкой");
            return;
        }


//
        Pattern pattern = Pattern.compile("\\b[a-zA-Z]{2,10}\\b");
        Matcher matcher = pattern.matcher(text);

        System.out.println("\nНайденные слова:");
        while (matcher.find()) {
            String word = matcher.group();
            words.add(word);
            counter++;
            System.out.printf("Слово %2d: '%s'%n", counter, word);
        }

        System.out.println("\nВсего слов: " + counter);

        if (counter < 2 || counter > 30) {
            System.out.println("Ошибка: слов должно быть от 2 до 30");
            return;
        }

        String lastWord = words.get(words.size() - 1);
        System.out.println("Последнее слово это: " + lastWord);

        ArrayList<String> transformedWords = new ArrayList<String>();
        int transformedCounter = 0;

        for (int i = 0; i < words.size() - 1; i++) {
            String word = words.get(i);

            if (!word.equals(lastWord)) {
                String transformedWord = transformWord(word);
                transformedWords.add(transformedWord);
                transformedCounter++;
            }
        }

        System.out.println("\nПреобразованные слова: ");
        for (int i = 0; i < transformedWords.size(); i++) {
            System.out.printf("%2d. %s%n", i + 1, transformedWords.get(i));
        }
        System.out.println("Преобразованных слов: " + transformedCounter);
    }

    private static String transformWord(String word) {

        if (word.length() < 2) {
            return word;
        }

        String first = word.substring(0, 1);
        String rest = word.substring(1);

        return rest + first;
    }

    public static String replaceKth(String word, int k, char replacement) {
        if (k > word.length() || k < 1) {
            return word;
        }

        int index = k - 1;
        char[] chars = word.toCharArray();
        chars[index] = replacement;

        return new String(chars);
    }

    public static void replacmentKth(String text, int k, char replacement) {
        StringBuilder resultText = new StringBuilder();

        Pattern pattern = Pattern.compile("([a-zA-Z]{2,10})|([^a-zA-Z]+)");
        Matcher matcher = pattern.matcher(text);

        int changedCount = 0;

        System.out.println("Процесс замены " + k + "-й буквы в словах:");
        while (matcher.find()) {
            String segment = matcher.group();

            if (segment.matches("[a-zA-Z]{2,10}")) {
                String modifiedWord = replaceKth(segment, k, replacement);

                if (!segment.equals(modifiedWord)) {
                    changedCount++;
                    System.out.printf("'%s' -> '%s' %n", segment, modifiedWord);
                }

                resultText.append(modifiedWord);
            } else {
                resultText.append(segment);
            }
        }

        System.out.println("Измененный текст: " + resultText);
        System.out.println("Слов с заменой: " + changedCount);
    }

    public static void main(String[] args) {
        String text = """
        Life-strategy struggle, fight strength courage 
        wisdom freedom victory honor glory power привет
        spirit destiny.. journey challenge... success achievement 
        progress.. innovation technology science discovery research 
        development solution strategy.""";
        //последнее слово strategy

        textCheck(text);
        replacmentKth(text, 3, '.');
    }
}