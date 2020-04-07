package libs;

import kong.unirest.Unirest;

public class ResultSender {

    private static final String CONTENT_TYPE = "Content-Type";
    private static final String CONTENT_TYPE_VALUE = "application/json";
    private ElasticSearchDataGenerator elasticSearchDataGenerator = new ElasticSearchDataGenerator();
    private BrowserStackDataGenerator browserStackDataGenerator = new BrowserStackDataGenerator();

    public void sendResultsToElasticSearch(String url, Scenarios scenarios) {
        try {
            Unirest.post(url)
                    .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
                    .body(elasticSearchDataGenerator.generateData(scenarios)).asJson();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendResultsToBrowserStack(String url, String status, String reason, String username, String password) {
        try {
            Unirest.put(url)
                    .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
                    .basicAuth(username, password)
                    .body(browserStackDataGenerator.generateData(status, reason)).asJson();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}