package libs;

import persistence.ScenarioContext;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import static libs.DriverFactory._parseJSONData;

public class GenerateTestData {

    private ScenarioContext _persistentData;

    public GenerateTestData(ScenarioContext _persistentData){
        this._persistentData = _persistentData;
    }
/*
    public static void main(String[] args) {

        //String testCondition = "mandatory|sentence|1000";
        //String testCondition = "mandatory|time|hh:mm a";
        //String testCondition = "mandatory|date|dd/MM/yyyy";
        //String testCondition = "mandatory|list|A shop/business~An organisation~A home~A public place~On a journey~Place of worship~Educational Facility~Other";
        //String testCondition = "mandatory|toggle|Yes~No";
        //String testCondition = "mandatory|data|Computer (Laptop)";
        //String testCondition = "mandatory|currency|12";
        String testCondition = "mandatory|checkbox|Yes~No";

        //condition :: optional/Mandatory|valid|type|length
        *//* relevance ::
            optional
            mandatory
        *//*
        *//* type ::
            an  - alphanumeric
            n   - numbers
            ans - alphanumeric and spaces
            ahs - alphabet, hyphen and spaces
            any - any data
            ns  - numbers and space
            as  - alphabet and spaces
            sentence - a full blown sentence
            date - dd/mm/yyyy
            time - hh:mm a
        *//*
        *//*
        length:
          int - length of data
        *//*
        String testData;
        GenerateTestData gtd = new GenerateTestData();

        testData = gtd.generateValidData(testCondition);
        //testData = gtd.generateInvalidData(testCondition, 1); // 1 for data-type || 2 for length
        System.out.println("Actual Data Length: " + testData.length());
        System.out.println("Generated Data : " + testData);

    }*/


    public String generateValidData(String dataXpath) {
        System.out.println("Valid data generation => ");
        String testData = null;
        String testCondition = _parseJSONData.getDataValue(dataXpath);
        List<String> conditions = splitCondition(testCondition);
        if (conditions.get(0).equalsIgnoreCase("mandatory")) {
            System.out.println("Expected data length : " + conditions.get(2));
            testData = getTestData(conditions.get(1), conditions.get(2), "");
            _persistentData.setContext(dataXpath, testData);
        }
        return testData;
    }

    public String[] generateListData(String dataXpath) {
        System.out.println("Valid data generation => ");
        String[] testData = null;
        String testCondition = _parseJSONData.getDataValue(dataXpath);
        List<String> conditions = splitCondition(testCondition);
        if (conditions.get(0).equalsIgnoreCase("mandatory")) {
            System.out.println("Expected data length : " + conditions.get(2));
            testData = getListDataAsArray(conditions.get(2));
        }
        return testData;
    }

    public String generateInvalidData(String testCondition, int invalidType) {
        String testData = null;
        List<String> conditions = splitCondition(testCondition);
        if (conditions.get(0).equalsIgnoreCase("mandatory")) {
            if (invalidType == 1) {
                System.out.println("Data genergit staation with Invalid data type => ");
                System.out.println("Expected data length : " + conditions.get(2));
                testData = getTestData(conditions.get(1), conditions.get(2), "type");
            } else if (invalidType == 2) {
                System.out.println("Data generation with Invalid length => ");
                System.out.println("Expected data length : " + conditions.get(2));
                testData = getTestData(conditions.get(1), conditions.get(2), "length");
            }
        }
        return testData;
    }

    public List<String> splitCondition(String testCondition) {
        String[] splitStringArray = testCondition.split("\\|");
        List<String> conditions = new ArrayList<>();
        for (String condition : splitStringArray) {
            conditions.add(condition);
        }
        return conditions;
    }

    public String[] getListDataAsArray(String dataFormat){
        return dataFormat.split("~");
    }

