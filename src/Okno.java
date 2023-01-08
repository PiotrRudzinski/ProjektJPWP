import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import static java.lang.Math.abs;


public class Okno extends JFrame implements ActionListener {
    JButton start,restart,green,red,red_2,red_3; //deklaracja przycisków
    JLabel score,bestscore,time; //deklaracaj napisów
    Los losowanie = new Los(); // utworzenie losowania
    Timer timer = new Timer(5, this); // utworzenie timera
    int second,actual_score = 0 ,best_score = 0; //deklaracja punktów i czasu
    String ddSecond;
    DecimalFormat dFormat = new DecimalFormat("00");
    public Okno(){
        setSize(1280,1024); //Ustawienie wymiarów
        setTitle("Refleks test"); // Ustawienie tytułu
        setLayout(null);
        getContentPane().setBackground(new Color(220,220,220)); // Ustawienie koloru tła
        setLocationRelativeTo(null); // ustawienie okna wyświetlania na środku



        start = new JButton("Start"); //utworzenie przysiku start
        start.setBounds(20,868,150,100 ); // Ustawinie pozycji przycisku start
        start.setFont(new Font("SansSerif",Font.BOLD,30)); // Ustawinie czcionki przycisku start
        add(start);
        start.addActionListener(this);

        restart = new JButton("Restart"); //utworzenie przysiku restart
        restart.setBounds(200,868,150,100 ); // Ustawinie pozycji przycisku restart
        restart.setFont(new Font("SansSerif",Font.BOLD,30)); // Ustawinie czcionki przycisku restart
        add(restart);
        restart.addActionListener(this);

        score = new JLabel("Punkty: "+actual_score); //utworzenie napisu Punkty z zmienną wynik
        score.setBounds(380,908,230,50); // Ustawinie pozycji napisu Punkty
        score.setFont(new Font("SansSerif",Font.BOLD,40)); // Ustawinie czcionki napisu Punkty
        add(score);

        time = new JLabel("Czas:"+" 60s"); //utworzenie napisu Czas wraz z startową ilością sekund
        time.setBounds(630,908,190,50); // Ustawinie pozycji napisu Czas
        time.setFont(new Font("SansSerif",Font.BOLD,40)); // Ustawinie czcionki napisu Czas
        time.setVisible(true);
        add(time);

        bestscore = new JLabel("Najlepszy wynik: "+best_score); //utworzenie napisu Najlepszy wynik z zmienną najlepszy wynik
        bestscore.setBounds(840,908,400,50); // Ustawinie pozycji napisu Najlepszy wynik
        bestscore.setFont(new Font("SansSerif",Font.BOLD,40)); // Ustawinie czcionki napisu Czas Najlepszy wynik
        add(bestscore);

        green = new JButton(new ImageIcon("green.png")); //utworzenie Zielonego punktu
        green.setBorderPainted(false);
        green.setBackground(new Color(220,220,220)); //Ustawienie koloru tła
        green.setVisible(false); // Wyłączenie wyświetlania się przycisku
        add(green);
        green.addActionListener(this);


        red = new JButton(new ImageIcon("red.png")); //utworzenie pierwszego czerwonego punktu
        red.setBorderPainted(false);
        red.setBackground(new Color(220,220,220)); //Ustawienie koloru tła
        red.setVisible(false); // Wyłączenie wyświetlania się przycisku
        add(red);
        red.addActionListener(this);

        red_2 = new JButton(new ImageIcon("red.png")); //utworzenie drugiego czerwonego punktu
        red_2.setBorderPainted(false);
        red_2.setBackground(new Color(220,220,220)); //Ustawienie koloru tła
        red_2.setVisible(false); // Wyłączenie wyświetlania się przycisku
        add(red_2);
        red_2.addActionListener(this);

        red_3 = new JButton(new ImageIcon("red.png")); //utworzenie trzeciego czerwonego punktu
        red_3.setBorderPainted(false);
        red_3.setBackground(new Color(220,220,220)); //Ustawienie koloru tła
        red_3.setVisible(false); // Wyłączenie wyświetlania się przycisku
        add(red_3);
        red_3.addActionListener(this);
    }


