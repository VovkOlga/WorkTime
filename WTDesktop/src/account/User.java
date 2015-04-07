package account;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_user")
	private long id;

	private String login;
	private String password;
	private String email;
	private String name;
	private String surname;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_photo")
	private Photo photo;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_role")
	private Role role;

	public User() {
	}

	public User(String login, String password, String email, String name,
			String surname, Photo photo, Role role) {

		this.login = login;
		this.password = password;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.photo = photo;
		this.role = role;
	}

	public User(String login, String password, String email, String name,
			Photo photo, Role role) {
		this(login, password, email, name, null, photo, role);
	}

	public User(String login, String password, String email, String name,
			Role role) {
		this(login, password, email, name, null, null, role);
	}

	public User(String login, String password, String email, String name,
			String surname, Role role) {
		this(login, password, email, name, surname, null, role);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Photo getPhoto() {
		return photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
