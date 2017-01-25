package slobevg.etl;


import slobevg.etl.data.User;
import slobevg.etl.exceptions.EtlException;
import slobevg.etl.exceptions.ExtractorException;
import slobevg.etl.exceptions.LoaderException;
import slobevg.etl.extract.Extractor;
import slobevg.etl.load.Loader;

public class Controller {
    private Extractor extractor;
    private Loader[] loaders;

    public Controller(Extractor extractor, Loader[] loaders) {
        this.extractor = extractor;
        this.loaders = loaders;
    }

    public Extractor getExtractor() {
        return extractor;
    }

    public void setExtractor(Extractor extractor) {
        this.extractor = extractor;
    }

    public Loader[] getLoaders() {
        return loaders;
    }

    public void setLoaders(Loader[] loaders) {
        this.loaders = loaders;
    }

    public void doEtl() throws EtlException {
        try {
            User[] extractedUserArray = extractor.extract();
            final User[] extractedUsers = extractor.extract();
                        for (Loader loader : loaders) {
                                loader.load(extractedUserArray);
                            }
        } catch (ExtractorException | LoaderException e) {
            throw new EtlException("Etl exception", e);
        }
    }
}
