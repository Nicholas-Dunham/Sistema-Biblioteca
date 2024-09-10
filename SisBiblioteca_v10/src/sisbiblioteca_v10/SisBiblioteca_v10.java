
package sisbiblioteca_v10;

import java.io.*;
import java.util.Scanner;

public class SisBiblioteca_v10 {

    static Livro[] livros = new Livro[1000];
    static Revista[] revistas = new Revista[1000];
    static int i = 0, j = 0;  // Contadores de livros e revistas

    public static void cadastroLivro() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Informe o nome do livro: ");
        String nomelivro = inp.nextLine();

        System.out.println("Informe o nome do autor: ");
        String autor = inp.nextLine();

        System.out.println("Informe o ISBN: ");
        String ISBN = inp.nextLine();

        System.out.println("Informe o ano de publicação: ");
        String ano = inp.nextLine();

        System.out.println("Informe a editora: ");
        String editora = inp.nextLine();

        System.out.println("Informe a edição: ");
        int edicao = Integer.parseInt(inp.nextLine());

        System.out.println("Informe a prateleira: ");
        String prateleira = inp.nextLine();

        System.out.println("Informe a seção: ");
        String secao = inp.nextLine();

        System.out.println("Informe o CDD: ");
        String CDD = inp.nextLine();

        livros[i] = new Livro(nomelivro, autor, ISBN, ano, editora, prateleira, secao, CDD, edicao);
        i++;
        System.out.println("Livro cadastrado com sucesso!");
       
    }

    public static void cadastroRevista() {
        Scanner inp = new Scanner(System.in);
        System.out.println("Informe o nome da revista: ");
        String nomeRevista = inp.nextLine();

        System.out.println("Informe o nome do autor: ");
        String autor = inp.nextLine();

        System.out.println("Informe o ISSN: ");
        String ISSN = inp.nextLine();

        System.out.println("Informe o ano de publicação: ");
        String ano = inp.nextLine();

        System.out.println("Informe a editora: ");
        String editora = inp.nextLine();

        System.out.println("Informe a edição: ");
        int edicao = Integer.parseInt(inp.nextLine());

        System.out.println("Informe a prateleira: ");
        String prateleira = inp.nextLine();

        System.out.println("Informe a seção: ");
        String secao = inp.nextLine();

        System.out.println("Informe o CDD: ");
        String CDD = inp.nextLine();

        revistas[j] = new Revista(nomeRevista, autor, ISSN, ano, editora, prateleira, secao, CDD, edicao);
        j++;
        System.out.println("Revista cadastrada com sucesso!");
        
    }

    public static void busca(String chave) {
        System.out.println("Resultados da busca para: " + chave);

        for (int k = 0; k < i; k++) {
            if (livros[k].getNomelivro().toLowerCase().contains(chave.toLowerCase())
                    || livros[k].getAutor().toLowerCase().contains(chave.toLowerCase())) {
                System.out.println("Livro: " + (k + 1) + " - " + livros[k].getNomelivro());
            }
        }

        for (int k = 0; k < j; k++) {
            if (revistas[k].getNomeRevista().toLowerCase().contains(chave.toLowerCase())
                    || revistas[k].getAutor().toLowerCase().contains(chave.toLowerCase())) {
                System.out.println("Revista: " + (k + 1) + " - " + revistas[k].getNomeRevista());
            }
        }
    }

    public static void listarLivros() {
        System.out.println("Listagem de livros:");
        for (int k = 0; k < i; k++) {
            System.out.println((k + 1) + " - " + livros[k].getNomelivro() + ", " + livros[k].getAutor());
        }
    }

    public static void listarRevistas() {
        System.out.println("Listagem de revistas:");
        for (int k = 0; k < j; k++) {
            System.out.println((k + 1) + " - " + revistas[k].getNomeRevista() + ", " + revistas[k].getAutor());
        }
    }

    public static void excluirLivro(int index) {
        if (index >= 0 && index < i) {
            for (int k = index; k < i - 1; k++) {
                livros[k] = livros[k + 1];
            }
            livros[i - 1] = null;
            i--;
            System.out.println("Livro excluído com sucesso.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public static void excluirRevista(int index) {
        if (index >= 0 && index < j) {
            for (int k = index; k < j - 1; k++) {
                revistas[k] = revistas[k + 1];
            }
            revistas[j - 1] = null;
            j--;
            System.out.println("Revista excluída com sucesso.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // Método para salvar dados em arquivo de texto
    public static void salvarDadosEmArquivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("biblioteca.txt"))) {
            for (int k = 0; k < i; k++) {
                writer.write("Livro;" + livros[k].getNomelivro() + ";" + livros[k].getAutor() + ";" + livros[k].getISBN() + ";" +
                        livros[k].getAno() + ";" + livros[k].getEditora() + ";" + livros[k].getPrateleira() + ";" +
                        livros[k].getSeção() + ";" + livros[k].getCDD() + ";" + livros[k].getEdição());
                writer.newLine();
            }
            for (int k = 0; k < j; k++) {
                writer.write("Revista;" + revistas[k].getNomeRevista() + ";" + revistas[k].getAutor() + ";" + revistas[k].getISSN() + ";" +
                        revistas[k].getAno() + ";" + revistas[k].getEditora() + ";" + revistas[k].getPrateleira() + ";" +
                        revistas[k].getSecao() + ";" + revistas[k].getCDD() + ";" + revistas[k].getEdicao());
                writer.newLine();
            }
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    // Método para carregar dados do arquivo de texto
    public static void carregarDadosDoArquivo() {
        try (BufferedReader reader = new BufferedReader(new FileReader("biblioteca.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(";");
                if (dados[0].equals("Livro")) {
                    livros[i] = new Livro(dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], dados[7], dados[8], Integer.parseInt(dados[9]));
                    i++;
                } else if (dados[0].equals("Revista")) {
                    revistas[j] = new Revista(dados[1], dados[2], dados[3], dados[4], dados[5], dados[6], dados[7], dados[8], Integer.parseInt(dados[9]));
                    j++;
                }
            }
            System.out.println("Dados carregados com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        carregarDadosDoArquivo();  // Carregar os dados do arquivo ao iniciar o programa

        String retorno;
        do {
            System.out.println("*******************************");
            System.out.println("* Sistema de Cadastro de Livros e Revistas *");
            System.out.println("*******************************");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Cadastrar revista");
            System.out.println("3 - Buscar livro/revista");
            System.out.println("4 - Listar livros/revistas");
            System.out.println("5 - Excluir livro/revista");
            System.out.println("6 - Salvar dados");
            System.out.println("7 - Encerrar programa");

            retorno = inp.nextLine();
            
            switch (retorno) {
                case "1":
                    cadastroLivro();
                    break;
                case "2":
                    cadastroRevista();
                    break;
                case "3":
                    System.out.println("Informe a palavra chave para busca:");
                    String chave = inp.nextLine();
                    busca(chave);
                    break;
                case "4":
                    listarLivros();
                    listarRevistas();
                    break;
                case "5":
                    System.out.println("1 - Excluir Livro");
                    System.out.println("2 - Excluir Revista");
                    String tipo = inp.nextLine();
                    if (tipo.equals("1")) {
                        try {
                            System.out.println("Qual livro deseja excluir? Informe o índice:");
                            listarLivros();
                            String input = inp.nextLine();
                            int indexLivro = Integer.parseInt(input) - 1;
                    
                            // Verifica se o índice está dentro dos limites
                            if (indexLivro >= 0 && indexLivro < livros.length && livros[indexLivro] != null) {
                                excluirLivro(indexLivro);
                                System.out.println("Livro excluído com sucesso.");
                            } else {
                                System.out.println("Índice inválido! O livro não existe.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida! Por favor, insira um número.");
                        } catch (Exception e) {
                            System.out.println("Ocorreu um erro inesperado ao excluir o livro.");
                        }
                    } else if (tipo.equals("2")) {
                        try {
                            System.out.println("Qual revista deseja excluir? Informe o índice:");
                            listarRevistas();
                            String input = inp.nextLine();
                            int indexRevista = Integer.parseInt(input) - 1;
                    
                            // Verifica se o índice está dentro dos limites
                            if (indexRevista >= 0 && indexRevista < revistas.length && revistas[indexRevista] != null) {
                                excluirRevista(indexRevista);
                                System.out.println("Revista excluída com sucesso.");
                            } else {
                                System.out.println("Índice inválido! A revista não existe.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida! Por favor, insira um número.");
                        } catch (Exception e) {
                            System.out.println("Ocorreu um erro inesperado ao excluir a revista.");
                        }
                    }
                    
                    break;
                case "6":
                    salvarDadosEmArquivo();
                    break;
                case "7":
                    System.out.println("Fim do programa");
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        } while (!retorno.equals("7"));

        inp.close();
    }
}
