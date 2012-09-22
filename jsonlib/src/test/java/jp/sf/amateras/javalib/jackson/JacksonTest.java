package jp.sf.amateras.javalib.jackson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {

	private long startTime;
	private long endTime;

	private SampleBeanHolder holder = new SampleBeanHolder(50000);

	@Test
	public void beanToJson() throws Exception {
		System.out.println("==========BeanからJSON文字列へ==============");
		String json = new ObjectMapper().writeValueAsString(holder.getBean());
	}

	@Test
	public void listToJson() throws Exception {
		System.out.println("==========List<String>からJSON文字列へ==============");
		String json = new ObjectMapper().writeValueAsString(holder.getList());
	}

	@Test
	public void mapToJson() throws Exception {
		System.out.println("==========Map<String, String>からJSON文字列へ==============");
		String json = new ObjectMapper().writeValueAsString(holder.getMap());
	}

	@Test
	public void listBeanToJson() throws Exception {
		System.out.println("==========List<SampleBean>からJSON文字列へ==============");
		String json = new ObjectMapper().writeValueAsString(holder.getSampleBeanList());
	}

	@Test
	public void mapBeanToJson() throws Exception {
		System.out.println("==========Map<String, SampleBean>からJSON文字列へ==============");
		String json = new ObjectMapper().writeValueAsString(holder.getSampleBeanMap());
	}

	@Test
	public void jsonToBean() throws Exception {
		System.out.println("==========JSON文字列からBeanへ==============");
		SampleBean bean = new ObjectMapper().readValue(holder.getSampleBeanJsonStr(), SampleBean.class);
	}

	@Test
	public void jsonToList() throws Exception {
		System.out.println("==========JSON文字列からListへ==============");
		List list = new ObjectMapper().readValue(holder.getJsonListString(), ArrayList.class);
	}

	@Test
	public void jsonToMap() throws Exception {
		System.out.println("==========JSON文字列からMapへ==============");
		Map map = new ObjectMapper().readValue(holder.getJsonMapString(), HashMap.class);
	}

	@Test
	public void jsonToListBean() throws Exception {
		System.out.println("==========JSON文字列からList<SampleBean>へ==============");
		List<SampleBean> list = new ObjectMapper().readValue(holder.getJsonListBeanString(), new TypeReference<List<SampleBean>>() {});
	}

	@Test
	public void jsonToMapBean() throws Exception {
		System.out.println("==========JSON文字列からMap<String, SampleBean>へ==============");
		Map<String, SampleBean> map = new ObjectMapper().readValue(holder.getJsonMapBeanString(), new TypeReference<Map<String, SampleBean>>() {});
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
