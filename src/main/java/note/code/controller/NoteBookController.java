package note.code.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.catalina.mapper.Mapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import note.code.model.NoteBook;
import note.code.repository.NoteBookRepository;

@RestController
@RequestMapping("/api/notebooks")
@CrossOrigin
public class NoteBookController {
	private NoteBookRepository notebookRepository;
	private Mapper mapper;
	
	public NoteBookController(NoteBookRepository notebookRepository, Mapper mapper) {
		this.notebookRepository=notebookRepository;
		this.mapper=mapper;
	}
	
	@GetMapping("/all")
	public List<NoteBook> all(){
		return notebookRepository.findAll() ;
		
	}
	@PostMapping
	public NoteBook save(@RequestBody NoteBook noteBook) {
		return notebookRepository.save(noteBook);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id){
		notebookRepository.deleteById(UUID.fromString(id));
	}
	
	
	
	
	
	

}
