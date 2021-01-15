import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Controller extends JFrame {
    private JSlider sliderPitch ;
//    private Oscillator oscillator = new Oscillator();
    public Controller()
    {
        //UI stuff, created with WindowsBuilder
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
//                oscillator.exit();
                System.exit(0);
            }
        });

        setTitle("Slider Frequency Sine Wave Demo");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 793, 166);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout(0, 0));

        sliderPitch = new JSlider();
        sliderPitch.setName("");
        sliderPitch.setMinimum(100);
        sliderPitch.setPaintLabels(true);
        sliderPitch.setPaintTicks(true);
        sliderPitch.setMajorTickSpacing(500);
        sliderPitch.setMaximum(4100);
        sliderPitch.setValue(880);
        getContentPane().add(sliderPitch);

//        getContentPane().add(iniSlider(sliderPitch, "", 100, true, true, 500, 4100,880));

        JLabel lblAdjustPitch = new JLabel("Adjust Pitch");
        lblAdjustPitch.setHorizontalAlignment(SwingConstants.CENTER);
        lblAdjustPitch.setFont(new Font("Tahoma", Font.PLAIN, 18));
        getContentPane().add(lblAdjustPitch, BorderLayout.NORTH);


    }

    public JSlider getSliderPitch() {
        return sliderPitch;
    }

    private JSlider iniSlider(JSlider slider,
                           String name,
                           int minimum,
                           boolean paintLabels,
                           boolean paintTicks,
                           int majorTickSpacing,
                           int maximum,
                           int value) {
        slider.setName(name);
        slider.setMinimum(minimum);
        slider.setPaintLabels(paintLabels);
        slider.setPaintTicks(paintTicks);
        slider.setMajorTickSpacing(majorTickSpacing);
        slider.setMaximum(maximum);
        slider.setValue(value);

        return slider;
    }
}
