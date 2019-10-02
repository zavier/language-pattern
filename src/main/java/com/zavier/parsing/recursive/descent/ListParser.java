package com.zavier.parsing.recursive.descent;

import com.zavier.parsing.lexer.Lexer;
import com.zavier.parsing.lexer.ListLexer;

/**
 * list元素的解析器
 * @author zhengwei
 */
public class ListParser extends Parser {
    public ListParser(Lexer input) {
        super(input);
    }

    /**
     * list: '[] elements ']'; 匹配方括号
     */
    public void list() {
        match(ListLexer.LBRACK);
        elements();
        match(ListLexer.RBRACK);
    }

    /**
     * elements: element (',' element)
     */
    void elements() {
        // 查找元素
        element();
        // 查找逗号
        while (lookahead.type == ListLexer.COMMA) {
            match(ListLexer.COMMA);
            element();
        }
    }

    /**
     * element: name | list  // 一个element要么是NAME, 要么是嵌套的列表
     */
    void element() {
        if (lookahead.type == ListLexer.NAME) {
            match(ListLexer.NAME);
        } else if (lookahead.type == ListLexer.LBRACK) {
            list();
        } else {
            throw new Error("expecting name or list; found " + lookahead);
        }
    }
}
