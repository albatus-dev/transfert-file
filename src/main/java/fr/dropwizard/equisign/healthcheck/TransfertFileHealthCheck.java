package fr.dropwizard.equisign.healthcheck;

import com.codahale.metrics.health.HealthCheck;

public class TransfertFileHealthCheck extends HealthCheck {

	@Override
	protected Result check() throws Exception {
		return Result.healthy();
	}

}