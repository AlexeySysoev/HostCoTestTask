package utils;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Random;

public class PrepareTestData {
    private HashMap<String, String> testIndicatorsData = new HashMap<>();
    private final String KIRILLIC_ALPHABET = "цукенгшщзхъфывапролджэячсмитьбю";

    public HashMap<String, String> getIndicatorsTestData() {
        testIndicatorsData.put("temperature", getIntValueFromRange(340, 420));       //340-420
        testIndicatorsData.put("weight", getIntValueFromRange(3, 120));              //3-120
        testIndicatorsData.put("pressure1", getIntValueFromRange(100, 140));         //100-140
        testIndicatorsData.put("pressure2", getIntValueFromRange(60, 80));           //60-80
        testIndicatorsData.put("sugar", getIntValueFromRange(230, 240));             //230-240
        testIndicatorsData.put("pulse", getIntValueFromRange(70, 120));              //70-120
        testIndicatorsData.put("alcohol", getIntValueFromRange(3, 5));               //3-5
        testIndicatorsData.put("ambivalent", getIntValueFromRange(50, 60));          //50-60
        testIndicatorsData.put("mood", getRandomWord(10, KIRILLIC_ALPHABET));                //any text
        testIndicatorsData.put("generalHealthLevel", getRandomWord(12, KIRILLIC_ALPHABET)); //any text
        testIndicatorsData.put("skinCondition", getRandomWord(14, KIRILLIC_ALPHABET));     //any text
        return testIndicatorsData;
        //RandomStringUtils.randomAlphabetic(12).toLowerCase()
    }

    public String getIntValueFromRange(int startNumber, int endNumber) {
        Random random = new Random();
        Integer value = random.nextInt(endNumber - startNumber) + startNumber;
        return value.toString();
    }

    public static String getRandomWord(int length, String alphabet) {
        SecureRandom RND = new SecureRandom();
        StringBuilder sb = new StringBuilder(Math.max(length, 16));
        for (int i = 0; i < length; i++) {
            int len = alphabet.length();
            int random = RND.nextInt(len);
            char c = alphabet.charAt(random);
            sb.append(c);
        }
        return sb.toString();
    }
}
