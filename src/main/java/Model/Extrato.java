package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Extrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idExtrato;
    int numContaEx;
    String tipoTransacaoEx;
    double valorTransac;
    String dataTransac;

    @Override
    public String toString() {
        return "Extrato{" +
                "idExtrato=" + idExtrato +
                ", numContaEx=" + numContaEx +
                ", tipoTransacaoEx='" + tipoTransacaoEx + '\'' +
                ", valorTransac=" + valorTransac +
                ", dataTransac=" + dataTransac +
                '}';
    }


    public int getIdExtrato() {
        return idExtrato;
    }

    public void setIdExtrato(int idExtrato) {
        this.idExtrato = idExtrato;
    }

    public int getNumContaEx() {
        return numContaEx;
    }

    public void setNumContaEx(int numContaEx) {
        this.numContaEx = numContaEx;
    }

    public String getTipoTransacaoEx() {
        return tipoTransacaoEx;
    }

    public void setTipoTransacaoEx(String tipoTransacaoEx) {
        this.tipoTransacaoEx = tipoTransacaoEx;
    }

    public double getValorTransac() {
        return valorTransac;
    }

    public void setValorTransac(double valorTransac) {
        this.valorTransac = valorTransac;
    }

    public String getDataTransac() {
        return dataTransac;
    }

    public void setDataTransac(String dataTransac) {
        this.dataTransac = dataTransac;
    }




}
