import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.*;

public class calculator extends JFrame
{
	private JButton numbers[], add, substract, divide, multiply, equals;
	private String temp1="", temp2="", string_answer="";
	private JTextField display;
	private JPanel content_panel;
	private double  dtemp1=0, dtemp2=0, operation_selected = 0;
	
	private hNumber number_handler;
	
	private hOperation operation_handler;
	
	private void handle_buttons()
	{
        numbers = new JButton[10];
    	add = new JButton("+");
    	substract = new JButton("-");
    	divide = new JButton("/");
    	multiply = new JButton("*");
    	equals = new JButton("=");
    	
        Dimension button_dimension = new Dimension(75, 25);
    	
        for(int i=0;i<numbers.length;i++)
    	{
    		numbers[i] = new JButton(""+i);
    		numbers[i].setVisible(true);
    		numbers[i].setPreferredSize(button_dimension);
    	}
        
        add.setVisible(true);
        add.setPreferredSize(button_dimension);
        
        substract.setVisible(true);
        substract.setPreferredSize(button_dimension);
        
        multiply.setVisible(true);
        multiply.setPreferredSize(button_dimension);
        
        divide.setVisible(true);
        divide.setPreferredSize(button_dimension);
        
        equals.setVisible(true);
        equals.setPreferredSize(button_dimension);    	
    	
	}
	
	private void handle_content()
	{
		display = new JTextField(null, 21);
		
    	display.setEditable(false);
    	display.setCaretColor(Color.GREEN);
    	display.setBackground(Color.GRAY);
    	
    	display.setSize(230, 50);
 

    	
    	
    	content_panel = new JPanel();
    	
    	content_panel.setBackground(Color.BLACK);
    	
    	
    	
    	content_panel.setLayout(new FlowLayout());
    	
    	handle_events();
    	
    	add_buttons();
    	
    	this.setContentPane(content_panel);
    	
    	this.setSize(250,210);
    	this.setResizable(false);
    	
    	this.setVisible(true);
    	
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
	}
	
	private void add_buttons()
	{
		content_panel.add(display);
		
		for(int i=1;i<10;i++)
		content_panel.add(numbers[i]);
		
		
		content_panel.add(add);
		content_panel.add(numbers[0]);
		content_panel.add(substract);
		content_panel.add(multiply);
		content_panel.add(equals);
		content_panel.add(divide);
	}
	
	private void handle_events()
	{
		number_handler    = new hNumber();
		operation_handler = new hOperation();
		
		
		for(int i=0;i< numbers.length;i++)
		{
			numbers[i].addActionListener(number_handler);
		}
		
		add.addActionListener(operation_handler);
		substract.addActionListener(operation_handler);
		multiply.addActionListener(operation_handler);
		substract.addActionListener(operation_handler);
		equals.addActionListener(operation_handler);
	}
	
	
	
    public calculator()
    {
    	super("Calculator");
    	
    	handle_buttons();
    	handle_content();  
  
    }
    
    
    public static void main(String[] args)
	{
      calculator ceva = new calculator();
    
	}
    
   
    
    
    private class hNumber implements ActionListener
    {
    	public void actionPerformed(ActionEvent event)
    	{
    		JButton source = (JButton) event.getSource();
    		for(int i=0;i< numbers.length;i++)
    			if(source == numbers[i])
    			{
    				if(operation_selected == 0)
    				{
                      
                    	
                    	   temp1+=i;
                    	   
                    	   dtemp1 = (dtemp1*10)+i;
                    	   
                    	   System.out.println(dtemp1);
                    	   
                    	   display.setText(temp1);
                    	
    		        }    				
    				else
    					{
    					   temp2+=i;
                      	   
                      	   dtemp2 = (dtemp2*10)+i;
                      	   
                      	   System.out.println(dtemp2);
                      	   
                      	   display.setText(temp2);
    					}
    				
    		        
    				
    	         }
    	}
    }
    
    private double compute_result()
    {
    	if(operation_selected == 1)
    		return dtemp1+dtemp2;
    	
    	if(operation_selected == 2)
    		return dtemp1-dtemp2;
    	
    	if(operation_selected == 3)
    		return dtemp1*dtemp2;
    	
    	if(operation_selected == 4)
    		return dtemp1/dtemp2;
    	
    	return dtemp1;
    	
    }
    
    
    private class hOperation implements ActionListener
    {
    	public void actionPerformed(ActionEvent event)
    	{
    		JButton source = (JButton) event.getSource();
   
    			if(source == add)
    			{
                    operation_selected = 1;
    			}
    			if(source == substract)
    			{
                    operation_selected = 2;
    			}
    			if(source == multiply)
    			{
                    operation_selected = 3;
    			}
    			if(source == divide)
    			{
                    operation_selected = 4;
    			}
    			if(source == equals)
    			{            
                    string_answer+=compute_result();
				    display.setText(string_answer);
				    wipe_memory();
    			}
    	}
    }
    
    private void wipe_memory()
    {
    	dtemp1=0;
    	dtemp2=0;
    	temp1="";
    	temp2="";
    	string_answer="";
    	operation_selected = 0;
    			
    			
    }
    
    
    
}
