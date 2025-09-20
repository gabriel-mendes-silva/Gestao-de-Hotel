/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import model.bo.Hospede;

/**
 *
 * @author GABRIEL
 */
public class HospedeBuilder {
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

    public HospedeBuilder setId(int id) {
        this.id = id;
        return this;   
    }

    public HospedeBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public HospedeBuilder setTelefone(String fone1) {
        this.fone1 = fone1;
        return this;
    }

    public HospedeBuilder setTelefoneReserva(String fone2) {
        this.fone2 = fone2;
        return this;
    }

    public HospedeBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public HospedeBuilder setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public HospedeBuilder setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public HospedeBuilder setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public HospedeBuilder setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public HospedeBuilder setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public HospedeBuilder setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
        return this;
    }

    public HospedeBuilder setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public HospedeBuilder setRg(String rg) {
        this.rg = rg;
        return this;
    }

    public HospedeBuilder setObs(String obs) {
        this.obs = obs;
        return this;
    }

    public HospedeBuilder setStatus(char status) {
        this.status = status;
        return this;
    }

    public HospedeBuilder setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
        return this;
    }

    public HospedeBuilder setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public HospedeBuilder setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
        return this;
    }

    public HospedeBuilder setContato(String contato) {
        this.contato = contato;
        return this;
    }
    
    public Hospede build(){
        
        
        return new Hospede(
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
