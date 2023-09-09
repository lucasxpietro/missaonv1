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
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class PessoaJuridicaRepo {

    private final ArrayList<PessoaJuridica> pessoaJu = new ArrayList<PessoaJuridica>();

    public void inserir(PessoaJuridica pj) {
        pessoaJu.add(pj);
    }

    public void alterar(PessoaJuridica pj) {
        for (int i = 0; i < pessoaJu.size() - 1; i++) {
            if (pj.getId() == pessoaJu.get(i).getId()) {
                pessoaJu.get(i).setNome(pj.getNome());
                pessoaJu.get(i).setCnpj(pj.getCnpj());
                pessoaJu.get(i).setId(pj.getId());
            }
        }
    }

    public void excluir(int id) {
        pessoaJu.remove(obter(id));
    }

    public PessoaJuridica obter(int id) {
        PessoaJuridica j = new PessoaJuridica();
        for (int i = 0; i < pessoaJu.size(); i++) {
            if(pessoaJu.get(i).getId() == id){
                j = pessoaJu.get(i);
            }
            
        }
        return j;
    }

    public ArrayList<PessoaJuridica> obterTodos() {
        return pessoaJu;
    }

    public void recuperar(String arquivoModel) throws Exception {
        try {

            // Declaring and initializing the string with
            // custom path of a file
            String path = "D:\\dev-teo\\" + arquivoModel + ".juridica.bin";

            // Creating an instance of Inputstream
            InputStream is = new FileInputStream(path);

            // Try block to check for exceptions
            Scanner sc = new Scanner(is, StandardCharsets.UTF_8.name());

            // It holds true till there is single element
            // left in the object with usage of hasNext()
            // method
            while (sc.hasNextLine()) {

                // Printing the content of file
                String[] linha = sc.nextLine().split(";");

                PessoaJuridica pessoaJuridica = new PessoaJuridica();
                pessoaJuridica.setId(Integer.parseInt(linha[0]));
                pessoaJuridica.setNome(linha[1]);
                pessoaJuridica.setCnpj(linha[3]);

                this.pessoaJu.add(pessoaJuridica);
            }

        } catch (Exception e) {
            throw new Exception("Exception message");
        }
    }

    public void persistir(String arquivoModel) throws Exception {
        try {
            Path path = Paths.get("D:\\dev-teo\\" + arquivoModel + ".juridica.bin");

            String banco = "";

            for (int i = 0; i < obterTodos().size(); i++) {
                banco = banco + obterTodos().get(i).getId() + "; ";
                banco = banco + obterTodos().get(i).getNome() + "; ";
                banco = banco + obterTodos().get(i).getCnpj() + "; \n";                

            }
            // Custom string as an input
            Files.writeString(path, banco,
                    StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new Exception("Exception message");
        }
    }
}
