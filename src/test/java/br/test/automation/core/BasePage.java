package br.test.automation.core;

import static br.test.automation.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
private static WebDriverWait wait;
	
	// Metodo para clicar
	public void clicar(By elemento) {
		wait = new WebDriverWait(getDriver(), 10); //espera por dez sengundos
		wait.until(ExpectedConditions.elementToBeClickable(elemento));
		wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
		getDriver().findElement(elemento).click();
	}

	// Metodo para clicar por texto xpath
	public void clicarPorTextoXpath(String texto) {
		clicar(By.xpath("//*[@text=' + texto + ']"));
	}
	// Metodo para clicar por texto xpath
	public void clicarPorTextoClassName(String texto) {
		clicar(By.className("//*[@text=' + texto + ']"));
	}
	
	// Metodo para clicar por texto css
		public void clicarPorTextoCss(String texto) {
			clicar(By.cssSelector("a[href*=' + texto + ']"));
		}

	// Metodo para escrever
	public void escrever(By elemento, String texto) {
		getDriver().findElement(elemento).sendKeys(texto);
	}
	
	// Metodo para apagar campo texto
	public void apagar(By elemento) {
			getDriver().findElement(elemento).clear();
	}
	
	
	// Metodo para ler texto
	public String lerTexto(By elemento) {
		return getDriver().findElement(elemento).getText().toString();
	}

	// Metodo de comparacao de texto
	public void validarTexto(String textoEsperado, By elemento) {
		Assert.assertEquals(textoEsperado, lerTexto(elemento));
	}
	
	// Metodo de comparacao de elemento
		public void validarElemento(By elemento, String textoEsperado) {
			Assert.assertEquals(elemento, textoEsperado);
		}

	// Ignorar elemento ausente
	public void ignorarElementoAusente(By elemento) {
		if (getDriver().findElements(elemento).size() != 0) {
			clicar(elemento);
			;
		} else {
			System.out.println("Elemento est� ausente");
		}
	}

	// Verifica se elemento est� visivel
	public void verificarElementoVisivel(By elemento) {
		if (getDriver().findElement(elemento).isDisplayed()) {
			System.out.println("Element is Visible");
		} else {
			System.out.println("Element is InVisible");
		}
	}
	

	//Metodo para selecionar um combobox por text
	public void selecionarOpcaoText(By elemento, String opcaoDesejada) {
		Select sl = new Select(getDriver().findElement(elemento));
		sl.selectByVisibleText(opcaoDesejada);
		 
	}
	
	//Metodo para selecionar um combobox por value
	public void selecionarOpcaoValue(By elemento, String value) {
		Select sl = new Select(getDriver().findElement(elemento));
		sl.selectByValue(value);
		
		 
	}
	
	// Metodo para clicar por link
	public void clicar_por_link(String link_text) {
		getDriver().findElement(By.linkText(link_text));
	}
	
	
	// Metodo para escrever e clicar enter
	public void escrever_e_clicar(By elemento, String texto) {
		getDriver().findElement(elemento).sendKeys(texto);
		getDriver().findElement(elemento).sendKeys(Keys.ENTER);
	}
	
	// Metodo para aguardar ate 10s para que o elemento fique visivel
	public void esperar_elemento_ficar_visivel(By elemento) {
		wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));

	}
	
	// Metodo de comparacao de texto
		public void validarStringsIguais(String texto, String textoEsperado) {
			Assert.assertEquals(texto, textoEsperado);
		}
	


	

}
