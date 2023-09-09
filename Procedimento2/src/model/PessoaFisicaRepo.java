/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class PessoaFisicaRepo {

    private final ArrayList<PessoaFisica> pessoaFi = new ArrayList<PessoaFisica>();

    public void inserir(PessoaFisica pf) {
        pessoaFi.add(pf);
    }

    public void alterar(PessoaFisica pf) {
        for (int i = 0; i < pessoaFi.size() - 1; i++) {
            if (pf.getId() == pessoaFi.get(i).getId()) {
                pessoaFi.get(i).setNome(pf.getNome());
                pessoaFi.get(i).setIdade(pf.getIdade());
                pessoaFi.get(i).setCpf(pf.getCpf());
            }
        }
    }

    public void excluir(int id) {
        pessoaFi.remove(obter(id));
    }

    public PessoaFisica obter(int id) {
        PessoaFisica p = new PessoaFisica();
        for (int i = 0; i < pessoaFi.size(); i++) {
            if (pessoaFi.get(i).getId() == id) {
                p = pessoaFi.get(i);

            }
        }

        return p;
    }

    public ArrayList<PessoaFisica> obterTodos() {
        return pessoaFi;
    }

    public void recuperar(String arquivoModel) throws Exception {
        try {

            // Declaring and initializing the string with
            // custom path of a file
            String path = "D:\\dev-teo\\" + arquivoModel + ".fisica.bin";

            // Creating an instance of Inputstream
            InputStream is = new FileInputStream(path);

            // Try block to check for exceptions
            Scanner sc = new Scanner(is, StandardCharsets.UTF_8.name());

            // It holds true till there is single element
            // left in the object with usage of hasNext()
            // method
            while (sc.hasNextLine()) {

                String[] linha = sc.nextLine().split(";");

                PessoaFisica pessoaFisica = new PessoaFisica();
                pessoaFisica.setId(Integer.parseInt(linha[0]));
                pessoaFisica.setNome(linha[1]);
                pessoaFisica.setIdade(Integer.parseInt(linha[2].trim()));
                pessoaFisica.setCpf(linha[3]);

                this.pessoaFi.add(pessoaFisica);
            }

        } catch (Exception e) {
            throw new Exception("Exception message");
        }
    }

    public void persistir(String arquivoModel) throws Exception {

        try {
            Path path = Paths.get("D:\\dev-teo\\" + arquivoModel + ".fisica.bin");

            String banco = "";

            for (int i = 0; i < obterTodos().size(); i++) {
                banco = banco + obterTodos().get(i).getId() + "; ";
                banco = banco + obterTodos().get(i).getNome() + "; ";
                banco = banco + obterTodos().get(i).getCpf() + "; ";
                banco = banco + obterTodos().get(i).getIdade() + "; \n";

            }
            // Custom string as an input
            Files.writeString(path, banco,
                    StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new Exception("Exception message");
        }
    }
}
