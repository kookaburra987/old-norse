package me.kookaburra987.oldnorse.word.preposition;

import me.kookaburra987.oldnorse.word.Preposition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static me.kookaburra987.oldnorse.Case.ACC;
import static me.kookaburra987.oldnorse.Case.GEN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PrepositionConstructorTest {

    @Test
    void givenLatinNotationNullThrowsException(){
        Executable createPreposition = () -> new Preposition(null, GEN);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, createPreposition);
        assertEquals("latinNotation is blank", e.getMessage());
    }

    @Test
    void givenLatinNotationBlankStringThrowsException(){
        Executable createPreposition = () -> new Preposition(" ", GEN);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, createPreposition);
        assertEquals("latinNotation is blank", e.getMessage());
    }

    @Test
    void givenCaseNullThrowsException(){
        Executable createPreposition = () -> new Preposition("gegnum", null);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, createPreposition);
        assertEquals("case is null", e.getMessage());
    }

    @Test
    void givenLatinNotationCreatesPreposition(){
        Preposition preposition = new Preposition("gegnum", ACC);

        assertEquals("gegnum", preposition.getLatinNotation());
        assertEquals(ACC, preposition.getCase());
    }

    @Test
    void givenLatinNotationWithStartingAndTrailingWhiteSpaceCreatesTrimmedPreposition(){
        Preposition preposition = new Preposition(" gegnum  ", ACC);

        assertEquals("gegnum", preposition.getLatinNotation());
        assertEquals(ACC, preposition.getCase());
    }
}
