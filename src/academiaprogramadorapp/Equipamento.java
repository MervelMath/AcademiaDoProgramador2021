
package academiaprogramadorapp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

public class Equipamento {
        
    private String nome;
    private double preço;
    private int nmrserie;
    private String fabricante;
    private String data2;
    private boolean manut;
    LocalDate data;
    LocalDate datamanut;
    private String datamanutf;
    private String título;
    private String descchamado;

    
    public Equipamento(String nome, double preço, int nmrserie, String fabricante, int ano, int mes, int dia) {
        this.nome = nome;
        this.preço = preço;
        this.nmrserie = nmrserie;
        this.fabricante = fabricante;
        this.data = LocalDate.of(ano, mes, dia);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.data2 = data.format(format);
    }
    
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreço() {
        return preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }

    public int getNmrserie() {
        return nmrserie;
    }

    public void setNmrserie(int nmrserie) {
        this.nmrserie = nmrserie;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(int ano, int mes, int dia) {
        this.data = LocalDate.of(ano, mes, dia);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.data2 = data.format(format);
    }

    public boolean isManut() {
        return manut;
    }
    
    public void setManut(boolean manut) {
        this.manut = manut;
    }

   

    public LocalDate getDatamanut() {
        return datamanut;
    }

    public void setDatamanut(LocalDate datamanut, int n) {
        this.datamanut = datamanut;
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.datamanutf = getDatamanut().plusDays(n).format(format);
    }

   

    public String getDatamanutf() {
        return datamanutf;
    }

    public void setDatamanutf(String datamanutf) {
        this.datamanutf = datamanutf;
    }

    public String getTítulo() {
        return título;
    }

    public void setTítulo(String Título) {
        this.título = Título;
    }

    public String getDescchamado() {
        return descchamado;
    }

    public void setDescchamado(String descchamado) {
        this.descchamado = descchamado;
    }

    

    
    
    
}
