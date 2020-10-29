import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.*;

public class Panel extends JPanel {
    JButton numbers[] = new JButton[10];
    JTextField textField = new JTextField();
    Font font = new Font("Calibri",Font.BOLD, 20);
    JButton dat , equals, back, del, inver;
    JButton plus, minus, div, mult;
    String a, b;
    double aDouble, bDouble;
    int sPlus, sMinus, sDiv, sMult, sDat = 0;

    public Panel(){
        setLayout(null);
        setBackground(Color.yellow);

        textField.setBounds(10,10,130,60);
        textField.setEditable(false);
        textField.setFont(font);
        add(textField);

        numbers[0] = new JButton("0");
        numbers[0].setBounds(80,290,60,60);
        numbers[0].setFont(font);
        numbers[0].addActionListener(actionEvent -> textField.setText(textField.getText() + "0"));
        numbers[0].setBackground(Color.cyan);
        add(numbers[0]);

        for (int i = 0; i < 10; i ++){
            numbers[i] = new JButton(i +"");
            add(numbers[i]);
            numbers[i].setFont(font);
            int finalI = i;
            numbers[i].addActionListener(actionEvent -> textField.setText(textField.getText() + finalI + ""));
            numbers[i].setBackground(Color.cyan);
        }
        for (int x = 0; x < 3; x ++){
            for (int y = 0; y < 3; y ++){
                numbers[x + 1 + y * 3].setBounds(x * 70 + 10,y * 70 + 80, 60,60);
            }
        }

        dat = new JButton(".");
        dat.setBounds(10, 290,60,60);
        dat.setFont(font);
        add(dat);
        dat.addActionListener(actionEvent -> {
            if (sDat == 0) {
                textField.setText(textField.getText() + ".");
                sDat = 1;
            }
        });

        inver = new JButton("+/-");
        inver.setBounds(10, 360,60,60);
        inver.setFont(font);
        add(inver);
        inver.addActionListener(actionEvent -> {
            sDat = 1;
            a = textField.getText();
            aDouble = Double.parseDouble(a);
            if (aDouble > 0){
                textField.setText("-" + textField.getText());
            }
            if (aDouble < 0){
                textField.setText(null);
                aDouble = aDouble * (-1);
                textField.setText(aDouble + textField.getText() + "");
            }
        });

        back = new JButton("<");
        back.setBounds(150, 10,60,60);
        back.setFont(font);
        add(back);
        back.addActionListener(actionEvent -> textField.setText(textField.getText().substring(0, textField.getText().length() - 1)));

        del = new JButton("C");
        del.setBounds(220, 10,60,60);
        del.setFont(font);
        add(del);
        del.addActionListener(actionEvent -> {
            textField.setText(null);
            deleteVar();
        });

        equals = new JButton("=");
        equals.setBounds(150, 290,60,60);
        equals.setFont(font);
        add(equals);
        equals.addActionListener(actionEvent -> {
            sDat = 1;
            b = textField.getText();
            aDouble = Double.parseDouble(a);
            bDouble = Double.parseDouble(b);

            if (sPlus == 1){
                textField.setText(aDouble + bDouble + "");
                deleteVar();
            }

            if (sMinus == 1){
                textField.setText(aDouble - bDouble + "");
                deleteVar();
            }

            if (sMult == 1){
                textField.setText(aDouble * bDouble + "");
                deleteVar();
            }

            if (sDiv == 1){
                if (bDouble == 0) {
                    textField.setText(null);
                    textField.setText("делить нельзя" + textField.getText());
                }
                else {
                    textField.setText(aDouble / bDouble + "");
                    deleteVar();
                }
            }

        });

        plus = new JButton("+");
        plus.setBounds(220, 80,60,60);
        plus.setFont(font);
        add(plus);
        plus.addActionListener(actionEvent -> {
            a = textField.getText();
            textField.setText(null);
            sPlus = 1;
            sDat = 0;
        });

        minus = new JButton("-");
        minus.setBounds(220, 150,60,60);
        minus.setFont(font);
        add(minus);
        minus.addActionListener(actionEvent -> {
            a = textField.getText();
            textField.setText(null);
            sMinus = 1;
            sDat = 0;
        });

        mult = new JButton("*");
        mult.setBounds(220, 220,60,60);
        mult.setFont(font);
        add(mult);
        mult.addActionListener(actionEvent -> {
            a = textField.getText();
            textField.setText(null);
            sMult = 1;
            sDat = 0;
        });

        div = new JButton("/");
        div.setBounds(220, 290,60,60);
        div.setFont(font);
        add(div);
        div.addActionListener(actionEvent -> {
            a = textField.getText();
            textField.setText(null);
            sDiv = 1;
            sDat = 0;
        });
    }
    public void deleteVar(){
        aDouble = 0;
        bDouble = 0;
        sMult = 0;
        sPlus = 0;
        sMinus = 0;
        sDiv = 0;
    }
}
