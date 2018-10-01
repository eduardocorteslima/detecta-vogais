# Detecta Vogais

Processa e encontra o primeiro caracter Vogal, após uma consoante, onde a mesma é antecessora a uma vogal e que não se repete no resto da stream. O termino da leitura da stream é garantido através do método hasNext(), ou seja, retorna falso para o término da leitura da stream.


### Pré requisitos

É necessário ter o JRE 8+ e o Maven versão 3.3+ para execução da aplicação.


### Instalando


Faça o download da aplicação pelo git ou zipado.

```
clone https://github.com/eduardocorteslima/detecta-vogais.git
```

Acesse a pasta onde a aplicação foi baixada e execute o seguinte comando.

```
mvn package
```

Após esse comando, execute a aplicação com o comando:

```
java -jar target/detecta-vogais-0.0.1.jar aAbBABacafe
```

O resultado deverá ser igual à:

`
**Processamento iniciado!
 Encontrado: e 
**Processamento concluído!
`
