package me.kookaburra987.oldnorse.utils;

import me.kookaburra987.oldnorse.Case;
import me.kookaburra987.oldnorse.Gender;
import me.kookaburra987.oldnorse.Number;

import static me.kookaburra987.oldnorse.Gender.*;

/**
 * Class that maps the case, gender and number of a {@link me.kookaburra987.oldnorse.word.Noun} to the ending of it.
 */
public final class NounEndingMapper {

    private NounEndingMapper() {
    }

    public static String endingOfWeakNoun(Case c, Gender gender, Number number){
        if (gender.equals(M)){
            return endingOfMaleNoun(c, number);
        }
        if (gender.equals(F)){
            return endingOfFemaleNoun(c, number);
        }
        if (gender.equals(N)){
            return endingOfNeuterNoun(c, number);
        }
        return null;
    }

    public static String endingOfNeuterNoun(Case c, Number number) {
        if (number.isMultiple()){
            return endingOfNeuterPlNoun(c);
        }
        return "a";
    }

    private static String endingOfNeuterPlNoun(Case c) {
        return switch (c) {
            case DAT -> "um";
            case GEN -> "na";
            default -> "u";
        };
    }

    public static String endingOfFemaleNoun(Case c, Number number) {
        if (number.isMultiple()){
            return endingOfFemalePlNoun(c);
        }
        return endingOfFemaleSgNoun(c);
    }

    private static String endingOfFemalePlNoun(Case c) {
        return switch (c) {
            case DAT -> "um";
            case GEN -> "na";
            default -> "ur";
        };
    }

    private static String endingOfFemaleSgNoun(Case c) {
        if (c.equals(Case.NOM)){
            return "a";
        }
        return "u";
    }

    public static String endingOfMaleNoun(Case c, Number number) {
        if (number.isMultiple()){
            return endingOfMalePlNoun(c);
        }
        return endingOfMaleSgNoun(c);
    }

    private static String endingOfMalePlNoun(Case c) {
        return switch (c) {
            case NOM -> "ar";
            case DAT -> "um";
            default -> "a";
        };
    }

    private static String endingOfMaleSgNoun(Case c) {
        if (c.equals(Case.NOM)){
            return "i";
        }
        return "a";
    }
}
