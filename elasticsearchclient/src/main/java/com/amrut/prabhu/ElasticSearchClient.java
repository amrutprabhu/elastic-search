package com.amrut.prabhu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ElasticSearchClient {

    private static Logger logger = LoggerFactory.getLogger(ElasticSearchClient.class);

    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:9200/_cat/health", String.class);

        if (response.getStatusCode().value() == 200) {
            logger.info("Health Status: " + response.getBody());
        }


    }

}