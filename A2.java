package main;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
public class A2 {


	
		public static void main(String[] args) throws IOException , DocumentException, FileNotFoundException {
			
			char arr[] = args[0].toCharArray();
			int count[] = new int[arr.length];
			displayAscii(arr,count,args[0], args[1]);
		
		}
		public static String print_Invisible(int ctr) {
			
			String char_01[]  =  {"NULL", "SOH", "STX", "ETX", "EOT", "ENQ", "ACK", "BEL", "BS", "HT", "LF", "VT", "FF", "CR", "SO", "SI",
					"DLE", "DC1", "DC2", "DC3", "DC4", "NAK", "SYN", "ETB", "CAN", "EM", "SUB", "ESC", "FS", "GS", "RS", "US", "SPACE"};
			String char_02[] = {"DEL", "Ç", "ü", "é", "â", "ä", "à", "å", "ç", "ê", "ë", "è", "ï", "î", "ì", "Ä", "Å", "É", "æ", "Æ",
					"ô", "ö", "ò", "û", "ù", "ÿ", "Ö", "Ü", "ø", "£", "Ø", "×", "ƒ", "á", "í", "ó", "ú", "ñ", "Ñ", "ª", "º", "¿", "®", "¬",
					"½", "¼", "¡", "«", "»", "░", "▒", "▓", "│", "┤", "Á", "Â", "À", "©", "╣","║", "╗", "╝", "¢", "¥", "┐", "└", "┴", "┬", "├",
					"─", "┼", "ã", "Ã", "╚", "╔", "╩", "╦", "╠", "═", "╬", "¤", "ð", "Ð", "Ê", "Ë", "È", "ı", "Í", "Î", "Ï", "┘", "┌", "█", "▄",
					"¦", "Ì", "▀", "Ó", "ß", "Ô", "Ò", "õ", "Õ", "µ", "þ", "Þ", "Ú", "Û", "Ù", "ý", "Ý", "¯", "´", "≡", "±", "‗", "¾", "¶", "§",
					"÷", "¸", "°", "¨", "·", "¹", "³", "²", "■", "Nbsp"};
			
			if (ctr <= 32) 
				return char_01[ctr];
			
			else 
				return char_02[ctr - 127];
		}
		public static void count_Occurances(char arr[], int count[]) {

			for(int i = 0; i < arr.length;i++) {
				count[i] = 1;
					for(int j = i+1; j < arr.length; j++) {
						if(arr[i] == arr[j]) {
							count[i]+=1;
							arr[j] = (char) 0;
						}
					}
			}
		}
		public static int print_Occurances(char arr[], int count[],char symbol) {
			int counter = 0;
			for(int index = 0; index<arr.length;index++) {
				if(arr[index]== symbol) {
					counter = count[index];
				}
			}return counter;
		}
		
	
	public static void Sleep(int time) {
		try {
			Thread.sleep(time);
		}catch (Exception e) {}
	}
	public static boolean check_character(char symbol, char arr[]){
		boolean check = false;
		
		if(symbol != (char) 0){
			for(int i = 0; i<arr.length; i++) {
				if(symbol == arr[i]) {
					check = true;
				}
			}
		}return check;
	}
	public static int count_visible(String characters) {
		char arr[] = characters.toCharArray();
		int count = 0;
		
		for(int index = 0; index <arr.length;index++){
			if(arr[index] >32 && arr[index]<127)
			count+= 1;
		}return count;
		
	}
	public static int count_invisible(String characters) {
		
		char arr[] = characters.toCharArray();
		int count = 0;
		
		for(int ctr = 0; ctr <arr.length;ctr++){
			if(arr[ctr] <33 || arr[ctr] == 127){
				count += 1;
			}
		}return count;
	}
	public static int Embedded(String Char_01, String Char_02) {
		int count = 0;
		
		if(!Char_01.isEmpty()&& !Char_02.isEmpty()) {
			count = (Char_01.length() - Char_01.replace(Char_02, "").length())/ Char_02.length();
		}return count;
	}
	public static int Total_Characters(int num, int num2){
		int count = num + num2;
		return count;
	}
	public static void displayAscii(char arr[], int count[], String char_01, String char_02)throws IOException , 
	DocumentException, FileNotFoundException {
		Document document = new Document();
		
	        PdfWriter.getInstance(document,new FileOutputStream("D:\\ Mp2_Result.pdf"));
	        document.open();
	        PdfPTable table = new PdfPTable(3);
	        PdfPCell cell;
	        
	        String imgLoc = "D:\\love2.png";
	        Image image1 = Image.getInstance(imgLoc);
	        image1.setAbsolutePosition(225f, 680f);
	        image1.scaleAbsolute(150f, 150f);
	        document.add(image1);
	        
	        Paragraph para = new Paragraph();
		    para.add("Gomez and Gaspar's ASCII Table Machine Problem");
		    para.setAlignment(Element.ALIGN_CENTER);
		    para.setSpacingBefore(135);
		    para.setSpacingAfter(20);
		    document.add(para);
		    
		    
		
		table.addCell("DEC");
		table.addCell("Char");
		table.addCell("OCC");
		System.out.println("DEC\tChar\t\tOCC");
		count_Occurances(arr,count);
		for (int ctr = 0; ctr <=255; ctr++) {
			char symbol = (char) ctr;
			
			if( ctr <=32){
				String s= Integer.toString(ctr);
				String val = print_Invisible(ctr);
				
				table.addCell(s);
				table.addCell(val);
				System.out.print(ctr+"\t"+val+"\t\t");
				if(check_character(symbol, arr)) {
					int occ = print_Occurances(arr,count,symbol);
					System.out.println(occ);
					String oc = Integer.toString(occ);
					table.addCell(oc);
				}
				else
				table.addCell("0");	
				System.out.println("0");
			}
			else if(ctr == 127) {
				String s= Integer.toString(ctr);
				String val = print_Invisible(ctr);
				table.addCell(s);
				table.addCell(val);
				System.out.print(ctr+"\t"+val+"\t\t");
				if(check_character(symbol, arr)){
					int occ = print_Occurances(arr,count,symbol);
					System.out.println(occ);
					String oc = Integer.toString(occ);
					table.addCell(oc);
				}
				else {
					table.addCell("0");
					System.out.println("0");
				}
				Scanner pause = new Scanner(System.in);
				String text = "Press any key to Continue: ";
				System.out.println(text);
				cell = new PdfPCell(new Phrase(text));
				cell.setColspan(3);
				table.addCell(cell);
				pause.nextLine();
				pause.close();
				System.out.println("Pls wait loading....");
				Sleep(2000);
			}
			else if(ctr >127) {
				String s= Integer.toString(ctr);
				String val = print_Invisible(ctr);
				table.addCell(s);
				table.addCell(val);
				System.out.print(ctr+"\t"+val+"\t\t");
				if(check_character(symbol, arr)) {
					int occ = print_Occurances(arr,count,symbol);
					System.out.println(occ);
					String oc = Integer.toString(occ);
					table.addCell(oc);
				}
				else {
					table.addCell("0");
					System.out.println("0");
				}
					
			}
			else {
				String s= Integer.toString(ctr);
				String sym= Character.toString(symbol);
				table.addCell(s);
				table.addCell(sym);
				System.out.print(ctr+"\t"+symbol+"\t\t");
				if(check_character(symbol, arr)) {
					int occ = print_Occurances(arr,count,symbol);
					System.out.println(occ);
					String oc = Integer.toString(occ);
					table.addCell(oc);
				}
				else
					table.addCell("0");
					System.out.println("0");
			}
		}
		document.add(table);
	      Paragraph para1 = new Paragraph();
	      Paragraph para2 = new Paragraph();
	      Paragraph para3 = new Paragraph();
	      Paragraph para4 = new Paragraph();
	      para1.add("\nNumber of Invisible Characters: "+ count_invisible(char_01));
	      para2.add("Number of Visible Characters: " + count_visible(char_01));
	      para3.add("Total Characters: " + Total_Characters(count_visible(char_01), count_invisible(char_01)));
	      para4.add("Embedded Word Occurances: " + Embedded(char_01,char_02));
	      para1.setAlignment(Element.ALIGN_LEFT);
	      para2.setAlignment(Element.ALIGN_LEFT);
	      para3.setAlignment(Element.ALIGN_LEFT);
	      para4.setAlignment(Element.ALIGN_LEFT);
	      document.add(para1);
	      document.add(para2);
	      document.add(para3);
	      document.add(para4);
	      
	     
		System.out.println("\nNumber of Invisible Characters: " + count_invisible(char_01));
		System.out.println("Number of Visible Characters: " + count_visible(char_01));
		System.out.println("Total Characters: " + Total_Characters(count_visible(char_01), count_invisible(char_01)));
		System.out.println("Embedded Word Occurances: " + Embedded(char_01,char_02));

        document.close();
	}
}
