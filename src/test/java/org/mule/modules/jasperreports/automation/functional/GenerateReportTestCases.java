package org.mule.modules.jasperreports.automation.functional;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.modules.jasperreports.JasperReportsConnector;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class GenerateReportTestCases extends
		AbstractTestCase<JasperReportsConnector> {

	public GenerateReportTestCases() {
		super(JasperReportsConnector.class);
	}

	@Before
	public void setup() {
		// TODO
	}

	@After
	public void tearDown() {
		// TODO
	}

	@Test
	public void verify() {
		java.lang.String expected = null;
		java.lang.String reportId = null;
		org.w3c.dom.Document reportContent = null;
		assertEquals(getConnector().generateReport(reportId, reportContent, JasperReportsConnector.ReportType.PDF, true),
				expected);
	}

}