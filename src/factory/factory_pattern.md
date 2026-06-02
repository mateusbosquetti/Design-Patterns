# Design Pattern: Factory Method - Contexto: Gerador de Documentos

O padrão **Factory Method** é um padrão de projeto criacional que fornece uma interface para criar objetos em uma superclasse, mas permite que as subclasses alterem o tipo de objetos que serão criados.

## Problema
Imagine que você está criando um sistema de geração de documentos. No início, você só gera arquivos **PDF**. O código está espalhado com `new PDFDocument()`.
Depois, surge a necessidade de gerar arquivos **Word**. Se você usou `new` diretamente em todo o código, terá que caçar todas as instâncias e mudar para `if (tipo == PDF) new PDF() else new Word()`. Isso torna o código rígido e difícil de expandir para novos formatos (Excel, HTML, etc).

## A Solução
Em vez de instanciar o objeto diretamente, você chama um método especial (o "método fábrica"). As subclasses podem sobrescrever esse método para retornar diferentes tipos de documentos, enquanto a lógica principal do sistema permanece a mesma.

## Implementação Passo a Passo

### 1. Definir a Interface do Produto (`Document`)
Define o comportamento comum de todos os produtos que a fábrica pode criar (ex: método `open()`, `save()`).

### 2. Implementar Produtos Concretos (`PDFDocument`, `WordDocument`)
As classes reais que fazem o trabalho.

### 3. Definir a Classe Criadora (`DocumentFactory` ou `DocumentGenerator`)
Esta classe contém o **Factory Method**. Ela pode ser uma interface, classe abstrata ou uma classe simples com um método estático.

### 4. Uso do Cliente
O cliente interage com a fábrica e com a interface `Document`, nunca com as classes concretas.

## Exemplo de Estrutura de Código

```java
// 1. Interface do Produto
public interface Document {
    void open();
}

// 2. Produtos Concretos
public class PDFDocument implements Document {
    public void open() { System.out.println("Abrindo documento PDF..."); }
}

public class WordDocument implements Document {
    public void open() { System.out.println("Abrindo documento Word..."); }
}

// 3. Fábrica (Abordagem Simple Factory)
public class DocumentFactory {
    public static Document createDocument(String type) {
        if (type.equalsIgnoreCase("PDF")) {
            return new PDFDocument();
        } else if (type.equalsIgnoreCase("WORD")) {
            return new WordDocument();
        }
        throw new IllegalArgumentException("Tipo de documento desconhecido");
    }
}
```

## Benefícios
- **Desacoplamento:** O código que usa o documento não sabe qual classe concreta está sendo instanciada.
- **Single Responsibility:** Você centraliza a lógica de criação em um único lugar.
- **Extensibilidade:** Para adicionar um novo tipo de documento, você só muda a fábrica e cria a nova classe, sem tocar na lógica de negócio principal.
