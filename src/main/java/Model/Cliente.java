package Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {

   @Id
   private int idCliente;
   private String nomeCliente;
   private int telCliente;
   private String enderCliente;
   private String bairroCliente;
   private String cidadeCliente;
   private String estadoCliente;
   int CEPCliente;

   public int getIdCliente() {
      return idCliente;
   }

   public void setIdCliente(int idCliente) {
      this.idCliente = idCliente;
   }

   public String getNomeCliente() {
      return nomeCliente;
   }

   public void setNomeCliente(String nomeCliente) {
      this.nomeCliente = nomeCliente;
   }

   public int getTelCliente() {
      return telCliente;
   }

   public void setTelCliente(int telCliente) {
      this.telCliente = telCliente;
   }

   public String getEnderCliente() {
      return enderCliente;
   }

   public void setEnderCliente(String enderCliente) {
      this.enderCliente = enderCliente;
   }

   public String getBairroCliente() {
      return bairroCliente;
   }

   public void setBairroCliente(String bairroCliente) {
      this.bairroCliente = bairroCliente;
   }

   public String getCidadeCliente() {
      return cidadeCliente;
   }

   public void setCidadeCliente(String cidadeCliente) {
      this.cidadeCliente = cidadeCliente;
   }

   public String getEstadoCliente() {
      return estadoCliente;
   }

   public void setEstadoCliente(String estadoCliente) {
      this.estadoCliente = estadoCliente;
   }

   public int getCEPCliente() {
      return CEPCliente;
   }

   public void setCEPCliente(int CEPCliente) {
      this.CEPCliente = CEPCliente;
   }


 }
