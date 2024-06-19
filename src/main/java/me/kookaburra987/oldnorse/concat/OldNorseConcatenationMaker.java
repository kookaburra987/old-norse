package me.kookaburra987.oldnorse.concat;

import me.kookaburra987.oldnorse.word.Word;

/**
 * Interface for classes that concatenate two old norse words taking grammar into account.
 * Example 1: Ek vil (pronoun + verb)
 * Example 2: móti honum (preposition, pronoun)
 * F is the type of the first word
 * S is the type of the second word
 */
public interface OldNorseConcatenationMaker<F extends Word, S extends Word> {

    /**
     * Returns the concatenation of firstWord and secondWord taking
     * the grammar of old norse into account.
     * @param firstWord of type F
     * @param secondWord of type S
     * @return grammatical correct concatenation
     */
    String concat(F firstWord, S secondWord);
}
