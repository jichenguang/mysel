package lesson16;

import java.util.HashMap;

import org.testng.annotations.Test;


public class testhashMap {

//	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	@Test
		public void test(){
		
		// 创建一个映射对象
			HashMap<Integer, String> maps = new HashMap<Integer, String>();

		// 装入键值对
		for (int i = 0; i < 3; i++) {

			int num = i * 1000;
			String name = "学生" + i;

			// 装入一个键值对
			maps.put(num, name);

		}
		
		//增加一个键值对，加入K相同的键值对，则会替换已经存在的键值对
		maps.put(30000, "新学生");
		maps.put(40000, "新学生");		
		maps.put(40000, "又来一个");
		
		
		//遍历
		//得到K的Set集合
		java.util.Set<Integer> set = maps.keySet();
		//遍历K的集合，得到set的迭代器
		java.util.Iterator<Integer> iter = set.iterator();
		while(iter.hasNext()){
			//取出一个key
			int num = iter.next();
			System.out.println(num);
			//根据key得到对应的Value
			String name = maps.get(num);
			
			System.out.println(num+"\t"+name);
		}

	}

}
