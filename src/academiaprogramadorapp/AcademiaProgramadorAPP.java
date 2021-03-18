
package academiaprogramadorapp;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class AcademiaProgramadorAPP {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        ArrayList<Equipamento> listaequipamentos = new ArrayList();
        
        String nome = JOptionPane.showInputDialog(null, "Primeiro, diga o seu nome: ");
        Usuario user = new Usuario(nome);
        
        int i = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantos equipamentos deseja registrar? "));
        
        for(int n=0; n<i; n++){
            String nomeeq = JOptionPane.showInputDialog(null, "Me diz o nome do equipamento: ");
            double preco = Double.parseDouble(JOptionPane.showInputDialog(null, "E quanto foi que ele custou? "));
            int nmrserie = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número de série sem espaços ou pontos: "));
            String marca = JOptionPane.showInputDialog(null, "De qual marca é esse equipamento? ");
            int dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual foi o dia em que ele foi fabricado? "));
            int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Qual foi o mês (numeral)? "));
            int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Por fim, me diz qual foi o ano em que comprou o equipamento, " + nome + ": "));
            
            Equipamento equi = new Equipamento(nomeeq, preco, nmrserie, marca, ano, mes, dia);
            
            listaequipamentos.add(equi);
        }
        user.setListaequipamentos(listaequipamentos);
        
        int var = 8;
        
            do{
            var = Integer.parseInt(JOptionPane.showInputDialog(null, " Digite uma das seguintes opções: \n 1 - Visualizar \n 2 -  Editar equipamento \n 3 - Excluir um equipamento \n 4 - Colocar em manutenção \n 5 - Ver chamadas de manutenção \n 6 - Editar chamada de manutenção \n 7 - Excluir chamada \n 0 - Finalizar programa "));
            if(var==1){
               
                String e1 = (JOptionPane.showInputDialog(null, "Qual o nome do equipamento? "));
                
                user.verificar(e1);
            }
            else if(var==2){
                String e1 = (JOptionPane.showInputDialog(null, "Qual o nome do equipamento? "));
                user.editar(e1);
            }
            else if(var==3){
                
                String e1 = (JOptionPane.showInputDialog(null, "Qual o nome do equipamento que deseja remover? "));
                if(listaequipamentos.size() == 1){
                    JOptionPane.showMessageDialog(null, "Você não possui mais equipamentos registrados. \nFinalizando aplicativo...");
                    var=0;
                }
                else if(listaequipamentos.size() != 1){
                user.remover(e1);
                }
            }
            else if(var==4){
                String e1 = (JOptionPane.showInputDialog(null, "Qual o nome do equipamento que deseja colocar em manutenção? "));
                user.manutençãoon(e1);
            }
            
            else if(var==5){
                String e1 = (JOptionPane.showInputDialog(null, "Ei, me diz o nome do equipamento, pra gente ver se ele tem manutenção marcada: "));
                user.verificarmanut(e1);
            }
            else if(var==6){
                String e1 = (JOptionPane.showInputDialog(null, "Qual o nome do equipamento que deseja colocar em manutenção? "));
                user.editmanut(e1);
            }
            else if(var==7){
                String e1 = JOptionPane.showInputDialog(null, "Me diz, a manutenção de qual equipamento você quer que eu desmarque? ");
                user.removemanut(e1);
            }
        }while(var != 0);
    
}
}