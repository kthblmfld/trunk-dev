package com.dev9.trunkdev;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;


import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;


public class TrunkDevResourceTest {

    private TrunkDevResource trunkDevResource;

    @Before
    public void setUp(){
        trunkDevResource = new TrunkDevResource();
    }

    @Test
    public void getOrderId() {

        String orderId = "123";
        ResponseEntity<Map> responseEntity = trunkDevResource.getOrderId(orderId);
        assertEquals(responseEntity.getStatusCode().value(), HttpStatus.SC_OK);
        assertThat(responseEntity.getBody().get("Legacy")).isEqualTo(orderId);
    }
}