# Design Pattern: Decorator - Contexto: Cafeteria (Personalização de Bebidas)

O padrão **Decorator** é um padrão de projeto estrutural que permite adicionar novos comportamentos a um objeto dinamicamente, colocando-os dentro de objetos "envoltórios" (wrappers) que contêm esses comportamentos.

## Problema
Imagine que você tem uma classe `Coffee`. Agora você quer adicionar opcionais: Leite, Açúcar, Chantilly, Caramelo.
Se usar herança, você terá uma explosão de classes:
- `CoffeeWithMilk`
- `CoffeeWithMilkAndSugar`
- `CoffeeWithMilkAndCaramel`
- `CoffeeWithEverything`...

Isso se torna impossível de manter. Além disso, a herança é estática (você não pode mudar o café em tempo de execução).

## A Solução
O Decorator permite que você "monte" seu objeto em camadas. Você começa com um café simples e vai "decorando-o" com camadas extras. Cada camada adiciona algo ao custo e à descrição.

## Implementação Passo a Passo

### 1. Definir a Interface do Componente (`Coffee`)
Define os métodos básicos (ex: `getDescription()`, `getCost()`).

### 2. Criar o Componente Concreto (`SimpleCoffee`)
A implementação base que será decorada.

### 3. Criar a Classe Decoradora Base (`CoffeeDecorator`)
Uma classe abstrata que:
- Implementa a interface `Coffee`.
- Contém uma referência para um objeto `Coffee` (o objeto que está sendo decorado).

### 4. Criar Decoradores Concretos (`MilkDecorator`, `CaramelDecorator`)
Classes que estendem o `CoffeeDecorator` e adicionam sua lógica específica aos métodos originais.

## Exemplo de Estrutura de Código

```java
// 1. Interface
public interface Coffee {
    String getDescription();
    double getCost();
}

// 2. Componente Concreto
public class SimpleCoffee implements Coffee {
    public String getDescription() { return "Café Simples"; }
    public double getCost() { return 5.0; }
}

// 3. Decorador Base
public abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    public String getDescription() { return decoratedCoffee.getDescription(); }
    public double getCost() { return decoratedCoffee.getCost(); }
}

// 4. Decorador Concreto
public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) { super(coffee); }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Leite";
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0;
    }
}
```

## Como Usar (Composição)
```java
Coffee meuCafe = new SimpleCoffee();
meuCafe = new MilkDecorator(meuCafe); // Agora é café com leite
meuCafe = new CaramelDecorator(meuCafe); // Agora é café com leite e caramelo
```

## Benefícios
- **Flexibilidade:** Você pode adicionar ou remover responsabilidades em tempo de execução.
- **Composição sobre Herança:** Resolve o problema da explosão de subclasses.
- **Princípio da Responsabilidade Única:** Você pode dividir uma classe que tem muitos comportamentos em várias classes menores (decoradores).
