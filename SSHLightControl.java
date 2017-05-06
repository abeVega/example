import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import javafx.application.Platform;

import java.io.InputStream;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;

public class SSHLightControl {
	int hour, minute, second;

    public SSHLightControl(int input) {
    	String command = null;
    	
    	if(input == 1) {
    		command = "cd Desktop; ./lightOn.sh";
    	}
    	else if (input == 0) {
    		command = "cd Desktop; ./lightOff.sh";
    		
    	}
    	sendCommand(command);
    	
    }
    
    public SSHLightControl(int hourInput, int minuteInput, int secondInput) {
    	hour = hourInput;
    	minute = minuteInput;
    	second = secondInput;
    	
    	
		String command = "cd Desktop; ./lightOn.sh";
		sendCommand(command);
		
		Timer timer = new Timer();
		
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				
				if (hour > 0 && minute == 0 && second == 0) {
					hour--;
					minute = 59;
					second = 59;
				}
				
				if (hour == 0 && minute > 0 && second == 0) {
					minute--;
					second = 59;
				}
			
				second--;
				
				if (hour == 0 && minute == 0 && second == 0) {
					timer.cancel();
					timer.purge();
				}
				
				Platform.runLater(new Runnable() {

					public void run() {
						
						
						if(hour == 0 && minute == 0 && second == 0) {
							String command = "cd Desktop; ./lightOff.sh";
							sendCommand(command);
						}
					}
				});
				
			}		
		}, 0, 1000);
	}

	private void sendCommand(String command) {
		try {
        	System.out.println(command);
        	
            JSch jsch = new JSch();

            Session session = jsch.getSession("pi", "192.168.1.206", 22);

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            session.setPassword("pi");
            session.connect();

            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand(command);

            ((ChannelExec) channel).setErrStream(System.err);

            InputStream is = channel.getInputStream();

            System.out.println("Connect to session...");
            channel.connect();

            byte[] tmp = new byte[1024];
            while (true) {
                while (is.available() > 0) {
                    int i = is.read(tmp, 0, 1024);
                    if (i < 0) {
                        break;
                    }
                    System.out.print(new String(tmp, 0, i));
                }
                if (channel.isClosed()) {
                    System.out.println("exit-status: " + channel.getExitStatus());
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception ee) {
                }
            }
            channel.disconnect();
            session.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }
		
	}
}