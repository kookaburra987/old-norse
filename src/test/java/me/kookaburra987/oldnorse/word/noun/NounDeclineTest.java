package me.kookaburra987.oldnorse.word.noun;


import me.kookaburra987.oldnorse.word.Noun;
import org.junit.jupiter.api.Test;

import static me.kookaburra987.oldnorse.Case.*;
import static me.kookaburra987.oldnorse.DeclensionType.WEAK;
import static me.kookaburra987.oldnorse.Gender.*;
import static me.kookaburra987.oldnorse.Number.PL;
import static me.kookaburra987.oldnorse.Number.SG;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NounDeclineTest {

    @Test
    void givenWeakMasculineNounDeclines(){
        Noun noun = new Noun("goði", M, WEAK);

        assertEquals("goði", noun.decline(NOM, SG));
        assertEquals("goða", noun.decline(ACC, SG));
        assertEquals("goða", noun.decline(DAT, SG));
        assertEquals("goða", noun.decline(GEN, SG));

        assertEquals("goðar", noun.decline(NOM, PL));
        assertEquals("goða", noun.decline(ACC, PL));
        assertEquals("goðum", noun.decline(DAT, PL));
        assertEquals("goða", noun.decline(GEN, PL));
    }

    @Test
    void givenWeakFeminineNounDeclines(){
        Noun noun = new Noun("tunga", F, WEAK);

        assertEquals("tunga", noun.decline(NOM, SG));
        assertEquals("tungu", noun.decline(ACC, SG));
        assertEquals("tungu", noun.decline(DAT, SG));
        assertEquals("tungu", noun.decline(GEN, SG));

        assertEquals("tungur", noun.decline(NOM, PL));
        assertEquals("tungur", noun.decline(ACC, PL));
        assertEquals("tungum", noun.decline(DAT, PL));
        assertEquals("tungna", noun.decline(GEN, PL));
    }

    @Test
    void givenWeakNeuterNounDeclines(){
        Noun noun = new Noun("auga", N, WEAK);

        assertEquals("auga", noun.decline(NOM, SG));
        assertEquals("auga", noun.decline(ACC, SG));
        assertEquals("auga", noun.decline(DAT, SG));
        assertEquals("auga", noun.decline(GEN, SG));

        assertEquals("augu", noun.decline(NOM, PL));
        assertEquals("augu", noun.decline(ACC, PL));
        assertEquals("augum", noun.decline(DAT, PL));
        assertEquals("augna", noun.decline(GEN, PL));
    }
}
