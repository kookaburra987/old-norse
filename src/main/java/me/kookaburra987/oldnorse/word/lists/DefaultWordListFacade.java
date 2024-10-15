package me.kookaburra987.oldnorse.word.lists;

import me.kookaburra987.oldnorse.utils.ResourceReader;
import me.kookaburra987.oldnorse.word.Preposition;
import me.kookaburra987.oldnorse.word.noun.Noun;
import me.kookaburra987.oldnorse.word.parse.CsvNounParser;
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
    private final WordParser<Noun> nounWordParser = new CsvNounParser();

    @Override
    public List<Preposition> prepositionList() {
        String[] lines = resourceReader.readLinesOfTextFile("words/prepositions.csv");
        return parser.parse(lines);
    }

    @Override
    public List<Noun> nounList() {
        String[] lines = resourceReader.readLinesOfTextFile("words/nouns.csv");
        return nounWordParser.parse(lines);
    }

}
