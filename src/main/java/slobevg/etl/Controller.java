package slobevg.etl;


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

    public void doEtl(Extractor extractor, Loader[] loaders) {
        extractor.extract();
        for (Loader loader : loaders) {
            loader.load();
        }
    }
}
