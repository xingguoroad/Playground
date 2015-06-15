import java.util.Arrays;


public class MinStack {
	private int[] arr = new int[100];
	private int index = -1;
	
	public void push(int x) {
		if (index == arr.length - 1) {
			arr = Arrays.copyOf(arr, arr.length * 2);
		}
		arr[++index] = x;
		System.out.println("***** " + index + " **** " + arr[index]);
	}
	
	public void pop() {
		if (index > -1) {
			if (index == arr.length / 2 && arr.length > 100) {
				arr = Arrays.copyOf(arr, arr.length / 2);
			}
		}
		index--;
	}
	
	public int top() {
		if (index > -1) {
			return arr[index];
		} else {
			return 0;
		}
	}
	
	public int getMin() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= index; ++i) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}

	public static void main(String[] argv) {
		MinStack ms = new MinStack();
		ms.push(-3);
		System.out.println(ms.getMin());
	}

}
