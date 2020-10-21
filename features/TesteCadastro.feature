#language: pt
Funcionalidade: Preencher Formulario

		
		  Cenario: Preencher Formulario
			  Dado que um usuario acesse a plataforma grocerycrud e acesse a pagina do formulario
	   		Quando preencher todos campos do formulario '<name>','<last_name>','<contact_first_name>','<phone>','<address1>','<address2>'
	   		Entao '<city>','<stage>','<postal_code>','<country>','<from_employeer>','<credit_limit>' e salvar
		    Entao sera exibida a mensagem  'Your data has been successfully stored into the database. Edit Customer or Go back to list'
		    Exemplos: 
	   		|name					|last_name|contact_first_name|phone					|address1							  |address2|city				|stage|postal_code  |country|from_employeer|credit_limit|
		    |Teste Sicredi|Teste		|Cayro Correia     |5199999999    |Av Assis Brasil3970	  |Torre D |Porto Alegre|RS		|  91000000  	|Brasil |Fixter				 |200					|
		  
		    
		    
		 
			Cenario: Deletar Formulario
				Dado que um usuario acesse a plataforma grocerycrud e acesse a pagina do formulario
	   		Quando preencher todos campos do formulario '<name>','<last_name>','<contact_first_name>','<phone>','<address1>','<address2>'
	   		E '<city>','<stage>','<postal_code>','<country>','<from_employeer>','<credit_limit>' e salvar
				E o usuario clicar no link Go back list
				E clicar na coluna Search Name e digitar o '<name>' que foi inserido anteriomente
				E realizar o procedimento de exclusao validado a '<mensagem01>'
				Entao o sistema apresentara a '<mensagem02>' 
				 Exemplos: 
	   		|name					|last_name|contact_first_name|phone					|address1							  |address2|city				|stage|postal_code  |country|from_employeer|credit_limit|mensagem01																				|mensagem02																								|
   		  |Teste Sicredi|Teste		|Cayro Correia     |5199999999    |Av Assis Brasil3970	  |Torre D |Porto Alegre|RS		|  91000000  	|Brasil |Fixter				 |200					|Are you sure that you want to delete this 1 item?|Your data has been successfully deleted from the database|
		  
		   
				
				 