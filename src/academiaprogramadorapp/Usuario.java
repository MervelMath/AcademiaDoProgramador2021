
package academiaprogramadorapp;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Usuario {
    private String nome;
    
    ArrayList<Equipamento> listaequipamentos;

    public Usuario(String nome) {
        this.nome = nome;
    }
    
    
    void verificar(String e1) {
        for (Equipamento equip : listaequipamentos) {
            if(equip.getNome().equalsIgnoreCase(e1)){
                JOptionPane.showMessageDialog(null, "Nome: " + equip.getNome() + "\nPreço do equipamento: R$" + equip.getPreço() + "\nNúmero de série: " + equip.getNmrserie() + "\nFabricante: " +  equip.getFabricante() + "\nData de fabricação: " + equip.getData2());
            }
        }
    }
    
    void editar(String e1) {
        int var =0;
        for (Equipamento equip : listaequipamentos) {
            if(equip.getNome().equalsIgnoreCase(e1)){
                var = Integer.parseInt(JOptionPane.showInputDialog(null, "O que deseja editar? \n 1 - Nome \n 2 - Preço \n 3 - Fabricante \n 4 - Data de fabricação \n 5 - Número de série \n Ou digite outro número para CANCELAR "));
                if(var==1){
                    String n = JOptionPane.showInputDialog(null, "Digite o novo nome: ");
                    equip.setNome(n);
                }
                else if(var==2){
                    int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o novo nome: "));
                    equip.setPreço(n);
                }
                else if(var==3){
                    String n = JOptionPane.showInputDialog(null, "Digite o nome da marca Fabricante: ");
                    equip.setFabricante(n);
                }
                else if(var==4){
                    int dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o dia da fabricação:  "));
                    int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o mês(numeral): "));
                    int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Diga qual foi o ano em que comprou o equipamento: "));
                    
                    equip.setData(ano, mes, dia);
                }
                else if(var==5){
                    int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o novo número de série: "));
                    equip.setNmrserie(n);
                }
                
                
            }
        }
    }
    
    void remover(String e1) {
        for (Equipamento equip : listaequipamentos) {
            if(equip.getNome().equalsIgnoreCase(e1)){
                listaequipamentos.remove(equip);
            }
        }
    }
    
    void manutençãoon(String e1) {
        for (Equipamento equip : listaequipamentos) {
            
            if(equip.getNome().equalsIgnoreCase(e1)){
                String tit = (JOptionPane.showInputDialog(null, "Digite um título para a manutenção: "));
                equip.setTítulo(tit);
                tit = (JOptionPane.showInputDialog(null, "Adicione uma descrição para o chamado de manutenção: "));
                equip.setDescchamado(tit);
                int n = Integer.parseInt(JOptionPane.showInputDialog(null, "Daqui a quantos dias você quer que a manutenção seja feita? "));
                equip.setDatamanut(LocalDate.now(), n);
                equip.setManut(true);
                JOptionPane.showMessageDialog(null, "Manutenção agendada para: " + equip.getDatamanutf() + ".");
                
            }
        }
    }
    
    public void verificarmanut(String e1) {
        
        for (Equipamento equip : listaequipamentos) {
        if(equip.getNome().equalsIgnoreCase(e1)){
        if(equip.isManut() == true){
           JOptionPane.showMessageDialog(null, "Título do chamado: " + equip.getTítulo() + "\nDescrição adicionada pelo usuário " + getNome() + ": " + equip.getDescchamado() + "\nEquipamento com manutenção marcada. \nData agendada: " + equip.getDatamanutf());
            
        }
        else{
            JOptionPane.showMessageDialog(null, "O equipamento não está com manutenção marcada.");
            
            
        }
        }
        }
    }
    
    void editmanut(String e1) {
         for (Equipamento equip : listaequipamentos) {
             if(equip.getNome().equalsIgnoreCase(e1)){
                 if(equip.isManut() == true){
                    String n =  JOptionPane.showInputDialog(null, "Deseja alterar: \n1 - Título \n2 - Descrição \n 3 - Data \n0 - Calcelar " );
                    
                    if(n.equalsIgnoreCase("1")){
                        String novotit = JOptionPane.showInputDialog(null, "Novo tículo: ");
                        equip.setTítulo(novotit);
                    }
                    
                    else if(n.equalsIgnoreCase("2")){
                        String novadesc = JOptionPane.showInputDialog(null, "Novo tículo: ");
                        equip.setDescchamado(novadesc);
                    }
                    else if(n.equalsIgnoreCase("3")){
                        int m =  Integer.parseInt(JOptionPane.showInputDialog(null, "Deseja remarcar a manutenção para daqui a quantos dias? "));
                        equip.setDatamanut(LocalDate.now(), m);
                        JOptionPane.showMessageDialog(null, "Data remarcada com sucesso!");
                    }
                 }
             }
         }
    }
    void removemanut(String e1) {
        for (Equipamento equip : listaequipamentos) {
            if(equip.getNome().equalsIgnoreCase(e1)){
                equip.setManut(false);
            }
        }
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Equipamento> getListaequipamentos() {
        return listaequipamentos;
    }

    public void setListaequipamentos(ArrayList<Equipamento> listaequipamentos) {
        this.listaequipamentos = listaequipamentos;
    }

    
    
    
    
}
