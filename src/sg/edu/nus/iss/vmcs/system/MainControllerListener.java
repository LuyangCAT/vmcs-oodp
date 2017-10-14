package sg.edu.nus.iss.vmcs.system;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainControllerListener implements ListenerStrategy,ActionListener{
	private MainController mctrl;	
	
	public MainControllerListener(MainController mc) {
		mctrl = mc;
	}

	public void actionPerformed(ActionEvent e) {
		
		switch(e.getActionCommand())
		{
		case SimulatorControlPanel.L_SIMUL_END:
			mctrl.closeDown();
			break;
			
		default:
			break;
		
	}

}
}
