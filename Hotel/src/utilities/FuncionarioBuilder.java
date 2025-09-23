/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import model.bo.Funcionario;
import model.bo.Sexo;
import model.bo.SexoNullable;
import model.bo.SexoNulo;

/**
 *
 * @author GABRIEL
 */
public class FuncionarioBuilder {
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
    private String usuario;
    private String senha;
    private Sexo sexo;
    
    public FuncionarioBuilder(){
        this.sexo = new SexoNulo();
    }

    public FuncionarioBuilder setId(int id) {
        this.id = id;
        return this;   
    }

    public FuncionarioBuilder setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public FuncionarioBuilder setTelefone(String fone1) {
        this.fone1 = fone1;
        return this;
    }

    public FuncionarioBuilder setTelefoneReserva(String fone2) {
        this.fone2 = fone2;
        return this;
    }

    public FuncionarioBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public FuncionarioBuilder setCep(String cep) {
        this.cep = cep;
        return this;
    }

    public FuncionarioBuilder setLogradouro(String logradouro) {
        this.logradouro = logradouro;
        return this;
    }

    public FuncionarioBuilder setBairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public FuncionarioBuilder setCidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public FuncionarioBuilder setComplemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public FuncionarioBuilder setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
        return this;
    }

    public FuncionarioBuilder setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public FuncionarioBuilder setRg(String rg) {
        this.rg = rg;
        return this;
    }

    public FuncionarioBuilder setObs(String obs) {
        this.obs = obs;
        return this;
    }

    public FuncionarioBuilder setStatus(char status) {
        this.status = status;
        return this;
    }

    public FuncionarioBuilder setUsuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    public FuncionarioBuilder setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    
    
    public FuncionarioBuilder setSexo(Sexo sexo){
        this.sexo = sexo;
        return this;
    }
    
    public Funcionario build(){
        
        
        return new Funcionario(
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
                usuario,
                senha,
                obs,
                status,
                sexo
        );
    }
    
    
        
}
