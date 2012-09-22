package jp.sf.amateras.javalib.jsonpullparser;

import java.io.StringWriter;
import java.util.List;

import net.vvakame.util.jsonpullparser.JsonPullParser;
import net.vvakame.util.jsonpullparser.util.JsonArray;
import net.vvakame.util.jsonpullparser.util.JsonHash;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JsonPullParserTest {

	private long startTime;
	private long endTime;

	private StringWriter writer;

	private SampleBeanHolder holder = new SampleBeanHolder(50000);

	@Test
	public void beanToJson() throws Exception {
		System.out.println("==========BeanからJSON文字列へ==============");
		SampleBeanGenerated.encode(writer, holder.getBean());
	}

	@Test
	public void listToJson() throws Exception {
		System.out.println("==========List(JsonArray)からJSON文字列へ==============");
		holder.getJsonArrayList().toJson(writer);
	}

	@Test
	public void mapToJson() throws Exception {
		System.out.println("==========Map(JsonHash)からJSON文字列へ==============");
		holder.getJsonHashMap().toJson(writer);
	}

	@Test
	public void listBeanToJson() throws Exception {
		System.out.println("==========List<SampleBean>からJSON文字列へ==============");
		SampleBeanGenerated.encodeList(writer, holder.getSampleBeanList());
	}

	@Test
	public void mapBeanToJson() throws Exception {
		System.out.println("==========※該当なし※Map<String, SampleBean>からJSON文字列へ==============");
	}

	@Test
	public void jsonToBean() throws Exception {
		System.out.println("==========JSON文字列からBeanへ==============");
		SampleBean bean = SampleBeanGenerated.get(holder.getSampleBeanJsonStr());
	}

	@Test
	public void jsonToList() throws Exception {
		System.out.println("==========JSON文字列からListへ==============");
		JsonPullParser parser = JsonPullParser.newParser(holder.getJsonListString());
		JsonArray jsonArray = JsonArray.fromParser(parser);
	}

	@Test
	public void jsonToMap() throws Exception {
		System.out.println("==========JSON文字列からMapへ==============");
		JsonPullParser parser = JsonPullParser.newParser(holder.getJsonMapString());
		JsonHash jsonHash = JsonHash.fromParser(parser);
	}

	@Test
	public void jsonToListBean() throws Exception {
		System.out.println("==========JSON文字列からList<SampleBean>へ==============");
		List<SampleBean> list = SampleBeanGenerated.getList(holder.getJsonListBeanString());
	}

	@Test
	public void jsonToMapBean() throws Exception {
		System.out.println("==========※該当なし※ JSON文字列からMap<String, SampleBean>へ==============");
	}

	@Before
	public void setup() {
		writer = new StringWriter();
		System.gc();
		startTime = System.currentTimeMillis();
	}

	@After
	public void teardown() {
		endTime = System.currentTimeMillis();
		System.out.println("  " + (endTime - startTime) + " millisecond");
	}

}
