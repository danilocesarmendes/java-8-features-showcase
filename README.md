# ☕ Java 8 Features Showcase

Este repositório apresenta as principais funcionalidades introduzidas no
**Java 8**, que marcou a transição da linguagem para um modelo mais
funcional e moderno.

O objetivo é consolidar fundamentos essenciais amplamente utilizados em
aplicações backend.

------------------------------------------------------------------------

## 🚀 Principais Features

### 🔹 Lambda Expressions

Reduzem verbosidade e substituem classes anônimas.

``` java
lista.sort((a, b) -> a.compareTo(b));
```

------------------------------------------------------------------------

### 🔹 Functional Interfaces

Interfaces com apenas um método abstrato.

``` java
@FunctionalInterface
public interface Calculadora {
    int calcular(int a, int b);
}

Calculadora soma = (a, b) -> a + b;
```

Principais interfaces do pacote `java.util.function`: - `Predicate` -
`Function` - `Consumer` - `Supplier`

------------------------------------------------------------------------

### 🔹 Stream API

Processamento funcional e declarativo de coleções.

``` java
List<String> resultado = nomes.stream()
        .filter(n -> n.startsWith("D"))
        .map(String::toUpperCase)
        .toList();
```

Operações demonstradas: - `filter` - `map` - `flatMap` - `reduce` -
`groupingBy` - `partitioningBy`

------------------------------------------------------------------------

### 🔹 Optional

Representa presença ou ausência de valor, evitando
`NullPointerException`.

``` java
Optional<String> nome = Optional.ofNullable(null);
String resultado = nome.orElse("Valor padrão");
```

Boas práticas: - Usar como retorno - Evitar como atributo de entidade

------------------------------------------------------------------------

### 🔹 java.time API

Substitui `Date` e `Calendar`.\
Imutável e thread-safe.

``` java
LocalDate hoje = LocalDate.now();
Period idade = Period.between(nascimento, hoje);
```

Principais classes: - `LocalDate` - `LocalDateTime` - `ZonedDateTime` -
`Instant` - `Duration` - `Period`

------------------------------------------------------------------------

### 🔹 Default Methods

Permite adicionar métodos concretos em interfaces sem quebrar
implementações.

``` java
default void log(String msg) {
    System.out.println(msg);
}
```

------------------------------------------------------------------------

### 🔹 Parallel Streams

Processamento paralelo usando `ForkJoinPool`.

``` java
long total = IntStream.rangeClosed(1, 1_000_000)
        .parallel()
        .filter(n -> n % 2 == 0)
        .count();
```

⚠️ Indicado para operações CPU-bound.

------------------------------------------------------------------------

## 🎯 Objetivo

Demonstrar domínio dos fundamentos do Java 8, incluindo programação
funcional, Stream API, Optional e manipulação moderna de datas.

------------------------------------------------------------------------

## 🛠 Requisitos

-   Java 8+
