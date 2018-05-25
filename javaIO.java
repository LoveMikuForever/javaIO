package foldIO;

import java.io.IOException;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Arrays;
import java.util.List;


public class newIO {
	public static void main(String[] args) throws IOException{
		Path path1 = Paths.get("D:\\test");
		Path path2 = Paths.get("D:\\test\\test.txt");
		try{
			Files.createFile(path2);
		}catch(IOException e) {
			if(Files.exists(path2)){
				Files.delete(path2);
				Files.createFile(path2);
			}
		}
		try(OutputStream is = Files.newOutputStream(path2,StandardOpenOption.WRITE,StandardOpenOption.APPEND);BufferedOutputStream bf = new BufferedOutputStream(is)){
			for(int i = 0 ; i < 20 ; i ++) {
				bf.write((int)(Math.random()*101));
				bf.flush();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		try(InputStream is = Files.newInputStream(path2,StandardOpenOption.READ);BufferedInputStream bi = new BufferedInputStream(is)){
			int c = 0;
			while((c = bi.read())!=-1) {
				System.out.print(c + " ");
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
