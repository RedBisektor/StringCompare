/**
 * User: Robin
 * Date: 1/22/13
 * Time: 2:34 AM
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.datatransfer.*;

public class Control extends JFrame{
    BackEnd model;
    compView view;
    JMenuBar bar;
    JMenu edit;
    JMenuItem copyFirst;
    JMenuItem copySecond;
    Clipboard board;

    public Control (String title)
    {
        //Setting up the window in general
        super(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setSize(300,425);
        setResizable(false);

        model = new BackEnd();
        view = new compView(model);
        board = Toolkit.getDefaultToolkit().getSystemClipboard();

        //Adding the Event Handler for Compare
        view.getSubmit().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleCompare();
            }
        });
        setupMenu();
        //Adding the Event Handler for copy first
        copyFirst.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.setContents(new StringSelection(view.getFirstString().getText()),null);
            }
        });
        copySecond.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                board.setContents(new StringSelection(view.getSecondString().getText()),null);
            }
        });

        getContentPane().add(view);
    }

    private void setupMenu()
    {
        bar = new JMenuBar();
        setJMenuBar(bar);

        edit = new JMenu("Edit");
        bar.add(edit);

        copyFirst = new JMenuItem("Copy initial string to ClipBoard");
        edit.add(copyFirst);

        copySecond = new JMenuItem("Copy compare string to ClipBoard");
        edit.add(copySecond);

    }
    private void handleCompare ()
    {
        if(view.getFirstString().getText().equals("") || view.getSecondString().getText().equals(""))
        {
            view.update("Invalid Input");
            return;
        }
        model.setFirstString(view.getFirstString().getText());
        model.setSecondString(view.getSecondString().getText());
        if (view.getInsensitive().isSelected())
        {
            if(model.CompareIgnoreCase())
            {
                view.update("The Strings are the same");
            }
            else
            {
                view.update("The Strings are not the same");
            }
        }
        else
        {
            if(model.Compare())
            {
                view.update("The Strings are the same");
            }
            else
            {
                view.update("The Strings are not the same");
            }
        }
    }

    public static void main (String[] args)
    {
        JFrame frame = new Control("String Compare App");
        frame.setVisible(true);

    }
}
