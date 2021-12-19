package com.dnapass.java.training.files;


	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileWriter;
	import java.io.IOException;


	public class BufferedReaderSample {
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			
			try {
	            FileWriter writer = new FileWriter("Sample.txt", true);
	            BufferedWriter bufferedWriter = new BufferedWriter(writer);
	 
	            bufferedWriter.write("Hello HCL");
	          
	 
	            bufferedWriter.close();
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

		}
	}



//javaIofile
package com.dnapass.java.training.files;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import com.dnapass.java.training.ineritance1.Account;





public class JavaIOFileDemo {

	public static void main(String[] args) throws IOException,ClassNotFoundException {
		FileInputStream in=null;
		FileOutputStream out=null;
		try {
			in=new FileInputStream("input.txt");
			out=new FileOutputStream("output-bytes.txt");
			int c;
			while((c=in.read())!=-1) {
				out.write(c);
			}
			FileReader inputStream=new FileReader("input.txt");
			FileWriter outputStream=new FileWriter("output.chars.txt");
			
			while((c=inputStream.read())!=-1) {
				outputStream.write(c);
		} 
			
	   BufferedReader reader=new BufferedReader(new FileReader("input.txt"));	
	   PrintWriter writer=new PrintWriter(new FileWriter("buffered-output.txt"));
	   
      String l;
      while((l=reader.readLine())!=null) {
    	  writer.println(l);
      }
      
      BufferedReader bufReader=new BufferedReader(new FileReader("input.txt"),16384);
      BufferedWriter bufWriter=new BufferedWriter(new FileWriter("buffer.output.txt"),16834);
      
      while((c=bufReader.read())!=-1) {
			bufWriter.write(c);
	}
      while((l=bufReader.readLine())!=null) {
    	  bufWriter.write(l);
      }
		
      Scanner s=new Scanner(new BufferedReader(new FileReader("usnumbers.txt")));
      
      while(s.hasNext()) {
    	  System.out.println(s.next());
      }
      
      double sum=0;
      s=new Scanner(new BufferedReader(new FileReader("usnumbers.txt")));
      s.useLocale(Locale.US);
      
      while(s.hasNext()) {
    	  if(s.hasNextDouble()) {
    		  sum+=s.nextDouble();
    	  }else {
    		  s.next();
    	  }
      }
      
      final String dataFile="invoice.dat";
      final double[] prices= {19.99,9.99,15.99,3.99,4.99};
      final int[] units= {12,8,13,29,50};
      final String[] descs= {"Java T-shirt","Java Mug","Duke Juggling Dolls","Java Pin","Java Key Chain"};
      //List<Invoice> invoices=DataLoader.newInvoices();
      
      DataOutputStream out1=new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)));
      
      for(int i=0;i<prices.length;i++) {
    	  out1.writeDouble(prices[i]);
    	  out1.writeInt(units[i]);
    	  out1.writeUTF(descs[i]);
    	  
      }
      DataInputStream in1=new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile)));
      double price;
      int unit;
      String desc;
      double total=0.0;
      
      try {
    	  while(true) {
    		  price=in1.readDouble();
    		  unit=in1.readInt();
    		  desc=in1.readUTF();
    		  System.out.format("you ordered %d"+"units of %s at $%.2f%n",units,desc,price);
    		  total+=unit*price;
    	  }
      }catch (EOFException e) {
      }
      Account account=new Account(1,20000);
      ObjectOutputStream out2=new ObjectOutputStream(new FileOutputStream("bank.dat"));
      out2.writeObject(account);
      
      ObjectInputStream in2=new ObjectInputStream(new FileInputStream("bank.dat"));
      Account account1=(Account) in2.readObject();
      System.out.println(account1);
      
      List<Account> list1=new ArrayList<Account>();
      list1.add(new Account(1,20000));
      list1.add(new Account(2,20000));
      list1.add(new Account(3,20000));
      list1.add(new Account(4,20000));
      out2.writeObject(list1);
      
      ArrayList<Account> list=(ArrayList<Account>)in2.readObject();
      System.out.println(list);
	
		}finally {
			if(in !=null) {
				in.close();
			}
			if(out!=null) {
				out.close();
			}
		}
      
      
      
	}
}
//javaIOfiledemo
package com.dnapass.java.training.files;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.BasicFileAttributes;

