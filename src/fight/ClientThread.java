package fight;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ClientThread extends Thread {
	private ObjectInputStream in = null;
	private JLabel jl = null;

	ClientThread(Socket socket, JLabel jl) {
		try {
			in = new ObjectInputStream(socket.getInputStream());
			this.jl = jl;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			try {
				ObjectImage save = (ObjectImage) in.readObject();

				if (save != null) {
					InputStream buffin = new ByteArrayInputStream(save.getImage(), 0, save.getImage().length);

					Image img = ImageIO.read(buffin);

					jl.setIcon(new ImageIcon(img));
				}
			} catch (Exception  e) {
				// TODO Auto-generated catch block
				try {
					in.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}
}
