package com.revolut.resources;

import com.codahale.metrics.annotation.Timed;
import com.revolut.common.data.model.Transaction;
import com.revolut.common.manager.TransactionManager;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("/api/transaction")
@Produces(MediaType.APPLICATION_JSON)
public class TransactionResource {

    @POST
    @Timed
    public Transaction execute(Transaction transaction) {
        return TransactionManager.getInstance().execute(transaction);
    }
}
