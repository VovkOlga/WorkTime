package account;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "photos")
public class Photo {
	@Id
	@GeneratedValue
	@Column(name = "id_photo")
	private long id;
	private String name;
	
	@Column(name = "bytes")
	private byte[] body;

	public Photo() {
	}

	public Photo(String path) {

		path = path.trim();
		Path p = Paths.get(path);

		File f = new File(path);
		this.name = f.getName();
		try {
			this.body = Files.readAllBytes(p);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Photo(String name, byte[] body) {
		this.name = name;
		this.body = body;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getBody() {
		return body;
	}

	public void setBody(byte[] body) {
		this.body = body;
	}

}
