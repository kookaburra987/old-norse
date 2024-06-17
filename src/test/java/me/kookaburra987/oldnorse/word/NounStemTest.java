package me.kookaburra987.oldnorse.word;

import org.junit.jupiter.api.Test;

import static me.kookaburra987.oldnorse.DeclensionType.STRONG;
import static me.kookaburra987.oldnorse.DeclensionType.WEAK;
import static me.kookaburra987.oldnorse.Gender.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NounStemTest {

    @Test
    void givenMasculineWordReturnsStem(){
        Noun noun = new Noun("Bárðr", M, STRONG);

        String stem = noun.stem();

        assertEquals("Bárð", stem);
    }

    @Test
    void givenFeminineWordReturnsStem(){
        Noun noun = new Noun("Helga", F, STRONG);

        String stem = noun.stem();

        assertEquals("Helga", stem);
    }

    @Test
    void givenNeuterWordReturnsStem(){
        Noun noun = new Noun("skip", N, WEAK);

        String stem = noun.stem();

        assertEquals("skip", stem);
    }
}
