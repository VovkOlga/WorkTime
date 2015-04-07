package account;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountDAOImpl implements AccountDAO {

	@Autowired
	private EntityManager entityManager;

	@Override
	public byte[] getPhoto(long id) {
		try {
			Photo photo = entityManager.find(Photo.class, id);
			return photo.getBody();
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public void addUser(User u) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(u);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			entityManager.getTransaction().rollback();
			ex.printStackTrace();
		}

	}

	@Override
	public List<Role> listRoles() {
		Query query = entityManager.createQuery("FROM Role", Role.class);
		return (List<Role>) query.getResultList();

	}

	@Override
	public Role findRole(long id) {
		return entityManager.find(Role.class, id);
	}

	@Override
	public String isAvailableLoginAndEmail(String login, String email) {
		String res = "";
		List<User> list = new ArrayList<>();
		Query query = entityManager.createQuery(
				"SELECT u FROM User u WHERE u.login=:login", User.class);
		query.setParameter("login", login);
		list = query.getResultList();

		if (list.size() != 0) {
			res = res.concat("Your Login is not available! ");
		}
		query = entityManager.createQuery(
				"SELECT u FROM User u WHERE u.email=:email", User.class);
		query.setParameter("email", email);
		List<User> list1 = new ArrayList<>();
		list1 = query.getResultList();
		if (list1.size() != 0) {
			res = res.concat("User with this email already exist! ");
		}

		return res;
	}

	@Override
	public User isUserExist(String login, String password) {
		List<User> list = new ArrayList<>();
		Query query = entityManager
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
