# Projeto Java Maven

Este é um projeto Java Maven Spring com alguns endpoints para criação e manipulação de usuários

## Pré-requisitos

Certifique-se de ter o seguinte software instalado em sua máquina:

- Java Development Kit (JDK) - versão 11
- Apache Maven

## Tecnologias Utilizadas

O projeto foi desenvolvido utilizando as seguintes tecnologias:

- **Java**: Linguagem de programação orientada a objetos utilizada como base para o desenvolvimento do projeto.
- **Spring Boot**: Framework para criação de aplicativos Java baseados em Spring, que simplifica o processo de configuração e desenvolvimento.
- **Maven**: Ferramenta de automação de compilação e gerenciamento de dependências amplamente utilizada para projetos Java.
- **Spring Web**: Módulo do Spring que fornece recursos para criar aplicativos web, como manipulação de requisições HTTP e roteamento.
- **Spring Data**: Módulo do Spring que facilita a integração com bancos de dados, oferecendo recursos para persistência de dados e operações CRUD.
- **Swagger**: Framework para documentação de APIs, que facilita a geração automática de documentação interativa.
- **Lombok**: Biblioteca Java que reduz a verbosidade do código, fornecendo anotações para gerar automaticamente getters, setters, construtores e outros métodos comuns.

## Configuração do Ambiente

Siga as etapas abaixo para configurar o ambiente de desenvolvimento:

1. Clone este repositório para sua máquina local.
Abra o terminal ou prompt de comando e navegue até o diretório onde deseja clonar o projeto. Em seguida, execute o comando:

git clone <URL do repositório>

3. Certifique-se de ter o JDK instalado e configurado corretamente.

Abra o prompt e execute o comando: java -version

5. Certifique-se de ter o Apache Maven instalado e configurado corretamente.

Abra o prompt e execute o comando: mvn -version


Siga as etapas abaixo para configurar as variáveis de ambiente para o Java e o Maven:

- Configurando as Variáveis de Ambiente para o Java:

  - **Windows:**

    ```
    set PATH=%PATH%;C:\caminho\para\o\jdk\bin
    ```

    Substitua `C:\caminho\para\o\jdk` pelo caminho de instalação do JDK no seu sistema.

  - **Linux/Mac:**

    ```
    export PATH=$PATH:/caminho/para/o/jdk/bin
    ```

    Substitua `/caminho/para/o/jdk` pelo caminho de instalação do JDK no seu sistema.

- Configurando as Variáveis de Ambiente para o Maven:

  - **Windows:**

    ```
    set PATH=%PATH%;C:\caminho\para\o\maven\bin
    ```

    Substitua `C:\caminho\para\o\maven` pelo caminho de instalação do Maven no seu sistema.

  - **Linux/Mac:**

    ```
    export PATH=$PATH:/caminho/para/o/maven/bin
    ```

    Substitua `/caminho/para/o/maven` pelo caminho de instalação do Maven no seu sistema.




## Executando o Projeto

Para executar o projeto, siga as etapas abaixo:

1. Abra um terminal ou prompt de comando.
2. Navegue até o diretório raiz do projeto.
3. Execute o seguinte comando para compilar o projeto:

   ```shell
1. mvn clean install
2. mvn spring-boot:run


O servidor será iniciado e estará disponível em http://localhost:8080.
