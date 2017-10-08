package SK;


public class Server {


	public Server(int screen, int mouseclick, int mousemove, int keyboard) {
		ScreenThread st = new ScreenThread(screen);
		new Thread(st).start();
		MouseThread mt = new MouseThread(mousemove);
		new Thread(mt).start();
		MouseClickThread mct = new MouseClickThread(mouseclick);
		new Thread(mct).start();
		KeyThread kt = new KeyThread(keyboard);
		new Thread(kt).start();

	}

}
