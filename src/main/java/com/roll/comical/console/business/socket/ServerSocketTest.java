package com.roll.comical.console.business.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * User: roll
 * Date: 2017/2/18
 * Time: 下午5:17
 *
 * @author zongqiang.hao
 */
public class ServerSocketTest {
	public static void main(String args[]) throws IOException {
		ServerSocket server = new ServerSocket(8080);
		Socket socket = server.accept();
		BufferedReader fs = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line = fs.readLine();
		System.out.println("receive from client:" + line);
		PrintStream pw = new PrintStream(socket.getOutputStream());
		pw.print("receive data:" + line);
		pw.flush();
		pw.close();
		fs.close();
		socket.close();
		server.close();
	}
}
