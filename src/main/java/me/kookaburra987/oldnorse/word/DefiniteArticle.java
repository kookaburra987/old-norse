package me.kookaburra987.oldnorse.word;

import me.kookaburra987.oldnorse.Case;
import me.kookaburra987.oldnorse.Gender;
import me.kookaburra987.oldnorse.Number;

import static me.kookaburra987.oldnorse.Case.*;
import static me.kookaburra987.oldnorse.Gender.*;
import static me.kookaburra987.oldnorse.Number.PL;
import static me.kookaburra987.oldnorse.utils.Assert.notNull;

/**
 * Old norse has one definite article: inn,
 * which declines for case, number and gender.
 */
public final class DefiniteArticle extends Word {

    public static final String MSG_CASE_NULL = "case is null";

    private static DefiniteArticle instance;

    private DefiniteArticle() {
        super("inn");
    }

    public static DefiniteArticle getInstance(){
        if (instance == null){
            instance = new DefiniteArticle();
        }
        return instance;
    }

    /**
     * Returns the declined definite article.
     * @param number of the related noun
     * @param gender of the related noun
     * @return declined definite article
     */
    public String decline(Case c, Number number, Gender gender){
        notNull(c, MSG_CASE_NULL);
        notNull(number, "number is null");
        notNull(gender, "gender is null");

        //It is difficult so find logic in declining the definite article. The plural seems most consistent.
        if (number.equals(PL)){
            return declinePlural(c, gender);
        }
        if (gender.equals(M)){
            return declineMasculineSingular(c);
        }
        if (gender.equals(N)){
            return declineNeuterSingular(c);
        }
        return declineFeminineSingular(c);
    }

    /**
     * Declines feminine singular of the definite article: inn
     * @param c case of the related noun
     * @return feminine singular declension of inn
     */
    private String declineFeminineSingular(Case c) {
        notNull(c, MSG_CASE_NULL);

        return switch (c) {
            case NOM -> "in";
            case ACC -> "ina";
            case DAT -> "inni";
            case GEN -> "innar";
        };
    }

    /**
     * Declines neuter singular of the definite article: inn
     * @param c case of the related noun
     * @return neuter singular declension of inn
     */
    private String declineNeuterSingular(Case c) {
        notNull(c, MSG_CASE_NULL);

        if (c.equals(DAT)){
            return "inu";
        }
        if (c.equals(GEN)){
            return "ins";
        }
        return "it";
    }

    /**
     * Declines masculine singular of the definite article: inn
     * @param c case of the related noun
     * @return masculine singular declension of inn
     */
    private String declineMasculineSingular(Case c) {
        notNull(c, MSG_CASE_NULL);

        if (c.equals(DAT)){
            return "inum";
        }
        if (c.equals(GEN)){
            return "ins";
        }
        return "inn";
    }

    /**
     * Declines the plural of definite article: inn
     * @param c case of the related noun
     * @param gender gender of the related noun
     * @return plural declension of inn
     */
    private String declinePlural(Case c, Gender gender) {
        notNull(c, MSG_CASE_NULL);
        notNull(gender, "gender is null");

        if (c.equals(DAT)){
            return "inum";
        }
        if (c.equals(GEN)){
            return "inna";
        }
        if (gender.equals(F)){
            return "inar";
        }
        if (gender.equals(N)){
            return "in";
        }
        if (c.equals(NOM)){
            return "inir";
        }
        return "ina";
    }
}
