package me.kookaburra987.oldnorse.word;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static me.kookaburra987.oldnorse.Gender.*;
import static me.kookaburra987.oldnorse.Number.PL;
import static me.kookaburra987.oldnorse.Number.SG;
import static me.kookaburra987.oldnorse.word.Person.*;
import static org.junit.jupiter.api.Assertions.*;

class PersonalPronounPoolReturnPersonalPronounTest {

    @Test
    void shouldReturnCorrectPersonalPronounForFirstPersonSgGenderNull(){
        PersonalPronoun pp = PersonalPronounPool.returnPersonalPronoun(SG, FIRST, null);

        assertEquals("ek", pp.getLatinNotation());
        assertTrue(pp.hasGender(null));
        assertTrue(pp.hasNumber(SG));
        assertTrue(pp.hasPerson(FIRST));
    }

    @Test
    void shouldReturnCorrectPersonalPronounForFirstPersonSgGenderM(){
        PersonalPronoun pp = PersonalPronounPool.returnPersonalPronoun(SG, FIRST, M);

        assertEquals("ek", pp.getLatinNotation());
        assertTrue(pp.hasGender(null));
        assertTrue(pp.hasNumber(SG));
        assertTrue(pp.hasPerson(FIRST));
    }

    @Test
    void shouldReturnCorrectPersonalPronounForFirstPersonSgGenderF(){
        PersonalPronoun pp = PersonalPronounPool.returnPersonalPronoun(SG, FIRST, F);

        assertEquals("ek", pp.getLatinNotation());
        assertTrue(pp.hasGender(null));
        assertTrue(pp.hasNumber(SG));
        assertTrue(pp.hasPerson(FIRST));
    }

    @Test
    void shouldReturnCorrectPersonalPronounForSecondPersonSgGenderNull(){
        PersonalPronoun pp = PersonalPronounPool.returnPersonalPronoun(SG, SECOND, null);

        assertEquals("þú", pp.getLatinNotation());
        assertTrue(pp.hasGender(null));
        assertTrue(pp.hasNumber(SG));
        assertTrue(pp.hasPerson(SECOND));
    }

    @Test
    void shouldReturnCorrectPersonalPronounForSecondPersonSgGenderM(){
        PersonalPronoun pp = PersonalPronounPool.returnPersonalPronoun(SG, SECOND, M);

        assertEquals("þú", pp.getLatinNotation());
        assertTrue(pp.hasGender(null));
        assertTrue(pp.hasNumber(SG));
        assertTrue(pp.hasPerson(SECOND));
    }

    @Test
    void shouldReturnCorrectPersonalPronounForSecondPersonSgGenderF(){
        PersonalPronoun pp = PersonalPronounPool.returnPersonalPronoun(SG, SECOND, F);

        assertEquals("þú", pp.getLatinNotation());
        assertTrue(pp.hasGender(null));
        assertTrue(pp.hasNumber(SG));
        assertTrue(pp.hasPerson(SECOND));
    }

    @Test
    void shouldReturnCorrectPersonalPronounForThirdPersonSgGenderM(){
        PersonalPronoun pp = PersonalPronounPool.returnPersonalPronoun(SG, THIRD, M);
        assertEquals("hann", pp.getLatinNotation());

        assertTrue(pp.hasGender(M));
        assertTrue(pp.hasNumber(SG));
        assertTrue(pp.hasPerson(THIRD));
    }

    @Test
    void shouldReturnCorrectPersonalPronounForThirdPersonSgGenderF(){
        PersonalPronoun pp = PersonalPronounPool.returnPersonalPronoun(SG, THIRD, F);
        assertEquals("hon", pp.getLatinNotation());

        assertTrue(pp.hasGender(F));
        assertTrue(pp.hasNumber(SG));
        assertTrue(pp.hasPerson(THIRD));
    }

    @Test
    void shouldReturnCorrectPersonalPronounForThirdPersonSgGenderN(){
        PersonalPronoun pp = PersonalPronounPool.returnPersonalPronoun(SG, THIRD, N);
        assertEquals("þat", pp.getLatinNotation());

        assertTrue(pp.hasGender(N));
        assertTrue(pp.hasNumber(SG));
        assertTrue(pp.hasPerson(THIRD));
    }

    @Test
    void shouldReturnCorrectPersonalPronounForFirstPersonPlGenderNull(){
        PersonalPronoun pp = PersonalPronounPool.returnPersonalPronoun(PL, FIRST, null);

        assertEquals("vér", pp.getLatinNotation());
        assertTrue(pp.hasGender(null));
        assertTrue(pp.hasNumber(PL));
        assertTrue(pp.hasPerson(FIRST));
    }

