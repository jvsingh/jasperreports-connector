package org.mule.modules.jasperreports.automation.functional;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mule.modules.jasperreports.JasperReportsConnector;
import org.mule.tools.devkit.ctf.junit.AbstractTestCase;

public class JasperReportsConnectorTestCases extends
		AbstractTestCase<JasperReportsConnector> {

	public JasperReportsConnectorTestCases() {
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
		//assertEquals(getConnector().generateReport(reportId, null), expected);
	}

}