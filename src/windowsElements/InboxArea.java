package windowsElements;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextArea;
import javax.swing.text.Document;


public class InboxArea extends JTextArea implements FocusListener {

	public InboxArea() {
		this.addFocusListener(this);
	}

	public InboxArea(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

	public InboxArea(Document doc) {
		super(doc);
		// TODO Auto-generated constructor stub
	}

	public InboxArea(int rows, int columns) {
		super(rows, columns);
		// TODO Auto-generated constructor stub
	}

	public InboxArea(String text, int rows, int columns) {
		super(text, rows, columns);
		// TODO Auto-generated constructor stub
	}

	public InboxArea(Document doc, String text, int rows, int columns) {
		super(doc, text, rows, columns);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void focusGained(FocusEvent fe) {
		if (fe.getSource().equals(this)) {
			this.setText(null);
		}
		
	}

	@Override
	public void focusLost(FocusEvent fe) {
		if (fe.getSource().equals(this)) this.setText("Enter your message");
		
	}

}
