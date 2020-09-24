package com.agenda.online.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.agenda.online.model.User;

@Entity
@Table(name = "annotation")
public class Annotation
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private User users_id;
	
	private String name;
	private String descricao;
	private String data;
	
	public Annotation() {
	}
	
	public Annotation(Long id, String name, String descricao, String data) {
		super();
		this.id = id;
		this.name = name;
		this.descricao = descricao;
		this.data = data;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}	
}
