package note.code.repository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import note.code.model.Note;
import note.code.model.NoteBook;
/*
 * This component will only execute (and get instantiated) if the
 * property "noteit.db.recreate" is set to true in the
 * application.properties file
 * 
 * */
 

@Component
@ConditionalOnProperty(name="noteit.db.recreate", havingValue="true")
public class DbSeeder implements CommandLineRunner{
	private NoteBookRepository notebookRepository;
	private NoteRepository noteRepository;
	
	public DbSeeder(NoteBookRepository notebookRepository, NoteRepository noteRepository) {
		this.notebookRepository=notebookRepository;
		this.noteRepository=noteRepository;
	}
	

	@Override
	public void run(String... args) throws Exception {
		//remove all existing entities
		this.notebookRepository.deleteAll();
		this.noteRepository.deleteAll();
		
		//save a default notebook
		NoteBook defaultNoteBook=new NoteBook("Default");
		this.notebookRepository.save(defaultNoteBook);
		
		NoteBook quotesNoteBook=new NoteBook("Quotes");
		this.notebookRepository.save(quotesNoteBook);
		
		//save the welcome note
		Note note=new Note("hello","welcome to note it", defaultNoteBook);
		this.noteRepository.save(note);
		
		System.out.println("Initialized database");
		
		
		
	}

}
