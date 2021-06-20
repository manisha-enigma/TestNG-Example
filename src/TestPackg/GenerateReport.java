package TestPackg;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.common.excelreport.ExcelReportGenerator;

public class GenerateReport {

	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

		ExcelReportGenerator.generateExcelReport("ExcelReport.xlsx", "C:\\Eclipse_Workspace\\TestNG_Example\\");

	}

}
