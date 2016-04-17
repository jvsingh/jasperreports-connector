package org.mule.modules.jasperreports;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.modules.jasperreports.config.ConnectorConfig;
import org.w3c.dom.Document;

@Connector(name="jasperreports", friendlyName="JasperReports")
public class JasperReportsConnector {

    @Config
    ConnectorConfig config;

    /**
     * Custom processor
     *
     * @param friend Name to be used to generate a greeting message.
     * @return A greeting message
     */
    @Processor
    public String generateReport(String reportId, Document xmlContent) {
        /*
         * MESSAGE PROCESSOR CODE GOES HERE
         */
        return config.getReportIdentifier() + " " + reportId + ". " + config.getXmlData();
    }

    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }

}