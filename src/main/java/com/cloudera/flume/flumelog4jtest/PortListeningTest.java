package com.cloudera.flume.flumelog4jtest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class PortListeningTest {

	public static void main(String[] args) throws IOException {
		InetAddress addr = InetAddress.getByName("10.20.52.224");  
		Socket socket = new Socket(addr, 41414);  
		System.out.println("Program is listenig to the port..41414");
		socket.close();
		System.out.println("Port is closed..!");

	}

}
