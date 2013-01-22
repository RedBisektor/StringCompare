/**
 * User: Robin
 * Date: 1/22/13
 * Time: 2:06 AM
 */

import javax.swing.*;

public class compView extends JPanel{
    BackEnd model;
    JTextField first;
    JTextField second;
    JButton comp;
    JLabel aLabel;
    JCheckBox insensitive;
    JCheckBox sensitive;
    ButtonGroup Sensitivity;
    JTextArea output;

    public compView (BackEnd m)
    {
        model = m;
        setSize(300,400);
        setLayout(null);

        //Setting up the Interface
        //Input first string
        aLabel = new JLabel ("Initial String");
        aLabel.setLocation(10,10);
        aLabel.setSize(200,20);
        add(aLabel);

        first = new JTextField ("");
        first.setLocation(10,30);
        first.setSize(250,20);
        add(first);

        //Input second string
        aLabel = new JLabel ("String to compare to");
        aLabel.setLocation(10,60);
        aLabel.setSize(200,20);
        add(aLabel);

        second = new JTextField ("");
        second.setLocation(10,80);
        second.setSize(250,20);
        add(second);

        //Setting up the Compare Button
        comp = new JButton("Compare");
        comp.setLocation(10,120);
        comp.setSize(100,50);
        add(comp);

        //Setting up the Check Boxes
        insensitive = new JCheckBox("Case Insensitive");
        insensitive.setLocation(120,125);
        insensitive.setSize(150, 20);
        insensitive.setSelected(true);
        add(insensitive);

        sensitive = new JCheckBox("Case Sensitive");
        sensitive.setLocation(120,150);
        sensitive.setSize(150, 20);
        sensitive.setSelected(false);
        add(sensitive);

        Sensitivity = new ButtonGroup();
        Sensitivity.add(insensitive);
        Sensitivity.add(sensitive);

        //Setting up the Text Area
        output = new JTextArea("");
        JScrollPane scroll = new JScrollPane(output,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setLocation(10,175);
        scroll.setSize(250,200);
        add(scroll);
    }

    //Get Operations
    public JTextArea getOutput (){return output;}
    public JButton getSubmit () {return comp;}
    public JTextField getFirstString () {return first;}
    public JTextField getSecondString () {return second;}
    public JCheckBox getInsensitive () {return insensitive;}
    public JCheckBox getSensitive () {return sensitive;}

    public void update (String Message)
    {
        output.append(Message + '\n');
        output.setCaretPosition(output.getDocument().getLength());
    }

}
