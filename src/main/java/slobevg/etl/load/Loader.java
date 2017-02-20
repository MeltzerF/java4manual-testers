package slobevg.etl.load;

import slobevg.etl.data.User;
import slobevg.etl.exceptions.LoaderException;

import java.util.Collection;

public interface Loader {
    void load(Collection<User> userArray) throws LoaderException;
}
