/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import model.bo.Fornecedor;
import model.bo.Sexo;
import model.bo.SexoNullable;
import model.bo.SexoNulo;

/**
 *
 * @author GABRIEL
 */
public class FornecedorBuilder {
    private int id;
    private String nome;
    private String fone1;
    private String fone2;
    private String email;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String complemento;
    private String dataCadastro;
    private String cpf;
    private String rg;
    private String obs;
    private char status;
    private String razaoSocial;
    private String cnpj;
    private String inscricaoEstadual;
    private String contato;
    
    public FornecedorBuilder(){
        
    }

    public FornecedorBuilder setId(int id) {
        this.id = id;
        return this;   
    }

    public FornecedorBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public FornecedorBuilder setTelefone(String fone1) {
        this.fone1 = fone1;
        return this;
    }

    public FornecedorBuilder setTelefoneReserva(String fone2) {
        this.fone2 = fone2;
        return this;
    }

    public FornecedorBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public FornecedorBuilder setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public FornecedorBuilder setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public FornecedorBuilder setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public FornecedorBuilder setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public FornecedorBuilder setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public FornecedorBuilder setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
        return this;
    }

    public FornecedorBuilder setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public FornecedorBuilder setRg(String rg) {
        this.rg = rg;
        return this;
    }

    public FornecedorBuilder setObs(String obs) {
        this.obs = obs;
        return this;
    }

    public FornecedorBuilder setStatus(char status) {
        this.status = status;
        return this;
    }

    public FornecedorBuilder setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
        return this;
    }

    public FornecedorBuilder setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public FornecedorBuilder setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
        return this;
    }

    public FornecedorBuilder setContato(String contato) {
        this.contato = contato;
        return this;
    }
    
    
    public Fornecedor build(){
        
        
        return new Fornecedor(
                id,
                nome,
                fone1,
                fone2,
                email,
                cep,
                logradouro,
                bairro,
                cidade,
                complemento,
                dataCadastro,
                cpf,
                rg, 
                razaoSocial,
                cnpj, 
                inscricaoEstadual,
                contato,
                obs,
                status
        );
    }
    
    
        
}
