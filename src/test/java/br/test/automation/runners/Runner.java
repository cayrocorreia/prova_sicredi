package br.test.automation.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		publish = true,
		features = "./features",
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
		glue = {"br.test.automation.steps", "br.test.automation.utils"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false
		)
public class Runner {

}
