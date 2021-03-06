package fileSending;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

public class TestPane extends JPanel {

	private static final long serialVersionUID = 1L;
	private JProgressBar pbProgress;


    public TestPane() {
    	setBackground(Color.WHITE);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        pbProgress = new JProgressBar();
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(pbProgress, gbc);
    }
    public void startProgress(float max, Server s)
    {
         		this.setVisible(true);
                ProgressWorker pw = new ProgressWorker(max, s);
                pw.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            pbProgress.setValue(progress);
                            repaint();
                        } else if (name.equals("state")) {
                            SwingWorker.StateValue state = (SwingWorker.StateValue) evt.getNewValue();
                            switch (state) {
                                case DONE:
                                	pbProgress.setVisible(false);
                                    break;
                            }
                        }
                    }

                });
                pw.execute();
    }
    
    public void startProgress(float max, Client c)
    {
    			this.setVisible(true);
                ProgressWorker pw = new ProgressWorker(max, c);
                pw.addPropertyChangeListener(new PropertyChangeListener() {

                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if (name.equals("progress")) {
                            int progress = (int) evt.getNewValue();
                            pbProgress.setValue(progress);
                            repaint();
                        } else if (name.equals("state")) {
                            SwingWorker.StateValue state = (SwingWorker.StateValue) evt.getNewValue();
                            switch (state) {
                                case DONE:
                                	pbProgress.setVisible(false);
                                    break;
                            }
                        }
                    }

                });
                pw.execute();
    }

}