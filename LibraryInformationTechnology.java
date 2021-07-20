import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.util.Calendar;
import java.text.SimpleDateFormat;
class BookInfo{
     int bookNo;
     String bookTitle,bookAuthor;
     void displayBooksRecord()
     {
      System.out.println("book no:" +bookNo);
      System.out.println("book title:" +bookTitle);
      System.out.println("book author" +bookAuthor);
      System.out.println("\n");
     }
 }
class BorrowerRec{
  int regNo;
  String name,adress;
  void displayBorrowerInfo(){
      System.out.println("RegNo.:"+regNo);
      System.out.println("name:"+name);
      System.out.println("adress:"+adress);
      System.out.println("\n");
  }
}
class IssueRecord{
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        
    int regNo;
    String issueDate=dateFormat.format(cal.getTime());
    String returnDate;
    int bookNo;
    void displayIssueRecord(){
        System.out.println("regno:"+regNo);
        System.out.println("book no:"+bookNo);
        System.out.println("issu date:"+issueDate);
        System.out.println("return date:"+returnDate);
        System.out.println("\n");
    }
}
class ReturnRecord{
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
    int regNo;
    String returnDate=dateFormat.format(cal.getTime());;
    void displayReturnRecord()
    {
        System.out.println("reg no:"+regNo);
        System.out.println("return date"+returnDate);
        System.out.println("\n");
    }
}
public class LibraryInformationTechnology {
            public static void main(String[] args) throws IOException {
int t=0;
        System.out.println("******NHCE Library********");
        int password,option;
          int i,num,username;
        int choice=0,count=0;
        int searchRegNo=0,searchBookNo=0;
        String str="";
        boolean flag=true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
          System.out.println("username");
            username=Integer.parseInt(br.readLine());
            System.out.println("password");
            password=Integer.parseInt(br.readLine());
            if(username==137220&&password==137220)
                break;
            else
                System.out.println("enter correct username and password");
 }
 while(flag)
       {
           System.out.println("\nMENU\n");
           System.out.println("1.Books Information");
           System.out.println("2.Borrowers Information");
           System.out.println("3.Issues And Returns");
           System.out.println("4.exit\n");
           System.out.println("enter users option");
           option=Integer.parseInt(br.readLine());
           switch(option)
           {
             case 1:
                   System.out.println("****BOOKS INFORMATION SYSTEM****");
                  BookInfo record=new BookInfo();
                   first: while(true)
                         {
                      System.out.println("\nMENU\n");
                      System.out.println("1.create");
                      System.out.println("2.update");
                      System.out.println("3.search");
                      System.out.println("4.records");
                      System.out.println("5.exit\n");
                      System.out.println("enter users choice");
                      choice=Integer.parseInt(br.readLine());
                        switch(choice){

                            case 1:
                                //creating books data
                                FileWriter fout=new FileWriter("bookdata.txt");
                                System.out.println("how many records");
                                num=Integer.parseInt(br.readLine());
                                for(i=0;i<num;i++)
                                {
                                    System.out.println("enter book number");
                                    record.bookNo=Integer.parseInt(br.readLine());
                                    System.out.println("enter book title");
                                    record.bookTitle=br.readLine();
                                    System.out.println("enter author name");
                                    record.bookAuthor=br.readLine();
                                    //write to a file
                                    fout.write(record.bookNo+"\t");
                                    fout.write(record.bookTitle+"\t");
                                    fout.write(record.bookAuthor+"\t");
                                }
                                fout.write("EOF");
                                fout.close();
                                break;
                            case 2:
                                FileWriter fw = new FileWriter("klu.txt");
                                FileReader fin1=new FileReader("bookdata.txt");
                                  Scanner sc1=new Scanner(fin1);
                                  while(sc1.hasNextInt())
                                  {
                                    record.bookNo=sc1.nextInt();
                                    fw.write(record.bookNo+"\n");
                                    record.bookTitle=sc1.next();
                                    fw.write(record.bookTitle+"\n");
                                    record.bookAuthor=sc1.next();
                                    fw.write(record.bookAuthor+"\n");
                                  }
                                   System.out.println("enter then no of records");
                                    num=Integer.parseInt(br.readLine());
                                  for(i=0;i<num;i++){
                                    System.out.println("enter book number");
                                    record.bookNo=Integer.parseInt(br.readLine());
                                    fw.write(record.bookNo+"\t");
                                    System.out.println("enter book title");
                                    record.bookTitle=br.readLine();
                                    fw.write(record.bookTitle+"\t");
                                    System.out.println("enter author name");
                                    record.bookAuthor=br.readLine();                  
                                    fw.write(record.bookAuthor+"\t");
                                    } 
                                    fw.write("EOF");
                                    fw.close();
                                    FileWriter fout1 = new FileWriter("bookdata.txt");
                                    FileReader fin2=new FileReader("klu.txt");
                                      Scanner sc2=new Scanner(fin2);
                                      while(sc2.hasNextInt())
                                      {
                                        record.bookNo=sc2.nextInt();
                                        fout1.write(record.bookNo+"\n");
                                        record.bookTitle=sc2.next();
                                        fout1.write(record.bookTitle+"\n");
                                        record.bookAuthor=sc2.next();
                                        fout1.write(record.bookAuthor+"\n");
                                      }
                                    fout1.write("EOF");
                                    fout1.close();
                                    break;

                            case 3:
                                System.out.println("enter book number");
                                searchBookNo=Integer.parseInt(br.readLine());
                            case 4:
                                    FileReader fin=new FileReader("bookdata.txt");
                                    Scanner sc=new Scanner(fin);
                    
                while(sc.hasNextInt())
                                    {
                                      record.bookNo=sc.nextInt();
                                      record.bookTitle=sc.next();
                                      record.bookAuthor=sc.next();
                                      if(choice==4)
                                          record.displayBooksRecord();
                                      if(choice==3)
                                      {
                                          if(record.bookNo==searchBookNo)
                                              record.displayBooksRecord();
                                      }
                                    }
                                    str=sc.next();
                                    if(str.equals("EOF"))
                                        System.out.println("END OF FILE");
                                    else
                                        System.out.println("File format error");

                                   break;
                            case 5:
                                  break first;
                 
                  
                        }                 
                    }
        case 2:
                        System.out.println("***BORROWERS INFORMATION***");
                        BorrowerRec record1=new BorrowerRec();
                        second: while(true)
                        {
                            System.out.println("\nMENU\n");
                            System.out.println("1.create");
                            System.out.println("2.update");
                            System.out.println("3.search");
                            System.out.println("4.record");
                            System.out.println("5.exit\n");
                            System.out.println("enter user option");
                            choice=Integer.parseInt(br.readLine());
                            switch(choice)
                            {
                                case 1:
                                FileWriter fout=new FileWriter("borrowerinfo.txt");
                                System.out.println("How many records");
                                num=Integer.parseInt(br.readLine());
                                for(i=0;i<num;i++)
                                {
                                    System.out.println("enter id number");
                                    record1.regNo=Integer.parseInt(br.readLine());
                                    System.out.println("enter name");
                                    record1.name=br.readLine();
                                    System.out.println("enter adress");
                                    record1.adress=br.readLine();
                                    fout.write(record1.regNo+"\n");
                                    fout.write(record1.name+"\n");
                                    fout.write(record1.adress+"\n");
                                }
                             
                             fout.write("EOF");
                                fout.close();
                                break;
                                case 2:
                                        FileWriter fw = new FileWriter("klu.txt");
                                        FileReader fin1=new FileReader("borrowerinfo.txt");
                                          Scanner sc1=new Scanner(fin1);
                                          while(sc1.hasNextInt())
                                          {
                                            record1.regNo=sc1.nextInt();
                                            fw.write(record1.regNo+"\n");
                                            record1.name=sc1.next();
                                            fw.write(record1.name+"\n");
                                            record1.adress=sc1.next();
                                            fw.write(record1.adress+"\n");
                                          }
                                           System.out.println("enter then no of records");
                                           num=Integer.parseInt(br.readLine());
                                          for(i=0;i<num;i++){
                                            System.out.println("enter id number");
                                            record1.regNo=Integer.parseInt(br.readLine());
                                            fw.write(record1.regNo+"\t");
                                            System.out.println("enter name");
                                            record1.name=br.readLine();
                                            fw.write(record1.name+"\t");
                                            System.out.println("enter adress");
                                            record1.adress=br.readLine();                  
                                            fw.write(record1.adress+"\t");
                                            } 
                                        fw.write("EOF");
                                        fw.close();
                                        FileWriter fout1 = new FileWriter("borrowerinfo.txt");
                                        FileReader fin2=new FileReader("klu.txt");
                                          Scanner sc2=new Scanner(fin2);
                                          while(sc2.hasNextInt())
                                          {
                                            record1.regNo=sc2.nextInt();
                                            fout1.write(record1.regNo+"\n");
                                            record1.name=sc2.next();
                                            fout1.write(record1.name+"\n");
                                            record1.adress=sc2.next();
                                            fout1.write(record1.adress+"\n");
                                          }
                                        fout1.write("EOF");
                                        fout1.close();
                                        break;
                                case 3:
                                    System.out.println("enter search id number");
                                    searchRegNo=Integer.parseInt(br.readLine());
                                case 4:
                                    FileReader fin=new FileReader("borrowerinfo.txt");
                                    Scanner sc=new Scanner(fin);
                                    while(sc.hasNextInt())
                                    {
                                      record1.regNo=sc.nextInt();
                                      record1.name=sc.next();
                                      record1.adress=sc.next();
                                      if(choice==4)
                                          record1.displayBorrowerInfo();
                                      if(choice==3)
                                      {
                                          if(record1.regNo==searchRegNo)
                                              record1.displayBorrowerInfo();
                                      }
                                    }
                                    str=sc.next();
                                    if(str.equals("EOF"))
                                        System.out.println("END OF FILE");
                                    else
                                        System.out.println("File format error");
                                    break;
                                case 5:
                                    break second;
                            }
                  }
                  
            case 3:
                    IssueRecord record2=new IssueRecord();
                    ReturnRecord record3=new ReturnRecord();
                    IssueRecord record6=new IssueRecord();
                    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Calendar cal = Calendar.getInstance();
                    cal.add(Calendar.DATE,14);
                    record2.returnDate=dateFormat.format(cal.getTime());
                    record6.returnDate=dateFormat.format(cal.getTime());
                    third: while(true)
                    {  
                        System.out.println("\n***ISSUES AND RETURNS***\n");
                        System.out.println("\nMENU\n");
                        System.out.println("1.ISSUES");
                        System.out.println("2.RETURNS");
                        System.out.println("3.SEARCH IN ISSUE FILE");
                        System.out.println("4.DISPLAY ISSUE FILE");
                        System.out.println("5.SEARCH IN RETURNS FILE");
                        System.out.println("6.DISPLAY RETURNS FILE");
                        System.out.println("7.EXIT\n");
                   
                        System.out.println("enter choice");
                        choice=Integer.parseInt(br.readLine());
                        switch(choice)
                        {
                            case 1:
                            count=count+1;
                            BorrowerRec record4=new BorrowerRec();
                            BookInfo record5=new BookInfo();
                            System.out.println("enter student id no:");
                            searchRegNo=Integer.parseInt(br.readLine());
                            FileReader fin=new FileReader("borrowerinfo.txt");
                            Scanner sc=new Scanner(fin);
                            while(sc.hasNextInt())
                            {++t;
                              record4.regNo=sc.nextInt();
                              record4.name=sc.next();
                              record4.adress=sc.next();
                              
                                  if(record4.regNo==searchRegNo){
                                      record2.regNo=searchRegNo;
                                  }
                            }
                            System.out.println("enter book number");
                            searchBookNo=Integer.parseInt(br.readLine());
                            FileReader fin1=new FileReader("bookdata.txt");
                                Scanner sc1=new Scanner(fin1);
                                while(sc1.hasNextInt())
                                {
                                  record5.bookNo=sc1.nextInt();
                                  record5.bookTitle=sc1.next();
                                  record5.bookAuthor=sc1.next();
                                  
                                  
                                      if(record5.bookNo==searchBookNo){
                                          record2.bookNo=searchBookNo;
                                      }
                                  
                                }
                           if(count==1){
                            FileWriter fout1=new FileWriter("issues.txt");
                            for(i=0;i<t;i++)
                                {
                                    
                                    fout1.write(record2.regNo+"\n");
                                    fout1.write(record2.bookNo+"\n");
                                    fout1.write(record2.issueDate+"\n");
                                    fout1.write(record2.returnDate+"\n");
                                }
                            fout1.write("EOF");
                            fout1.close();
                           }
                           else
                           {
                            FileWriter fout5 = new FileWriter("klume.txt");
                            FileReader fin4=new FileReader("issues.txt");
                              Scanner sc4=new Scanner(fin4);
                              DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
                              Calendar cal1 = Calendar.getInstance();
                              cal1.add(Calendar.DATE,14);
                              while(sc4.hasNextInt())
                              {
                                record6.regNo=sc4.nextInt();
                                fout5.write(record6.regNo+"\t");
                                record6.bookNo=sc4.nextInt();
                                fout5.write(record6.bookNo+"\t");
                                record6.issueDate=sc4.next();
                                fout5.write(record6.issueDate+"\t");
                                record6.returnDate=sc4.next();
                                fout5.write(record6.returnDate+"\t");
                              }
                              for(i=0;i<1;i++){
                                 record6.regNo=searchRegNo;
                                 fout5.write(record6.regNo+"\t");
                                 record6.bookNo=searchBookNo;
                                 fout5.write(record6.bookNo+"\t");
                                 fout5.write(record6.issueDate+"\t");
                                 record6.returnDate=dateFormat1.format(cal.getTime());
                                 fout5.write(record6.returnDate+"\t");
                                } 
                            fout5.write("EOF");
                            fout5.close();
                            
                            FileWriter fout3 = new FileWriter("issues.txt");
                            FileReader fin5=new FileReader("klume.txt");
                              Scanner sc5=new Scanner(fin5);
                              while(sc5.hasNextInt())
                              {
                              record6.regNo=sc5.nextInt();
                              fout3.write(record6.regNo+"\n");
                              record6.bookNo=sc5.nextInt();
                              fout3.write(record6.bookNo+"\n");
                              record6.issueDate=sc5.next();
                              fout3.write(record6.issueDate+"\n");
                              record6.returnDate=sc5.next();
                              fout3.write(record6.returnDate+"\n");  
                              }
                            fout3.write("EOF");
                            fout3.close();
                            }
                            break;
                            case 2:
                             IssueRecord record7=new IssueRecord();
                             ReturnRecord record8=new ReturnRecord();
                             FileWriter fout2=new FileWriter("returns.txt");
                             FileReader fin6=new FileReader("issues.txt");   
                             Scanner sc6=new Scanner("fin6");
                             System.out.println("enter id nunmber");
                             searchRegNo=Integer.parseInt(br.readLine());
                             System.out.println("enter book number");
                             searchBookNo=Integer.parseInt(br.readLine());
                             while(sc6.hasNextInt())
                                {
                                  record7.regNo=sc6.nextInt();
                                  record7.bookNo=sc6.nextInt();
                                  record7.issueDate=sc6.next();
                                  record7.returnDate=sc6.next();
                                      if(record7.bookNo==searchBookNo&&record7.regNo==searchRegNo){
                                          record8.regNo=searchRegNo;
                                      }
                                  
                                }
                             for(i=0;i<1;i++){
                                 fout2.write(record8.regNo+"\t");
                                 fout2.write(record8.returnDate);
                             }
                            fout2.write("EOF");
                            fout2.close();
                            break;
                            case 3:
                                System.out.println("enter search id number");
                                searchRegNo=Integer.parseInt(br.readLine());
                            case 4:
                                 FileReader fin2=new FileReader("issues.txt");
                                Scanner sc2=new Scanner(fin2);

                                while(sc2.hasNextInt())
                                { 
                                  record2.regNo=sc2.nextInt();
                                  record2.bookNo=sc2.nextInt();
                                  record2.issueDate=sc2.next();
                                  record2.returnDate=sc2.next();
                                  if(choice==4)
                                      record2.displayIssueRecord();
                                  if(choice==3)
                                  {
                                      if(record2.regNo==searchRegNo)
                                          record2.displayIssueRecord();
                                  }
                                }
                                str=sc2.next();
                                if(str.equals("EOF"))
                                    System.out.println("END OF FILE");
                                else
                                    System.out.println("File format error");
                                break;
                            case 5:
                                int searchRecNo=0;
                                System.out.println("enter search id number");
                                searchRegNo=Integer.parseInt(br.readLine());
                            case 6:
                                 FileReader fin3=new FileReader("returns.txt");
                                Scanner sc3=new Scanner(fin3);
                                while(sc3.hasNextInt())
                                {
                                  record3.regNo=sc3.nextInt();

                                  record3.returnDate=sc3.next();
                                  if(choice==6)
                                      record3.displayReturnRecord();
                                  if(choice==5)
                                  {
                                      if(record3.regNo==searchRegNo)
                                          record3.displayReturnRecord();
                                  }
                                }
                                str=sc3.next();
                                if(str.equals("EOF"))
                                    System.out.println("END OF FILE");
                                else
                                    System.out.println("File format error");

                                break;
                            case 7:
                                break third;
                        }
                    }
                    break;
                case 4:
                   flag=false;
                   break;
           }
     }}
}
