import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.sql.SQLException;

class Form1 extends Frame implements ActionListener,FocusListener,ItemListener
{
	static Connection con=null;
	static Statement st=null;
	static ResultSet rs=null;
 Label l1, l2, l3, l4, l5, l6, l7;
 Button b1,b2,b3,b4,b5;
 TextField t1, t2, t3;
 Checkbox c1, c2, c3, c4, c5;
 Checkbox cb1, cb2;
 CheckboxGroup cbg;
 Choice ch1, ch2;
 List li1;
 TextArea ta1;
 
 String a="",b="",c="",d="",e="",f="",g="",h="";
 
 String uk[]={"Dehradun","Nanitial","Rudraprayag"};
 String up[]={"Lucknow","Jhansi","Prayagraj","Firozabad"};
 String mh[]={"Mumbai","Pune","Panvel",};
 String tn[]={"Chennai","Coimbatore","Tripura"};
 String goa[]={"Panji","Margao","Ponda"};
 
 Form1()
 {
  l1=new Label("NAME:");
  l1.setBounds(10,50,100,20);
  t1=new TextField(20);
  t1.addFocusListener(this);
  t1.setBounds(110,50,150,20);
  
  l2=new Label("FATHER'S NAME:");
  l2.setBounds(10,80,100,20);
  t2=new TextField(20);
  t2.addFocusListener(this);
  t2.setBounds(110,80,150,20);
  
  l3=new Label("GENDER:");
  l3.setBounds(10,110,100,20);
  cbg=new CheckboxGroup();
  cb1=new Checkbox("Male",false,cbg);
  cb1.setBounds(110,110,50,20);
  cb2=new Checkbox("Female",false,cbg);
  cb2.setBounds(160,110,60,20);
  
  l4=new Label("HOBBIES:");
  l4.setBounds(10,140,100,20);
  c1=new Checkbox("Drawing");
  c1.setBounds(110,140,70,20);
  c2=new Checkbox("Playing Cricket");
  c2.setBounds(180,140,100,20);
  c3=new Checkbox("Listening Songs");
  c3.setBounds(110,170,100,20);
  c4=new Checkbox("Travelling");
  c4.setBounds(220,170,100,20);
  c5=new Checkbox("Others");
  c5.setBounds(110,200,60,20);
  t3=new TextField(20);
  t3.setBounds(170,200,100,20);
  
  
  l5=new Label("STATE");
  l5.setBounds(10,230,100,20);
  ch1=new Choice();
  ch1.add("Uttarakhand");
  ch1.add("Uttar Pradesh");
  ch1.add("Maharashtra");
  ch1.add("Tamilnadu");
  ch1.add("Goa");
  ch1.addItemListener(this);
  ch1.setBounds(110,230,100,20);
  
  l6=new Label("CITY:");
  l6.setBounds(10,260,100,20);
  ch2=new Choice();
  ch2.setBounds(110,260,100,20);
  
  l7=new Label("EDUCATION:");
  l7.setBounds(10,290,100,20);
  li1=new List();

  li1.add("Matric pass");
  li1.add("10th Pass");
  li1.add("12th Pass");
  li1.add("Undergraduate");
  li1.add("Postgraduate");
  li1.add("None");
  li1.setBounds(110,290,120,60);
  
  b1=new Button("SUMBIT");
  b1.setBounds(10,370,150,40);
  b1.addActionListener(this);
  
  b2=new Button("Insert");
  b2.setBounds(170,370,150,40);
  b2.addActionListener(this);
  
  b3=new Button("Select");
  b3.setBounds(10,410,150,40);
  b3.addActionListener(this);
  
  b4=new Button("Delete");
  b4.setBounds(170,410,150,40);
  b4.addActionListener(this);
  
  b5=new Button("Update");
  b5.setBounds(100,450,150,40);
  b5.addActionListener(this);
  
  ta1=new TextArea();
  ta1.setBounds(10,470,300,200);
  
  add(l1);
  add(t1);
  add(l2);
  add(t2);
  add(l3);
  add(cb1);
  add(cb2);
  add(l4);
  add(c1);
  add(c2);
  add(c3);
  add(c4);
  add(c5);
  add(t3);
  add(l5);
  add(ch1);
  add(l6);
  add(ch2);
  add(l7);
  add(li1);
  add(b1);
  add(b2);
  add(b3);
  add(b4);
  add(b5);
  add(ta1);
  
  setSize(320,620);
  setLayout(null);
  setVisible(true);
 }
	
