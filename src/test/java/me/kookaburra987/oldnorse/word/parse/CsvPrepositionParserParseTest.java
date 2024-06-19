package me.kookaburra987.oldnorse.word.parse;

import me.kookaburra987.oldnorse.word.Preposition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.List;

import static me.kookaburra987.oldnorse.Case.ACC;
import static me.kookaburra987.oldnorse.Case.DAT;
import static org.junit.jupiter.api.Assertions.*;

class CsvPrepositionParserParseTest {

    private CsvPrepositionParser parser;

    @BeforeEach
    void setup(){
        parser = new CsvPrepositionParser();
    }

    @Test
    void givenBlankLineThrowsException(){
        Executable doParse = () -> parser.parse(" ");

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, doParse);
        assertEquals("line is blank", e.getMessage());
    }

    @Test
    void givenLineWithOneElementThrowsException(){
        Executable doParse = () -> parser.parse("at");

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, doParse);
        assertEquals("line has invalid amount of elements", e.getMessage());
    }

    @Test
    void givenInvalidCaseThrowsException(){
        Executable doParse = () -> parser.parse("at, cat");

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, doParse);
        assertEquals("case is invalid", e.getMessage());
    }

    @Test
    void givenLineWithTwoElementsReturnsPreposition(){
        Preposition preposition = parser.parse("at, dat");

        assertNotNull(preposition);
        assertEquals("at", preposition.getLatinNotation());
        assertEquals(DAT, preposition.getCase());
    }

    @Test
    void givenLineWithThreeElementsReturnsPreposition(){
        Preposition preposition = parser.parse("at, dat, ignoreThis");

        assertNotNull(preposition);
        assertEquals("at", preposition.getLatinNotation());
        assertEquals(DAT, preposition.getCase());
    }

    @Test
    void givenLineWithWhiteSpacesReturnsPrepositionTrimmed(){
        Preposition preposition = parser.parse(" at , dat ");

        assertNotNull(preposition);
        assertEquals("at", preposition.getLatinNotation());
        assertEquals(DAT, preposition.getCase());
    }

    @Test
    void givenLinesEmptyArrayThrowsException(){
        String[] lines = {};

        Executable doParse = () -> parser.parse(lines);

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, doParse);
        assertEquals("lines is empty", e.getMessage());
    }

    @Test
    void givenLinesArrayReturnsListOfPrepositions(){
        String[] lines = {"af,dat","gegnum,acc"};

        List<Preposition> prepositions = parser.parse(lines);

        assertNotNull(prepositions);
        assertEquals(2, prepositions.size());
        boolean firstPrepositionCreated = prepositions.stream()
                .anyMatch(p -> p.getLatinNotation().equals("af") && p.getCase().equals(DAT));
        assertTrue(firstPrepositionCreated);
        boolean secondPrepositionCreated = prepositions.stream()
                .anyMatch(p -> p.getLatinNotation().equals("gegnum") && p.getCase().equals(ACC));
        assertTrue(secondPrepositionCreated);
    }
}
