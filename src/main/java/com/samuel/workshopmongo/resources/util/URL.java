package com.samuel.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
	
	public static String decodeParam(String txt) {
		try {
			return URLDecoder.decode(txt, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	

}
