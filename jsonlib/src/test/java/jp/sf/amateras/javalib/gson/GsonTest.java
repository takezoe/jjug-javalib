package jp.sf.amateras.javalib.gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.xml.internal.bind.api.TypeReference;

public class GsonTest {

	private long startTime;
	private long endTime;

	private SampleBeanHolder holder = new SampleBeanHolder(50000);

	@Test
	public void beanToJson() throws Exception {
		System.out.println("==========BeanからJSON文字列へ==============");
		String json = new Gson().toJson(holder.getBean(), SampleBean.class);
	}

	@Test
	public void listToJson() throws Exception {
		System.out.println("==========List<String>からJSON文字列へ==============");
		String json = new Gson().toJson(holder.getList(), List.class);
	}

	@Test
	public void mapToJson() throws Exception {
		System.out.println("==========Map<String, String>からJSON文字列へ==============");
		String json = new Gson().toJson(holder.getMap(), Map.class);
	}

	@Test
	public void listBeanToJson() throws Exception {
		System.out.println("==========List<SampleBean>からJSON文字列へ==============");
		Type type = new TypeToken<List<SampleBean>>() {}.getType();
		String json = new Gson().toJson(holder.getSampleBeanList(), type);
	}

	@Test
	public void mapBeanToJson() throws Exception {
		System.out.println("==========Map<String, SampleBean>からJSON文字列へ==============");
		Type type = new TypeToken<Map<String, SampleBean>>() {}.getType();
		String json = new Gson().toJson(holder.getSampleBeanMap(), type);
	}

	@Test
	public void jsonToBean() throws Exception {
		System.out.println("==========JSON文字列からBeanへ==============");
		SampleBean bean = new Gson().fromJson(holder.getSampleBeanJsonStr(), SampleBean.class);
	}

	@Test
	public void jsonToList() throws Exception {
		System.out.println("==========JSON文字列からListへ==============");
		List list = new Gson().fromJson(holder.getJsonListString(), ArrayList.class);
	}

	@Test
	public void jsonToMap() throws Exception {
		System.out.println("==========JSON文字列からMapへ==============");
		Map map = new Gson().fromJson(holder.getJsonMapString(), HashMap.class);
	}

	@Test
	public void jsonToListBean() throws Exception {
		System.out.println("==========JSON文字列からList<SampleBean>へ==============");
		Type type = new TypeToken<List<SampleBean>>() {}.getType();
		List<SampleBean> list = new Gson().fromJson(holder.getJsonListBeanString(), type);
	}

	@Test
	public void jsonToMapBean() throws Exception {
		System.out.println("==========JSON文字列からMap<String, SampleBean>へ==============");
		Type type = new TypeToken<Map<String, SampleBean>>() {}.getType();
		Map<String, SampleBean> map = new Gson().fromJson(holder.getJsonMapBeanString(), type);
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
