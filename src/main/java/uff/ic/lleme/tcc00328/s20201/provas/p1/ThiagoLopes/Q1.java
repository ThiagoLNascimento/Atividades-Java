/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328.s20201.provas.p1.ThiagoLopes;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.NoSuchElementException;

/**
 *
 * @author Thiago
 */

public class Q1 {
    
    public static prato[] prato = new prato[3];
    public static pedido[] pedido = new pedido[5];
    
    public static void ArmazenarPratos(String arq) throws Exception{
        
        InputStream input = new FileInputStream(arq);
        Scanner in = new Scanner (input);
        
        /*Formato do aquivo:
        cada linha irá conter um float para o preço do prato seguido do nome do prato
        */
        for (int i = 0; i < prato.length; i ++){
            try{
                
                prato[i] = new prato();
                prato[i].preco = in.nextFloat();
                prato[i].nome = in.nextLine();
                
            }catch(NoSuchElementException e){
                break;
            }
        }
        
    }
    
    public static void ArmazenarPedidos(String arq) throws Exception{
        
        InputStream input = new FileInputStream(arq);
        Scanner in = new Scanner (input);
        
        /*Formato do arquivo: 
        1 inteiro para a quantidade de pedidos
        depois para cada pedido terá 1 inteiro para a quantidade de pratos no pedido
        e em cada linha seguida terá um int para a quantidade do prato e uma string para o nome do prato */
        while(in.hasNext()){
            int n = in.nextInt();
            for (int i = 0; i < n; i ++){
                pedido[i] = new pedido();
                int m = in.nextInt();
                
                for (int j = 0; j < m; j ++){
                    try{
                        
                        pedido[i].item[j] = new item();
                        pedido[i].item[j].quant = in.nextInt();
                        pedido[i].item[j].prato.nome = in.nextLine();
                        
                        for (int k = 0; k < prato.length; k ++){
                            try{
                                if(pedido[i].item[j].prato.nome.equals(prato[k].nome)){
                                    pedido[i].item[j].prato.preco = prato[k].preco;
                                    break;
                                }
                            }catch(ArrayIndexOutOfBoundsException e){
                                break;
                            }
                        }

                    }catch(NoSuchElementException e){
                        break;
                    }
                }
            }
        }
    }
    
    public static void ValorConta(){
        Scanner in = new Scanner (System.in);
        int n;
        while(true){
            System.out.println("Digite o pedido que deseja saber o valor da conta ou 0 para finalizar: ");
            n = in.nextInt();
            if(n == 0)
                break;
            try{
                System.out.println("O valor da conta e: " + pedido[n - 1].valorConta());
                
            }catch(ArrayIndexOutOfBoundsException | NullPointerException e){
                System.out.println("Nao existe pedido com esse numero!");
            }
        }
    }
    
    public static void main(String[] args) throws Exception{
        ArmazenarPratos("src/main/java/uff/ic/lleme/tcc00328_classroom/s20201/provas/p1/ThiagoLopes/Pratos.txt");
        ArmazenarPedidos("src/main/java/uff/ic/lleme/tcc00328_classroom/s20201/provas/p1/ThiagoLopes/Pedidos.txt");
        ValorConta();
    }
}
