/*
 * $Header: /home/jerenkrantz/tmp/commons/commons-convert/cvs/home/cvs/jakarta-commons//beanutils/src/test/org/apache/commons/beanutils/Attic/BeanPropertyValueChangeClosureTest.java,v 1.3 2003/10/09 20:40:07 rdonkin Exp $
 * $Revision: 1.3 $
 * $Date: 2003/10/09 20:40:07 $
 *
 * ====================================================================
 * 
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2001-2003 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer. 
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution,
 *    if any, must include the following acknowledgement:  
 *       "This product includes software developed by the 
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowledgement may appear in the software itself,
 *    if and wherever such third-party acknowledgements normally appear.
 *
 * 4. The names "Apache", "The Jakarta Project", "Commons", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written 
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache",
 *    "Apache" nor may "Apache" appear in their names without prior 
 *    written permission of the Apache Software Foundation.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */ 
 
package org.apache.commons.beanutils;

import junit.framework.TestCase;


/**
 * Test cases for <code>BeanPropertyValueChangeClosure</code>.
 *
 * @author Norm Deane
 */
public class BeanPropertyValueChangeClosureTest extends TestCase {
   
    private static final Integer expectedIntegerValue = new Integer(123);
    private static final Float expectedFloatValue = new Float(123.123f);
    private static final Double expectedDoubleValue = new Double(567879.12344d);
    private static final Boolean expectedBooleanValue = Boolean.TRUE;
    private static final Byte expectedByteValue = new Byte("12");

    /**
     * Constructor for BeanPropertyValueChangeClosureTest.
     *
     * @param name Name of this test case.
     */
    public BeanPropertyValueChangeClosureTest(String name) {
        super(name);
    }
    
    /**
     * Test execute with simple float property and Float value.
     */
    public void testExecuteWithSimpleFloatPropertyAndFloatValue() {
        TestBean testBean = new TestBean();
        new BeanPropertyValueChangeClosure("floatProperty", expectedFloatValue).execute(testBean);
        assertTrue(expectedFloatValue.floatValue() == testBean.getFloatProperty());
    }

