# contact-list

Pré requisito:

Java8
Maven

Após baixar o projeto , basta entrar pelo terminal na pasta raiz, e executar mvn spring-boot:run

O aplicativo será executado na porta 8080

Segue abaixo os comandos http que foram utilizados no software POSTMAN, para os comandos de PUT e POST é necessário ir em BODY > RAW e mudar o tipo para JSON, e adicionar 
os dados a serem enviados.

verbo: POST 
Insere uma pessoa e 2 contatos relacionados a ela
Obs.: Crie pelo menos 2 pessoas, e no momento da exclusão, ter mais registros para testes
url: http://localhost:8080/person
{
    "name": "Geber",
    "nickName": "Bim",
    "contacts": [
        {
            "title": "Personal",
	        "phone": "99-99999-9999",
	        "email": "geber.home@gmail.com",
	        "whatsApp": "99-99999-9999"
        },{
            "title": "Work",
             "phone": "91-99999-9999",
	        "email": "geber.worker@gmail.com",
	        "whatsApp": "91-99999-9999"
        }
    ]
}
    
verbo: GET 
consulta todas as pessoas
url: http://localhost:8080/person

PUT
Edita pessoa de id 1, edita contato de id 1
url: http://localhost:8080/person/1
{
    "name" : "Geber Cabral",
    "contacts": [
     {
                "id": 1,
                "title": "Personal test",
                "phone": "88-8888-88888",
                "email": "geber.home-test@gmail.com",
                "whatsApp": "88-8888-88888"
            }
    ]
}

verbo GET
Consulta pessoa de id 1
url: http://localhost:8080/person/1

verbo DELETE
exclui pessoa de id 2 
url: http://localhost:8080/person/2

Verbo POST
Insere contato e vincula a pessoa de id 1
url: localhost:8080/contact

{
    "title": "Test contact",
    "phone": "11-11111-1111",
    "email": "test@teste.com",
    "whatsApp": "22-22222-2222",
    "person" : {
        "id": 1
    }
}
Verbo GET
Consulta todos os contatos
url: http://localhost:8080/contact

Verbo GET
Consulta contato de id 1
url: localhost:8080/contact/1

Verbo PUT
Edita contato de id 3
url: localhost:8080/contact/3
{
    "title": "Personal test edited"
}

verbo DELETE
Exclui contato de id 3 caso exista
url: http://localhost:8080/contact/3


