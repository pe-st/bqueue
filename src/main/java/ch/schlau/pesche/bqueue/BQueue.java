package ch.schlau.pesche.bqueue;

import javax.ws.rs.PathParam;

public interface BQueue {

    String put(@PathParam("id") String id, String request);
}
