package miniproject;


public class Fdit {

	GUI gui;
	public Fdit(GUI gui) {
		this.gui=gui;
	}
	
	public void undo() {
		gui.um.undo();
	} 
	public void redo() {
		gui.um.redo();
	}

}
 