package fr.dropwizard.equisign.healthcheck;

import com.codahale.metrics.health.HealthCheck;

public class TransferFileHealthCheck extends HealthCheck {

	@Override
	protected Result check()  {
		return Result.healthy();
	}

}
