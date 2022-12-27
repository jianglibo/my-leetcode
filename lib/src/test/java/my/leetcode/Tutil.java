package my.leetcode;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.json.JSONArray;
import org.json.JSONObject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Tutil {

	public static JSONObject loadJsonFromClassPath(String fn) {
		try (InputStream in = Tutil.class.getResourceAsStream(fn)) {
			String text = new String(in.readAllBytes(), StandardCharsets.UTF_8);
			return new JSONObject(text);
		} catch (Exception e) {
			log.error("load json from class path failed.", e);
			return null;
		}
	}

	public static int[] toIntAry(JSONArray ja) {
		int[] ii = new int[ja.length()];
		for (int i = 0; i < ii.length; i++) {
			ii[i] = ja.getInt(i);
		}
		return ii;
	}

	public static int[] getIntAry(JSONObject jo, String key) {
		return toIntAry(jo.getJSONArray(key));
	}
}
