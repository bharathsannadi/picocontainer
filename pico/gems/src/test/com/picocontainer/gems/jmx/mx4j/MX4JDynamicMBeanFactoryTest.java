/*****************************************************************************
 * Copyright (C) 2003-2011 PicoContainer Committers. All rights reserved.    *
 * ------------------------------------------------------------------------- *
 * The software in this package is published under the terms of the BSD      *
 * style license a copy of which has been included with this distribution in *
 * the LICENSE.txt file.                                                     *
 *                                                                           *
 * Original code by Michael Ward                                             *
 *****************************************************************************/

package com.picocontainer.gems.jmx.mx4j;

import static org.junit.Assert.assertNotNull;

import javax.management.DynamicMBean;
import javax.management.MBeanInfo;

import org.junit.Test;
import com.picocontainer.gems.jmx.DynamicMBeanFactory;
import com.picocontainer.gems.jmx.testmodel.Person;
import com.picocontainer.testmodel.SimpleTouchable;

/**
 * @author J&ouml;rg Schaible
 */
public class MX4JDynamicMBeanFactoryTest {

    @Test public void testMBeanCreationFailsWithoutManagementInterface() {
        final DynamicMBeanFactory factory = new MX4JDynamicMBeanFactory();
        final MBeanInfo mBeanInfo = Person.createMBeanInfo();
        final DynamicMBean mBean = factory.create(new SimpleTouchable(), null, mBeanInfo);
        assertNotNull(mBean);
    }

}
