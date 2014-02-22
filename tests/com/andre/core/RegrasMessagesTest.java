package com.andre.core;

import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

public class RegrasMessagesTest {

	@Test
	public void testarProprert() {
		String re = "([\\s-]*)(([\\w-\\.]*)[.-]?([\\s-]*=)([*\\d*\\D]*))+$";
		//String re = "^[\\s-]*(([\\w-\\.]*)[.-]?[\\s-]*=([*\\d*\\D]*))+$";
		String str = "po.sida_sopdiaop = asjald%$&923JFKjalj";

		Pattern p = Pattern.compile(re);
		Assert.assertTrue(p.matcher("   dsdsdjkl    = ljsajsda").matches());
		Assert.assertTrue(p.matcher("ssdasd=sdad").matches());
		Assert.assertFalse(p.matcher(",.__00sadjdajl = jkdjkasj").matches());
		Assert.assertTrue(p.matcher(str).matches());
		Assert.assertTrue(p.matcher("  s=x").matches());

		p.split("=");
		Assert.assertTrue(str.split("=").length == 2);

	}

}
