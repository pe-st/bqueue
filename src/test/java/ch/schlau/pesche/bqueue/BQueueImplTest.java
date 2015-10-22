package ch.schlau.pesche.bqueue;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import javax.ws.rs.WebApplicationException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BQueueImplTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void put_short_throw() throws Exception {

        expectedException.expect(WebApplicationException.class);

        BQueue bQueue = new BQueueImpl();
        bQueue.put("1", "a");
    }

    @Test
    public void put_normal_string() throws Exception {

        BQueue bQueue = new BQueueImpl();

        String s = bQueue.put("2", "ab");
        assertThat(s, containsString("2"));
        assertThat(s, containsString("ab"));
    }
}
