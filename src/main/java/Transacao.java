import Model.Conta;
import Model.Extrato;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;


public class Transacao  {
    ConexaoDAO conexao = new ConexaoDAO();
    Extrato extrato = new Extrato();
    private Date DateTimeAtCreation;

    public void saque(double valor, int numeroConta) {
        Conta contas = conexao.entityManager.find(Conta.class, numeroConta);
        double saldo = contas.getSaldo();
        contas.setSaldo(saldo-=valor);

        Extrato extrato = new Extrato();

        GregorianCalendar date = new GregorianCalendar();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt","BR"));
        date.getTime();

        extrato.setNumContaEx(numeroConta);
        extrato.setTipoTransacaoEx("Saque");
        extrato.setValorTransac(-valor);
        extrato.setDataTransac(data.format(date.getTime()));

        conexao.entityManager.getTransaction().begin();
        conexao.entityManager.persist(contas);
        conexao.entityManager.getTransaction().commit();

    }


    public void deposito(double valor, int numeroConta) {
        Conta contad = conexao.entityManager.find(Conta.class, numeroConta);
        double saldo = contad.getSaldo();
        contad.setSaldo(saldo+=valor);

        Extrato extrato = new Extrato();
        GregorianCalendar date = new GregorianCalendar();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt","BR"));
        date.getTime();

        extrato.setNumContaEx(numeroConta);
        extrato.setTipoTransacaoEx("Depósito");
        extrato.setValorTransac(valor);
        extrato.setDataTransac(data.format(date.getTime()));

        conexao.entityManager.getTransaction().begin();
        conexao.entityManager.persist(contad);
        conexao.entityManager.persist(extrato);
        conexao.entityManager.getTransaction().commit();

    }

    public void Transferencia(double valor, int contaO, int contaD ) {
        Conta conta = conexao.entityManager.find(Conta.class, contaO);
        double saldo = conta.getSaldo();
        Conta contaT = conexao.entityManager.find(Conta.class, contaD);
        double saldoD = contaT.getSaldo();
        saldo -= valor;
        saldoD += valor;

        GregorianCalendar date = new GregorianCalendar();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt","BR"));
        date.getTime();

        extrato.setNumContaEx(contaO);
        extrato.setTipoTransacaoEx("Transferência");
        extrato.setValorTransac(-valor);
        extrato.setDataTransac(data.format(date.getTime()));

        conta.setSaldo(saldo);
        contaT.setSaldo(saldoD);

        conexao.entityManager.getTransaction().begin();
        conexao.entityManager.persist(conta);
        conexao.entityManager.persist(contaT);
        conexao.entityManager.persist(extrato);
        conexao.entityManager.getTransaction().commit();
    }

    public void saldo(int numeroConta){
        Conta conta = conexao.entityManager.find(Conta.class, numeroConta);
        System.out.println(conta.getSaldo());
    }

    public void extrato(EntityManager entityManager,int numeroConta){
        String jpql = "select ext from Extrato ext where ext.numContaEx = :contaUsuario";
        TypedQuery<Extrato> typedQuery = entityManager.createQuery(jpql, Extrato.class);
        typedQuery.setParameter("contaUsuario", numeroConta);
        List<Extrato> lista = typedQuery.getResultList();
        lista.forEach(ext -> System.out.println("===="+ ext.getIdExtrato() + " ==== " + ext.getNumContaEx()+" ==== "+ ext.getValorTransac()+" ==== "+ ext.getTipoTransacaoEx()+" ==== "+ext.getDataTransac()));
    }


}
