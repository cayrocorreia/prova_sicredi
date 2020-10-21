package br.test.automation.steps;

import static br.test.automation.core.DriverFactory.getDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import br.test.automation.pages.TesteCadastroPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;


public class TesteCadastroSteps {
	
	public TesteCadastroPage pg = new TesteCadastroPage();
	@Dado("que um usuario acesse a plataforma grocerycrud e acesse a pagina do formulario")
	public void que_um_usuario_acesse_a_plataforma_grocerycrud_e_acessar_a_pagina_do_formulario() throws Exception {
		pg.acessarSite();
		pg.selecionarThemeV4();
		pg.acessar_add_customer();
	   
	}
	
	@Quando("preencher todos campos do formulario {string},{string},{string},{string},{string},{string}")
	public void preencher_todos_campos_do_formulario(String nome, String last_name, String contact_first, String phone, String address_1 , String address_2) {
		  pg.preencher_formulario_parte_01(nome, last_name, contact_first, phone, address_1, address_2);

	}
	@Quando("{string},{string},{string},{string},{string},{string} e salvar")
	public void string_string_string_string_string_string(String city, String stage, String postal, String country, String credit_lit , String employeer) {
		pg.preencher_formulario_parte_02(city, stage, postal, country, credit_lit, employeer);
		pg.clicar_btn_salvar();

	}
	@Entao("sera exibida a mensagem  {string}")
	public void sera_exibida_a_mensagem(String msg) {
	    pg.validar_mensagem_sucesso_01(msg);
	}
	
	//DESAFIO_2
	@Quando("o usuario clicar no link Go back list")
	public void o_usuario_clicar_no_link_go_back_list() {
		pg.go_back_list();

	}
	
	@Quando("clicar na coluna Search Name e digitar o {string} que foi inserido anteriomente")
	public void clicar_na_coluna_search_name_e_digitar_o_que_foi_inserido_anteriomente(String nome) throws InterruptedException {
		pg.procurar_nome(nome);
		
	}


	@Quando("realizar o procedimento de exclusao validado a {string}")
	public void realizar_o_procedimento_de_exclusao_validado_a(String msg) {
		pg.realizar_exclusao();
	    pg.validar_mensagem_confirmar_exclusao(msg);
	

		
	}

	@Entao("o sistema apresentara a {string}")
	public void o_sistema_apresentara_a(String mensagem) {
		pg.validar_mensagem_sucesso(mensagem);
	}
	

	
	

}
