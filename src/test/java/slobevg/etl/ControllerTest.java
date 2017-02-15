package slobevg.etl;

import org.junit.Test;
import slobevg.etl.data.User;
import slobevg.etl.exceptions.EtlException;
import slobevg.etl.exceptions.ExtractorException;
import slobevg.etl.exceptions.LoaderException;
import slobevg.etl.extract.Extractor;
import slobevg.etl.load.Loader;

import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.*;

public class ControllerTest {


    @Test
    public void shouldDoEtlOperationWhenNoExceptions() throws ExtractorException, EtlException, LoaderException {
        //region Given
        final Extractor extractorStub = mock(Extractor.class);
        final User[] usersDummy = {
                new User("1", "user1"),
                new User("1", "user2")
        };

        when(extractorStub.extract()).thenReturn(usersDummy);
        Collection<Loader> loaderList = new ArrayList<Loader>();
        final Loader loaderMock = mock(Loader.class);
        loaderList.add(loaderMock);
        final Controller etlcontroller = new Controller(
                extractorStub,
                loaderList
        );
        //endregion

        //region When
        etlcontroller.doEtl();
        //endregion

        //region Then
        verify(loaderMock, times(1)).load(usersDummy);
        //endregion
    }

    @Test (expected=EtlException.class)
    public void shouldDoEtlOperationWhenExtractorExceptionIsThrown() throws ExtractorException, EtlException, LoaderException {
        //region Given
        final Extractor extractorStub = mock(Extractor.class);
        final User[] usersDummy = {
                new User("1", "user1"),
                new User("1", "user2")
        };
        doThrow(new ExtractorException()).when(extractorStub).extract();
        Collection<Loader> loaderList = new ArrayList<Loader>();
        final Loader loaderMock = mock(Loader.class);
        loaderList.add(loaderMock);
        final Controller etlcontroller = new Controller(
                extractorStub,
                loaderList
        );
        //endregion

        //region When
        etlcontroller.doEtl();
        //endregion
    }



}
