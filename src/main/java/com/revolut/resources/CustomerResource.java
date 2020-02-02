package com.revolut.resources;

import com.revolut.common.data.model.Account;
import com.revolut.common.data.model.Customer;
import com.revolut.common.manager.CustomerManager;

import com.codahale.metrics.annotation.Timed;

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

@Path("/api/customer")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @GET
    @Path("{email}")
    @Timed
    public Customer get(@PathParam("email") final String email) {
        return CustomerManager.getInstance().get(email);
    }

    @POST
    @Path("{email}/account")
    @Timed
    public Account get(@PathParam("email") final String email, final Account account) {
        return CustomerManager.getInstance().createAccount(email, account.getAccountNickName(), account.getBalance());
    }

    @POST
    @Timed
    public Customer create(final Customer customer) {
        return CustomerManager.getInstance().create(customer.getFirstName(), customer.getLastName(), customer.getEmail());
    }
}
