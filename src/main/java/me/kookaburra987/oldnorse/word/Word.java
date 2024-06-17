package me.kookaburra987.oldnorse.word;

import lombok.Getter;

import static me.kookaburra987.oldnorse.utils.Assert.notBlank;
import static me.kookaburra987.oldnorse.utils.Assert.size;

@Getter
public abstract class Word {

    private final String latinNotation;

    protected Word(String latinNotation) {
        notBlank(latinNotation, "latinNotation is blank");
        size(latinNotation, 1, 64, "latinNotation has invalid size");

        this.latinNotation = latinNotation;
    }

}
