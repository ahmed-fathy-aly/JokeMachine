package builditbigger;

import com.ahmed.jokemachine.JokeTask;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

/**
 * Created by ahmed on 1/4/2017.
 */
public class JokeTaskTest {

    @Mock
    JokeTask.Callback callback;
    @Captor
    ArgumentCaptor captor;

    JokeTask jokeTask;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        jokeTask = new JokeTask(callback);
    }

    @Test
    public void testJokeTaskResult() {
        jokeTask.execute();

        Mockito.verify(callback, Mockito.timeout(1000)).onResult((String) captor.capture());
        Mockito.verifyNoMoreInteractions(callback);

        String str = (String) captor.getValue();
        Assert.assertTrue(str.length() > 0);
    }

}