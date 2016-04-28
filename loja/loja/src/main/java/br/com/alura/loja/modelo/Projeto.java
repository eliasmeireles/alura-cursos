package br.com.alura.loja.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

public class Projeto {
	private long id;
	private String nome;
	private int anoDeInicio;
	private List<Projeto> projetos = new ArrayList<Projeto>();

	public Projeto(long id, String nome, int anoDeInicio) {
		this.nome = nome;
		this.id = id;
		this.anoDeInicio = anoDeInicio;
	}

	public Projeto() {
	}

	public void remove(long projetoId) {
		for (Iterator iterator = projetos.iterator(); iterator.hasNext();) {
			Projeto projeto = (Projeto) iterator.next();
		
			if (projeto.getId() == projetoId) {
				iterator.remove();
			}
		}
	}

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAnoDeInicio() {
		return anoDeInicio;
	}

	public void setAnoDeInicio(int anoDeInicio) {
		this.anoDeInicio = anoDeInicio;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	public String toXml() {
		return new XStream().toXML(this);
	}

	public String toJson() {
		return new Gson().toJson(this);
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

}