public class JavaNIOFileDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Path path=Paths.get("c:\\home\\joe\\foo");
		
		System.out.format("toString: %s%n",path.toString());
		System.out.format("getFileName: %s%n",path.getFileName());
		System.out.format("getName(0): %s%n",path.getName(0));
		System.out.format("getNameCount: %s%n",path.getNameCount());
		System.out.format("subpath(0,2): %s%n",path.subpath(0,2));
		System.out.format("get Parent: %s%n",path.getParent());
		System.out.format("getRoot: %s%n",path.getRoot());
		
		Path p1=Paths.get("c:\\home\\joe\\foo");
		//Result is file:///home/logfile
		System.out.format("toString: %s%n",p1.toUri());
		
		Path path1=Paths.get("sally\\bar");
		Path fullpath=path1.toAbsolutePath();
		
		Path fp=path1.toRealPath();
		
		//Microsoft windows
		Path p11=Paths.get("c:\\home\\joe\\foo");
		System.out.format("%s%n",p11.resolve("bar"));
		
		Path pa2=Paths.get("sally");
		Path pa1=Paths.get("jce");
		
		
		Path pa1_to_pa2=pa1.relativize(pa2);
		Path pa2_to_pa1=pa2.relativize(pa1);
		
		
		Path pb1=Paths.get("home");
		Path pb3=Paths.get("home/sally/bar");
		
		
		Path p1_to_p3=pb1.relativize(pb3);
		Path p3_to_p1=pb3.relativize(pb1);
		
		Path path11=null;
		Path otherPath=null;
		Path beginning=Paths.get("/home");
		Path ending=Paths.get("foo");
		
		
		if(path11.equals(otherPath)) {
			//equality logic here
		}else if(path11.startsWith(otherPath)) {
			//path begins with "/home"
		}else if(path11.endsWith(otherPath)) {
			//path ends with "foo"
		}
		System.out.println();
		
		path=Paths.get("input.txt");
		System.out.println(Files.exists(path));
		Path tempFile=Files.createTempFile("dir","inpt.txt");
		System.out.println(Files.exists(tempFile));
		Path tempDirectory=Files.createTempDirectory("dir-exists");
		System.out.println(Files.exists(tempDirectory));
		System.out.println(Files.notExists(tempDirectory));
		
		System.out.println(Files.isDirectory(tempDirectory));
		System.out.println(Files.isDirectory(tempFile));
		System.out.println(Files.isRegularFile(tempFile));
		
		System.out.println(Files.isReadable(tempFile));
		System.out.println(Files.isReadable(Paths.get("/root/not-readbale.txt")));
		
		boolean isRegularExecutableFile=Files.isRegularFile(path)&
				Files.isReadable(path)&Files.isExecutable(path);
		
		if(Files.isSameFile(p1,path)) {
			//logic when the paths locate the same file
			
		}
		try {
			Files.delete(path);
		}catch(NoSuchFileException x) {
			System.err.format("%s: no such"+"file or directory %n",path);	
		}catch(DirectoryNotEmptyException x) {
			System.err.format("%s not empty%n",path);
		}catch(IOException x) {
			//File permission problems are caught here
			System.err.println(x);
			
		}
		Path source=p1;
		Path target=path;
		Files.copy(source,target,StandardCopyOption.REPLACE_EXISTING);
		
		Files.move(source, target,StandardCopyOption.REPLACE_EXISTING);
		
		Path file=p1;
		BasicFileAttributes attr=Files.readAttributes(file,BasicFileAttributes.class);
		
		System.out.println("CreationTime:"+attr.creationTime());
		System.out.println("lastAccessTime:"+attr.lastAccessTime());
		System.out.println("lastModifiedTime:"+attr.lastModifiedTime());

		
		System.out.println("isdirectory:"+attr.isDirectory());
		System.out.println("isOther:"+attr.isOther());
		System.out.println("isRegularFile:"+attr.isRegularFile());
		System.out.println("isSymbolicLink:"+attr.isSymbolicLink());
		System.out.println("size:"+attr.size());
		
		
		FileStore store=Files.getFileStore(file);
		
		long total=store.getTotalSpace();
		long used=(store.getTotalSpace()-store.getUsableSpace());
		long avail=store.getUsableSpace();
		
		//Reading all bytes from a file
		byte[] fileArray;
		fileArray=Files.readAllBytes(file);
		Files.write(file, fileArray);
		
		//Buffered I/O mehods for text files
		
		Charset charset=Charset.forName("US-ASCII");
		try(BufferedReader reader=Files.newBufferedReader(file,charset)) {
			String line=null;
			while((line=reader.readLine())!=null) {
				System.out.println(line);
			}
			
		}catch(IOException x) {
			System.err.format("IOException: %s%n",x);
		}
		
	  charset=Charset.forName("US-ASCII");
	  String s="file content";
		try(BufferedWriter writer=Files.newBufferedWriter(file,charset)){
			writer.write(s,0,s.length());
			} catch (IOException x) {
			System.err.format("IOException: %s%n",x);
		}
		

		//Methods for Unbuffered Streams
		Path p=Paths.get("logfile.txt");
		try(InputStream in=Files.newInputStream(file);
				BufferedReader reader=
						new BufferedReader(new InputStreamReader(in));
				OutputStream out=new BufferedOutputStream(
						Files.newOutputStream(p,StandardOpenOption.CREATE,StandardOpenOption.APPEND))){
			String line=null;
			while((line=reader.readLine())!=null){
				System.out.println(line);
				out.write(line.getBytes(),0,line.length());
			}
		}catch (IOException x) {
			System.err.println(x);
		}
		

	}

}
//randomaccessfile
package com.dnapass.java.training.files;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

