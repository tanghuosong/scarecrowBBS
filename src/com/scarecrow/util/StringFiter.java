package com.scarecrow.util;

public class StringFiter {
	static public String encodeFiter(String str)
    {
        str = str.replace("&", "&amp;");
        str = str.replace("<", "&lt;");
        str = str.replace(">", "&gt;");
        str = str.replace("'", "''");
        str = str.replace("*", "x");
        str = str.replace("\n", "<br/>");
        str = str.replace("\r\n", "<br/>");
        //str = str.Replace("?","");
        str = str.replace("select", "select/");
        str = str.replace("insert", "insert/");
        str = str.replace("update", "update/");
        str = str.replace("delete", "delete/");
        str = str.replace("create", "create/");
        str = str.replace("drop", "drop/");
        str = str.replace("delcare", "delcare/");
        if (str.trim().toString() == "") { str = "无"; }
        return str.trim();
    }
}
