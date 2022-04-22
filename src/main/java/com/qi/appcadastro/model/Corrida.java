package com.qi.appcadastro.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Corrida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long codigo;
	
private String nome;
private String Sexo;
private String tipo;
private int cilindrada;
private String tempo;

public Long getCodigo() {
	return codigo;
}
public void setCodigo(Long codigo) {
	this.codigo = codigo;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getSexo() {
	return Sexo;
}
public void setSexo(String sexo) {
	Sexo = sexo;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public int getCilindrada() {
	return cilindrada;
}
public void setCilindrada(int cilindrada) {
	this.cilindrada = cilindrada;
}
public String getTempo() {
	return tempo;
}
public void setTempo(String tempo) {
	this.tempo = tempo;
}
}
