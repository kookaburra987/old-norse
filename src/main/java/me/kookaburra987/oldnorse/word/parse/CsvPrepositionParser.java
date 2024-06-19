package me.kookaburra987.oldnorse.word.parse;

import me.kookaburra987.oldnorse.Case;
import me.kookaburra987.oldnorse.word.Preposition;

import java.util.ArrayList;
import java.util.List;

import static me.kookaburra987.oldnorse.utils.Assert.*;
import static org.apache.commons.lang3.EnumUtils.getEnumIgnoreCase;

public class CsvPrepositionParser implements WordParser<Preposition> {

    @Override
    public List<Preposition> parse(String[] lines) {
        notEmpty(lines, "lines is empty");

        List<Preposition> prepositions = new ArrayList<>();
        for (String line : lines) {
            Preposition preposition = parse(line);
            prepositions.add(preposition);
        }
        return prepositions;
    }

    @Override
    public Preposition parse(String line) {
        notBlank(line, "line is blank");
        String[] split = line.split(",");
        if (split.length < 2){
            throw new IllegalArgumentException("line has invalid amount of elements");
        }
        String latinNotation = split[0].trim();
        notBlank(latinNotation, "latinNotation is blank");
        Case theCase = getEnumIgnoreCase(Case.class, split[1].trim());
        notNull(theCase, "case is invalid");
        return new Preposition(latinNotation, theCase);
    }
}
