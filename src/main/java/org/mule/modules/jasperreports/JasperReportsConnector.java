package org.mule.modules.jasperreports;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.param.Optional;
import org.mule.modules.jasperreports.config.ConnectorConfig;
import org.w3c.dom.Document;

@Connector(name="jasperreports", friendlyName="JasperReports")
public class JasperReportsConnector {

    @Config
    ConnectorConfig config;
    
    public enum ReportType {
        HTML, PDF 
    }

    /**
     * Custom processor
     *
     * @param 
     * @return 
     */
    @Processor
    public String generateReport(String reportId, Document reportContent, ReportType reportType, @Optional Boolean retainFile) {
        /*
         * MESSAGE PROCESSOR CODE GOES HERE
         */
    	System.out.println("XML Content: "+ reportContent);
    	if(reportContent != null)
    		System.out.println("reportContent: "+ reportContent.getFirstChild().getTextContent());
        return config.getReportIdentifier() + " " + reportId + ". " + config.getXmlData();
    }

    public ConnectorConfig getConfig() {
        return config;
    }

    public void setConfig(ConnectorConfig config) {
        this.config = config;
    }

}