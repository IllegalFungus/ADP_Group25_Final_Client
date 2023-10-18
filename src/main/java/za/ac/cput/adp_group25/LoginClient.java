/*
Coded By: Siddeeq Rabin 221084096
*/
package za.ac.cput.adp_group25;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginClient implements ActionListener{
    
    private static ObjectInputStream in;
    private static ObjectOutputStream out;
    private static JFrame frameAdminLogin=new JFrame(),frameStudentLoggedInPage=new JFrame(),frameAdminLoggedInPage=new JFrame(), frameStudentLogin=new JFrame();
    private static JPanel northPanel=new JPanel(),southPanel=new JPanel();
    private static JPanel n2nPanel=new JPanel(),n2sPanel=new JPanel();
    private static JPanel n3nPanel=new JPanel(),n3sPanel=new JPanel();
    private static JLabel lblStudentNum=new JLabel("Student Number: "),lblPassword=new JLabel("Password: "),
            lblAdminNum=new JLabel("Admin Number: "),
            lblNameSurname=new JLabel("Name and Surname: "), lblEmail=new JLabel("Email: "),
            lblMobNum=new JLabel("Mobile Number: "),
            lblConPass=new JLabel("Confirm Password: "),lblStudName=new JLabel("Student Name: "),
            lblNewStud=new JLabel("Add New Students and Subjects "),
            lblStudSurname=new JLabel("Student Surname :"), lblNewStudPassw=new JLabel("Password: "),
            lblNewStudSubj=new JLabel("Subject: "),
            lblNewSubject=new JLabel("Add New Subject "), lblSubjName=new JLabel("Subject: "),
             lblSubjCode=new JLabel("Subject Code: "), lblNewID=new JLabel("ID: "),
             lblSubjFac=new JLabel("Subject Faculty: ");
    private static JTextField txtStudentNum=new JTextField(20),txtPassword=new JTextField(20),
            txtNameSurname=new JTextField(20), txtAdminNum=new JTextField(20),
            txtEmail=new JTextField(20), txtMobNum=new JTextField(20),
            txtConPass=new JTextField(20),txtCourseID=new JTextField(20),  txtNewStudSurname=new JTextField(20),
              txtNewStudName=new JTextField(20),txtNewStudPassw=new JTextField(20),txtNewStudSubj=new JTextField(20),
            txtNewSubjName=new JTextField(20),txtNewSubjCode=new JTextField(20), txtNewID=new JTextField(20),
             txtNewSubjFac=new JTextField(20);
    private static JTextArea txtAreaRecords=new JTextArea(10,50);
    private static JButton btnLogin=new JButton("Login"),btnStudentSignUp1=new JButton("Sign Up"),btnExit=new JButton("Exit"),
            btnStudentSignUp2=new JButton("Sign Up"),btnAdminSignUp1=new JButton("Sign Up"),btnAllCourses=new JButton("All Courses"),
            btnEnrolledCourses=new JButton("Enrolled Courses"),btnEnroll=new JButton("Enroll"),
            btnUnenroll=new JButton("Unenroll"), btnAddNewStud=new JButton("Add New Student"),
            btnAddNewSubj=new JButton("Add New Subject"), btnDisplayStud=new JButton("Display Students");
    private static String[] Subject = { "Business & Management Studies", "Economics & Econometrics","Medicine","Law",
            "Accounting & Finance","Art & Design"," Engineering & Technology" };
    private static String[] User = { "Student", "Admin" };
    
    private static JComboBox<String> SubjectCbmBox = new JComboBox<>(Subject);
    
    private static Socket server;
    private static ArrayList <User> arrList=new ArrayList<>();
    private static Object object;
     JFrame frmFrame = new JFrame();
      private static JCheckBox AdminChb = new JCheckBox("Admin");   
            
        private static JTextField txtID = new JTextField();
      private static   JTextField txtPass = new JTextField();
   private static JPanel pnlBtn = new JPanel();
   private static JPanel pnl1 = new JPanel();
   private static JPanel pnl2 = new JPanel();
   private static JPanel pnl3 = new JPanel();
         private static    JButton btnSignUp = new JButton("Sign Up");      
      private static   JLabel lblID = new JLabel("ID:");
      private static   JLabel lblPass = new JLabel("Password:");
  private static  JPanel pnlMain = new JPanel();
 
    
      public LoginClient(){
           
//            try{
//                server=new Socket("localhost",12345);
//            }
//            catch(IOException e){
//                e.printStackTrace();
//            }
//            try{
//                out= new ObjectOutputStream(server.getOutputStream());
//                out.flush();
//                in= new ObjectInputStream(server.getInputStream());
//            }
//            catch(IOException e){
//                System.out.println("Exception error in LoginClient() method: "+e.getMessage());
//            }            
            createAndShowStudentPageGUI();               

    }
      
      
        public void createLoginGUI()
        {
       
        frmFrame.setLayout(new BorderLayout());    
           
                btnLogin.addActionListener(this);
            
                btnExit.addActionListener(this);
        
                btnSignUp.addActionListener(this);
                
      
            pnlMain.setLayout(new GridLayout(2, 2));
                pnlMain.add(lblID);
                pnlMain.add(txtID);
                pnlMain.add(lblPass);
                pnlMain.add(txtPass);
        
            pnlBtn.setLayout(new GridLayout(1, 3));
                pnlBtn.add(btnLogin);
                pnlBtn.add(btnExit);
                pnlBtn.add(btnSignUp);
            
            frmFrame.add(pnlMain, BorderLayout.CENTER);    
            frmFrame.add(pnlBtn, BorderLayout.SOUTH);    
                
            frmFrame.setSize(600,200);
            frmFrame.setVisible(true);
            frmFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        }
      
   
       
      
       public void createAndShowStudentPageGUI(){
          
            frmFrame.setLayout(new BorderLayout());  
             btnUnenroll.setVisible(false);
             btnEnroll.setVisible(true);
             pnlBtn.setLayout(new GridLayout(1,2));
                pnlBtn.add(btnAllCourses);
                pnlBtn.add(btnEnrolledCourses);
                
                pnl2.add(txtAreaRecords);
               
               pnl3.setLayout(new GridLayout(1,2));   
                 pnl2.add(txtCourseID);
                   pnl2.add(btnEnroll);
                   pnl2.add(btnUnenroll);
             frmFrame.add(pnl2, BorderLayout.CENTER);    
            frmFrame.add(pnlBtn, BorderLayout.NORTH);
             frmFrame.add(pnl3, BorderLayout.SOUTH);
                
            frmFrame.setSize(600,400);
            frmFrame.setVisible(true);
            frmFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           
          btnAllCourses.addActionListener(this);
            
               btnEnrolledCourses.addActionListener(this);
        
                btnEnroll.addActionListener(this);
                btnUnenroll.addActionListener(this);

        
       }
       
        private void createAndShowAdminPageGUI(){
            
             frmFrame.setLayout(new BorderLayout());
             
               
               pnl1.add(txtAreaRecords);
               
                pnl2.setLayout(new GridLayout(6,5));
                pnl2.add(lblStudName);
                pnl2.add(txtNewStudName);
                pnl2.add(lblStudSurname);
                pnl2.add(txtNewStudSurname);
                pnl2.add(lblNewStudPassw);
                pnl2.add(txtNewStudPassw);
                pnl2.add(lblNewID);
                pnl2.add(txtNewID);
                pnl2.add(lblNewStudSubj);
                pnl2.add(txtNewStudSubj);
               pnl2.add(btnAddNewStud); 
     
               pnl3.setLayout(new GridLayout(4,2));
               
                pnl3.add(lblSubjFac);
               pnl3.add(txtNewSubjFac); 
                 pnl3.add(lblSubjName);
                pnl3.add(txtNewSubjName);
                pnl3.add(lblSubjCode);
               pnl3.add(txtNewSubjCode); 
               pnl3.add(btnAddNewSubj);
                pnl3.add(btnDisplayStud);
               
               
               frmFrame.add(pnl2, BorderLayout.NORTH);
               frmFrame.add(pnl3, BorderLayout.CENTER);
               frmFrame.add(pnl1, BorderLayout.SOUTH); 
               
             frmFrame.setSize(700,500);
            frmFrame.setVisible(true);
            frmFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            
            btnAddNewStud.addActionListener(this);
            btnDisplayStud.addActionListener(this);
            btnAddNewSubj.addActionListener(this);
            
               
        }
        
         private void Enrolling(){
        try{
            String strFunction = "Enroll Course for student"; 
            String strID = txtID.getText();
            String strCourse=txtAreaRecords.getSelectedText();
     
     
      int intID = Integer.parseInt(strID);
           
            
            User courseEnroll = new User(intID, strFunction ,strCourse);
            
            
            object=courseEnroll;
            out.writeObject(object);
            out.flush();
        }
        catch(IOException e){
            System.out.println("Exception error in Enrolling() method: "+e.getMessage());
        }
   
        }
        
   
         
         private void AddCourse() {
           try{
               String strCourseID =txtNewSubjCode.getText();
    String strCourseTitle=txtNewSubjName.getText();
    String strCourseFaculty= txtNewSubjFac.getText() ;
    String strFunction= "Add New Course";
    
Course newCourse = new Course(strCourseID, strCourseTitle,strCourseFaculty,strFunction );
   object=newCourse;
            out.writeObject(object);
            out.flush();
        }
        catch(IOException e){
            System.out.println("Exception error in AddCourse() method: "+e.getMessage());
        }

              
         }
         
     private void AddStudent() {
        try{
             String strID = txtID.getText();
     String strPassword = txtPass.getText();
      int intID = Integer.parseInt(strID);
      String strFunction = "Add Student";
      String strName= txtNewStudName.getText();
       String strSurname= txtNewStudSurname.getText();
       String strSubject= txtNewStudSubj.getText();
       boolean isAdmin = AdminChb.isSelected();
       
            User stud = new User(intID, strName, strSurname, strPassword, isAdmin, "addUser" );
             
            object=stud;
            out.writeObject(object);
            out.flush();
        }
        catch(IOException e){
            System.out.println("Exception error in addStudent() method: "+e.getMessage());
        }
        
    }
        
   
       private static void AttemptLogin(){
     String strID = txtID.getText();
     String strPassword = txtPass.getText();
      int intID = Integer.parseInt(strID);
      
       String strFunction = "Login";

            User newUser = new User(intID, strPassword, strFunction);
            
           
            try
            {
                out.writeObject(newUser);
                out.flush();
            } catch (IOException ioe)
            {
                System.out.println("IOException in client send object: " + ioe.getMessage());
            }
        }
       
        private void Unenrolling(){
        String strFunction = "Unenroll"; 
            String strID = txtID.getText();
            String strCourse=txtAreaRecords.getSelectedText(); 
            int intID = Integer.parseInt(strID);
            
            User UnenrollCourse = new User(intID, strCourse, strFunction);
            
              try
            {
                out.writeObject(UnenrollCourse);
                out.flush();
            } catch (IOException ioe)
            {
                System.out.println("IOException in client send object: " + ioe.getMessage());
            }
     }
       
        public void LoggedIn(){
                try
                {
                    object = in.readObject();
                    if (object instanceof User)
                    {
                        User loggedIn = (User) object;
                        
                        if (loggedIn == null) {
                            JOptionPane.showMessageDialog(null, "The ID or Password is incorrect.");
                        } else if (loggedIn.isAdmin()) {
                            
                            JOptionPane.showMessageDialog(null, "Welcome Admin");
                        } else if (loggedIn.isAdmin() == false) {
                            
                            JOptionPane.showMessageDialog(null, "Welcome Student.");
                        }
                    }
                    
                } catch (ClassNotFoundException cnfe)
                {
                    cnfe.printStackTrace();
                } catch (IOException e)
                {
                    e.printStackTrace();
                }

    }
      
    
        
    
      private void AllCourses(ArrayList courseList) throws IOException, ClassNotFoundException{
          for(int i =0;i<courseList.size();i++){
            txtAreaRecords.append(courseList.get(i).toString()+"\n");            
        }
        txtAreaRecords.append("------------------------------------------"+"\n");
            
      }
      private void AllStudents(ArrayList studentList) throws IOException, ClassNotFoundException{
          for(int i =0;i<studentList.size();i++){
            txtAreaRecords.append(studentList.get(i).toString()+"\n");            
        }
        txtAreaRecords.append("------------------------------------------"+"\n");
            
      }
      
      private void EnrolledCourses(ArrayList enrolledCourseList) throws IOException, ClassNotFoundException{
           for(int i =0;i<enrolledCourseList.size();i++){
            txtAreaRecords.append(enrolledCourseList.get(i).toString()+"\n");            
        }
        txtAreaRecords.append("------------------------------------------"+"\n");
      }
    
       private static void closeConnection() 
        {
            //Send exit string:
            try
            {
                out.writeObject("exit");
                out.flush();
            }
            catch (IOException ioe)
            {
                System.out.println("IO Exception: " + ioe.getMessage());
            }

            //Close all connections:
            try
            {
                out.close();
                in.close();
                server.close();
            }
            catch (IOException ioe)
            {
                System.out.println("IO Exception in closeConnections(): " + ioe.getMessage());
            }
        }
   
      @Override
    public void actionPerformed(ActionEvent e) {  
       if(e.getSource()==btnLogin){            
            AttemptLogin();
        } else if (e.getSource()==btnExit){
           closeConnection();
        }else if (e.getSource()==btnSignUp){
            // where do you go for the sign up page
        } else if (e.getSource()==btnAllCourses){
            AllCourses();
           btnUnenroll.setVisible(false);
             btnEnroll.setVisible(true);
       } else if (e.getSource()==btnEnrolledCourses){
           EnrolledCourses();
           btnUnenroll.setVisible(true);
           btnEnroll.setVisible(false);
           } else if (e.getSource()==btnUnenroll){
           Unenrolling();
           } else if (e.getSource()==btnEnroll){
           Enrolling();
           } else if (e.getSource()==btnAddNewStud){
           AddStudent();
           } else if (e.getSource()==btnDisplayStud){
           AllStudents();
           } else if (e.getSource()==btnAddNewSubj){
           AddCourse();
           } 
    }   
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        LoginClient client=new LoginClient();
    }
    
}
