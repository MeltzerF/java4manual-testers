package slobevg.etl.extract;

import slobevg.etl.data.User;

public interface Extractor {

    User[] extract();
}
