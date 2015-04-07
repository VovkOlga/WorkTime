package account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "activity")
public class Activity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_activity")
	private long id;

	@Column(name = "number_click")
	private long numberClick;

	@Column(name = "number_enter")
	private long numberEnter;

	public Activity() {
	}

	public Activity(long numberClick, long numberEnter) {

		this.numberClick = numberClick;
		this.numberEnter = numberEnter;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getNumberClick() {
		return numberClick;
	}

	public void setNumberClick(long numberClick) {
		this.numberClick = numberClick;
	}

	public long getNumberEnter() {
		return numberEnter;
	}

	public void setNumberEnter(long numberEnter) {
		this.numberEnter = numberEnter;
	}

}
