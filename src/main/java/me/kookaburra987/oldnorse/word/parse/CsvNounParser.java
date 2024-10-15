package me.kookaburra987.oldnorse.word.parse;

import me.kookaburra987.oldnorse.DeclensionType;
import me.kookaburra987.oldnorse.Gender;
import me.kookaburra987.oldnorse.word.noun.Noun;

import java.util.ArrayList;
import java.util.List;

import static me.kookaburra987.oldnorse.utils.Assert.*;
import static org.apache.commons.lang3.EnumUtils.getEnumIgnoreCase;

public class CsvNounParser implements WordParser<Noun> {

    @Override
    public List<Noun> parse(String[] lines) {
        notEmpty(lines, "lines is empty");

        List<Noun> nouns = new ArrayList<>();
        for (String line : lines) {
            if (! line.startsWith("//")){
                Noun noun = parse(line);
                nouns.add(noun);
            }
        }
        return nouns;
    }

    @Override
    public Noun parse(String line) {
        notBlank(line, "line is blank");
        String[] split = line.split(",");
        if (split.length < 3){
            throw new IllegalArgumentException("line has invalid amount of elements");
        }

        //latin notation
        String latinNotation = split[0].trim();
        notBlank(latinNotation, "latinNotation is blank");

        //gender
        Gender gender = getEnumIgnoreCase(Gender.class, split[1].trim());
        notNull(gender, "gender is invalid");

        //weak or strong
        DeclensionType declensionType = getEnumIgnoreCase(DeclensionType.class, split[2].trim());
        notNull(declensionType, "declensionType is invalid");

        return new Noun(latinNotation, gender, declensionType);
    }
}
