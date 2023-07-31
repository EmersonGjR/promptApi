Chat GPT API
Este é um projeto de API desenvolvido em Spring Boot para gerar laudos utilizando o modelo de linguagem GPT (Generative Pre-trained Transformer). A aplicação possui dois endpoints: /home e /laudos, que podem ser acessados no navegador.

Configuração do Banco de Dados
Para executar a aplicação, é necessário configurar o banco de dados no arquivo application.properties. Certifique-se de fornecer as informações corretas de conexão ao banco de dados.

Exemplo de configuração no arquivo application.properties:

properties
Copy code
# Configurações do Banco de Dados H2 (Exemplo)
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
Substitua essas configurações com as informações do seu banco de dados.

Endpoints
/home
Esse endpoint é acessado no navegador através da URL http://localhost:8080/home. Ele exibe a página inicial da aplicação, onde você pode digitar uma solicitação para gerar um laudo.

/laudos
Esse endpoint é acessado no navegador através da URL http://localhost:8080/laudos. Ele exibe uma página com a lista de laudos salvos no banco de dados. Certifique-se de ter executado o endpoint /home primeiro e ter salvo os laudos gerados para visualizá-los aqui.

Classe ApiController
Essa classe é responsável por definir os endpoints da API e seus respectivos métodos. Ela possui os seguintes endpoints:

POST /api/prompt
Esse endpoint recebe uma solicitação (ResponseDto) contendo informações para gerar um laudo utilizando o modelo GPT. O método getChat do ApiController chama o serviço AppService.textGenerator para gerar o laudo e retorna o resultado como uma resposta com status 200 OK.

POST /api/saveEdited
Esse endpoint recebe um laudo editado (TextDto) para ser salvo no banco de dados. O método saveTxt do ApiController chama o serviço AppService.saveText para salvar o laudo no banco e retorna o resultado como uma resposta com status 200 OK.

Classe ViewController
Essa classe é responsável por definir os endpoints da interface do usuário e seus respectivos métodos. Ela possui os seguintes endpoints:

GET /home
Esse endpoint é acessado no navegador através da URL http://localhost:8080/home. Ele exibe a página inicial da aplicação, onde o usuário pode digitar uma solicitação para gerar um laudo.

GET /laudos
Esse endpoint é acessado no navegador através da URL http://localhost:8080/laudos. Ele exibe uma página com a lista de laudos salvos no banco de dados. Certifique-se de ter executado o endpoint /home primeiro e ter salvo os laudos gerados para visualizá-los aqui.

Observações
Lembre-se de configurar corretamente o banco de dados no arquivo application.properties antes de executar a aplicação. Além disso, é importante ressaltar que os endpoints da API são acessados pelo navegador em /home e /laudos. Certifique-se de seguir as instruções acima para interagir corretamente com a aplicação.
