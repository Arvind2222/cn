// CLIENT-SERVER USING NETWORK SOCKET CONNECTION.


//	SERVER
import java.net.*;  
import java.io.*;  
class myserver
{  
public static void main(String args[])throws IOException
{  
	ServerSocket ss=new ServerSocket(3333);  
	Socket s=ss.accept();  
	DataInputStream din=new DataInputStream(s.getInputStream());  
	DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
	String str="",str2="";  
	while(!str.equals("stop")){  
	str=din.readUTF();  
	System.out.println("client says: "+str);
	System.out.print("You: ");  
	str2=br.readLine();  
	dout.writeUTF(str2);  
	dout.flush();  
}  
System.out.println("Closing Connection");
din.close();  
s.close();  
ss.close();  
}
		

//CLIENT
import java.net.*;  
import java.io.*;  
class myclient
{  
	public static void main(String args[])throws IOException{  
	Socket s=new Socket("localhost",3333);  
	DataInputStream din=new DataInputStream(s.getInputStream());  
	DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  	System.out.print("You: ");
	String str="",str2="";  
	while(!str.equals("stop"))
	{  
		str=br.readLine();  
		dout.writeUTF(str);  
		dout.flush();  
		str2=din.readUTF();  
		System.out.println("Server says: "+str2); 
		System.out.print("You: "); 
	}  
System.out.println("Connection Terminated");
dout.close();  
s.close();  
}



