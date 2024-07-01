package me.kookaburra987.oldnorse.word.personalpronoun;

import me.kookaburra987.oldnorse.Gender;
import me.kookaburra987.oldnorse.word.PersonalPronoun;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static me.kookaburra987.oldnorse.Number.DUAL;
import static me.kookaburra987.oldnorse.word.Person.THIRD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonalPronounConstructorTest {

    @ParameterizedTest
    @EnumSource(Gender.class)
    void given3rdPersonAndDualShouldThrowException(Gender gender){
        Executable doReturnPersonalPronoun = () -> new PersonalPronoun(DUAL, THIRD, gender);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, doReturnPersonalPronoun);
        assertEquals("dual number not allowed for 3rd person", e.getMessage());
    }

}
