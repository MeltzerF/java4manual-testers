package slobevg.etl;

import slobevg.etl.extract.Extractor;
import slobevg.etl.extract.instances.FileStubExtractor;
import slobevg.etl.load.Loader;
import slobevg.etl.load.instances.FileStubLoader;

public class ControllerApp {
    public static void main(String[] args) {
        Controller cont = new Controller(
                new FileStubExtractor(),
                new Loader[] {
                        new FileStubLoader(),
                        new FileStubLoader()
                }

        );
    }
}
