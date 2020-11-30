/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328.s20201.prova.p2.ThiagoLopes;

/**
 *
 * @author Thiago
 */

public class App {
    
    public static void main(String [] args){
        
        Dicionario dic = new Dicionario();
        dic.adicionar("livro");
        dic.palavras.get(0).adicionarSignificado("coleção de folhas de papel, impressas ou não, reunidas em cadernos cujos dorsos são unidos por meio de cola, costura etc., formando um volume que se recobre com capa resistente.");
        dic.palavras.get(0).adicionarSignificado("obra de cunho literário, artístico, científico etc. que constitui um volume [Para fins de documentação, é uma publicação não periódica com mais de 48 páginas, além da capa.].");
        dic.adicionar("obra");
        dic.palavras.get(1).adicionarSignificado("aquilo que resulta de um trabalho, de uma ação.");
        dic.palavras.get(1).adicionarSignificado(dic.palavras.get(0).sinonimo.get(1));
        //Dicionario.palavras.get(1).adicionarSignificado("obra de cunho literário, artístico, científico etc. que constitui um volume [Para fins de documentação, é uma publicação não periódica com mais de 48 páginas, além da capa.].");

        dic.listar();
                
    }
    
}
