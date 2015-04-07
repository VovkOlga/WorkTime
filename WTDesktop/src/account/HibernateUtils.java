package account;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.commons.codec.digest.DigestUtils;

public class HibernateUtils {

	private static final String PERSISTENT_UNIT_NAME = "AccountingJPA";

	private static final EntityManager emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME)
					.createEntityManager();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static User isUserExist(String login, String password) {
		List<User> list = new ArrayList<>();
		Query query = emf
				.createQuery(
						"SELECT u FROM User u WHERE u.login=:login AND u.password=:password",
						User.class);
		query.setParameter("login", login);
		String md5 = DigestUtils.md5Hex(password);
		query.setParameter("password", md5);
		list = query.getResultList();

		if (list.size() == 0) {
			return null;
		}

		return list.get(0);
	}

}