package jp.sf.amateras.javalib.jsonpullparser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.vvakame.util.jsonpullparser.JsonPullParser.State;
import net.vvakame.util.jsonpullparser.util.JsonArray;
import net.vvakame.util.jsonpullparser.util.JsonHash;

public class SampleBeanHolder {

	private int LOOP_COUNT = 10;

	private String sampleBeanJsonStr = "{\"note1\":\"aaaaaaaaaa\",\"note10\":\"jjjjjjjjjj\",\"note2\":\"bbbbbbbbbb\",\"note3\":\"cccccccccc\",\"note4\":\"dddddddddd\",\"note5\":\"eeeeeeeeee\",\"note6\":\"ffffffffff\",\"note7\":\"gggggggggg\",\"note8\":\"hhhhhhhhhh\",\"note9\":\"iiiiiiiiii\"}";

	private SampleBean bean;

	private JsonArray jsonArraylist;

	private JsonHash jsonHashMap;

	private List<SampleBean> sampleBeanList;

	private Map<String, SampleBean> sampleBeanMap;

	private String jsonListString;

	private String jsonMapString;

	private String jsonListBeanString;

	private String jsonMapBeanString;

	public SampleBeanHolder(int loopCount) {
		LOOP_COUNT = loopCount;
		bean = createBean();
		jsonArraylist = createJsonArrayList();
		jsonHashMap = createJsonHashMap();
		sampleBeanList = createSampleBeanList();
		sampleBeanMap = createSampleBeanMap();

		jsonListString = createJsonListString();
		jsonMapString = createJsonMapString();
		jsonListBeanString = createJsonListBeanString();
		jsonMapBeanString = createJsonMapBeanString();
	}

	private JsonArray createJsonArrayList() {
		JsonArray list = new JsonArray();
		for(int i = 0; i < LOOP_COUNT; i++) {
			list.add(String.format("%06d", i), State.VALUE_STRING);
		}
		return list;
	}

	private JsonHash createJsonHashMap() {
		JsonHash map = new JsonHash();
		for(int i = 0; i < LOOP_COUNT; i++) {
			map.put(String.format("%06d", i),"aaaaaaaaaa", State.VALUE_STRING);
		}
		return map;
	}

	private List<SampleBean> createSampleBeanList() {
		List<SampleBean> list = new ArrayList<SampleBean>();
		for(int i = 0; i < LOOP_COUNT; i++) {
			list.add(createBean());
		}
		return list;
	}

	private Map<String, SampleBean> createSampleBeanMap() {
		Map<String, SampleBean> map = new HashMap<String, SampleBean>();
		for (int i = 0; i < LOOP_COUNT; i++) {
			map.put(String.format("%06d", i) , createBean());
		}
		return map;
	}

	private SampleBean createBean() {
		SampleBean bean = new SampleBean();
		bean.setNote1("aaaaaaaaaa");
		bean.setNote2("bbbbbbbbbb");
		bean.setNote3("cccccccccc");
		bean.setNote4("dddddddddd");
		bean.setNote5("eeeeeeeeee");
		bean.setNote6("ffffffffff");
		bean.setNote7("gggggggggg");
		bean.setNote8("hhhhhhhhhh");
		bean.setNote9("iiiiiiiiii");
		bean.setNote10("jjjjjjjjjj");
		return bean;
	}

	private String createJsonListString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		for (int i = 0; i < LOOP_COUNT; i++) {
			builder.append("\"" + String.format("%06d", i) + "\",");
		}
		builder.setLength(builder.length() - 1);
		builder.append("]");
		return builder.toString();
	}

	private String createJsonMapString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for (int i = 0; i < LOOP_COUNT; i++) {
			builder.append("\"" + String.format("%06d", i) + "\":\"" + "aaaaaaaaaa\",");
		}
		builder.setLength(builder.length() - 1);
		builder.append("}");
		return builder.toString();
	}

	private String createJsonListBeanString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		for (int i = 0; i < LOOP_COUNT; i++) {
			builder.append(sampleBeanJsonStr + ",");
		}
		builder.setLength(builder.length() - 1);
		builder.append("]");
		return builder.toString();
	}

	private String createJsonMapBeanString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for (int i = 0; i < LOOP_COUNT; i++) {
			builder.append("\"" + String.format("%06d", i) + "\":" + sampleBeanJsonStr + ",");
		}
		builder.setLength(builder.length() - 1);
		builder.append("}");
		return builder.toString();
	}

	public String getSampleBeanJsonStr() {
		return sampleBeanJsonStr;
	}

	public SampleBean getBean() {
		return bean;
	}

	public JsonArray getJsonArrayList() {
		return jsonArraylist;
	}

	public JsonHash getJsonHashMap() {
		return jsonHashMap;
	}

	public List<SampleBean> getSampleBeanList() {
		return sampleBeanList;
	}

	public Map<String, SampleBean> getSampleBeanMap() {
		return sampleBeanMap;
	}

	public String getJsonListString() {
		return jsonListString;
	}

	public String getJsonMapString() {
		return jsonMapString;
	}

	public String getJsonListBeanString() {
		return jsonListBeanString;
	}

	public String getJsonMapBeanString() {
		return jsonMapBeanString;
	}

}
