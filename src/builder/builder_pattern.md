# Design Pattern: Builder - Contexto: House

O padrão **Builder** é um padrão de projeto criacional que permite a construção de objetos complexos passo a passo. Ele é especialmente útil quando um objeto tem muitos atributos opcionais ou quando o processo de construção envolve várias etapas.

## Problema
Imagine uma classe `House`. Uma casa pode ter:
- Paredes (obrigatório)
- Telhado (obrigatório)
- Janelas (opcional)
- Portas (opcional)
- Piscina (opcional)
- Jardim (opcional)

Se usarmos um construtor comum, teríamos algo como:
`new House(4, "Telhado Colonial", 10, 2, true, false);`
Isso fica difícil de ler e manter à medida que mais atributos são adicionados.

## Implementação Passo a Passo

### 1. Definir a Classe Principal (`House`)
A classe alvo deve ter um construtor privado para garantir que ela só possa ser instanciada através do Builder.

### 2. Criar a Classe Builder
Geralmente implementada como uma classe estática aninhada dentro de `House`. Ela deve conter os mesmos campos que a classe `House`.

### 3. Métodos de Configuração
Para cada atributo, criamos um método no Builder que:
1. Define o valor do campo.
2. Retorna a própria instância do Builder (`return this;`), permitindo o encadeamento de métodos (Fluent Interface).

### 4. O Método `build()`
O Builder deve ter um método (geralmente chamado `build()`) que valida os dados e chama o construtor privado da classe `House`, retornando o objeto finalizado.

## Exemplo de Estrutura de Código

```java
public class House {
    private final int walls;
    private final String roof;
    private final int windows;
    private final boolean hasPool;

    private House(HouseBuilder builder) {
        this.walls = builder.walls;
        this.roof = builder.roof;
        this.windows = builder.windows;
        this.hasPool = builder.hasPool;
    }

    public static class HouseBuilder {
        private int walls;
        private String roof;
        private int windows;
        private boolean hasPool;

        public HouseBuilder setWalls(int walls) {
            this.walls = walls;
            return this;
        }

        // ... outros métodos set ...

        public House build() {
            return new House(this);
        }
    }
}
```

## Como usar
```java
House house = new House.HouseBuilder()
    .setWalls(4)
    .setRoof("Plano")
    .setPool(true)
    .build();
```
