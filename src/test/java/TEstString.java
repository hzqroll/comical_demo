import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

/**
 * User: roll
 * Date: 2017/3/5
 * Time: 下午1:17
 *
 * @author zongqiang.hao
 */
public class TEstString {
	public static void main(String args[]){
		List<String> a= new ArrayList<String>();
		a.add("1");
		a.add("2");
		System.out.println(StringUtils.collectionToDelimitedString(a,""));

		String b = "1,2,3,4,5,6";
		System.out.println(StringUtils.commaDelimitedListToSet(b));
	}
}
