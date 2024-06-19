package me.kookaburra987.oldnorse.word.parse;

import me.kookaburra987.oldnorse.word.Word;

import java.util.List;

/**
 * Interface for classes responsible for reading a String
 * and converting it into a Word of subtype T.
 */
public interface WordParser<T extends Word> {
    /**
     * Parses a list of lines to a list of words of type T.
     * @param lines lines to parse
     * @return the list of words
     * @throws IllegalArgumentException when parsing fails (example: lines not in correct format)
     */
    List<T> parse(String[] lines);

    /**
     * Parses a line to a word of type T.
     * @param line to parse
     * @return the word
     * @throws IllegalArgumentException when parsing fails (example: lines not in correct format)
     */
    T parse(String line);
}
