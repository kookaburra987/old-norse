package me.kookaburra987.oldnorse.word.lists;

import me.kookaburra987.oldnorse.DeclensionType;
import me.kookaburra987.oldnorse.Gender;
import me.kookaburra987.oldnorse.word.noun.Noun;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static me.kookaburra987.oldnorse.DeclensionType.STRONG;
import static me.kookaburra987.oldnorse.DeclensionType.WEAK;
import static me.kookaburra987.oldnorse.Gender.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DefaultWordListFacadeNounListTest {
    private DefaultWordListFacade facade;

    @BeforeEach
    void setup(){
        facade = new DefaultWordListFacade();
    }

    @Test
    void returnsNounList(){
        List<Noun> nouns = facade.nounList();

        assertEquals(8, nouns.size());
        assertTrue(isPresent("goði", M, WEAK, nouns));
        assertTrue(isPresent("tunga", F, WEAK, nouns));
        assertTrue(isPresent("auga", N, WEAK, nouns));
        assertTrue(isPresent("skip", N, STRONG, nouns));
        assertTrue(isPresent("mál", N, STRONG, nouns));
        assertTrue(isPresent("sverð", N, STRONG, nouns));
        assertTrue(isPresent("þing", N, STRONG, nouns));
        assertTrue(isPresent("ferð", F, STRONG, nouns));
    }

    private boolean isPresent(String latinNotation, Gender gender, DeclensionType declensionType, List<Noun> nouns) {
        return nouns.stream()
                .anyMatch(n -> n.getLatinNotation().equals(latinNotation)
                    && n.getGender().equals(gender)
                    && n.getDeclensionType().equals(declensionType)
                    && n.getIrregularity() == null);
    }

}
