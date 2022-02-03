import Model.metodoTransacoes;

public class Transacao implements metodoTransacoes {


    @Override
    public double saque(double valor, double saldo) {

     return saldo-valor;
    }

    @Override
    public double deposito(double valor, double saldo) {

     return saldo+valor;
    }



}
