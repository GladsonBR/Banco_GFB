import Model.*;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("Transacao-BC");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Scanner scan = new Scanner(System.in);

        double valor;
        double saldo;
        double saldoD;
        int numeroConta;
        int numeroContaD;
        int opt;
        do {
            System.out.println("O que deseja fazer? ");
            System.out.println("Digite 1 - Saque");
            System.out.println("Digite 2 - Depósito");
            System.out.println("Digite 3 - Transferência");
            System.out.println("Digite 4 - Saldo");
            System.out.println("Digite 5 - Sair");
            opt = scan.nextInt();
            Transacao transacao = new Transacao();
            if (opt > 0 && opt < 5) {
                switch (opt) {
                    case 1:
                        System.out.println("Digite o numero da conta: ");
                        numeroConta = scan.nextInt();
                        Conta contas = entityManager.find(Conta.class, numeroConta);
                        System.out.println("Digite o valor para saque: ");
                        valor = scan.nextDouble();
                        saldo = contas.getSaldo();
                        contas.setSaldo(transacao.saque(valor, saldo));
                        entityManager.getTransaction().begin();
                        entityManager.persist(contas);
                        entityManager.getTransaction().commit();
                        break;
                    case 2:
                        System.out.println("Digite o numero da conta para depósito: ");
                        numeroConta = scan.nextInt();
                        Conta contad = entityManager.find(Conta.class, numeroConta);
                        System.out.println("Digite o valor para depósito: ");
                        valor = scan.nextDouble();
                        saldo = contad.getSaldo();
                        contad.setSaldo(transacao.deposito(valor, saldo));
                        entityManager.getTransaction().begin();
                        entityManager.persist(contad);
                        entityManager.getTransaction().commit();
                        break;
                    case 3:
                        System.out.println("Digite o numero da conta de origem para transferência: ");
                        numeroConta = scan.nextInt();
                        System.out.println("Digite o numero da conta destino para transferência: ");
                        numeroContaD = scan.nextInt();
                        Conta conta = entityManager.find(Conta.class, numeroConta);
                        saldo = conta.getSaldo();
                        Conta contaT = entityManager.find(Conta.class, numeroContaD);
                        saldoD = contaT.getSaldo();
                        System.out.println("Digite o valor para transferência: ");
                        valor = scan.nextDouble();
                        Transferencia transferencia = new Transferencia(saldo, saldoD, valor);
                        conta.setSaldo(transferencia.getSaldo());
                        contaT.setSaldo(transferencia.getSaldoD());
                        entityManager.getTransaction().begin();
                        entityManager.persist(conta);
                        entityManager.persist(contaT);
                        entityManager.getTransaction().commit();
                        break;
                    case 4:
                        System.out.println("Digite o numero da conta para Saldo: ");
                        numeroConta = scan.nextInt();

                        Conta contaSaldo = entityManager.find(Conta.class, numeroConta);

                        System.out.println(contaSaldo.getSaldo());

                        entityManager.getTransaction().begin();
                        entityManager.persist(contaSaldo);
                        entityManager.getTransaction().commit();
                    }
                }
            }while (opt != 5);


        entityManager.close();
        entityManagerFactory.close();

    }
}
