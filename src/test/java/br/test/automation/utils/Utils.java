package br.test.automation.utils;

import static br.test.automation.core.DriverFactory.getDriver;
import static br.test.automation.core.DriverFactory.killDriver;

import java.io.IOException;
import java.util.Date;
import java.io.File;
import java.text.SimpleDateFormat;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;




public class Utils {
	
	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extentReport;
	private static ExtentTest extentTest;

	public static String timestamp() {
		return new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date());
	}

	public static void takeScreenShot(Scenario scenario) {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			if (!scenario.isFailed()) {
				FileUtils.copyFile(srcFile,
						(new File("./screenshots/passed/", scenario.getName() + " - " + timestamp() + ".png")));
			} else {
				FileUtils.copyFile(srcFile,
						(new File("./screenshots/failed", scenario.getName() + " - " + timestamp() + ".png")));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void afterScenario(Scenario scenario) {
		if (!scenario.isFailed()) {
			extentTest.log(Status.PASS, "Cenário " + scenario.getName() + " executado com sucesso!");
		} else {
			extentTest.log(Status.FAIL, "Cenário " + scenario.getName() + " executado com falha!");
		}
		extentReport.flush();
	}

	@Before
	public static void takeReport(Scenario scenario) {
		if (extentReport == null) {
			criarDiretorioMacro();
			extentReport = new ExtentReports();
			htmlReporter = new ExtentHtmlReporter("./report/htmlReporter.html");
			extentReport.attachReporter(htmlReporter);
		}
		extentTest = extentReport.createTest(scenario.getId());
	}
	
	public static void criarDiretorioMacro() {
        try {
            File diretorio = new File("./report");
            diretorio.mkdir();
            System.out.println("Diretorio report criado com sucesso");
        } catch (Exception ex) {
        	System.out.println("Erro ao criar o diretorio report");
            System.out.println(ex);
        }
    }

	@After
	public static void tearDown(Scenario scenario) {
		takeScreenShot(scenario);
		afterScenario(scenario);
		killDriver();
	}

}
