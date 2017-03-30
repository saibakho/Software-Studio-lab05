import javax.swing.*;

/**
 * Created by jerry on 2017/3/28.
 */
public class HeavyComputationSimulator implements Runnable {

    private Thread myThread;
    private JProgressBar progressBar;
    private JLabel progressLabel;
    private boolean isExecuting; //true if the task is executing
    private int count = 0;

    public HeavyComputationSimulator(JProgressBar bar,JLabel label)
    {
        this.progressBar = bar;
        this.progressBar.setBounds(20, 20, 280, 30);

        this.progressLabel = label;
        this.progressLabel.setBounds(320, 20, 140, 30);
        //TODO:initial the thread and assign GUI variables
        myThread = new Thread(this);
    }

    public void startHeavyTask(){
        //TODO:start the thread here
        isExecuting = true;
        myThread.start();        
    }
    public void resumeHeavyTask()
    {
        //TODO
        isExecuting = true;
    }
    public void pauseHeavyTask()
    {
        //TODO
        isExecuting = false;
    }

    public boolean isExecuting() {
        return isExecuting;
    }

    @Override
    public void run() {
        /**
         * TODO:
         * call pretendToBeBusy and update count value if task is executing
         * put Swing GUI modification inside SwingUtilities.invokeLater !!
         */
        while (count < 100) {
            pretendToBeBusy();
            if (isExecuting) {
                count++;
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        progressBar.setValue(count);
                        progressLabel.setText("Complete : " + count + "%");
                    }
                });
            }
        }

    }

    private void pretendToBeBusy()
    {
        /**Just imagine you are doing some heavy computation work
         * simulate by Thread.sleep
         */
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
