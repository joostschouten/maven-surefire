package org.apache.maven.plugins.surefire.report;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;

import junit.framework.TestCase;

/**
 * @author Kristian Rosenvold
 */
public class TestSuiteXmlParserTest
    extends TestCase
{
    public void testParse()
        throws Exception
    {
        TestSuiteXmlParser testSuiteXmlParser = new TestSuiteXmlParser();
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
            "<testsuite failures=\"4\" time=\"0.005\" errors=\"0\" skipped=\"0\" tests=\"4\" name=\"wellFormedXmlFailures.TestSurefire3\">\n"
            +
            "  <properties>\n" +
            "    <property name=\"java.runtime.name\" value=\"Java(TM) SE Runtime Environment\"/>\n" +
            "    <property name=\"sun.cpu.isalist\" value=\"amd64\"/>\n" +
            "  </properties>\n" +
            "  <testcase time=\"0.005\" classname=\"wellFormedXmlFailures.TestSurefire3\" name=\"testLower\">\n" +
            "    <failure message=\"&lt;\" type=\"junit.framework.AssertionFailedError\"><![CDATA[junit.framework.AssertionFailedError: <\n"
            +
            "\tat junit.framework.Assert.fail(Assert.java:47)\n" +
            "\tat wellFormedXmlFailures.TestSurefire3.testLower(TestSurefire3.java:30)\n" +
            "]]></failure>\n" +
            "  </testcase>\n" +
            "  <testcase time=\"0\" classname=\"wellFormedXmlFailures.TestSurefire3\" name=\"testU0000\">\n" +
            "    <failure message=\"&amp;0#;\" type=\"junit.framework.AssertionFailedError\">junit.framework.AssertionFailedError:  \n"
            +
            "\tat junit.framework.Assert.fail(Assert.java:47)\n" +
            "\tat wellFormedXmlFailures.TestSurefire3.testU0000(TestSurefire3.java:40)\n" +
            "</failure>\n" +
            "  </testcase>\n" +
            "  <testcase time=\"0\" classname=\"wellFormedXmlFailures.TestSurefire3\" name=\"testGreater\">\n" +
            "    <failure message=\"&gt;\" type=\"junit.framework.AssertionFailedError\">junit.framework.AssertionFailedError: >\n"
            +
            "\tat junit.framework.Assert.fail(Assert.java:47)\n" +
            "\tat wellFormedXmlFailures.TestSurefire3.testGreater(TestSurefire3.java:35)\n" +
            "</failure>\n" +
            "  </testcase>\n" +
            "  <testcase time=\"0\" classname=\"wellFormedXmlFailures.TestSurefire3\" name=\"testQuote\">\n" +
            "    <failure message=\"&quot;\" type=\"junit.framework.AssertionFailedError\">junit.framework.AssertionFailedError: \"\n"
            +
            "\tat junit.framework.Assert.fail(Assert.java:47)\n" +
            "\tat wellFormedXmlFailures.TestSurefire3.testQuote(TestSurefire3.java:25)\n" +
            "</failure>\n" +
            "  </testcase>\n" +
            "</testsuite>";
        InputStream byteArrayIs = new ByteArrayInputStream( xml.getBytes() );
        Collection<ReportTestSuite> parse = testSuiteXmlParser.parse( byteArrayIs );
    }
}
