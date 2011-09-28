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

import org.exoplatform.social.sandbox.rest.model.FieldMetadata.FieldName;

/**
 * Created by The eXo Platform SAS
 * Author : eXoPlatform
 *          exo@exoplatform.com
 * Sep 27, 2011  
 */
public class ActivityRest extends HashMap<String, Object> {
  /**
   * The id.
   */
  private String id;

  /**
   * The title.
   */
  private String title;

  
  public ActivityRest() {
  }


  /**
   * Initialize constructor.
   *
   * @param id The id.
   * @param title The title.
   * @param priority The priority.
   * @param appId The application id.
   * @param type The activity type.
   * @param postedTime The timestamp.
   * @param createdAt The human date.
   * @param titleId The title id.
   * @param templateParams The template parameters.
   * @param liked Is liked
   * @param likedByIdentities The identity ids who like.
   * @param identityId The owner identity id.
   */
  public ActivityRest(
      final String id,
      final String title
      ) {

    this.setId(id);
    this.setTitle(title);

  }

  
  
  public String getId() {
    return (String) get(FieldName.AC_ID.getFieldName());
  }

  public void setId(final String id) {
    put(FieldName.AC_ID.getFieldName(), id);
  }

  public String getTitle() {
    return (String) get(FieldName.AC_TITLE.getFieldName());
  }

  public void setTitle(final String title) {
    put(FieldName.AC_TITLE.getFieldName(), title);
  }
  
  
}
