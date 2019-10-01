package com.zavier.parsing.lexer;

import org.junit.Test;

public class ParsingTest {
    @Test
    public void test() {
        ListLexer lexer = new ListLexer("[ac, b]");
        Token t = lexer.nextToken();
        while (t .type != Lexer.EOF_TYPE) {
            System.out.println(t);
            t = lexer.nextToken();
        }
        System.out.println(t);
    }
}
