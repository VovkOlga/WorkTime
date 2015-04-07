package account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "screen")
public class Screen {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_screen")
	private long id;

	private String memo;

	@Column(name = "body")
	private byte[] body;

	public Screen() {
	}

	public Screen(String memo, byte[] body) {

		this.memo = memo;
		this.body = body;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public byte[] getBody() {
		return body;
	}

	public void setBody(byte[] body) {
		this.body = body;
	}

}
