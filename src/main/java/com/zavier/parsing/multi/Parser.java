package com.zavier.parsing.multi;

import com.zavier.parsing.lexer.Lexer;
import com.zavier.parsing.lexer.Token;

public class Parser {

    /**
     * 待处理词法单元的来源
     */
    Lexer input;

    /**
     * 环形缓冲区
     */
    Token[] lookahead;

    /**
     * 向前看符号的个数(缓冲区大小)
     */
    int k;

    /**
     * 环形缓冲区中装填下一个词法单元的位置
     */
    int p = 0;

    public Parser(Lexer input, int k) {
        this.input = input;
        this.k = k;
        // 初始化缓冲区大小
        lookahead = new Token[k];
        for (int i = 0; i < k; i++) {
            consume();
        }
    }

    public void consume() {
        // 填充下一个
        lookahead[p] = input.nextToken();
        p = (p + 1) % k;
    }

    /**
     * 向前看i个对应的词法单元
     * @param i
     * @return
     */
    public Token LT(int i) {
        return lookahead[(p + i - 1) % k];
    }

    /**
     * 向前看i个词法单元的类型
     * @param i
     * @return
     */
    public int LA(int i) {
        return LT(i).type;
    }

    public void match(int x) {
        if (LA(1) == x) {
            consume();
        } else {
            throw new Error("expecting " + input.getTokenName(x) + "; found " + LT(1));
        }
    }
}
