package account;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/time")
public class MainController {
	@Autowired
	private AccountDAO accDAO;

	@Autowired
	private Map<String, Object> registerMap;

	@RequestMapping("/")
	public ModelAndView index(Model model) {

		return new ModelAndView("index", "errors", "");
	}

	/*
	 * @RequestMapping(value = "/add_user_page", method = RequestMethod.POST)
	 * public ModelAndView addPage(Model model) { registerMap.put("roles",
	 * accDAO.listRoles()); registerMap.put("errors", ""); return new
	 * ModelAndView("add_page", "registerMap", registerMap); }
	 */

	@RequestMapping(value = "/index_main", method = RequestMethod.POST)
	public ModelAndView indexPage(Model model) {
		return new ModelAndView("index", "errors", "");
	}

	@RequestMapping("/image/{file_id}")
	public void getFile(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("file_id") long fileId) {
		try {
			byte[] content = accDAO.getPhoto(fileId);
			response.setContentType("image/png");
			response.getOutputStream().write(content);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	@RequestMapping(value = "/index_action", method = RequestMethod.POST)
	public ModelAndView addUser(@RequestParam(value = "login") String login,
			@RequestParam(value = "password") String password,
			HttpServletRequest request, HttpServletResponse response) {
		if (request.getParameter("signIn") != null) {
			if (accDAO.isUserExist(login, password) == null) {

				return new ModelAndView("index", "errors",
						"Login or Password isn't correct!");
			} else {
				return new ModelAndView("profile");
			}
		} else {
			registerMap.put("roles", accDAO.listRoles());
			registerMap.put("errors", "");
			return new ModelAndView("add_page", "registerMap", registerMap);
		}
	}

	@RequestMapping(value = "/user_profile", method = RequestMethod.POST)
	public ModelAndView addUser(
			@RequestParam(value = "name") String name,
			@RequestParam(value = "surname", required = false) String surname,
			@RequestParam(value = "login") String login,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "re_password") String repassword,
			@RequestParam(value = "email") String email,
			@RequestParam(value = "photo", required = false) MultipartFile photo,
			@RequestParam(value = "roleName") long roleName,
			HttpServletRequest request, HttpServletResponse response) {
		if ("".equals(CorrectUtils.errorDataString(name, login, password,
				repassword, email))
				&& "".equals(accDAO.isAvailableLoginAndEmail(login, email))) {
			registerMap.put("errors", "");

			try {
				User u = new User(login, DigestUtils.md5Hex(password), email,
						name, surname.isEmpty() ? null : surname,
						photo.isEmpty() ? null : new Photo(photo
								.getOriginalFilename(), photo.getBytes()),
						accDAO.findRole(roleName));
				accDAO.addUser(u);
				return new ModelAndView("profile");
			} catch (IOException ex) {
				response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				return null;
			}
		} else {
			registerMap.put(
					"errors",
					CorrectUtils.errorDataString(name, login, password,
							repassword, email)
							+ accDAO.isAvailableLoginAndEmail(login, email));
			return new ModelAndView("add_page", "registerMap", registerMap);
		}
	}
}