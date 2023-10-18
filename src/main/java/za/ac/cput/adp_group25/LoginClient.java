/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
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
/**
 *
 * @author Rabin Family
 */
public class LoginClient implements ActionListener{
    
    private static ObjectInputStream in;
    private static ObjectOutputStream out;
    private static JFrame frameAdminLogin=new JFrame(),frameStudentLoggedInPage=new JFrame(),frameAdminLoggedInPage=new JFrame(),
            frameStudentLogin=new JFrame();
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
             lblSubjCode=new JLabel("Subject Code: "), lblNewID=new JLabel("User ID: "),
             lblSubjFac=new JLabel("Subject Faculty: "),lblSpace=new JLabel(" "),
                     lblNewID2=new JLabel("ID: "),lblSubjCode2=new JLabel("Subject Code: ");
    private static JTextField txtStudentNum=new JTextField(20),txtPassword=new JTextField(20),
            txtNameSurname=new JTextField(20), txtAdminNum=new JTextField(20),
            txtEmail=new JTextField(20), txtMobNum=new JTextField(20),
            txtConPass=new JTextField(20),txtCourseID=new JTextField(20),  txtNewStudSurname=new JTextField(20),
              txtNewStudName=new JTextField(20),txtNewStudPassw=new JTextField(20),txtNewStudSubj=new JTextField(20),
            txtNewSubjName=new JTextField(20),txtNewSubjCode=new JTextField(20), txtNewID=new JTextField(20),
             txtNewSubjFac=new JTextField(20),txtDeleteOrGetID=new JTextField(20),txtDeleteOrGetCourse=new JTextField(20);
    private static JTextArea txtAreaRecords=new JTextArea(10,50);
    private static JButton btnLogin=new JButton("Login"),btnStudentSignUp1=new JButton("Sign Up"),btnExit=new JButton("Exit"),
            btnStudentSignUp2=new JButton("Sign Up"),btnAdminSignUp1=new JButton("Sign Up"),btnAllCourses=new JButton("All Courses"),
            btnEnrolledCourses=new JButton("Enrolled Courses"),btnEnroll=new JButton("Enroll"),
            btnUnenroll=new JButton("Unenroll"), btnAddNewStud=new JButton("Add New Student"),
            btnAddNewSubj=new JButton("Add New Subject"), btnDisplayStud=new JButton("Display Students"),
            btnDeleteUser=new JButton("Delete User"), btnGetUser=new JButton("Get User"), btnGetCourse=new JButton("Get Course"),
             btnDeleteCourse=new JButton("Delete Course");
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
 
//-----------------------------------------------------------------------------------------------------------------------------------------------     
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
            createLoginGUI();               

    }
//----------------------------------------------------------------------------------------------------------------------------------------------- 
      
        public void createLoginGUI()
        {
       
        frmFrame.setLayout(new BorderLayout());    
           
                btnLogin.addActionListener(this);
            
                btnExit.addActionListener(this);
        
               
                
      
            pnlMain.setLayout(new GridLayout(2, 2));
                pnlMain.add(lblID);
                pnlMain.add(txtID);
                pnlMain.add(lblPass);
                pnlMain.add(txtPass);
        
            pnlBtn.setLayout(new GridLayout(1, 2));
                pnlBtn.add(btnLogin);
                pnlBtn.add(btnExit);
                
            
            frmFrame.add(pnlMain, BorderLayout.CENTER);    
            frmFrame.add(pnlBtn, BorderLayout.SOUTH);    
                
            frmFrame.setSize(600,200);
            frmFrame.setVisible(true);
            frmFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        }
//----------------------------------------------------------------------------------------------------------------------------------------------- 
        
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
//----------------------------------------------------------------------------------------------------------------------------------------------- 
       
        private void createAndShowAdminPageGUI(){
            
             frmFrame.setLayout(new BorderLayout());
             
               
               pnl1.add(txtAreaRecords);
               
                pnl2.setLayout(new GridLayout(8,5));
                pnl2.add(lblStudName);
                pnl2.add(txtNewStudName);
                pnl2.add(lblStudSurname);
                pnl2.add(txtNewStudSurname);
                pnl2.add(lblNewStudPassw);
                pnl2.add(txtNewStudPassw);
                pnl2.add(lblNewID2);
                pnl2.add(txtNewID);
                pnl2.add(lblNewStudSubj);
               pnl2.add(txtNewStudSubj);
               pnl2.add(btnAddNewStud);
            
     
               pnl3.setLayout(new GridLayout(8,2));
               
              pnl3.add(lblNewID);
              pnl3.add(txtDeleteOrGetID);
              pnl3.add(btnDeleteUser);
             pnl3.add(btnGetUser);
             
             pnl3.add(lblSubjCode2);
             pnl3.add(txtDeleteOrGetCourse);
             pnl3.add(btnDeleteCourse);
            pnl3.add(btnGetCourse);
             
                pnl3.add(lblSubjFac);
               pnl3.add(txtNewSubjFac); 
                 pnl3.add(lblSubjName);
                pnl3.add(txtNewSubjName);
                pnl3.add(lblSubjCode);
               pnl3.add(txtNewSubjCode); 
               pnl3.add(btnAddNewSubj);
                pnl3.add(btnDisplayStud);
               //
               
               frmFrame.add(pnl2, BorderLayout.NORTH);
               frmFrame.add(pnl3, BorderLayout.CENTER);
               frmFrame.add(pnl1, BorderLayout.SOUTH); 
               
             frmFrame.setSize(800,600);
            frmFrame.setVisible(true);
            frmFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            
            btnAddNewStud.addActionListener(this);
            btnDisplayStud.addActionListener(this);
            btnAddNewSubj.addActionListener(this);
            btnDeleteUser.addActionListener(this);
            btnDeleteCourse.addActionListener(this);
            btnGetCourse.addActionListener(this);
            btnGetUser.addActionListener(this);
               
        }
