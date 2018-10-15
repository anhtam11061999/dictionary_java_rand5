
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AnhTam
 */
public class dictionary{
    public static int  n=100;
    public static Word word[];
    public static  String fname = "word.txt";
    public static int soluongtu = 0;
    public static Scanner input = new Scanner(System.in);

    public dictionary(){
        word =  new Word[n]; 
    }
    public void Menu(){
        System.out.println("1. Them tu");
        System.out.println("2. Tim kiem");
        System.out.println("3. Xoa tu");
        System.out.println("4. Sua tu");
        System.out.println("5. In ra tat ca cac tu");
        System.out.println("6. Luu");
        System.out.println("7. Thoat");
        System.out.println("Lua chon: ");
    }
   
    public void add_word(){
        addword:
        while(true){
        int stt = soluongtu+1;
        String tu;
        String nghia;
        String loai;
        if(soluongtu>=100) System.out.println("Da qua so luong tu cho phep."); 
        else {
            input = new Scanner(System.in);
            System.out.println("Stt: "+stt);
            System.out.println("Nhap tu: ");
            tu = input.next().toLowerCase();
            input = new Scanner(System.in);
            System.out.println("Nhap nghia cua tu: ");
            nghia = input.nextLine();
            System.out.println("Nhap loai cua tu: ");
            input = new Scanner(System.in);
            loai = input.nextLine();
            word[soluongtu] = new Word(tu, nghia, loai);
            soluongtu++;
            }
        String yeu_cau;
            do{
                System.out.println("Ban co muon nhap them tu(Y/N): ");
            input = new Scanner(System.in);
            yeu_cau = input.next().toUpperCase();
            if(yeu_cau.equals("N"))
            {
                break addword;
            }}
            while(!yeu_cau.equals("Y")&&!yeu_cau.equals("N"));
        }
    }
     public void file(){
        BufferedWriter Bu = null;
        FileWriter Fi = null;
        try{
            String dt="";
            File file = new File(fname);
        if (!file.exists())
        {
            file.createNewFile();
        }
        Fi = new FileWriter(file.getAbsoluteFile(), true);
        Bu = new BufferedWriter(Fi);
        int i;
        for(i = 0;i<soluongtu;i++){
            dt = ""+word[i].word+"\t"+word[i].mean+"\t"+word[i].type+"\r\n";
            Bu.write(dt);
            dt = "";
     
        }
                Bu.write(dt);}
        catch(IOException e) {
            e.printStackTrace();
        }finally {
			try {
				if (Bu != null)
					Bu.close();
				if (Fi != null)
					Fi.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
        }
    }
     public void readfile() throws FileNotFoundException {
         int i = soluongtu;
         FileInputStream fis = new FileInputStream(fname);
        Scanner scanner = new Scanner(fis);
        while(scanner.hasNextLine()){
           String[] str = scanner.nextLine().split("\t");
           word[i] = new Word(str[0], str[1], str[2]);
           i++;
           soluongtu++;        
        }
 
        scanner.close();
    }
     
    public void delfile(){
        File file = new File(fname);
        if (file.exists()) {
            file.delete();
        }
          
    }
     
    public void search(){
        int a;
        int b ;
        input = new Scanner(System.in);
        String searchword;
        if(soluongtu==0) {
            System.out.println("Tu Dien Hien Dang Khong Co Tu Nao");
        }
        else{
            System.out.println("Nhap tu ban muon tim: ");
            searchword = input.next().toLowerCase();
            for(b=0;b<soluongtu;b++)
            {
                if(word[b].word.substring(0,searchword.length()).equals(searchword)){
                    a = 1;
                    System.out.println(" -------------------------------------------------------------- ");
                    System.out.println("| Stt |      English      |        Vietnamses       |   Type   |");
                    System.out.println(" --------------------------------------------------------------");
                    System.out.println("|   "+(b+1)+"  |          "+word[b].word+"      |      "+word[b].mean+"      |   "+word[b].type+"    |");
                }
            }
        }
    }
    
    public void delete()
    {
        String deleteword;
        int m;
        input = new Scanner(System.in);
        if(soluongtu==0)
        {
            System.out.println("Tu dien khong co tu.");
            
        }
        else{
            int a= 0;
            System.out.println("Nhap tu ban muon xoa: ");
            deleteword = input.next().toLowerCase();
            for( m = 0;m<soluongtu;m++)
            {
                if(word[m].word.equals(deleteword))
                {
                    for(int j = m;j<soluongtu-1;j++)
                    {
                        word[m]= word[j+1];
                        a =1;
                    }
                }
            }
            
            if( a == 1){
                 System.out.println("Ban da xoa tu thanh cong.");
            }else {
                System.out.println("Khong tim thay tu ban muon xoa.");
            
            
            soluongtu--;
        }
    }
    }
    public void edit()
    {
        int c , d=0;
        int a, c1 = 0 ;
        System.out.println("Nhap lua chon ban muon: ");
        System.out.println("\n1. Sua tu");
        System.out.println("\n2. Sua nghia cua tu");
        System.out.println("\n3. Sua loai tu");
        System.out.println("\nLua chon: ");
        a = input.nextInt();
        System.out.println("Nhap tu can sua: ");
        String editword;
        String newword;
        String newmean;
        String newtype;
        editword = input.next().toLowerCase();
        input = new Scanner(System.in);    
        for(c = 0;c<soluongtu;c++)
        {
            if(word[c].word.equals(editword))
            {    
                d = 1;  
                c1 = c;
        }}
        if(d==1)
        {
             switch(a){
                        case 1: 
                            System.out.println("Tu can sua: "+word[c1].word);
                            System.out.println("Ban muon sua thanh: ");
                            newword = input.next().toLowerCase();
                            word[c1] = new Word(newword,word[c1].mean,word[c1].type);
                            System.out.println("Ban da sua thanh cong.");
                            break;
                        case 2:
                            System.out.println("Nghia cua tu: "+word[c1].word+": "+word[c1].mean);
                            System.out.println("Ban muon sua thanh: ");
                            newmean = input.nextLine();
                            word[c1] = new Word(word[c1].word,newmean,word[c1].type);
                            System.out.println("Ban da sua thanh cong.");
                            break;
                        case 3:
                            System.out.println("Loai cua tu: "+word[c1].word+": "+word[c1].type);
                            System.out.println("Ban muon sua thanh: ");
                            newtype = input.nextLine();
                            word[c1] = new Word(word[c1].word,word[c1].mean,newtype);
                            System.out.println("Ban da sua tu thanh cong.");
                            break;
                        default:
                            System.out.println("Lua chon tu 1->3");
                            break;
            }
        }else System.out.println("Khong tim thay tu can sua");
        
    }
    
    public void print(){
        System.out.println(" --------------------------------------------------------------");
        System.out.println("| Stt |      English      |        Vietnamses       |   Type   |");
        System.out.println(" --------------------------------------------------------------");
        int a;
        for(a =0;a<soluongtu;a++)
        {
            System.out.println("|  "+(a+1)+" |        "+word[a].word+"       |      "+word[a].mean+"      |  "+word[a].type+"    |");
           
  
        }
        System.out.println("----------------------------------------------------------------");
    }
    
    public void use_menu() throws FileNotFoundException{
        dictionary td = new dictionary();
        while(true)
        {
            td.Menu();
            int chon;
            input = new Scanner(System.in);
            chon= input.nextInt();
            switch(chon){
                case 1: 
                    td.add_word();
                    break;
                case 2:
                    td.search();
                    break;
                case 3:
                     td.delete();
                    break;
                case 4:
                   td.edit();
                    break;
                case 5:
                    td.readfile();
                    td.print();
                    break;
                case 6:
                    td.delfile();
                    td.file();
                    System.out.println("da luu vao file");
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Nhap so tu 1->7");
                    break;
            }
        }
    }
}
