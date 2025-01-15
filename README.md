# Conversor de Moedas

## Descrição do Projeto
Este é um programa em Java que realiza a conversão de moedas com base em taxas de câmbio obtidas em tempo real através de uma API de taxas de câmbio. A interação com o usuário ocorre por meio de uma interface textual no console, onde é possível selecionar uma entre seis opções de conversão disponíveis.

O programa utiliza:
- **HttpClient**, **HttpRequest** e **HttpResponse** para realizar solicitações à API.
- A biblioteca **GSON** para processar e filtrar os dados da resposta JSON da API.
- A classe **Scanner** para capturar as entradas do usuário via console.

## Funcionalidades
- Oferece 6 opções de conversão de moedas:
  1. Peso argentino (ARS) para Real (BRL).
  2. Boliviano (BOB) para Real (BRL).
  3. Real (BRL) para Dólar americano (USD).
  4. Peso chileno (CLP) para Real (BRL).
  5. Peso colombiano (COP) para Real (BRL).
  6. Dólar americano (USD) para Real (BRL).
- Permite a entrada do valor a ser convertido.
- Exibe o resultado da conversão diretamente no console.

## Tecnologias Utilizadas
- Linguagem: **Java**
- Biblioteca: **GSON**
- API de taxas de câmbio: **ExchangeRate API**
- Ferramentas padrão da biblioteca Java: `HttpClient`, `HttpRequest`, `HttpResponse`, `Scanner`

## Como Usar
1. Clone o repositório ou copie o código para sua IDE de preferência.
2. Certifique-se de ter o **JDK 11** ou superior instalado.
3. Adicione a biblioteca **GSON** ao projeto:
   - Use um gerenciador de dependências (como Maven ou Gradle) ou baixe o arquivo JAR do GSON e inclua no classpath do projeto.
4. Substitua `YOUR_API_KEY_HERE` pela sua chave da API ExchangeRate.
5. Compile e execute o programa.

## Exemplo de Uso
1. O programa apresentará o seguinte menu:
   ```
   Bem-vindo ao Conversor de Moedas!
   Escolha uma das opções abaixo para conversão:
   1-Peso argentino para Real
   2-Boliviano para Real
   3-Real para Dólar
   4-Peso chileno para Real
   5-Peso colombiano para Real
   6-Dólar para Real
   ```
2. Digite o número correspondente à opção desejada e pressione **Enter**.
3. Insira o valor a ser convertido e pressione **Enter**.
4. O programa exibirá o valor convertido com base na taxa de câmbio atual.

## Exemplo de Saída
Caso o usuário escolha a opção 6 (Dólar para Real) e insira o valor `100`, o programa poderá exibir:
```
100.00 USD equivale a 486.65 BRL
```

## Estrutura JSON da API
A resposta JSON da API ExchangeRate contém um objeto com as taxas de câmbio, onde as chaves representam os códigos das moedas e os valores representam as taxas de câmbio. Exemplo:
```json
{
  "rates": {
    "USD": 1.0,
    "BRL": 4.8665,
    "ARS": 0.0102,
    "BOB": 0.1448,
    "CLP": 0.0012,
    "COP": 0.00024
  }
}
```

## Melhorias Futuras
- Adicionar mais opções de conversão de moedas.
- Implementar testes automatizados para validar os cálculos e funcionalidades.
- Criar uma interface gráfica (GUI) para melhorar a experiência do usuário.

## Dependências
- **Java 11+**
- **Biblioteca GSON**

## Observação
Certifique-se de que a API ExchangeRate esteja acessível e a chave de acesso seja válida para realizar as conversões. Verifique os limites de requisições impostos pela API para evitar erros durante o uso.

## Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests com melhorias e sugestões.

## Licença
Este projeto é distribuído sob a Licença MIT. Consulte o arquivo `LICENSE` para mais informações.