//----------------------------------------------------------------------------------------------------------------------------------------------- 
        
         private void DeleteUser() {
            try {
                int intID = Integer.parseInt(txtDeleteOrGetID.getText());
                String strFunction = "Delete";
                
                User user = new User(intID, null, strFunction);
                
                out.writeObject(user);
                out.flush();
            } catch (IOException e) {
                System.out.println("Exception error: "+e.getMessage());
            }
        }
//----------------------------------------------------------------------------------------------------------------------------------------------- 
         
          private void DeleteCourse() {
            try {
                int intID = Integer.parseInt(txtDeleteOrGetCourse.getText());
                String strFunction = "deleteCourse";
                
                Course course = new Course(intID, null, null, strFunction);
                
                out.writeObject(course);
                out.flush();
            } catch (IOException e) {
                System.out.println("Exception error: "+e.getMessage());
            }
        }
//----------------------------------------------------------------------------------------------------------------------------------------------- 
          
           private void GetUserRequest() {
            try {
                int intID = Integer.parseInt(txtDeleteOrGetID.getText());
                String strFunction = "getUser";
                
                User user = new User(intID, null, strFunction);
                
                out.writeObject(user);
                out.flush();
            } catch (IOException e) {
                System.out.println("Exception error: "+e.getMessage());
            }
        }
           private User userReceived;
        private  User GetUserReceive() {
            
            try
            {
                object = in.readObject();
                userReceived = (User) object;
            } catch (ClassNotFoundException cnfe)
            {
                System.out.println("cnf error: "+cnfe.getMessage());
            } catch (IOException e)
            {
                System.out.println("Exception error: "+e.getMessage());
            }
            return userReceived;
        }
//-----------------------------------------------------------------------------------------------------------------------------------------------
        
           private void GetCourseRequest() {
            try {
                int intID = Integer.parseInt(txtDeleteOrGetCourse.getText());
                String strFunction = "getCourse";
                Course course = new Course(intID, null, null, strFunction);
                
                out.writeObject(course);
                out.flush();
            } catch (IOException e) {
                System.out.println("Exception error: "+e.getMessage());
            }
        }
            private Course courseReceived;
        private Course GetCourseReceive() {
            try
            {
                object = in.readObject();
                courseReceived = (Course) object;
            } catch (ClassNotFoundException cnfe)
            {
                System.out.println("cnf error: "+cnfe.getMessage());
            } catch (IOException e)
            {
                System.out.println("Exception error: "+e.getMessage());
            }
            return courseReceived;
        }
//----------------------------------------------------------------------------------------------------------------------------------------------- 
        
         private void AddCourse() {
           try{
               
    int intCourseID = Integer.parseInt(txtNewSubjCode.getText());
    String strCourseTitle=txtNewSubjName.getText();
    String strCourseFaculty= txtNewSubjFac.getText() ;
    String strFunction= "Add New Course";
    
Course newCourse = new Course(intCourseID, strCourseTitle,strCourseFaculty,strFunction );
   object=newCourse;
            out.writeObject(object);
            out.flush();
        }
        catch(IOException e){
            System.out.println("Exception error in AddCourse() method: "+e.getMessage());
        }

              
         }
//----------------------------------------------------------------------------------------------------------------------------------------------- 
         
     private void AddStudent() {

        
        try{
             String strID = txtID.getText();
     String strPassword = txtPass.getText();
      int intID = Integer.parseInt(strID);
      String strFunction = "addUser";
      String strName= txtNewStudName.getText();
       String strSurname= txtNewStudSurname.getText();
       String strSubject= txtNewStudSubj.getText();
       boolean isAdmin = AdminChb.isSelected();
      
       
            User stud = new User(intID, strName,strSurname,strPassword,isAdmin,strSubject );
             
            object=stud;
            out.writeObject(object);
            out.flush();
        }
        catch(IOException e){
            System.out.println("Exception error in AddStudent() method: "+e.getMessage());
        }
        
    }
        
