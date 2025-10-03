package com.mensalista;

public class Main {
    public static void main(String[] args) throws Exception {
        StatusClient statusClient = new StatusClient();
        System.out.println("Status: " + statusClient.getStatus());

        CriarMensalistaClient criar = new CriarMensalistaClient();
        String novo = criar.criarMensalista("{\"matricula\":\"123\",\"nome\":\"João\",\"salario\":2500.0}");
        System.out.println("Criado: " + novo);

        ListarMensalistasClient listar = new ListarMensalistasClient();
        System.out.println("Lista: " + listar.listar());

        BuscarMensalistaClient buscar = new BuscarMensalistaClient();
        System.out.println("Buscar 123: " + buscar.buscarPorMatricula("123"));
    }
}