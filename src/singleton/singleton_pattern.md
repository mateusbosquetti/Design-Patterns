# Design Pattern: Singleton - Contexto: Gerenciamento de Configurações

O padrão **Singleton** é um padrão de projeto criacional que garante que uma classe tenha apenas uma única instância em todo o ciclo de vida da aplicação e fornece um ponto de acesso global a essa instância.

## 🧠 O Problema
Em muitos sistemas, precisamos de objetos que devem ser únicos. Por exemplo:
- Um gerenciador de conexão com o banco de dados.
- Um objeto que carrega as configurações do sistema (`config.properties`).
- Um gerenciador de log.

Se criarmos várias instâncias desses objetos, podemos ter problemas de sincronização, consumo excessivo de memória ou comportamentos inconsistentes (ex: duas partes do sistema lendo configurações diferentes).

## 💡 A Solução
O Singleton resolve isso ao:
1.  **Privatizar o construtor:** Impede que outras classes usem o `new`.
2.  **Criar um método estático de acesso:** Um método (geralmente `getInstance()`) que controla a criação e retorna a instância única.

---

## 🛠️ Implementações em Java

Aqui estão as formas mais comuns de implementar o Singleton, da mais simples à mais robusta.

### 1. Lazy Initialization (Thread-Safe Básica)
Ideal para quando a instância é pesada e só deve ser criada quando for realmente usada. O `synchronized` garante que dois processos não criem duas instâncias ao mesmo tempo.

```java
package singleton;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private String serverUrl;

    // 1. Construtor PRIVADO
    private ConfigurationManager() {
        this.serverUrl = "https://api.meusistema.com";
        System.out.println("Configurações Carregadas!");
    }

    // 2. Método de acesso Global
    public static synchronized ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public String getServerUrl() { return serverUrl; }
}
```

### 2. Bill Pugh Singleton (A mais recomendada para Java)
Usa uma classe interna estática. É thread-safe sem a sobrecarga do `synchronized` e só carrega a instância quando o método `getInstance` é chamado.

```java
public class DatabaseConnection {
    private DatabaseConnection() {
        System.out.println("Conexão com Banco de Dados estabelecida!");
    }

    private static class Holder {
        private static final DatabaseConnection INSTANCE = new DatabaseConnection();
    }

    public static DatabaseConnection getInstance() {
        return Holder.INSTANCE;
    }
}
```

### 3. Enum Singleton (A prova de falhas)
A forma mais simples e robusta de implementar Singleton em Java moderno. Ela protege contra problemas de reflexão e serialização.

```java
public enum AppSettings {
    INSTANCE;

    private String theme = "Dark";

    public String getTheme() { return theme; }
    public void setTheme(String t) { this.theme = t; }
}
```

---

## 🚀 Como Testar (Exemplo de Main)

```java
package singleton;

public class Main {
    public static void main(String[] args) {
        // Tentar instanciar diretamente dará erro de compilação:
        // ConfigurationManager config = new ConfigurationManager(); 

        ConfigurationManager c1 = ConfigurationManager.getInstance();
        ConfigurationManager c2 = ConfigurationManager.getInstance();

        System.out.println("C1: " + c1.hashCode());
        System.out.println("C2: " + c2.hashCode());

        if (c1 == c2) {
            System.out.println("Sucesso! Ambas são a mesma instância.");
        }
    }
}
```

## ✅ Benefícios
- **Instância Única:** Economia de recursos e consistência de dados.
- **Lazy Loading:** O objeto só é criado se e quando for necessário.
- **Acesso Global:** Fácil de acessar de qualquer lugar do código.
