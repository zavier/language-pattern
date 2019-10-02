package com.zavier.parsing.multi;

import com.zavier.parsing.lexer.Lexer;

public class LookaheadParser extends Parser {

    public LookaheadParser(Lexer input, int k) {
        super(input, k);
    }

    /**
     * element: NAME '=' NAME | NAME | list; assignment, NAME or list
     */
    void element() {
        if (LA(1) == LookaheadLexer.NAME && LA(2) == LookaheadLexer.EQUALS) {
            match(LookaheadLexer.NAME);
            match(LookaheadLexer.EQUALS);
            match(LookaheadLexer.NAME);
        } else if (LA(1) == LookaheadLexer.NAME) {
            match(LookaheadLexer.NAME);
        } else if (LA(1) == LookaheadLexer.LBRACK) {
            list();
        } else {
            throw new Error("expecting name or list; found " + LT(1));
        }
    }

    /**
     * list: '[] elements ']'; 匹配方括号
     */
    public void list() {
        match(LookaheadLexer.LBRACK);
        elements();
        match(LookaheadLexer.RBRACK);
    }

    /**
     * elements: element (',' element)
     */
    void elements() {
        // 查找元素
        element();
        // 查找逗号
        while (LA(1) == LookaheadLexer.COMMA) {
            match(LookaheadLexer.COMMA);
            element();
        }
    }
}
