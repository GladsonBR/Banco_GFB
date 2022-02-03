package Model;
import javax.persistence.*;

@Entity
@Table(name = "Contas")
public class Conta {

    public Conta(){

    }
    public Conta(double saldo) {
       this.saldo = saldo;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numeroConta")
    int conta;
    @Column(name = "agConta")
    int agencia;

    @Override
    public String toString() {
        return "Conta{" +
                "saldo=" + saldo +
                '}';
    }

    @Column(name = "saldoConta")
    double saldo;
    @Column(name = "tipoConta")
    char tipoConta;

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    @Column(name = "nomeCliente")
    String nomeCliente;

    public char getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(char tipoConta) {
        this.tipoConta = tipoConta;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
