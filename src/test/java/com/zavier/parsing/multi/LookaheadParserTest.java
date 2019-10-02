package com.zavier.parsing.multi;

import com.zavier.parsing.lexer.ListLexer;
import org.junit.Test;

import static org.junit.Assert.*;

public class LookaheadParserTest {

    @Test
    public void test() {
        LookaheadLexer lexer = new LookaheadLexer("[a,b = c,[d,e]]");
        LookaheadParser parser = new LookaheadParser(lexer, 2);
        parser.list();
    }
}