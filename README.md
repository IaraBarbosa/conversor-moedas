# Conversor de Moedas :heavy_dollar_sign:
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

O projeto é um Challenge da *Formação Java e Orientação a Objetos - One [Alura]*.

O Conversor de Moedas permite a conversão de moedas utilizando a [ExchangeRate-API](https://www.exchangerate-api.com/).

## Funcionalidades

- Conversão entre diferentes pares de moedas pré-definidos.
- Interface de menu interativo no terminal.
- Validação de entrada do usuário.
- Consumo de API externa para obter taxas de câmbio em tempo real.

## Execução

1. **Pré-requisitos:**
   - Java 17+
   - Maven

## Estrutura do Projeto

`Main.java`: Classe principal.

`Menu.java`: Interface de menu e lógica de interação.

`ExchangeRateAPIClient.java`: Cliente HTTP para a ExchangeRate-API.

`MoedaExchangeRateAPI.java`: Record para resposta da API.

`InternalJsonParser.java`: Conversão de JSON para objeto Java.

## Observações

- O projeto utiliza uma chave gratuita da ExchangeRate-API. Recomenda-se utilizar sua própria chave.

- O menu permite apenas conversões entre pares de moedas pré-definidos.
