public class PigLatinConverter {

    private String[] vowels = {"a", "e", "i", "o", "u"};
    private int count = 0;


    public String convert(String sentence) {
        String[] words = sentence.split(" ");

        for (String word : words) {
            sentence = sentence.replace(word, convertWord(word));
        }

        return sentence;
    }

    private String convertWord(String word) {
        for (String vowel : vowels) {
            if (word.toLowerCase().startsWith(vowel) && count == 0) {
                resetCount();
                return word + "yay";
            } else if (word.toLowerCase().startsWith(vowel)) {
                resetCount();
                return word + "ay";
            } else if (count == word.length()) {
                resetCount();
                return word + "ay";
            }
        }

        count += 1;
        return convert(word.substring(1) + word.charAt(0));
    }

    private void resetCount() {
        count = 0;
    }
}
