package note.code.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import note.code.model.Note;
import note.code.model.NoteBook;
import note.code.repository.NoteRepository;

@RestController
@RequestMapping("/api/note")
@CrossOrigin
public class NoteController {
	
	private NoteRepository noteRepository;
	@GetMapping("/all")
	public List<Note> all(){
		return noteRepository.findAll() ;
		
	}
	@PostMapping
	public Note save(@RequestBody Note note) {
		return noteRepository.save(note);
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id){
		noteRepository.deleteById(UUID.fromString(id));
	}

}
