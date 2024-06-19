package me.kookaburra987.oldnorse.word;

import me.kookaburra987.oldnorse.Case;

import static me.kookaburra987.oldnorse.utils.Assert.notNull;

public final class Preposition extends Word {

    private final Case c;

    public Preposition(String latinNotation, Case c) {
        super(latinNotation);
        notNull(c, "case is null");
        this.c = c;
    }

    public Case getCase(){
        return c;
    }

}
