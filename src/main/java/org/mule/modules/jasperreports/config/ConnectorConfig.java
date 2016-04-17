package org.mule.modules.jasperreports.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mule.api.ConnectionExceptionCode;
import org.mule.api.annotations.Configurable;
import org.mule.api.annotations.TestConnectivity;
import org.mule.api.annotations.components.Configuration;
import org.mule.api.annotations.display.Path;
import org.mule.api.annotations.display.Placement;
import org.mule.util.StringUtils;

@Configuration(friendlyName = "Configuration")
public class ConnectorConfig {
    private static final Logger logger = LogManager.getLogger(ConnectorConfig.class.getName());

	  /**
     * Concrete path of the location where the *.jasper (Compiled reports) are placed.
     */
    @Configurable
    @Placement(order = 1, group = "Setup")
    @Path
    private String jasperPath;

    /**
     * Unique name of the compiled report template.
     */
    @Configurable
    @Placement(order = 2, group = "Setup")
    private String reportIdentifier;
    
    /**
     * Location where the generated reports are physically placed, if configured. 
     * If not, only the binary output is returned in the flow response.
     */
    @Configurable
    @Placement(order = 3, group = "Setup")
	@Path
    private String outputDirectory;

    /**
     * 
     */
    @Configurable
    @Placement(order = 4, group = "ReportContent")
    private String xmlData;


    @TestConnectivity(label = "Validate Config")
    public void validateConfig() throws org.mule.api.ConnectionException {

        if (StringUtils.isBlank(getJasperPath())) {
            throw new org.mule.api.ConnectionException(ConnectionExceptionCode.INCORRECT_CREDENTIALS, "", "Username attribute must not be null");
        }

        try {
            //TODO ping filesystem
        } catch (Exception ex) {
            logger.error("Target filesystem may not exist or may not be writable.", ex);
            throw ex;
        } 

    }

    public String getJasperPath() {
		return jasperPath;
	}

	public void setJasperPath(String jasperPath) {
		this.jasperPath = jasperPath;
	}

	public String getReportIdentifier() {
		return reportIdentifier;
	}

	public void setReportIdentifier(String reportIdentifier) {
		this.reportIdentifier = reportIdentifier;
	}

	public String getOutputDirectory() {
		return outputDirectory;
	}

	public void setOutputDirectory(String outputDirectory) {
		this.outputDirectory = outputDirectory;
	}

	public String getXmlData() {
		return xmlData;
	}

	public void setXmlData(String xmlData) {
		this.xmlData = xmlData;
	}

	

}