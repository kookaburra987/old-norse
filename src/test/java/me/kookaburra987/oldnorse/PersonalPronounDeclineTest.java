package me.kookaburra987.oldnorse;

import me.kookaburra987.oldnorse.word.PersonalPronoun;
import me.kookaburra987.oldnorse.word.UnsupportedDeclensionException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static me.kookaburra987.oldnorse.Case.*;
import static me.kookaburra987.oldnorse.Number.SG;
import static me.kookaburra987.oldnorse.word.Person.FIRST;
import static me.kookaburra987.oldnorse.word.Person.SECOND;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
