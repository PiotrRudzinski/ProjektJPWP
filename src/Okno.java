
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Okno extends JFrame implements ActionListener {
    JButton start,restart;
    JLabel score,bestscore,time;
    int x =10;
    public Okno(){
        setSize(1280,1024);
        setTitle("Refleks test");
        setLayout(null);


        start = new JButton("Start");
        start.setBounds(20,868,150,100 );
        start.setFont(new Font("SansSerif",Font.BOLD,30));
        add(start);
        start.addActionListener(this);

        restart = new JButton("Restart");
        restart.setBounds(200,868,150,100 );
        restart.setFont(new Font("SansSerif",Font.BOLD,30));
        add(restart);
        restart.addActionListener(this);


        score = new JLabel("Punkty: "+x);
        score.setBounds(380,908,230,50);
        score.setFont(new Font("SansSerif",Font.BOLD,40));
        add(score);


        time = new JLabel("Czas: "+x);
        time.setBounds(630,908,190,50);
        time.setFont(new Font("SansSerif",Font.BOLD,40));
        add(time);

        int best_score = 200;
        bestscore = new JLabel("Najlepszy wynik: "+best_score);
        bestscore.setBounds(840,908,400,50);
        bestscore.setFont(new Font("SansSerif",Font.BOLD,40));
        add(bestscore);

    }


    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if (source==start)
        {
            System.out.println("raz ");
        }
        else if (source==restart)
        {
            System.out.println("dwa");
        }
    }
}
