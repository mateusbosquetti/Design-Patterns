# Design Pattern: Command - Contexto: Automação Residencial (Controle Remoto)

O padrão **Command** é um padrão de projeto comportamental que encapsula uma solicitação como um objeto, permitindo que você parametrize clientes com diferentes solicitações, enfileire ou registre solicitações e suporte operações que podem ser desfeitas.

## 🧠 O Problema
Imagine que você está desenvolvendo o software para um controle remoto universal. O controle tem vários botões físicos, mas você não sabe, no momento da fabricação do controle, o que cada botão fará. Um botão pode ligar uma lâmpada, outro abrir a garagem e outro ligar o ar-condicionado.

Se você programar o botão diretamente para chamar `lampada.ligar()`, seu controle remoto ficará "preso" à classe Lâmpada. Se amanhã você quiser que o botão ligue a TV, terá que mudar o código interno do Controle Remoto.

## 💡 A Solução
O padrão Command resolve isso introduzindo uma interface comum para todas as ações. O Controle Remoto (Invocador) não sabe *o que* a ação faz, ele apenas sabe que pode chamar o método `execute()`.

### Anatomia do Padrão
1.  **Command (Interface):** Define o contrato (ex: `execute()` e `undo()`).
2.  **ConcreteCommand (Comando Concreto):** Implementa o contrato. Ele possui uma referência ao Receptor e sabe qual método dele chamar.
3.  **Receiver (Receptor):** A classe que contém a lógica de negócio real (ex: `Light`, `Stereo`).
4.  **Invoker (Invocador):** Segura o comando e decide quando executá-lo (ex: `RemoteControl`).

---

## 🛠️ Guia de Implementação

### Passo 1: Definir a Interface `Command`
Crie uma interface que servirá de base para todas as ações. Ela deve permitir a execução e a reversão da ação.
```java
public interface Command {
    void execute();
    void undo();
}
```

### Passo 2: Criar o Receptor (`Receiver`)
Crie a classe que realmente faz o trabalho. Ela não conhece o padrão Command, apenas realiza suas tarefas.
```java
public class Light {
    public void on() { System.out.println("Luz acesa!"); }
    public void off() { System.out.println("Luz apagada!"); }
}
```

### Passo 3: Criar Comandos Concretos
Para cada ação do receptor, crie uma classe de comando.
- **Dica:** O comando deve receber o receptor no construtor.
- **Implementação:** No `execute()`, chame `light.on()`. No `undo()`, chame `light.off()`.

### Passo 4: Implementar o Invocador (`Invoker`)
Crie o controle remoto. Ele deve ter um campo para guardar o comando atual.
- Ele deve ter um método para "setar" o comando (`setCommand`).
- Ele deve ter um método para pressionar o botão (`buttonPressed`), que chama `command.execute()`.
- Ele deve ter um método para o botão de desfazer (`undoPressed`), que chama `command.undo()`.

---

## 🚀 Desafio Extra: Suporte a Histórico
Para tornar seu padrão Command ainda mais poderoso, em vez de guardar apenas um comando no Invocador, você pode usar uma `Stack<Command>` (Pilha) para guardar o histórico de todos os comandos executados. Assim, o botão `undo` pode ser pressionado várias vezes para voltar ao estado inicial!

## ✅ Benefícios
- **Desacoplamento Total:** O controle remoto não conhece as classes das lâmpadas ou portões.
- **Extensibilidade:** Adicionar um novo dispositivo é apenas criar um novo par de Comandos Concretos.
- **Operações Complexas:** Permite criar "Macros" (um comando que executa uma lista de outros comandos).
