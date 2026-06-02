# Design Pattern: Observer - Contexto: Sistema de Notificações (Newsletter)

O padrão **Observer** (também conhecido como Publisher/Subscriber) é um padrão de projeto comportamental que define uma dependência um-para-muitos entre objetos. Quando o objeto principal (o *Subject* ou *Publisher*) muda de estado, todos os seus dependentes (os *Observers* ou *Subscribers*) são notificados e atualizados automaticamente.

## Problema
Imagine que você tem uma loja e os clientes querem saber quando um produto (ex: iPhone) volta ao estoque. 
- Sem o Observer, o cliente teria que acessar o site todo dia para verificar (isso se chama *Polling*, que gasta muitos recursos).
- A solução ideal é: o cliente deixa o email dele na loja (se inscreve). Quando o iPhone chega, a loja envia um email para todos os inscritos.

## Atores Principais
1. **Subject (Sujeito / Publisher):** É o gerador de eventos. Ele mantém uma lista de assinantes e fornece métodos para adicionar e remover inscritos.
2. **Observer (Observador / Subscriber):** É a interface que define como as notificações serão recebidas (geralmente um método `update()`).

## Implementação Passo a Passo

### 1. Definir a Interface do Observer (`Subscriber`)
Define o método que será chamado pelo Publisher quando algo acontecer.

### 2. Definir a Interface do Subject (`Publisher`) (Opcional, mas recomendado)
Define os métodos `subscribe()`, `unsubscribe()` e `notifySubscribers()`.

### 3. Implementar o Subject Concreto (`Newsletter`)
Mantém uma lista (como um `List<Subscriber>`) e, quando ocorre um evento, varre a lista chamando o método `update()` de cada um.

### 4. Implementar os Observers Concretos (`EmailSubscriber`, `PushSubscriber`)
Implementam o que fazer quando recebem a notificação (ex: imprimir na tela, enviar um email real).

## Exemplo de Estrutura de Código

```java
// 1. Interface Observer
public interface Subscriber {
    void update(String news);
}

// 2. Observer Concreto
public class EmailSubscriber implements Subscriber {
    private String email;

    public EmailSubscriber(String email) { this.email = email; }

    @Override
    public void update(String news) {
        System.out.println("Enviando email para " + email + ": Nova notícia! " + news);
    }
}

// 3. Subject Concreto
import java.util.ArrayList;
import java.util.List;

public class Newsletter {
    private List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber s) {
        subscribers.add(s);
    }

    public void unsubscribe(Subscriber s) {
        subscribers.remove(s);
    }

    public void addNews(String news) {
        System.out.println("Adicionando notícia e notificando inscritos...");
        for (Subscriber s : subscribers) {
            s.update(news); // Notifica cada um
        }
    }
}
```

## Benefícios
- **Desacoplamento:** O Publisher não precisa saber a classe concreta do Subscriber. Ele só sabe que todos implementam a interface `Subscriber`.
- **Flexibilidade:** Você pode adicionar novos tipos de Subscribers (ex: SMS, WhatsApp) sem alterar o código do Publisher.
