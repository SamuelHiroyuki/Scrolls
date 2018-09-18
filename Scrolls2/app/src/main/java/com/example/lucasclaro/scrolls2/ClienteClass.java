package com.example.lucasclaro.scrolls2;

import java.io.Serializable;

    public class ClienteClass implements Serializable {
        int Id;
        String Nome;
        String Sobrenome;
        String Email;
        String Cpf;
        String Senha;

        public ClienteClass (int id,String nome, String sobrenome, String email,String cpf, String senha){
            this.Id =id;
            this.Nome = nome;
            this.Sobrenome = sobrenome;
            this.Email = email;
            this.Cpf = cpf;
            this.Senha = senha;
        }
        public ClienteClass(){
            this.Id =0;
            this.Nome = null;
            this.Sobrenome = null;
            this.Email = null;
            this.Cpf = null;
            this.Senha = null;
        }
    }

