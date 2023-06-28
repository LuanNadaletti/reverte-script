# ReverteScript

O ReverteScript é um software em Java que permite receber um script SQL completo e realizar as operações reversas de cada consulta. Ele foi projetado para identificar e executar operações de reversão em consultas que não podem ser executadas mais de uma vez devido a restrições de chave primária (PK) e outras restrições.

## Status do Projeto

⚠️ **Atenção: Este projeto está em fase de desenvolvimento e pode não estar totalmente funcional ainda.**

Este projeto tem como objetivo implementar um software em Java para realizar as operações reversas de consultas SQL. No momento, algumas funcionalidades estão em desenvolvimento e podem não estar disponíveis. Atualmente, o projeto suporta a análise de consultas simples, mas consultas complexas ainda estão sendo implementadas.

### Funcionalidades já implementadas:
-   Análise de consultas simples.
-   Reversão de operações básicas.

### Funcionalidades em desenvolvimento:
-   Reversão de consultas complexas.
-   Tratamento de restrições avançadas.

Fique à vontade para explorar o código existente e contribuir com sugestões ou melhorias. Sua colaboração é bem-vinda!

## Funcionalidades

O SQL Reverse Operations oferece as seguintes funcionalidades:

1.  **Reversão de Operações**: O software analisa cada consulta do script SQL fornecido e executa as operações reversas necessárias para desfazer os efeitos da consulta. Isso é particularmente útil quando você precisa reverter alterações feitas em um banco de dados.

2.  **Tratamento de Restrições**: O software lida com restrições de chave primária (PK) e outras restrições que impedem a execução de uma consulta mais de uma vez. Ele identifica as consultas que não podem ser revertidas diretamente e executa as operações apropriadas para garantir que as consultas subsequentes possam ser executadas corretamente.

3.  **Preservação de Integridade**: Durante o processo de reversão das consultas, o software preserva a integridade dos dados no banco. Ele mantém a consistência dos dados e as relações definidas pelas restrições de chave primária e estrangeira.

4.  **Suporte a Diferentes Sistemas de Banco de Dados**: O SQL Reverse Operations é projetado para funcionar com diferentes sistemas de banco de dados compatíveis com SQL. Ele pode lidar com consultas escritas em uma variedade de dialetos SQL, como MySQL, PostgreSQL, Oracle, SQL Server, entre outros.

## Como Usar

Para utilizar o SQL Reverse Operations, siga as etapas abaixo:

1.  **Compilação**: Compile o código-fonte Java do software ou obtenha o arquivo JAR fornecido.

2.  **Execução**: Execute o software fornecendo o script SQL como entrada. Por exemplo:

```lua
java -jar reverte-script.jar script.sql
```

Onde `reverte-script.jar` é o arquivo JAR do software e `script.sql` é o arquivo contendo o script SQL a ser revertido.

3.  **Análise e Reversão**: O software analisará o script SQL e executará as operações de reversão em cada consulta. O resultado será exibido no console ou gravado em um arquivo, dependendo da configuração do software.

4.  **Verificação dos Resultados**: Após a execução, verifique os resultados das operações de reversão. Certifique-se de revisar cuidadosamente as saídas geradas para garantir que as operações foram realizadas corretamente e que a integridade dos dados foi preservada.
