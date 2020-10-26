/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uff.ic.lleme.tcc00328.s20201.exercicios.exercicio15;

/**
 *
 * @author Thiago
 */
public class ThiagoLopesNascimento {
    
    public static float[] histograma(float[] numeros, float[] categorias){
        int i, pos = 0,a;
        float quant = 0.0f;
        float hist[] = new float[categorias.length - 1];
        for (i = 0; i < numeros.length; i++){
            if (numeros[i] < categorias[pos])
                a = 1;
            else{
                if(pos + 1 == categorias.length - 1){
                    if(categorias[pos] <= numeros[i] && numeros[i] <= categorias[pos + 1])
                        quant ++;
                    else{
                        hist[pos] = quant/numeros.length * 100;
                        quant = 0;
                        i = numeros.length;
                    }
                }
                else{
                    if(categorias[pos] <= numeros[i] && numeros[i] < categorias[pos + 1])
                        quant ++;
                    else{
                        hist[pos] = quant/numeros.length * 100;
                        quant = 0;
                        pos++;
                        i--;
                    }
                }
            }
        }
        return hist;
    }
    
    public static int categoria(float numero, float[] categs){
        int cat = 0;
        if (numero < categs[0] || numero > categs[categs.length - 1])
            return -1;
        while(categs[cat] < numero){
            if (cat + 1 == categs.length)
                if (categs[cat] <= numero && numero <= categs[cat + 1])
                    return cat + 1;
            else
                if (categs[cat] <= numero && numero < categs[cat + 1])
                    return cat + 1;
            cat++;
        }
        return cat;
    }
    
    public static void main(String[] args){
        float numeros[] = {1.2f, 3.4f, 4.7f, 5.7f, 5.9f, 8.0f};  //Exemplo com numero menor e maior que os extremos
        float [] cat = {2.0f, 3.4f, 4.9f, 5.9f};  //Escolha de categorias tendo uma vazia e com numeros junto com os limites de mudança
        float num = 2.6f;
        float [] hist = histograma(numeros, cat);
        System.out.println("O numero " + num + " esta na categoria " + categoria(num, cat));
        num = 5.9f;  // exemplo com o ultimo numero da categoria
        System.out.println("O numero " + num + " esta na categoria " + categoria(num, cat));
        num = 1.0f;  // exemplo de numero menor que as categorias
        System.out.println("O numero " + num + " esta na categoria " + categoria(num, cat));
        num = 6.5f;  // exemplo de numero menor que as categorias
        System.out.println("O numero " + num + " esta na categoria " + categoria(num, cat));
        for(int i = 0; i < hist.length; i ++){
            System.out.println("O percentual de numeros na categoria " + (i + 1) + " e " + hist[i]);
        }
    }
}
