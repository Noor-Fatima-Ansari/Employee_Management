import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


class Employee implements Serializable{
    int id;
    String name,contact_no,email;
    double salary;

  public Employee(int id,String name,String contact_no,String email,double salary){
      this.id=id;
      this.name= name;
      this.contact_no=contact_no;
      this.email=email;
      this.salary=salary;
  }
  public String toString(){
      return ("\n Employee Details:  "+"\n ID: "+id+"\n Employee Name: "+name+
              "\n Contact No: "+contact_no+"\n Salary:  "+salary+"\n Email Address: "+email);
  }

}
public class Employee_Management {

static void display(ArrayList<Employee>emp){
    System.out.println("\n            *************EMPLOYEES LIST**************\n");
    for (Employee e: emp){
        System.out.println("\n Employee Details:  "+"\n ID: "+e.id+"\n Employee Name: "+e.name+
                "\n Contact No: "+e.contact_no+"\n Salary:  "+e.salary+"\n Email Address: "+e.email);
    }
}


    public static void main(String[] args) {
        int id;
        String name,contact_no,email;
        double salary;
    Delay d=new Delay();

    Scanner sc=new Scanner(System.in);
     ArrayList<Employee>emp=new ArrayList<>();
       File f=null;
        FileInputStream fis=null;
        ObjectInputStream ois=null;
        FileOutputStream fos=null;
        ObjectOutputStream oos=null;
      try {
           f=new File("new.txt");
          if(f.exists()){
               fis=new FileInputStream(f);
               ois=new ObjectInputStream(fis);
              emp=(ArrayList<Employee>)ois.readObject();

          }

      }catch (Exception e){
          System.out.println(e);
      }

  do {

      System.out.println("\n     ***************EMPLOYEE MANAGEMENT SYSTEM**************\n");
      System.out.println(    "1) Add Employee data   \n"+
                             "2) Search for Employee data by given ID  \n"+
                             "3)  Edit Employee Details  \n"+
                             "4)  Delete Employee Details  \n"+
                             "5)  Display All Employee data working inside company\n"+
                             "6)   Save\n" +
                            " 7)   EXIT");
                        Loading l=new Loading();
                        l.start();

             System.out.println("\nEnter the choice : ");

      int ch= sc.nextInt();


  switch (ch){
      case 1:
          System.out.println("Enter the following details:  \n");
          System.out.println("Enter ID:  ");
          id=sc.nextInt();
          System.out.println("Enter Name:  ");
          name=sc.next();
          System.out.println("Enter the Contact No:  ");
          contact_no=sc.next();
          System.out.println("Enter email:  ");
          email=sc.next();
          System.out.println("Enter the salary:  ");
          salary=sc.nextDouble();
          emp.add(new Employee(id,name,contact_no,email,salary));

          try {
              d.run();
          }catch (Exception e){
              System.out.println(e);
          }



          display(emp);
          break;


      case 2: {
          System.out.println("Enter Employee id to search: ");
          id = sc.nextInt();
          int i = 0;
          for (Employee e : emp) {
              if (id == e.id) {
                  System.out.println(e + "\n");
                  i++;
              }
          }
          if (i == 0) {
              System.out.println("Employee ID is incorrect :( \n ** Please Enter valid ID!! ");

          }
          break;
      }

      case 3:
          System.out.println("Enter Employee Id to edit the details:  \n");
          id=sc.nextInt();
          int j=0;
          for (Employee e:emp) {
              if (id==e.id) {
                  j++;}

              while (j==1){
              System.out.println("\n**Edit Employee Details**\n");
              System.out.println("1) Employee ID");
              System.out.println("2) Name");
              System.out.println("3)contact No  \n" + "4)Email\n" + "5)salary\n");
              System.out.println("6)GO BACK!");
              System.out.print("Enter your choice to edit: ");
              int choice = sc.nextInt();
              switch (choice){
                  case 1:
                  {System.out.println("Enter new Id:");
                      e.id=sc.nextInt();
                      System.out.println(e+"\n");
                      break;}
                  case 2:
                  {System.out.println("Enter new name:");
                      e.name=sc.next();
                      System.out.println(e+"\n");
                      break;}
                  case 3:
                  {System.out.println("Enter new Contact No:");
                      e.contact_no=sc.next();
                      System.out.println(e+"\n");
                      break;}
                  case 4:
                  { System.out.println("Enter new Email:");
                      e.email=sc.next();
                      System.out.println(e+"\n");
                      break;}
                  case 5:
                  {  System.out.println("Enter new salary:");
                      e.salary=sc.nextDouble();
                      System.out.println(e+"\n");
                      break;}

                  case 6:
                  {j++;
                      break;}
                  default:
                  { System.out.println("Enter the correct choice!!");
                      break;}
              }

      }}
      if (j==0){
          System.out.println("Employee Details is not Found please enter the valid ID!!\n");
      }
  break;

      case 4:
          System.out.println("Enter the Employee ID to delete the Data");
          id= sc.nextInt();
          int k=0;
          try {
              for (Employee e:emp){
                  if (id==e.id){
                      emp.remove(e);
                      k++;
                  }

              }if (k==0){
                  System.out.println("Employee details is not available.\n Please enter the valid ID\n");
              }
          }catch (Exception ex){
              System.out.println(ex);
          }


      case 5:
         try {
        emp=(ArrayList<Employee>) ois.readObject();
         }catch (IOException ex){

         }catch (Exception e){


         }
         try {
             d.start();
         }catch (Exception e){
             System.out.println(e);
         }

         display(emp);
         break;
      case 6:
          try {
              fos=new FileOutputStream(f);
              oos=new ObjectOutputStream(fos);
              oos.writeObject(emp);
          }catch (IOException e){
              System.out.println(e);
          }

          finally {
           try {
               fis.close();
               fos.close();
               ois.close();
               oos.close();

           }catch (IOException ex){
               System.out.println(ex);
           }
              System.out.println("\n Saving the file ");


           break;

       } // Finally block end


      case 7:
                {
                    sc.close();
                    System.exit(0);
                    break;
                }
      default:
          System.out.println("\n Enter the correct choice from given options");
  }

  }while (true);

}

}
