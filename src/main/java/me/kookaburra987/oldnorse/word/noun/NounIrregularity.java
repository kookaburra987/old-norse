package me.kookaburra987.oldnorse.word.noun;

/**
 * Information about irregular behavior for (declining) a {@link Noun}.
 */
public class NounIrregularity {
    private final boolean uncommonSgGen;
    private final boolean uncommonPlNomAcc;

    /**
     * @param uncommonSgGen is Sg Gen of the noun uncommon (-ar for masculine, -r for feminine)
     * @param uncommonPlNomAcc is Pl Nom and Acc of the noun uncommon (-r for strong feminine)
     */
    public NounIrregularity(boolean uncommonSgGen, boolean uncommonPlNomAcc) {
        this.uncommonSgGen = uncommonSgGen;
        this.uncommonPlNomAcc = uncommonPlNomAcc;
    }

    public static boolean isUncommonSgGen(NounIrregularity irregularity){
        if (irregularity == null){
            return false;
        }
        return irregularity.isUncommonSgGen();
    }

    public boolean isUncommonSgGen() {
        return uncommonSgGen;
    }

    public static boolean isUncommonPlNomAcc(NounIrregularity irregularity){
        if (irregularity == null){
            return false;
        }
        return irregularity.isUncommonPlNomAcc();
    }

    public boolean isUncommonPlNomAcc() {
        return uncommonPlNomAcc;
    }
}
