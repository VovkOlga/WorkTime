package account;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
	
	@Id
	@GeneratedValue
	@Column(name = "id_role")
	private long id;
	
	private String name;

	public Role(){}
public Role(long id, String name) {
	
	this.id = id;
	this.name = name;
}

public Role(String name) {
	this.name = name;
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


}
