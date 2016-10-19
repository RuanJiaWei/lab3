package lab1;
import java.util.*;
import java.util.regex.Pattern;
/**
 * Class constructor.
 */
public class Polynomial {
	/**
	    * 定义数字43 
	    */
	public static final int NUMBER43 = 43;
	/**
	    * 定义数字1
	    */
	public static final int NUMBER1 = 1;
	/**
	    * 定义数字42
	    */
	public static final int NUMBER42 = 42;
	/**
	    * 定义数字4
	    */
	public static final int NUMBER4 = 4;
	/**
	    * 定义数字48
	    */
	public static final int NUMBER48 = 48;
	/**
	    * 定义数字57
	    */
	public static final int NUMBER57 = 57;
	/**
	    * 定义数字97
	    */
	public static final int NUMBER97 = 97;
	/**
	    * 定义数字122
	    */
	public static final int NUMBER122 = 122;
	/**
	    * Class constructor.
	    * @return      the image at the specified URL
	    * @param s lalala
	    */
	/**
     * 判断表达式合法性,采用正则表达式
     * @param expression 输入的表达式
     * @return 是否合法 0表示合法 非0表示非法
     */
	private static int expression(final String string0) { //判断字符串是否合法 string0是输入的字符串
		int num = 0;//num
		for (int i = 0; i < string0.length(); i++) { //42:*  43:+  48:0 57:9 97:a 122:z
			//判断条件是 当string里面的字符<'*' 或 >'+'且<'0' 或 >'9'且<'a' 或>'z'
			//如果在这个范围内的话 num则+1 计数
			//System.out.println("1------:"+string0.charAt(i)+"/tnum="+num);
			if (string0.charAt(i) < NUMBER42 
					|| string0.charAt(i) > NUMBER43
					&& string0.charAt(i) < NUMBER48
					|| string0.charAt(i) > NUMBER57
					&& string0.charAt(i) < NUMBER97
					|| string0.charAt(i) > NUMBER122) {
				num++;
				//num在这里已经不是0了，所以可以判断已经不是正确的表达式了，所以在这里可以直接返回函数值
			} else {//PS 这边的话如果进去分割一次后，之后都是重复工作了，所以可以先扫一遍判断没有其他奇怪的非法字符后在进行分割
				//如果有一个条件不符的话 那么就创建一个新的字符串数组，用来存放string0字符串按'+'分割的结果
				final String[] newstr = string0.split("\\+");
				String[] splitnewstr;
				for (int x = 0; x < newstr.length; x++) {
					//循环刚才分割得到的字符串数组的大小 次数 ；对每个小项 按照'*'分割
					splitnewstr = newstr[x].split("\\*");
					for (int j = 0; j < splitnewstr.length; j++) {
						//如果每个最小项的长度大于1且第一个字符是在 'a' 到 'z'的范围，那么num++
						if (splitnewstr[j].length() > NUMBER1
								&& splitnewstr[j].charAt(0) >= NUMBER97
								&& splitnewstr[j].charAt(0) <= NUMBER122) {
							//num在这里已经不是0了，所以可以判断已经不是正确的表达式了，所以在这里可以直接返回函数值
							num++;
						}
					}
				}
			}
		}
		return num;
	}
	//修正之后的函数
//	private static int expression(final String string0) { //判断字符串是否合法 string0是输入的字符串
//		int num = 0;//num
//		for (int i = 0; i < string0.length(); i++) { //42:*  43:+  48:0 57:9 97:a 122:z
//			//判断条件是 当string里面的字符<'*' 或 >'+'且<'0' 或 >'9'且<'a' 或>'z'
//			//如果在这个范围内的话 num则+1 计数
//			if (string0.charAt(i) < NUMBER42 
//					|| string0.charAt(i) > NUMBER43
//					&& string0.charAt(i) < NUMBER48
//					|| string0.charAt(i) > NUMBER57
//					&& string0.charAt(i) < NUMBER97
//					|| string0.charAt(i) > NUMBER122) {
//				num++;
//				return num;
//			} //PS 这边的话如果进去分割一次后，之后都是重复工作了，所以可以先扫一遍判断没有其他奇怪的非法字符后在进行分割
//		}
//		//如果有一个条件不符的话 那么就创建一个新的字符串数组，用来存放string0字符串按'+'分割的结果
//		final String[] newstr = string0.split("\\+");
//		String[] splitnewstr;
//		for (int x = 0; x < newstr.length; x++) {
//			//循环刚才分割得到的字符串数组的大小 次数 ；对每个小项 按照'*'分割
//			splitnewstr = newstr[x].split("\\*");
//			for (int j = 0; j < splitnewstr.length; j++) {
//				//如果每个最小项的长度大于1且第一个字符是在 'a' 到 'z'的范围，那么num++
//				if (splitnewstr[j].length() > NUMBER1
//						&& splitnewstr[j].charAt(0) >= NUMBER97
//						&& splitnewstr[j].charAt(0) <= NUMBER122) {
//					num++;
//					return num;
//				}
//			}
//		}
//		return num;
//	}
	/**
	    * 本函数实现的功能是判断第二次输入的字符串命令是否与!simplify 匹配，实现第二个功能，变量赋值
	    * @param string0 表示第一次输入的字符串 代表表达式
	    * @param string1 表示第二次输入的命令 !simplify 
	    */
	private static void simplify(final String string0, final String string1) {
		if ("!simplify".equals(string1)) {//如果输入的字符串与!simplify，则输出string0
			System.out.println(string0);
		} else {
			final String[] str1 = string1.split(" ");
			String string2 = string0;
			for (int i = 1; i < str1.length; i++) {
			    string2 = string2.replace(str1[i].split("=")[0]
			    		, str1[i].split("=")[1]);
			}
			System.out.println(string2);
		}
	}
	/**
	    * 本函数实现的工能是判断第三次输入的字符串命令是否与!d/dx匹配，实现第三个功能，变量求导
	    * @param string0 表示第一次输入的字符串 代表表达式
	    * @param string2 表示第三次输入的命令 !d/dx
	    */
	private static void derivative(final String string0, final String string2) {
		String[] str1 = string0.split("\\+");
		String yousb = "";
		for (int i = 0; i < str1.length; i++) {
			int num = 0;
			for (int j = 0; j < str1[i].length(); j++) {
				if (str1[i].charAt(j) == string2.charAt(NUMBER4)) {
					num++;
				}
			}
				if (num == 0) {
					yousb = yousb + "";
				} else if (num == NUMBER1) {
					if (str1[i].length() == NUMBER1) {
						yousb = yousb + "+1";
					} else {
						if (str1[i].charAt(0) == string2.charAt(NUMBER4)) {
							str1[i] = str1[i].replace((string2.charAt(NUMBER4) + ("*")), "");
						} else {
					        str1[i] = str1[i].replace(("*") + string2.charAt(NUMBER4), "");
						}
						yousb = yousb + "+" + str1[i];
					}
				} else {
					str1[i] = str1[i].replaceFirst(("" + string2.charAt(NUMBER4)),
							String.valueOf(num));
					yousb = yousb + "+" + str1[i];
				}
		}
		System.out.println(yousb.substring(1, yousb.length()));
	}
	/**
	    * Class constructor.
	    * 完成的功能只有基本功能：
	    * 	1-满足多项式的基本规则
	    * 	2-不含任何非数字，非字母，非+和*的符号（如括号、小数点、减号等
	    * 	3-多小时中的变量用单字母表示
	    * 	4-如果不满足上述条件，则展示错误信息
	    * 
	    * 
	    * 且本程序 能实现的功能为： 
	    * 	1-输入一个表达式
	    * 	2-无论表达式是否正确，都进入下一次输入，且该输入只能为!simplify x=? 
	    * 		如果不是!simplify 也不会报错，输出结果就是随机的结果，跟输入有关，一班就是string0
	    * 	3-
	    * @param args lalla
	    */
	public static void main(final String[] args) {
		final Scanner xscanner = new Scanner(System.in);
		final String string0 = xscanner.nextLine();
		if (expression(string0) == 0) {//如果string0经过字符串判断后得到的返回值=0 那么就输出string0，即认为是正确的表达式
			System.out.println(string0);
		} else {//否则的话则是错误的表达式
			System.out.println("Error!");
		}
		final String string1 = xscanner.nextLine();//输入
		simplify(string0, string1);
		final String string2 = xscanner.nextLine();
		derivative(string0, string2);
		xscanner.close();
	}
}
