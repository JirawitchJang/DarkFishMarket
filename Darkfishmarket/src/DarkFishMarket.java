import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DarkFishMarket extends JFrame implements ActionListener {
    public String space = ("                                                                   ");
    public String tell = " Check Bill ";
    public ArrayList<String> code = new ArrayList<String>();

    private JLabel inTro;
    private JLabel info1;
    private JLabel info2;
    private JLabel info3;
    private JLabel question1;
    private JLabel question2;
    private JLabel question3;
    private JLabel kg1;
    private JLabel kg2;
    private JLabel kg3;
    private JTextField SalmonKg;// ช่องที่รับข้อมูลนน.ของปลา
    private JTextField SharkKg;// ช่องที่รับข้อมูลนน.ของปลา
    private JTextField WhaleKg;// ช่องที่รับข้อมูลนน.ของปลา
    private JButton buttonCheck;
    private Component labelSpace;
    private JTextField showTotalPrice;

    ImageIcon fish = new ImageIcon(getClass().getResource("1.jpg"));
    ImageIcon fish2 = new ImageIcon(getClass().getResource("2.jpg"));
    ImageIcon fish3 = new ImageIcon(getClass().getResource("3.jpg"));

    public DarkFishMarket() {
        super("DARK-FISH-MARKET");
        getContentPane().setBackground(new Color(180, 235, 250));// สี Background
        initComponentes();
        setSize(600, 850);
        setResizable(false);// ทำไห้ไม่สามารถขยายวินโดว์ได้

    }

    private void initComponentes() {

        inTro = new JLabel("__Welcome To DARK-FISH-MARKET__");
        inTro.setFont(new Font("MV Boli", Font.BOLD, 23));// ปรับตัวหนังสือ
        inTro.setForeground(new Color(255, 0, 0));// สีตัวหนังสือ

        info1 = new JLabel("1.Salmon meat     30$   per  kg. ");
        info1.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 13));
        info2 = new JLabel("2.Shark meat     99$   per kg. ");
        info2.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 13));
        info3 = new JLabel("3.Whale meat     150$   per kg. ");
        info3.setFont(new Font("MV Boli", Font.BOLD | Font.ITALIC, 13));

        question1 = new JLabel("How much would you accept this kind of fish?");
        question1.setFont(new Font("MV Boli", Font.BOLD, 13));
        question2 = new JLabel("How much would you accept this kind of fish?");
        question2.setFont(new Font("MV Boli", Font.BOLD, 13));
        question3 = new JLabel("How much would you accept this kind of fish?");
        question3.setFont(new Font("MV Boli", Font.BOLD, 13));

        kg1 = new JLabel(" kg.");
        kg1.setFont(new Font("MV Boli", Font.BOLD, 13));
        kg2 = new JLabel(" kg.");
        kg2.setFont(new Font("MV Boli", Font.BOLD, 13));
        kg3 = new JLabel(" kg.");
        kg3.setFont(new Font("MV Boli", Font.BOLD, 13));

        // ช่องที่รับค่านน.ของปลาที่รับเข้ามา
        SalmonKg = new JTextField(7);
        SalmonKg.setFont(new Font("MV Boli", Font.BOLD, 13));
        SalmonKg.setText("0");
        SharkKg = new JTextField(7);
        SharkKg.setFont(new Font("MV Boli", Font.BOLD, 13));
        SharkKg.setText("0");
        WhaleKg = new JTextField(7);
        WhaleKg.setFont(new Font("MV Boli", Font.BOLD, 13));
        WhaleKg.setText("0");

        // ช่องที่เเสดงราคาที่ลูกค่าต้องจ่าย
        showTotalPrice = new JTextField(15);
        showTotalPrice.setFont(new Font("MV Boli", Font.PLAIN, 15));
        showTotalPrice.setText(" Please choose order!! ");

        labelSpace = new JLabel(space);

        buttonCheck = new JButton(tell);
        buttonCheck.setFont(new Font("MV Boli", Font.BOLD, 17));
        buttonCheck.setBackground(new Color(240, 128, 128));

        JLabel displayField1 = new JLabel(fish);
        JLabel displayField2 = new JLabel(fish2);
        JLabel displayField3 = new JLabel(fish3);

        setLayout(new FlowLayout());

        add(inTro);

        add(displayField1);
        add(info1);
        add(question1);
        add(SalmonKg);
        add(kg1);

        add(displayField2);
        add(info2);
        add(question2);
        add(SharkKg);
        add(kg2);

        add(displayField3);
        add(info3);
        add(question3);
        add(WhaleKg);
        add(kg3);

        add(labelSpace);
        add(showTotalPrice);
        add(buttonCheck);

        buttonCheck.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message = "Total price is : %.2f$ ";
        float Selmon = Float.parseFloat(SalmonKg.getText());
        float Shark = Float.parseFloat(SharkKg.getText());
        float Whale = Float.parseFloat(WhaleKg.getText());
        float Price = calculate(Selmon, Shark, Whale);
        message = String.format(message, Price);
        showTotalPrice.setText(message);
        thankAndDiscount(Selmon, Shark, Whale, Price);

    }

    /**
     * //คำนวนราคาปลา
     * 
     * @param selmon จำนวนนน.ของเนื้อปลาเซลม่อนที่รับเข้ามาในหน่วยของกิโลกรัม
     * @param shark  จำนวนนน.ของเนื้อปลาฉลามที่รับเข้ามาในหน่วยของกิโลกรัม
     * @param whale  จำนวนนน.ของเนื้อวาฬที่รับเข้ามาในหน่วยของกิโลกรัม
     * @return totalPrice ราคาที่ได้จากการคำนวนในหน่วยเงิน ดอลลาร์
     */
    float calculate(float selmon, float shark, float whale) {
        float totalselmon = selmon * 30;
        float totalshark = shark * 99;
        float totalwhale = whale * 150;
        float totalPrice = totalselmon + totalshark + totalwhale;
        return totalPrice;
    }

    /**
     * คำวนส่วนลดเเละทำการขอบคุณ
     * 
     * @param selmon จำนวนนน.ของเนื้อปลาเซลม่อนที่รับเข้ามาในหน่วยของกิโลกรัม
     * @param shark  จำนวนนน.ของเนื้อปลาฉลามที่รับเข้ามาในหน่วยของกิโลกรัม
     * @param whale  จำนวนนน.ของเนื้อวาฬที่รับเข้ามาในหน่วยของกิโลกรัม
     */
    protected void thankAndDiscount(float selmon, float shark, float whale, float price) {
        String code1 = "65362943";
        String code2 = "65362942";
        String code3 = "65362941";
        float finalPrice;

        if (selmon == 0 & shark == 0 & whale == 0) {
            JOptionPane.showMessageDialog(this, " You haven't selected an order yet. ");
        } else {
            String discount = JOptionPane.showInputDialog(" Enter your discount code : ");
            if (discount.equals(code1) | discount.equals(code2) | discount.equals(code3)) {
                finalPrice = (float) (price - (price * 0.2));
                JOptionPane.showMessageDialog(this,
                        " Congratulations you get a discount 20%. Total Price only" + finalPrice + "$");
                showTotalPrice.setText("Total price is : " + finalPrice);

            } else {
                finalPrice = price;
                JOptionPane.showMessageDialog(this,
                        "Ohh!!! Your discount code is invalid. Total Price only" + finalPrice + "$");
            }
            JOptionPane.showMessageDialog(this, " Thank you for your support. Hope you are happy for our service :) ");
        }
    }

    public static void main(String[] args) throws Exception {

        new DarkFishMarket().setVisible(true);
        
    }
}