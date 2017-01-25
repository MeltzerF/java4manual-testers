package slobevg.etl.load;

import slobevg.etl.data.User;
import slobevg.etl.exceptions.LoaderException;

public interface Loader {
    void load(User[] userArray) throws LoaderException;
}
