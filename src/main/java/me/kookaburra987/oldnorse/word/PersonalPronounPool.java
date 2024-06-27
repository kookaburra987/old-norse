package me.kookaburra987.oldnorse.word;

import me.kookaburra987.oldnorse.Gender;
import me.kookaburra987.oldnorse.Number;

import java.util.HashSet;
import java.util.Set;

import static me.kookaburra987.oldnorse.utils.Assert.isFalse;
import static me.kookaburra987.oldnorse.utils.Assert.notNull;
import static me.kookaburra987.oldnorse.word.Person.THIRD;

/**
 * Class that contains a pool of {@link PersonalPronoun} objects.
 * They are in a pool so that they can be reused.
 */
public final class PersonalPronounPool {

    //Set that contains the created personalPronouns so that they can be reused.
    private static final Set<PersonalPronoun> pool = new HashSet<>();

    private PersonalPronounPool() {
    }

    /**
     * Method to fetch the {@link PersonalPronoun} from the pool that matches with the given {@link java.lang.Number},
     * {@link Person} and {@link Gender}.
     * @param number required
     * @param person required
     * @param gender only required if person is THIRD
     * @return the {@link PersonalPronoun} that matches the number, person and gender
     * @throws IllegalArgumentException if number or person is null, or gender is null for THIRD person
     */
    public static PersonalPronoun returnPersonalPronoun(Number number, Person person, Gender gender){
        notNull(number, "number is null");
        notNull(person, "person is null");
        isFalse(person.equals(THIRD) && gender == null, "gender is required when 3rd person is used");
        if (!person.equals(THIRD)){
            gender = null;
        }

        PersonalPronoun foundWord = searchInPool(number, person, gender);
        if (foundWord != null) return foundWord;

        return addPersonalPronounToPool(number, person, gender);
    }

    private static PersonalPronoun addPersonalPronounToPool(Number number, Person person, Gender gender) {
        PersonalPronoun personalPronoun = new PersonalPronoun(number, person, gender);
        pool.add(personalPronoun);
        return personalPronoun;
    }

    private static PersonalPronoun searchInPool(Number number, Person person, Gender gender) {
        for (PersonalPronoun pp : pool) {
            if (pp.hasGender(gender) && pp.hasPerson(person) && pp.hasNumber(number)){
                return pp;
            }
        }
        return null;
    }
}
