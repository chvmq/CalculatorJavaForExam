import javax.swing.JFrame;

public class JFrameWindowCalc extends JFrame{
    public JFrameWindowCalc(){
        add(new Panel());
        setSize(305,470);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("calculator1.1");
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        JFrameWindowCalc window = new JFrameWindowCalc();
    }
}