    /**
     * Test execute with simple float property and String value.
     */
    public void testExecuteWithSimpleFloatPropertyAndStringValue() {
        try {
            new BeanPropertyValueChangeClosure("floatProperty", "123").execute(new TestBean());
            fail("Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e) { 
            /* this is what we expect */
        }
    }

    /**
     * Test execute with simple float property and Double value.
     */
    public void testExecuteWithSimpleFloatPropertyAndDoubleValue() {
        try {
            new BeanPropertyValueChangeClosure("floatProperty", expectedDoubleValue).execute(new TestBean());
            fail("Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e) { 
            /* this is what we expect */
        }
    }

    /**
     * Test execute with simple float property and Integer value.
     */
    public void testExecuteWithSimpleFloatPropertyAndIntegerValue() {
        TestBean testBean = new TestBean();
        new BeanPropertyValueChangeClosure("floatProperty", expectedIntegerValue).execute(testBean);
        assertTrue(expectedIntegerValue.floatValue() == testBean.getFloatProperty());
    }

    /**
     * Test execute with simple double property and Double value.
     */
    public void testExecuteWithSimpleDoublePropertyAndDoubleValue() {
        TestBean testBean = new TestBean();
        new BeanPropertyValueChangeClosure("doubleProperty", expectedDoubleValue).execute(testBean);
        assertTrue(expectedDoubleValue.doubleValue() == testBean.getDoubleProperty());
    }

    /**
     * Test execute with simple double property and String value.
     */
    public void testExecuteWithSimpleDoublePropertyAndStringValue() {
        try {
            new BeanPropertyValueChangeClosure("doubleProperty", "123").execute(new TestBean());
            fail("Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e) { 
            /* this is what we expect */
        }
    }

    /**
     * Test execute with simple double property and Float value.
     */
    public void testExecuteWithSimpleDoublePropertyAndFloatValue() {
        TestBean testBean = new TestBean();
        new BeanPropertyValueChangeClosure("doubleProperty", expectedFloatValue).execute(testBean);
        assertTrue(expectedFloatValue.doubleValue() == testBean.getDoubleProperty());
    }

    /**
     * Test execute with simple double property and Integer value.
     */
    public void testExecuteWithSimpleDoublePropertyAndIntegerValue() {
        TestBean testBean = new TestBean();
        new BeanPropertyValueChangeClosure("doubleProperty", expectedIntegerValue).execute(testBean);
        assertTrue(expectedIntegerValue.doubleValue() == testBean.getDoubleProperty());
    }

    /**
     * Test execute with simple int property and Double value.
     */
    public void testExecuteWithSimpleIntPropertyAndDoubleValue() {
        try {
            new BeanPropertyValueChangeClosure("intProperty", expectedDoubleValue).execute(new TestBean());
            fail("Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e) { 
            /* this is what we expect */
        }
    }

    /**
     * Test execute with simple int property and String value.
     */
    public void testExecuteWithSimpleIntPropertyAndStringValue() {
        try {
            new BeanPropertyValueChangeClosure("intProperty", "123").execute(new TestBean());
            fail("Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e) { 
            /* this is what we expect */
        }
    }

    /**
     * Test execute with simple int property and Float value.
     */
    public void testExecuteWithSimpleIntPropertyAndFloatValue() {
        try {
            new BeanPropertyValueChangeClosure("intProperty", expectedFloatValue).execute(new TestBean());
            fail("Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e) { 
            /* this is what we expect */
        }
    }

    /**
     * Test execute with simple int property and Integer value.
     */
    public void testExecuteWithSimpleIntPropertyAndIntegerValue() {
        TestBean testBean = new TestBean();
        new BeanPropertyValueChangeClosure("intProperty", expectedIntegerValue).execute(testBean);
        assertTrue(expectedIntegerValue.intValue() == testBean.getIntProperty());
    }

    /**
     * Test execute with simple boolean property and Boolean value.
     */
    public void testExecuteWithSimpleBooleanPropertyAndBooleanValue() {
        TestBean testBean = new TestBean();
        new BeanPropertyValueChangeClosure("booleanProperty", expectedBooleanValue).execute(testBean);
        assertTrue(expectedBooleanValue.booleanValue() == testBean.getBooleanProperty());
    }

    /**
     * Test execute with simple boolean property and String value.
     */
    public void testExecuteWithSimpleBooleanPropertyAndStringValue() {
        try {
            new BeanPropertyValueChangeClosure("booleanProperty", "true").execute(new TestBean());
            fail("Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e) { 
            /* this is what we expect */
        }
    }

    /**
     * Test execute with simple byte property and Byte value.
     */
    public void testExecuteWithSimpleBytePropertyAndByteValue() {
        TestBean testBean = new TestBean();
        new BeanPropertyValueChangeClosure("byteProperty", expectedByteValue).execute(testBean);
        assertTrue(expectedByteValue.byteValue() == testBean.getByteProperty());
    }

    /**
     * Test execute with simple boolean property and String value.
     */
    public void testExecuteWithSimpleBytePropertyAndStringValue() {
        try {
            new BeanPropertyValueChangeClosure("byteProperty", "foo").execute(new TestBean());
            fail("Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e) { 
            /* this is what we expect */
        }
    }

    /**
     * Test execute with simple primitive property and null value.
     */
    public void testExecuteWithSimplePrimitivePropertyAndNullValue() {
        try {
            new BeanPropertyValueChangeClosure("intProperty", null).execute(new TestBean());
            fail("Should have thrown an IllegalArgumentException");
        } catch (NullPointerException e) { 
            /* this is what we expect */
        }
    }

    /**
     * Test execute with read only property.
     */
    public void testExecuteWithReadOnlyProperty() {
        try {
            new BeanPropertyValueChangeClosure("readOnlyProperty", "foo").execute(new TestBean());
            fail("Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e) { 
            /* this is what we expect */
        }
    }

    /**
     * Test execute with write only property.
     */
    public void testExecuteWithWriteOnlyProperty() {
        TestBean testBean = new TestBean();
        new BeanPropertyValueChangeClosure("writeOnlyProperty", "foo").execute(testBean);
        assertEquals("foo", testBean.getWriteOnlyPropertyValue());
    }

    /**
     * Test execute with a nested property.
     */
    public void testExecuteWithNestedProperty() {
        TestBean testBean = new TestBean();
        new BeanPropertyValueChangeClosure("nested.stringProperty", "bar").execute(testBean);
        assertEquals("bar", testBean.getNested().getStringProperty());
    }

    /**
     * Test execute with a nested property and null in the property path.
     */
    public void testExecuteWithNullInPropertyPath() {
        try {
            new BeanPropertyValueChangeClosure("anotherNested.stringProperty", "foo").execute(new TestBean());
            fail("Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e) { 
            /* this is what we expect */
        }
    }

    /**
     * Test execute with a nested property and null in the property path and ignoreNull = true.
     */
    public void testExecuteWithNullInPropertyPathAngIgnoreTrue() {
        TestBean testBean = new TestBean();

        // create a closure that will attempt to set a property on the null bean in the path
        BeanPropertyValueChangeClosure closure = new BeanPropertyValueChangeClosure("anotherNested.stringProperty",
                "Should ignore exception", true);

        try {
            closure.execute(testBean);
        } catch (IllegalArgumentException e) {
            fail("Should have ignored the exception.");
        }
    }

    /**
     * Test execute with indexed property.
     */
    public void testExecuteWithIndexedProperty() {
        TestBean testBean = new TestBean();
        new BeanPropertyValueChangeClosure("intIndexed[0]", expectedIntegerValue).execute(testBean);
        assertTrue(expectedIntegerValue.intValue() == testBean.getIntIndexed(0));
    }

    /**
     * Test execute with mapped property.
     */
    public void testExecuteWithMappedProperty() {
        TestBean testBean = new TestBean();
        new BeanPropertyValueChangeClosure("mappedProperty(fred)", "barney").execute(testBean);
        assertEquals("barney", testBean.getMappedProperty("fred"));
    }

    /**
     * Test execute with a simple String property.
     */
    public void testExecuteWithSimpleStringProperty() {
        TestBean testBean = new TestBean();
        new BeanPropertyValueChangeClosure("stringProperty", "barney").execute(testBean);
        assertEquals("barney", testBean.getStringProperty());
    }

    /**
     * Test execute with an invalid property name.
     */
    public void testExecuteWithInvalidPropertyName() {
        try {
            new BeanPropertyValueChangeClosure("bogusProperty", "foo").execute(new TestBean());
            fail("Should have thrown an IllegalArgumentException");
        } catch (IllegalArgumentException e) { 
            /* this is what we expect */
        }
    }
}