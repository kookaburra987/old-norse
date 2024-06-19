package me.kookaburra987.oldnorse.word.lists;

import me.kookaburra987.oldnorse.Case;
import me.kookaburra987.oldnorse.word.Preposition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static me.kookaburra987.oldnorse.Case.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DefaultWordListFacadePrepositionListTest {

    private DefaultWordListFacade facade;

    @BeforeEach
    void setup(){
        facade = new DefaultWordListFacade();
    }

    @Test
    void returnsPrepositionList(){
        List<Preposition> prepositions = facade.prepositionList();

        assertEquals(14, prepositions.size());
        assertTrue(isPresent("gegnum", ACC, prepositions));
        assertTrue(isPresent("umfram", ACC, prepositions));
        assertTrue(isPresent("af", DAT, prepositions));
        assertTrue(isPresent("at", DAT, prepositions));
        assertTrue(isPresent("frá", DAT, prepositions));
        assertTrue(isPresent("hjá", DAT, prepositions));
        assertTrue(isPresent("móti", DAT, prepositions));
        assertTrue(isPresent("nær", DAT, prepositions));
        assertTrue(isPresent("ór", DAT, prepositions));
        assertTrue(isPresent("úr", DAT, prepositions));
        assertTrue(isPresent("undan", DAT, prepositions));
        assertTrue(isPresent("meðal", GEN, prepositions));
        assertTrue(isPresent("milli", GEN, prepositions));
        assertTrue(isPresent("til", GEN, prepositions));
    }

    private boolean isPresent(String latinNotation, Case c, List<Preposition> prepositions){
        return prepositions.stream()
                .anyMatch(p -> p.getLatinNotation().equals(latinNotation) && p.getCase().equals(c));
    }
}
