package account;

import java.util.List;

public interface AccountDAO {
	byte[] getPhoto(long id);

	void addUser(User u);

	List<Role> listRoles();

	Role findRole(long id);

	String isAvailableLoginAndEmail(String login, String email);

	User isUserExist(String login, String password);
}