    public String getTestData(String type, String condition, String invalidType) {
        String testData = null;
        int maxLength = 0;
        String dataFormat = null;
        if (!type.equalsIgnoreCase("data")) {
            try {
                maxLength = Integer.parseInt(condition);
            } catch (Exception e) {
                dataFormat = condition;
            }
        }

        switch (type) {
            case "an":
                System.out.println("Alphanumeric data ");
                testData = generateAlphaNumericString(maxLength, false);
                if (invalidType.equalsIgnoreCase("length")) {
                    testData = testData + generateAlphaNumericString(maxLength, true);
                } else if (invalidType.equalsIgnoreCase("type")) {
                    testData = makeDataInvalid(testData, "$");
                }
                break;
            case "n":
                System.out.println("Numeric Data ");
                testData = generateNumericData(maxLength, false);
                if (invalidType.equalsIgnoreCase("length")) {
                    testData = testData + generateNumericData(maxLength, true);
                } else if (invalidType.equalsIgnoreCase("type")) {
                    testData = makeDataInvalid(testData, "a");
                }
                break;
            case "ans":
                System.out.println("Alphanumeric data with spaces ");
                testData = generateAlphaNumericWithSpacesString(maxLength, false);
                if (invalidType.equalsIgnoreCase("length")) {
                    testData = testData + generateAlphaNumericWithSpacesString(maxLength, true);
                } else if (invalidType.equalsIgnoreCase("type")) {
                    testData = makeDataInvalid(testData, "$");
                }
                break;
            case "ahs":
                System.out.println("Alphabet with hyphen and spaces ");
                testData = generateAlphabetWithSpacesAndHyphenString(maxLength, false);
                if (invalidType.equalsIgnoreCase("length")) {
                    testData = testData + generateAlphabetWithSpacesAndHyphenString(maxLength, true);
                } else if (invalidType.equalsIgnoreCase("type")) {
                    testData = makeDataInvalid(testData, "1");
                }
                break;
            case "any":
                break;
            case "ns":
                System.out.println("Numeric data with spaces ");
                testData = generateNumbersAndSpaceData(maxLength, false);
                if (invalidType.equalsIgnoreCase("length")) {
                    testData = testData + generateNumbersAndSpaceData(maxLength, true);
                } else if (invalidType.equalsIgnoreCase("type")) {
                    testData = makeDataInvalid(testData, "a");
                }
                break;
            case "as":
                System.out.println("Alphabet data with spaces ");
                testData = generateAlphabetsAndSpaceData(maxLength, false);
                if (invalidType.equalsIgnoreCase("length")) {
                    testData = testData + generateNumbersAndSpaceData(maxLength, true);
                } else if (invalidType.equalsIgnoreCase("type")) {
                    testData = makeDataInvalid(testData, "1");
                }
                break;
            case "sentence":
                System.out.println("Sentence ");
                testData = generateSentence(maxLength, false);
                if (invalidType.equalsIgnoreCase("length")) {
                    testData = testData + generateSentence(maxLength, true);
                } else if (invalidType.equalsIgnoreCase("type")) {
                    testData = makeDataInvalid(testData, "@#");
                }
                break;
            case "date":
                String pattern = dataFormat;
                LocalDate localDateObject = LocalDate.now().minusDays(1);
                Date dateObject = Date.from(localDateObject.atStartOfDay(ZoneId.systemDefault()).toInstant());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                testData = simpleDateFormat.format(dateObject);
                break;
            case "time":
                Date date = new Date();
                DateFormat formatter = new SimpleDateFormat("h:mm a");
                testData = formatter.format(date);
                break;
            case "list":
                String[] listItems = dataFormat.split("~");
                int randomIndex = generateRandomLength(0, listItems.length);
                testData = listItems[randomIndex];
                break;
            case "toggle":
            case "checkbox":
                listItems = dataFormat.split("~");
                randomIndex = generateRandomLength(0, listItems.length);
                testData = listItems[randomIndex];
                break;
            case "data":
                testData = condition;
                break;
            case "currency":
                NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
                testData = format.format(Double.parseDouble(generateNumericData(maxLength, false)));
                break;
        }
        return testData.trim();
    }

    public String getAlphanumericString() {
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    }

    public String getNumericString() {
        return "0123456789";
    }

    public String getAlphabets() {
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    }

    public String[] getArticles() {
        String article[] = {"the ", "a ", "one ", "some ", "any "};
        return article;
    }

    public String[] getNoun() {
        String noun[] = {"mobile ", "house ", "car ", "bicycle ", "stranger "};
        return noun;
    }

    public String[] getVerb() {
        String verb[] = {"hurt ", "stolen ", "lost ", "theft "};
        return verb;
    }

    public String[] getProposition() {
        String preposition[] = {"away ", "towards ", "around ", "near "};
        return preposition;
    }

    public String getSpecialCharactersInSentence() {
        String specialCharactersSentence = ".!'?&()#$";
        return specialCharactersSentence;
    }

    public String generateAlphaNumericString(int length, boolean fixed) {
        int dataLength = length;
        if (!fixed) {
            dataLength = generateRandomLength(1, length);
        }
        StringBuilder data = new StringBuilder(dataLength);
        Random random = new Random();
        for (int i = 0; i < dataLength; i++) {
            data.append(getAlphanumericString().charAt(random.nextInt(getAlphanumericString().length())));
        }
        return data.toString();
    }

    public String generateNumericData(int length, boolean fixed) {
        int dataLength = length;
        if (!fixed) {
            dataLength = generateRandomLength(1, length);
        }
        StringBuilder data = new StringBuilder(dataLength);
        Random random = new Random();
        for (int i = 0; i < dataLength; i++) {
            data.append(getNumericString().charAt(random.nextInt(getNumericString().length())));
        }
        return data.toString();
    }

