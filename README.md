# Demo Drools

### Getting started

Para executar o projeto, será necessário instalar os seguintes programas:

- [JDK 8: Necessário para executar o projeto Java](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html) 
- [Maven 3.6.3: Necessário para realizar o build do projeto Java](http://mirror.nbtelecom.com.br/apache/maven/maven-3/3.6.3/source/apache-maven-3.6.3-src.zip) 
- [Eclipse 2020-03: Para desenvolvimento do projeto](https://www.eclipse.org/downloads/packages/release/2020-03/m3) 
- [Lombok](https://projectlombok.org/downloads/lombok.jar)


### Implementing Rules

Agora que terminamos a configuração, vamos dar uma olhada em algumas opções para criar regras.


### Drools Rule File( .drl )

Simplificando, o arquivo de regras Drools contém todas as regras de negócios.

Uma regra inclui uma construção When-Then , aqui a seção Quando lista a condição a ser verificada e a seção Então lista a ação a ser tomada se a condição for atendida:

```shell
package com.baeldung.drools.rules;
 
import com.baeldung.drools.model.Applicant;
 
global com.baeldung.drools.model.SuggestedRole suggestedRole;
 
dialect  "mvel"
 
rule "Suggest Manager Role"
    when
        Applicant(experienceInYears > 10)
        Applicant(currentSalary > 1000000 && currentSalary <= 
         2500000)
    then
        suggestedRole.setRole("Manager");
end
```


### Tabelas de decisão

Uma tabela de decisão fornece a capacidade de definir regras em uma planilha do Excel pré-formatada. A vantagem dos Drools fornecidos pela Decision Table é que eles são fáceis de entender, mesmo para pessoas não técnicas.

Além disso, é útil quando existem regras semelhantes, mas com valores diferentes, nesse caso, é mais fácil adicionar uma nova linha na planilha do Excel do que escrever uma nova regra. arquivos drl . Vamos ver qual é a estrutura de uma tabela de decisão com um exemplo de aplicação do rótulo em um produto com base no tipo de produto:

A Tabela de Decisão está agrupada em seções diferentes; a primeira é como uma seção de cabeçalho, onde especificamos o RuleSet (ou seja, pacote onde os arquivos de regras estão localizados), Import (classes Java a serem importadas) e Notes (comentários sobre o objetivo das regras).

A seção central em que definimos regras é chamada RuleTable, que agrupa as regras que são aplicadas ao mesmo objeto de domínio.

Na próxima linha, temos os tipos de coluna CONDITION e ACTION . Dentro dessas colunas, podemos acessar as propriedades do objeto de domínio mencionado em uma linha e seus valores nas linhas subseqüentes.




### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/htmlsingle/#using-boot-devtools)
* [Introdução ao Drools](https://www.baeldung.com/drools)









