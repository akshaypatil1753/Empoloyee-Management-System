
package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener {
    
    Choice choiceEMPID;
    JButton delete,back;
   
    
    RemoveEmployee(){
        JLabel label = new JLabel("Employee ID");
        label.setBounds(50,50,100,30);
        label.setFont(new Font("Tahoma",Font.BOLD,15));
        add(label);
        
        choiceEMPID = new Choice();
        choiceEMPID.setBounds(200,50,150,30);
        add(choiceEMPID);
        
        try{
            Conn c = new Conn();
            java.sql.ResultSet resultSet = c.statement.executeQuery("select * from employee");
            while(resultSet.next()){
                choiceEMPID.add(resultSet.getString("empID"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel labelname = new JLabel("Name");
        label.setBounds(50,100,100,30);
        label.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelname);
        
        JLabel textname = new JLabel();
        textname.setBounds(200,100,100,30);
        add(textname);
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50,150,100,30);
        labelphone.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelphone);
        
        JLabel textphone = new JLabel();
        textphone.setBounds(200,150,100,30);
        add(textphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,200,100,30);
        labelemail.setFont(new Font("Tahoma",Font.BOLD,15));
        add(labelemail);
        
        JLabel textemail = new JLabel();
        textemail.setBounds(200,200,100,30);
        add(textemail);
        
        try{
           Conn c = new Conn();
           java.sql.ResultSet resultSet = c.statement.executeQuery("select * from employee where empID='"+choiceEMPID.getSelectedItem()+"'");
           while(resultSet.next()){
               textname.setText(resultSet.getString("name"));
               textphone.setText(resultSet.getString("phone"));
               textemail.setText(resultSet.getString("email"));
               
               
               


           }
        }catch(Exception e){
            e.printStackTrace();
           
        }
        
        
        choiceEMPID.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                
           
        try{
            Conn c = new Conn();
           java.sql.ResultSet resultSet = c.statement.executeQuery("select * from employee where empID='"+choiceEMPID.getSelectedItem()+"'");
           while(resultSet.next()){
               textname.setText(resultSet.getString("name"));
               textphone.setText(resultSet.getString("phone"));
               textemail.setText(resultSet.getString("email"));
           }
        }catch(Exception E){
            E.printStackTrace();
        }
    }
    }); 
        
        
        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.black);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.black);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(700,80,200,200);
        add(img);
        
        ImageIcon i11 = new ImageIcon(ClassLoader.getSystemResource("icons/rback.png"));
        Image i22 = i11.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon i33 = new ImageIcon(i22);
        JLabel imgg = new JLabel(i33);
        imgg.setBounds(0,0,1120,630);
        add(imgg);
        
        setSize(1000,400);
        setLocation(300,150);
        setLayout(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==delete){
            try{
                Conn c = new Conn();
                String query = "delete from employee where empID ='"+choiceEMPID.getSelectedItem()+"'";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee deleted sucessfully");
                setVisible(false);
                new Main_class();
                        
            }catch(Exception E){
                E.printStackTrace();
            }
        } else{
            setVisible(false);
        }
    }
   public static void main(String[] args) 
   {
       new RemoveEmployee();
   }
}
