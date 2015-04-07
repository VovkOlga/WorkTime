package account;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "hired")
public class Hired {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_hired")
	private long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_user")
	private User userDeveloper;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_project")
	private Project project;

	public Hired() {
	}

	public Hired(User userDeveloper, Project project) {

		this.userDeveloper = userDeveloper;
		this.project = project;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUserDeveloper() {
		return userDeveloper;
	}

	public void setUserDeveloper(User userDeveloper) {
		this.userDeveloper = userDeveloper;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
