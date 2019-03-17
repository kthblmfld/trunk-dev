package com.sandbox.databaseservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import com.lightstep.tracer.jre.JRETracer;
import io.opentracing.Tracer;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;

@Configuration
public class TracerConfiguration {

    private static final String COMPONENT_NAME = "api-service";
    private static final int VERBOSITY_MAX = 4;

    @Value("${lightstep.api.token}")
    private String apiToken;

    @Bean
    Tracer tracer() throws MalformedURLException {

        return new JRETracer(
                new com.lightstep.tracer.shared.Options.OptionsBuilder()
                        .withAccessToken(apiToken)
                        .withComponentName(COMPONENT_NAME)
                        .withVerbosity(VERBOSITY_MAX)
                        .withCollectorProtocol("https")
                        .withCollectorHost("collector-grpc.lightstep.com")
                        .withCollectorPort(443)
                        .build()
        );
    }
}