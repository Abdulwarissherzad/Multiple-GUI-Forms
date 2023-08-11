
package MultipleForms;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class FirstForm extends JFrame implements ActionListener{
    private JTextField NameTxt = new JTextField(15);
    private JTextField SurNameTxt = new JTextField(15);
    
    private JRadioButton MaleRadio = new JRadioButton("Male");
    private JRadioButton FamaleRadio = new JRadioButton("Female");
    
    private JCheckBox Hobey1 = new JCheckBox("Reading");
    private JCheckBox Hobey2 = new JCheckBox("Sport");
    private JCheckBox Hobey3 = new JCheckBox("Golf");
    
    private String [] Nation = {"Afghan","Pakistan","German", "Grace","Turkish","Cyprut"};
    
    private JComboBox NationalityCombo = new JComboBox(Nation);
    
    private JLabel FormLable = new JLabel("Please fell the following form!");
    
    private JButton SubmitBtn = new JButton("Submite");
    private JButton ClearBtn = new JButton("Clear");
    private JButton CloseBtn = new JButton("Close");
    
    private ButtonGroup GenderGroup = new ButtonGroup();
    
    private JPanel Panel = new JPanel();
    
    
    public FirstForm(String FormName){
        setLayout(new FlowLayout());
        setMinimumSize(new Dimension(440,300));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle(FormName);// This is importan, Learned here, it's taking the class name from above.
        setVisible(true);
        setLocationRelativeTo(null);
        
        GenderGroup.add(MaleRadio);
        GenderGroup.add(FamaleRadio);
        
        Panel.setPreferredSize(new Dimension(330, 220));
        Panel.setBorder(BorderFactory.createTitledBorder("Please fill the form!"));
        
        SubmitBtn.setBackground(Color.GREEN);
        ClearBtn.setBackground(Color.GREEN);
        CloseBtn.setBackground(Color.red);
        
        FormLable.setForeground(Color.BLUE);
        FormLable.setFont(new Font("Verdana",Font.BOLD,18));
        
        Panel.add(FormLable);
        Panel.add(new JLabel("Enter Name            :"));
        Panel.add(NameTxt);
        Panel.add(new JLabel("Enter Surname      :"));
        Panel.add(SurNameTxt);
        Panel.add(new JLabel("Select Your Gender           :"));
        Panel.add(MaleRadio);
        Panel.add(FamaleRadio);
        Panel.add(new JLabel("Select Your Nationality                  :"));
        Panel.add(NationalityCombo);
        Panel.add(new JLabel("Select Your Hobbies:"));
        Panel.add(Hobey1);
        Panel.add(Hobey2);
        Panel.add(Hobey3);
        Panel.add(SubmitBtn);
        Panel.add(ClearBtn);
        Panel.add(CloseBtn);
        add(Panel);
        setVisible(true);
        
        SubmitBtn.addActionListener(this);
        ClearBtn.addActionListener(this);        
        CloseBtn.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
     
        if(e.getSource() == SubmitBtn){
            //Validation
            if(VolidationFields() == true){
                String Hobbies = "";
                SecondForm SecondFormObject = new SecondForm("Profile Information");
                SecondFormObject.setName(this.NameTxt.getText());
                SecondFormObject.setSurname(this.SurNameTxt.getText());
                
                if(this.MaleRadio.isSelected()){
                    SecondFormObject.setGender("Male");
                }
                if(this.FamaleRadio.isSelected()){
                    SecondFormObject.setTitle("Famal");
                }
                //This is ComboBox
                SecondFormObject.setNationalaties(""+this.NationalityCombo.getSelectedItem());
                //The addition assignment operator, +=, is a shorthand way to add a value to a variable.
                if(this.Hobey1.isSelected()){
                    Hobbies += " Reading ";
                }
                if(this.Hobey2.isSelected()){
                    Hobbies += " Sport ";
                }
                if(this.Hobey3.isSelected()){
                    Hobbies +=" Golf ";
                }   
                SecondFormObject.setHobbies(Hobbies);   
                dispose(); //When Finished it should be closed
            }
        }
        if(e.getSource() == ClearBtn){
            this.NameTxt.setText("");
            this.SurNameTxt.setText("");
            this.GenderGroup.clearSelection();
            this.NationalityCombo.setSelectedIndex(0);
            this.Hobey1.setSelected(false);
            this.Hobey2.setSelected(false);
            this.Hobey3.setSelected(false);
        }
        else if(e.getSource()== CloseBtn){
            this.dispose();
        }
        
    }
    private boolean VolidationFields(){
        /*
        This part of Validation is important: if it's true so first part which is control true will be passed to the
        class, otherwise the next fields the once who had not volidation will be passed to the class above.
        */
        boolean Control = true;
        
        if(this.NameTxt.getText().length()<1){
            JOptionPane.showMessageDialog(Panel,"Please Enter Your Name!", "Name Error Massage",JOptionPane.ERROR_MESSAGE);
            Control = false;
        }
        if(this.SurNameTxt.getText().length()<1){
            JOptionPane.showMessageDialog(Panel,"Please Enter Your Surename!", "Surname Error Massage",JOptionPane.ERROR_MESSAGE);
            Control = false;
        }
        else if((this.MaleRadio.isSelected() == false) && (this.FamaleRadio.isSelected() == false)){
            JOptionPane.showMessageDialog(Panel,"Please Select one radio button!", "Radio Button Error",JOptionPane.ERROR_MESSAGE);
            Control = false;
        }
          //If it's true the contro will pass the true message, otherwise the fell message.
        return Control;   
    }
}
