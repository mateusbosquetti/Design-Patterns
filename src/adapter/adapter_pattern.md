# Design Pattern: Adapter - Contexto: Integração de Notificações

O padrão **Adapter** é um padrão de projeto estrutural que permite que objetos com interfaces incompatíveis colaborem. Ele funciona como um "tradutor" ou "conversor" entre dois sistemas.

## Problema
Imagine que seu sistema já tem uma interface padrão para enviar notificações:
```java
public interface NotificationService {
    void send(String message);
}
```

Você precisa integrar um novo fornecedor de SMS (ex: *LegacySMSProvider*), mas a biblioteca deles usa um formato totalmente diferente:
```java
public class LegacySMSProvider {
    // Eles esperam o número e a mensagem separadamente
    public void sendSmsNow(String phone, String msg) {
        System.out.println("Enviando SMS legadamente...");
    }
}
```

Se você usar o `LegacySMSProvider` diretamente no seu código, você estará "preso" a essa biblioteca e violará sua própria interface padrão.

## A Solução
Criar uma classe **Adapter** que:
1. Implementa a sua interface (`NotificationService`).
2. Contém uma referência ao objeto incompatível (`LegacySMSProvider`).
3. Traduz a chamada do método `send(message)` para o método `sendSmsNow(phone, msg)`.

## Implementação Passo a Passo

### 1. Definir a Interface Alvo (`Target`)
É a interface que seu sistema já conhece e usa.

### 2. Identificar a Classe Incompatível (`Adaptee`)
É o sistema externo ou antigo que você quer usar, mas não pode alterar o código.

### 3. Criar o Adaptador (`Adapter`)
Uma classe que une os dois mundos. Ela implementa a interface Alvo e delega o trabalho para o Adaptee.

## Exemplo de Estrutura de Código

```java
// 1. Nossa Interface (Target)
public interface NotificationService {
    void send(String message);
}

// 2. Classe Externa (Adaptee)
public class LegacySMSProvider {
    public void sendSmsNow(String number, String text) {
        System.out.println("SMS enviado via Legacy: " + text);
    }
}

// 3. O Adaptador (Adapter)
public class SMSAdapter implements NotificationService {
    private LegacySMSProvider provider;
    private String phoneNumber;

    public SMSAdapter(LegacySMSProvider provider, String phoneNumber) {
        this.provider = provider;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void send(String message) {
        // Tradução: Nossa chamada 'send' vira a chamada 'sendSmsNow' deles
        provider.sendSmsNow(phoneNumber, message);
    }
}
```

## Benefícios
- **Princípio SRP (Single Responsibility):** Você separa a interface ou o código de conversão de dados da lógica de negócio do programa.
- **Princípio OCP (Open/Closed):** Você pode introduzir novos tipos de adaptadores no programa sem quebrar o código cliente existente.
- **Reutilização:** Você consegue usar classes legadas ou de terceiros que de outra forma seriam incompatíveis.
