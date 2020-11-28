/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328.s20201.exercicio.exercicio23.exercicio23a;

/**
 *
 * @author Thiago
 */
public class Produto {
    
    private String codigo;
    private String nome;
    private float preco;
    
    public Produto(){
        this.codigo = null;
        this.nome = null;
        this.preco = -1;
    }
    
    public String getCodigo(){
        return this.codigo;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public float getPreco(){
        return this.preco;
    }
    
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setPreco(float preco){
        this.preco = preco;
    }
}
