package model;

import java.io.*;
import java.util.*;

public class MainApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Repositórios de pessoas físicas e jurídicas
        PessoaFisicaRepo pessoaFisicaRepo = new PessoaFisicaRepo();
        PessoaJuridicaRepo pessoaJuridicaRepo = new PessoaJuridicaRepo();

        int escolha;
        do {
            System.out.println("Menu de Opções:");
            System.out.println("1. Incluir Pessoa");
            System.out.println("2. Alterar Pessoa");
            System.out.println("3. Excluir Pessoa");
            System.out.println("4. Exibir Pessoa pelo ID");
            System.out.println("5. Exibir Todas as Pessoas");
            System.out.println("6. Salvar Dados em Arquivos");
            System.out.println("7. Recuperar Dados dos Arquivos");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (escolha) {
                case 1:
                    incluirPessoa(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 2:
                    alterarPessoa(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 3:
                    excluirPessoa(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 4:
                    exibirPessoaPorId(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 5:
                    exibirTodasAsPessoas(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 6:
                    salvarDados(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 7:
                    recuperarDados(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (escolha != 0);

        scanner.close();
    }

    public static void incluirPessoa(Scanner scanner, PessoaFisicaRepo pessoaFisicaRepo, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.println("Escolha o tipo de Pessoa:");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica");
        System.out.print("Digite a opção: ");
        int tipoPessoa = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        if (tipoPessoa == 1) {
            cadastrarPessoaFisica(scanner, pessoaFisicaRepo);
        } else if (tipoPessoa == 2) {
            cadastrarPessoaJuridica(scanner, pessoaJuridicaRepo);
        } else {
            System.out.println("Opção inválida.");
        }
    }

    public static void cadastrarPessoaFisica(Scanner scanner, PessoaFisicaRepo pessoaFisicaRepo) {
        // Implemente a lógica para cadastrar uma Pessoa Física
    }

    public static void cadastrarPessoaJuridica(Scanner scanner, PessoaJuridicaRepo pessoaJuridicaRepo) {
        // Implemente a lógica para cadastrar uma Pessoa Jurídica
    }

    // Implemente os métodos alterarPessoa, excluirPessoa, exibirPessoaPorId,
    // exibirTodasAsPessoas, salvarDados, recuperarDados conforme a descrição do seu projeto.
}
