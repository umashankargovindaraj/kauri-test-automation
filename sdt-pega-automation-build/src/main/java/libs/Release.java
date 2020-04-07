package libs;

import java.util.ArrayList;
import java.util.List;

public class Release {
    private String service;
    private String build;
    private List<String> techComponents;
    private String prodStatus;
    private String unitTesting;
    private String performanceTestAverage;
    private String Testing;
    private String securityTest;
    private String CJMSignOff;
    private String timeStamp;
    private Scenarios scenarios;

    public String getService() {
        return service;
    }

    public String getBuild() {
        return build;
    }

    public List<String> getTechComponents() {
        return techComponents;
    }

    public String getProdStatus() {
        return prodStatus;
    }

    public String getUnitTesting() {
        return unitTesting;
    }

    public String getPerformanceTestAverage() {
        return performanceTestAverage;
    }

    public String getTesting() {
        return Testing;
    }

    public String getSecurityTest() {
        return securityTest;
    }

    public String getCJMSignOff() {
        return CJMSignOff;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public Scenarios getScenarios() {
        return scenarios;
    }

    public void setServiceName(String service) {
        this.service = service;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    public void setTechComponents(String techComponents) {
        this.techComponents = new ArrayList<String>();
        this.techComponents.add(techComponents);
    }


    public void setProdStatus(String prodStatus) {
        this.prodStatus = prodStatus;
    }

    public void setUnitTesting(String unitTesting) {
        this.unitTesting = unitTesting;
    }

    public void setPerformanceTestAverage(String performanceTestAverage) {
        this.performanceTestAverage = performanceTestAverage;
    }

    public void setTesting(String testing) {
        Testing = testing;
    }

    public void setSecurityTest(String securityTest) {
        this.securityTest = securityTest;
    }

    public void setCJMSignOff(String CJMSignOff) {
        this.CJMSignOff = CJMSignOff;
    }

    public void setScenarios(Scenarios scenarios) {
        this.scenarios = scenarios;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}