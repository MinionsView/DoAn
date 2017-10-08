package Main;

import java.awt.BorderLayout;
//import de.javasoft.plaf.synthetica.SyntheticaAluOxideLookAndFeel;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class StartFrame extends JFrame {

	private JPanel contentPane, mainPnl;
	private BufferedImage tvicon;
	private ClientPanel clientPnl;
	private ServerPanel serverPnl;
	private static StartFrame frame;
	public int screen = 9000, mousemove = 9001, mouseclick = 9002, keyboard = 9003;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				      
					frame = new StartFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public int getScreen() {
		return screen;
	}

	public void setScreen(int screen) {
		this.screen = screen;
	}

	public int getMousemove() {
		return mousemove;
	}

	public void setMousemove(int mousemove) {
		this.mousemove = mousemove;
	}

	public int getMouseclick() {
		return mouseclick;
	}

	public void setMouseclick(int mouseclick) {
		this.mouseclick = mouseclick;
	}
	
	public int getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(int keyboard) {
		this.keyboard = keyboard;
	}

	public StartFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 380);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnSetup = new JMenu("Tùy Chọn");
		menuBar.add(mnSetup);

		JCheckBoxMenuItem cbmClient = new JCheckBoxMenuItem("Client");
		cbmClient.setSelected(true);
		mnSetup.add(cbmClient);

		JCheckBoxMenuItem cbmServer = new JCheckBoxMenuItem("Server");
		
		mnSetup.add(cbmServer);

		ButtonGroup mnItem = new ButtonGroup();
		mnItem.add(cbmServer);
		mnItem.add(cbmClient);
		
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		serverPnl = new ServerPanel(this);
		clientPnl = new ClientPanel(this);
		mainPnl = new JPanel(new CardLayout());
		mainPnl.add(clientPnl, "Client");
		mainPnl.add(serverPnl, "Server");
		contentPane.add(mainPnl, BorderLayout.CENTER);
		cbmClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (mainPnl.getLayout());
				cl.show(mainPnl, "Client");
			}
		});
		cbmServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (mainPnl.getLayout());
				cl.show(mainPnl, "Server");
			}
		});
		
		LoadImage load = new LoadImage();
		tvicon = load.loadImage("icon.png");
		setIconImage(tvicon);
		setTitle("Controlling Machine ");
	}

}
