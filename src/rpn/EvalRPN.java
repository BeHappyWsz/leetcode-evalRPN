package rpn;
import java.util.Stack;

/**
 * 逆波兰式求解
 * @author wsz
 * @date 2018年4月12日
 */
public class EvalRPN {
	
	public static void main(String[] args) {
		String[] a = {"2", "1", "+", "3", "*"};
		System.out.println(evalRPN(a));
		
		String[] b = {"4", "13", "5", "/", "+"};
		System.out.println(evalRPN(b));
	}
	
	/**
	  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  	  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
	 * @param tokens
	 * @return
	 */
	public static int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (String str : tokens) {
			int a,b;
			if("+".equals(str)) {
				a = stack.pop();
				b = stack.pop();
				stack.add(a+b);
			}else if("-".equals(str)) {
				a = stack.pop();
				b = stack.pop();
				stack.add(b-a);
			}else if("*".equals(str)) {
				a = stack.pop();
				b = stack.pop();
				stack.add(a*b);
			}else if("/".equals(str)){
				a = stack.pop();
				b = stack.pop();
				stack.add(b/a);
			}else {
				stack.push(Integer.valueOf(str));
			}
		}
		return stack.pop();
	}
}
