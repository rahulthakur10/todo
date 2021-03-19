package com.todo.test;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.todo.test.ToDoRepository.ToDoRepository;
import com.todo.test.ToDoService.ToDoService;
import com.todo.test.ToDoService.ToDoServiceImpl;
import com.todo.test.entities.ToDo;

@ExtendWith(MockitoExtension.class)
class ComTodoListApplicationTests {

	
	@Autowired
	private ToDoService todoService ;
	
	@Mock
	private ToDoRepository todoRepository ;
	
	
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void getAllListTest() {
		Mockito.when(todoRepository.findAll()).thenReturn(Stream.of(new ToDo(1L, "Fruit", false),
				new ToDo(2L,"Shop",false))
				.collect(Collectors.toList()));
		
		Assertions.assertEquals(2, todoService.getFullList().size());
	}
	
	@Test
	void savelistTest() {
		
		ToDo t1  = new ToDo(1L,"Fruit",false);
		todoService.addList(t1);
		Mockito.verify(todoRepository,Mockito.times(1)).save(t1);
		
		
	}
	
	@Test
	void getlistbyIdTest() {
		Long id  = 1L ;
		
		Optional<ToDo> todo = Optional.of(new ToDo(1L,"Rahul",false));
		Mockito.when(todoRepository.findById(id)).thenReturn(todo);
		Assertions.assertEquals(todo, todoService.getOneList(id));
	}
	
	@Test
	void deleteListTest() {
		
		Long id = 1L ;
		
		todoService.deleteList(id);
		Mockito.verify(todoRepository,Mockito.times(1)).deleteById(id);
	}
	

}
