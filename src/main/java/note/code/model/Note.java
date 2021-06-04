package note.code.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Note {
	@Id
private UUID id;
private String title;
private String text;
@ManyToOne(fetch=FetchType.LAZY)
private NoteBook notebook;

private Date lastModifiedOn;
	protected Note() {
		this.id=UUID.randomUUID();
		this.lastModifiedOn=new Date();
		}
	public Note(String id, String title, String text, NoteBook notebook) {
		this(title,text,notebook);
		if(id!=null) {
			this.id=UUID.fromString(id);
		}
	}
	public Note(String title, String text, NoteBook notebook) {
		this();
		this.title = title;
		this.text = text;
		this.notebook = notebook;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public NoteBook getNotebook() {
		return notebook;
	}
	public void setNotebook(NoteBook notebook) {
		this.notebook = notebook;
	}
	public Date getLastModifiedOn() {
		return lastModifiedOn;
	}
	public void setLastModifiedOn(Date lastModifiedOn) {
		this.lastModifiedOn = lastModifiedOn;
	}
	
	
}
