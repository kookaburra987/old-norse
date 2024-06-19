package me.kookaburra987.oldnorse.concat;

import me.kookaburra987.oldnorse.DeclensionType;
import me.kookaburra987.oldnorse.Gender;
import me.kookaburra987.oldnorse.word.Noun;
import me.kookaburra987.oldnorse.word.Preposition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static me.kookaburra987.oldnorse.Case.DAT;
import static me.kookaburra987.oldnorse.Case.GEN;
import static me.kookaburra987.oldnorse.Number.PL;
import static me.kookaburra987.oldnorse.Number.SG;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Tests PrepositionNounConcatenation in combination with Preposition and Noun.
 */
class PrepositionNounConcatenationIntegrationTest {

    @Test
    void givenPrepositionNullThrowsException(){
        PrepositionNounConcatenationMaker maker = new PrepositionNounConcatenationMaker(SG);
        Noun noun = new Noun("auga", Gender.N, DeclensionType.WEAK);

        Executable doConcat = () -> maker.concat(null, noun);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, doConcat);
        assertEquals("preposition is null", e.getMessage());
    }

    @Test
    void givenNounNullThrowsException(){
        PrepositionNounConcatenationMaker maker = new PrepositionNounConcatenationMaker(SG);
        Preposition preposition = new Preposition("til", GEN);

        Executable doConcat = () -> maker.concat(preposition, null);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, doConcat);
        assertEquals("noun is null", e.getMessage());
    }

    @Test
    void givenPrepositionAndWeakNeuterSgNounConcatenates(){
        PrepositionNounConcatenationMaker maker = new PrepositionNounConcatenationMaker(SG);
        Noun noun = new Noun("auga", Gender.N, DeclensionType.WEAK);
        Preposition preposition = new Preposition("at", DAT);

        String concatenation = maker.concat(preposition, noun);

        assertEquals("at auga", concatenation);
    }

    @Test
    void givenPrepositionAndWeakMasculineSgNounConcatenates(){
        PrepositionNounConcatenationMaker maker = new PrepositionNounConcatenationMaker(SG);
        Noun noun = new Noun("goði", Gender.M, DeclensionType.WEAK);
        Preposition preposition = new Preposition("at", DAT);

        String concatenation = maker.concat(preposition, noun);

        assertEquals("at goða", concatenation);
    }

    @Test
    void givenPrepositionAndWeakNeuterPlNounConcatenates(){
        PrepositionNounConcatenationMaker maker = new PrepositionNounConcatenationMaker(PL);
        Noun noun = new Noun("auga", Gender.N, DeclensionType.WEAK);
        Preposition preposition = new Preposition("at", DAT);

        String concatenation = maker.concat(preposition, noun);

        assertEquals("at augum", concatenation);
    }

    @Test
    void givenPrepositionAndWeakMasculinePlNounConcatenates(){
        PrepositionNounConcatenationMaker maker = new PrepositionNounConcatenationMaker(PL);
        Noun noun = new Noun("goði", Gender.M, DeclensionType.WEAK);
        Preposition preposition = new Preposition("at", DAT);

        String concatenation = maker.concat(preposition, noun);

        assertEquals("at goðum", concatenation);
    }

    @Test
    void givenPrepositionAndWeakFemininePlNounConcatenates(){
        PrepositionNounConcatenationMaker maker = new PrepositionNounConcatenationMaker(PL);
        Noun noun = new Noun("tunga", Gender.F, DeclensionType.WEAK);
        Preposition preposition = new Preposition("til", GEN);

        String concatenation = maker.concat(preposition, noun);

        assertEquals("til tungna", concatenation);
    }
}
