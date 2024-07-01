package me.kookaburra987.oldnorse.word;

import me.kookaburra987.oldnorse.Case;
import me.kookaburra987.oldnorse.Gender;
import me.kookaburra987.oldnorse.Number;
import me.kookaburra987.oldnorse.utils.Assert;

import java.util.Objects;

import static me.kookaburra987.oldnorse.Case.*;
import static me.kookaburra987.oldnorse.Number.*;
import static me.kookaburra987.oldnorse.utils.Assert.isFalse;
import static me.kookaburra987.oldnorse.utils.Assert.notNull;
import static me.kookaburra987.oldnorse.word.Person.*;

/**
 * Personal Pronouns are words that stand in for a noun.
 * Examples from english: I, you, we, he, she, him, his
 */
public final class PersonalPronoun extends Word {

    private static final String MSG_CASE_NULL = "case is null";

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
        isFalse(number.equals(DUAL) && person.equals(THIRD), "dual number not allowed for 3rd person");

        if (number.equals(PL)){
            return determineLatinNotationForPl(person, gender);
        }
        if (number.equals(DUAL)){
            return determineLatinNotationForDual(person);
        }
        return determineLatinNotationForSg(person, gender);
    }

    private static String determineLatinNotationForDual(Person person) {
        notNull(person, "person is null");

        if (person.equals(FIRST)){
            return "vit";
        }
        if (person.equals(SECOND)){
            return "þit";
        }
        return null;
    }

    private static String determineLatinNotationForPl(Person person, Gender gender) {
        if (person.equals(FIRST)){
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
        if (person.equals(FIRST)){
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

    /**
     * Declines the PersonalPronoun.
     * Supports: all nominative declensions, singular 1st and 2n person declensions
     * @param c case
     * @return the declension in latin notation
     * @throws UnsupportedDeclensionException for not supported declensions
     */
    public String decline(Case c) throws UnsupportedDeclensionException {
        notNull(c, MSG_CASE_NULL);
        isFalse(person.equals(THIRD) && number.equals(DUAL), "declension not allowed for 3rd person dual");

        if (c.equals(NOM)){
            return getLatinNotation();
        }
        if (!number.isMultiple()){
            return declineSg(c);
        }
        if (number.equals(DUAL)){
            return declineDual(c);
        }
        throw new UnsupportedDeclensionException("declension only supported for singular");
    }

    private String declineDual(Case c) {
        notNull(c, MSG_CASE_NULL);
        isFalse(person.equals(THIRD), "declension not allowed for 3rd person dual");

        if (c.equals(NOM)){
            return getLatinNotation();
        }

        String start = person.equals(FIRST) ? "okk" : "ykk";
        String ending = c.equals(GEN) ? "ar" : "r";
        return start + ending;
    }

    private String declineSg(Case c) throws UnsupportedDeclensionException {
        notNull(c, MSG_CASE_NULL);

        if (c.equals(NOM)){
            return getLatinNotation();
        }
        if (person.equals(FIRST) || person.equals(SECOND)){
            String start = person.equals(FIRST) ? "m" : "þ";
            String ending = switch (c) {
                case ACC -> "ik";
                case DAT -> "ér";
                case GEN -> "ín";
                default -> "";
            };
            return start + ending;
        }
        throw new UnsupportedDeclensionException("declension not supported for 3rd person singular");
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
