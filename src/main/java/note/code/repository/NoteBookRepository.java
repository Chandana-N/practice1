package note.code.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import note.code.model.NoteBook;

public interface NoteBookRepository extends JpaRepository<NoteBook, UUID>{
	
	
	

}
