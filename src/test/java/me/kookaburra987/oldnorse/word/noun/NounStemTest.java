package me.kookaburra987.oldnorse.word.noun;

import org.junit.jupiter.api.Test;

import static me.kookaburra987.oldnorse.DeclensionType.STRONG;
import static me.kookaburra987.oldnorse.DeclensionType.WEAK;
import static me.kookaburra987.oldnorse.Gender.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NounStemTest {

    @Test
    void givenMasculineWordReturnsStem(){
        Noun noun = new Noun("Bárðr", M, STRONG, true, null);

        String stem = noun.stem();

        assertEquals("Bárð", stem);
    }

    @Test
    void givenFeminineWordReturnsStem(){
        Noun noun = new Noun("Helga", F, STRONG, true, null);

        String stem = noun.stem();

        assertEquals("Helg", stem);
    }

    @Test
    void givenNeuterWordReturnsStem(){
        Noun noun = new Noun("auga", N, WEAK);

        String stem = noun.stem();

        assertEquals("aug", stem);
    }
}
