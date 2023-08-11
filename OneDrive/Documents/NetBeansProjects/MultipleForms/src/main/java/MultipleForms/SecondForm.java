
package MultipleForms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SecondForm extends JFrame implements ActionListener{
        private JLabel NameLabel = new JLabel("<name>");
        private JLabel SurnameLabel = new JLabel("<surname>");
        private JLabel GenderLabel = new JLabel("<gender>");
        private JLabel NationalityLabel = new JLabel("<nationality>");
        private JLabel HobbiesLabel = new JLabel("<hobbies>");
        private JButton FormBtn = new JButton("Go Back");
        private JButton CloseBtn = new JButton("Close");
        
        private JPanel Panel = new JPanel();
   
    
    
    public SecondForm(String Forname){
        setMinimumSize(new Dimension(400,300));
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(Forname);
        setLocationRelativeTo(null);
        setVisible(true);
        
        FormBtn.setForeground(Color.BLUE);
        CloseBtn.setForeground(Color.BLUE);
        
        Panel.setPreferredSize(new Dimension (330,220));
        Panel.setBorder(BorderFactory.createTitledBorder("Your Profile Information"));
        
        
        NameLabel.setForeground(Color.BLUE);
        SurnameLabel.setForeground(Color.BLUE);
        GenderLabel.setForeground(Color.BLUE);
        NationalityLabel.setForeground(Color.BLUE);
        HobbiesLabel.setForeground(Color.BLUE);
        NameLabel.setFont(new Font("Verdana",Font.BOLD,16));
        SurnameLabel.setFont(new Font("Verdana",Font.BOLD,16));
        GenderLabel.setFont(new Font("Verdana",Font.BOLD,16));
        NationalityLabel.setFont(new Font("Verdana",Font.BOLD,16));
        HobbiesLabel.setFont(new Font("Verdana",Font.BOLD,16));

        Panel.add(new JLabel("your full name is "));
        Panel.add(NameLabel);
        Panel.add(new JLabel("  "));
        Panel.add(SurnameLabel);
        Panel.add(new JLabel(" and you define yourself as  : "));
        Panel.add(GenderLabel);
        Panel.add(new JLabel(" You defined your nationality as : "));
        Panel.add(NationalityLabel);
        Panel.add(new JLabel(" Your hobbies are: "));
        Panel.add(HobbiesLabel);
        add(Panel);
        add(CloseBtn);
        add(FormBtn);
        setVisible(true);
        
        CloseBtn.addActionListener(this);
        FormBtn.addActionListener(this);        
        
    }
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == FormBtn){
            new FirstForm("First Form Opned!");
            dispose();
        }
        if(e.getSource() == CloseBtn){
            dispose();
        }
    }
    
    public void setName(String Value){
        this.NameLabel.setText(Value);
    }
    public void setSurname(String Value){
        this.SurnameLabel.setText(Value);
    }    
    public void setGender(String Value){
        this.GenderLabel.setText(Value);
    }
    public  void setNationalaties(String Value){
        this.NationalityLabel.setText(Value);
    }
    public void setHobbies(String Value){
        this.HobbiesLabel.setText(Value);
    }
}
