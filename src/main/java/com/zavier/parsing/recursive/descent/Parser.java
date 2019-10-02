package com.zavier.parsing.recursive.descent;

import com.zavier.parsing.lexer.Lexer;
import com.zavier.parsing.lexer.Token;

/**
 * 解析起
 * @author zhengwei
 */
public class Parser {

    /**
     * 输入的词法单元
     */
    Lexer input;

    /**
     * 当前的向前看符号
     */
    Token lookahead;

    public Parser(Lexer input) {
        this.input = input;
        lookahead = input.nextToken();
    }

    public void match(int x) {
        if (lookahead.type == x) {
            consume();
        } else {
            throw new Error("expecting " + input.getTokenName(x) + "; found " + lookahead);
        }
    }

    public void consume() {
        lookahead = input.nextToken();
    }
}
