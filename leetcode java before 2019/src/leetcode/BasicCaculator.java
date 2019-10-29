package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class BasicCaculator {
    /**
     * BasicCaculator 2
     * @param s
     * @return
     */
    public static int calculate2(String s) {
        String input = s.replaceAll(" ", "");
        Deque<Character> operator = new LinkedList<>();
        Deque<Integer> operand = new LinkedList<>();
        int left = 0, right = 0;
        while (left < input.length()) {
            if (Character.isDigit(input.charAt(left))) {
                if (left == input.length() - 1) {
                    operand.add(Integer.parseInt(input.substring(left)));
                    right = left;
                } else {
                    right = left + 1;
                    while (Character.isDigit(input.charAt(right)) && right != input.length() - 1) {
                        right++;
                    }
                    if (!Character.isDigit(input.charAt(right))) {
                        right--;
                    }
                    operand.addLast(Integer.parseInt(input.substring(left, right + 1)));
                    left = right;
                }
                if (!operator.isEmpty() && (operator.peekLast() == '*' || operator.peekLast() == '/')) {
                    Character op = operator.pollLast();
                    int rightOp = operand.pollLast();
                    int leftOp = operand.pollLast();
                    if (op == '*') {
                        operand.addLast(rightOp * leftOp);
                    } else {
                        operand.addLast(leftOp / rightOp);
                    }
                }
            } else {
                operator.addLast(input.charAt(left));
            }
            left++;
        }
        return helperSum(operator, operand);
    }

    public static int calculate(String s) {
        String input = s.replaceAll(" ", "");
        Deque<Character> operator = new LinkedList<>();
        Deque<Integer> operand = new LinkedList<>();
        int left = 0, right = 0;
        while (left < input.length()) {
            if (Character.isDigit(input.charAt(left))) {
                if (left == input.length() - 1) {
                    operand.add(Integer.parseInt(input.substring(left)));
                    right = left;
                } else {
                    right = left + 1;
                    while (Character.isDigit(input.charAt(right)) && right != input.length() - 1) {
                        right++;
                    }
                    if (!Character.isDigit(input.charAt(right))) {
                        right--;
                    }
                    operand.addLast(Integer.parseInt(input.substring(left, right + 1)));
                    left = right;
                }
            } else {
                if (input.charAt(left) == ')') {
                    Character temp = operator.pollLast();
                    if (temp == '(') {
                        left++;
                        continue;
                    }
                    Stack<Integer> operandT = new Stack<>();
                    Stack<Character> operatorT = new Stack<>();
                    while (temp != '(') {
                        operandT.push(operand.pollLast());
                        operatorT.push(temp);
                        temp = operator.pollLast();
                    }
                    operandT.push(operand.pollLast());
                    while (!operatorT.isEmpty()) {
                        int rightOp = operandT.pop();
                        int leftOp = operandT.pop();
                        temp = operatorT.pop();
                        if (temp == '+') {
                            operandT.push(rightOp + leftOp);
                        } else {
                            operandT.push(rightOp - leftOp);
                        }
                    }
                    operand.addLast(operandT.pop());
                } else {
                    operator.addLast(input.charAt(left));
                }
            }
            left++;
        }
        return helperSum(operator, operand);
    }

    public static int helperSum(Deque<Character> operator, Deque<Integer> operand) {
        while (!operator.isEmpty()) {
            Character temp = operator.pollFirst();

            int leftOp = operand.pollFirst();
            int rightOp = operand.pollFirst();
            if (temp == '+') {
                operand.addFirst(rightOp + leftOp);
            } else {
                operand.addFirst(leftOp - rightOp);
            }

        }
        return operand.pop();
    }

    public static void main(String[] args) {
        // System.out.println(BasicCaculator.calculate("1 + 1"));
        // System.out.println(BasicCaculator.calculate(" 2-1 + 2 "));
        // System.out.println(BasicCaculator.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(BasicCaculator.calculate("2-4-(8+2-6+(8+4-(1)+8-10))"));
        System.out.println(BasicCaculator.calculate2(" 3+5 / 2 "));
    }

}
