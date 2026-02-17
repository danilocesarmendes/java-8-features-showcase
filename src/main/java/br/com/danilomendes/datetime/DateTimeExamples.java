package br.com.danilomendes.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DateTimeExamples {

    public static void main(String[] args) {
        final LocalDate hoje = LocalDate.now();
        final LocalDate nascimento = LocalDate.of(1985, 1, 31);

        System.out.println("data de hoje " + hoje);
        System.out.println("data do nascimento " + nascimento);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String  dtHojeFormatada = hoje.format(formatter);
        System.out.println(dtHojeFormatada);

        String  dtNascimentoFormatada = nascimento.format(formatter);
        System.out.println(dtNascimentoFormatada);

        Period idade = Period.between(nascimento, hoje);
        System.out.println("Idade: " + idade.getYears());

        LocalDate proximaSemana = hoje.plusWeeks(1);
        LocalDate mesPassado = hoje.minusMonths(1);

        System.out.println("proxima semana = " + proximaSemana);
        System.out.println("mes passado = " + mesPassado);


        ZonedDateTime agoraSP = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        ZonedDateTime agoraNY = ZonedDateTime.now(ZoneId.of("America/New_York"));

        System.out.println(agoraSP);
        System.out.println(agoraNY);


        // importante para medir performance
        Instant inicio = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant fim = Instant.now();

        Duration duracao = Duration.between(inicio, fim);
        System.out.println("Tempo em ms: " + duracao.toMillis());

        LocalDateTime expiracao = LocalDateTime.now().plusMinutes(15);
        boolean expirado = LocalDateTime.now().isAfter(expiracao);
        System.out.println("Token expirado? " + expirado);




    }
}
