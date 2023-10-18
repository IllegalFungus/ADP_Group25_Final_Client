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

public class LoginClientNew implements ActionListener{
    
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
 
    
      public LoginClientNew(){
           
            try{
                server = new Socket("localhost",12345);
            }
            catch(IOException e){
                e.printStackTrace();
            }
            try{
                out = new ObjectOutputStream(server.getOutputStream());
                out.flush();
                in = new ObjectInputStream(server.getInputStream());
            }
            catch(IOException e){
                System.out.println("Exception error in LoginClient() method: " + e.getMessage());
            }            
            createLoginGUI();

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
        
        private static void AttemptLogin(){
            int intID = Integer.parseInt(txtID.getText());
            String strPassword = txtPass.getText();

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
                        createAndShowStudentPageGUI();
                        JOptionPane.showMessageDialog(null, "Welcome Admin");
                    } else if (loggedIn.isAdmin() == false) {
                        createAndShowStudentPageGUI();
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
        
        private void AddStudent() {
            try{
                int intID = Integer.parseInt(txtID.getText());
                String strPassword = txtPass.getText();
                String strFunction = "addUser";
                String strName= txtNewStudName.getText();
                String strSurname= txtNewStudSurname.getText();
                boolean isAdmin = AdminChb.isSelected();

                User user = new User(intID, strName, strSurname, strPassword, isAdmin, strFunction);

                out.writeObject(user);
                out.flush();
            }
            catch(IOException e){
                System.out.println("Exception error in addStudent() method: "+e.getMessage());
            }
        }
        
        //Need this functionality in GUI, admin types in ID of user and clicks a button. Button calls this method.
        private void deleteUser() {
            try {
                int intID = Integer.parseInt(txtID.getText());
                String strFunction = "Delete";
                
                User user = new User(intID, null, strFunction);
                
                out.writeObject(user);
                out.flush();
            } catch (IOException e) {
                System.out.println("Exception error: "+e.getMessage());
            }
        }
        
        //Need this functionality in GUI, admin types in ID of a user and clicks a button. Method returns all the info on that student.
        private void getUserRequest() {
            try {
                int intID = Integer.parseInt(txtID.getText());
                String strFunction = "getUser";
                User user = new User(intID, null, strFunction);
                
                out.writeObject(user);
                out.flush();
            } catch (IOException e) {
                System.out.println("Exception error: "+e.getMessage());
            }
        }
        
        //Need this functionality in GUI, admin types in ID of a user and clicks a button. Method returns all the info on that student.
        //This method should be called directly after the previous one, as it checks for the servers response.
        private User userReceived;
        private User getUserReceive() {
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
        
        private void AddCourse() {
            try{
                int intCourseID = Integer.parseInt(txtNewSubjCode.getText());
                String strCourseTitle = txtNewSubjName.getText();
                String strCourseFaculty = txtNewSubjFac.getText() ;
                String strFunction= "addCourse";

                Course newCourse = new Course(intCourseID, strCourseTitle,strCourseFaculty,strFunction );
                out.writeObject(newCourse);
                out.flush();
            }
            catch(IOException e){
                System.out.println("Exception error in AddCourse() method: "+e.getMessage());
            }      
        }
        
        //Need this functionality in GUI, admin types in ID of a course and clicks a button. Method returns all the info on that course.
        private void getCourseRequest() {
            try {
                int intID = Integer.parseInt(txtCourseID.getText());
                String strFunction = "getCourse";
                Course course = new Course(intID, null, null, strFunction);
                
                out.writeObject(course);
                out.flush();
            } catch (IOException e) {
                System.out.println("Exception error: "+e.getMessage());
            }
        }
        
        //Need this functionality in GUI, admin types in ID of a course and clicks a button. Method returns all the info on that course.
        //This method should be called directly after the previous one, as it checks for the servers response.
        private Course courseReceived;
        private Course getCourseReceive() {
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
        
        //Need this functionality in GUI, admin types in ID of course and clicks a button. Button calls this method.
        private void deleteCourse() {
            try {
                int intID = Integer.parseInt(txtCourseID.getText());
                String strFunction = "deleteCourse";
                
                Course course = new Course(intID, null, null, strFunction);
                
                out.writeObject(course);
                out.flush();
            } catch (IOException e) {
                System.out.println("Exception error: "+e.getMessage());
            }
        }
        
        //-----
        //These two methods must be called one after the other, as the 2nd one is getting the servers response.
        private void getAllCoursesRequest() {
            try {
                out.writeObject("allCourses");
                out.flush();
            } catch (IOException e) {
                System.out.println("Exception error: "+e.getMessage());
            }
        }
        
        private ArrayList listReceived;
        private ArrayList<Course> getAllCoursesReceived() {
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
        //-----
        
        //-----
        //These two methods must be called one after the other, as the 2nd one is getting the servers response.
        private void getAllUsersRequest() {
            try {
                out.writeObject("allUsers");
                out.flush();
            } catch (IOException e) {
                System.out.println("Exception error: "+e.getMessage());
            }
        }
        
        private ArrayList<Course> getAllUsersReceived() {
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
        //-----
        
        private static void closeConnection() 
        {
            try
            {
                out.writeObject("exit");
                out.flush();
            }
            catch (IOException ioe)
            {
                System.out.println("IO Exception: " + ioe.getMessage());
            }
            
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
        
        private void Enrolling() {
            try {
            //Takes userID, courseID and sends it to Server to enroll student.
            String strFunction = "Enroll";
            int intUID = Integer.parseInt(txtID.getText());
            //Need a way to get the course ID on this GUI, as its needed for sending the object. (This was your code, dont know if it works as intended)
            int intCID = Integer.parseInt(txtAreaRecords.getSelectedText()); 
            
            UserCourse enroll = new UserCourse(0, intUID, intCID, strFunction);
            
            out.writeObject(enroll);
            out.flush();
            } catch (IOException e) {
                System.out.println("Exception error: "+e.getMessage());
            }
        }
        
        private void Unenrolling(){
            try {
            //Takes userID, courseID and sends it to Server to enroll student.
            String strFunction = "Unenroll";
            int intUID = Integer.parseInt(txtID.getText());
            //Need a way to get the course ID on this GUI, as its needed for sending the object. (This was your code, dont know if it works as intended)
            int intCID = Integer.parseInt(txtAreaRecords.getSelectedText()); 
            
            UserCourse unenroll = new UserCourse(0, intUID, intCID, strFunction);
            
            out.writeObject(unenroll);
            out.flush();
            } catch (IOException e) {
                System.out.println("Exception error: "+e.getMessage());
            }
        }
   
    public void actionPerformed(ActionEvent e) {  
        if(e.getSource()==btnLogin){            
            AttemptLogin();
            LoggedIn();
        } else if (e.getSource()==btnExit){
           closeConnection();
           System.exit(0);
        } else if (e.getSource()==btnAllCourses){
            getAllCoursesRequest();
            getAllCoursesReceived();
            btnUnenroll.setVisible(false);
            btnEnroll.setVisible(true);
        } else if (e.getSource()==btnUnenroll){
            Unenrolling();
        } else if (e.getSource()==btnEnroll){
            Enrolling();
        } else if (e.getSource()==btnAddNewStud){
            AddStudent();
        } else if (e.getSource()==btnDisplayStud){
            getAllUsersRequest();
            getUserReceive();
        } else if (e.getSource()==btnAddNewSubj){
            AddCourse();
        } 
        /*Still Needed: 
            Button to get Single User information.
            Button to get Single Course information.
            Button to delete a user.
        */
    }   

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        LoginClientNew client=new LoginClientNew();
    }
    
}
