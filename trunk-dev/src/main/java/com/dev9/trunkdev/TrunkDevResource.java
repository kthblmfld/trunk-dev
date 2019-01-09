package com.dev9.trunkdev;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TrunkDevResource {

    @Value("${orders.repository}")
    String repo = "legacyOrdersRepo";

    @GetMapping("/orders/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity getOrderId(@PathVariable("orderId") String orderId) {

        Map<String,String> responseBody = new HashMap<>();
        responseBody.put("Legacy", orderId);
        responseBody.put("Repo", repo);
        return new ResponseEntity<Map>(responseBody, HttpStatus.OK);
    }
}
