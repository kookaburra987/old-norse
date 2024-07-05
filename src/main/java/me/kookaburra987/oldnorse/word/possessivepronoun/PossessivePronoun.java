package me.kookaburra987.oldnorse.word.possessivepronoun;

import me.kookaburra987.oldnorse.word.Person;
import me.kookaburra987.oldnorse.word.Word;

import java.util.EnumMap;
import java.util.Map;

import static me.kookaburra987.oldnorse.utils.Assert.notNull;

/**
 * Possessive pronouns decline and function like an adjective. They give provide information about an object or person.
 * They tell who possesses it. They decline with the object of possession. They decline with gender, case and number.
 * Their declension (and latin notations) looks a lot like the one for DefiniteArticle.
 */
public class PossessivePronoun extends Word {

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
}
