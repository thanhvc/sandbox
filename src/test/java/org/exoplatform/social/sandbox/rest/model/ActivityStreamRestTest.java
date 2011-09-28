/*
 * Copyright (C) 2003-2011 eXo Platform SAS.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.exoplatform.social.sandbox.rest.model;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.MessageBodyWriter;

import junit.framework.TestCase;

import org.exoplatform.services.rest.impl.provider.JsonEntityProvider;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Sep 28, 2011  
 */
public class ActivityStreamRestTest extends TestCase {

  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
  }
  
  @Override
  protected void tearDown() throws Exception {
    super.tearDown();
  }
  
  public void testActivityStreamSpaceByIdentityIdNoNull() throws Exception {
    ActivityStreamRest model = new ActivityStreamRest("1", "title", null);
    model.setActivities(null);
    MessageBodyWriter writer = new JsonEntityProvider();
    
    OutputStream jsonOut = new ByteArrayOutputStream();
    writer.writeTo(model, ActivityStreamRest.class, ActivityStreamRest.class, null, null, null, jsonOut);
    String jsonString = jsonOut.toString();
    
    System.out.print(jsonOut);
  }
  
  
}
