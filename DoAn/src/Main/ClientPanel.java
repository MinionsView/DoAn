package Main;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClientPanel extends JPanel {
	private JTextField textField;
	private StartFrame frame;

	public ClientPanel(StartFrame frame) {

		
		this.frame = frame;
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		

		JLabel lblCntto = new JLabel("Kết nối tới :");

		textField = new JTextField();

		textField.setToolTipText(
				"Nhập IP");
		textField.setColumns(10);

		JRadioButton rdbtnRem = new JRadioButton("Bắt đầu điều khiển!");

		rdbtnRem.setSelected(true);

		JButton btnStt = new JButton("Bắt đầu!");
		btnStt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ip = textField.getText();
				if (!ip.isEmpty()) {
					if (rdbtnRem.isSelected()) {
						Remote rem = new Remote(ip, frame.getScreen(), frame.getMousemove(), frame.getMouseclick(), frame.getKeyboard());
						frame.hide();
					}
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
						.addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
										.addGap(23).addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblCntto))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(textField, GroupLayout.PREFERRED_SIZE, 203,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayout.createSequentialGroup()
														)))
								.addGroup(groupLayout.createSequentialGroup().addGap(171).addComponent(btnStt)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addComponent(label, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
				.addGap(53)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblCntto).addComponent(
						textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE))
				.addGap(18).addComponent(btnStt).addContainerGap(55, Short.MAX_VALUE)));
		ButtonGroup group = new ButtonGroup();
		
		setLayout(groupLayout);
	}
}
