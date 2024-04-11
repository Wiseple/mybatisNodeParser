package com.wiseple.enatlas.parser;

import mybatisParser.XMLLexer;
import mybatisParser.XMLParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import static org.antlr.v4.runtime.CharStreams.fromFileName;

public class MybatisNodeParserTestApp {
    public static void main(String[] args) {
        System.out.println("Hello, MybatisNodeParserTestApp!");
        try {
            CharStream cs = fromFileName("src/main/resources/xml/sqlmap.xml");

            XMLLexer lexer = new XMLLexer(cs);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            XMLParser parser = new XMLParser(tokens);
            ParseTree tree = parser.document();
            MybatisVisitor visitor = new MybatisVisitor();
            visitor.visit(tree);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
