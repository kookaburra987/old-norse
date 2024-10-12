package me.kookaburra987.oldnorse.utils;

import me.kookaburra987.oldnorse.Case;
import me.kookaburra987.oldnorse.Gender;
import me.kookaburra987.oldnorse.Number;
import me.kookaburra987.oldnorse.word.noun.Noun;
import me.kookaburra987.oldnorse.word.noun.NounIrregularity;

import static me.kookaburra987.oldnorse.Gender.*;
import static me.kookaburra987.oldnorse.word.noun.NounIrregularity.isUncommonPlNomAcc;
import static me.kookaburra987.oldnorse.word.noun.NounIrregularity.isUncommonSgGen;

/**
 * Class that maps the case, gender and number of a {@link Noun} to the ending of it.
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

    public static String endingOfStrongNoun(Case c, Gender gender, Number number, NounIrregularity irregularity) {
        if (gender.equals(N)){
            return endingOfStrongNeuterNoun(c, number);
        }
        if (gender.equals(F)){
            return endingOfStrongFeminineNoun(c, number, irregularity);
        }

        return null;
    }

    private static String endingOfStrongFeminineNoun(Case c, Number number, NounIrregularity irregularity) {
        if (number.isMultiple()){
            return endingOfStrongPlFeminineNoun(c, isUncommonPlNomAcc(irregularity));
        } else {
            return endingOfStrongSgFeminineNoun(c, isUncommonSgGen(irregularity));
        }
    }

    private static String endingOfStrongSgFeminineNoun(Case c, boolean uncommonSgGen) {
        if (!Case.GEN.equals(c)){
            return "";
        }
        return uncommonSgGen ? "r" : "ar";
    }

    private static String endingOfStrongPlFeminineNoun(Case c, boolean uncommonPlNomAcc) {
        if (Case.DAT.equals(c)){
            return "um";
        }
        if (Case.GEN.equals(c)){
            return "a";
        }
        return uncommonPlNomAcc ? "r" : "ir";
    }

    private static String endingOfStrongNeuterNoun(Case c, Number number) {
        if (number.isMultiple()){
            return endingOfStrongPlNeuterNoun(c);
        } else {
            return endingOfStrongSgNeuterNoun(c);
        }
    }

    private static String endingOfStrongSgNeuterNoun(Case c) {
        return switch (c) {
            case DAT -> "i";
            case GEN -> "s";
            default -> "";
        };
    }

    private static String endingOfStrongPlNeuterNoun(Case c) {
        return switch (c){
            case DAT -> "um";
            case GEN -> "a";
            default -> "";
        };
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
