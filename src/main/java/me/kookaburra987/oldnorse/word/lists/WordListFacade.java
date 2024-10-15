package me.kookaburra987.oldnorse.word.lists;

import me.kookaburra987.oldnorse.word.Preposition;
import me.kookaburra987.oldnorse.word.noun.Noun;

import java.util.List;

/**
 * Interface for classes that provide lists of old norse words.
 */
public interface WordListFacade {
    /**
     * To retrieve a list of prepositions.
     * @return list of prepositions
     */
    List<Preposition> prepositionList();

    /**
     * To retrieve a list of nouns
     * @return list of nouns
     */
    List<Noun> nounList();
}
