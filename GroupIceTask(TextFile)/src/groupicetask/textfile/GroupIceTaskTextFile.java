
package groupicetask.textfile;
import java.io.*;
import javax.swing.*;
public class GroupIceTaskTextFile {

    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
       Boolean Run =true;
       while (Run == true)
       {
        try
        {
       
           String strStudentID = JOptionPane.showInputDialog(null,"Enter the Student ID");
           String strStudentName = JOptionPane.showInputDialog(null,"Enter the Student Name");
           String strStudentAvg = JOptionPane.showInputDialog(null,"Enter the student Average");
           int dialogButton = JOptionPane.showConfirmDialog(null,"Do you want to save?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
           BufferedReader br = null;
           if(dialogButton==JOptionPane.YES_OPTION)
           {
               File saveFile = new File("StudentRecords.txt");
               
               if(!saveFile.exists())
               {
                   saveFile.createNewFile();
               }
               FileWriter fw = new FileWriter(saveFile.getAbsoluteFile(),true);
               //true is for append
               BufferedWriter bw = new BufferedWriter(fw);
               bw.write(strStudentID);
               bw.newLine();
               bw.write(strStudentName);
               bw.newLine();
               bw.write(strStudentAvg);
               bw.newLine();
               bw.close(); //very important!
               JOptionPane.showMessageDialog(null,"Student record has been saved successfully");
           }
           else
           {
               JOptionPane.showMessageDialog(null,"Your Student record has not been saved");
           }
         
                int x =0;
                String strCurrentLine ="", strDisplay="";
                Double dblTotal=0.0;
                
                br = new BufferedReader(new FileReader("Sales.txt"));
                 
                while((strCurrentLine = br.readLine())!= null)
                {
                    strDisplay+= strCurrentLine+"- R ";
                    //Read the test result from the file
                    strCurrentLine = br.readLine();
                    dblTotal=Double.parseDouble(strCurrentLine);
                    x+=1;
                }
        }
 
       catch(IOException e)
       {
           JOptionPane.showMessageDialog(null,"There was an error saving to the textfile");
       }
       catch(Exception ex)
       {
           JOptionPane.showMessageDialog(null,"The following error has occured: "+ex.toString());
       }
       finally
       {
            System.out.println("Thank you for using the program");
       }   
    }
        int dialogButton2 = JOptionPane.showConfirmDialog(null,"Do you want to start over again?","Confirm",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE );
        if(dialogButton2==JOptionPane.YES_OPTION)
        {
            Run =true;
        }
        else
        {
            Run =false;
            JOptionPane.showMessageDialog(null,"You have exited the program");
        }
    }
}
