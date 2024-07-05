package me.kookaburra987.oldnorse.word.personalpronoun;

import org.junit.jupiter.api.Test;

import static me.kookaburra987.oldnorse.Gender.F;
import static me.kookaburra987.oldnorse.Gender.N;
import static me.kookaburra987.oldnorse.Number.PL;
import static me.kookaburra987.oldnorse.Number.SG;
import static me.kookaburra987.oldnorse.word.Person.SECOND;
import static me.kookaburra987.oldnorse.word.Person.THIRD;
import static org.junit.jupiter.api.Assertions.*;

class PersonalPronounEqualsTest {

    @Test
    void givenTwoPersonalPronounsWithSameGenderNumberAndPersonThenReturnsTrue(){
        PersonalPronoun pp1 = new PersonalPronoun(SG, SECOND, F);
        PersonalPronoun pp2 = new PersonalPronoun(SG, SECOND, F);

        assertTrue(pp1.equals(pp2));
    }

    @Test
    void givenDifferentNumberThenReturnsFalse(){
        PersonalPronoun pp1 = new PersonalPronoun(SG, SECOND, F);
        PersonalPronoun pp2 = new PersonalPronoun(PL, SECOND, F);

        assertFalse(pp1.equals(pp2));
    }

    @Test
    void givenDifferentPersonThenReturnsFalse(){
        PersonalPronoun pp1 = new PersonalPronoun(SG, SECOND, F);
        PersonalPronoun pp2 = new PersonalPronoun(SG, THIRD, F);

        assertFalse(pp1.equals(pp2));
    }

    @Test
    void givenDifferentGenderThenReturnsFalse(){
        PersonalPronoun pp1 = new PersonalPronoun(SG, THIRD, F);
        PersonalPronoun pp2 = new PersonalPronoun(SG, THIRD, N);

        assertFalse(pp1.equals(pp2));
    }
}
