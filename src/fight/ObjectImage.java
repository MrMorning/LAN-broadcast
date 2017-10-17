package fight;

import java.io.Serializable;

public class ObjectImage implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private byte[] image;

	public void setImage(byte[] image) {
		// TODO Auto-generated method stub
		this.image = image;
	}
	
	public byte[] getImage() {
		return this.image;
	}
}
