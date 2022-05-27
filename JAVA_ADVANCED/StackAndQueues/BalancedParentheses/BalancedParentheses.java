package implementations;

import interfaces.Solvable;

import java.util.Stack;

public class BalancedParentheses implements Solvable {
    private static final char L_PAREN    = '(';
    private static final char R_PAREN    = ')';
    private static final char L_BRACE    = '{';
    private static final char R_BRACE    = '}';
    private static final char L_BRACKET  = '[';
    private static final char R_BRACKET  = ']';
    private String parentheses;

    public BalancedParentheses(String parentheses) {
        this.parentheses = parentheses;
    }

    public Boolean solve() {
        Stack<Character> stack = new Stack<> ();
        char[] chars = parentheses.toCharArray ();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == L_PAREN){
                stack.push (L_PAREN);
            }else if (chars[i] == L_BRACE){
                stack.push (L_BRACE);
            }else if (chars[i] == L_BRACKET){
                stack.push (L_BRACKET);
            }else if (chars[i] == R_PAREN){
                if (stack.pop ()!=L_PAREN) return false;
            }else if (chars[i] == R_BRACE){
                if (stack.pop ()!=L_BRACE) return false;
            }else if (chars[i] == R_BRACKET){
                if (stack.pop ()!=L_BRACKET) return false;
            }
        }

        return stack.isEmpty ();
    }
}
