package Main;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SwingConstants;

import SK.Server;

import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class ServerPanel extends JPanel implements ActionListener {
	private Server server;
	JCheckBox chckbxTing;
	private JButton btnBtu;
	private JRadioButton rdbtnServerRemote;
	private StartFrame sf;
	private JLabel lblChaR;
	
	public ServerPanel(StartFrame frame) {
		sf = frame;
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblaChMy = new JLabel("Địa chỉ của máy là :");
		lblaChMy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel lblNewLabel = new JLabel();
		InetAddress adr = null;
		try {
			adr = Inet4Address.getLocalHost();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblNewLabel.setText(adr.getHostAddress());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		
		lblChaR = new JLabel();
		btnBtu = new JButton("Bắt đầu!!");
		btnBtu.addActionListener(this);
		
		
		lblChaR.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		chckbxTing = new JCheckBox("Đồng ý chia sẻ");
		
		rdbtnServerRemote = new JRadioButton("Remote Server");
		
		
		ButtonGroup group = new ButtonGroup();
		
		
		rdbtnServerRemote.setSelected(true);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(label, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(18)
					.addComponent(lblChaR))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblaChMy)
					.addGap(18)
					.addComponent(lblNewLabel))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(179)
					.addComponent(btnBtu))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxTing))
				.addGroup(groupLayout.createSequentialGroup()
					
					)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblaChMy)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChaR))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE))
					.addGap(16)
					.addComponent(chckbxTing)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnBtu)
					.addContainerGap())
		);
		setLayout(groupLayout);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		if(chckbxTing.isSelected()){
			if(rdbtnServerRemote.isSelected()){
			server = new Server(sf.getScreen(), sf.getMouseclick(),sf.getMousemove());
			}
			btnBtu.setEnabled(false);
		}
		else
			JOptionPane.showMessageDialog(null, "Bạn tích đồng ý để bắt đầu!");
	}
	

}
