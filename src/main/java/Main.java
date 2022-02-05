import Model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConexaoDAO conexaoDAO = new ConexaoDAO();

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
            System.out.println("Digite 4 - Saldo/Extrato");
            System.out.println("Digite 5 - Sair");
            opt = scan.nextInt();
            Transacao transacao = new Transacao();
            if (opt > 0 && opt < 5) {
                switch (opt) {
                    case 1:
                        System.out.println("Digite o numero da conta: ");
                        numeroConta = scan.nextInt();
                        System.out.println("Digite o valor para saque: ");
                        valor = scan.nextDouble();
                        transacao.saque(valor, numeroConta);

                        break;
                    case 2:
                        System.out.println("Digite o numero da conta para depósito: ");
                        numeroConta = scan.nextInt();

                        System.out.println("Digite o valor para depósito: ");
                        valor = scan.nextDouble();
                        transacao.deposito(valor, numeroConta);

                        break;
                    case 3:
                        System.out.println("Digite o numero da conta de origem para transferência: ");
                        numeroConta = scan.nextInt();
                        System.out.println("Digite o numero da conta destino para transferência: ");
                        numeroContaD = scan.nextInt();

                        System.out.println("Digite o valor para transferência: ");
                        valor = scan.nextDouble();

                        transacao.Transferencia( valor, numeroConta, numeroContaD);
                        break;
                    case 4:
                        System.out.println("Digite 1 - p/Saldo     2- p/Extrato: ");
                        int opts = scan.nextInt();
                        System.out.println("Digite o numero da conta para saldo/Extrato: ");
                        numeroConta = scan.nextInt();
                        if(opts == 1){
                            transacao.saldo(numeroConta);
                        }else if(opts == 2) {
                            transacao.extrato(conexaoDAO.entityManager, numeroConta);
                        }else{
                            System.out.println("Digite uma opção válida");
                        }

                    }
                }
            }while (opt != 5);


        conexaoDAO.entityManager.close();
        conexaoDAO.entityManagerFactory.close();

    }
}
