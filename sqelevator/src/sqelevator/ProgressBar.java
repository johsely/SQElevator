package sqelevator;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class ProgressBar extends JPanel {

	JProgressBar progressBar;
	static final int MY_MINIMUM = 0;
	static final int MY_MAXIMUM = 100;

	public ProgressBar() {
		progressBar = new JProgressBar(JProgressBar.VERTICAL);
		progressBar.setMinimum(MY_MINIMUM);
		progressBar.setMaximum(MY_MAXIMUM);
		Dimension prefSize = progressBar.getPreferredSize();
		prefSize.height = 450;
		progressBar.setPreferredSize(prefSize);
		add(progressBar);
	}

	public void updateBar(int newValue) {
		progressBar.setValue(newValue);
	}

	public void runBar() {
		for (int i = MY_MINIMUM; i <= MY_MAXIMUM; i++) {
			final int percent = i;
			try {
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						updateBar(percent);
					}
				});
				java.lang.Thread.sleep(100);
			} catch (InterruptedException e) {
				;
			}
		}
	}
}
