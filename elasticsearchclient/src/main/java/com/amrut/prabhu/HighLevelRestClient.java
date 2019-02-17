package com.amrut.prabhu;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthRequest;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class HighLevelRestClient {

    static Logger logger = LoggerFactory.getLogger(HighLevelRestClient.class);

    public static void main(String[] args) throws IOException {

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http"),
                        new HttpHost("localhost", 9300, "http")));


        ClusterHealthRequest healthRequest = new ClusterHealthRequest();

        ClusterHealthResponse health = client.cluster().health(healthRequest, RequestOptions.DEFAULT);
        logger.info("Health Status: " + Integer.toString(health.status().getStatus()));
        logger.info("Cluster name: " + health.getClusterName());
        client.close();


    }
}
