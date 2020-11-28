/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uff.ic.lleme.tcc00328.s20201.exercicio.exercicio22;

/**
 *
 * @author Thiago
 */
import java.util.*;

abstract class Main {
    
    public static Jurado[] jurado = new Jurado[5]; 
    public static Escola[] escola = new Escola[10];
    
    public static int registrarNovoJurado(int quant_jurado){
        
        Scanner in = new Scanner (System.in);
        
        if (quant_jurado == 5){
            System.out.println("Número máximo de jurados já inscritos!");
            return quant_jurado;
        }else{
            System.out.println("Digite o nome do jurado que deseja adicionar: ");
            jurado[quant_jurado] = new Jurado();
            jurado[quant_jurado].setNome(in.next());
            quant_jurado ++;
            return quant_jurado;
        }
    }
    
    
    public static int registrarNovaEscola(int quant_escola){
        
        Scanner in = new Scanner (System.in);
        
        if(quant_escola == 10){
            System.out.println("Número máximo de escolas já inscritos!");
            return quant_escola;
        }else{
            System.out.println("Digite o nome da escola que deseja adicionar: ");
            escola[quant_escola] = new Escola();
            escola[quant_escola].setNome(in.next());
            quant_escola ++;
            return quant_escola;
        }
        
    }
    
    
    public static void registrarNota(){
        
        Scanner in = new Scanner (System.in);
        
        System.out.println("Digite o nome do Jurado que vai dar a nota: ");
        String nota_jur = in.next();
        int ver = 0;
        int i = 0;
        for(i = 0; i < 5; i ++)
            try{                
                if(jurado[i].getNome().equals(nota_jur)){
                    
                    int ques = -1;
                    System.out.println("Digite o nome do quesito da nota: ");
                    String nota_ques = in.next();
                    if(nota_ques.equals("harmonia"))
                        ques = 0;
                    else if(nota_ques.equals("fantasia"))
                        ques = 1;
                    else if(nota_ques.equals("bateria"))
                        ques = 2;
                    else if(nota_ques.equals("samba"))
                        ques = 3;
                    else{
                        System.out.println("Quesito inexistente.");
                        return;
                    }
                    System.out.println("Digite o nome da escola que vai receber a nota: ");
                    String nota_esc = in.next();
                    for(int j = 0; j < 10; j ++){
                        try{
                            if(nota_esc.equals(escola[j].getNome())){
                                
                                if(escola[j].getNota(ques,i) != null){
                                    System.out.println("Nota desse jurado para esse quesito para essa escola ja dada:");
                                    return;
                                }
                                Nota nota = new Nota();
                                nota.escola = escola[j];
                                nota.jurado = jurado[i];
                                nota.quesito = nota_ques;
                                System.out.println("Digite o valor da nota:");
                                nota.valor = in.nextFloat();
                                escola[j].setNota(nota,ques,i);
                                jurado[i].setNota(nota,ques,j);
                                return;
                            }
                        }catch(NullPointerException e){
                          
                        }
                    }
                    System.out.println("Escola nao cadastrada");
                    return;
                }
            }catch(NullPointerException e){
                break;
            }

        if(ver == 0){
            System.out.println("Jurado nao existente!");
        }
    }
    

    
        public static void mostrarResultado(){
        System.out.print("\t\t");
        for(Escola escola: escola)
            try{
                System.out.print(escola.getNome() + "\t");
            }catch(NullPointerException e){
                break;
            }
        System.out.print("\n");
        System.out.print("Harmonia:\t");
        for(Escola escola: escola)
            try{
                System.out.print(escola.mediaNotaHarmonia() + "\t");    
            }catch(NullPointerException e){
                break;
            }
        System.out.print("\n");
        System.out.print("Fantasia:\t");
        for(Escola escola: escola)
            try{
                System.out.print(escola.mediaNotaFantasia() + "\t");
            }catch(NullPointerException e){
                break;
            }
        System.out.print("\n");
        System.out.print("Bateria:\t");
        for(Escola escola: escola)
            try{
                System.out.print(escola.mediaNotaBateria() + "\t");
            }catch(NullPointerException e){
                break;
            }
        System.out.print("\n");
        System.out.print("Samba:\t\t");
        for(Escola escola: escola)
            try{
                System.out.print(escola.mediaNotaSamba() + "\t");
            }catch(NullPointerException e){
                break;
            }
        System.out.print("\n");
        System.out.print("Medias:\t\t");
        for(Escola escola: escola)
            try{
                System.out.print(escola.mediaTotal()+ "\t");
            }catch(NullPointerException e){
                break;
            }
        System.out.print("\n");
    }
        
        
    public static void computarResultados(int desempate){
        float [][]end_maior = new float[10][2];
        float []aux = new float[2];
        int i, j, k = 1;
        boolean troca = true;
        try{
            for(i = 0; i < 10; i ++){
                    end_maior[i][0] = i;
                    end_maior[i][1] = escola[i].mediaTotal();
            }
            while (troca) {
                troca = false;
                for (j = 0; j < 9; j++) {
                    if (end_maior[j][1] < end_maior[j + 1][1]) {
                        aux[0] = end_maior[j][1];
                        aux[1] = end_maior[j][0];
                        end_maior[j][1] = end_maior[j + 1][1];
                        end_maior[j][0] = end_maior[j + 1][0];
                        end_maior[j + 1][1] = aux[0];
                        end_maior[j + 1][0] = aux[1];
                        troca = true;
                    }
                }
            }
        }catch(ArrayIndexOutOfBoundsException | NullPointerException e){           
        }
        try{
            for(i = 0; i < 10; i ++){
                if(end_maior[i][1] == end_maior[i + 1][1])
                    k++;
                else
                    break;
            }
            for(i = k; i < 10; i ++){
                end_maior[i][0] = -1;
                end_maior[i][1] = -1;
            }
        }catch(ArrayIndexOutOfBoundsException | NullPointerException e){           
        }
        if(desempate == 0){
            try{
                for(i = 0; i < k; i ++){
                        end_maior[i][0] = i;
                        end_maior[i][1] = escola[i].mediaNotaHarmonia();
                }
                while (troca) {
                    troca = false;
                        for (j = 0; j < k - 1; j++) {
                            if (end_maior[j][1] < end_maior[j + 1][1]) {
                                aux[0] = end_maior[j][1];
                                aux[1] = end_maior[j][0];
                                end_maior[j][1] = end_maior[j + 1][1];
                                end_maior[j][0] = end_maior[j + 1][0];
                                end_maior[j + 1][1] = aux[0];
                                end_maior[j + 1][0] = aux[1];
                                troca = true;
                            }
                        }
                        
               }
            }catch(ArrayIndexOutOfBoundsException | NullPointerException e){           
            }
        }
        if(desempate == 1){
            try{
                for(i = 0; i < k; i ++){
                        end_maior[i][0] = i;
                        end_maior[i][1] = escola[i].mediaNotaFantasia();
                        while (troca) {
                           troca = false;
                           for (j = 0; j < k - 1; j++) {
                               if (end_maior[j][1] < end_maior[j + 1][1]) {
                                   aux[0] = end_maior[j][1];
                                   aux[1] = end_maior[j][0];
                                   end_maior[j][1] = end_maior[j + 1][1];
                                   end_maior[j][0] = end_maior[j + 1][0];
                                   end_maior[j + 1][1] = aux[0];
                                   end_maior[j + 1][0] = aux[1];
                                   troca = true;
                               }
                           }
                        }
                }
            }catch(ArrayIndexOutOfBoundsException | NullPointerException e){           
            }
        }
        if(desempate == 2){
            try{
                for(i = 0; i < k; i ++){
                        end_maior[i][0] = i;
                        end_maior[i][1] = escola[i].mediaNotaBateria();
                        while (troca) {
                           troca = false;
                           for (j = 0; j < k - 1; j++) {
                               if (end_maior[j][1] < end_maior[j + 1][1]) {
                                   aux[0] = end_maior[j][1];
                                   aux[1] = end_maior[j][0];
                                   end_maior[j][1] = end_maior[j + 1][1];
                                   end_maior[j][0] = end_maior[j + 1][0];
                                   end_maior[j + 1][1] = aux[0];
                                   end_maior[j + 1][0] = aux[1];
                                   troca = true;
                               }
                           }
                        }
                }
            }catch(ArrayIndexOutOfBoundsException | NullPointerException e){           
            }
        }
        if(desempate == 3){
            try{
                for(i = 0; i < k; i ++){
                        end_maior[i][0] = i;
                        end_maior[i][1] = escola[i].mediaNotaSamba();
                        while (troca) {
                           troca = false;
                           for (j = 0; j < k - 1; j++) {
                               if (end_maior[j][1] < end_maior[j + 1][1]) {
                                   aux[0] = end_maior[j][1];
                                   aux[1] = end_maior[j][0];
                                   end_maior[j][1] = end_maior[j + 1][1];
                                   end_maior[j][0] = end_maior[j + 1][0];
                                   end_maior[j + 1][1] = aux[0];
                                   end_maior[j + 1][0] = aux[1];
                                   troca = true;
                               }
                           }
                        }
                }
            }catch(ArrayIndexOutOfBoundsException | NullPointerException e){           
            }
        }
        i = 0;
        System.out.println("A escola " + escola[(int) end_maior[i][0]].getNome() + " esta vencendo\n");
        i++;
        while(end_maior[i][1] == end_maior[i - 1][1]){
            System.out.println("A escola " + escola[(int) end_maior[i][0]].getNome() + " esta vencendo\n");
            i++;
        }
    }
    
    
    public static void main(String args[]){
        
        int quant_jurado = 0;
        int quant_escola = 0;
        int desempate = (int) (Math.random() * 4);
        System.out.println("Os quesitos para votação são: harmonia, fantasia, bateria e samba.");
        if (desempate == 0)
            System.out.println("O critério de desempate é: harmonia");
        else if (desempate == 1)
            System.out.println("O critério de desempate é: fantasia");
        else if (desempate == 2)
            System.out.println("O critério de desempate é: bateria");
        else if (desempate == 3)
            System.out.println("O critério de desempate é: samba");
        
        Scanner in = new Scanner (System.in);
        int op;
        
        while(true){
            System.out.println("\nDigite 1 para adicionar um novo jurado.");
            System.out.println("Digite 2 para adicionar uma nova escola.");
            System.out.println("Digite 3 para adicionar uma nova nota.");
            System.out.println("Digite 4 para mostrar a tabela de resultados.");
            System.out.println("Digite 5 para computar resultados.");
            System.out.println("Digite 0 para sair.");
            
            op = in.nextInt();
            System.out.println();
            if(op == 1)
                quant_jurado = registrarNovoJurado(quant_jurado);
            if(op == 2)
                quant_escola = registrarNovaEscola(quant_escola);
            if(op == 3)
                registrarNota();
            if(op == 4)
                mostrarResultado();
            if(op == 5)
                computarResultados(desempate);
            if(op == 0)
                break;
        }
    }
}