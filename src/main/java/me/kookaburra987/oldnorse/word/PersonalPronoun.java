package me.kookaburra987.oldnorse.word;

import me.kookaburra987.oldnorse.Gender;
import me.kookaburra987.oldnorse.Number;

import java.util.Objects;

import static me.kookaburra987.oldnorse.utils.Assert.isFalse;
import static me.kookaburra987.oldnorse.utils.Assert.notNull;
import static me.kookaburra987.oldnorse.word.Person.THIRD;

/**
 * Personal Pronouns are words that stand in for a noun.
 * Examples from english: I, you, we, he, she, him, his
 */
public final class PersonalPronoun extends Word {

    private final Number number;

    private final Person person;

    private Gender gender;

    public PersonalPronoun(Number number, Person person, Gender gender) {
        super(determineLatinNotation(number, person, gender));

        this.number = number;
        this.person = person;
        if (person.equals(THIRD)){
            this.gender = gender;
        }
    }

    private static String determineLatinNotation(Number number, Person person, Gender gender) {
        notNull(number, "number is null");
        notNull(number, "person is null");
        isFalse(person.equals(THIRD) && gender == null, "gender is required when 3rd person is used");

        if (number.equals(Number.SG)){
            return determineLatinNotationForSg(person, gender);
        }
        if (number.equals(Number.PL)){
            return determineLatinNotationForPl(person, gender);
        }
        return null;
    }

    private static String determineLatinNotationForPl(Person person, Gender gender) {
        if (person.equals(Person.FIRST)){
            return "vér";
        }
        if (person.equals(Person.SECOND)){
            return "þér";
        }
        if (person.equals(THIRD)){
            if (gender.equals(Gender.N)){
                return "þau";
            }
            if (gender.equals(Gender.M)){
                return "þeir";
            }
            if (gender.equals(Gender.F)){
                return "þær";
            }
        }
        return null;
    }

    private static String determineLatinNotationForSg(Person person, Gender gender) {
        if (person.equals(Person.FIRST)){
            return "ek";
        }
        if (person.equals(Person.SECOND)){
            return "þú";
        }
        if (person.equals(THIRD)){
            if (gender.equals(Gender.N)){
                return "þat";
            }
            if (gender.equals(Gender.M)){
                return "hann";
            }
            if (gender.equals(Gender.F)){
                return "hon";
            }
        }
        return null;
    }

    public boolean hasNumber(Number number){
        return this.number.equals(number);
    }

    public boolean hasPerson(Person person){
        return this.person.equals(person);
    }

    public boolean hasGender(Gender gender){
        if (gender == null){
            return this.gender == null;
        }
        return this.gender != null && this.gender.equals(gender);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalPronoun that = (PersonalPronoun) o;
        return number == that.number && person == that.person && gender == that.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, person, gender);
    }
}
