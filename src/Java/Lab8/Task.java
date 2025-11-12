package Java.Lab8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {

    public static void textCheck(String text) {

        System.out.println("\nИсходный текст: " + text);

        if (!text.trim().endsWith(".")) {
            System.out.println("Предложение должно заканчиваться точкой");
            return;
        }

        Pattern pattern = Pattern.compile("[A-Za-zА-Яа-яЁё]{2,10}");
        Matcher matcher = pattern.matcher(text);

        int counter = 0;
        String lastWord = null;

        while (matcher.find()) {
            String word = matcher.group();
            counter++;
            lastWord = word;
        }

        System.out.println("\nВсего слов: " + counter);

        if (counter < 2 || counter > 30) {
            System.out.println("Ошибка: слов должно быть от 2 до 30");
            return;
        }

        System.out.println("Последнее слово это: " + lastWord);

        matcher.reset();
        int transformedCounter = 0;

        while (matcher.find()) {
            String word = matcher.group();
            if (!word.equals(lastWord)) {
                String transformedWord = transformWord(word);
                transformedCounter++;
                System.out.printf(" %2d. %s%n", transformedCounter, transformedWord);
            }
        }
    }

    private static String transformWord(String word) {
        if (word.length() < 2) {
            return word;
        }
        return word.substring(1) + word.charAt(0);
    }

    public static String replaceKth(String word, int k, char replacement) {
        if (k > word.length() || k < 1) {
            return word;
        }
        char[] chars = word.toCharArray();
        chars[k - 1] = replacement;
        return new String(chars);
    }

    public static void replacmentKth(String text, int k, char replacement) {
    //appendReplacemnt
        Pattern pattern = Pattern.compile("([A-Za-zА-Яа-яЁё]+)|([^A-Za-zА-Яа-яЁё]+)");
        Matcher matcher = pattern.matcher(text);

        StringBuilder resultText = new StringBuilder();
        int changedCount = 0;

        System.out.println("\nРезультат замены " + k + "-й буквы в словах:");

        while (matcher.find()) {
            String word = matcher.group(1);
            if (word != null) {
                String modifiedWord = replaceKth(word, k, replacement);
                if (!word.equals(modifiedWord)) {
                    changedCount++;
                }
                matcher.appendReplacement(resultText, Matcher.quoteReplacement(modifiedWord));
            } else {
                matcher.appendReplacement(resultText, Matcher.quoteReplacement(matcher.group()));
            }
        }

        matcher.appendTail(resultText);

        System.out.println("\nИзмененный текст: " + resultText);
        System.out.println("Слов с заменой: " + changedCount);
    }

    public static void main(String[] args) {
        String text = """
                Life-strategy struggle, fight strength courage
                wisdom freedom victory honor glory power 
                spirit destiny.. journey challenge... success achievement 
                progress.. innovation technology science discovery research 
                development solution strategy.""";

        String text2 = """
                Life-здаров struggle, fight strength courage привет привет
                wisdom как victory удача glory power 
                spirit destiny.. journey challenge... success achievement 
                progress.. innovation как science discovery research 
                development solution strategy.""";

        textCheck(text);
        replacmentKth(text2, 4, '$');
    }
}
