package org.mule.modules.jasperreports;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.api.annotations.Processor;
import org.mule.api.annotations.param.Optional;
import org.mule.modules.jasperreports.config.ConnectorConfig;
import org.w3c.dom.Document;

import com.lowagie.text.pdf.codec.Base64;

@Connector(name = "jasperreports", friendlyName = "JasperReports")
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
	public String generateReport(String reportId, Document reportContent,
			ReportType reportType, @Optional Boolean retainFile) {

		try {
			String trackingInfo = "000";
			String reportRootElement = reportId;
			System.out.println("XML Content: " + reportContent);
			if (reportContent != null)
				System.out.println("reportContent: "
						+ reportContent.getFirstChild().getTextContent());

			String tempFileName = config.getOutputDirectory() + "/"
					+ trackingInfo + System.currentTimeMillis()
					+ ("." + reportType).toLowerCase();

			String reportDefinition = config.getJasperPath() + "/" + reportId
					+ ".jasper";

			Map<String, Object> parameters = new HashMap<String, Object>();

			JasperReport jasperReport = (JasperReport) JRLoader
					.loadObject(new File(reportDefinition));

			JRXmlDataSource xmlDS = new JRXmlDataSource(reportContent,
					reportRootElement);

			JasperPrint jasperPrint = JasperFillManager.fillReport(
					jasperReport, parameters, xmlDS);
			

			if (ReportType.HTML == reportType)
				JasperExportManager.exportReportToHtmlFile(jasperPrint,
						tempFileName);
			if (ReportType.PDF == reportType)
				JasperExportManager.exportReportToPdfFile(jasperPrint,
						tempFileName);

			String allReportPages = Base64.encodeFromFile(tempFileName);
			return "<" + reportId + ">" + allReportPages + "</" + reportId
					+ ">";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public ConnectorConfig getConfig() {
		return config;
	}

	public void setConfig(ConnectorConfig config) {
		this.config = config;
	}

	public static void main(String[] args) {

		try {
			JasperReportsConnector connector = new JasperReportsConnector();
			Document reportContent = null;
			connector.generateReport("invoice", reportContent, ReportType.PDF,
					true);

		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}
}