//----------------------------------------------------------------------------------------------------------------------------------------------- 
     
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
//----------------------------------------------------------------------------------------------------------------------------------------------- 
        
           private void Enrolling(){
        try{
            String strFunction = "Enroll Course for student"; 
            String strUserID = txtID.getText();
            String strCourseID=txtAreaRecords.getSelectedText();
     //int intCOurseID = Integer.parseInt(txtAreaRecords.getSelectedText()); 
     
      int intUserID = Integer.parseInt(strUserID);
           

            User Enroll = new User(intUserID, strFunction,strCourseID);
            
            
            
            out.writeObject(Enroll);
            out.flush();
        }
        catch(IOException e){
            System.out.println("Exception error in Enrolling() method: "+e.getMessage());
        }
        
        
    }
//----------------------------------------------------------------------------------------------------------------------------------------------- 
           
        private void Unenrolling(){
        String strFunction = "Unenroll"; 
            String strUserID = txtID.getText();
            String strCourseID=txtAreaRecords.getSelectedText(); 
            int intUserID = Integer.parseInt(strUserID);
            
            User Unenroll = new User(intUserID, strCourseID, strFunction);
            
              try
            {
                out.writeObject(Unenroll);
                out.flush();
            } catch (IOException ioe)
            {
                System.out.println("IOException in client send object: " + ioe.getMessage());
            }
     }
//----------------------------------------------------------------------------------------------------------------------------------------------- 
        
     private void GetAllCoursesRequest() {
            try {
                out.writeObject("allCourses");
                out.flush();
            } catch (IOException e) {
                System.out.println("Exception error: "+e.getMessage());
            }
        }
     
       private ArrayList listReceived;
        private ArrayList<Course> GetAllCoursesReceived() {
            try {
                object = in.readObject();
                listReceived = (ArrayList<Course>)object;
            } catch(IOException e) {
                System.out.println("Exception error: "+e.getMessage());
            } catch (ClassNotFoundException cnfe) {
                System.out.println("CNFE error: "+ cnfe.getMessage());
            }
            return listReceived;
        }
        
//-----------------------------------------------------------------------------------------------------------------------------------------------   
        
        
      private void GetAllUsersRequest() {
            try {
                out.writeObject("allUsers");
                out.flush();
            } catch (IOException e) {
                System.out.println("Exception error: "+e.getMessage());
            }
        }
        
        private ArrayList<User> GetAllUsersReceived() {
            try {
                object = in.readObject();
                listReceived = (ArrayList<User>)object;
            } catch(IOException e) {
                System.out.println("Exception error: "+e.getMessage());
            } catch (ClassNotFoundException cnfe) {
                System.out.println("CNFE error: "+ cnfe.getMessage());
            }
            return listReceived;
        }
        
//----------------------------------------------------------------------------------------------------------------------------------------------- 
        
        
      private void GetAllEnrolledCoursesRequest(){
          try {
               int intID = Integer.parseInt(txtID.getText());
                String strFunction = "getEnrolledCourses";
                
                User EnrolledCourses = new User(intID, null, strFunction);
              
                out.writeObject(EnrolledCourses);
                out.flush();
            } catch (IOException e) {
                System.out.println("Exception error: "+e.getMessage());
            }
      }
       private ArrayList<Course> GetAllEnrolledCoursesReceived() {
            try {
                object = in.readObject();
                listReceived = (ArrayList<Course>)object;
            } catch(IOException e) {
                System.out.println("Exception error: "+e.getMessage());
            } catch (ClassNotFoundException cnfe) {
                System.out.println("CNFE error: "+ cnfe.getMessage());
            }
            return listReceived;
        }
//-----------------------------------------------------------------------------------------------------------------------------------------------        
    
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
//----------------------------------------------------------------------------------------------------------------------------------------------- 
       
      @Override
    public void actionPerformed(ActionEvent e) {  
       if(e.getSource()==btnLogin){            
            AttemptLogin();
             LoggedIn();
        } else if (e.getSource()==btnExit){
           closeConnection();
           System.exit(0);
        } else if (e.getSource()==btnAllCourses){
          GetAllCoursesRequest();
            GetAllCoursesReceived();
            btnUnenroll.setVisible(false);
            btnEnroll.setVisible(true);
       } else if (e.getSource()==btnEnrolledCourses){
           GetAllEnrolledCoursesRequest();
           GetAllEnrolledCoursesReceived();
           btnUnenroll.setVisible(true);
             btnEnroll.setVisible(false);
           } else if (e.getSource()==btnUnenroll){
           Unenrolling();
           } else if (e.getSource()==btnEnroll){
           Enrolling();
           } else if (e.getSource()==btnAddNewStud){
           AddStudent();
           } else if (e.getSource()==btnDisplayStud){
           GetAllUsersRequest();
            GetUserReceive();
           } else if (e.getSource()==btnAddNewSubj){
           AddCourse();
           } 
       else if (e.getSource()==btnDeleteUser){
           DeleteUser();
       }else if (e.getSource()==btnDeleteCourse){
           DeleteCourse();
       }else if (e.getSource()==btnGetCourse){
           GetCourseRequest();
           GetCourseReceive();
           }else if (e.getSource()==btnGetUser){
           GetUserRequest();
           GetUserReceive();
           }
           
          
          
    
    }
        
//-----------------------------------------------------------------------------------------------------------------------------------------------         
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        LoginClient client=new LoginClient();
    }
    
}
