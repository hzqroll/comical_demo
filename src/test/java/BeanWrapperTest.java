import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.PropertyValue;

/**
 * User: roll
 * Date: 2017/3/5
 * Time: 下午1:50
 *
 * @author zongqiang.hao
 */
public class BeanWrapperTest {
	public static void main(String args[]){
		User user = new User();
		BeanWrapper bw = PropertyAccessorFactory.forBeanPropertyAccess(user);
		bw.setPropertyValue("userName","jhon");
		System.out.println(user.getUserName());
		PropertyValue value = new PropertyValue("userName","alle");
		bw.setPropertyValue(value);
		System.out.println(user.getUserName());
	}
}
