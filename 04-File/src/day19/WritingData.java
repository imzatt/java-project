package day19;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class WritingData {

	public static void main(String[] args) throws IOException {
		
		var path = Path.of("src/cities.txt");
		
		//File_Writes(path);
		//WriteString(Path.of("student.txt"));
		//BufferWriter(Path.of("tester1.txt"));
		//readWithChannel();
		//readLarFileWithChannel();
		//writeWithChannel();
		writeLargeDataWithChannel();
		
	}

	private static void writeLargeDataWithChannel() {
		
		String data = """
				Join Zoom Meeting
				https://us06web.zoom.us/j/85453624098?pwd=Z2JaT3dpMERzTVhVN1Jqdk5mMGlvdz09

				Meeting ID: 854 5362 4098
				Passcode: 6FrzpZ
				""";
		
		try(RandomAccessFile file = new RandomAccessFile("data-1.txt", "rw")) {
			
			FileChannel channel = file.getChannel();
			
			MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 1024*8);
			
			buffer.put(data.getBytes());
			
			System.out.println("Save Success.....");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	private static void writeWithChannel() {
		
		String data = """
				Join Zoom Meeting
				https://us06web.zoom.us/j/85453624098?pwd=Z2JaT3dpMERzTVhVN1Jqdk5mMGlvdz09

				Meeting ID: 854 5362 4098
				Passcode: 6FrzpZ
				""";
		
		try(RandomAccessFile file = new RandomAccessFile("data.txt", "rw")) {
			
			//1
			FileChannel channel = file.getChannel();
			//2
			byte[] content = data.getBytes();
			ByteBuffer buffer = ByteBuffer.allocate(content.length);
			//3 (write data to buffer from java)
			buffer.put(content);
			//4
			buffer.flip();
			//5
			channel.write(buffer);
			System.out.println("Sava success......");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void readLarFileWithChannel() {
		
		try(FileChannel channel = FileChannel.open(Path.of("src/employee.txt"), StandardOpenOption.READ)) {
			int buffer_size = 1024;
			
			if(buffer_size > channel.size())
				buffer_size = (int)channel.size();
			
			ByteBuffer buffer = ByteBuffer.allocate(buffer_size);
			
			while(channel.read(buffer) > 0) { // return -1 there is no data in file
				buffer.flip();
				String data = new String(buffer.array(), 0 , buffer.limit());
				System.out.println("Content : " + data);
				buffer.clear();
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void readWithChannel() {
		
		try(RandomAccessFile inputFile = new RandomAccessFile("src/employee.txt", "r")) {
			
			//get file channel
			FileChannel channel = inputFile.getChannel();
			long fileSize = channel.size();
			//create buffer
			ByteBuffer buffer = ByteBuffer.allocate((int)fileSize);
			//read data with channel
			channel.read(buffer);
			buffer.flip();
			String data = new String(buffer.array(),0,buffer.limit());
			System.out.println(data);
			
		} 
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	private static void BufferWriter(Path of) {
		
		//open
		//operation..
		//close
		try(BufferedWriter writer = Files.newBufferedWriter(of)) {
			writer.write("BufferWriter is the simplest way of writing data to a file");
			writer.write("\nIt supports buffering");
			writer.newLine();
			//writer.close();
			writer.flush();
			writer.write("This is end line");
			System.out.println("Save...");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void WriteString(Path of) throws IOException {
		
		String data = """
				Name: Aung Aung
				Address: Sagaing
				Age: 26
				""";
		Files.writeString(of, data);
		System.out.println("Save.....");
		
	}

	private static void File_Writes(Path path) throws IOException {
		
		List<String> data = List.of("Yangon","Mandalay","Pyin Oo Lwim");
		
		Files.write(path, data);
		
		Files.write(path, "Monywa".getBytes(), StandardOpenOption.APPEND);
		
	}
}
