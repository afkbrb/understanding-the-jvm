package c02;

import java.util.List;
import java.util.ArrayList;

/**
 * 
 * 注意：jdk8中PermSize和MaxPerm已经被移除
 * 
 * VM Args：-XX:PermSize=10M -XX:MaxPermSize=10M
 * 
 * @author zzm
 */
public class RuntimeConstantPoolOOM {

	public static void main(String[] args) {
		// 使用List保持着常量池引用，避免Full GC回收常量池行为
		List<String> list = new ArrayList<>();
		// 10MB的PermSize在integer范围内足够产生OOM了
		int i = 0; 
		while (true) {
			list.add(String.valueOf(i++).intern());
		}
	}
}
