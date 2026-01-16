/*
 *	Mark's Code Fractal CFLib DbTest 3.1 Database Test and Prototyping
 *	
 *	Copyright 2016-2026 Mark Stephen Sobkow
 *	
 *	These files are part of Mark's Code Fractal CFLib DbTest.
 *	
 *	Mark's Code Fractal CFLib DbTest is available under dual commercial license from
 *	Mark Stephen Sobkow, or under the terms of the GNU Library General Public License,
 *	Version 3 or later.
 *	
 *	Mark's Code Fractal CFLib DbTest is free software: you can redistribute it and/or
 *	modify it under the terms of the GNU Library General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *	
 *	Mark's Code Fractal CFLib DbTest is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU Library General Public License for more details.
 *	
 *	You should have received a copy of the GNU Library General Public License
 *	along with Mark's Code Fractal CFLib DbTest.  If not, see &lt;https://www.gnu.org/licenses/&gt;.
 *	
 *	If you wish to modify and use this code without publishing your changes in order to
 *	tie it to proprietary code, please contact Mark Stephen Sobkow
 *	for a commercial license at mark.sobkow@gmail.com
 */
package io.github.msobkow.v3_1.cflib.dbtest.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupListener {

    @Autowired
    // @Qualifier("TestSecDb")
    private TestSecDb testSecDb;

    @Autowired
    // @Qualifier("TestAppDb")
    private TestAppDb testAppDb;

    @EventListener
    public void onApplicationReady(ApplicationReadyEvent event) {

        System.err.println("Executing testSecDb.performTests()");
        try {
            String response = testSecDb.performTests(null);
            if (response != null) {
                System.err.println("TestSecDb.performTests() responded: " + response);
            }
            else {
                System.err.println("TestSecDb.performTests() did not return a response");
            }
        }
        catch (Throwable th) {
            System.err.println("testSecDb.performTests() threw " + th.getClass().getCanonicalName() + " - " + th.getMessage());
            th.printStackTrace(System.err);
        }

        System.err.println("Executing testAppDb.performTests()");
        try {
            String response = testAppDb.performTests(null);
            if (response != null) {
                System.err.println("TestAppDb.performTests() responded: " + response);
            }
            else {
                System.err.println("TestAppDb.performTests() did not return a response");
            }
        }
        catch (Throwable th) {
            System.err.println("testAppDb.performTests() threw " + th.getClass().getCanonicalName() + " - " + th.getMessage());
            th.printStackTrace(System.err);
        }

        System.err.println("DbTest StartupListener tests complete.");
    }
}
