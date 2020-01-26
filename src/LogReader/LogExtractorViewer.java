package LogReader;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileSystemView;

public class LogExtractorViewer extends JFrame implements  ActionListener 
{
	static JTextField t,t1,t2; 
	static Frame f; 
	static JButton b,b1,b2; 
	static JLabel l; 
	static JTextArea tArea;
	static JCheckBox c;
	LogExtractorViewer() 
	{ 
		
	} 
	public static void viewer() 
	{ 
		f  = new Frame("Unique Log Extractor"); 
		f.addWindowListener(new WindowAdapter() {public void windowClosing(WindowEvent windowEvent){System.exit(0);}}); 
		//f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		f.setLocation((dim.width/2-f.getSize().width/2)-250, (dim.height/2-f.getSize().height/2)-100);
		
		l = new JLabel("  Input field Name          ");
		l.setFont(new Font("Serif", Font.BOLD,13));

		
		LogExtractorViewer te = new LogExtractorViewer(); 
		b  = new JButton("Extract");
		b.setPreferredSize(new Dimension(90,20));
		b.addActionListener(te);
		b1 = new JButton("Input File Path");
		b1.setPreferredSize(new Dimension(125, 20));
		b1.addActionListener(te);
		b2 = new JButton("Output File Path");
		b2.setPreferredSize(new Dimension(125, 20));
		b2.addActionListener(te);
	
		t  = new JTextField(28);
		t1 = new JTextField(28);
		t2 = new JTextField(28);
		
		//JPanel p = new JPanel(new GridLayout(7, 2, 20, 4));
		JPanel p = new JPanel(new FlowLayout());
		p.setBorder(BorderFactory.createTitledBorder("Hello Arcsight V1.0: "));
				
		c= new JCheckBox();
		c.setText("Key-vale pair");
		c.setSelected(true);
		c.addActionListener(new ActionListener() 
		{
		    @Override
		    public void actionPerformed(ActionEvent event)
		    {
		        JCheckBox cb = (JCheckBox) event.getSource();
		        if (cb.isSelected()) 
		        {
		    		l.setText("  Input field Name          ");
		        } 
		        else 
		        {
		    		l.setText("   Input UniqueId            ");
		        }
		    }
		});
		//checkbox.setIcon(icon);
		
	 
		p.add(t);
		p.add(b1);
		p.add(t1);
		p.add(b2);
		p.add(t2);
		p.add(l);
		p.add(b); 
		p.add(c);
		f.add(p); 
		f.setSize(500,250); 
        f.show();
	} 
	public void actionPerformed(ActionEvent e) 
	{ 
		String s = e.getActionCommand(); 
		
		
		if (s.equals("Extract")) 
		{ 				
			
			if(t.getText().equals("")|t1.getText().equals("")|t2.getText().equals(""))
			{
				 JOptionPane.showMessageDialog(this,"Please Input",
						   "Warning",JOptionPane.WARNING_MESSAGE);    
			}
			else
			{
				MyFileReader.myReader(t.getText(),t1.getText(),t2.getText());
				
				if(MyFileReader.flags==1)
				{
					 JOptionPane.showMessageDialog(this,"Done!!!!!!","Successful",JOptionPane.PLAIN_MESSAGE);
				}
				else
				{
					 JOptionPane.showMessageDialog(this,"Invalid Input!!!","Error",JOptionPane.ERROR_MESSAGE);
	
				}
					
			}
		} 
		else if(s.equals("Output File Path"))
		{
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			int returnValue = jfc.showOpenDialog(null);
			//int returnValue = jfc.showSaveDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) 
			{
				File selectedFile = jfc.getSelectedFile();
				t1.setText( selectedFile.getAbsolutePath());
			}
		}
		else
		{
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			int returnValue = jfc.showOpenDialog(null);
			//int returnValue = jfc.showSaveDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) 
			{
				File selectedFile = jfc.getSelectedFile();
				t.setText( selectedFile.getAbsolutePath());
			}
		}
	} 

}
