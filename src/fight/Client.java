package fight;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Client {
	private JFrame jf = new JFrame("Fight");
	private DataOutputStream  out = null;

	Client() {
		try {
			Socket socket = new Socket("192.168.31.152", 8080);
			JLabel jl = new JLabel();
			jf.add(jl);
			jf.setSize(1000, 500);
			jf.setVisible(true);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			new ClientThread(socket, jl).start();
			out = new DataOutputStream(socket.getOutputStream());
			jf.addKeyListener(new KeyListener() {

				public void keyPressed(KeyEvent arg0) {
					// TODO Auto-generated method stub
					try {
						out.writeInt(arg0.getKeyCode());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				public void keyReleased(KeyEvent arg0) {
					// TODO Auto-generated method stub
				}

				public void keyTyped(KeyEvent arg0) {
					// TODO Auto-generated method stub
				}

			});
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Client();
	}

}