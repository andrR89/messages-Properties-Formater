package com.andre.rules;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/**
 * Enum com os Códigos UTF.
 * 
 * @author andre
 * 
 */
public final class UTFCodes 
{

	public static ByteBuffer toByteBuffer(String content, String encode) {  
	    Charset charset = Charset.forName(encode);  
	    ByteBuffer bb = charset.encode(content);  
	    return bb;  
	}  
	
}
