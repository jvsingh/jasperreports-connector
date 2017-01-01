Mule JasperReports Connector
============================

JasperReports is an open source reporting tool that can generate outputs in a variety of formats (Word, PDF, HTML, Excel). 
http://community.jaspersoft.com/project/jasperreports-library

An ESB can be the central information hub of an enterprise - information flows through it most commonly as XML or JSon documents. 
In addition to integrating source and target systems, information often needs to be printed 
or stored in different formats - this is what JasperReports allows us to do. 

With this connector, with some setup, the data from the ESB can be sent to the reports engine and the connector returns a formatted document
that can be printed/emailed or simply presented to end users for download. 
(Also see the demo/app/jasper-flow)

This is quite a useful tool - in your integration flows, wherever you have a requirement to generate well-formatted documents (e.g. to send as email attachments, end-user download, sending electronically via API's in B2B scenarios), the connector can save a lot of coding effort - with the connector, you would simply supply a JasperReports compiled template and the raw data and the connector would return a formatted document in electronic format. JasperReports is a powerful tool with a visual WYSIWYG editor (iReport/JasperSoft studio).
***Note that JasperSoft studio and runtime come with community and enterprise licenses so evaluate which one is suitable for your requirements.***

Installation and Usage
----------------------

This connector is not yet available from the anypoint exchange. To install purely for the purpose of trying it out, checkout the project from github, build and install.



Reporting Issues
----------------

We use GitHub:Issues for tracking issues with this connector. You can report new issues at this link https://github.com/jvsingh/jasperreports-connector/issues

Contribute to JasperReports Connector
----------------------------------

This connector might need some more work before it can be made available for wider consumption
Contributions and collaboration from the community is invited.