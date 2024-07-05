package me.kookaburra987.oldnorse.word.possessivepronoun;

import me.kookaburra987.oldnorse.word.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static me.kookaburra987.oldnorse.word.Person.*;
import static org.junit.jupiter.api.Assertions.*;

class PossessivePronounGetInstanceTest {

    @Test
    void givenPersonNullThenThrowsException(){
        Executable doGetInstance = () -> PossessivePronoun.getInstance(null);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, doGetInstance);

        assertEquals("person is null", e.getMessage());
    }

    @Test
    void givenFirstPersonReturnsMinn(){
        PossessivePronoun possessivePronoun = PossessivePronoun.getInstance(FIRST);

        assertEquals("minn", possessivePronoun.getLatinNotation());
    }

    @Test
    void givenSecondPersonReturnsCorrectPronoun(){
        PossessivePronoun possessivePronoun = PossessivePronoun.getInstance(SECOND);

        assertEquals("þinn", possessivePronoun.getLatinNotation());
    }

    @Test
    void givenThirdPersonReturnsSinn(){
        PossessivePronoun possessivePronoun = PossessivePronoun.getInstance(THIRD);

        assertEquals("sinn", possessivePronoun.getLatinNotation());
    }

    @ParameterizedTest
    @EnumSource(Person.class)
    void givenAskingSamePersonTwiceReturnsSameObject(Person person){
        PossessivePronoun instance = PossessivePronoun.getInstance(person);
        PossessivePronoun secondInstance = PossessivePronoun.getInstance(person);

        assertSame(instance, secondInstance);
    }
}
