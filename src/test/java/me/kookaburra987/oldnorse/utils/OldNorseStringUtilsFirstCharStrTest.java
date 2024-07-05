package me.kookaburra987.oldnorse.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class OldNorseStringUtilsFirstCharStrTest {

    @Test
    void givenStringReturnsFirstCharStr(){
        assertEquals("b", OldNorseStringUtils.firstCharStr("ba"));
    }

    @Test
    void givenNullReturnsNull(){
        assertNull(OldNorseStringUtils.firstCharStr(null));
    }

    @Test
    void givenEmptyStringReturnsEmptyString(){
        assertEquals("", OldNorseStringUtils.firstCharStr(""));
    }
}
