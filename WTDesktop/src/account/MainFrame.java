package account;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;

public class MainFrame extends JFrame {
	private JPanel mainPanel, leftPanel, rightPanel;
	private JMenuBar menuBar;
	private JMenu optionsMenu;
	private JMenuItem profileItem;
	private JMenuItem signOutItem;
	private JTextField loginTF;
	private JTextField passwordTF;
	private JButton signInBtn;
	private JButton signOutBtn;
	private static final String MF_LABEL_LOGIN = "Login:";
	private static final String MF_LABEL_PASSWORD = "Password:";
	private static final String MF_BUTTON_SIGN_IN = "Sign In";
	private static boolean isLogin = false;

	MainFrame() {
		setTitle("Work Time");
		setSize(800, 600);
		setMinimumSize(new Dimension(800, 600));

		initGUI();

	}

	private void initGUI() {
		FormLayout mainLayout = new FormLayout(
				"5dlu,p,70dlu,10dlu,150:grow,5dlu", // columns
				"5dlu,15dlu,5dlu,p:grow,5dlu"); // rows
		mainPanel = new JPanel(mainLayout);

		initMenu();

		createInitLeftPanel();// before autorization

		add(mainPanel);

	}

	private void initMenu() {
		menuBar = new JMenuBar();

		optionsMenu = new JMenu("Options");
		profileItem = new JMenuItem("Web-profile");
		profileItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (Desktop.isDesktopSupported()) {
					try {
						final URI uri = new URI(
								"http://localhost:8080/WorkTime/time/");
						Desktop.getDesktop().browse(uri);
					} catch (Exception ex) {
					}
				}

			}

		});

		signOutItem = new JMenuItem("Sign Out");
		signOutItem.setEnabled(false);
		signOutItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}

		});

		optionsMenu.add(profileItem);
		optionsMenu.add(signOutItem);
		menuBar.add(optionsMenu);
		mainPanel.add(menuBar, CC.xy(2, 2));

	}

	private void createInitLeftPanel() {
		FormLayout leftLayout = new FormLayout(
				"5dlu,10dlu:grow,30dlu:grow,10dlu:grow,5dlu",
				"5dlu,p,5dlu,p,5dlu,p,5dlu,p,10dlu,p,5dlu,10dlu:grow");
		leftPanel = new JPanel(leftLayout);
		leftPanel.add(new JLabel(MF_LABEL_LOGIN), CC.xywh(2, 2, 3, 1));
		loginTF = new JTextField("");
		leftPanel.add(loginTF, CC.xywh(2, 4, 3, 1));
		leftPanel.add(new JLabel(MF_LABEL_PASSWORD), CC.xywh(2, 6, 3, 1));
		passwordTF = new JTextField("");
		leftPanel.add(passwordTF, CC.xywh(2, 8, 3, 1));
		signInBtn = new JButton(MF_BUTTON_SIGN_IN);
		leftPanel.add(signInBtn, CC.xy(3, 10));
		signInBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				createLoginLeftPanel();

			}
		});

		mainPanel.add(leftPanel, CC.xywh(2, 4, 2, 1, "f,f"));

	}

	private void createLoginLeftPanel() {
		User u = HibernateUtils.isUserExist(loginTF.getText(),
				passwordTF.getText());
		if (u != null) {
			mainPanel.remove(leftPanel);
			FormLayout leftLayout = new FormLayout(
					"5dlu,10dlu:grow,p:grow,10dlu:grow,5dlu",
					"5dlu,p,10dlu,p,5dlu,10dlu:grow");
			leftPanel = new JPanel(leftLayout);
			leftPanel.add(new JLabel("<html>Hello <b>" + u.getName()
					+ "!</b></html>"), CC.xywh(2, 2, 3, 1, "center,top"));
			signOutBtn = new JButton("Sign Out");
			signOutBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					mainPanel.remove(leftPanel);
					createInitLeftPanel();

				}
			});
			leftPanel.add(signOutBtn, CC.xy(3, 4));
			mainPanel.add(leftPanel, CC.xywh(2, 4, 2, 1, "f,f"));
			mainPanel.revalidate();
			mainPanel.repaint();
			createRightPanel();
		} else {
			JOptionPane.showMessageDialog(MainFrame.this,
					"Login or Password isn't correct!", "Error",
					JOptionPane.WARNING_MESSAGE);
			loginTF.setText("");
			passwordTF.setText("");
		}
	}

	private void createRightPanel() {

	}
}
