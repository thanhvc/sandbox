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


/**
 * Created by The eXo Platform SAS
 * Author : Thanh_VuCong
 *          thanhvc@exoplatform.com
 * Sep 27, 2011  
 */
public class FieldMetadata {
  
  /**
   * The type of activity stream, can be user or space.
   */
  public static enum FieldName {
    
    //DEFINE ACTIVITY_STREAM FIELD NAME 
    AS_TITLE("title"),
    AS_PRETTY_ID("prettyId"),
    AS_ACTIVITIES("activities"),
    AS_FAVICON_URL("faviconUrl"),
    AS_PERMA_LINK("permaLink"),
    
    //DEFINE ACTIVITY FIELD NAME
    AC_TITLE("title"),
    AC_ID("id");

    /**
     * String type.
     */
    private final String fieldName;

    /**
     * private constructor.
     * 
     * @param string string type
     */
    private FieldName(final String string) {
      fieldName = string;
    }

    public String getFieldName() {
      return fieldName;
    }
  }
  
}
