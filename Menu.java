import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jerry on 2017/3/28.
 */
public class Menu {
    private JProgressBar progressBar;
    private JButton startBtn;
    private JButton pauseBtn;
    private JPanel root;
    private JLabel progressLabel;
    private HeavyComputationSimulator simulator;

    public Menu() {
        //
        progressBar = new JProgressBar();
        progressLabel = new JLabel("Complete : 0%");
        progressLabel.setFont(new Font("Consolas", Font.PLAIN, 16));
        simulator = new HeavyComputationSimulator(progressBar, progressLabel);

        startBtn = new JButton("Start");
        startBtn.setBounds(20, 70, 200, 30);
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: start the task
                simulator.startHeavyTask();
                startBtn.setEnabled(false);
            }
        });
        pauseBtn = new JButton("Pause");
        pauseBtn.setBounds(240, 70, 200, 30);
        pauseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * TODO:
                 * pause or resume the task
                 * you should use SwingUtilities.invokeLater() to modify GUI elements!
                 */
                if (simulator.isExecuting()) {
                    pauseBtn.setText("Resume");
                    simulator.pauseHeavyTask();
                } else {

                    pauseBtn.setText("Pause");
                    simulator.resumeHeavyTask();
                }
                
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Menu");
        Menu menu = new Menu();
        /*frame.setContentPane(new Menu().root);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();*/
        frame.setSize(480, 175);
        frame.add(menu.startBtn);
        frame.add(menu.pauseBtn);
        frame.add(menu.progressLabel);
        frame.add(menu.progressBar);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
