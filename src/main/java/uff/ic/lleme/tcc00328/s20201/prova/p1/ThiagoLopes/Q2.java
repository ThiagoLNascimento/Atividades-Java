/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328.s20201.prova.p1.ThiagoLopes;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.NoSuchElementException;

/**
 *
 * @author Thiago
 */

public class Q2 {
    
    public static prato[] prato = new prato[3];
    public static pedido[] pedido = new pedido[5];
    
    public static void ArmazenarPratos(String arq) throws Exception{
        
        InputStream input = new FileInputStream(arq);
        Scanner in = new Scanner (input);
        
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
    
    public static void PercentualPratos(){
        
        int quant_total = 0;
        for (int i = 0; i < pedido.length; i ++){
            try{
         
                for (int j = 0; j < pedido[i].item.length; j ++){
                    try{
                        quant_total += pedido[i].item[j].quant;
                    }catch(NoSuchElementException |NullPointerException e){
                        break;
                    }
                }
            }catch(NoSuchElementException |NullPointerException e){
                break;
            }
        }
        for (int i = 0; i < prato.length; i ++){
            if (prato[i].nome.equals(""))
                break;
            float quant = 0;
            try{
                for (int j = 0; j < pedido.length; j ++){
                    try{
                        for (int k = 0; k < pedido[j].item.length; k ++){
                            try{
                                if(prato[i].nome.equals(pedido[j].item[k].prato.nome))
                                    quant += pedido[j].item[k].quant;
                            }catch(NoSuchElementException |NullPointerException e){
                                break;
                            }
                        }
                    }catch(NoSuchElementException |NullPointerException e){
                        break;
                    }   
                }
            }catch(NoSuchElementException |NullPointerException e){
                break;
            }
            float porc = quant / quant_total * 100;
            System.out.println("A porcentagem de pedidos do " + prato[i].nome + " e de " + porc + "%");
        }
    }
    
    
    public static void main(String[] args) throws Exception{
        ArmazenarPratos("src/main/java/uff/ic/lleme/tcc00328_classroom/s20201/provas/p1/ThiagoLopes/Pratos.txt");
        ArmazenarPedidos("src/main/java/uff/ic/lleme/tcc00328_classroom/s20201/provas/p1/ThiagoLopes/Pedidos.txt");
        PercentualPratos();
        
    }
}