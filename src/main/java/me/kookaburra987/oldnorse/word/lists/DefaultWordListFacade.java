package me.kookaburra987.oldnorse.word.lists;

import me.kookaburra987.oldnorse.utils.ResourceReader;
import me.kookaburra987.oldnorse.word.Preposition;
import me.kookaburra987.oldnorse.word.parse.CsvPrepositionParser;
import me.kookaburra987.oldnorse.word.parse.WordParser;

import java.util.List;

/**
 * Some words come by default with the old norse library.
 * This is the facade to retrieve them.
 */
public final class DefaultWordListFacade implements WordListFacade {

    private final ResourceReader resourceReader = new ResourceReader();
    private final WordParser<Preposition> parser = new CsvPrepositionParser();

    @Override
    public List<Preposition> prepositionList() {
        String csv = resourceReader.readTextFile("words/prepositions.csv");
        String[] lines = csv.split("\n");
        return parser.parse(lines);
    }

}
