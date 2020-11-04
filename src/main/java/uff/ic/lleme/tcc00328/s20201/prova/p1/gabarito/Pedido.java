package uff.ic.lleme.tcc00328.s20201.prova.p1.gabarito;

import java.util.*;


public class Pedido {

    public int mesa;
    public Date inicio;
    public Date fechamento;
    public Integer numero = null;
    public Item[] itens = new Item[10];

    public double valor() {
        double valor = 0;
        for (Item item : itens)
            if (item != null)
                valor += item.prato.valor;
        return valor;
    }
}
