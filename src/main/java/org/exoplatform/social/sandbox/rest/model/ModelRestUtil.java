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

import java.util.HashMap;

/**
 * Created by The eXo Platform SAS
 * Author : Thanh_VuCong
 *          thanhvc@exoplatform.com
 * Sep 27, 2011  
 */
public class ModelRestUtil {
    
    /**
     * Defines the Field Type which is used in the Rest Service.
     * @author thanh_vucong
     *
     * @param <D> the data type
     */
    public abstract static class FieldType<D, V> {
      
      /** Define the STRING DataType*/
      public static final FieldType<String, String> STRING_TYPE = new FieldType<String, String>(String.class, "") {};

      /** Define the CHARACTER DataType*/
      public static final FieldType<Character, Character> CHARACTER_TYPE = new FieldType<Character, Character>(Character.class, '\0') {};
      
      /** Define the NUMBER DataType*/
      public static final FieldType<Number, Number> NUMBER_TYPE = new FieldType<Number, Number>(Number.class, 0) {};
      //
      private final Class<D> javaType;
      private final V defaultValue;
           
      private FieldType(Class<D> javaType, V defaultValue) {
        this.javaType = javaType;
        this.defaultValue = defaultValue;
      }

      public V getDefaultValue() {
        return defaultValue;
      }
     
    }//end type class
    
   
    /**
     * Factory method which use to get the default value from provided object.
     * 
     * @param object
     * @return
     */
    public static Object getDefaultValue(Object value) {
      if (value instanceof String) {
        return FieldType.STRING_TYPE.getDefaultValue();
      } else if (value instanceof Character) {
        return FieldType.CHARACTER_TYPE.getDefaultValue();
      } else if (value instanceof Number) {
        return FieldType.NUMBER_TYPE.getDefaultValue();
      } else {
        return new HashMap<String, Object>();        
      }
      
    }
}
