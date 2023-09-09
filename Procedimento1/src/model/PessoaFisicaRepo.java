package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaRepo {
    private List<PessoaFisica> pessoasFisicas;
    private final String arquivo;

    public PessoaFisicaRepo(String arquivo) {
        this.arquivo = arquivo;
        pessoasFisicas = new ArrayList<>();
    }

    public void inserir(PessoaFisica pessoaFisica) {
        pessoasFisicas.add(pessoaFisica);
    }

    public void alterar(PessoaFisica pessoaFisicaNova) {
        for (int i = 0; i < pessoasFisicas.size(); i++) {
            PessoaFisica pessoaFisica = pessoasFisicas.get(i);
            if (pessoaFisica.getId() == pessoaFisicaNova.getId()) {
                pessoasFisicas.set(i, pessoaFisicaNova);
                break;
            }
        }
    }

    public void excluir(int id) {
        pessoasFisicas.removeIf(pessoaFisica -> pessoaFisica.getId() == id);
    }

    public PessoaFisica obter(int id) {
        for (PessoaFisica pessoaFisica : pessoasFisicas) {
            if (pessoaFisica.getId() == id) {
                return pessoaFisica;
            }
        }
        return null;
    }

    public List<PessoaFisica> obterTodos() {
        return pessoasFisicas;
    }

    public void persistir() throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(arquivo))) {
            outputStream.writeObject(pessoasFisicas);
        }
    }

    public void recuperar() throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(arquivo))) {
            pessoasFisicas = (List<PessoaFisica>) inputStream.readObject();
        }
    }
}
