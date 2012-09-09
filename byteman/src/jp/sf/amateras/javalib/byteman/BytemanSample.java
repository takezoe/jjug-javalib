package jp.sf.amateras.javalib.byteman;

public class BytemanSample {
	
	public String hello(String name){
		return String.format("Hello %s!", name);
	}
	
	public static void main(String[] args) {
      BytemanSample sample = new BytemanSample();
      System.out.println(sample.hello("Byteman"));
	}
}
