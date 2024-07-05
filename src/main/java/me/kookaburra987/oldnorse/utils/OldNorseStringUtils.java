package me.kookaburra987.oldnorse.utils;

import static me.kookaburra987.oldnorse.utils.Assert.*;
import static org.apache.commons.lang3.StringUtils.substring;

public final class OldNorseStringUtils {

    public static final String ON_CONSONANTS = "bdðfghjklmnprstvxzþ";

    private OldNorseStringUtils() {
    }

    /**
     * Method to get the first character of a given String back
     * as a String. Null is returned if the string was null.
     * Empty string will be returned if the given string was empty.
     * @return the string for which you want to retrieve the first character
     */
    public static String firstCharStr(String s){
        return substring(s, 0,1);
    }


    /**
     * Method to replace the char at given index if it is not followed by double consonant (tt, nn, ...).
     * @param subject the string in which the character is present
     * @param indexOfChar index of the character that might need to be replaced
     * @param replacement the new character that might replace the old one
     * @return the modified string
     */
    public static String replaceCharIfNotFollowedByDoubleConsonant(String subject, int indexOfChar, char replacement){
        notNull(subject, "subject is null");
        isFalse(indexOfChar < 0, "index should be 0 or positive");
        isFalse(subject.length() <= indexOfChar, "string has no character at provided index (i)");

        if (!isFollowedByDoubleConsonant(subject, indexOfChar)){
            char[] chars = subject.toCharArray();
            chars[indexOfChar] = replacement;
            return new String(chars);
        }

        return subject;
    }

    /**
     * Method that returns if a character at index i of a String is followed by a double consonant (dd, tt, nn, ...).
     * Example: Is for the word "mikill" the character at index 3 followed by double consonant?
     * @param s a String
     * @param i index of the character
     * @return true if character at index is followed by double consonant
     */
    public static boolean isFollowedByDoubleConsonant(String s, int i) {
        notNull(s, "string is null");
        isFalse(i < 0, "index should be 0 or positive");
        isFalse(s.length() <= i, "string has no character at provided index (i)");

        int endIndexOfDoubleConsonant = i + 2;
        if (s.length() <= endIndexOfDoubleConsonant){
            return false;
        }
        String nextTwoChars = substring(s, i + 1, endIndexOfDoubleConsonant + 1);
        return allSameConsonant(nextTwoChars);
    }

    /**
     * Returns if a string contains only consonants.
     * @param s a string
     * @return true if the string has only consonants
     */
    public static boolean allSameConsonant(String s) {
        notEmpty(s, "string is null");

        char theChar = s.charAt(0);
        if (!isOldNorseConsonant(theChar)){
            return false;
        }
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar != theChar){
                return false;
            }
        }
        return true;
    }

    /**
     * Method to check if a given char is an old norse consonant.
     * @param c char to check
     * @return true if old norse contains the given character as a consonant (Example: it will return false for 'w',
     * because that does not exist in old norse)
     */
    public static boolean isOldNorseConsonant(char c){
        return ON_CONSONANTS.indexOf(c) >= 0;
    }

    public static char lastCharOf(String s) {
        Assert.notEmpty(s, "string is empty");

        return s.charAt(s.length() - 1);
    }
}
