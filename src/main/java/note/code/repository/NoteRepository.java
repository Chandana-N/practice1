package note.code.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import note.code.model.Note;
import note.code.model.NoteBook;

public interface NoteRepository extends JpaRepository<Note, UUID> {
	List<Note> findAllByNoteBook(NoteBook notebook);

}
