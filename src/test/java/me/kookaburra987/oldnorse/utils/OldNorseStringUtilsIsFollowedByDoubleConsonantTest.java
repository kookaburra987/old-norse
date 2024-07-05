package me.kookaburra987.oldnorse.utils;

import org.junit.jupiter.api.Test;

import static me.kookaburra987.oldnorse.utils.OldNorseStringUtils.isFollowedByDoubleConsonant;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OldNorseStringUtilsIsFollowedByDoubleConsonantTest {

    @Test
    void whenCharacterIsFollowedByDoubleConsonantThenReturnsTrue(){
        assertTrue(isFollowedByDoubleConsonant("inn", 0));
        assertTrue(isFollowedByDoubleConsonant("epp", 0));
        assertTrue(isFollowedByDoubleConsonant("leiff", 2));
        assertTrue(isFollowedByDoubleConsonant("leiffs", 2));
    }

    @Test
    void whenCharacterNotFollowedDoubleConsonantThenReturnsFalse(){
        assertFalse(isFollowedByDoubleConsonant("ina", 0));
        assertFalse(isFollowedByDoubleConsonant("eat", 0));
        assertFalse(isFollowedByDoubleConsonant("leif", 2));
        assertFalse(isFollowedByDoubleConsonant("lei ", 2));
        assertFalse(isFollowedByDoubleConsonant("lei", 2));
        assertFalse(isFollowedByDoubleConsonant("ins", 0));
    }
}
