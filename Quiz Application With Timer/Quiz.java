import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
public class Quiz implements ActionListener{
    String[] questions = {
                            "Which company created java ?",
                            "Which year was Java Created ?",
                            "What was Java originally called ?",
                            "Number of primitive data types in java ?",
                            "When array is passed to method, what does method receive ?",
                            "Select the valid declaration :- ",
                            "Select the valid initialization :-",
                            "Arrays in java are :-",
                            "When is the object created with new keyboard ?",
                            "In which package is toString() method defined ?"
    };
    String[][] options = {
                            {"Sun Microsystems","Apple","Microsoft","Alphabet"},
                            {"1989","1996","1972","1993"},
                            {"Apple","Latte","Oak","Koffing"},
                            {"6","7","8","9"},
                            {"The reference of the array","A copy of the array","Length of the array","Copy of first element"},
                            {"char[] ch = new char(5)","char[] ch = new char[5]","char[] ch = new char()","char[] ch = new char[]"},
                            {"Int[] A = {}","Int[] A = (1,2,3)","Int[] A = {1,2,3}","Int[][] A = {1,2,3}"},
                            {"Object references","Object","None","Primitive Data Type"},
                            {"At run time","At compile time","Depends on the code","None"},
                            {"java.lang.Object","java.lang.util","java.lang.String","None"}
    };
    char[] answers = {
                            'A',
                            'B',
                            'C',
                            'A',
                            'D',
                            'B',
                            'C',
                            'D',
                            'C',
                            'B'
    };
    char answer;
    int index;
    int correct_guess=0;
    int total_questions = questions.length;
    float result;
    int seconds=10;
    String Message;

    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();
    JTextArea textarea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();
    JLabel time_label = new JLabel();
    JLabel seconds_left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();

    Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            seconds_left.setText(String.valueOf(seconds));
            if(seconds<=0){
                displayAnswer();
            }
        }
    });

    public Quiz() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 650);
        frame.getContentPane().setBackground(new Color(255, 255, 255));
        frame.setLayout(null);

        textfield.setBounds(0, 50, 650, 50);
        textfield.setBackground(new Color(255, 255, 255));
        textfield.setForeground(new Color(199, 56, 189));
        textfield.setFont(new Font("Times New Roman", Font.BOLD, 25));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);

        textarea.setBounds(0, 100, 650, 50);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(255, 255, 255));
        textarea.setForeground(new Color(199, 56, 189));
        textarea.setFont(new Font("Times New Roman", Font.BOLD, 25));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setText("TEST");

        buttonA.setBounds(0, 150, 100, 100);
        buttonA.setFont(new Font("Times New Roman", Font.BOLD, 25));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0, 250, 100, 100);
        buttonB.setFont(new Font("Times New Roman", Font.BOLD, 25));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0, 350, 100, 100);
        buttonC.setFont(new Font("Times New Roman", Font.BOLD, 25));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0, 450, 100, 100);
        buttonD.setFont(new Font("Times New Roman", Font.BOLD, 25));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answer_labelA.setBounds(125, 150, 500, 100);
        answer_labelA.setBackground(new Color(255, 255, 255));
        answer_labelA.setForeground(new Color(199, 59, 189));
        answer_labelA.setFont(new Font("Times New Roman", Font.PLAIN, 35));

        answer_labelB.setBounds(125, 250, 500, 100);
        answer_labelB.setBackground(new Color(255, 255, 255));
        answer_labelB.setForeground(new Color(199, 56, 189));
        answer_labelB.setFont(new Font("Times New Roman", Font.PLAIN, 35));

        answer_labelC.setBounds(125, 350, 500, 100);
        answer_labelC.setBackground(new Color(255, 255, 255));
        answer_labelC.setForeground(new Color(199, 56, 189));
        answer_labelC.setFont(new Font("Times New Roman", Font.PLAIN, 35));

        answer_labelD.setBounds(125, 450, 500, 100);
        answer_labelD.setBackground(new Color(255, 255, 255));
        answer_labelD.setForeground(new Color(199, 56, 189));
        answer_labelD.setFont(new Font("Times New Roman", Font.PLAIN, 35));

        time_label.setBounds(400, 0, 300, 50);
        time_label.setBackground(new Color(255, 255, 255));
        time_label.setForeground(new Color(199, 56, 189));
        time_label.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        time_label.setText("Seconds Left ");

        seconds_left.setBounds(540, 0, 100, 50);
        seconds_left.setBackground(new Color(199, 56, 189));
        seconds_left.setForeground(new Color(255, 255, 255));
        seconds_left.setFont(new Font("Times New Roman", Font.BOLD, 35));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        number_right.setBounds(50, 225, 550, 100);
        number_right.setBackground(new Color(255,255,255));
        number_right.setForeground(new Color(199, 56, 189));
        number_right.setFont(new Font("Times New Roman", Font.BOLD, 35));
        number_right.setHorizontalAlignment(JTextField.CENTER);

        percentage.setBounds(50, 325, 550, 100);
        percentage.setBackground(new Color(255,255,255));
        percentage.setForeground(new Color(199, 56, 189));
        percentage.setFont(new Font("Times New Roman", Font.BOLD, 30));
        percentage.setHorizontalAlignment(JTextField.CENTER);

        frame.add(textfield);
        frame.add(textarea);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);
        frame.add(seconds_left);
        frame.add(time_label);
        frame.setVisible(true);

        nextQuestion();
    }
        public void nextQuestion(){
        if(index>=total_questions){
            results();
        }
        else {
            textfield.setText("Question "+(index+1));
            textarea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);
            timer.start();
        }
    }
    public void displayAnswer(){
        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(answers[index]!='A'){
            answer_labelA.setForeground(new Color(255,0,0));
        }
        if(answers[index]!='B'){
            answer_labelB.setForeground(new Color(255,0,0));
        }
        if(answers[index]!='C'){
            answer_labelC.setForeground(new Color(255,0,0));
        }
        if(answers[index]!='D'){
            answer_labelD.setForeground(new Color(255,0,0));
        }
        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer_labelA.setForeground(new Color(199, 56, 189));
                answer_labelB.setForeground(new Color(199, 56, 189));
                answer_labelC.setForeground(new Color(199, 56, 189));
                answer_labelD.setForeground(new Color(199, 56, 189));

                answer = ' ';
                seconds=10;
                seconds_left.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();
    }
    public void results(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result=((correct_guess/(float)total_questions)*100);

        if (correct_guess >= 0 && correct_guess <= 2) {
            Message="Ohh No :( !!";
        } else if (correct_guess > 2 && correct_guess <= 5) {
            Message=" - Refresh Your Concepts";
        } else if (correct_guess > 5 && correct_guess <= 8) {
            Message=" - Well Done !!";
        } else {
            Message=" - Outstanding Performance :) !!";
        }

        textfield.setText("RESULTS !!");
        textarea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");
        time_label.setText("");

        number_right.setText("You Got "+correct_guess+" Out Of "+total_questions+" Questions");
        percentage.setText(result+"% "+Message);

        frame.add(number_right);
        frame.add(percentage);
        buttonA.setVisible(false);
        buttonB.setVisible(false);
        buttonC.setVisible(false);
        buttonD.setVisible(false);
        seconds_left.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(e.getSource()==buttonA){
            answer='A';
            if(answer==answers[index]){
                answer_labelA.setForeground(new Color(25,255,0));
                correct_guess++;
            }
        }
        if(e.getSource()==buttonB){
            answer='B';
            if(answer==answers[index]){
                answer_labelB.setForeground(new Color(25,255,0));
                correct_guess++;
            }
        }
        if(e.getSource()==buttonC){
            answer='C';
            if(answer==answers[index]){
                answer_labelC.setForeground(new Color(25,255,0));
                correct_guess++;
            }
        }
        if(e.getSource()==buttonD){
            answer='D';
            if(answer==answers[index]){
                answer_labelD.setForeground(new Color(25,255,0));
                correct_guess++;
            }
        }
        displayAnswer();
    }
}
