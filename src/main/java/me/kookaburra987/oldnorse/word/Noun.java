package me.kookaburra987.oldnorse.word;

import lombok.Getter;
import me.kookaburra987.oldnorse.Case;
import me.kookaburra987.oldnorse.DeclensionType;
import me.kookaburra987.oldnorse.Gender;
import me.kookaburra987.oldnorse.Number;
import me.kookaburra987.oldnorse.utils.NounEndingMapper;

import static me.kookaburra987.oldnorse.DeclensionType.WEAK;
import static me.kookaburra987.oldnorse.utils.Assert.notNull;

/**
 * A noun is a {@link Word} that identifies a person or object.
 * Proper Nouns (names of persons etc.) start with a capital character in latin notation.
 */
@Getter
public final class Noun extends Word{

    private final Gender gender;
    private final DeclensionType declensionType;

    /**
     * Constructor for making a Noun object.
     * @param latinNotation notation in latin characters (not runes)
     * @param gender masculine, feminine or neuter
     * @param declensionType strong or weak
     */
    public Noun(String latinNotation, Gender gender, DeclensionType declensionType){
        super(latinNotation);
        notNull(gender, "gender is null");
        notNull(declensionType, "declensionType is null");

        this.gender = gender;
        this.declensionType = declensionType;
    }

    /**
     * Determines the stem of the Noun.
     * It is the latinNotation without the last character.
     * @return the stem of the word
     */
    public String stem() {
        String latinNotation = getLatinNotation();
        return latinNotation.substring(0, latinNotation.length() - 1);
    }

    public String decline(Case c, Number number){
        notNull(c, "case is null");
        notNull(number, "number is null");

        if (declensionType.equals(WEAK)){
            String ending = NounEndingMapper.endingOfWeakNoun(c, gender, number);
            return stem() + ending;
        }
        return null;
    }
}
