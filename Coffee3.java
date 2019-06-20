import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Coffee 

{
    private static final int Menu_Number = 8;
    JFrame frame = new JFrame("Coffee");
    String show;
    int[] Price;
    JButton ButtonList[] = new JButton[Menu_Number];
    Label PriceLabel[] = new Label[Menu_Number];
    TextField Number[] = new TextField[Menu_Number];
    JButton Save[] = new JButton[Menu_Number];
    Button add[] = new Button[Menu_Number];
    Button sub[] = new Button[Menu_Number];
    public Coffee()
    {
        frame.setBounds(0, 0, 650, 1000);
        frame.setBackground(Color.black);

        Font font = new Font(Font.SANS_SERIF, Font.ITALIC, 18);
        Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 15);

        Panel MenuPanel = new Panel();
        MenuPanel.setBackground(new Color(255,255,150));
        MenuPanel.setLayout(null);
        MenuPanel.setSize(500, 500);
        MenuPanel.setFont(font);

        

        for (int i = 0; i < Menu_Number; i++) 
        {
            // image
            ButtonList[i] = new JButton();
            if (i < 4) 
            {
                ButtonList[i].setBounds(25 + i * 150, 50, 100, 100);
            } else 
            {
                ButtonList[i].setBounds(25 + (i - 4) * 150, 300, 100, 100);
            }

            // number

            Number[i] = new TextField("0");
            Number[i].setBackground(Color.white);
            Number[i].setEditable(false);
            Number[i].setBounds(ButtonList[i].getX() + 30, ButtonList[i].getY() + 130, 30, 20);

            // "+"
            add[i] = new Button("+");
            add[i].setBounds(ButtonList[i].getX() + 80, Number[i].getY(), 20, 20);
            add[i].setEnabled(false);

            // "-"
            sub[i] = new Button("-");
            sub[i].setBounds(ButtonList[i].getX(), Number[i].getY(), 20, 20);
            sub[i].setEnabled(false);

            // price
            PriceLabel[i] = new Label();
            PriceLabel[i].setBounds(ButtonList[i].getX() + 15, Number[i].getY() - 25, 100, 20);

            // save
            Save[i] = new JButton("save");
            Save[i].setBounds(ButtonList[i].getX(), Number[i].getY() + 30, 100, 20);
            Save[i].setEnabled(false);

            MenuPanel.add(ButtonList[i]);
            MenuPanel.add(Number[i]);
            MenuPanel.add(add[i]);
            MenuPanel.add(sub[i]);
            MenuPanel.add(PriceLabel[i]);
            MenuPanel.add(Save[i]);
        }



        Panel ChangePanel = new Panel();
        ChangePanel.setBackground(new Color(255, 255, 150));
        Button hot = new Button("hot");
        Button cold = new Button("cold");

        ActionListener al = new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String str = e.getActionCommand();
                if (str.equals("cold")) {
                    setMenu("cold");
                } else if (str.equals("hot")) {
                    setMenu("hot");
                }
            }
        };

        hot.addActionListener(al);
        cold.addActionListener(al);
        ChangePanel.add(hot);
        ChangePanel.add(cold);
        ChangePanel.setBounds(250, 250, 100, 50);
        MenuPanel.add(ChangePanel);


        TextArea OrderText = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        OrderText.setText("     name               price        number        total\n\n");
        OrderText.setBackground(Color.white);
        OrderText.setEditable(false);
        OrderText.setFont(font1);

        Panel OrderPanel = new Panel();
        OrderPanel.setFont(font);
        OrderPanel.setBackground(new Color(255, 255, 150));

        Button bt1 = new Button("order");
        Button bt2 = new Button("clear");
        Button bt3 = new Button("exit");
        OrderPanel.add(bt1);
        OrderPanel.add(bt2);
        OrderPanel.add(bt3);



        bt1.addActionListener(new ActionListener() 
        {
            @Override

            public void actionPerformed(ActionEvent e)
            {
            	String n=OrderText.getText();
            	if(n.equals("     name               price        number        total\n\n"))
            	{
            		JOptionPane.showMessageDialog(null,"There is no coffee you ordered.");
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(null, OrderText.getText() + " The order is complete.");
            	}  
                for (int i = 0; i < Menu_Number; i++) 
                {
                    ButtonList[i].setEnabled(true);
                    sub[i].setEnabled(false);
                    add[i].setEnabled(false);
                    Number[i].setText("0");
                    OrderText.setText("     name               price        number        total\n\n");


                }

            }

        });



        bt2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                for (int i = 0; i < Menu_Number; i++)
                {
                    ButtonList[i].setEnabled(true);
                    sub[i].setEnabled(false);
                    add[i].setEnabled(false);
                    Number[i].setText("0");
                    OrderText.setText("     name               price        number        total\n\n");
                    
                }
            }
        });



        bt3.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

        });

        frame.add(MenuPanel, BorderLayout.NORTH);
        frame.add(OrderText, BorderLayout.CENTER);
        frame.add(OrderPanel, BorderLayout.SOUTH);
        frame.setVisible(true);



        // event

        for (int i = 0; i < Menu_Number; i++) 
        {
            int j = i;
            ButtonList[i].addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    sub[j].setEnabled(false);
                    add[j].setEnabled(true);
                    ButtonList[j].setEnabled(false);
                    Save[j].setEnabled(false);
                    Number[j].setText("0");
                }

            });



            // "-" event

            sub[i].addActionListener(new ActionListener()
            {

                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    int count = Integer.parseInt(Number[j].getText()) - 1;
                    if (count >= 0) {
                        Number[j].setText(Integer.toString(count));
                        Save[j].setEnabled(true);
                    }
                    if (count <= 0) {
                        sub[j].setEnabled(false);
                        Save[j].setEnabled(false);
                    }
                }
            });

            


            // "+" event

            add[i].addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    int count = Integer.parseInt(Number[j].getText()) + 1;
                    Number[j].setText(count + "");
                    Save[j].setEnabled(true);
                    if (count > 0) {

                        sub[j].setEnabled(true);
                    }
                }

            });



            // save event

            Save[i].addActionListener(new ActionListener() 
            {
                @Override
                public void actionPerformed(ActionEvent e) 
                {
                    int count = Integer.parseInt(Number[j].getText());
                    show = ButtonList[j].getActionCommand();
                    OrderText.append("   " + show + "       " + Price[j] + "        " + count + "         " + Price[j] * count + "won" + "\n");
                    Save[j].setEnabled(false);
                    ButtonList[j].setEnabled(true);
                    Number[j].setText("0");

                }

            });



        }

        // exit

        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e) 
            {
                System.exit(0);
            }
        });

        // init menu hot

        setMenu("hot");

    }

    // Set menu (Hot or Cold)

    private void setMenu(String hotCold) 
    {
        String[] Menu = null;
        if (hotCold.equals("hot")) 
        {
            Menu = new String[] { "Americano", "Cappuccino", "Caffe Latte", "hazelnut Latte", "Caramel macchiato", "Toffeenut Latte", "Green tea Latte", "Espresso" };
            Price = new int[] { 5000, 5000, 5000, 5000, 5000, 5000, 5000, 5000 };
        } 

        else if (hotCold.equals("cold"))
        {
            Menu = new String[] { "Vienna Coffee", "Ice Americano", "Cold Brew", "Dutch Coffee", "Ice Vanilla Latte", "Ice Hazelnut", "einspanner", "Ice Cafe Latte" };
            Price = new int[] { 3000, 3000, 3000, 3000, 3000, 3000, 3000, 3000 };
        }

        for (int i = 0; i < Menu_Number; i++) {
            PriceLabel[i].setText(Price[i] + "won");
            ButtonList[i].setText(Menu[i]);
            ButtonList[i].setIcon(new ImageIcon(hotCold + i + ".png")); 
            ButtonList[i].setEnabled(true);
            Number[i].setText("0");
            Number[i].setEditable(false);
            Save[i].setEnabled(false);
        }

    }



    public static void main(String[] args)

    {
        new Coffee();
    }

}