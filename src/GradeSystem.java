/////////////////////////////////////
///  David Mulhall                ///
///                               /// 
///  B00107874 - Software Dev.    ///
///                               /// 
///  Assignment 3 - Grade system  ///
///                               ///
///  Date:  05/03/2018            ///
/////////////////////////////////////

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class GradeSystem extends JFrame implements ActionListener  {

	private static final long serialVersionUID = 1L;
	public JPanel  contentPane,hostPanel,menuPanel,infoPanel,averagePanel,highestPanel,lowestPanel,sortPanel,searchPanel;
	public JPanel[] panelArray = {menuPanel,infoPanel,averagePanel,highestPanel,lowestPanel,sortPanel,searchPanel};
	public int studentCount,index=0;
	public String[] names;
	public int[] grades;
	public JTextField studentCountTF,studentNameTF,studentGradeTF,averageTF,highestTF,lowestTF,sortTF,searchTF,searchOutput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					GradeSystem frame = new GradeSystem();
					frame.setVisible(true);
	}

	public GradeSystem() {
		
		//Finds screen size, the calculates the offset needed to center the frame in the screen
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		int screenHeight = Integer.parseInt(String.format("%.0f",(screenSize.getHeight())));
		int screenWidth = Integer.parseInt(String.format("%.0f",(screenSize.getWidth())));
		int frameWidth = 450;
		int frameHeight = 600;
		
		// create the frame and sets some options
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds((screenWidth/2)-(frameWidth/2),(screenHeight/2)-(frameHeight/2), frameWidth, frameHeight);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		//import the header panel from another class
		
		JPanel headPanel = new headerPanel();
		contentPane.add(headPanel, BorderLayout.NORTH);
		
		//Creates the footer panel and applies buttons
		
		JPanel footerPanel = new JPanel();
		footerPanel.setBackground(Color.WHITE);
		contentPane.add(footerPanel, BorderLayout.SOUTH);
		footerPanel.setLayout(new BorderLayout(0, 0));
		
			JButton menuButton = new JButton("Main Menu");
			menuButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
			menuButton.setHorizontalAlignment(SwingConstants.RIGHT);
			menuButton.addActionListener(this);
			menuButton.setActionCommand("menu");
			footerPanel.add(menuButton, BorderLayout.EAST);
			
		//Creates the panel that will hold the other panels used in the card layout type
				
		JPanel hostPanel = new JPanel();
		contentPane.add(hostPanel, BorderLayout.CENTER);
		hostPanel.setLayout(new CardLayout(0, 0));
		hostPanel.setVisible(true);
		
			//Add first panel to host panel
		
			menuPanel = new JPanel();
			hostPanel.add(menuPanel, "menuPanel");
			menuPanel.setBackground(Color.WHITE);
			menuPanel.setLayout(null);
			
				//Add buttons to the menu panel
			
				JButton enterInfoButton = new JButton("Enter Info");
				enterInfoButton.setBounds(153, 126, 130, 23);
				menuPanel.add(enterInfoButton);
				enterInfoButton.addActionListener(this);
				enterInfoButton.setActionCommand("enterInfo");
				
				JButton averageButton = new JButton("Average Grade");
				averageButton.setBounds(153, 228, 130, 23);
				menuPanel.add(averageButton);
				averageButton.addActionListener(this);
				averageButton.setActionCommand("average");
				
				JButton lowestGradeButton = new JButton("Lowest Grade");
				lowestGradeButton.setBounds(153, 262, 130, 23);
				menuPanel.add(lowestGradeButton);
				lowestGradeButton.addActionListener(this);
				lowestGradeButton.setActionCommand("lowest");
				
				JButton highestGradeButton = new JButton("Highest Grade");
				highestGradeButton.setBounds(153, 194, 130, 23);
				menuPanel.add(highestGradeButton);
				highestGradeButton.addActionListener(this);
				highestGradeButton.setActionCommand("highest");
				
				JButton sortDisplayButton = new JButton("Sort & Display");
				sortDisplayButton.setBounds(153, 160, 130, 23);
				menuPanel.add(sortDisplayButton);
				sortDisplayButton.addActionListener(this);
				sortDisplayButton.setActionCommand("sort");
				
				JButton searchButton = new JButton("Search");
				searchButton.setBounds(153, 296, 130, 23);
				menuPanel.add(searchButton);
				searchButton.addActionListener(this);
				searchButton.setActionCommand("search");
				
				//add labels to the main menu
				
				JLabel welcomeLabel = new JLabel("Welcome to the ITB student grading system");
				welcomeLabel.setBounds(60, 33, 285, 16);
				menuPanel.add(welcomeLabel);
				welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
				
				JLabel pleaseChooseLabel = new JLabel("Please choose one of the below options to begin");
				pleaseChooseLabel.setBounds(89, 72, 232, 14);
				menuPanel.add(pleaseChooseLabel);
				pleaseChooseLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
				
			//create info panel and add it to host panel
				
			infoPanel = new JPanel();
			hostPanel.add(infoPanel, "infoPanel");
			infoPanel.setBackground(Color.WHITE);
			infoPanel.setLayout(null);
			
				//add labels and buttons to the info panel
	
				JLabel lblPleaseEnterThe = new JLabel("Please enter the number of students you want to grade");
				lblPleaseEnterThe.setBounds(73, 41, 313, 14);
				infoPanel.add(lblPleaseEnterThe);
				
				JLabel lblStudentName = new JLabel("Student Name:");
				lblStudentName.setEnabled(false);
				lblStudentName.setBounds(84, 184, 101, 14);
				infoPanel.add(lblStudentName);
				
				JLabel lblGrade = new JLabel("Grade:");
				lblGrade.setEnabled(false);
				lblGrade.setBounds(246, 184, 46, 14);
				infoPanel.add(lblGrade);
				
				JLabel completeLabel = new JLabel("Complete!");
				completeLabel.setForeground(new Color(34, 139, 34));
				completeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
				completeLabel.setBounds(173, 278, 136, 34);
				infoPanel.add(completeLabel);
				completeLabel.setVisible(false);
				
				JLabel completeLabel2 = new JLabel("Please return the main menu.");
				completeLabel2.setBounds(130, 323, 252, 14);
				infoPanel.add(completeLabel2);
				completeLabel2.setVisible(false);
				
				JLabel label = new JLabel("/100");
				label.setBounds(296, 222, 46, 14);
				infoPanel.add(label);
				label.setEnabled(false);
				
				JLabel studentErrorLabel = new JLabel("Please enter a value between 2 and 25");
				studentErrorLabel.setForeground(Color.RED);
				studentErrorLabel.setFont(new Font("Tahoma", Font.ITALIC, 9));
				studentErrorLabel.setBounds(130, 97, 294, 34);
				studentErrorLabel.setVisible(false);
				infoPanel.add(studentErrorLabel);
				
				//add in text fields to the info panel
				
				studentNameTF = new JTextField();
				studentNameTF.setEnabled(false);
				studentNameTF.setBounds(84, 219, 153, 20);
				infoPanel.add(studentNameTF);
				studentNameTF.setColumns(10);
				
				studentCountTF = new JTextField();
				studentCountTF.setBounds(200, 66, 24, 20);
				infoPanel.add(studentCountTF);
				studentCountTF.setColumns(10);
				
				//add local instance of event handler to deal with events
				
				studentCountTF.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						studentErrorLabel.setVisible(false);
						studentCount = Integer.parseInt(studentCountTF.getText());
							if (studentCount >=2 && studentCount <=25){
								names = new String[studentCount];
								grades = new int[studentCount];
								studentErrorLabel.setVisible(false);
								studentCountTF.setText("");
								studentCountTF.setEnabled(false);
								lblPleaseEnterThe.setEnabled(false);
								lblStudentName.setEnabled(true);
								lblGrade.setEnabled(true);
								studentNameTF.setEnabled(true);
								studentGradeTF.setEnabled(true);
							}else {
								studentErrorLabel.setVisible(true);
								studentCount=0;
								studentCountTF.setText("");
							}
					}
				});
				
				studentGradeTF = new JTextField();
				studentGradeTF.setEnabled(false);
				studentGradeTF.setBounds(246, 219, 46, 20);
				infoPanel.add(studentGradeTF);
				studentGradeTF.setColumns(10);
				studentGradeTF.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nameEntered = studentNameTF.getText();
						names[index] = nameEntered;
						grades[index] = Integer.parseInt(studentGradeTF.getText());
						index++;
						studentNameTF.setText("");
						studentGradeTF.setText("");
						
							if (index >= studentCount) {
								studentNameTF.setEnabled(false);
								studentGradeTF.setEnabled(false);
								lblStudentName.setEnabled(false);
								lblGrade.setEnabled(false);
								completeLabel.setVisible(true);
								completeLabel2.setVisible(true);
								average();
								highest();
								lowest();
								sort();
								}
					}
				});	
				
				//add search panel to the host panel
				
				searchPanel = new JPanel();
				hostPanel.add(searchPanel, "searchPanel");
				searchPanel.setBackground(Color.WHITE);
				searchPanel.setLayout(null);
				
					//add labels and text fields to panel
				
					JLabel lblSearchToFind = new JLabel("Search to find out if a student has been graded yet");
					lblSearchToFind.setBounds(81, 76, 291, 14);
					searchPanel.add(lblSearchToFind);
					
					JLabel lblName = new JLabel("name:");
					lblName.setBounds(107, 104, 46, 14);
					searchPanel.add(lblName);
					
					searchOutput = new JTextField();
					searchOutput.setHorizontalAlignment(SwingConstants.CENTER);
					searchOutput.setEditable(false);
					searchOutput.setBounds(67, 179, 291, 20);
					searchPanel.add(searchOutput);
					searchOutput.setColumns(10);
					
					searchTF = new JTextField();
					searchTF.setBounds(163, 101, 123, 20);
					searchPanel.add(searchTF);
					searchTF.setColumns(10);
					
					//add local instance of event handler to deal with local events
					
					searchTF.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							//set variable from text field
							String enteredName = searchTF.getText();
							boolean hook = false;
							
							//loop array checking for match
							for (int i = 0; i < studentCount; i++) {
								if (enteredName.equalsIgnoreCase(names[i])) {
									hook = true;
									break;
								}
							}
							//if true display this
							if(hook == true) {
								searchOutput.setForeground(new Color(0, 128, 0));
								searchOutput.setText("This student has been graded");
								searchTF.setText(null);}
							//if false display this
							else {
								searchOutput.setForeground(new Color(128, 0, 0));
								searchOutput.setText("This student has not yet been graded");
								searchTF.setText(null);
							}
							
						}
					});
					
			//add average panel to host panel
				
			averagePanel = new JPanel();
			hostPanel.add(averagePanel, "averagePanel");
			averagePanel.setBackground(Color.WHITE);
			averagePanel.setLayout(null);
			
				//add labels and text fields to the host panel
			
				JLabel lblTheAverageClass = new JLabel("The class average grade is:");
				lblTheAverageClass.setBounds(131, 99, 283, 58);
				averagePanel.add(lblTheAverageClass);
				
				averageTF = new JTextField();
				averageTF.setFont(new Font("Tahoma", Font.BOLD, 15));
				averageTF.setHorizontalAlignment(SwingConstants.CENTER);
				averageTF.setEditable(false);
				averageTF.setBounds(129, 200, 155, 58);
				averagePanel.add(averageTF);
				averageTF.setColumns(10);
				
			//add lowest value panel to the host panel
			
			lowestPanel = new JPanel();
			hostPanel.add(lowestPanel, "lowestPanel");
			lowestPanel.setBackground(Color.WHITE);
			lowestPanel.setLayout(null);
			
				//add labels and text fields to the panel
			
				JLabel lblTheLowestGrade = new JLabel("The lowest grade entered today was:");
				lblTheLowestGrade.setBounds(110, 114, 221, 14);
				lowestPanel.add(lblTheLowestGrade);
				
				lowestTF = new JTextField();
				lowestTF.setHorizontalAlignment(SwingConstants.CENTER);
				lowestTF.setFont(new Font("Tahoma", Font.BOLD, 15));
				lowestTF.setEditable(false);
				lowestTF.setColumns(10);
				lowestTF.setBounds(128, 155, 144, 51);
				lowestPanel.add(lowestTF);
				
			//add highest value panel to the host panel
			
			highestPanel = new JPanel();
			hostPanel.add(highestPanel, "highestPanel");
			highestPanel.setBackground(Color.WHITE);
			highestPanel.setLayout(null);
			
				//add labels and text fields to panel
			
				JLabel highestLabel = new JLabel("The highest grade recorded this session was:");
				highestLabel.setBounds(92, 123, 238, 14);
				highestPanel.add(highestLabel);
				
				highestTF = new JTextField();
				highestTF.setFont(new Font("Tahoma", Font.BOLD, 15));
				highestTF.setHorizontalAlignment(SwingConstants.CENTER);
				highestTF.setEditable(false);
				highestTF.setBounds(134, 172, 144, 51);
				highestPanel.add(highestTF);
				highestTF.setColumns(10);
				
			//add sort panel to host panel
			
			sortPanel = new JPanel();
			hostPanel.add(sortPanel, "sortPanel");
			sortPanel.setBackground(Color.WHITE);
			sortPanel.setLayout(null);
			
				//add labels and textfields to the panel
			
				JLabel sortLabel = new JLabel("The complete list of grades in accending order");
				sortLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
				sortLabel.setBounds(82, 99, 281, 14);
				sortPanel.add(sortLabel);
			
				sortTF = new JTextField();
				sortTF.setFont(new Font("Tahoma", Font.BOLD, 12));
				sortTF.setHorizontalAlignment(SwingConstants.CENTER);
				sortTF.setEditable(false);
				sortTF.setBounds(58, 124, 314, 214);
				sortPanel.add(sortTF);
				sortTF.setColumns(10);
					
				// calls main menu view to start off otherwise host panel is shown which is empty
				menuView();
	}
			
		
	public void actionPerformed(ActionEvent e) {
		
		//Takes action command and passes it to switch 
		String pageCall = e.getActionCommand();
		
		//failed attempt to make panel change more efficient
		
//		for(int i=0;i<=7;i++) {
//			
//			if(panelArray[i].getName() == e.getActionCommand()) {
//				System.out.println("win");
//			}else {
//				System.out.println("Fail");
//			}
//		}
		
		//Switch takes action command and calls panel change
		switch (pageCall) {
		case "menu" : menuView();break;
		case "enterInfo" : infoView();break;
		case "average" : averageView();break;
		case "lowest" : lowestView();break;
		case "highest" : highestView();break;
		case "sort" : sortView();break;
		case "search" : searchView();break;
		
		}
		
	}
	
	//call for named panel view
	public void menuView() {
		menuPanel.setVisible(true);
		infoPanel.setVisible(false);
		averagePanel.setVisible(false);
		lowestPanel.setVisible(false);
		highestPanel.setVisible(false);
		sortPanel.setVisible(false);
		searchPanel.setVisible(false);
		validate();
		
		
	}
	
	//call for named panel view
	public void infoView() {
		infoPanel.setVisible(true);
		averagePanel.setVisible(false);
		lowestPanel.setVisible(false);
		highestPanel.setVisible(false);
		sortPanel.setVisible(false);
		searchPanel.setVisible(false);
		menuPanel.setVisible(false);
		validate();
		
		
	}
	
	//call for named panel view
	public void averageView() {
		menuPanel.setVisible(false);
		infoPanel.setVisible(false);
		averagePanel.setVisible(true);
		lowestPanel.setVisible(false);
		highestPanel.setVisible(false);
		sortPanel.setVisible(false);
		searchPanel.setVisible(false);
		validate();
		
		
	}
	
	//call for named panel view
	public void lowestView() {
		menuPanel.setVisible(false);
		infoPanel.setVisible(false);
		averagePanel.setVisible(false);
		lowestPanel.setVisible(true);
		highestPanel.setVisible(false);
		sortPanel.setVisible(false);
		searchPanel.setVisible(false);
		validate();
		
		
	}
	
	//call for named panel view
	public void highestView() {
		menuPanel.setVisible(false);
		infoPanel.setVisible(false);
		averagePanel.setVisible(false);
		lowestPanel.setVisible(false);
		highestPanel.setVisible(true);
		sortPanel.setVisible(false);
		searchPanel.setVisible(false);
		validate();
		
		
	}
	
	//call for named panel view
	public void sortView() {
		menuPanel.setVisible(false);
		infoPanel.setVisible(false);
		averagePanel.setVisible(false);
		lowestPanel.setVisible(false);
		highestPanel.setVisible(false);
		sortPanel.setVisible(true);
		searchPanel.setVisible(false);
		validate();
		
	}
	
	//call for named panel view
	public void searchView() {
		menuPanel.setVisible(false);
		infoPanel.setVisible(false);
		averagePanel.setVisible(false);
		lowestPanel.setVisible(false);
		highestPanel.setVisible(false);
		sortPanel.setVisible(false);
		searchPanel.setVisible(true);
		validate();
		
		
	}
	
	//method that calculates average
	public void average() {
		
		double sum=0;
		
		for(int i=0;i<=studentCount-1;i++) {
			sum += grades[i];	
		}
		averageTF.setText(Double.toString((sum/studentCount)));
		
	}
	
	//method that calculates the lowest grade
	public void lowest() {
		
		double min=100;
		
		for(int i=0;i<=studentCount-1;i++) {
				if(grades[i] <= min) {
					min = grades[i];
				}
		}
		lowestTF.setText(Double.toString(min));
	}
	
	//method that calculates the highest grade
	public void highest() {
		
		double max=0;
		
		for(int i=0;i<=studentCount-1;i++) {
				if(grades[i] >= max) {
					max = grades[i];
				}
		}
		highestTF.setText(Double.toString(max));	
	}
	
	//method that sorts the array in acceding order and converts it to a string for display
	public void sort() {
		
		int hold=0;
		int size = studentCount;

		for(int pass = 0; pass < (size); pass++)
		{
			for(int i = 0; i < ((size)-1); i++)
			{
				if (grades[i] > (grades[i+1]))
				{
					hold = grades[i];
					grades[i] = grades[i+1];
					grades[i+1] = hold;
				}
			}
		}
		
		String SortedArray ="";
		
		for(int i=0;i<=((studentCount)-1);i++){
			SortedArray = SortedArray+(Integer.toString(grades[i]))+", ";
		}
			sortTF.setText(SortedArray);
		
	}
}
