package me.kookaburra987.oldnorse.concat;

import me.kookaburra987.oldnorse.Case;
import me.kookaburra987.oldnorse.Number;
import me.kookaburra987.oldnorse.word.Noun;
import me.kookaburra987.oldnorse.word.Preposition;

import static java.util.Objects.requireNonNullElse;
import static me.kookaburra987.oldnorse.Number.SG;
import static me.kookaburra987.oldnorse.utils.Assert.notNull;

/**
 * Concatenates a {@link Preposition} with a {@link Noun}.
 * It declines the noun so that it matches with the case of the Preposition.
 */
public class PrepositionNounConcatenationMaker implements OldNorseConcatenationMaker<Preposition, Noun> {

    private Number number;

    /**
     * Constructor of the concatenation.
     * @param number of the noun in the concatenation (default is SG)
     */
    public PrepositionNounConcatenationMaker(Number number) {
        this.number = requireNonNullElse(number, SG);
    }

    @Override
    public String concat(Preposition preposition, Noun noun) {
        notNull(preposition, "preposition is null");
        notNull(noun, "noun is null");

        Case theCase = preposition.getCase();
        String declinedNoun = noun.decline(theCase, number);

        return String.format("%s %s", preposition.getLatinNotation(), declinedNoun);
    }
}
