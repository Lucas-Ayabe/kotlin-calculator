# **KTCalculator**
Um projeto de calculadora simples, implementado em Kotlin, que utiliza conceitos de **Orientação a Objetos** (OO) e organização em camadas, inspirado em **Clean Architecture** e **Hexagonal Architecture**. Este exemplo reflete boas práticas como encapsulamento, separação de responsabilidades e expressividade.

## **Sobre o Projeto**
O `KTCalculator` é uma aplicação de console que permite realizar operações matemáticas básicas (`+`, `-`, `*`, `/`) interagindo com o usuário por meio de um formulário dinâmico.
Embora pareça simples, o projeto demonstra o uso de arquiteturas modernas para organização estrutural, mantendo o código **bem encapsulado**, **modular** e **extensível**, o que facilita a manutenção e escalabilidade.
- **Camada de Domínio (`domain`)**: Contém a lógica central da calculadora, incluindo classes que definem operações matemáticas (`Calculator`) e conceitos semânticos como `Expression`.
- **Camada de Interface (`ui`)**: Lida com a interação com o usuário, separando a entrada e saída em contextos claramente definidos.
- **Componentes Reutilizáveis**: A estrutura permite reutilizar partes da lógica do formulário (`Form` e `Report`) para diferentes interfaces de usuário.

## **Funcionalidades**
- Aceita **operações matemáticas básicas**: soma (`+`), subtração (`-`), multiplicação (`*`), divisão (`/`).
- Recebe os inputs do usuário através de **perguntas dinâmicas**.
- Valida os dados inseridos para garantir segurança e consistência.
- Retorna o resultado calculado diretamente no terminal.

## **Conceitos e Decisões de Design**
### **1. Organização em Camadas**
O projeto foi estruturado em pacotes que respeitam o princípio de separação de responsabilidades:
- `domain`:
  Contém a lógica central (ou núcleo da aplicação). Os principais componentes incluem:
    - `Calculator`: Responsável por executar operações matemáticas de maneira genérica, baseada em um mapeamento de operadores.
    - `Expression`: Uma classe que encapsula os operadores e operandos de uma operação.

- `ui`:
  Implementa os adaptadores de interface. É dividida em:
    - **`ui` (abstrações gerais):**
        - `Report`: Representa o estado final de um formulário preenchido, oferecendo uma API fluent baseada no encapsulamento e message chaining para acessar campos em diferentes representações (`asInt()`, `asString()`, etc.).

    - **`ui.console`:**
        - `Form`: Um formulário dinâmico que gera perguntas no terminal e retorna um `Report` após o envio.
        - `Question`: Representa uma única pergunta apresentada ao usuário.

### **2. Encapsulamento e Expressividade**
- Todos os campos de entrada do formulário são encapsulados dentro de um `Report`. Isso garante que o chamador nunca tenha acesso direto aos valores crus dos campos, apenas às suas representações definidas pela API (`field("key").asInt()` ou `field("key").asString()`).
- A API de encadeamento de mensagens (message chaining) promove uma interface intuitiva e fluente.

### **3. Arquitetura Extensível**
- A camada `domain` é independente da interface de usuário (`ui`), permitindo que o adaptador console (`ui.console`) seja substituído facilmente por outro adaptador (uma GUI, por exemplo) sem necessidade de alterar o núcleo da aplicação.

## **Como Executar o Projeto**
### **Pré-requisitos**
- Ter o [Kotlin](https://kotlinlang.org/) configurado no ambiente.
- Um editor compatível, como [IntelliJ IDEA](https://www.jetbrains.com/idea/).

### **Passos**
1. Clone este repositório:
``` bash
   git clone https://github.com/seu-usuario/KTCalculator.git
```
1. Abra o projeto no IntelliJ IDEA ou no editor de sua escolha.
2. Execute o arquivo `Main.kt`, localizado no pacote `com.lucas.ktcalculator`.
3. Interaja com o terminal inserindo as perguntas solicitadas.

## **Exemplo de Uso**
No terminal:
``` plaintext
Enter the first number: 10
Enter the second number: 5
Choose your operation: +, -, *, /: +
Result: 15
```
## **Estrutura do Projeto**
``` plaintext
com.lucas.ktcalculator
│
├── domain
│   ├── Calculator.kt       # Abstrai a interface entre uma Expression e as operações matemáticas configuradas
│   └── Expression.kt       # Encapsula os dados de uma operação
│
├── ui
│   ├── Report.kt           # Representa o estado final de entrada do formulário
│   └── console
│       ├── Form.kt         # Gerencia o fluxo de entrada do usuário no console
│       └── Question.kt     # Representa uma pergunta no formulário
│
└── Main.kt                 # Ponto de entrada do aplicativo
```
## **Expansibilidade**
O projeto foi desenhado pensando em fácil expansão. Algumas ideias futuras:
1. **Novas Interfaces de Usuário:**
    - O sistema poderia implementar outro adaptador em `ui`, como uma interface gráfica (GUI) ou uma API REST.

2. **Suporte a Mais Operações e Números Decimais:**
    - Adicionar suporte para números decimais ou incluir operações mais avançadas (como potência ou raiz quadrada) exigiria apenas alterações no `Calculator` e `Expression`.

3. **Formulários Mais Dinâmicos:**
    - Perguntas condicionais ou validações mais complexas poderiam ser integradas ao `Form`.
