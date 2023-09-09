/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cadastropoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;

/**
 *
 * @author Usuario
 */
public class CadastroPOO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));

        String opcao = "";

        PessoaFisicaRepo repo_fisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repo_juridica = new PessoaJuridicaRepo();

        while (!"8".equals(opcao)) {
            System.out.println("1 - Incluir pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo ID");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Persistir Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("8 - Finalizar Programa");

            System.out.println("---------------------------------------------");

            // Reading data using readLine
            opcao = reader.readLine();

            // Printing the read line
            System.out.println(opcao);

            String pessoa = "";

            switch (opcao) {

                case "1" -> {
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    pessoa = reader.readLine();
                    switch (pessoa) {
                        case "F" -> {
                            PessoaFisica p = new PessoaFisica();
                            System.out.println("Digite o CPF do usuário");
                            p.setCpf(reader.readLine());
                            System.out.println("Digite a Idade do usuário");
                            p.setIdade(Integer.parseInt(reader.readLine()));
                            System.out.println("Digite o Id do usuário");
                            p.setId(Integer.parseInt(reader.readLine()));
                            System.out.println("Digite o Nome do usuário");
                            p.setNome(reader.readLine());
                            repo_fisica.inserir(p);
                        }
                        case "J" -> {
                            PessoaJuridica j = new PessoaJuridica();
                            System.out.println("Digite o CNPJ do usuário");
                            j.setCnpj(reader.readLine());
                            System.out.println("Digite o Id do usuário");
                            j.setId(Integer.parseInt(reader.readLine()));
                            System.out.println("Digite o Nome do usuário");
                            j.setNome(reader.readLine());
                            repo_juridica.inserir(j);
                        }
                    }
                }

                case "2" -> {
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    pessoa = reader.readLine();
                    switch (pessoa) {
                        case "F" -> {
                            System.out.println("Digite o Id que deseja alterar: ");
                            int id = Integer.parseInt(reader.readLine());
                            PessoaFisica pf = repo_fisica.obter(id);
                            System.out.println("CPF Antigo: " + pf.getCpf());
                            System.out.println("Digite o novo CPF do usuário");
                            pf.setCpf(reader.readLine());
                            System.out.println("Idade Antigo: " + pf.getIdade());
                            System.out.println("Digite a nova Idade do usuário");
                            pf.setIdade(Integer.parseInt(reader.readLine()));
                            System.out.println("Nome Antigo: " + pf.getNome());
                            System.out.println("Digite o novo Nome do usuário");
                            pf.setNome(reader.readLine());
                            repo_fisica.alterar(pf);
                            repo_fisica.obter(pf.getId());

                        }
                        case "J" -> {
                            System.out.println("Digite o Id que deseja alterar: ");
                            int id = Integer.parseInt(reader.readLine());
                            PessoaJuridica pj = repo_juridica.obter(id);
                            System.out.println("CNPJ Antigo: " + pj.getCnpj());
                            System.out.println("Digite o novo CNPJ do usuário");
                            pj.setCnpj(reader.readLine());
                            System.out.println("Nome Antigo: " + pj.getNome());
                            System.out.println("Digite o novo Nome do usuário");
                            pj.setNome(reader.readLine());
                            repo_juridica.alterar(pj);
                            repo_juridica.obter(pj.getId());
                        }
                    }
                }

                case "3" -> {
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    pessoa = reader.readLine();
                    switch (pessoa) {
                        case "F" -> {
                            System.out.println("Digite o Id do usuário");
                            int id = Integer.parseInt(reader.readLine());
                            repo_fisica.excluir(id);

                        }
                        case "J" -> {
                            System.out.println("Digite o Id do usuário");
                            int id = Integer.parseInt(reader.readLine());
                            repo_juridica.excluir(id);
                        }
                    }
                }

                case "4" -> {
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    pessoa = reader.readLine();
                    switch (pessoa) {
                        case "F" -> {
                            System.out.println("Digite o Id do usuário");
                            int id = Integer.parseInt(reader.readLine());
                            PessoaFisica pf = repo_fisica.obter(id);
                            System.out.println("Id: " + pf.getId());
                            System.out.println("CPF: " + pf.getCpf());
                            System.out.println("Idade: " + pf.getIdade());
                            System.out.println("Nome: " + pf.getNome());

                        }
                        case "J" -> {
                            System.out.println("Digite o Id do usuário");
                            int id = Integer.parseInt(reader.readLine());
                            PessoaJuridica pj = repo_juridica.obter(id);
                            System.out.println("Id: " + pj.getId());
                            System.out.println("CNPJ: " + pj.getCnpj());
                            System.out.println("Nome: " + pj.getNome());
                        }
                    }
                }

                case "5" -> {
                    System.out.println("F - Pessoa Fisica | J - Pessoa Juridica");
                    pessoa = reader.readLine();
                    switch (pessoa) {
                        case "F" -> {
                            for (int i = 0; i < repo_fisica.obterTodos().size(); i++) {
                                System.out.println("id:" + repo_fisica.obterTodos().get(i).getId());
                                System.out.println("Nome:" + repo_fisica.obterTodos().get(i).getNome());
                                System.out.println("CPF:" + repo_fisica.obterTodos().get(i).getCpf());
                            }
                        }
                        case "J" -> {
                            for(int i = 0; i < repo_juridica.obterTodos().size(); i++){
                                System.out.println("id:" + repo_juridica.obterTodos().get(i).getId());
                                System.out.println("Nome:" + repo_juridica.obterTodos().get(i).getNome());
                                System.out.println("CNPJ:" + repo_juridica.obterTodos().get(i).getCnpj());
                            }
                        }
                    }
                }

                case "6" -> {
                    System.out.println("Qual o prefixo dos arquivos: ");
                    String arquivoP = reader.readLine();
                    repo_fisica.persistir(arquivoP);
                    repo_juridica.persistir(arquivoP);
                }

                case "7" -> {
                    System.out.println("Qual o prefixo dos arquivos: ");
                    String arquivoP = reader.readLine();
                    repo_fisica.recuperar(arquivoP);
                    repo_juridica.recuperar(arquivoP);
                    
                }

                case "8" -> {
                    System.out.println("Fechando o sistema");
                }

                default -> {
                }

            }
        }
    }

}
