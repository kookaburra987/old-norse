package me.kookaburra987.oldnorse.word.possessivepronoun;

import org.junit.jupiter.api.Test;

import static me.kookaburra987.oldnorse.Case.*;
import static me.kookaburra987.oldnorse.Gender.*;
import static me.kookaburra987.oldnorse.Number.PL;
import static me.kookaburra987.oldnorse.Number.SG;
import static me.kookaburra987.oldnorse.word.Person.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PossessivePronounDeclineTest {

    @Test
    void givenFirstPersonMasculineThenShouldDecline(){
        PossessivePronoun pronoun = PossessivePronoun.getInstance(FIRST);

        assertEquals("minn", pronoun.decline(NOM, SG, M));
        assertEquals("minn", pronoun.decline(ACC, SG, M));
        assertEquals("mínum", pronoun.decline(DAT, SG, M));
        assertEquals("míns", pronoun.decline(GEN, SG, M));

        assertEquals("mínir", pronoun.decline(NOM, PL, M));
        assertEquals("mína", pronoun.decline(ACC, PL, M));
        assertEquals("mínum", pronoun.decline(DAT, PL, M));
        assertEquals("minna", pronoun.decline(GEN, PL, M));
    }

    @Test
    void givenFirstPersonFeminineThenShouldDecline(){
        PossessivePronoun pronoun = PossessivePronoun.getInstance(FIRST);

        assertEquals("mín", pronoun.decline(NOM, SG, F));
        assertEquals("mína", pronoun.decline(ACC, SG, F));
        assertEquals("minni", pronoun.decline(DAT, SG, F));
        assertEquals("minnar", pronoun.decline(GEN, SG, F));

        assertEquals("mínar", pronoun.decline(NOM, PL, F));
        assertEquals("mínar", pronoun.decline(ACC, PL, F));
        assertEquals("mínum", pronoun.decline(DAT, PL, F));
        assertEquals("minna", pronoun.decline(GEN, PL, F));
    }

    @Test
    void givenFirstPersonNeuterThenShouldDecline(){
        PossessivePronoun pronoun = PossessivePronoun.getInstance(FIRST);

        assertEquals("mitt", pronoun.decline(NOM, SG, N));
        assertEquals("mitt", pronoun.decline(ACC, SG, N));
        assertEquals("mínu", pronoun.decline(DAT, SG, N));
        assertEquals("míns", pronoun.decline(GEN, SG, N));

        assertEquals("mín", pronoun.decline(NOM, PL, N));
        assertEquals("mín", pronoun.decline(ACC, PL, N));
        assertEquals("mínum", pronoun.decline(DAT, PL, N));
        assertEquals("minna", pronoun.decline(GEN, PL, N));
    }

    //second person
    @Test
    void givenSecondPersonMasculineThenShouldDecline(){
        PossessivePronoun pronoun = PossessivePronoun.getInstance(SECOND);

        assertEquals("þinn", pronoun.decline(NOM, SG, M));
        assertEquals("þinn", pronoun.decline(ACC, SG, M));
        assertEquals("þínum", pronoun.decline(DAT, SG, M));
        assertEquals("þíns", pronoun.decline(GEN, SG, M));

        assertEquals("þínir", pronoun.decline(NOM, PL, M));
        assertEquals("þína", pronoun.decline(ACC, PL, M));
        assertEquals("þínum", pronoun.decline(DAT, PL, M));
        assertEquals("þinna", pronoun.decline(GEN, PL, M));
    }

    @Test
    void givenSecondPersonFeminineThenShouldDecline(){
        PossessivePronoun pronoun = PossessivePronoun.getInstance(SECOND);

        assertEquals("þín", pronoun.decline(NOM, SG, F));
        assertEquals("þína", pronoun.decline(ACC, SG, F));
        assertEquals("þinni", pronoun.decline(DAT, SG, F));
        assertEquals("þinnar", pronoun.decline(GEN, SG, F));

        assertEquals("þínar", pronoun.decline(NOM, PL, F));
        assertEquals("þínar", pronoun.decline(ACC, PL, F));
        assertEquals("þínum", pronoun.decline(DAT, PL, F));
        assertEquals("þinna", pronoun.decline(GEN, PL, F));
    }

    @Test
    void givenSecondPersonNeuterThenShouldDecline(){
        PossessivePronoun pronoun = PossessivePronoun.getInstance(SECOND);

        assertEquals("þitt", pronoun.decline(NOM, SG, N));
        assertEquals("þitt", pronoun.decline(ACC, SG, N));
        assertEquals("þínu", pronoun.decline(DAT, SG, N));
        assertEquals("þíns", pronoun.decline(GEN, SG, N));

        assertEquals("þín", pronoun.decline(NOM, PL, N));
        assertEquals("þín", pronoun.decline(ACC, PL, N));
        assertEquals("þínum", pronoun.decline(DAT, PL, N));
        assertEquals("þinna", pronoun.decline(GEN, PL, N));
    }

    //3rd person
    @Test
    void givenThirdPersonMasculineThenShouldDecline(){
        PossessivePronoun pronoun = PossessivePronoun.getInstance(THIRD);

        assertEquals("sinn", pronoun.decline(NOM, SG, M));
        assertEquals("sinn", pronoun.decline(ACC, SG, M));
        assertEquals("sínum", pronoun.decline(DAT, SG, M));
        assertEquals("síns", pronoun.decline(GEN, SG, M));

        assertEquals("sínir", pronoun.decline(NOM, PL, M));
        assertEquals("sína", pronoun.decline(ACC, PL, M));
        assertEquals("sínum", pronoun.decline(DAT, PL, M));
        assertEquals("sinna", pronoun.decline(GEN, PL, M));
    }

    @Test
    void givenThirdPersonFeminineThenShouldDecline(){
        PossessivePronoun pronoun = PossessivePronoun.getInstance(THIRD);

        assertEquals("sín", pronoun.decline(NOM, SG, F));
        assertEquals("sína", pronoun.decline(ACC, SG, F));
        assertEquals("sinni", pronoun.decline(DAT, SG, F));
        assertEquals("sinnar", pronoun.decline(GEN, SG, F));

        assertEquals("sínar", pronoun.decline(NOM, PL, F));
        assertEquals("sínar", pronoun.decline(ACC, PL, F));
        assertEquals("sínum", pronoun.decline(DAT, PL, F));
        assertEquals("sinna", pronoun.decline(GEN, PL, F));
    }

    @Test
    void givenThirdPersonNeuterThenShouldDecline(){
        PossessivePronoun pronoun = PossessivePronoun.getInstance(THIRD);

        assertEquals("sitt", pronoun.decline(NOM, SG, N));
        assertEquals("sitt", pronoun.decline(ACC, SG, N));
        assertEquals("sínu", pronoun.decline(DAT, SG, N));
        assertEquals("síns", pronoun.decline(GEN, SG, N));

        assertEquals("sín", pronoun.decline(NOM, PL, N));
        assertEquals("sín", pronoun.decline(ACC, PL, N));
        assertEquals("sínum", pronoun.decline(DAT, PL, N));
        assertEquals("sinna", pronoun.decline(GEN, PL, N));
    }
}
