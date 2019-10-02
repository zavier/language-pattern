package com.zavier.parsing.lexer;

import com.zavier.parsing.recursive.descent.ListParser;
import org.junit.Test;

public class ParsingTest {
    @Test
    public void testLexer() {
        ListLexer lexer = new ListLexer("[ac, b]");
        Token t = lexer.nextToken();
        while (t .type != Lexer.EOF_TYPE) {
            System.out.println(t);
            t = lexer.nextToken();
        }
        System.out.println(t);
    }

    @Test
    public void testParser() {
        ListLexer lexer = new ListLexer("[ac, b]");
        ListParser parser = new ListParser(lexer);
        parser.list();
    }
}
