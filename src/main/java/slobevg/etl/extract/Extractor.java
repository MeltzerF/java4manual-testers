package slobevg.etl.extract;

import slobevg.etl.data.User;
import slobevg.etl.exceptions.ExtractorException;

import java.util.Collection;

public interface Extractor {

    Collection<User> extract() throws ExtractorException;
}
