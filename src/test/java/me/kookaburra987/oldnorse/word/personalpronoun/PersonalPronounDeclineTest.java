package me.kookaburra987.oldnorse.word.personalpronoun;

import me.kookaburra987.oldnorse.Gender;
import me.kookaburra987.oldnorse.word.UnsupportedDeclensionException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static me.kookaburra987.oldnorse.Case.*;
import static me.kookaburra987.oldnorse.Gender.*;
import static me.kookaburra987.oldnorse.Number.DUAL;
import static me.kookaburra987.oldnorse.Number.SG;
import static me.kookaburra987.oldnorse.word.Person.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonalPronounDeclineTest {

    @ParameterizedTest
    @EnumSource(Gender.class)
    void givenFirstPersonSgThenReturnsDeclension(Gender gender) throws UnsupportedDeclensionException {
        PersonalPronoun pp = new PersonalPronoun(SG, FIRST, gender);

        assertEquals("ek", pp.decline(NOM));
        assertEquals("mik", pp.decline(ACC));
        assertEquals("mér", pp.decline(DAT));
        assertEquals("mín", pp.decline(GEN));
    }

    @ParameterizedTest
    @EnumSource(Gender.class)
    void givenSecondPersonSgThenReturnsDeclension(Gender gender) throws UnsupportedDeclensionException {
        PersonalPronoun pp = new PersonalPronoun(SG, SECOND, gender);

        assertEquals("þú", pp.decline(NOM));
        assertEquals("þik", pp.decline(ACC));
        assertEquals("þér", pp.decline(DAT));
        assertEquals("þín", pp.decline(GEN));
    }

    @ParameterizedTest
    @EnumSource(Gender.class)
    void givenFirstPersonDualThenReturnsDeclension(Gender gender) throws UnsupportedDeclensionException {
        PersonalPronoun pp = new PersonalPronoun(DUAL, FIRST, gender);

        assertEquals("vit", pp.decline(NOM));
        assertEquals("okkr", pp.decline(ACC));
        assertEquals("okkr", pp.decline(DAT));
        assertEquals("okkar", pp.decline(GEN));
    }

    @ParameterizedTest
    @EnumSource(Gender.class)
    void givenSecondPersonDualThenReturnsDeclension(Gender gender) throws UnsupportedDeclensionException {
        PersonalPronoun pp = new PersonalPronoun(DUAL, SECOND, gender);

        assertEquals("þit", pp.decline(NOM));
        assertEquals("ykkr", pp.decline(ACC));
        assertEquals("ykkr", pp.decline(DAT));
        assertEquals("ykkar", pp.decline(GEN));
    }

    @Test
    void givenSgThirdPersonMasculineThenReturnsDeclension() throws UnsupportedDeclensionException {
        PersonalPronoun pp = new PersonalPronoun(SG, THIRD, M);

        assertEquals("hann", pp.decline(NOM));
        assertEquals("hann", pp.decline(ACC));
        assertEquals("honum", pp.decline(DAT));
        assertEquals("hans", pp.decline(GEN));
    }

    @Test
    void givenSgThirdPersonFeminineThenReturnsDeclension() throws UnsupportedDeclensionException {
        PersonalPronoun pp = new PersonalPronoun(SG, THIRD, F);

        assertEquals("hon", pp.decline(NOM));
        assertEquals("hana", pp.decline(ACC));
        assertEquals("henni", pp.decline(DAT));
        assertEquals("hennar", pp.decline(GEN));
    }

    @Test
    void givenSgThirdPersonNeuterThenReturnsDeclension() throws UnsupportedDeclensionException {
        PersonalPronoun pp = new PersonalPronoun(SG, THIRD, N);

        assertEquals("þat", pp.decline(NOM));
        assertEquals("þat", pp.decline(ACC));
        assertEquals("því", pp.decline(DAT));
        assertEquals("þess", pp.decline(GEN));
    }

    @Test
    void givenCaseNullThenThrowsIllegalArgumentException(){
        PersonalPronoun pp = new PersonalPronoun(DUAL, SECOND, M);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> pp.decline(null));

        assertEquals("case is null", e.getMessage());
    }

}