import com.dnapass.java.training.exceptions.Account;



public class RandomAccessFileDemo {

	public static void main(String[] args) throws IOException {
	
		// TODO Auto-generated method stub

		Scanner in=new Scanner(System.in);
		BankData data=new BankData();
		try {
			data.open("bank.dat");
			boolean done=false;
			while(!done) {
				System.out.println("Account number");
				int accountNumber=in.nextInt();
				System.out.println("amount to deposit");
				double amount=in.nextDouble();
				
				int position=data.find(accountNumber);
				Account account;
				if(position>=0) {
					account=data.read(position);
					account.deposit(amount);
					System.out.println("new balance="+account.getAccountBalance());
				}else
				{
					account=new Account(accountNumber,amount);
					position=data.size();
					System.out.println("add account");
				}
				data.write(position,account);
				System.out.println("Done?(Y/N)");
				String input=in.next();
				if(input.equalsIgnoreCase("Y"))
					done=true;
			}
		}finally {
			data.close();
		}	
		  
	}

}
class BankData {
	public BankData() {
		file=null;
	}
	public void open(String filename) throws IOException{
		if(file!=null)
			file.close();
		file=new RandomAccessFile(filename,"rw");
	}
	public int size() throws IOException{
		return (int) (file.length()/RECORD_SIZE);	
	}
	public void close() throws IOException{
		if(file!=null)
			file.close();
		file=null;
	}
	public Account read(int n)throws IOException{
		file.seek(n*RECORD_SIZE);
		int accountNumber=file.readInt();
		double balance=file.readDouble();
		return new Account(accountNumber,balance);
	}
	public int find(int accountNumber)throws IOException{
		for(int i=0;i<size();i++) {
			file.seek(i*RECORD_SIZE);
			int a=file.readInt();
			if(a==accountNumber)
				return i;	
			}
		return -1;
		
	}
	public void write(int n,Account account) throws IOException{
		file.seek(n*RECORD_SIZE);
		file.writeInt(account.getAccountNumber());
		file.writeDouble(account.getAccountBalance());	
	}
	private RandomAccessFile file;
	public static final int INT_SIZE=4;
	public static final int DOUBLE_SIZE=8;
	public static final int RECORD_SIZE=INT_SIZE+DOUBLE_SIZE;
	}