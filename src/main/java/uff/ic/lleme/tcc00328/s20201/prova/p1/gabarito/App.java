package uff.ic.lleme.tcc00328.s20201.prova.p1.gabarito;

import java.io.*;

import java.util.*;

public abstract class App {

    public static Prato[] pratos;
    public static Pedido[] pedidos;

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "src/main/java/uff/ic/lleme/tcc00328/s20201/prova/p1/gabarito/pratos.txt";
        pratos = carregarPratos(filename);

        filename = "src/main/java/uff/ic/lleme/tcc00328/s20201/prova/p1/gabarito/pedidos.txt";
        pedidos = carregarPedidos(filename, pratos);

        Scanner sc = new Scanner(System.in);
        System.out.println("Informe numero de pedido: ");
        System.out.println(buscarPedido(sc.nextInt()).valor());

        double[] histograma = calcularHistograma();
        imprimirHistograma(histograma);
    }

    public static Prato[] carregarPratos(String filename) throws FileNotFoundException {
        Prato[] pratos = new Prato[5];
        InputStream is = new FileInputStream(filename);
        Scanner sc = new Scanner(is);
        int i = 0;
        while (sc.hasNext()) {
            double valor = sc.nextDouble();
            String nome = sc.nextLine();
            Prato prato = new Prato();
            prato.numero = i; // *** ATENCAO ***
            prato.nome = nome;
            prato.valor = valor;
            pratos[i++] = prato;
        }
        return pratos;
    }

    public static Pedido[] carregarPedidos(String filename, Prato[] pratos) throws FileNotFoundException {
        Pedido[] pedidos = new Pedido[10000];
        InputStream is = new FileInputStream(filename);
        Scanner sc = new Scanner(is);

        Pedido pedido = null;
        int i = 0, j = 0;
        while (sc.hasNext()) {
            int numero = sc.nextInt();
            int quantidade = sc.nextInt();
            String nomePrato = sc.nextLine();
            Prato prato = buscarPrato(nomePrato);

            if (pedido == null || pedido.numero != numero) {
                pedido = new Pedido();
                pedidos[j++] = pedido;
                i = 0;
            }

            Item item = new Item();
            item.prato = prato;
            item.quantidade = quantidade;
            pedido.itens[i++] = item;
            pedido.numero = numero;
        }
        return pedidos;
    }

    public static Prato buscarPrato(String nome) {
        for (Prato prato : pratos)
            if (prato != null && prato.nome.equals(nome))
                return prato;
        return null;
    }

    public static Pedido buscarPedido(int numero) {
        for (Pedido pedido : pedidos)
            if (pedido != null && pedido.numero == numero)
                return pedido;
        return null;
    }


    public static double[] calcularHistograma() {
        double[] histograma = new double[pratos.length];
        double totalPedidos = 0;
        for (Pedido pedido : pedidos)
            if (pedido != null)
                for (Item item : pedido.itens)
                    if (item != null) {
                        histograma[item.prato.numero] += item.quantidade;
                        totalPedidos += item.quantidade;
                    }
        for (int i = 0; i < histograma.length; i++)
            if (totalPedidos > 0)
                histograma[i] /= totalPedidos;
        return histograma;
    }

    public static void imprimirHistograma(double[] histograma) {
        for (int i = 0; i < histograma.length; i++) {
            String prato = "   " + i;
            System.out.println(prato.substring(prato.length() - 3) + ": " +
                               new String(new char[(int) (100 * histograma[i])]).replace("\0", "X") + "|-> " +
                               histograma[i] + "%");
        }

    }
}
