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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.exoplatform.social.sandbox.rest.model.FieldMetadata.FieldName;

/**
 * Created by The eXo Platform SAS
 * Author : Thanh_VuCong
 *          thanhvc@exoplatform.com
 * Sep 27, 2011  
 */
@SuppressWarnings("serial")
public class ActivityStreamRest extends HashMap<String, Object> {

  /**
   * Activities of activityStream;
   */
  @OptionalValue
  ActivityRest[] activities;

  /**
   * Constructor.
   * 
   * @param type The type.
   * @param prettyId The pretty id.
   * @param faviconUrl The favorite icon URL.
   * @param title The title.
   * @param permalink The permanent link.
   */
  public ActivityStreamRest(final String prettyId,
                            final String title,
                            final String permaLink) {

    this.setPrettyId(prettyId);
    this.setTitle(title);
    this.setPermaLink(permaLink);
  }

  public String getPrettyId() {
    return (String) get(FieldName.AS_PRETTY_ID.getFieldName());
  }

  public void setPrettyId(final String prettyId) {
    put(FieldName.AS_PRETTY_ID.getFieldName(), prettyId);
  }

  public String getTitle() {
    return (String) get(FieldName.AS_TITLE.getFieldName());
  }

  public void setTitle(final String title) {
    if (title == null) {
      put(FieldName.AS_TITLE.getFieldName(), ModelRestUtil.getDefaultValue(title));
    } else {
      put(FieldName.AS_TITLE.getFieldName(), title);      
    }
  }

  public String getPermaLink() {
    return (String) get(FieldName.AS_PERMA_LINK.getFieldName());
  }

  public void setPermaLink(final String permalink) {
    if (permalink == null) {
      put(FieldName.AS_PERMA_LINK.getFieldName(), ModelRestUtil.getDefaultValue(permalink));
    } else {
      put(FieldName.AS_PERMA_LINK.getFieldName(), permalink);      
    }
  }

  public String getFaviconUrl() {
    return (String) get(FieldName.AS_FAVICON_URL.getFieldName());
  }

  public void setFaviconUrl(String faviconUrl) {
    if (faviconUrl == null) {
      put(FieldName.AS_FAVICON_URL.getFieldName(), ModelRestUtil.getDefaultValue(faviconUrl));
    } else {
      put(FieldName.AS_FAVICON_URL.getFieldName(), faviconUrl);      
    }
    
  }

  public ActivityRest[] getActivities() {
    return (ActivityRest[]) get(FieldName.AS_ACTIVITIES.getFieldName());
  }

  public void setActivities(List<ActivityRest>[] activities) {
    if (activities == null) {
      put(FieldName.AS_ACTIVITIES.getFieldName(), new ArrayList<ActivityRest>());      
    } else {
      put(FieldName.AS_ACTIVITIES.getFieldName(), activities);      
    }
    
  }
}
