package me.kookaburra987.oldnorse.word.noun;

import org.junit.jupiter.api.Test;

import static me.kookaburra987.oldnorse.DeclensionType.STRONG;
import static me.kookaburra987.oldnorse.Gender.M;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class NounConstructorTest {

    @Test
    void givenValidParametersConstructsNoun(){
        Noun noun = new Noun("Bárðr", M, STRONG, true, null);

        assertNotNull(noun);
        assertEquals("Bárðr", noun.getLatinNotation());
        assertEquals(M, noun.getGender());
        assertEquals(STRONG, noun.getDeclensionType());
    }
}
