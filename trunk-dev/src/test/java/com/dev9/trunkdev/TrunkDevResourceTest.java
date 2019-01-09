package com.dev9.trunkdev;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class TrunkDevResourceTest {

    private TrunkDevResource trunkDevResource;

    @Before
    public void setUp() {
        trunkDevResource = new TrunkDevResource();
    }

    @Test
    public void getOrderId() {

        String orderId = "123";
        ResponseEntity<Map> responseEntity = trunkDevResource.getOrderId(orderId);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().get("Legacy")).isEqualTo(orderId);
    }
}