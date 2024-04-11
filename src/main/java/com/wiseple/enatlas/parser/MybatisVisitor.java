package com.wiseple.enatlas.parser;

import mybatisParser.XMLParser;
import org.apache.commons.lang3.StringUtils;

public class MybatisVisitor extends mybatisParser.XMLParserBaseVisitor{
//    @Override
//    public Object visitDocument(mybatisParser.XMLParser.DocumentContext ctx) {
////        System.out.println("visitDocument---------------");
//        return super.visitDocument(ctx);
//    }
//
//    @Override
//    public Object visitProlog(mybatisParser.XMLParser.PrologContext ctx) {
//        System.out.println("visitProlog---------------" + ctx.getPayload().getText());
//        return super.visitProlog(ctx);
//    }
//
//    @Override
//    public Object visitContent(mybatisParser.XMLParser.ContentContext ctx) {
////        System.out.println("visitContent---------------" + ctx.getText());
//        return super.visitContent(ctx);
//    }

    @Override
    public Object visitElement(mybatisParser.XMLParser.ElementContext ctx) {

//        System.out.println("element name: " + ctx.getStart().getText());
//        System.out.println("element : depth : " + ctx.depth());
        if(StringUtils.equals( ctx.getChild(1).getText(), "mapper" ) && ctx.depth() == 2){
            System.out.println("visitElement---------------------------------------------------------------------------------");
            String namespace = getAttributeValueByKey(ctx, "namespace");
            System.out.println("namespace : " + namespace);
        }



        if(  ctx.depth() == 4){
            System.out.println("visitElement---------------------------------------------------------------------------------");
            switch( getNodeName(ctx) ){
            case "select":
                String sqlMapId= getAttributeValueByKey(ctx, "id");
                System.out.println("select ID : " + sqlMapId);
                String selectSql = getContent (  ctx );
                System.out.println("select SQL : " + selectSql);
                break;

            case "insert":
                sqlMapId= getAttributeValueByKey(ctx, "id");
                System.out.println("insert ID : " + sqlMapId);
                String sql = getContent (  ctx );
                System.out.println("insert SQL : " + sql);
                break;

            case "update":
                sqlMapId= getAttributeValueByKey(ctx, "id");
                System.out.println("update ID : " + sqlMapId);
                sql = getContent (  ctx );
                System.out.println("update SQL : " + sql);
                break;

            case "delete":
                sqlMapId= getAttributeValueByKey(ctx, "id");
                System.out.println("delete ID : " + sqlMapId);
                sql = getContent (  ctx );
                System.out.println("delete SQL : " + sql);
                break;
        }



        }
        return super.visitElement(ctx);
    }

    private String getAttributeValueByKey(mybatisParser.XMLParser.ElementContext ctx, String key){
        for ( int i = 0; i < ctx.getChildCount(); i++ ){
            if( ctx.getChild(i) instanceof mybatisParser.XMLParser.AttributeContext &&
            StringUtils.equals( ctx.getChild(i).getChild(0).getText(), key )){
                return ctx.getChild(i).getChild(2).getText().replace("\"", "");
            }
        }
        return null;
    }

    private String getNodeName(mybatisParser.XMLParser.ElementContext ctx){
        return ctx.getChild(1).getText();
    }

    private String getContent(mybatisParser.XMLParser.ElementContext ctx){
        return ctx.getChild( XMLParser.ContentContext.class , 0 ).getText();
    }

//    @Override
//    public Object visitReference(mybatisParser.XMLParser.ReferenceContext ctx) {
//        System.out.println("visitReference---------------");
//        return super.visitReference(ctx);
//    }
//
//    @Override
//    public Object visitAttribute(mybatisParser.XMLParser.AttributeContext ctx) {
//        System.out.println("visitAttribute---------------");
//        return super.visitAttribute(ctx);
//    }
//
    @Override
    public Object visitChardata(mybatisParser.XMLParser.ChardataContext ctx) {
        System.out.println("visitChardata---------------" + ctx.getText());
        return super.visitChardata(ctx);
    }
//
//    @Override
//    public Object visitMisc(mybatisParser.XMLParser.MiscContext ctx) {
//        System.out.println("visitMisc---------------");
//        return super.visitMisc(ctx);
//    }


    @Override
    public Object visitParameter(XMLParser.ParameterContext ctx) {
        System.out.println("visitParameter---------------" + ctx.getText());
        return super.visitParameter(ctx);
    }
}
