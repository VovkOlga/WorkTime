package account;

import java.util.Date;

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
@Table(name = "work_time")
public class WorkTimes {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_work_time")
	private long id;

	private Date date;

	@Column(name = "end_date")
	private Date endTime;

	@Column(name = "start_date")
	private Date startTime;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_screen")
	private Screen screen;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_activity")
	private Activity activity;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_hired")
	private Hired hired;

	public WorkTimes() {
	}

	public WorkTimes(Date date, Date endTime, Date startTime, Screen screen,
			Activity activity, Hired hired) {

		this.date = date;
		this.endTime = endTime;
		this.startTime = startTime;
		this.screen = screen;
		this.activity = activity;
		this.hired = hired;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Hired getHired() {
		return hired;
	}

	public void setHired(Hired hired) {
		this.hired = hired;
	}

}
