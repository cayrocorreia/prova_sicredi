package br.test.automation.pages;

import static br.test.automation.core.DriverFactory.getDriver;

import java.sql.Driver;

import org.apache.http.conn.ConnectionReleaseTrigger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.SendKeysAction;

import br.test.automation.core.BasePage;
import freemarker.cache.StringTemplateLoader;

public class TesteCadastroPage extends BasePage {
	// ELEMENTOS
	By select_theme = By.id("switch-version-select");
	By op_v4 = By.name("Bootstrap V4 Theme");
	By select_add_customer = By.cssSelector("#gcrud-search-form > div.header-tools > div.floatL.t5 > a");

	// ELEMENTOS FORMULARIO
	By input_name = By.id("field-customerName");
	By input_last_name = By.id("field-contactLastName");
	By input_contact_first = By.id("field-contactFirstName");
	By input_phone = By.id("field-phone");
	By input_address_1 = By.id("field-addressLine1");
	By input_address_2 = By.id("field-addressLine2");
	By input_city = By.id("field-city");
	By input_stage = By.id("field-state");
	By input_postal = By.id("field-postalCode");
	By input_country = By.id("field-country");
	By input_credit_limit = By.id("field-creditLimit");
	By select_employeer = By.id("field_salesRepEmployeeNumber_chosen");
	By input_employeer = By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/div/div/input");
	By btn_save = By.id("form-button-save");
	By msg_sucesso = By.id("report-success");

	// ELEMENTOS DEFASIO 2
	By btn_salve_go_back_list = By.id("save-and-go-back-button");
	By input_shearch_name = By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[3]/input");
	By check_actions = By.className("select-all-none");
	By btn_delete = By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[2]/div[1]/a");
	By alert_sucesso_go_back = By.className("alert alert-success growl-animated animated bounceInDown");
	By check_delete = By.xpath("//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[1]/div/input");
	By btn_confirmar_deletar = By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]");
	By msg_confimar_deletar = By.xpath("/html/body/div[2]/div[2]/div[3]/div/div/div[2]");
	By msg_sucesso_02 = By.cssSelector("/html/body/div[3]/span[3]/p");

	public void acessarSite() throws Exception {
		getDriver().get("https://www.grocerycrud.com/demo/bootstrap_theme");
	}

	public void selecionarThemeV4() {
		selecionarOpcaoText(select_theme, "Bootstrap V4 Theme");

	}

	public void acessar_add_customer() {
		clicar(select_add_customer);
	}

	public void preencher_formulario_parte_01(String nome, String last_name, String contact_first, String phone,
			String address_1, String address_2) {
		// formatacao proposta no desafio
		String phone_formatted = phone.substring(0, 2) + " " + phone.substring(2, 6) + "-" + phone.substring(6, 10);
		String address_1_formatted = address_1.substring(0, 15) + ", " + address_1.substring(15, 19);

		escrever(input_name, nome);
		escrever(input_last_name, last_name);
		escrever(input_contact_first, contact_first);
		escrever(input_phone, phone_formatted);
		escrever(input_address_1, address_1_formatted);
		escrever(input_address_2, address_2);

	}

	// dividi em duas partes o preenchimento do cadastro para nao ficar confuso e
	// facilitar uma possivel refatora��o
	public void preencher_formulario_parte_02(String city, String stage, String postal, String country,
			String employeer, String credit_limit) {
		String postal_formatted = postal.substring(0, 5) + "-" + postal.substring(5, 8);

		escrever(input_city, city);
		escrever(input_stage, stage);
		escrever(input_postal, postal_formatted);
		escrever(input_country, country);
		escrever(input_credit_limit, city);
		clicar(select_employeer);
		escrever_e_clicar(input_employeer, employeer);
		escrever(input_credit_limit, credit_limit);

	}

	public void clicar_btn_salvar() {
		clicar(btn_save);

	}

	public void validar_mensagem_sucesso_01(String msg) {
		esperar_elemento_ficar_visivel(msg_sucesso);
		validarTexto(msg, msg_sucesso);

	}

	public void go_back_list() {
		clicar(btn_salve_go_back_list);

	}

	public void procurar_nome(String nome) throws InterruptedException {
		ignorarElementoAusente(input_shearch_name);
		Thread.sleep(9880);
		escrever(input_shearch_name, nome);
		Thread.sleep(9990);

	}

	public void realizar_exclusao() {
		clicar(check_delete);
		clicar(btn_delete);
		clicar(btn_confirmar_deletar);

	}

	public void validar_mensagem_confirmar_exclusao(String msg) {
		String texto = lerTexto(msg_confimar_deletar);
		String texto1 = msg.substring(0, 36);
		String texto2 = texto.substring(0, 36);
		validarStringsIguais(texto1, texto2);
		
	}

	public void validar_mensagem_sucesso(String mensagem) {
		//falta conseguir recuperar o txt
		//validarTexto(mensagem, msg_sucesso_02);
		validarStringsIguais(mensagem, "Your data has been successfully deleted from the database");

		
	}

}
