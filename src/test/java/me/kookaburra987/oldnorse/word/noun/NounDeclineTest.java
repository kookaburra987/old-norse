package me.kookaburra987.oldnorse.word.noun;


import me.kookaburra987.oldnorse.word.Noun;
import org.junit.jupiter.api.Test;

import static me.kookaburra987.oldnorse.Case.*;
import static me.kookaburra987.oldnorse.DeclensionType.STRONG;
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

    @Test
    void givenStrongNeuterNounDeclines(){
        Noun noun = new Noun("skip", N, STRONG);

        String[] expectations = {"skip", "skip", "skipi", "skips", "skip", "skip", "skipum", "skipa"};
        testDeclension(noun, expectations);
    }

    //test for the word: mál
    @Test
    void givenNounMalDeclines(){
        Noun noun = new Noun("mál", N, STRONG);

        String[] expectations = {"mál", "mál", "máli", "máls", "mál", "mál", "málum", "mála"};
        testDeclension(noun, expectations);
    }

    //test for the word: sverð
    @Test
    void givenNounSverdDeclines(){
        Noun noun = new Noun("sverð", N, STRONG);

        String[] expectations = {"sverð", "sverð", "sverði", "sverðs", "sverð", "sverð", "sverðum", "sverða"};
        testDeclension(noun, expectations);
    }

    //test for the word:
    @Test
    void givenNounThingDeclines(){
        Noun noun = new Noun("þing", N, STRONG);

        String[] expectations = {"þing", "þing", "þingi", "þings", "þing", "þing", "þingum", "þinga"};
        testDeclension(noun, expectations);
    }

    /**
     * Tests the declension for a specific noun.
     * @param noun for which declining has to be tested
     * @param expectations list of expected results in this order:
     *                     NOM SG
     *                     ACC SG
     *                     DAT SG
     *                     GEN SG
     *                     NOM PL
     *                     ACC PL
     *                     DAT PL
     *                     GEN PL
     */
    private void testDeclension(Noun noun, String[] expectations){
        assertEquals(expectations[0], noun.decline(NOM, SG));
        assertEquals(expectations[1], noun.decline(ACC, SG));
        assertEquals(expectations[2], noun.decline(DAT, SG));
        assertEquals(expectations[3], noun.decline(GEN, SG));

        assertEquals(expectations[4], noun.decline(NOM, PL));
        assertEquals(expectations[5], noun.decline(ACC, PL));
        assertEquals(expectations[6], noun.decline(DAT, PL));
        assertEquals(expectations[7], noun.decline(GEN, PL));
    }
}
