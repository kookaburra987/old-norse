package me.kookaburra987.oldnorse.word.possessivepronoun;

import me.kookaburra987.oldnorse.Case;
import me.kookaburra987.oldnorse.Gender;
import me.kookaburra987.oldnorse.Number;
import me.kookaburra987.oldnorse.utils.OldNorseStringUtils;
import me.kookaburra987.oldnorse.word.DefiniteArticle;
import me.kookaburra987.oldnorse.word.Person;
import me.kookaburra987.oldnorse.word.Word;

import java.util.EnumMap;
import java.util.Map;

import static me.kookaburra987.oldnorse.utils.Assert.notNull;
import static me.kookaburra987.oldnorse.utils.OldNorseStringUtils.firstCharStr;
import static me.kookaburra987.oldnorse.utils.OldNorseStringUtils.replaceCharIfNotFollowedByDoubleConsonant;

/**
 * Possessive pronouns decline and function like an adjective. They give provide information about an object or person.
 * They tell who possesses it. They decline with the object of possession. They decline with gender, case and number.
 * Their declension (and latin notations) looks a lot like the one for DefiniteArticle.
 */
public final class PossessivePronoun extends Word {

    private Person person;

    private static Map<Person, PossessivePronoun> instances = new EnumMap<Person, PossessivePronoun>(Person.class);

    private PossessivePronoun(Person person) {
        super(determineLatinNotation(person));
        this.person = person;
    }

    private static String determineLatinNotation(Person person) {
        notNull(person, "person is null");

        return switch (person){
            case FIRST -> "minn";
            case SECOND -> "þinn";
            case THIRD -> "sinn";
        };
    }

    public static PossessivePronoun getInstance(Person person){
        notNull(person, "person is null");

        PossessivePronoun found = instances.get(person);
        if (found != null){
            return found;
        }
        PossessivePronoun possessivePronoun = new PossessivePronoun(person);
        instances.put(person, possessivePronoun);
        return possessivePronoun;
    }

    public String decline(Case c, Number number, Gender gender){
        notNull(c, "cas is null");
        notNull(number, "number is null");
        notNull(gender, "gender is null");

        String declinedDefiniteArticle = DefiniteArticle.getInstance().decline(c, number, gender);
        String firstCharStr = firstCharStr(getLatinNotation());

        String withoutSoundChange = firstCharStr + declinedDefiniteArticle;
        if (OldNorseStringUtils.lastCharOf(withoutSoundChange) == 't'){
            withoutSoundChange = withoutSoundChange + "t";
        }
        return replaceCharIfNotFollowedByDoubleConsonant(withoutSoundChange, 1, 'í');
    }

}
