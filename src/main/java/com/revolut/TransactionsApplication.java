package com.revolut;

import com.revolut.health.BasicHealthCheck;
import com.revolut.resources.CustomerResource;
import com.revolut.resources.HealthResource;
import com.revolut.resources.TransactionResource;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TransactionsApplication extends Application<Configuration> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionsApplication.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    private void addHealthCheck(Environment environment) {
        environment.healthChecks().register("BasicHealthCheck", new BasicHealthCheck());
    }

    private void addResources(Environment environment) {
        environment.jersey().register(new HealthResource());
        environment.jersey().register(new CustomerResource());
        environment.jersey().register(new TransactionResource());
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {

        addHealthCheck(environment);

        addResources(environment);
    }

    public static void main(String[] args) throws Exception {
        new TransactionsApplication().run(args);
    }
}
