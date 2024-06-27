package me.kookaburra987.oldnorse.word;

import lombok.Getter;

import static me.kookaburra987.oldnorse.utils.Assert.notBlank;
import static me.kookaburra987.oldnorse.utils.Assert.size;

/**
 * A Word is an old icelandic norse (ON) word it its non-declines, non-conjugated form.
 * It is represented by its latin notation (not runes).
 */
@Getter
public abstract class Word {

    private final String latinNotation;

    protected Word(String latinNotation) {
        notBlank(latinNotation, "latinNotation is blank");
        size(latinNotation, 1, 64, "latinNotation has invalid size");

        this.latinNotation = latinNotation.trim();
    }

}