    @Test
    void shouldReturnCorrectPersonalPronounForFirstPersonPlGenderM(){
        PersonalPronoun pp = PersonalPronounPool.returnPersonalPronoun(PL, FIRST, M);

        assertEquals("vér", pp.getLatinNotation());
        assertTrue(pp.hasGender(null));
        assertTrue(pp.hasNumber(PL));
        assertTrue(pp.hasPerson(FIRST));
    }

    @Test
    void shouldReturnCorrectPersonalPronounForFirstPersonPlGenderF(){
        PersonalPronoun pp = PersonalPronounPool.returnPersonalPronoun(PL, FIRST, F);

        assertEquals("vér", pp.getLatinNotation());
        assertTrue(pp.hasGender(null));
        assertTrue(pp.hasNumber(PL));
        assertTrue(pp.hasPerson(FIRST));
    }

    @Test
    void shouldReturnCorrectPersonalPronounForSecondPersonPlGenderNull(){
        PersonalPronoun pp = PersonalPronounPool.returnPersonalPronoun(PL, SECOND, null);

        assertEquals("þér", pp.getLatinNotation());
        assertTrue(pp.hasGender(null));
        assertTrue(pp.hasNumber(PL));
        assertTrue(pp.hasPerson(SECOND));
    }

    @Test
    void shouldReturnCorrectPersonalPronounForSecondPersonPlGenderM(){
        PersonalPronoun pp = PersonalPronounPool.returnPersonalPronoun(PL, SECOND, M);

        assertEquals("þér", pp.getLatinNotation());
        assertTrue(pp.hasGender(null));
        assertTrue(pp.hasNumber(PL));
        assertTrue(pp.hasPerson(SECOND));
    }

    @Test
    void shouldReturnCorrectPersonalPronounForSecondPersonPlGenderF(){
        PersonalPronoun pp = PersonalPronounPool.returnPersonalPronoun(PL, SECOND, F);

        assertEquals("þér", pp.getLatinNotation());
        assertTrue(pp.hasGender(null));
        assertTrue(pp.hasNumber(PL));
        assertTrue(pp.hasPerson(SECOND));
    }

    @Test
    void shouldReturnCorrectPersonalPronounForThirdPersonPlGenderM(){
        PersonalPronoun pp = PersonalPronounPool.returnPersonalPronoun(PL, THIRD, M);
        assertEquals("þeir", pp.getLatinNotation());

        assertTrue(pp.hasGender(M));
        assertTrue(pp.hasNumber(PL));
        assertTrue(pp.hasPerson(THIRD));
    }

    @Test
    void shouldReturnCorrectPersonalPronounForThirdPersonPlGenderF(){
        PersonalPronoun pp = PersonalPronounPool.returnPersonalPronoun(PL, THIRD, F);
        assertEquals("þær", pp.getLatinNotation());

        assertTrue(pp.hasGender(F));
        assertTrue(pp.hasNumber(PL));
        assertTrue(pp.hasPerson(THIRD));
    }

    @Test
    void shouldReturnCorrectPersonalPronounForThirdPersonPlGenderN(){
        PersonalPronoun pp = PersonalPronounPool.returnPersonalPronoun(PL, THIRD, N);
        assertEquals("þau", pp.getLatinNotation());

        assertTrue(pp.hasGender(N));
        assertTrue(pp.hasNumber(PL));
        assertTrue(pp.hasPerson(THIRD));
    }

    @Test
    void givenThirdPersonAndNoGenderShouldThrowException(){
        Executable doReturnPersonalPronoun = () -> PersonalPronounPool.returnPersonalPronoun(SG, THIRD, null);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, doReturnPersonalPronoun);
        assertEquals("gender is required when 3rd person is used", e.getMessage());
    }

    @Test
    void givenNumberNullShouldThrowException(){
        Executable doReturnPersonalPronoun = () -> PersonalPronounPool.returnPersonalPronoun(null, THIRD, M);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, doReturnPersonalPronoun);
        assertEquals("number is null", e.getMessage());
    }

    @Test
    void givenPersonNullShouldThrowException(){
        Executable doReturnPersonalPronoun = () -> PersonalPronounPool.returnPersonalPronoun(SG, null, M);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, doReturnPersonalPronoun);
        assertEquals("person is null", e.getMessage());
    }
}
