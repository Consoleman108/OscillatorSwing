import java.awt.*;

public class MainApp {
    //Launch the app
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Controller controller = new Controller();
                controller.setVisible(true);
                new Oscillator(controller).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
