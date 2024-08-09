import java.awt.*;
import java.awt.event.*;  
import javax.swing.*; 
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//need ideas for making next DnD character and most online resources aren't cutting it so I'm making one myself
//other than the text thing (see below), this is pretty much all done
public class makePerson extends JFrame  {
	JButton b;
	
	JTextField f;
	JTextField f2;
	JTextField f3;
	JTextField f4;
	JTextField f5;
	JTextField f6;
	JTextField f7;
	//JTextField f8;
	
	List<String> genList;
	List<String> racList;
	List<String> classList;
	List<String> alignList;
	List<String> likeList;
	List<String> disList;
	List<String> backList;
	
	int gNum;
	int rNum;
	int cNum;
	int aNum;
	int lNum;
	int dNum;
	int bNum;
	int randNum;
	
	/*
	JLabel l;
	JLabel l2;
	JLabel l3;
	JLabel l4;
	JLabel l5;
	JLabel l6;
	JLabel l7;
	//JLabel l8;
	*/
	
	public int chooseRandNum(int a) { //chooses a random number between 0 and a
		Random r = new Random();
		return r.nextInt(a);
	}
	
	//TO DO (already done): write method that reads strings from text file and throws them into an array (or list or whatever is better idk)
	//will probablky need to make more Objects for this...
	public void addToList(List<String> a, String b) throws IOException {
		try {
			BufferedReader bf = new BufferedReader (new FileReader(b));
			String word = bf.readLine();
		
			while(word != null) {
				a.add(word);
				word = bf.readLine();
			}
			bf.close();
		}
		catch(Exception e2) {
			System.out.println("it didd't work :(");
			System.out.println(e2);
		}
		/*
		BufferedReader bf = new BufferedReader (new FileReader(b));
		String word = bf.readLine();
		
		while(word != null) {
			a.add(word);
			word = bf.readLine();
		}
		bf.close();
		*/
	}
	
	//TO DO: fix text boxes so that the words stop being cut off after the button is pressed...
	public makePerson() throws IOException {
		super("Person maker thingy");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		//creating everything
		b = new JButton("Click to generate!");
		b.setBounds(220, 100, 150, 30);
		
		f = new JTextField("Gender");
		f.setSize(600, 600);
		f.setEditable(false);
		
		f2 = new JTextField("Race");
		f2.setSize(800, 600);
		f2.setEditable(false);
		
		f3 = new JTextField("Class");
		f3.setSize(600, 600);
		f3.setEditable(false);
		
		f4 = new JTextField("Alignment");
		f4.setSize(800, 600);
		f4.setEditable(false);
		
		f5 = new JTextField("Like");
		f5.setSize(600, 600);
		f5.setEditable(false);
		
		f6 = new JTextField("Dislike");
		f6.setSize(600, 600);
		f6.setEditable(false);
		
		f7 = new JTextField("Background");
		f7.setSize(800, 600);
		f7.setEditable(false);
		//f8 = new JTextField("Gender");
		
		//init. lists, and using method put strings from files into each list
		genList = new ArrayList<String>();
		addToList(genList, "list_g.txt");
		racList = new ArrayList<String>();
		addToList(racList, "list_r.txt");
		classList = new ArrayList<String>();
		addToList(classList, "list_c.txt");
		alignList = new ArrayList<String>();
		addToList(alignList, "list_a.txt");
		likeList = new ArrayList<String>();
		addToList(likeList, "list_like.txt");
		disList = new ArrayList<String>();
		addToList(disList, "list_dis.txt");
		backList = new ArrayList<String>();
		addToList(backList, "list_b.txt");
		
		//NOTE: if anything is added/removed from any of the lists, the corresponding number(s) will need to be updated here
		gNum = 2;
		rNum = 66;
		cNum = 13;
		aNum = 9;
		lNum = 4;
		dNum = 4;
		bNum = 15;
		randNum = 0;
		
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//find random number in each list and set each text box to the corresponding string in each list
				
				randNum = chooseRandNum(gNum);
				f.setText(genList.get(randNum));
				
				randNum = chooseRandNum(rNum);
				f2.setText(racList.get(randNum));
				
				randNum = chooseRandNum(cNum);
				f3.setText(classList.get(randNum));
				
				randNum = chooseRandNum(aNum);
				f4.setText(alignList.get(randNum));
				
				randNum = chooseRandNum(lNum);
				f5.setText(likeList.get(randNum));
				
				randNum = chooseRandNum(dNum);
				f6.setText(disList.get(randNum));
				
				randNum = chooseRandNum(bNum);
				f7.setText(backList.get(randNum));
				
				
			}
		});
		
		add(b);
		add(f);
		add(f2);
		add(f3);
		add(f4);
		add(f5);
		add(f6);
		add(f7);

		setSize(800, 800);
		setVisible(true);
	}
	
	public static void main(String[] args) throws IOException {
		new makePerson();
	}
	
}