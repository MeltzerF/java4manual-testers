package slobevg.etl.extract;

import slobevg.etl.data.User;
import slobevg.etl.exceptions.ExtractorException;

public interface Extractor {

    User[] extract() throws ExtractorException;
}
