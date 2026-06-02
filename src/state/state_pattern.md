# Design Pattern: State - Contexto: Ciclo de Vida de uma Tarefa (Task)

O padrão **State** é um padrão de projeto comportamental que permite que um objeto altere seu comportamento quando seu estado interno muda. O objeto parecerá ter mudado de classe.

## Problema
Gerenciar estados complexos com múltiplos `if/else` ou `switch` torna o código difícil de manter. Toda vez que um novo estado é adicionado (ex: `PAUSED`), você precisa alterar todos os métodos da classe principal para lidar com a nova lógica.

## Implementação Refinada (Transição por Retorno)

Nesta abordagem, em vez de o estado "forçar" uma mudança no contexto (via setter), ele **retorna** o próximo estado. Isso garante um encapsulamento superior.

### 1. Definir a Interface de Estado (`TaskState`)
Os métodos retornam a interface `TaskState`, indicando qual será o próximo estado após a ação.

### 2. Implementar Estados Concretos
Cada classe decide qual é o seu sucessor.
- Se a transição for válida, retorna o **novo objeto de estado**.
- Se for inválida, retorna `this` (mantém o estado atual).

### 3. O Contexto (`Task`)
Mantém o estado de forma privada. Não há necessidade de métodos `setStatus` públicos.

## Exemplo de Estrutura Refatorada

```java
// 1. Interface
public interface TaskState {
    TaskState start();
    TaskState finish();
    TaskState cancel();
}

// 2. Estado Concreto (Exemplo)
public class NotStartedTask implements TaskState {
    @Override
    public TaskState start() {
        System.out.println("Iniciando...");
        return new RunningTask(); // Transição válida
    }

    @Override
    public TaskState finish() {
        System.out.println("Erro: Não pode finalizar o que não começou.");
        return this; // Mantém o estado atual
    }
    
    // ... cancel()
}

// 3. Contexto
public class Task {
    private TaskState status;

    public Task() {
        this.status = new NotStartedTask();
    }

    public void start() {
        // O próprio estado diz qual é o próximo
        this.status = status.start();
    }
}
```

## Vantagens desta Abordagem
- **Imutabilidade do Fluxo:** O estado da classe `Task` só muda através dos métodos de negócio (`start`, `finish`), nunca por uma atribuição externa arbitrária.
- **Single Responsibility:** Cada classe de estado cuida apenas da sua própria lógica de transição.
- **Desacoplamento:** O estado não precisa conhecer a classe `Task` (a menos que precise ler dados dela), tornando-o mais fácil de testar isoladamente.