 public void actionPerformed(ActionEvent ae)
 {
  if(ae.getSource()==b1)
  {
	  a=t1.getText();
	  b=t2.getText();
	  
	if(cb1.getState()==true)
	c=cb1.getLabel();
	else if(cb2.getState()==true)
	c=cb2.getLabel();

	d="";
  if(c1.getState()==true)
    d=d+" "+c1.getLabel();
   if(c2.getState()==true)
    d=d+" "+c2.getLabel();
   if(c3.getState()==true)
    d=d+" "+c3.getLabel();
   if(c4.getState()==true)
    d=d+" "+c4.getLabel();
   if(c5.getState()==true)
    d=d+" "+t3.getText();
   
   e=ch1.getSelectedItem();
   f=ch2.getSelectedItem();
   g=li1.getSelectedItem();
   
   ta1.append(a);
   ta1.append(b);
   ta1.append(c);
   ta1.append(d);
   ta1.append(e);
   ta1.append(f);
   ta1.append(g);
  }
   
   if(ae.getSource()==b2)
   {
	   connectToDB();
	   try 
	   {
	   st.executeUpdate("insert into form(Name,F_Name,Gender,Hobbies,State,City,Edu) values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"')");
	   System.out.println("Record Insert Successfully ");
	   }
	   catch(SQLException ex)
	   {

	   }
   }
 }
  
public void itemStateChanged(ItemEvent ie)
{
	if(ie.getSource()==ch1)
	{
		if(ch1.getSelectedItem().equals("Uttarakhand"))
		{
			ch2.removeAll();
			for(int i=0;i<uk.length;i++)
			{
				ch2.add(uk[i]);
			}
		}
	
		if(ch1.getSelectedItem().equals("Uttar Pradesh"))
		{
			ch2.removeAll();
			for(int i=0;i<up.length;i++)
			{
				ch2.add(up[i]);
			}
		}
			
			if(ch1.getSelectedItem().equals("Maharashtra"))
			{
				ch2.removeAll();
				for(int i=0;i<mh.length;i++)
				{
					ch2.add(mh[i]);
				}
			}
			
			if(ch1.getSelectedItem().equals("Tamilnadu"))
			{
				ch2.removeAll();
				for(int i=0;i<tn.length;i++)
				{
					ch2.add(tn[i]);
				}
			}
			
			if(ch1.getSelectedItem().equals("Goa"))
			{
				ch2.removeAll();
				for(int i=0;i<goa.length;i++)
				{
					ch2.add(goa[i]);
				}
			}
	}
  }

			
	
		
	


	public void focusLost(FocusEvent fe)
	{
		if(fe.getSource()==t1)
		{
			if(t1.getText().length()==0)
			t1.setText("TF1 CAN'T BE EMPTY");
		}
		
		if(fe.getSource()==t2)
		{
			if(t2.getText().length()==0)
			t2.setText("TF2 CAN'T BE EMPTY");
		}
		
		
	}
	
	public void focusGained(FocusEvent fe)
	{
	}
	
	public static void main(String []args)
	{
	new Form1();
	}
	
	static void connectToDB()
	{
	try
	{  
	Class.forName("com.mysql.jdbc.Driver");  
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bhuvan","root","yash1234");  
	System.out.println("Database Connected ");
	st=con.createStatement();
	}
	catch(Exception exx)
	{ 
	System.out.println(exx);
	}  
	}
 }
 

