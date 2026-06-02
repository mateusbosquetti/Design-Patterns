# Design Pattern: Strategy - Contexto: Sistema de Pagamentos

O padrão **Strategy** é um padrão de projeto comportamental que permite definir uma família de algoritmos, encapsular cada um deles e torná-los intercambiáveis. O Strategy permite que o algoritmo varie independentemente dos clientes que o utilizam.

## Problema
Imagine um sistema de e-commerce que aceita diferentes métodos de pagamento:
- Cartão de Crédito
- PayPal
- Pix

Sem o Strategy, o código de finalização de compra teria muitos `if/else`:
```java
if (method.equals("CREDIT_CARD")) {
    // lógica complexa do cartão
} else if (method.equals("PAYPAL")) {
    // lógica do paypal
} // ...
```
Isso viola o princípio **Open/Closed**: toda vez que você adicionar um novo método de pagamento, terá que modificar a classe principal.

## Implementação Passo a Passo

### 1. Definir a Interface da Estratégia (`PaymentStrategy`)
Esta interface define o contrato comum para todos os algoritmos de pagamento.

### 2. Implementar Estratégias Concretas
Cada classe implementa a interface com sua lógica específica (ex: `CreditCardPayment`, `PixPayment`).

### 3. Criar o Contexto (`ShoppingCart` ou `Order`)
A classe que utiliza a estratégia. Ela mantém uma referência para um objeto `PaymentStrategy` e não sabe qual implementação exata está usando.

### 4. Configurar e Executar
O cliente decide qual estratégia passar para o contexto em tempo de execução.

## Exemplo de Estrutura de Código

```java
// 1. Interface
public interface PaymentStrategy {
    void collectPaymentDetails();
    void processPayment(double amount);
}

// 2. Estratégia Concreta
public class PixPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Pagamento de R$" + amount + " via Pix processado.");
    }
    // ...
}

// 3. Contexto
public class Order {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void checkout(double amount) {
        strategy.processPayment(amount);
    }
}
```

## Benefícios
- **Adeus ao IF/ELSE infinito:** A lógica fica isolada em classes menores.
- **Flexibilidade:** Você pode trocar a estratégia em tempo de execução.
- **Extensibilidade:** Adicionar um novo método de pagamento é apenas criar uma nova classe.
