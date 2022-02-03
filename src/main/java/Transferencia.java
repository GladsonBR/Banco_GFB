public class Transferencia {
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldoD() {
        return SaldoD;
    }

    public void setSaldoD(double saldoD) {
        SaldoD = saldoD;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    double saldo;
    double SaldoD;
    double valor;
    public Transferencia(double saldoO, double saldoD, double valor ) {
        this.saldo = saldoO;
        this.SaldoD = saldoD;
        this.valor = valor;

        saldo-=valor;
        SaldoD+=valor;
    }


}
