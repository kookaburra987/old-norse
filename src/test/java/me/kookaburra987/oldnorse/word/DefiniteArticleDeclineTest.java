package me.kookaburra987.oldnorse.word;

import me.kookaburra987.oldnorse.Gender;
import me.kookaburra987.oldnorse.Number;
import org.junit.jupiter.api.Test;

import static me.kookaburra987.oldnorse.Case.*;
import static me.kookaburra987.oldnorse.Gender.*;
import static me.kookaburra987.oldnorse.Number.PL;
import static me.kookaburra987.oldnorse.Number.SG;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DefiniteArticleDeclineTest {

    private final DefiniteArticle inn = DefiniteArticle.getInstance();

    @Test
    void givenMasculineSgDeclines(){
        Number number = SG;
        Gender gender = M;

        assertEquals("inn", inn.decline(NOM, number, gender));
        assertEquals("inn", inn.decline(ACC, number, gender));
        assertEquals("inum", inn.decline(DAT, number, gender));
        assertEquals("ins", inn.decline(GEN, number, gender));
    }

    @Test
    void givenFeminineSgDeclines(){
        Number number = SG;
        Gender gender = F;

        assertEquals("in", inn.decline(NOM, number, gender));
        assertEquals("ina", inn.decline(ACC, number, gender));
        assertEquals("inni", inn.decline(DAT, number, gender));
        assertEquals("innar", inn.decline(GEN, number, gender));
    }

    @Test
    void givenNeuterSgDeclines(){
        Number number = SG;
        Gender gender = N;

        assertEquals("it", inn.decline(NOM, number, gender));
        assertEquals("it", inn.decline(ACC, number, gender));
        assertEquals("inu", inn.decline(DAT, number, gender));
        assertEquals("ins", inn.decline(GEN, number, gender));
    }

    @Test
    void givenMasculinePlDeclines(){
        Number number = PL;
        Gender gender = M;

        assertEquals("inir", inn.decline(NOM, number, gender));
        assertEquals("ina", inn.decline(ACC, number, gender));
        assertEquals("inum", inn.decline(DAT, number, gender));
        assertEquals("inna", inn.decline(GEN, number, gender));
    }

    @Test
    void givenFemininePlDeclines(){
        Number number = PL;
        Gender gender = F;

        assertEquals("inar", inn.decline(NOM, number, gender));
        assertEquals("inar", inn.decline(ACC, number, gender));
        assertEquals("inum", inn.decline(DAT, number, gender));
        assertEquals("inna", inn.decline(GEN, number, gender));
    }

    @Test
    void givenNeuterPlDeclines(){
        Number number = PL;
        Gender gender = N;

        assertEquals("in", inn.decline(NOM, number, gender));
        assertEquals("in", inn.decline(ACC, number, gender));
        assertEquals("inum", inn.decline(DAT, number, gender));
        assertEquals("inna", inn.decline(GEN, number, gender));
    }

}
