package com.roll.comical.console.business.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * User: roll
 * Date: 2017/2/18
 * Time: 下午5:26
 *
 * @author zongqiang.hao
 */
public class client {
	public static void main(String args[]) throws IOException {
		/*String msg = "Client Data";
		Socket socket = new Socket("127.0.0.1",8080);
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw.println(msg);
		pw.flush();
		String line = is.readLine();
		System.out.println("recieved from server:"+line);
		pw.close();
		is.close();
		socket.close();*/

		String videos = "331776";
		String a  = videos.substring(0, videos.indexOf("."));
		int videoRate = Integer.parseInt(videos.substring(0, videos.indexOf(".")));
	}
}
