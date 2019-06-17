package com.acme.example.custom.message.constant;

import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

import com.acme.architecture.testing.util.JUnitTestBuilder;
import com.acme.example.custom.message.core.constant.GeneralCustomMessageConfigConstant;

public class GeneralCommonTemplateConfigConstantTest {

	@Test
	public void checkWellFormattedClass() throws NoSuchMethodException, InvocationTargetException,
			InstantiationException, IllegalAccessException {
		JUnitTestBuilder.assertUtilityClassWellDefined(GeneralCustomMessageConfigConstant.class);
	}

}
