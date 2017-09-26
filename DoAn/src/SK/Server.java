package SK;

public class Server {


	public Server(int screen, int mouseclick, int mousemove) {
		ScreenThread st = new ScreenThread(screen);
		new Thread(st).start();
		MouseThread mt = new MouseThread(mousemove);
		new Thread(mt).start();
		MouseClickThread mct = new MouseClickThread(mouseclick);
		new Thread(mct).start();

	}

}
