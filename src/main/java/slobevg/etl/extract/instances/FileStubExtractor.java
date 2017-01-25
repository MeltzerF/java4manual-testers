package slobevg.etl.extract.instances;

import slobevg.etl.data.User;
import slobevg.etl.extract.Extractor;

public class FileStubExtractor implements Extractor {
    @Override
    public User[] extract() {
        return new User[0];
    }
}
