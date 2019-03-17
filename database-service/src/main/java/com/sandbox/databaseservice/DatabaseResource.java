package com.sandbox.databaseservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RestController
public class DatabaseResource {

    private static final Logger LOG = LoggerFactory.getLogger(DatabaseResource.class);

    @PostMapping("/datamodel/{operation}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity performCrudOperation(@PathVariable("operation") Integer operation) {

        String responseMessage = "operation: ";
        int sleepMillis = 2000;

        ResponseEntity responseEntity = null;

        switch(operation) {
            case 1:
                try {
                    Thread.sleep(sleepMillis);
                    responseEntity = ResponseEntity.ok().body(responseMessage + operation);
                } catch (InterruptedException e) {
                    LOG.error(e.getMessage());
                }
                break;
            case 2:
                responseEntity = ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(responseMessage + operation);
                break;
            default:
                responseEntity = ResponseEntity.ok().body(responseMessage + operation);
        }

        return responseEntity;
    }
}