    public void Timer()
    {
        second = 0; // ustawienie licznika na wartość początkową
        timer = new Timer(1000, new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                second++; // inkrementacja licznika
                ddSecond = dFormat.format((60-second)); //zmiana formatu z liczny na stringa
                time.setText("Czas: "+ ddSecond+"s"); //wyświetlanie aktualnego czasu
                if(second == 60) //warunek zakonczenia licznika
                {
                    second = 0; //wyzerowanie licznika
                    timer.stop(); //zatrzymanie timera
                    green.setVisible(false); // Wyłączenie wyświetlania się przycisku
                    red.setVisible(false); // Wyłączenie wyświetlania się przycisku
                    red_2.setVisible(false); // Wyłączenie wyświetlania się przycisku
                    red_3.setVisible(false); // Wyłączenie wyświetlania się przycisku
                    time.setText("Czas: 60s"); //wyświetlanie początkowego czasu
                    if(actual_score>best_score) //warunek sprawdzający czy uzyskany wynik jest więszy od obecnego rekordu
                    {
                        best_score = actual_score; //ustawinie wartość wyniku jako rekord
                        bestscore.setText("Najlepszy wynik: "+best_score); //wyświetlenie najlepszego wyniku
                    }
                }

            }
        });
    }
    void Position() //funkcja generująca położenie wyświetlanych punktów
    {
        int x_green = losowanie.losowanie_x(); //Przypisywanie wartości x dla zielonego punktu
        int y_green = losowanie.losowanie_y(); //Przypisywanie wartości y dla zielonego punktu
        green.setBounds(x_green,y_green,50,50);

        int x_red = losowanie.losowanie_x(); //Przypisywanie wartości x dla pierwszego czerwonego punktu
        int y_red = losowanie.losowanie_y(); //Przypisywanie wartości y dla pierwszego czerwonego punktu

        int x_red_2 = losowanie.losowanie_x(); //Przypisywanie wartości x dla drugiego czerwonego punktu
        int y_red_2 = losowanie.losowanie_y(); //Przypisywanie wartości y dla drugiego czerwonego punktu

        int x_red_3 = losowanie.losowanie_x(); //Przypisywanie wartości x dla trzeciego czerwonego punktu
        int y_red_3 = losowanie.losowanie_y(); //Przypisywanie wartości y dla trzeciego czerwonego punktu


        if(abs(x_green - x_red)<50 || abs(y_green - y_red)<50) //warunek odpowiedzialny za brak kolizji czerwonego punktu z zielonym
        {
            while(abs(x_green - x_red)<50 || abs(y_green - y_red)<50 ) //ponowne losowanie wspolżendnych dopóki nie bedą spełniać wymagania
            {
                x_red = losowanie.losowanie_x();
                y_red = losowanie.losowanie_y();
            }
        }
        if(abs(x_green - x_red_2)<50 || abs(y_green - y_red_2)<50) //warunek odpowiedzialny za brak kolizji czerwonego punktu z zielonym
        {
            while(abs(x_green - x_red_2)<50 || abs(y_green - y_red_2)<50 ) //ponowne losowanie wspolżendnych dopóki nie bedą spełniać wymagania
            {
                x_red_2 = losowanie.losowanie_x();
                y_red_2 = losowanie.losowanie_y();
            }
        }
        if(abs(x_green - x_red_3)<50 || abs(y_green - y_red_3)<50) //warunek odpowiedzialny za brak kolizji czerwonego punktu z zielonym
        {
            while(abs(x_green - x_red_3)<50 || abs(y_green - y_red_3)<50 ) //ponowne losowanie wspolżendnych dopóki nie bedą spełniać wymagania
            {
                x_red_3 = losowanie.losowanie_x();
                y_red_3 = losowanie.losowanie_y();
            }
        }

        red.setBounds(x_red,y_red,50,50);
        red_2.setBounds(x_red_2,y_red_2,50,50);
        red_3.setBounds(x_red_3,y_red_3,50,50);

        green.setVisible(true); //Włączenie wyświetlania się przycisku
        red.setVisible(true); //Włączenie wyświetlania się przycisku
        red_2.setVisible(true); //Włączenie wyświetlania się przycisku
        red_3.setVisible(true); //Włączenie wyświetlania się przycisku
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        if (source==start) //Działanie po naciśnięciu przycisku Start
        {
            if(!timer.isRunning())//zapobiegnięcie dwukrotnego odpalenia timera
            {
                Position(); //wywołanie funkcji od pozycji
                Timer(); //wywołanie funkcji timer
                timer.start();
                actual_score = 0; //Ustawienie wartości początkowej punktów
                score.setText("Punkty: "+actual_score); //Wyświetlenie początkowej wartosc punktów
            }
        }
        else if (source==restart) //Działanie po naciśnięciu przycisku Restart
        {
            timer.stop();
            Timer();
            timer.start();
            actual_score = 0; //Ustawienie wartości początkowej punktów
            score.setText("Punkty: "+actual_score); //Wyświetlenie początkowej wartosc punktów
            time.setText("Czas: 60s");  //Wyświetlenie początkowej wartosc Czasu
            Position();
        }
        else if(source==green) //Działanie po naciśnięciu przycisku green
        {
            actual_score +=1; //dodanie punktu do wyniku
            score.setText("Punkty: "+actual_score); //Ustawinie zaktualizowanych wartości Punktu
            Position(); //wywołanie funkcji od pozycji
        }
        else if(source==red || source==red_2 || source==red_3) //Działanie po naciśnięciu przycisku red
        {
            actual_score -=1; //odjęcie punktu od wyniku
            score.setText("Punkty: "+actual_score); //Ustawinie zaktualizowanych wartości Punktu
            Position(); //wywołanie funkcji od pozycji
        }
    }
}
