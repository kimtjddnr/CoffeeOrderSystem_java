import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Coffee2 extends Frame implements ActionListener
{
	int count=0;
	String show="";
	
	
	public Coffee2() 
	{

		JFrame frame=new JFrame("Coffee");
		frame.setBounds(0,0,625,1000);
		frame.setBackground(Color.black);
		

		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 18);
        Font font1 = new Font(Font.MONOSPACED, Font.BOLD, 22);
        
        
        
        
        Panel MenuPanel = new Panel();
        MenuPanel.setBackground(new Color(255, 255, 215));
        MenuPanel.setLayout(null);
        MenuPanel.setSize(0, 500);
        MenuPanel.setFont(font);
        
        String menu[] = {"Americano", "Late", "Cafe Mocha", "Cappuchino", "Flat white", "Plarocchino", "Irishcoffee", "Espresso"};
        int price[] = { 3000,3000,3000,3000,3000,3000,3000,3000 };
        JButton list[] = new JButton[menu.length];
        TextField number[] = new TextField[menu.length];
        Button add[] = new Button[menu.length];
        Button sub[] = new Button[menu.length];
        JButton save[] = new JButton[menu.length];
        Label PriceLabel[] = new Label[menu.length];

        
        for (int i = 0; i < menu.length; i++) {
        	 
            //set image to Button
            list[i] = new JButton(new ImageIcon("C:\\Users\\82108\\eclipse-workspace\\CoffeeOrderSystem\\image\\¾ÆÀÌ½º\\"+i+".png"));
            if (i < 4) {
                list[i].setBounds(25 + i * 150, 50, 100, 100);
            } else {
                list[i].setBounds(25 + (i - 4) * 150, 300, 100, 100);
            }
            
            //number
            number[i] = new TextField("0");
            number[i].setBackground(Color.white);
            number[i].setEditable(false);
            number[i].setBounds(list[i].getX() + 30, list[i].getY() + 130, 40, 20);
            
            // "+" 
            add[i] = new Button("+");
            add[i].setBounds(list[i].getX() + (100 - 20), number[i].getY(), 20, 20);
            add[i].setEnabled(false);
 
            // "-" 
            sub[i] = new Button("-");
            sub[i].setBounds(list[i].getX(), number[i].getY(), 20, 20);
            sub[i].setEnabled(false);
 
            
 
            // price
            PriceLabel[i] = new Label(price[i] + "won");
            PriceLabel[i].setBounds(list[i].getX() + 20, number[i].getY() - 25, 100, 20);
 
            //save
            save[i] = new JButton("save");
            save[i].setBounds(list[i].getX(), number[i].getY() + 30, 100, 20);
            save[i].setEnabled(false);
 
            MenuPanel.add(list[i]);
            MenuPanel.add(number[i]);
            MenuPanel.add(add[i]);
            MenuPanel.add(sub[i]);
            MenuPanel.add(PriceLabel[i]);
            MenuPanel.add(save[i]);
            
            
        }
        Panel ChangePanel = new Panel();
        ChangePanel.setBackground(new Color(255, 255, 215));
        Button hot = new Button("hot");
        Button cold = new Button("cold");
        hot.addActionListener(this);
        cold.addActionListener(this);
        ChangePanel.add(hot);
        ChangePanel.add(cold);
        
        ChangePanel.setBounds(250, 250, 100, 50);
        MenuPanel.add(ChangePanel);
        
        
        
        
        TextArea OrderText = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        OrderText.setText("   name        price        number        total\n\n");
        OrderText.setBackground(Color.white);
        OrderText.setEditable(false);
        OrderText.setFont(font1);
 
        
        Panel OrderPanel = new Panel();
        OrderPanel.setFont(font);
        OrderPanel.setBackground(new Color(255, 255, 215));
 
        Button bt1 = new Button("order");
        Button bt2 = new Button("clear");
        Button bt3 = new Button("exit");
        OrderPanel.add(bt1);
        OrderPanel.add(bt2);
        OrderPanel.add(bt3);

        
        bt1.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, OrderText.getText() + " The order is complete.");
                for (int i = 0; i < menu.length; i++) {
                    list[i].setEnabled(true);
                    sub[i].setEnabled(false);
                    add[i].setEnabled(false);
                    number[i].setText("0");
                    OrderText.setText("   name        price        number        total\n\n");
 
                }
            }
        });
 
        
        bt2.addActionListener(new ActionListener() {
 
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < menu.length; i++) {
                    list[i].setEnabled(true);
                    sub[i].setEnabled(false);
                    add[i].setEnabled(false);
                    number[i].setText("0");
                    OrderText.setText("   name        price        number        total\n\n");
 
                }
            }
        });
 
 
        
        
        bt3.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
 
 
        
        frame.add(MenuPanel, BorderLayout.NORTH);
        frame.add(OrderText, BorderLayout.CENTER);
        frame.add(OrderPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
 
        //event
        for (int i = 0; i < menu.length; i++) {
            int j = i;
 
            
            list[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    sub[j].setEnabled(true);
                    add[j].setEnabled(true);
                    list[j].setEnabled(false);
                    save[j].setEnabled(true);
 
                    count = 0;
                }
            });
 
            // "-" event
            sub[i].addActionListener(new ActionListener() {
 
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (count > 0) {
                        count = count - 1;
                        number[j].setText(count + "");
                        save[j].setEnabled(true);
                    } else {
                        sub[j].setEnabled(false);
                    }
                }
            });
            
            // "+" event
            add[i].addActionListener(new ActionListener() {
 
                @Override
                public void actionPerformed(ActionEvent e) {
                    count = count + 1;
                    number[j].setText(count + "");
                    save[j].setEnabled(true);
                    if (count > 0) {
                        sub[j].setEnabled(true);
                    }
                }
            });
            
            //save event
            save[i].addActionListener(new ActionListener() {
 
                @Override
                public void actionPerformed(ActionEvent e) {
                    show = list[j].getActionCommand();
                    OrderText.append("   " + show + "       " + price[j] + "        " + count + "         " + price[j] * count
                            + "won" + "\n");
                    save[j].setEnabled(false);
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
    }
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String str = e.getActionCommand();
		if(str.equals("cold"))
		{
			new Coffee2();
		}
		else if(str.equals("hot"))
		{
			new Coffee1();
		}	
	}
}
