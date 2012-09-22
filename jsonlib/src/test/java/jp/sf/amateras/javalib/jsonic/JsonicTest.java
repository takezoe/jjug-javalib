package jp.sf.amateras.javalib.jsonic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.arnx.jsonic.JSON;
import net.arnx.jsonic.TypeReference;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JsonicTest {

	private long startTime;
	private long endTime;

	private SampleBeanHolder holder = new SampleBeanHolder(50000);

	@Test
	public void beanToJson() throws Exception {
		System.out.println("==========BeanからJSON文字列へ==============");
		JSON.encode(holder.getBean());
	}

	@Test
	public void listToJson(){
		System.out.println("==========List<String>からJSON文字列へ==============");
		JSON.encode(holder.getList());
	}

	@Test
	public void mapToJson(){
		System.out.println("==========Map<String, String>からJSON文字列へ==============");
		JSON.encode(holder.getMap());
	}

	@Test
	public void listBeanToJson() throws Exception {
		System.out.println("==========List<SampleBean>からJSON文字列へ==============");
		JSON.encode(holder.getSampleBeanList());
	}

	@Test
	public void mapBeanToJson() throws Exception {
		System.out.println("==========Map<String, SampleBean>からJSON文字列へ==============");
		JSON.encode(holder.getSampleBeanMap());
	}

	@Test
	public void jsonToBean() throws Exception {
		System.out.println("==========JSON文字列からBeanへ==============");
		SampleBean bean = JSON.decode(holder.getSampleBeanJsonStr(), SampleBean.class);
	}

	@Test
	public void jsonToList() {
		System.out.println("==========JSON文字列からListへ==============");
		List list = JSON.decode(holder.getJsonListString(), ArrayList.class);
	}

	@Test
	public void jsonToMap() {
		System.out.println("==========JSON文字列からMapへ==============");
		Map map = JSON.decode(holder.getJsonMapString(), HashMap.class);
	}


	@Test
	public void jsonToListBean() throws Exception {
		System.out.println("==========JSON文字列からList<SampleBean>へ==============");
		List<SampleBean> list = JSON.decode(holder.getJsonListBeanString(), new TypeReference<List<SampleBean>>(){});
	}

	@Test
	public void jsonToMapBean() throws Exception {
		System.out.println("==========JSON文字列からMap<String, SampleBean>へ==============");
		Map<String, SampleBean> map = JSON.decode(holder.getJsonMapBeanString(), new TypeReference<Map<String, SampleBean>>(){});
	}

	@Before
	public void setup() {
		System.gc();
		startTime = System.currentTimeMillis();
	}

	@After
	public void teardown() {
		endTime = System.currentTimeMillis();
		System.out.println("  " + (endTime - startTime) + " millisecond");
	}

}
