package slobevg.etl;


import slobevg.etl.data.User;
import slobevg.etl.exceptions.EtlException;
import slobevg.etl.exceptions.ExtractorException;
import slobevg.etl.exceptions.LoaderException;
import slobevg.etl.extract.Extractor;
import slobevg.etl.load.Loader;

import java.util.Collection;

public class Controller {
    private Extractor extractor;
    private Collection<Loader> loaders;

    public Controller(Extractor extractor, Collection<Loader> loaders) {
        this.extractor = extractor;
        this.loaders = loaders;
    }

    public Extractor getExtractor() {
        return extractor;
    }

    public void setExtractor(Extractor extractor) {
        this.extractor = extractor;
    }

    public Collection<Loader> getLoaders() {
        return loaders;
    }

    public void setLoaders(Collection<Loader> loaders) {
        this.loaders = loaders;
    }

    public void doEtl() throws EtlException {
        try {
            final Collection<User> extractedUsers = extractor.extract();
                        for (Loader loader : loaders) {
                                loader.load(extractedUsers);
                            }
        } catch (ExtractorException | LoaderException e) {
            throw new EtlException("Etl exception", e);
        }
    }
}
