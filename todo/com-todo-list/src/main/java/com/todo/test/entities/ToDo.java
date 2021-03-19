package com.todo.test.entities;


import lombok.Data;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Data
@Table(name = "todolist1")

public class ToDo {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private boolean isCompleted ;
    
    
    
	public ToDo(Long id, String name, boolean isCompleted) {
		super();
		this.id = id;
		this.name = name;
		this.isCompleted = isCompleted;
	}
	
	
	
	
	public ToDo() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Long getId() {
		return id;
	}
	public void setId(Long i) {
		this.id = i;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}




	@Override
	public String toString() {
		return "ToDo [id=" + id + ", name=" + name + ", isCompleted=" + isCompleted + "]";
	}




	





	

}
