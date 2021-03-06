package GuiElements;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.nio.file.Path;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.MatteBorder;


public class BroadCastFileSend extends JPanel{

	private static final long serialVersionUID = 1L;
	private static int totalNum;
	private int index;
	private Path filepath;
	
	public BroadCastFileSend(Path filepath, String timeStamp) {

		this.filepath = filepath;
		String filename=filepath.getFileName().toString();
		totalNum++;
		index=totalNum;
		
		setBackground(Color.WHITE);
		setBorder(new MatteBorder(0, 3, 0, 0,(Color) new Color(0, 204, 204)));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{500};
		gridBagLayout.rowHeights = new int[]{45,25};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0};
		setLayout(gridBagLayout);
		createInsidePanel(filename, timeStamp);
	}
	
	private void createInsidePanel(String filename, String timeStamp){
		
		
		JTextPane txtpnMessage = new JTextPane();
		
		txtpnMessage.setEditable(false);
		txtpnMessage.setBackground(Color.WHITE);
		txtpnMessage.setText(filename);
		
		GridBagConstraints gbc_txtpnMessage = new GridBagConstraints();
		gbc_txtpnMessage.fill = GridBagConstraints.BOTH;
		gbc_txtpnMessage.gridx = 0;
		gbc_txtpnMessage.gridy = 0;
		gbc_txtpnMessage.insets = new Insets(3, 3, 0, 0);
		add(txtpnMessage, gbc_txtpnMessage);
		
		JLabel lblTimestamp = new JLabel(timeStamp);
		lblTimestamp.setFont(new Font("Ubuntu Light", Font.PLAIN, 10));
		lblTimestamp.setBackground(Color.WHITE);
		
		GridBagConstraints gbc_lblTimestamp = new GridBagConstraints();
		gbc_lblTimestamp.gridx = 0;
		gbc_lblTimestamp.gridy = 1;
		gbc_lblTimestamp.anchor = GridBagConstraints.NORTHEAST;
		add(lblTimestamp, gbc_lblTimestamp);


	}
	public int getIndex()
	{
		return index;
	}
	public Path getFilePath()
	{
		return filepath;
	}
}