    public String generateAlphaNumericWithSpacesString(int length, boolean fixed) {
        int dataLength = length;
        if (!fixed) {
            dataLength = generateRandomLength(1, length);
        }
        Random random = new Random();
        StringBuilder data = new StringBuilder(dataLength);
        int dataIndexForSpace = generateRandomLength(1, dataLength);
        for (int i = 0; i < dataLength; i++) {
            if (i == dataIndexForSpace) {
                data.append(" ");
            } else {
                data.append(getAlphanumericString().charAt(random.nextInt(getAlphanumericString().length())));
            }
        }
        return data.toString();
    }

    public String generateAlphabetWithSpacesAndHyphenString(int length, boolean fixed) {
        int dataLength = length;
        if (!fixed) {
            dataLength = generateRandomLength(1, length);
        }
        Random random = new Random();
        StringBuilder data = new StringBuilder(dataLength);
        int dataIndexForSpace = generateRandomLength(1, dataLength);
        int dataIndexForHyphen = generateRandomLength(1, dataLength);

        for (int i = 0; i < dataLength; i++) {
            if (i == dataIndexForSpace) {
                data.append(" ");
            } else if (i == dataIndexForHyphen) {
                data.append("-");
            } else {
                data.append(getAlphabets().charAt(random.nextInt(getAlphabets().length())));
            }
        }
        return data.toString();
    }

    public String generateNumbersAndSpaceData(int length, boolean fixed) {
        int dataLength = length;
        if (!fixed) {
            dataLength = generateRandomLength(1, length);
        }
        Random random = new Random();
        StringBuilder data = new StringBuilder(dataLength);
        int dataIndexForSpace = generateRandomLength(1, dataLength);
        for (int i = 0; i < dataLength; i++) {
            if (i == dataIndexForSpace) {
                data.append(" ");
            } else {
                data.append(getNumericString().charAt(random.nextInt(getNumericString().length())));
            }
        }
        return data.toString();
    }

    public String generateAlphabetsAndSpaceData(int length, boolean fixed) {
        int dataLength = length;
        if (!fixed) {
            dataLength = generateRandomLength(1, length);
        }
        Random random = new Random();
        StringBuilder data = new StringBuilder(dataLength);
        int dataIndexForSpace = generateRandomLength(1, dataLength);
        for (int i = 0; i < dataLength; i++) {
            if (i == dataIndexForSpace) {
                data.append(" ");
            } else {
                data.append(getAlphabets().charAt(random.nextInt(getAlphabets().length())));
            }
        }
        return data.toString();
    }

    public String generateSentence(int length, boolean fixed) {
        boolean exitLoop = false;
        StringBuilder sentence = null;
        while (!exitLoop) {
            int randomNumber = generateRandomLength(1, 3);
            String specialCharacters;
            if (randomNumber == 1) {
                specialCharacters = String.valueOf(getSpecialCharactersInSentence().charAt(generateRandomLength(1, getSpecialCharactersInSentence().length())));
            } else {
                specialCharacters = ".";
            }
            try {
                sentence = sentence.append(buildSentence().append(specialCharacters));
            } catch (Exception e) {
                sentence = buildSentence().append(specialCharacters);
            }

            if (sentence.length() >= length) {
                exitLoop = true;
            } else {
                sentence = sentence.append(buildSentence().append(specialCharacters));
            }
        }
        sentence.setCharAt(0, Character.toUpperCase(sentence.charAt(0)));
        String sentenceData;
        if (!fixed) {
            sentenceData = sentence.toString().substring(0, Math.min(sentence.length(), generateRandomLength(1, length)));
        } else {
            sentenceData = sentence.toString().substring(0, Math.min(sentence.length(), length));
        }
        return sentenceData;
    }

    public StringBuilder buildSentence() {
        int article1 = generateRandomLength(1, getArticles().length);
        int noun1 = generateRandomLength(1, getNoun().length);
        int verb1 = generateRandomLength(1, getVerb().length);
        int preposition1 = generateRandomLength(1, getProposition().length);
        int article2 = generateRandomLength(1, getArticles().length);
        int noun2 = generateRandomLength(1, getNoun().length);
        StringBuilder buffer = new StringBuilder();
        buffer.append(getArticles()[article1]).append(getNoun()[noun1]).append
                (getVerb()[verb1]).append(getProposition()[preposition1]).append
                (getArticles()[article2]).append(getNoun()[noun2].trim());
        return buffer;
    }


//    public int generateRandomLength(int maxLength) {
//        int minLength = 0;
//        if (maxLength > 1) {
//            minLength = 1;
//        }
//        Random random = new Random();
//        return random.nextInt(maxLength - minLength) + minLength;
//    }

    public int generateRandomLength(int minLength, int maxLength) {
        Random random = new Random();
        try{
            return random.nextInt(maxLength - minLength) + minLength;
        }catch (Exception e){
            return 1;
        }
    }

    public String makeDataInvalid(String testData, String invalidCharacter) {
        return testData + invalidCharacter;
    }


}
