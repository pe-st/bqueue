package ch.schlau.pesche.bqueue;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exercise service
 * <p>
 * Simple call with:
 * curl -H "Content-Type: application/json" -X POST -d "gugus" http://localhost:8080/bqueue/v0/put/42
 */
@Path("/put/{id: [0-9]*}")
@Stateless
public class BQueueImpl implements BQueue {

    private static final Logger logger = LoggerFactory.getLogger(BQueueImpl.class);

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public String put(@PathParam("id") String id, String request) {

        logger.debug("put {} '{}'", id, request);
        if (request.length() < 2) {
            throw new WebApplicationException(Status.BAD_REQUEST);
        }

        return String.format("id %s: %s\n", id, request);
    }

}
