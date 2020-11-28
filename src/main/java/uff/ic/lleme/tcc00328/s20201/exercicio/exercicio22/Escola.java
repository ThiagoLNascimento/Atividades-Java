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


public class Escola {
    
    private String nome = null;
    private Nota[][] nota = new Nota[4][5];
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String arg){
        this.nome = arg;
    }
    
    public Nota getNota(int x, int y){
        return nota[x][y]; 
    }
    
    public void setNota(Nota arg, int x, int y){
        this.nota[x][y] = arg;
    }
    
    public Escola(){
        for(int i = 0; i < 4; i ++){
            for(int j = 0; j < 5; j ++){
                this.nota[i][j] = null;
            }
        }
    }
    
    public float mediaNotaHarmonia(){
        
        float menor = 10, soma = 0;
        int i, quant = -1;
        for(i = 0; i <5 ; i ++)
            try{
                if (this.nota[0][i].valor < menor)
                    menor = this.nota[0][i].valor;
            }catch(ArrayIndexOutOfBoundsException | NullPointerException e){
                
            }
        for(i = 0; i < 5; i ++)
            try{
                soma += this.nota[0][i].valor;
                quant++;
            }catch(ArrayIndexOutOfBoundsException | NullPointerException e){
                
            }
        if(quant == -1 || quant == 0)
            return (soma);
        return (soma - menor)/quant;
    }

    public float mediaNotaFantasia(){
        
        float menor = 10, soma = 0;
        int i, quant = -1;
        for(i = 0; i <5 ; i ++)
            try{
                if (this.nota[1][i].valor < menor)
                    menor = this.nota[1][i].valor;
            }catch(ArrayIndexOutOfBoundsException | NullPointerException e){

            }
        for(i = 0; i < 5; i ++)
            try{
                soma += this.nota[1][i].valor;
                quant++;
            }catch(ArrayIndexOutOfBoundsException | NullPointerException e){

            }
        if(quant == -1 || quant == 0)
            return (soma);
        return (soma - menor)/quant;
    }   
    
    public float mediaNotaBateria(){
        
        float menor = 10, soma = 0;
        int i, quant = -1;
        for(i = 0; i <5 ; i ++)
            try{
                if (this.nota[2][i].valor < menor)
                    menor = this.nota[2][i].valor;
            }catch(ArrayIndexOutOfBoundsException | NullPointerException e){

            }
        for(i = 0; i < 5; i ++)
            try{
                soma += this.nota[2][i].valor;
                quant++;
            }catch(ArrayIndexOutOfBoundsException | NullPointerException e){

            }
        if(quant == -1 || quant == 0)
            return (soma);
        return (soma - menor)/quant;
    }  

    public float mediaNotaSamba(){
        
        float menor = 10, soma = 0;
        int i, quant = -1;
        for(i = 0; i <5 ; i ++)
            try{
                if (this.nota[3][i].valor < menor)
                    menor = this.nota[3][i].valor;
            }catch(ArrayIndexOutOfBoundsException | NullPointerException e){

            }
        for(i = 0; i < 5; i ++)
            try{
                soma += this.nota[3][i].valor;
                quant++;
            }catch(ArrayIndexOutOfBoundsException | NullPointerException e){

            }
        if(quant == -1 || quant == 0)
            return (soma);
        return (soma - menor)/quant;
    }
    
    public float mediaTotal(){
        return (this.mediaNotaSamba() + this.mediaNotaBateria() + this.mediaNotaFantasia() + this.mediaNotaHarmonia())/4;
    }
}

